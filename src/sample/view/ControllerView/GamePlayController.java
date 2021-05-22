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

    //GameLogic
    GameLogic gameLogic;
    //data Field
    BoardGame boardGame;
    Team team;

    //FXML connect
    @FXML
    Pane playGame;
    @FXML
    Pane endGame;
    //panePlayGame
    @FXML
    Button nextStageBtn;
    @FXML
    Button nextPlayerBtn;
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
        team = new Team(map.getColumnCount());
        gameLogic = new GameLogic(boardGame, team.getPlayers(), 1, 1);
        updatePlayersName(team);
//        if(!gameLogic.isWin()) {
//            if (gameLogic.isValidMove()) {
////                gameLogic.nextStage();
////                gameLogic.addPoint(20);
//                updateViews();
//            } else {
////                gameLogic.nextPlayer();
////                gameLogic.setCurrentStage(1);
//                updateViews();
//            }
//        }
//        else{
//            winnerView();
//        }
        updateViews();
        nextStageBtn.setOnAction(event -> nextStage());
        nextPlayerBtn.setOnAction(event -> nextPlayer());
//            updatePlayerData(team, gameLogic);

    }
    public void updateViews(){
        initPlayers(team.getPlayers());
        initMap(boardGame.getBoard(), gameLogic);
        startGame(gameLogic);
    }
    public void winnerView(){
        playGame.setVisible(false);
        endGame.setVisible(true);
    }
    public void resetView(){

    }

    public void displayPlayerName(String[] playersName) {
        p1name.setText(playersName[0]);
        p2name.setText(playersName[1]);
        p3name.setText(playersName[2]);
        p4name.setText(playersName[3]);
    }

    public void initMap(BOX[][] mapI, GameLogic gameLogic) {
        try {

            for (int i = 0; i < mapI.length; i++) {

                map.add(mapI[i][gameLogic.getCurrentStage() - 1], i, gameLogic.getCurrentStage() - 1, 1, 1);
                mapI[i][gameLogic.getCurrentStage() - 1].getChildren().add(mapI[i][gameLogic.getCurrentStage() - 1].getBoxImage());

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

    public void updatePlayersName(Team teamI) {
        teamI.getPlayers()[0].setPlayerName(p1name.getText());
        teamI.getPlayers()[1].setPlayerName(p2name.getText());
        teamI.getPlayers()[2].setPlayerName(p3name.getText());
        teamI.getPlayers()[3].setPlayerName(p4name.getText());
    }


    public void startGame(GameLogic gameLogicI) {
        //stage
        switch (gameLogicI.getCurrentStage()) {
            case 1:
                stage1.setVisible(true);
                stage5.setVisible(false);
                break;
            case 2:
                stage2.setVisible(true);
                stage1.setVisible(false);
                break;
            case 3:
                stage3.setVisible(true);
                stage2.setVisible(false);
                break;
            case 4:
                stage4.setVisible(true);
                stage3.setVisible(false);
                break;
            case 5:
                stage5.setVisible(true);
                stage4.setVisible(false);
                break;
        }
        //turn
        switch (gameLogic.getCurrentIndex()) {
            case 1:
                p1Pane.setDisable(false);
                p4Pane.setDisable(true);
                break;
            case 2:
                p2Pane.setDisable(false);
                p1Pane.setDisable(true);
                break;
            case 3:
                p3Pane.setDisable(false);
                p2Pane.setDisable(true);
                break;
            case 4:
                p4Pane.setDisable(false);
                p3Pane.setDisable(true);
                break;
        }
    }

    public void nextStage() {
        gameLogic.nextStage();
        updateViews();
    }
    public void nextPlayer(){
        gameLogic.nextPlayer();
        updateViews();
    }
    public void updatePlayerData(Team teamI, GameLogic gameLogicI) {
        teamI.getPlayers()[gameLogicI.getCurrentIndex()] = gameLogic.getCurrentPlayer();
    }

    public void switchToMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/view/menu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
