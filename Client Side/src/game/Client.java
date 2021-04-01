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
import static game.MenuGame.recordTable;
import static game.SignInController.userNameFieldText;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.EventType;

public class Client implements Runnable {

    Socket mySocket;
    DataInputStream dis;
    static PrintStream ps;
    Thread thread;
    String replyMsg;
    String id;
    String name1;
    String name2;

    public Client(String address) {
        try {

            mySocket = new Socket(address, 5005);
            dis = new DataInputStream(mySocket.getInputStream());
            ps = new PrintStream(mySocket.getOutputStream());
            ps.println("test test");
            /* while(true){
                        id = dis.readLine();
                        if(id != "")
                              break;
                    }
                    System.out.println(id);*/
        } catch (IOException ex) {
            // ex.printStackTrace();
            System.out.println("there is no available server");
            System.exit(0);
        }
        Thread th = new Thread(this);
        th.start();
    }

    @Override
    @SuppressWarnings("empty-statement")
    public void run() {
        System.out.println("in run");
        while (true) {
            try {
                String s = dis.readLine();

                if ("O".equals(s) || "X".equals(s)) {
                    {
                        //System.out.println(s);
                        id = s;
                        Platform.runLater(() -> {
                            if ("X".equals(beginBase.client.id)) {
                                // MenuGame.singlePlayerPane.text1.setText(userNameFieldText);
                                MenuGame.multiPlayerPane.nameplayer1.setText(userNameFieldText);
                                ps.println("Xuser." + userNameFieldText);
                            } else if ("O".equals(beginBase.client.id)) {
                                MenuGame.multiPlayerPane.nameplayer2.setText(userNameFieldText);
                                ps.println("Ouser." + userNameFieldText);
                            }
                            MenuGame.multiPlayerPane.newGame();
                        });
                    }

                } else if (s.startsWith("GameTable")) {
                    Platform.runLater(() -> {
                        MenuGame.recordTable.buildGameTable(s);
                    });
                    System.out.println(s);
                } else if (s.contains("Multi")) {
                    Platform.runLater(() -> {
                        MenuGame.multiPlayerPane.drawSymbol(s);
                    });
                } else if (s.contains("db")) {
                    System.out.println("In Client: " + s);
                    // sign in file:
                    if (s.contains("in")) {
                        Platform.runLater(() -> {
                            SignInController.authcheck(s);
                        });
                    } //sign up file:
                    else if (s.contains("up")) {
                        Platform.runLater(() -> {
                            SignUpController.userCheck(s);
                        });
                    }

                } else if (s.contains("Single")) {
                    Platform.runLater(() -> {
                        MenuGame.singlePlayerPane.drawSymbol(s);
                    });
                } else if ("Restart".equals(s)) {
                    Platform.runLater(() -> {
                        MenuGame.multiPlayerPane.restartGame();
                    });
                } else if (s.contains("Replay")) {
                    System.out.println("From client Class: " + s);
                    Platform.runLater(() -> {
                        MenuGame.viewPane(MenuGame.record);
                        MenuGame.record.rePlayGame(s);
                    });
                } else if (s.contains("Xuser")) {
                    Platform.runLater(() -> {
                        String[] arr = s.split("\\.");
                        name1 = arr[1];
                        MenuGame.multiPlayerPane.nameplayer1.setText(arr[1]);
                    });
                } else if (s.contains("Ouser")) {
                    Platform.runLater(() -> {
                        String[] arr = s.split("\\.");
                        name2 = arr[1];
                        MenuGame.multiPlayerPane.nameplayer2.setText(arr[1]);
                    });
                }

            } catch (IOException ex) {
                System.out.println("no data found to read it from socket");
            }
        }
    }

}
