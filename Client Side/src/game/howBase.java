package game;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class howBase extends Pane {

    protected final Text text;
    protected final Button backBtn;
    public howBase() {

        text = new Text();
        backBtn = new Button();
        setId("pane");
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(602.0);
        setPrefWidth(806.0);
        

        text.setId("how-Text");
        text.setLayoutX(190.0);
        text.setLayoutY(154.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("HOW TO PLAY\nツ Choose your opponent\nツ Press a square to place your mark\nツ Make three in a row horizontally, vertically, or diagonally to win\nツ Watch your opponent and block them if they get 2 in a row\nツ Use the Restart Button to reset your scores for the current opponent");
        text.setWrappingWidth(386.264835357666);
        text.setX(20.0);
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
        getChildren().add(backBtn);
    }
}
