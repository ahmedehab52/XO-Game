package game;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class GameTableBase extends TableView {

    TableColumn columnName;
    TableColumn columnId;
    TableColumn columnMoves;
    TableColumn columnGameTimeEnded;
    TableColumn columnplayerId1;
    TableColumn columnplayerId2;
    ObservableList<MyGame> data;
    TableViewSelectionModel<MyGame> selectionModel;
    // TableRow<MyGame> row;

    public GameTableBase() {
        columnId = new TableColumn("gameId");
        columnName = new TableColumn("gameName");
        columnMoves = new TableColumn("moves");
        columnGameTimeEnded = new TableColumn("GameTimeEnded");
        columnplayerId1 = new TableColumn("playerId1");
        columnplayerId2 = new TableColumn("playerId2");
        getColumns().addAll(columnId, columnName, columnGameTimeEnded, columnMoves, columnplayerId1, columnplayerId2);
        data = FXCollections.observableArrayList();
        setItems(data);

        columnId.setCellValueFactory(new PropertyValueFactory<>("gameId"));

        columnName.setCellValueFactory(new PropertyValueFactory<>("gameName"));
        columnGameTimeEnded.setCellValueFactory(new PropertyValueFactory<>("GameTimeEnded"));

        columnplayerId1.setCellValueFactory(new PropertyValueFactory<>("playerId1"));
        columnplayerId2.setCellValueFactory(new PropertyValueFactory<>("playerId2"));

        columnMoves.setCellValueFactory(new PropertyValueFactory<>("moves"));

        setPrefSize(880, 580);

        columnId.setPrefWidth(144);
        columnName.setPrefWidth(144);
        columnGameTimeEnded.setPrefWidth(150);
        columnName.setPrefWidth(144);
        columnplayerId1.setPrefWidth(144);
        columnplayerId2.setPrefWidth(150);
        columnMoves.setPrefWidth(150);

        setTranslateX(10);
        setTranslateY(10);

        setRowFactory(tv -> {
            TableRow<MyGame> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY
                        && event.getClickCount() == 2) {

                    MyGame clickedRow = row.getItem();
                    String s = "db.replay.select * FROM game WHERE gameId=" + clickedRow.getGameId();
                    Client.ps.println(s);
                }
            });
            return row;
        });
        selectionModel = getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
    }

    void buildGameTable(String s) {
        String[] arrOfStr = s.split("\\;");
        String[] arrOfRaw;

        for (String raw : arrOfStr) {
            if (raw.equals("GameTable")) {
                continue;
            } else {
                arrOfRaw = raw.split("\\,");
                data.add(new MyGame(arrOfRaw[0], arrOfRaw[1], arrOfRaw[2], arrOfRaw[3], arrOfRaw[4], arrOfRaw[5]));

            }
        }

    }
}
