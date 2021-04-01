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


import static game.MenuGame.root;
import java.awt.Toolkit;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow; 
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.scene.control.Alert.AlertType;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.util.Duration;


public  class MultiPlayer extends BorderPane {

    protected final Pane pane;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
       protected static Button[] locations = new Button[9];
    protected final Button RestartBt;
    protected final Button BackBt;
    protected final Text currentplayer;
    protected final Text player1;
    protected final Text nameplayer1;
    protected final Text score1;
    protected final Text scoreplayer1;
    protected final Text player2;
    protected final Text nameplayer2;
    protected final Text score2;
    protected final Text scoreplayer2;
    protected final Text text8;
    protected final Text playerx;
    protected final Text playero;
    protected final Button recordbtn;
	static boolean drawFlag;
        static boolean recordflag;
        volatile boolean xTurn;
        int clickCounter; 
	boolean gameEnd ;
   String myRec;
    
    protected String startGame = "X";
   private int xCount ;
   private int oCount;
    
    ArrayList<String> moves =new ArrayList<String>();
    StringBuilder clinetmoves ;
    String str_clintmoves;
     PauseTransition pauseTrans;
    Timer timer;
    boolean replay;
    String name1;
/////////////////////////////////////////////
    
    

    public MultiPlayer() {
         timer = new Timer();
        // timer.schedule(new Runnable(){,0,1*1000);
        System.out.println("Constructur ");
       // pauseTrans = new PauseTransition(Duration.millis(5000));
        replay = false;
      clickCounter = 0;
        xCount=0;
        oCount=0;
        clickCounter = 0;
        gameEnd = false;
        xTurn = true;
        pane = new Pane();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
		drawFlag=false;
                recordflag=false;
                clinetmoves = new StringBuilder();
        for (int i = 0; i < locations.length; i++) {
            locations[i] = new Button();
        }
		
	
	
		
		
        RestartBt = new Button();
        BackBt = new Button();
        currentplayer = new Text();
        player1 = new Text();
        nameplayer1 = new Text();
        score1 = new Text();
        scoreplayer1 = new Text();
        player2 = new Text();
        nameplayer2 = new Text();
        score2 = new Text();
        scoreplayer2 = new Text();
        text8 = new Text();
        playerx = new Text();
        playero = new Text();
        recordbtn = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(804.0);

        BorderPane.setAlignment(pane, javafx.geometry.Pos.CENTER);
        pane.setId("pane");
        pane.setMaxHeight(USE_PREF_SIZE);
        pane.setMaxWidth(USE_PREF_SIZE);
        pane.setMinHeight(USE_PREF_SIZE);
        pane.setMinWidth(USE_PREF_SIZE);
        pane.setPrefHeight(602.0);
        pane.setPrefWidth(806.0);
    //    pane.getStylesheets().add("mycss.css");

        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        gridPane.setLayoutX(201.0);
        gridPane.setLayoutY(107.0);
        gridPane.setMinHeight(USE_PREF_SIZE);
        gridPane.setMinWidth(USE_PREF_SIZE);
        gridPane.setPrefHeight(386.0);
        gridPane.setPrefWidth(398.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        locations[0].setAlignment(javafx.geometry.Pos.CENTER);
        locations[0].setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        locations[0].setId("Button");
        locations[0].setMaxHeight(Double.MAX_VALUE);
        locations[0].setMaxWidth(Double.MAX_VALUE);
        locations[0].setMnemonicParsing(false);
        locations[0].setPrefHeight(94.0);
        locations[0].setPrefWidth(107.0);
        locations[0].setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        GridPane.setMargin(locations[0], new Insets(5.0));
        locations[0].setPadding(new Insets(10.0, 0.0, 0.0, 0.0));
	
	
        GridPane.setColumnIndex(locations[1], 1);
        locations[1].setAlignment(javafx.geometry.Pos.CENTER);
        locations[1].setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        locations[1].setId("Button");
        locations[1].setMaxHeight(Double.MAX_VALUE);
        locations[1].setMaxWidth(Double.MAX_VALUE);
        locations[1].setMnemonicParsing(false);
        locations[1].setPrefHeight(94.0);
        locations[1].setPrefWidth(107.0);
        locations[1].setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        GridPane.setMargin(locations[1], new Insets(5.0));

        GridPane.setColumnIndex(locations[2], 2);
        locations[2].setAlignment(javafx.geometry.Pos.CENTER);
        locations[2].setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        locations[2].setId("Button");
        locations[2].setMaxHeight(Double.MAX_VALUE);
        locations[2].setMaxWidth(Double.MAX_VALUE);
        locations[2].setMnemonicParsing(false);
        locations[2].setPrefHeight(142.0);
        locations[2].setPrefWidth(143.0);
        locations[2].setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        GridPane.setMargin(locations[2], new Insets(5.0));

        GridPane.setRowIndex(locations[3], 1);
        locations[3].setAlignment(javafx.geometry.Pos.CENTER);
        locations[3].setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        locations[3].setId("Button");
        locations[3].setMaxHeight(Double.MAX_VALUE);
        locations[3].setMaxWidth(Double.MAX_VALUE);
        locations[3].setMnemonicParsing(false);
        locations[3].setPrefHeight(94.0);
        locations[3].setPrefWidth(107.0);
        locations[3].setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        GridPane.setMargin(locations[3], new Insets(5.0));

        GridPane.setColumnIndex(locations[4], 1);
        GridPane.setRowIndex(locations[4], 1);
        locations[4].setAlignment(javafx.geometry.Pos.CENTER);
        locations[4].setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        locations[4].setId("Button");
        locations[4].setMaxHeight(Double.MAX_VALUE);
        locations[4].setMaxWidth(Double.MAX_VALUE);
        locations[4].setMnemonicParsing(false);
        locations[4].setPrefHeight(94.0);
        locations[4].setPrefWidth(107.0);
        locations[4].setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        GridPane.setMargin(locations[4], new Insets(5.0));
        locations[4].setPadding(new Insets(5.0));

        GridPane.setColumnIndex(locations[5], 2);
        GridPane.setRowIndex(locations[5], 1);
        locations[5].setAlignment(javafx.geometry.Pos.CENTER);
        locations[5].setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        locations[5].setId("Button");
        locations[5].setMaxHeight(Double.MAX_VALUE);
        locations[5].setMaxWidth(Double.MAX_VALUE);
        locations[5].setMnemonicParsing(false);
        locations[5].setPrefHeight(94.0);
        locations[5].setPrefWidth(107.0);
        locations[5].setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        GridPane.setMargin(locations[5], new Insets(5.0));

        GridPane.setRowIndex(locations[6], 2);
        locations[6].setAlignment(javafx.geometry.Pos.CENTER);
        locations[6].setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        locations[6].setId("Button");
        locations[6].setMaxHeight(Double.MAX_VALUE);
        locations[6].setMaxWidth(Double.MAX_VALUE);
        locations[6].setMnemonicParsing(false);
        locations[6].setPrefHeight(94.0);
        locations[6].setPrefWidth(107.0);
        locations[6].setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        GridPane.setMargin(locations[6], new Insets(5.0));

        GridPane.setColumnIndex(locations[7], 1);
        GridPane.setRowIndex(locations[7], 2);
        locations[7].setAlignment(javafx.geometry.Pos.CENTER);
        locations[7].setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        locations[7].setId("Button");
        locations[7].setMaxHeight(Double.MAX_VALUE);
        locations[7].setMaxWidth(Double.MAX_VALUE);
        locations[7].setMnemonicParsing(false);
        locations[7].setPrefHeight(94.0);
        locations[7].setPrefWidth(107.0);
        locations[7].setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        GridPane.setMargin(locations[7], new Insets(5.0));

        GridPane.setColumnIndex(locations[8], 2);
        GridPane.setRowIndex(locations[8], 2);
        locations[8].setAlignment(javafx.geometry.Pos.CENTER);
        locations[8].setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        locations[8].setId("Button");
        locations[8].setMaxHeight(Double.MAX_VALUE);
        locations[8].setMaxWidth(Double.MAX_VALUE);
        locations[8].setMnemonicParsing(false);
        locations[8].setPrefHeight(94.0);
        locations[8].setPrefWidth(107.0);
        locations[8].setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        GridPane.setMargin(locations[8], new Insets(5.0));
      
        
        RestartBt.setAlignment(javafx.geometry.Pos.BASELINE_CENTER);
        RestartBt.setId("resback");
        RestartBt.setLayoutX(639.0);
        RestartBt.setLayoutY(531.0);
        RestartBt.setMinWidth(USE_PREF_SIZE);
        RestartBt.setMnemonicParsing(false);
        RestartBt.setPrefHeight(50.0);
        RestartBt.setPrefWidth(140.0);
        RestartBt.setText("Restart");
        RestartBt.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        
        
        ///restart Button
         RestartBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              Client.ps.println("Restart");
            }
         });
        
        
        
        
        
        
   
        

        BackBt.setAlignment(javafx.geometry.Pos.CENTER);
        BackBt.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        BackBt.setId("resback");
        BackBt.setLayoutX(21.0);
        BackBt.setLayoutY(538.0);
        BackBt.setMaxHeight(USE_PREF_SIZE);
        BackBt.setMaxWidth(USE_PREF_SIZE);
        BackBt.setMinHeight(USE_PREF_SIZE);
        BackBt.setMinWidth(USE_PREF_SIZE);
        BackBt.setMnemonicParsing(false);
        BackBt.setPrefHeight(50.0);
        BackBt.setPrefWidth(140.0);
        BackBt.setText("Back");
        BackBt.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        BackBt.setOnAction((Action) -> {
            root.getChildren().remove(buttonsBase.multi);
            MenuGame.viewPane(MenuGame.selectmodepane);
            //change player status to not playing
            String updateState = "update player set playerStatus = 'idle' where playerUsername= " + "'" + SignInController.userNameFieldText + "' and playerPassword = " + "'" + SignInController.passwordFieldText + "' ";
            String updateString = "db.".concat(updateState);
            Client.ps.println(updateString);
            
        });
        currentplayer.setLayoutX(355.0);
        currentplayer.setLayoutY(49.0);
        currentplayer.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        currentplayer.setStrokeWidth(0.0);
        currentplayer.setText("X");
        currentplayer.setWrappingWidth(11.4000244140625);

        player1.setId("pane");
        player1.setLayoutX(4.0);
        player1.setLayoutY(266.0);
        player1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player1.setStrokeWidth(0.0);
        player1.setText("Player");

        nameplayer1.setLayoutX(27.0);
        nameplayer1.setLayoutY(314.0);
        nameplayer1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        nameplayer1.setStrokeWidth(0.0);
        nameplayer1.setText("xxx");

        score1.setLayoutX(13.0);
        score1.setLayoutY(389.0);
        score1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        score1.setStrokeWidth(0.0);
        score1.setText("Score:");

        scoreplayer1.setLayoutX(48.0);
        scoreplayer1.setLayoutY(444.0);
        scoreplayer1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        scoreplayer1.setStrokeWidth(0.0);
        scoreplayer1.setText("0");

        player2.setLayoutX(677.0);
        player2.setLayoutY(266.0);
        player2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player2.setStrokeWidth(0.0);
        player2.setText("Player");

        nameplayer2.setLayoutX(700.0);
        nameplayer2.setLayoutY(314.0);
        nameplayer2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        nameplayer2.setStrokeWidth(0.0);
        nameplayer2.setText("ooo");

        score2.setLayoutX(666.0);
        score2.setLayoutY(389.0);
        score2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        score2.setStrokeWidth(0.0);
        score2.setText("Score:");

        scoreplayer2.setLayoutX(722.0);
        scoreplayer2.setLayoutY(444.0);
        scoreplayer2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        scoreplayer2.setStrokeWidth(0.0);
        scoreplayer2.setText("0");

        text8.setLayoutX(393.0);
        text8.setLayoutY(49.0);
        text8.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text8.setStrokeWidth(0.0);
        text8.setText("Turn");

        playerx.setLayoutX(47.0);
        playerx.setLayoutY(220.0);
        playerx.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerx.setStrokeWidth(0.0);
        playerx.setText("X");

        playero.setLayoutX(709.0);
        playero.setLayoutY(220.0);
        playero.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playero.setStrokeWidth(0.0);
        playero.setText("O");

        recordbtn.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        recordbtn.setGraphicTextGap(0.0);
        recordbtn.setId("resback");
        recordbtn.setLayoutX(678.0);
        recordbtn.setLayoutY(91.0);
        recordbtn.setMnemonicParsing(false);
        recordbtn.setPrefHeight(57.0);
        recordbtn.setPrefWidth(109.0);
        recordbtn.setText("REC");
        recordbtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        pane.setPadding(new Insets(10.0, 10.0, 0.0, 100.0));
        setCenter(pane);
        
        recordbtn.setOnAction((ActionEvent event) -> {
            recordflag=true;
            recordbtn.setText("REC(now)");
        });
        
       
//        System.out.println("MySymbol"+beginBase.client.id);   
        for (Button location : locations) {
            location.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
                actionOnClickedButton((Button) e.getSource());
            });
        }
       
       
       
        
        System.out.println("End of Constructor");
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(locations[0]);
        gridPane.getChildren().add(locations[1]);
        gridPane.getChildren().add(locations[2]);
        gridPane.getChildren().add(locations[3]);
        gridPane.getChildren().add(locations[4]);
        gridPane.getChildren().add(locations[5]);
        gridPane.getChildren().add(locations[6]);
        gridPane.getChildren().add(locations[7]);
        gridPane.getChildren().add(locations[8]);
		
	
        
		
      
       
        pane.getChildren().add(gridPane);
        pane.getChildren().add(RestartBt);
        pane.getChildren().add(BackBt);
        pane.getChildren().add(currentplayer);
        pane.getChildren().add(player1);
        pane.getChildren().add(nameplayer1);
        pane.getChildren().add(score1);
        pane.getChildren().add(scoreplayer1);
        pane.getChildren().add(player2);
        pane.getChildren().add(nameplayer2);
        pane.getChildren().add(score2);
        pane.getChildren().add(scoreplayer2);
        pane.getChildren().add(text8);
        pane.getChildren().add(playerx);
        pane.getChildren().add(playero);
        pane.getChildren().add(recordbtn);
        
    
       
       
       
    }
	
  /************************************************************************************************/
   
     
    protected void incrementScore()
    {
        scoreplayer1.setText(String.valueOf(xCount));
        scoreplayer2.setText(String.valueOf(oCount));
    }
    
    void winLose(){
        
          if ("5".equals(scoreplayer1.getText())){
              if("X".equals(beginBase.client.id))
              {
                         MenuGame.viewPane(MenuGame.youWin);
                          MenuGame.youWin.player.play();   
              }
		      
              else if("O".equals(beginBase.client.id)){
               
                                 MenuGame.viewPane(MenuGame.lose);
              }
          }
		   
           else if ("5".equals(scoreplayer2.getText())){
              if("O".equals(beginBase.client.id))
              {
					
                                                 MenuGame.viewPane(MenuGame.youWin);
                                                 MenuGame.youWin.player.play();   
			  }
		      
              else if("X".equals(beginBase.client.id)){
                
                                   MenuGame.viewPane(MenuGame.lose);
              }
       }
    }
     
    
    
    protected void winningGame()
    {
        String location1 = locations[0].getText();
        String location2 = locations[1].getText();
        String location3 = locations[2].getText();
        String location4 = locations[3].getText();
        String location5 = locations[4].getText();
        String location6 = locations[5].getText();
        String location7 = locations[6].getText();
        String location8 = locations[7].getText();
        String location9 = locations[8].getText();
  
        
        
       if (location1.equals(location2) && location1.equals(location3) && !location1.equals("")) {
      
         if("X".equals(currentplayer.getText()))
            { 
                xCount++;
            }
        
            else if("O".equals(currentplayer.getText()))
           { 
                     oCount++;
           }
            incrementScore();
//            record();
            newGame();
            
            
        }
 
       else if (location4.equals(location5) && location4.equals(location6) && !location4.equals("")) {
        if("X".equals(currentplayer.getText()))
            { 
                xCount++;
            }
        
            else if("O".equals(currentplayer.getText()))
           { 
                     oCount++;
           }
            incrementScore();
//            record();
            newGame();
        }
// 
     else if (location7 .equals(location8) && location7 .equals(location9) && !location7 .equals("")) {
           if("X".equals(currentplayer.getText()))
            { 
                xCount++;
            }
        
            else if("O".equals(currentplayer.getText()))
           { 
                     oCount++;
           }
            incrementScore();
//            record();
              newGame();
        }
// 
       else if (location1.equals(location4) && location1.equals(location7 ) && !location1.equals("")) {
            if("X".equals(currentplayer.getText()))
            { 
                xCount++;
            }
        
            else if("O".equals(currentplayer.getText()))
           { 
                     oCount++;
           }
            incrementScore();
//            record();
              newGame();
        }

       else if (location2.equals(location5) && location2.equals(location8) && !location2.equals("")) {
            if("X".equals(currentplayer.getText()))
            { 
                xCount++;
            }
        
            else if("O".equals(currentplayer.getText()))
           { 
                     oCount++;
           }
            incrementScore();
//            record();
              newGame();
        }
// 
       else if (location3.equals(location6) && location3.equals(location9) && !location3.equals("")) {
             if("X".equals(currentplayer.getText()))
            { 
                xCount++;
            }
        
            else if("O".equals(currentplayer.getText()))
           { 
                     oCount++;
           }
            incrementScore();
//            record();
             newGame();
        }
// 
       else if (location1.equals(location5) && location1.equals(location9) && !location1.equals("")) {
           if("X".equals(currentplayer.getText()))
            { 
                xCount++;
            }
        
            else if("O".equals(currentplayer.getText()))
           { 
                     oCount++;
           }
            incrementScore();
//            record();
              newGame();
        }
// 
       else if (location3.equals(location5) && location3.equals(location7 ) && !location3.equals("")) {
         if("X".equals(currentplayer.getText()))
            { 
                xCount++;
            }
        
            else if("O".equals(currentplayer.getText()))
           { 
                     oCount++;
           }
            incrementScore();
//            record();
             newGame();
        }
       
       if("5".equals(scoreplayer1.getText()) || "5".equals(scoreplayer2.getText())){
           winLose();
           record();
       }
  
        if( clickCounter >= 9)
        {
            Alert a = new Alert(AlertType.INFORMATION); 
            a.setContentText("Tied,Try Again!");
            a.show();
            clickCounter = 0;
            newGame();
           
            
        }             
        
    }
    
    
    
    
    
    
    
    
    void actionOnClickedButton(Button clickedbutton){
        System.out.println("actionOnClickedButtn");
         System.out.println("MySymbol"+beginBase.client.id);
   if( clickedbutton.getText().equals("")){
       if("X".equals(beginBase.client.id)&& "X".equals(currentplayer.getText()))
        {
         //   nameplayer2.setText(name1);
              for (Button location : locations) {
                   location.setDisable(true);
                   location.setOpacity(1.0);
                        
                  }
            sendMovement(clickedbutton,"X");   
            
        }
        else if("O".equals(beginBase.client.id)&& "O".equals(currentplayer.getText()))
        {      
           // nameplayer1.setText(name1);
             for (Button location : locations) {
                        location.setDisable(true);
                        location.setOpacity(1.0);
                    }
            sendMovement(clickedbutton,"O");
            
        }    
     }    
        
 }
			
			
     void sendMovement(Button clickedButton, String symbol){
         System.out.println("sendMovement");
             if(clickedButton == locations[0])
                   Client.ps.println("Multi."+"1"+"."+symbol);
             
               else if(clickedButton == locations[1])
		    Client.ps.println("Multi."+"2"+"."+symbol);
               
               else if(clickedButton == locations[2])
                    Client.ps.println("Multi."+"3"+"."+symbol);
               else if(clickedButton == locations[3])
                    Client.ps.println("Multi."+"4"+"."+symbol);
             
               else if(clickedButton == locations[4])
                    Client.ps.println("Multi."+"5"+"."+symbol);
             
             else if(clickedButton == locations[5])
                    Client.ps.println("Multi."+"6"+"."+symbol);
             
             else if(clickedButton == locations[6])
                    Client.ps.println("Multi."+"7"+"."+symbol);
             
             else if(clickedButton == locations[7])
                    Client.ps.println("Multi."+"8"+"."+symbol);
             
             else if(clickedButton == locations[8])
                  Client.ps.println("Multi."+"9"+"."+symbol);
          }
      
	  
	  
	  
      void drawSymbol(String message){
          clickCounter++;
         String[] arrOfStr = message.split("\\.");
	
         if(recordflag == true)
         {
            moves.add(arrOfStr[1]+"."+arrOfStr[2]);
         }
             switch(arrOfStr[1]){
                 case "1":
                     locations[0].setText(arrOfStr[2]);
                     break;
                 case "2":
                      locations[1].setText(arrOfStr[2]);
                     break;
                 case "3":
                      locations[2].setText(arrOfStr[2]);
                     break;
                     
                  case "4":
                       locations[3].setText(arrOfStr[2]);
                     break;
                 case "5":
                      locations[4].setText(arrOfStr[2]);
                     break; 
                 case "6":
                      locations[5].setText(arrOfStr[2]);
                     break;
                 case "7":
                      locations[6].setText(arrOfStr[2]);
                     break;
                 case "8":
                      locations[7].setText(arrOfStr[2]);
                     break;
                 case "9":
                      locations[8].setText(arrOfStr[2]);
                     break;
             }
             if(replay == false){
              winningGame();  
              //  drawFlag = true;
                  
                if("X".equals(arrOfStr[2]) && "O".equals(beginBase.client.id)){
                    for (Button location : locations) {
                        location.setDisable(false);
                    }    
                     
                }
               
                 else if("O".equals(arrOfStr[2]) && "X".equals(beginBase.client.id)){
                       for (Button location : locations) {
//                              location.removeEventHandler(ActionEvent.ACTION, (ActionEvent e)->{
//                              actionOnClickedButton((sButton) e.getSource());
//                       });
                        location.setDisable(false);
                    }    
                }
             }
                 if("X".equals(currentplayer.getText()))
                     currentplayer.setText("O");
                 else if("O".equals(currentplayer.getText()))
                     currentplayer.setText("X");
            
      }
      
     void record(){
         if(recordflag==true){
          for (int i=0;i<moves.size();i++) {
          if(i< (moves.size()-1))
             clinetmoves.append(moves.get(i)+":");
          else
              clinetmoves.append(moves.get(i));
      }
          
          
        str_clintmoves = clinetmoves.toString();
        str_clintmoves = str_clintmoves;
        
        //insert record into database^^:
        String insertRec = "insert into game (moves,playerId1,playerId2) values(?,?,?)";
               // + "//" + "'" + rec + "'," + "'" + id1 + "'  , " + "'" + id2 + "')";
        String insertRecString ="db*record*".concat(insertRec+"*").concat(str_clintmoves+"*").concat("1"+"*").concat("2");
        Client.ps.println(insertRecString);
        System.out.println("me! ");
        Client.ps.println(str_clintmoves);
       
        recordflag=false;
        recordbtn.setText("REC");
         clinetmoves.delete(0,clinetmoves.length());
           str_clintmoves = "";
           moves.clear();
       }
     
     }
     
      void newGame(){
           //System.out.println("NewGame");
           clickCounter = 0;
           nameplayer1.setText(beginBase.client.name1);
           nameplayer2.setText(beginBase.client.name2);
          
          
      
        
       for (int i=0; i<locations.length;i++) {
            locations[i].setText("");
        }
          
            for (Button location : locations)
                location.setDisable(false);
       
        if("X".equals(beginBase.client.id))
        {
            
           for(Button location:locations)
               location.setDisable(false);
        }
        
        else if("O".equals(beginBase.client.id)){
             
                         for (Button location : locations) {
                                location.setDisable(true);
                                location.setOpacity(1.0);
         }
        
        }
      
    }

   
  void restartGame(){
               oCount=0;
               xCount=0;
               newGame();
              scoreplayer1.setText("0");
              scoreplayer2.setText("0");
  }
  
 
}
    
 
 
        
       
 

