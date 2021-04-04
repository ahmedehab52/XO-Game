package game;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class buttonsBase extends Pane {

    protected final Pane pane;
    protected final Button button;
    protected final Button button0;
    protected final Button button1;
    static MultiPlayer multi;

    public buttonsBase() {

        pane = new Pane();
        button = new Button();
        button0 = new Button();
        button1 = new Button();

        setId("pane");
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(580.0);
        setPrefWidth(806.0);

        pane.setLayoutX(213.0);
        pane.setLayoutY(113.0);
        pane.setMaxHeight(USE_PREF_SIZE);
        pane.setMaxWidth(USE_PREF_SIZE);
        pane.setMinHeight(USE_PREF_SIZE);
        pane.setMinWidth(USE_PREF_SIZE);
        pane.setPrefHeight(374.0);
        pane.setPrefWidth(400.0);

        button.setAlignment(javafx.geometry.Pos.CENTER);
        button.setId("button");
        button.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        button.setLayoutX(75.0);
        button.setLayoutY(88.0);
        button.setMaxHeight(USE_PREF_SIZE);
        button.setMaxWidth(USE_PREF_SIZE);
        button.setMinHeight(USE_PREF_SIZE);
        button.setMinWidth(USE_PREF_SIZE);
        button.setMnemonicParsing(false);
        button.setPrefHeight(65.0);
        button.setPrefWidth(250.0);
        button.getStyleClass().add("pink-btn");
        button.setText("Single Mode");
        button.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        button.setOnAction((Action) -> {
            MenuGame.viewPane(MenuGame.singlePlayerPane);
            //change player status to playing
            String updateState = "update player set playerStatus = 'playing' where playerUsername= " + "'" + SignInController.userNameFieldText + "' and playerPassword = " + "'" + SignInController.passwordFieldText + "' ";
            String updateString = "db.".concat(updateState);
            Client.ps.println(updateString);
        });

        button0.setId("button");
        button0.setAlignment(javafx.geometry.Pos.CENTER);
        button0.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        button0.setLayoutX(75.0);
        button0.setLayoutY(196.0);
        button0.setMaxHeight(USE_PREF_SIZE);
        button0.setMaxWidth(USE_PREF_SIZE);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(65.0);
        button0.setPrefWidth(250.0);
        button0.getStyleClass().add("pink-btn2");
        button0.setText("Multi Mode");
        button0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        button0.setOnAction(Action -> {
            Client.ps.println("Two Players Game"+":"+SignInController.userId);
            String updateState = "update player set playerStatus = 'playing' where playerUsername= " + "'" + SignInController.userNameFieldText + "' and playerPassword = " + "'" + SignInController.passwordFieldText + "' ";
            String updateString = "db.".concat(updateState);
            Client.ps.println(updateString);
            MenuGame.viewPane(MenuGame.multiPlayerPane);
            System.out.println("I update palyer status,let's begin.");
        });

        button1.setId("button");
        button1.setAlignment(javafx.geometry.Pos.CENTER);
        button1.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        button1.setLayoutX(14.0);
        button1.setLayoutY(517.0);
        button1.setMaxHeight(USE_PREF_SIZE);
        button1.setMaxWidth(USE_PREF_SIZE);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(41.0);
        button1.setPrefWidth(110);
        button1.getStyleClass().add("pink-btn3");
        button1.setText("Back");
        button1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        button1.setOnAction((Action) -> {
            MenuGame.viewPane(MenuGame.startPane);
        });
        pane.getChildren().add(button);
        pane.getChildren().add(button0);
        getChildren().add(pane);
        getChildren().add(button1);

    }
}
