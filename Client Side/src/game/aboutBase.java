package game;

import javafx.scene.layout.Pane;
import javafx.scene.control.Button;

import javafx.scene.text.Text;

public class aboutBase extends Pane {

    protected final Text text;
    protected final Text text0;
    protected final Button backBtn;
    public aboutBase() {

        text = new Text();
        text0 = new Text();
        backBtn = new Button();
        setId("pane");
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(602.0);
        setPrefWidth(806.0);
        
        text.setId("about-Text");
        text.setLayoutX(199.0);
        text.setLayoutY(149.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("RULES\nTic-Tac-Toe is a simple and fun game for 2 players, X and O.\nIt is played on a 3x3 grid.\nEach player's goal is to make 3 in a row.");
        text.setWrappingWidth(421.46563720703125);

        text0.setId("about-Text");
        text0.setLayoutX(199.0);
        text0.setLayoutY(359.0);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("Ahmed Ehab\nOmnia Hassan\nDina Mohammed\nAya Abdelkader\nAbdelraouf Abdelaziz");
        text0.setWrappingWidth(290.068359375);
         
        backBtn.setId("button");
        backBtn.setAlignment(javafx.geometry.Pos.CENTER);
        backBtn.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        backBtn.setLayoutX(14.0);
        backBtn.setLayoutY(517.0);
        backBtn.setMaxHeight(USE_PREF_SIZE);
        backBtn.setMaxWidth(USE_PREF_SIZE);
        backBtn.setMnemonicParsing(false);
        backBtn.setPrefHeight(41.0);
        backBtn.setPrefWidth(110);
        backBtn.getStyleClass().add("pink-btn3");
        backBtn.setText("Back");
        backBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        backBtn.setOnAction((Action) ->{
            MenuGame.viewPane(MenuGame.startPane);
        });
        getChildren().add(text);
        getChildren().add(text0);
        getChildren().add(backBtn);

    }
}
