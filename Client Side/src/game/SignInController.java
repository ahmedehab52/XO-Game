/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import com.jfoenix.controls.JFXButton;
import static game.SignUpController.userNameFieldText;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author omniahassan
 */
public class SignInController implements Initializable {

    String data;

    static String userNameFieldText;
    static String passwordFieldText;
    static String serverData;
    @FXML
    private TextField textemail;
    @FXML
    private TextField textpass;
    @FXML
    private JFXButton butsin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        serverData = "";
    }

    @FXML
    private void signInMethod(ActionEvent event) throws IOException {
        System.out.println("Starting signing in ...");
        //  System.out.println("client sent---> " + serverData);
        //connect to db
        /*DataBase db = null;
        try {
            db = new DataBase();
        } catch (SQLException ex) {
            Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        // ResultSet rs1 = null; //result of execute query
        //int s = 0;  //result of update query
        userNameFieldText = textemail.getText();  //getting user name
        passwordFieldText = textpass.getText();  //getting user password
        // Alerts Alert1 = new Alerts(); //creating alert

        //checking that fields are not empty
        if ((!(userNameFieldText.equals(""))) && (!(passwordFieldText.equals("")))) { //if user name is not null and password not null
            System.out.println("user Name Field Text ..." + userNameFieldText);
            String queryString1 = new String("select * from player where playerUsername= " + "'" + userNameFieldText + "' and playerPassword = " + "'" + passwordFieldText + "' ");

//sending data to server
            data = "db.in.".concat(queryString1);
            Client.ps.println(data);  //server part
            //recieving from server:
            //serverData = client.s

        } //case that fields are empty:
        else {
            Alerts Alert1 = new Alerts();
            Alert1.ErrorAlert("ERROR", "you Must enter a user name and password...");
        }
    }

    static void authcheck(String s) {
        Alerts Alert1 = new Alerts();
        if (s.contains("notExist")) {
            System.out.println("Authentication Failed!");
            Alert1.ErrorAlert("ERROR", "User name: " + userNameFieldText + " doesnot Exist or wrong password O_o, try again... ");

        } else {
            System.out.println("Now,you can start your Game.");
            
            
            MenuGame.singlePlayerPane.text1.setText(userNameFieldText);
            //update player state to connected
            String updateState = "update player set playerState = 'connected' where playerUsername= " + "'" + userNameFieldText + "' and playerPassword = " + "'" + passwordFieldText + "' ";
            String updateString="db.".concat(updateState);
            Client.ps.println(updateString);  
            //go to main menu:
            MenuGame.viewPane(MenuGame.startPane);
        }
    }
}

