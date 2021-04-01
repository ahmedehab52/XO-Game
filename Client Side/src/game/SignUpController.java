/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import com.jfoenix.controls.JFXButton;
import static game.SignInController.userNameFieldText;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

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
public class SignUpController implements Initializable {

    String data;
    Alerts Alert2 = new Alerts(); //creating alert
    static String userNameFieldText;
    static String emailFieldText;
    static String passwordFieldText;
    @FXML
    private Pane fxml;
    private VBox VBox;

    @FXML
    private TextField textname;
    @FXML
    private TextField textmail;
    @FXML
    private PasswordField textpass;
    @FXML
    private JFXButton butsup;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void SignUpMethod(ActionEvent event) {
        System.out.println("Starting signing up ...");
        userNameFieldText = textname.getText();  //getting user name
        emailFieldText = textmail.getText();  //getting user name
        passwordFieldText = textpass.getText();  //getting user password

        if ((!(userNameFieldText.equals(""))) && (!(passwordFieldText.equals(""))) && (!(emailFieldText.equals("")))) { //if user name is not null, email not null and  password not null
            System.out.println("user Name Field Text ..." + userNameFieldText);
            
            //Email Validation:
            //Regular Expression   
            String regex = "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
            //Compile regular expression to get the pattern  
            Pattern pattern = Pattern.compile(regex);
            //Create instance of matcher   
            Matcher matcher = pattern.matcher(emailFieldText);

            if (matcher.matches() && (passwordFieldText.length()>=8) ) {
                System.out.println(emailFieldText + " : " + matcher.matches() + "\n");
                
                String queryString1 = new String("select * from player where playerUsername= " + "'" + userNameFieldText + "' ");
                //sending data to server
                data = "db.up.".concat(queryString1);
                Client.ps.println(data);  //server part
            } else if (passwordFieldText.length()<8){
                System.out.println("false");
                Alert2.ErrorAlert("ERROR", "Password must be longer than 8 characters...");
            }
            else {
                System.out.println("false");
                Alert2.ErrorAlert("ERROR", "Not valid Email...");
            }
            

        } //case that fields are empty:
        else {

            Alert2.ErrorAlert("ERROR", "you Must enter a user name ,email and password...");
        }

    }

    static void userCheck(String s) {
        Alerts Alert2 = new Alerts(); //creating alert
        if (s.contains("notExist")) {
            String insertQuery = "insert into player(playerUsername,playerMail,playerPassword) values(?,?,?)";
            String insertString = "db'".concat(insertQuery + "'").concat(userNameFieldText + "'").concat(emailFieldText + "'").concat(passwordFieldText);
            Client.ps.println(insertString);

        } else if (s.contains(userNameFieldText)) {
            System.out.println("User:   " + userNameFieldText + " already exists ^_^ ");
            //Alert part:
            Alert2.ErrorAlert("ERROR", "User name: " + userNameFieldText + " already exists,Please choose another user name");

        } else if (s.contains("ienserted")) {
            System.out.println("Player inserted into the Database successfully ^_^ ");
            //Alert part:
            Alert2.InformationAlert("You are added", "" + userNameFieldText + " Player inserted into the Database successfully." + "\n" + "Now Please sign in and enjoy playing ^_^");
        } else if (s.contains("mailExists")){
            //Alert part:
            Alert2.ErrorAlert("ERROR", "Email you entered already exists");
        }
    }

}

