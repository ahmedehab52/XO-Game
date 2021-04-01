/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;

/**
 *
 * @author omniahassan
 */
public class Alerts extends Application {

    Alert a;

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    Alerts() {
        a = new Alert(Alert.AlertType.NONE);
    }

    public void InformationAlert(String titlte, String content) {
        a.setAlertType(Alert.AlertType.INFORMATION);
        a.setTitle(titlte);
        a.setHeaderText("");
        a.setContentText(content);
        StyleAlert();
       
       
    }

    public void ErrorAlert(String titlte, String content) {
        a.setAlertType(Alert.AlertType.ERROR);
        a.setTitle(titlte);
        a.setHeaderText("");
        a.setContentText(content);
        StyleAlert();
        
    }

    void StyleAlert() {

        DialogPane dialogPane = a.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("myDialogs.css").toExternalForm());
        dialogPane.getStyleClass().add("myDialog");
        ShowDialog();
         
    }
    
    void ShowDialog(){
        a.show();
    }

}
