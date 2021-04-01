package game;

import static game.PlayerRecord.locations;
import java.util.Random;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow; 
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public  class SinglePlayer extends BorderPane {

    protected final Pane pane;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    static Button[] locations = new Button[9];
    protected final Button restartButton;
    protected final Button button9;
    protected final Text text;
    protected final Text text0;
    protected final Text text1;
    protected final Text text2;
    protected final Text text3;
    protected final Text text4;
    protected final Text text5;
    protected final Text text6;
    protected final Text text7;
    protected final Text text8;
    protected final Text text9;
    protected final Text text10;
    protected final Button button10;
    int clickCounter;
    boolean firstPlayerTurn;
    boolean gameEnd;
    Random random ;
    int randomNumber;
    Media media = null;
    AudioClip audioPlayer;
    PauseTransition newGameTrans;
    PauseTransition pause;
    String movements;
    boolean recFlag;
   
    

    public SinglePlayer() {
        
        recFlag = false;
        audioPlayer = new AudioClip(getClass().getResource("winning_sound.mp3").toExternalForm());
        pause = new PauseTransition(Duration.millis(500));
         pause.setOnFinished(
                             e -> {
                                   computerTurn();
                             });
         newGameTrans = new PauseTransition(Duration.millis(7000));
         newGameTrans.setOnFinished(
                             e -> {
                                   newGame();
                             });
        random = new Random();
        clickCounter = 0;
       // firstPlayerTurn = true;
        gameEnd = false;
        
        pane = new Pane();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        
        for (int i = 0; i < locations.length; i++) {

            locations[i] = new Button();
        }
        
        
        restartButton = new Button();
        button9 = new Button();
        text = new Text();
        text0 = new Text();
        text1 = new Text();
        text2 = new Text();
        text3 = new Text();
        text4 = new Text();
        text5 = new Text();
        text6 = new Text();
        text7 = new Text();
        text8 = new Text();
        text9 = new Text();
        text10 = new Text();
        button10 = new Button();

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
       // pane.getStylesheets().add("/game/mycss.css");

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

        restartButton.setAlignment(javafx.geometry.Pos.BASELINE_CENTER);
        restartButton.setId("resback");
        restartButton.setLayoutX(639.0);
        restartButton.setLayoutY(531.0);
        restartButton.setMinWidth(USE_PREF_SIZE);
        restartButton.setMnemonicParsing(false);
        restartButton.setPrefHeight(50.0);
        restartButton.setPrefWidth(140.0);
        restartButton.setText("Restart");
        restartButton.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        
        restartButton.setOnAction((Action) -> {
            restartGame();
        }); 
        button9.setAlignment(javafx.geometry.Pos.CENTER);
        button9.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        button9.setId("resback");
        button9.setLayoutX(21.0);
        button9.setLayoutY(538.0);
        button9.setMaxHeight(USE_PREF_SIZE);
        button9.setMaxWidth(USE_PREF_SIZE);
        button9.setMinHeight(USE_PREF_SIZE);
        button9.setMinWidth(USE_PREF_SIZE);
        button9.setMnemonicParsing(false);
        button9.setPrefHeight(50.0);
        button9.setPrefWidth(140.0);
        button9.setText("Back");
        button9.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
       button9.setOnAction((Action) -> {
            MenuGame.viewPane(MenuGame.selectmodepane);
            //change player status to not playing
            String updateState = "update player set playerStatus = 'idle' where playerUsername= " + "'" + SignInController.userNameFieldText + "' and playerPassword = " + "'" + SignInController.passwordFieldText + "' ";
            String updateString = "db.".concat(updateState);
            Client.ps.println(updateString);
        });

        text.setLayoutX(355.0);
        text.setId("text");
        text.setLayoutY(49.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("X");
        text.setWrappingWidth(11.4000244140625);

        text0.setId("pane");
        text0.setId("text");
        text0.setLayoutX(4.0);
        text0.setLayoutY(266.0);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("Player");

        text1.setLayoutX(27.0);
        text1.setId("PlayerName");
        text1.setId("text");
        text1.setLayoutY(314.0);
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText("xxx");

        text2.setLayoutX(13.0);
        text2.setId("text");
        text2.setLayoutY(389.0);
        text2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text2.setStrokeWidth(0.0);
        text2.setText("Score:");

        text3.setLayoutX(48.0);
        text3.setId("text");
        text3.setLayoutY(444.0);
        text3.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text3.setStrokeWidth(0.0);
        text3.setText("0");

        text4.setLayoutX(677.0);
        text4.setId("text");
        text4.setLayoutY(266.0);
        text4.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text4.setStrokeWidth(0.0);
        text4.setText("Player");

        text5.setLayoutX(640.0);
        text5.setLayoutY(314.0);
        text5.setId("text");
        text5.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text5.setStrokeWidth(0.0);
        text5.setText("Computer");

        text6.setLayoutX(666.0);
        text6.setId("text");
        text6.setLayoutY(389.0);
        text6.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text6.setStrokeWidth(0.0);
        text6.setText("Score:");

        text7.setLayoutX(722.0);
        text7.setId("text");
        text7.setLayoutY(444.0);
        text7.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text7.setStrokeWidth(0.0);
        text7.setText("0");

        text8.setLayoutX(393.0);
        text8.setId("text");
        text8.setLayoutY(49.0);
        text8.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text8.setStrokeWidth(0.0);
        text8.setText("Turn");

        text9.setLayoutX(47.0);
        text9.setId("text");
        text9.setLayoutY(220.0);
        text9.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text9.setStrokeWidth(0.0);
        text9.setText("X");

        text10.setLayoutX(709.0);
        text10.setId("text");
        text10.setLayoutY(220.0);
        text10.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text10.setStrokeWidth(0.0);
        text10.setText("O");

        button10.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        button10.setGraphicTextGap(0.0);
        button10.setId("resback");
        button10.setLayoutX(678.0);
        button10.setLayoutY(91.0);
        button10.setMnemonicParsing(false);
        button10.setPrefHeight(57.0);
        button10.setPrefWidth(109.0);
        button10.setText("REC");
        button10.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        pane.setPadding(new Insets(10.0, 10.0, 0.0, 100.0));
        setCenter(pane);
        button10.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> { 
                recFlag = true;
        });

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
        
         //Add Event To 9 Buttons
        for(int i=0;i<locations.length;i++){
          
            locations[i].addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
               
                actionOnClickedButton((Button) e.getSource());
            });
        }

      
           
        pane.getChildren().add(gridPane);
        pane.getChildren().add(restartButton);
        pane.getChildren().add(button9);
        pane.getChildren().add(text);
        pane.getChildren().add(text0);
        pane.getChildren().add(text1);
        pane.getChildren().add(text2);
        pane.getChildren().add(text3);
        pane.getChildren().add(text4);
        pane.getChildren().add(text5);
        pane.getChildren().add(text6);
        pane.getChildren().add(text7);
        pane.getChildren().add(text8);
        pane.getChildren().add(text9);
        pane.getChildren().add(text10);
        pane.getChildren().add(button10);
        
        
         
      
        newGame();
        setCurrentPlayerSymbol();

    }
    public void winColor(Button b1, Button b2, Button b3){
            b1.setId("btn");
            b2.setId("btn");
            b3.setId("btn");
            MenuGame.viewPane(MenuGame.youWin);
    }
    
    public void resetWinColor(){
        for(int i=0;i<9;i++)
           locations[i].setId("Button");    
    }
    
    private void checkGameState() {        
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
            gameEnd = true;
            winColor(locations[0],locations[1],locations[2]);
            incrementScore();
            newGameTrans.play();
        //    System.out.println(movements);
        }
 
        if (location4.equals(location5) && location4.equals(location6) && !location4.equals("")) {
             
             winColor(locations[3],locations[4],locations[5]);
            incrementScore();
            newGameTrans.play();
            //System.out.println(movements); 
        }
 
        if (location7 .equals(location8) && location7 .equals(location9) && !location7 .equals("")) {
            gameEnd = true;
             winColor(locations[6],locations[7],locations[8]);
            incrementScore();
            newGameTrans.play();
          // System.out.println(movements);
        }
 
        if (location1.equals(location4) && location1.equals(location7 ) && !location1.equals("")) {
            gameEnd = true;
             winColor(locations[0],locations[3],locations[6]);
            incrementScore();
            newGameTrans.play();
        //    System.out.println(movements);
        }
 
        if (location2.equals(location5) && location2.equals(location8) && !location2.equals("")) {
            gameEnd = true;
             winColor(locations[1],locations[4],locations[7]);
            incrementScore();
            newGameTrans.play();
            //System.out.println(movements);
        }
 
        if (location3.equals(location6) && location3.equals(location9) && !location3.equals("")) {
            gameEnd = true;
            winColor(locations[2],locations[5],locations[8]);
            incrementScore();
            newGameTrans.play();
           // System.out.println(movements);
        }
 
        if (location1.equals(location5) && location1.equals(location9) && !location1.equals("")) {
            gameEnd = true;
            winColor(locations[0],locations[4],locations[8]);
            incrementScore();
            newGameTrans.play();
            //System.out.println(movements);
        }
 
        if (location3.equals(location5) && location3.equals(location7 ) && !location3.equals("")) {
            gameEnd = true;
            winColor(locations[2],locations[4],locations[6]);
            incrementScore();
            newGameTrans.play();
           // System.out.println(movements);
        }
        
//       if("5".equals(text3.getText()) || "5".equals(text7.getText())){
//           winLose();
//       }
        if( clickCounter >= 9)
        {
            gameEnd = true;
            firstPlayerTurn = true;
            clickCounter = 0;
            newGameTrans.play();
        }             
        
    }
    
    private void incrementScore(){
            if(firstPlayerTurn)
            {
                text3.setText(Integer.valueOf(text3.getText()) + 1 + "");
                MenuGame.viewPane(MenuGame.youWinSingle);
                MenuGame.youWinSingle.player.play();   
            }
            else
            {
                text7.setText(Integer.valueOf(text7.getText()) + 1 + "");
                MenuGame.viewPane(MenuGame.loseSingle);
            }
    }
    
    private void setCurrentPlayerSymbol() {
        
        if (firstPlayerTurn == true) {
             text.setText("X");
        } else {
            text.setText("O");
        }
        
    }
    
    
    private void restartGame() {

        newGame();
        text3.setText("0");
        text7.setText("0");

    }
    
      void newGame() {
      
        gameEnd = false;
        //recFlag = false;
        clickCounter = 0;
        firstPlayerTurn = true;
        setCurrentPlayerSymbol();

        for (Button location : locations) {
            location.setText("");
        }
       resetWinColor();
    }

    
    private  void actionOnClickedButton(Button clickedButton)
    {
        if( gameEnd == false && clickedButton.getText().equals("") )
        {    
               sendMovement(clickedButton,"X");
                 pause.play();
              
        } 
        
    }
    
    private void computerTurn(){
             if(gameEnd == false)
                {
                    
                    for (Button location : locations) {
                        location.removeEventHandler(ActionEvent.ACTION, (ActionEvent e)->{
                              actionOnClickedButton((Button) e.getSource());
                       });
                    }
                    for (;;) {
                        randomNumber = random.nextInt(9);

                        if (locations[randomNumber].getText().equals(""))
                        {
                          locations[randomNumber].setFont(new Font("Times New Roman Bold", 30));
                           sendMovement(locations[randomNumber],"O");
                            break;
                        }
                    }   
                  
                }
       }
    
     void sendMovement(Button clickedButton, String symbol){
             if(clickedButton == locations[0])
                   beginBase.client.ps.println("Single."+"1"+"."+symbol);
             
               else if(clickedButton == locations[1])
	            beginBase.client.ps.println("Single."+"2"+"."+symbol);
               
               else if(clickedButton == locations[2])
                     beginBase.client.ps.println("Single."+"3"+"."+symbol);
               else if(clickedButton == locations[3])
                     beginBase.client.ps.println("Single."+"4"+"."+symbol);
             
               else if(clickedButton == locations[4])
                     beginBase.client.ps.println("Single."+"5"+"."+symbol);
             
             else if(clickedButton == locations[5])
                     beginBase.client.ps.println("Single."+"6"+"."+symbol);
             
             else if(clickedButton == locations[6])
                     beginBase.client.ps.println("Single."+"7"+"."+symbol);
             
             else if(clickedButton == locations[7])
                     beginBase.client.ps.println("Single."+"8"+"."+symbol);
             
             else if(clickedButton == locations[8])
                   beginBase.client.ps.println("Single."+"9"+"."+symbol);
          }
      
      
     void drawSymbol(String message){
      clickCounter++;
      if(recFlag){
        movements+= message+",";
      }
      String[] arrOfStr = message.split("\\.");
		for(String p:arrOfStr){  
             System.out.println(p);  
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
                 checkGameState();
                 
                   if(firstPlayerTurn == true)
                      firstPlayerTurn = false;
                   else
                      firstPlayerTurn = true;
                   
                    setCurrentPlayerSymbol();
                    
                 
              
      }
}
