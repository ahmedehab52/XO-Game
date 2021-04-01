/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servertry2;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author lenovo
 */
public class ServerPage extends Application {
    static serverpageBase intialPage;
    static ServerRun serverrunPane;
    
    public ServerPage(){
        intialPage = new serverpageBase();
        serverrunPane = new ServerRun();
    }
    
    static void viewPane(Pane p){
        intialPage.setVisible(false);
        serverrunPane.setVisible(false);
        p.setVisible(true);
    }
    
    @Override
    public void start(Stage primaryStage) {

        Pane root = new Pane();
        root.getChildren().add(intialPage);
        root.getChildren().add(serverrunPane);
        root.setId("pane");

       
        Scene scene = new Scene(root, 800, 580);

        String css = this.getClass().getResource("serverpage.css").toExternalForm();
        scene.getStylesheets().add(css);
        root.getStyleClass().add("root");
        viewPane(intialPage);

        //primaryStage.initStyle(StageStyle.TRANSPARENT);

        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
