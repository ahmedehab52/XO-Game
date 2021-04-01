package game;

import game.Client;
import game.MenuGame;
import game.SignInController;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MenuBase extends Pane {

    protected final Text text;
    protected final Pane pane;
    protected final Button button;
    protected final Button button0;
    protected final Button button1;
    protected final Button button2;
    protected final Button button3;

    public MenuBase() {

        text = new Text();
        pane = new Pane();
        button = new Button();
        button0 = new Button();
        button1 = new Button();
        button2 = new Button();
        button3 = new Button();

        setId("pane");
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(580.0);
        setPrefWidth(806.0);
        //getStylesheets().add("/menugame/menu.css");

        text.setLayoutX(199.0);
        text.setLayoutY(56.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("TIC-TAC-TOE");
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text.setWrappingWidth(407.7691116333008);
        text.setFont(new Font("System Bold", 51.0));

        pane.setLayoutX(203.0);
        pane.setLayoutY(103.0);
        pane.setMaxHeight(USE_PREF_SIZE);
        pane.setMaxWidth(USE_PREF_SIZE);
        pane.setMinHeight(USE_PREF_SIZE);
        pane.setMinWidth(USE_PREF_SIZE);
        pane.setPrefHeight(374.0);
        pane.setPrefWidth(400.0);

        button.setAlignment(javafx.geometry.Pos.CENTER);
        button.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        button.setId("button");
        button.setLayoutX(75.0);
        button.setMaxHeight(USE_PREF_SIZE);
        button.setMaxWidth(USE_PREF_SIZE);
        button.setMinHeight(USE_PREF_SIZE);
        button.setMinWidth(USE_PREF_SIZE);
        button.setMnemonicParsing(false);
        button.setPrefHeight(65.0);
        button.setPrefWidth(250.0);
        button.setText("Start");
        button.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        button.setOnAction(Action -> {
            MenuGame.viewPane(MenuGame.selectmodepane);
        });

        button0.setAlignment(javafx.geometry.Pos.CENTER);
        button0.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        button0.setId("button");
        button0.setLayoutX(75.0);
        button0.setLayoutY(80.0);
        button0.setMaxHeight(USE_PREF_SIZE);
        button0.setMaxWidth(USE_PREF_SIZE);
        button0.setMinHeight(USE_PREF_SIZE);
        button0.setMinWidth(USE_PREF_SIZE);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(65.0);
        button0.setPrefWidth(250.0);
        button0.setText("How to Play?");
        button0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        button0.setOnAction(Action -> {
            MenuGame.viewPane(MenuGame.howPlayPane);
        });
        
        button1.setAlignment(javafx.geometry.Pos.CENTER);
        button1.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        button1.setId("button");
        button1.setLayoutX(75.0);
        button1.setLayoutY(155.0);
        button1.setMaxHeight(USE_PREF_SIZE);
        button1.setMaxWidth(USE_PREF_SIZE);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(65.0);
        button1.setPrefWidth(250.0);
        button1.setText("About");
        button1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        button1.setOnAction(Action -> {
            MenuGame.viewPane(MenuGame.aboutPane);
        });

        button2.setAlignment(javafx.geometry.Pos.CENTER);
        button2.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        button2.setId("button");
        button2.setLayoutX(75.0);
        button2.setLayoutY(309.0);
        button2.setMaxHeight(USE_PREF_SIZE);
        button2.setMaxWidth(USE_PREF_SIZE);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(65.0);
        button2.setPrefWidth(250.0);
        button2.setText("Exit");
        button2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        button2.setOnAction(Action -> {

            //player not connected to game
            String updateState = "update player set playerState = 'disconnected' where playerUsername= " + "'" + SignInController.userNameFieldText + "' and playerPassword = " + "'" + SignInController.passwordFieldText + "' ";
            String updateString = "db.".concat(updateState);
            Client.ps.println(updateString);
            
            //close window
            System.exit(0);
        });

        button3.setId("button");
        button3.setLayoutX(75.0);
        button3.setLayoutY(231.0);
        button3.setMaxHeight(USE_PREF_SIZE);
        button3.setMaxWidth(USE_PREF_SIZE);
        button3.setMinHeight(USE_PREF_SIZE);
        button3.setMinWidth(USE_PREF_SIZE);
        button3.setMnemonicParsing(false);
        button3.setPrefHeight(65.0);
        button3.setPrefWidth(250.0);
        button3.setText("Records");
        button3.setOnAction(Action -> {
             System.out.println("replay");
             String s = "db.record.select * FROM game WHERE playerId1 = 1 and playerId2=2";
             Client.ps.println(s);
              MenuGame.viewPane(MenuGame.recordTable);
        });

        getChildren().add(text);
        pane.getChildren().add(button);
        pane.getChildren().add(button0);
        pane.getChildren().add(button1);
        pane.getChildren().add(button2);
        pane.getChildren().add(button3);
        getChildren().add(pane);

    }
}
