package game;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public  class loseBaseSingle extends Pane {

    protected final Button button;
    protected final Button button0;

    public loseBaseSingle() {

        button = new Button();
        button0 = new Button();

        setId("Pane");
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(580.0);
        setPrefWidth(800.0);
     //   getStylesheets().add("lose.css");
        button.setId("button-lose");
        button.setLayoutX(69.0);
        button.setLayoutY(465.0);
        button.setMnemonicParsing(false);
        button.setText("Return To Menu");
        button.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
                MenuGame.viewPane(MenuGame.startPane);
                
            });

        button0.setId("button-lose");
        button0.setLayoutX(560.0);
        button0.setLayoutY(465.0);
        button0.setMnemonicParsing(false);
        button0.setText("Exit");
         button0.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
               System.exit(0);
            });

        getChildren().add(button);
        getChildren().add(button0);

    }
}
