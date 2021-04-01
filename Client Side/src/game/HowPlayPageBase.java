package game;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public  class HowPlayPageBase extends AnchorPane {

    protected final Label label;

    public HowPlayPageBase() {

        label = new Label();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        label.setLayoutX(107.0);
        label.setLayoutY(147.0);
        label.setPrefHeight(106.0);
        label.setPrefWidth(431.0);
        label.setText("How To Play page");
        label.setFont(new Font(46.0));

        getChildren().add(label);

    }
}
