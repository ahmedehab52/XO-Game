package game;

import static game.PlayerRecord.recordflag;
import javafx.animation.PauseTransition;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public  class YouWin extends Pane {

     MediaPlayer player ;
     PauseTransition pause;
     
    public YouWin() {
         pause = new PauseTransition(Duration.millis(4000));
         pause.setOnFinished(
                             e -> {
                                   MenuGame.viewPane(MenuGame.bigWin);
                             });
        player = new MediaPlayer( new Media(getClass().getResource("winner.mp4").toExternalForm()));
        MediaView mediaView = new MediaView(player);
     
        mediaView.setFitWidth(800);
        mediaView.setFitHeight(880);
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
      
        getChildren().add(mediaView);
       
       // audioPlayer.play();
    player.setOnEndOfMedia(() -> {
        MenuGame.viewPane(MenuGame.bigWin);
    });
    
    }
}
