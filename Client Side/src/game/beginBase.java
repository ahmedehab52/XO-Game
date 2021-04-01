package game;

import game.MenuGame;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class beginBase extends Pane {

    protected final ImageView imageView;
    protected final TextField textField;
    protected final Button button; 
    public  static Client client ;
    public beginBase() {

        imageView = new ImageView();
        textField = new TextField();
        button = new Button();

        setId("pane-intial");
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(604.0);
        setPrefWidth(800.0);
       // getStylesheets().add("/xo/begin.css");

        imageView.setFitHeight(136.0);
        imageView.setFitWidth(428.0);
        imageView.setLayoutX(186.0);
        imageView.setLayoutY(221.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("stone-clip-tic-tac-3.gif").toExternalForm()));

        textField.setLayoutX(216.0);
        textField.setLayoutY(450.0);
        textField.setPrefHeight(30.0);
        textField.setPrefWidth(170.0);
        textField.setPromptText("127.0.0.1");
        textField.setId("TextField-intial");
        
        
        //button.setId("button");
        button.setLayoutX(422.0);
        button.setLayoutY(442.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(42.0);
        button.setPrefWidth(170.0);
        //button.getStylesheets().add("/xo/begin.css");
        button.setText("Connect To Server");
        button.setId("Butto-intial");
        button.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
              client = new Client(textField.getText());
              MenuGame.viewPane(MenuGame.myroot);
        });
        getChildren().add(imageView);
        getChildren().add(textField);
        getChildren().add(button);
       

    }
}
