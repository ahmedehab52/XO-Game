package servertry2;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.*;
import java.net.*;

public class ServerRun extends Pane {

    static  Label label;
    
    static  Button button;

    public ServerRun() {

        label = new Label();
        button = new Button();

        setId("pane");
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(604.0);
        setPrefWidth(800.0);
      //  getStylesheets().add("/serverpage/serverpage.css");

        label.setLayoutX(272.0);
        label.setLayoutY(250.0);
        label.setPrefHeight(100.0);
        label.setPrefWidth(308.0);
        label.setText("Server Is Running ..... ");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#d69d3c"));
        label.setFont(new Font("Copperplate Gothic Bold", 27.0));

       
        button.setId("Button");
        button.setLayoutX(433.0);
        button.setLayoutY(432.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(40.0);
        button.setPrefWidth(170.0);
     //   button.getStylesheets().add("/serverpage/serverpage.css");
        button.setText("Turn Off");
        button.setOnAction((ActionEvent event) -> {
              System.exit(0);
        });

        getChildren().add(label);
        getChildren().add(button);

    }
}
