package game;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public  class winBaseSingle extends Pane {

    protected final Button button;
    protected final Button button0;

    public winBaseSingle() {

        button = new Button();
        button0 = new Button();

        setId("pane-win");
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(604.0);
        setPrefWidth(800.0);
      //  getStylesheets().add("/win/Win.css");

        button.setId("button-win");
        button.setLayoutX(79.0);
        button.setLayoutY(496.0);
        button.setMnemonicParsing(false);
        button.setText("Back To Menu");
         button.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
                MenuGame.viewPane(MenuGame.startPane);
                MenuGame.singlePlayerPane.restartGame();
            });
        button0.setId("button-win");
        button0.setLayoutX(552.0);
        button0.setLayoutY(496.0);
        button0.setMnemonicParsing(false);
        button0.setText("Continue");
        button0.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
                MenuGame.viewPane(MenuGame.singlePlayerPane);
                MenuGame.singlePlayerPane.newGame();
                MenuGame.youWinSingle.player.stop();   
        });

        getChildren().add(button);
        getChildren().add(button0);

    }
}
