package game;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;


/**
 *
 * @author Aya
 */
public class MainController implements Initializable {

    @FXML
     public VBox vbox;
     private Parent fxml;
     
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
        
         TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbox);
         t.setToX(vbox.getLayoutX() * 5);
         t.play();
         t.setOnFinished((e) ->{
             try {
                 fxml = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
                 vbox.getChildren().removeAll();
                 vbox.getChildren().setAll(fxml);
             } catch (IOException ex) {
                 Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
             }
        
        });    
        
        
    }    

    @FXML
    private void open_signup(ActionEvent event) {
      TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbox);
        t.setToX(1);
        t.play();
        t.setOnFinished((e) -> {
            try {
                fxml = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });      
        
    }

    @FXML
    public void open_signin(ActionEvent event) {
        
        TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbox);
        t.setToX(vbox.getLayoutX() * 5);
        t.play();
        t.setOnFinished((e) -> {
            try {
                fxml = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        
    }
    
}
