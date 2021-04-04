/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

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

public class Server
{
	ServerSocket serverSocket;
	public Server()
	{
	   try{
	   	serverSocket = new ServerSocket(5005);
	  	 while(true)
	   	{
			Socket s = serverSocket.accept();
                        System.out.println("Done!");
			new ChatHandler(s);
	   	}
	      }
	   catch(IOException ex)
	   {
		   ex.printStackTrace();
	   }
	}

	public static void main(String[] args)
	{
		new Server();
	}
}


class ChatHandler extends Thread
{
        Socket mycs;
        String myRec;
	DataInputStream dis;
	PrintStream ps;
        static  String id = "X";
       
        DataBase mydb ;
	static Vector<ChatHandler> clientsVector = new Vector<ChatHandler>();
        static HashMap<ChatHandler,String> map=new HashMap<ChatHandler,String>();//Creating HashMap   
	public ChatHandler(Socket cs)
	{
             try{
                mydb = new DataBase();
              }
           catch (SQLException ex) {
                Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
            }           
	  try{
	   dis = new DataInputStream(cs.getInputStream());
	   ps  = new PrintStream(cs.getOutputStream());           
	  }
	  catch(IOException exce){
	  	exce.printStackTrace();
	  }
		clientsVector.add(this);
		start();
               
	}


	public void run()
	{
		while(true)
		{
			try
			{
			    String str = dis.readLine();
                                if(str.contains("db")){
                                    dbQuery(str);
                                }
                                else if("Two Players Game".equals(str)){
                                    ps.println(id);
                                      id = "O";
                                }
                            
                                else if(str.contains("Rec"))
                                {
                                    myRec = str;
                                    System.out.println(myRec);
                                }
                                else if(str.contains("Replay"))
                                      sendMessageToAll(myRec);
                                else
                                {
                                    System.out.println(str);
				    sendMessageToAll(str);                                
		                }
                        }
			catch(IOException e)
			{
                           clientsVector.remove(this);
                           break;
			}
		}
	}
	
	void sendMessageToAll(String msg)
	{
		for(ChatHandler ch : clientsVector)
		{
			ch.ps.println(msg);
		}
	}

   void dbQuery(String s) {
        String[] Resarr;
        String gmaeTable = "";
        ResultSet rs;
        int u = 0;  //result of update query


        if (s.contains("select")) {
            Resarr = s.split("\\.");
             if(s.contains("record")){
                try {
                    System.out.println("retreving");
                    rs = mydb.executeMyQuery(Resarr[2]);
                    while (rs.next()) {
                        gmaeTable +=rs.getString("gameId");
                        gmaeTable +="," +rs.getString("gameName");
                        gmaeTable +="," +rs.getString("gameTimeEnded");
                        gmaeTable +="," +rs.getString("moves");
                        gmaeTable +="," +rs.getString("playerId1");
                        gmaeTable +="," +rs.getString("playerId2");
                        gmaeTable +=";";
                        //this.ps.println("Replay:"+rs.getString("moves"));
                        //System.out.println("Replay:"+rs.getString("moves")); 
                    }
                    
                    this.ps.println("GameTable;"+gmaeTable);
                } catch (SQLException ex) {
                    Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
             else if(s.startsWith("db.replay"))
             {
                 try {
                    System.out.println("retreving");
                    rs = mydb.executeMyQuery(Resarr[2]);
                    if (rs.next()) {
                       
                          this.ps.println("Replay:"+rs.getString("moves"));
                        //System.out.println("Replay:"+rs.getString("moves")); 
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
            else{
            try {
                rs = mydb.executeMyQuery(Resarr[2]);
                //user exists
                if (rs.next()) {
                    //getting data from resultset
                    String nameToCheck = rs.getString("playerUsername");
                    String passwordToCheck = rs.getString("playerPassword");
                    //deciding to send to sign in file or sign up file:
                    if (s.contains("in")) {
                       this.ps.println("db,in," + nameToCheck + "," + passwordToCheck); //I need username and password
                        map.put(this,nameToCheck);
                        
                       for(Map.Entry m : map.entrySet()){
                            System.out.println(m.getKey()+" "+m.getValue());    
                       }  
                    } else if (s.contains("up")) {
                       this.ps.println("db,up," + nameToCheck); // I need user name only in sign up (if user name exists then player already exists)
                    }

                } //user doesnot exist
                else {

                    if (s.contains("in")) {
                        this.ps.println("db,in,notExist");
                    } else if (s.contains("up")) {
                        this.ps.println("db,up,notExist");
                    }

                }

            } catch (SQLException ex) {
                Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        } else if (s.contains("update")) {
            Resarr = s.split("\\.");
            try {
                u = mydb.executeMyUpdate(Resarr[1]);
                System.out.println("Server file: update done successfully");
            } catch (SQLException ex) {
                Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (s.contains("insert")) {
            //insert new recorded game:
            if (s.contains("record")) {
                String[] insertArr2 = s.split("\\*");

                try {
                    int uuu = mydb.executeMyPrepared(insertArr2[2], 1, insertArr2[3], 2, insertArr2[4], 3, insertArr2[5]);
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
                u = mydb.executeMyPrepared(query, 1, user, 2, mail, 3, pass);
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

