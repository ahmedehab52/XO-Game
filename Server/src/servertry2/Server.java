/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servertry2;

/**
 *
 * @author ELROWAD
 */
import java.net.*;
import java.io.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Server {

    ServerSocket serverSocket;
    static DataBase mydb;
    
    public Server(String name, String pass) {
        System.out.println("Sever is Up");
        mydb = new DataBase(name, pass);
        try {
            serverSocket = new ServerSocket(5005);
            while (true) {
                Socket s = serverSocket.accept();
                System.out.println("Done!");
                new ChatHandler(s, name, pass);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}

class ChatHandler extends Thread {

    DataInputStream dis;
    PrintStream ps;
    static String id = "X";
    
    static Vector<ChatHandler> clientsVector = new Vector<ChatHandler>();
    static Vector<User> userVector = new Vector<User>();//Creating HashMap 

    public ChatHandler(Socket cs, String name, String pass) {

       
        try {
            dis = new DataInputStream(cs.getInputStream());
            ps = new PrintStream(cs.getOutputStream());
            ps.println(id);
            id = "O";
        } catch (IOException exce) {
            exce.printStackTrace();
        }
        clientsVector.add(this);
        start();
    }

    public void run() {
        while (true) {
            try {
                String str = dis.readLine();
                if (str.contains("db")) {
                    dbQuery(str);
                } else {
                    sendMessageToAll(str);
                }
            } catch (IOException e) {
                clientsVector.remove(this);
                break;
            }
        }
    }

    void sendMessageToAll(String msg) {
        for (ChatHandler ch : clientsVector) {
            ch.ps.println(msg);
        }
    }

    void dbQuery(String s) {
        String[] Resarr;
        ResultSet rs = null;
        int u = 0;  //result of update query
        
        if (s.contains("select")) { //query to update score
            Resarr = s.split("\\.");
            if(s.contains("record")){
                try {
                    System.out.println("retreving");
                    rs = Server.mydb.executeMyQuery(Resarr[2]);
                    if (rs.next()) {
                        this.ps.println("Replay:"+rs.getString("moves")); //I need username and password
                        System.out.println("Replay:"+rs.getString("moves")); 
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if (s.contains("change")) {
                int scoreToCheck;
                Resarr = s.split("\\,");
                try {
                    rs = Server.mydb.executeMyQuery(Resarr[2]);

                    if (rs.next()) {
                        //getting data from resultset
                        scoreToCheck = rs.getInt("playerScore");

                    } else {
                        scoreToCheck = -1; //no value returned

                    }
                    int gameScore = Integer.parseInt(Resarr[3]);   //score from play
                    if (gameScore > scoreToCheck) {
                        String updateScore = "update player set playerScore =   " + "'" + gameScore + "'   where playerUsername= " + "'" + Resarr[4] + "'   ";
                        try {
                            int uu = Server.mydb.executeMyUpdate(updateScore);
                            System.out.println("Server file: update done successfully");
                        } catch (SQLException ex) {
                            Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        System.out.println("Already Max score....");
                    }

                } catch (SQLException ex) {
                    System.out.println("Update did not succeed");
                    Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            } //query from signing:
            else {
                Resarr = s.split("\\.");
                try {
                    rs = Server.mydb.executeMyQuery(Resarr[2]);
                    //user exists
                    if (rs.next()) {
                        //getting data from resultset
                        String nameToCheck = rs.getString("playerUsername");
                        String passwordToCheck = rs.getString("playerPassword");
                        
                        //deciding to send to sign in file or sign up file:
                        if (s.contains("in")) {
                            clientsVector.lastElement().ps.println("db,in," + nameToCheck + "," + passwordToCheck); //I need username and password
                            userVector.add(new User(1,nameToCheck,this,2));
                        } else if (s.contains("up")) {
                            clientsVector.lastElement().ps.println("db,up," + nameToCheck); // I need user name only in sign up (if user name exists then player already exists)
                        }

                    } //user doesnot exist
                    else {

                        if (s.contains("in")) {
                            clientsVector.lastElement().ps.println("db,in,notExist");
                        } else if (s.contains("up")) {
                            clientsVector.lastElement().ps.println("db,up,notExist");
                        }

                    }

                } catch (SQLException ex) {
                    Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (s.contains("update")) {
            System.out.println("Server file: " + s);
            Resarr = s.split("\\.");
            try {
                u = Server.mydb.executeMyUpdate(Resarr[1]);
                System.out.println("Server file: update done successfully");
            } catch (SQLException ex) {
                Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (s.contains("insert")) {
            //insert new recorded game:
            if (s.contains("record")) {
                String[] insertArr2 = s.split("\\*");

                try {
                    int uuu = Server.mydb.executeMyPrepared(insertArr2[2], 1, insertArr2[3], 2, insertArr2[4], 3, insertArr2[5]);
                } catch (SQLException ex) {
                    System.out.println("failed to insert record.....");
                    Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
                }

            } //insert new player:
            else {
                System.out.println("Server file: " + s);
                String[] insertArr = s.split("\\'");
                String query = insertArr[1]; //getting query
                String user = insertArr[2]; //getting username
                String mail = insertArr[3]; //getting email
                String pass = insertArr[4]; //getting password
                try {
                    u = Server.mydb.executeMyPrepared(query, 1, user, 2, mail, 3, pass);
                    if (u == 1) {
                        this.ps.println("db,up,ienserted");
                    }
                } catch (SQLException ex) { //means mail already exists
                    System.out.println("Server file: exception");
                    this.ps.println("db,up,mailExists");
                }
            }
        }
    }

}
