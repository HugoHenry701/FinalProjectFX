package sample.view.ControllerView;

import javafx.event.ActionEvent;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.image.ImageView;

import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import javafx.stage.Stage;

import sample.model.*;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

public class GamePlayController implements Initializable {

    //parameter


    //data Field
    BoardGame boardGame;
    Team team;
    GameLogic gameLogic;
    //FXML connect
    @FXML
    Pane playGame;
    @FXML
    Pane endGame;
    //panePlayGame
    @FXML
    Label wrongStatus;
    @FXML
    Label stage1;
    @FXML
    Label stage2;
    @FXML
    Label stage3;
    @FXML
    Label stage4;
    @FXML
    Label stage5;

    @FXML
    Label p1Status;
    @FXML
    Label p2Status;
    @FXML
    Label p3Status;
    @FXML
    Label p4Status;
    @FXML
    GridPane map;
    @FXML
    GridPane turnPane;
    @FXML
    GridPane p1Pane;
    @FXML
    GridPane p2Pane;
    @FXML
    GridPane p3Pane;
    @FXML
    GridPane p4Pane;

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
    //    @FXML
//    TextField[] playersName = {p1name, p2name, p3name, p4name};
//    @FXML
//    TextField[] playersPoint = {p1totalP, p2totalP, p3totalP, p4totalP};
//    @FXML
//    ImageView[] playersColor = {p1turn,p2turn,p3turn,p4turn};
    //paneEndGame
    @FXML
    Label winPlayer;
    @FXML
    TableView winTable;
    @FXML
    TableColumn<Player, Integer> turnCol;
    @FXML
    TableColumn<Player, String> playerNameCol;
    @FXML
    TableColumn<Player, String> colorCol;
    @FXML
    TableColumn<Player, Integer> totalPointCol;


    //Override
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        boardGame = new BoardGame(map.getColumnCount(), map.getRowCount(), true);
        initMap(boardGame.getBoard());
        team = new Team(map.getColumnCount());
        updatePlayersName();
        initPlayers(team.getPlayers());
        gameLogic = new GameLogic(boardGame, team.getPlayers(), 1, 1);

        startGame();

    }


    public void displayPlayerName(String[] playersName) {
        p1name.setText(playersName[0]);
        p2name.setText(playersName[1]);
        p3name.setText(playersName[2]);
        p4name.setText(playersName[3]);
    }

    public void initMap(BOX[][] mapI) {
        try {

            for (int i = 0; i < mapI.length; i++) {
                for (int j = 0; j < mapI[i].length; j++) {
                    map.add(mapI[i][j],i,j,1,1);
                    mapI[i][j].getChildren().add(mapI[i][j].getBoxImage());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initPlayers(Player[] players1) {
        try {
            //image
            p1turn.setImage(players1[0].getPlayerImage());
            p2turn.setImage(players1[1].getPlayerImage());
            p3turn.setImage(players1[2].getPlayerImage());
            p4turn.setImage(players1[3].getPlayerImage());
            //point
            p1totalP.setText("" + players1[0].getPoint());
            p2totalP.setText("" + players1[1].getPoint());
            p3totalP.setText("" + players1[2].getPoint());
            p4totalP.setText("" + players1[3].getPoint());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePlayersName() {
        team.getPlayers()[0].setPlayerName(p1name.getText());
        team.getPlayers()[1].setPlayerName(p2name.getText());
        team.getPlayers()[2].setPlayerName(p3name.getText());
        team.getPlayers()[3].setPlayerName(p4name.getText());
    }


    public void startGame() {
        //stage
        switch (gameLogic.getCurrentStage()){
            case 1: stage1.setVisible(true);
                for (int i = 0; i < map.getColumnCount(); i++) {
                    boardGame.getBoard()[i][gameLogic.getCurrentStage()].getBoxImage().setDisable(false);
                }
                break;
            case 2: stage2.setVisible(true);
                break;
            case 3: stage3.setVisible(true);
                break;
            case 4: stage4.setVisible(true);
                break;
            case 5: stage5.setVisible(true);
                break;
        }
        //turn
        switch (gameLogic.getCurrentIndex()){
            case 1: p1Pane.setDisable(false);break;
            case 2: p2Pane.setDisable(false);break;
            case 3: p3Pane.setDisable(false);break;
            case 4: p4Pane.setDisable(false);break;
        }

        //

    }

    public void switchToMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/view/menu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
