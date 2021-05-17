package sample.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


import javafx.geometry.Insets;

import javafx.scene.control.*;

import javafx.scene.image.Image;


import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;


import sample.middleware.ConvertData;
import sample.module.Player;

import java.io.IOException;
import java.net.URL;

import java.util.ArrayList;
import java.util.ResourceBundle;

public class PlayerController implements Initializable {
    //middleware
    private ConvertData convertData = new ConvertData();
    //
    private ArrayList<Player> players = new ArrayList<>();
    private SceneController sceneController = new SceneController();
    private ObservableList<Image> images = fetchImages();

    @FXML
    private TextField playerName;

    @FXML
    private ComboBox<Image> color;
    @FXML
    private ComboBox<String> playerduo;
    @FXML
    private StackPane layout;

    private String[] player = {"Player 1", "Player 2", "Player 3", "Player 4"};

    public PlayerController() throws IOException {
    }


    public void checkPlayer(ActionEvent event) {

    }

    public void submitPlayer(ActionEvent event) {

        try {
            players.add(new Player(playerName.getText(), color.getValue(), 0, convertData.convertTurn(playerduo.getValue()), -1, -1));
            sceneController.switchToScene2(event);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private ComboBox<Image> createComboBox(ObservableList<Image> data) {
        ComboBox<Image> combo = new ComboBox<>();
        combo.getItems().addAll(data);
        combo.setButtonCell(new ImageListCell());
        combo.setCellFactory(listView -> new ImageListCell());
        combo.getSelectionModel().select(0);
        return combo;
    }

    class ImageListCell extends ListCell<Image> {
        private final ImageView view;

        ImageListCell() {
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            view = new ImageView();
        }

        @Override
        protected void updateItem(Image item, boolean empty) {
            super.updateItem(item, empty);

            if (item == null || empty) {
                setGraphic(null);
            } else {
                view.setImage(item);
                setGraphic(view);
            }
        }

    }

    private ObservableList<Image> fetchImages() {
        final ObservableList<Image> data = FXCollections.observableArrayList();
        for (int i = 1; i < 5; i++) {

            data.add(new Image("./resources/images/PLAYER/player" + i + ".png"));
        }
        return data;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //comboBox for Color
        color = createComboBox(images);
        layout = new StackPane(color);
        layout.setPadding(new Insets(20));
        sceneController.root3.getChildren().add(layout);
//        color.getItems().addAll(images);
        //playerTurn

        playerduo.getItems().addAll(player);

        //fetchData for BoxAndPlayerScene
        BoxAndPlayerController boxAndPlayerController = new BoxAndPlayerController();
        boxAndPlayerController.getPlayer(players);
    }


    public void switchToSceneBoxAndPlayer(ActionEvent event) throws IOException {
        sceneController.switchToScene2(event);
    }
}


