package sample.view.ControllerView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import sample.model.BOX;
import sample.model.BoardGame;
import sample.model.Player;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class gamePlayController implements Initializable {
    private SceneController sceneController = new SceneController();
    //data Field
    BoardGame boardGame;
    //FXML connect
    @FXML
    Pane playGame;
    @FXML
    Pane endGame;
    //panePlayGame
    @FXML
    GridPane map;
    @FXML
    GridPane turnPane;
    @FXML
    ImageView p1turn;
    @FXML
    TextField p1name;
    @FXML
    TextField p1totalP;
    @FXML
    ImageView p2turn;
    @FXML
    TextField p2name;
    @FXML
    TextField p2totalP;
    @FXML
    ImageView p3turn;
    @FXML
    TextField p3name;
    @FXML
    TextField p3totalP;
    @FXML
    ImageView p4turn;
    @FXML
    TextField p4name;
    @FXML
    TextField p4totalP;
    //paneEndGame
    @FXML
    Label winPlayer;
    @FXML
    TableView winTable;
    @FXML
    TableColumn<Player, Integer> turnCol;
    @FXML
    TableColumn<Player,String> playerNameCol;
    @FXML
    TableColumn<Player,String> colorCol;
    @FXML
    TableColumn<Player,Integer> totalPointCol;

    //Override
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        boardGame = new BoardGame(map.getColumnCount(), map.getRowCount(),true );
        System.out.println("The game was made.");
        System.out.println(map.getColumnCount());//4
        System.out.println(map.getRowCount());//5
        initMap(boardGame.getBoard());
        System.out.println("The map was made.");
    }

    public void initMap(BOX[][] mapI){
        try{

            for (int i = 0; i < mapI.length ; i++) {
                for (int j = 0; j < mapI[i].length ; j++) {
                    ImageView box = new ImageView(mapI[i][j].getBoxImage());
                    box.setFitHeight(45);
                    box.setFitWidth(45);
                    box.setPreserveRatio(false);
                    map.add(box,i,j,1,1);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void switchToMenu(ActionEvent event) throws IOException {
        sceneController.switchToScene1(event);
    }
}
