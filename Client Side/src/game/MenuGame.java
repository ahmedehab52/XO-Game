package game;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.logging.Logger;

import game.buttonsBase;
import java.util.logging.Level;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;

/**
 *
 * @author lenovo
 */
public class MenuGame extends Application {

    static beginBase intialPage;
    static MenuBase startPane;
    static buttonsBase selectmodepane;
    static howBase howPlayPane;
    static aboutBase aboutPane;
    static MultiPlayer multiPlayerPane;
    static buttonsBase selectmodePane;
    static SinglePlayer singlePlayerPane;
    static Parent myroot;
    //static public Client client;
    static public YouWin youWin;
    static public YouWinSingle youWinSingle;
    static Pane root;
    static loseBase lose;
    static loseBaseSingle loseSingle;
    static winBase bigWin;
    static winBaseSingle bigWinSingle;
    static PlayerRecord record;
    static GameTableBase recordTable;
    public MenuGame() {
        recordTable = new GameTableBase();
        record = new PlayerRecord();
        intialPage = new beginBase();
        youWinSingle = new YouWinSingle();
        bigWinSingle = new winBaseSingle();
        loseSingle = new loseBaseSingle();

        lose = new loseBase();
        //  client = new Client();
        multiPlayerPane = new MultiPlayer();
        startPane = new MenuBase();
        selectmodepane = new buttonsBase();
        howPlayPane = new howBase();
        aboutPane = new aboutBase();
        selectmodePane = new buttonsBase();
        singlePlayerPane = new SinglePlayer();
        youWin = new YouWin();
        bigWin = new winBase();

        try {
            myroot = FXMLLoader.load(getClass().getResource("Main.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MenuGame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void viewPane(Node pane) {
        recordTable.setVisible(false);
        record.setVisible(false);
        intialPage.setVisible(false);
        bigWinSingle.setVisible(false);
        youWinSingle.setVisible(false);
        loseSingle.setVisible(false);

        youWin.setVisible(false);
        bigWin.setVisible(false);
        startPane.setVisible(false);

        //selectMoodPane.setVisible(false);
        selectmodepane.setVisible(false);
        howPlayPane.setVisible(false);
        aboutPane.setVisible(false);
        selectmodePane.setVisible(false);
        singlePlayerPane.setVisible(false);
        multiPlayerPane.setVisible(false);
        myroot.setVisible(false);
        lose.setVisible(false);
        pane.setVisible(true);
    }

    @Override
    public void start(Stage stage) throws IOException {

        root = new Pane();
      
        root.getChildren().add(recordTable);
        root.getChildren().add(record);
        root.getChildren().add(intialPage);
        root.getChildren().add(loseSingle);
        root.getChildren().add(youWinSingle);
        root.getChildren().add(bigWinSingle);

        root.getChildren().add(bigWin);
        root.getChildren().add(youWin);
        root.getChildren().add(lose);
        root.getChildren().add(myroot);
        root.getChildren().add(startPane);
        root.getChildren().add(selectmodepane);
        root.getChildren().add(howPlayPane);
        root.getChildren().add(aboutPane);

        root.getChildren().add(selectmodePane);
        root.getChildren().add(singlePlayerPane);
        root.getChildren().add(multiPlayerPane);
        viewPane(intialPage);
        Scene scene = new Scene(root, 806, 590);

        scene.setFill(Color.TRANSPARENT);

        String css = this.getClass().getResource("menu.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.initStyle(StageStyle.UTILITY);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void stop() {
        System.out.println("Stage is closing");
        //player not connected to game
        String updateState = "update player set playerState = 'disconnected' where playerUsername= " + "'" + SignInController.userNameFieldText + "' and playerPassword = " + "'" + SignInController.passwordFieldText + "' ";
        String updateString = "db.".concat(updateState);
        Client.ps.println(updateString);
        //change player status to not playing
        String updateState2 = "update player set playerStatus = 'idle' where playerUsername= " + "'" + SignInController.userNameFieldText + "' and playerPassword = " + "'" + SignInController.passwordFieldText + "' ";
        String updateString2 = "db.".concat(updateState2);
        Client.ps.println(updateString2);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
