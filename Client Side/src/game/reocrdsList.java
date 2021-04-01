package game;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public  class reocrdsList extends TableView {
    private static final  ObservableList<Game> data = FXCollections.observableArrayList(new Game(1,"ab","20/10/2013","1.x.o",2,5));
    protected final TableColumn tableColumn;
    protected final TableColumn tableColumn0;
    protected final TableColumn tableColumn1;
    protected final TableColumn tableColumn2;
    protected final TableColumn tableColumn3;
    protected final TableColumn tableColumn4;

    public reocrdsList() {

        tableColumn = new TableColumn();
        tableColumn0 = new TableColumn();
        tableColumn1 = new TableColumn();
        tableColumn2 = new TableColumn();
        tableColumn3 = new TableColumn();
        tableColumn4 = new TableColumn();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(580.0);
        setPrefWidth(800.0);

        tableColumn.setPrefWidth(52.0);
        tableColumn.setText("game Id");

        tableColumn0.setPrefWidth(98.0);
        tableColumn0.setText("game Name");

        tableColumn1.setPrefWidth(70.0);
        tableColumn1.setText("game Time");

        tableColumn2.setPrefWidth(410.0);
        tableColumn2.setText("Movement");

        tableColumn3.setMinWidth(0.0);
        tableColumn3.setPrefWidth(70.0);
        tableColumn3.setText("Player1 Id");

        tableColumn4.setPrefWidth(99.0);
        tableColumn4.setText("Player2 Id");
       
        setEditable(true);
        setItems(data);
        getColumns().add(tableColumn);
        getColumns().add(tableColumn0);
        getColumns().add(tableColumn1);
        getColumns().add(tableColumn2);
        getColumns().add(tableColumn3);
        getColumns().add(tableColumn4);

    }
}
class Game{
   Game(int id,String name,String date,String Movement,int ply1id,int ply2id){}
}