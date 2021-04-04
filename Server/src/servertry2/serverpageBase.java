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

public class serverpageBase extends Pane {

    static  Label label;
    static  TextField textField;
    static  TextField textField0;
    static  Button button;
    static String name;
    static String pass;
    
    public serverpageBase() {

        label = new Label();
        textField = new TextField();
        textField0 = new TextField();
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
        label.setLayoutY(95.0);
        label.setPrefHeight(100.0);
        label.setPrefWidth(308.0);
        label.setText("Sign In To DataBase");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#d69d3c"));
        label.setFont(new Font("Copperplate Gothic Bold", 27.0));

        textField.setId("TextField");
        textField.setLayoutX(184.0);
        textField.setLayoutY(252.0);
        textField.setPrefHeight(50.0);
        textField.setPrefWidth(432.0);
        textField.setPromptText("User Name");

        textField0.setId("Password");
        textField0.setLayoutX(184.0);
        textField0.setLayoutY(315.0);
        textField0.setPrefHeight(47.0);
        textField0.setPrefWidth(432.0);
        textField0.setPromptText("Password");

        button.setId("Button");
        button.setLayoutX(433.0);
        button.setLayoutY(432.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(40.0);
        button.setPrefWidth(170.0);
     //   button.getStylesheets().add("/serverpage/serverpage.css");
        button.setText("Submit");
        button.setOnAction((ActionEvent event) -> {
             name = textField.getText();
            pass = textField0.getText();
            Server myServer = new Server(name,pass);
           // label.setText("Sign In To DataBase");
        });

        getChildren().add(label);
        getChildren().add(textField);
        getChildren().add(textField0);
        getChildren().add(button);

    }
}
