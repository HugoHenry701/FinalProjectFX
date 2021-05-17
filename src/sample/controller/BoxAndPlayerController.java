package sample.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;


import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;


import java.net.URL;

import java.util.ArrayList;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;


import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import sample.module.Player;


public class BoxAndPlayerController implements Initializable {
    private ObservableList<Player> players ;
    @FXML
    private TableView<Player> playerTableView;
    //scene
    private SceneController sceneController = new SceneController();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            //playerNameCol
            TableColumn<Player, String> playerNameCol = new TableColumn<>("playerNameCol");
            playerNameCol.setCellValueFactory(new PropertyValueFactory<>("playerName"));
            //playerColorCol
            TableColumn<Player, Image> playerColorCol = new TableColumn<>("playerColorCol");
            playerColorCol.setCellValueFactory(new PropertyValueFactory<>("playerImage"));

            playerTableView = new TableView<>();
            playerTableView.setItems(players);
            playerTableView.getColumns().addAll(playerNameCol, playerColorCol);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void switchToScenePlayer(ActionEvent event) throws IOException {
        sceneController.switchToScene3(event);
    }

    public void switchToSceneMenu(ActionEvent event) throws IOException {
        sceneController.switchToScene1(event);
    }

    public void getPlayer( ArrayList<Player> playerArrayListList) {
        for (int i = 0; i < playerArrayListList.size(); i++) {
//            players.add(playerArrayListList.get(i));
            players = FXCollections.observableArrayList(playerArrayListList);
        }
    }

}

