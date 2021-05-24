package sample.controller;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.image.ImageView;


import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import javafx.stage.Stage;


import javafx.util.Duration;
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
    //test Btn
//    @FXML
//    Button nextStageBtn;
//    @FXML
//    Button nextPlayerBtn;
//    @FXML
//    Button closeAllBtn;
    //panePlayGame

    @FXML
    ImageView arrowP1;
    @FXML
    ImageView arrowP2;
    @FXML
    ImageView arrowP3;
    @FXML
    ImageView arrowP4;
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


    @FXML
    public void init() {

    }

    //Override
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        boardGame = new BoardGame(map.getColumnCount(), map.getRowCount(), true);
        team = new Team(map.getColumnCount());
        gameLogic = new GameLogic(boardGame, team, 0, 1, "playGame");

        updateViews();

//        if(gameLogic.getGameStatus() == "endGame"){
//            endView();
//            System.out.println("endgame");
//        }else if(gameLogic.getGameStatus() == "playGame"){
//            System.out.println("playgame");
//            if (boardGame.getClickedBox(gameLogic.getCurrentStage())){
//                System.out.println("clicked");
//                if(gameLogic.getValidMove()){
//                    updateViews();
//                    System.out.println("valid");
//                }
//                else {
//                    resetView();
//                    System.out.println("invalid");
//                }
//            }else {
//                updateViews();
//                System.out.println("not Clicked");
//            }
//
//        }

//        nextStageBtn.setOnAction(event -> nextStage());
//        nextPlayerBtn.setOnAction(event -> nextPlayer());
//        closeAllBtn.setOnAction(event -> boardGame.closeAllBox());
//            updatePlayerData(team, gameLogic);

    }

    public void updateViews() {
        initPlayers(team.getPlayers());
        initMap(boardGame.getBoard(), gameLogic);
        startGame(gameLogic);
    }
    public void updateViewsStage1(){
        initPlayers(team.getPlayers());
        startGame(gameLogic);
        initMapForStage1(boardGame.getBoard(),gameLogic);
    }


    public void resetView() {
        if (map.getChildren().removeAll()) {

        }
    }

    public void endView() {
        playGame.setVisible(false);
        endGame.setVisible(true);
        winPlayer.setText(gameLogic.getCurrentPlayer().getPlayerName());
    }

    public void displayPlayerName(String[] playersNametemp) {
        p1name.setText(playersNametemp[0]);
        p2name.setText(playersNametemp[1]);
        p3name.setText(playersNametemp[2]);
        p4name.setText(playersNametemp[3]);

    }

    public void initMap(BOX[][] mapI, GameLogic gameLogic) {
        try {
//            if (gameLogic.getCurrentIndex() != 0) {

//                List<BOX> addTo = new ArrayList<>();
//                map.getChildren().clear();
//                map = new GridPane();
//                for (int i = 0; i < mapI.length; i++) {
//                    BOX boxTarget = mapI[i][gameLogic.getCurrentStage() - 1];
////                    boxTarget.getChildren().add(boxTarget.getBoxImage());
//                    boxTarget.setOnMouseClicked(event -> checkMove(gameLogic, boxTarget.getBoxImage(), boxTarget));
//                    addTo.add(boxTarget);
//                    GridPane.setColumnIndex(boxTarget, i);
//                    GridPane.setRowIndex(boxTarget, gameLogic.getCurrentStage() - 1);
//                }
//                map.getChildren().setAll(addTo);
//                map.setGridLinesVisible(true);
//                for (int i = 0; i < mapI.length; i++) {
//                    Node node = mapI[i][gameLogic.getCurrentStage()-1].getBoxImage();
//                    map.add(node,i,gameLogic.getCurrentStage()-1,1,1);
//                }
//                map = new GridPane();
//                for (int i = 0; i < mapI.length; i++) {
//                    BOX currentBox = mapI[i][gameLogic.getCurrentStage() - 1];
////                    currentBox.getChildren().add(currentBox.getBoxImage());
//                    currentBox.setOnMouseClicked(event -> checkMove(gameLogic, currentBox.getBoxImage(), currentBox));
//                    map.add(currentBox, i, gameLogic.getCurrentStage() - 1, 1, 1);
//
//                }
//            } else {
            for (int i = 0; i < mapI.length; i++) {
                BOX currentBox = mapI[i][gameLogic.getCurrentStage() - 1];
//                    currentBox.getChildren().add(currentBox.getBoxImage());
                currentBox.setOnMouseClicked(event -> checkMove(gameLogic, currentBox.getBoxImage(), currentBox));
                map.add(currentBox, i, gameLogic.getCurrentStage() - 1, 1, 1);
            }
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void initMapForStage1(BOX[][] mapI, GameLogic gameLogic){
        for (int i = 0; i < mapI.length; i++) {
            BOX currentBox = mapI[i][gameLogic.getCurrentStage() -1];

            //                   currentBox.getChildren().add(currentBox.getBoxImage());
            currentBox.setOnMouseClicked(event -> checkMove(gameLogic, currentBox.getBoxImage(), currentBox));
            map.add(currentBox, i, gameLogic.getCurrentStage() - 1, 1, 1);
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


    public void startGame(GameLogic gameLogicI) {
        //stage
        switch (gameLogicI.getCurrentStage()) {
            case 1:
                stage1.setVisible(true);
                stage2.setVisible(false);
                stage3.setVisible(false);
                stage4.setVisible(false);
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
        switch (gameLogic.getCurrentIndex() + 1) {
            case 1:
                p1Pane.setDisable(false);
                arrowP1.setVisible(true);
                p4Pane.setDisable(true);
                arrowP4.setVisible(false);
                break;
            case 2:
                p2Pane.setDisable(false);
                arrowP2.setVisible(true);
                p1Pane.setDisable(true);
                arrowP1.setVisible(false);
                break;
            case 3:
                p3Pane.setDisable(false);
                arrowP3.setVisible(true);
                p2Pane.setDisable(true);
                arrowP2.setVisible(false);
                break;
            case 4:
                p4Pane.setDisable(false);
                arrowP4.setVisible(true);
                p3Pane.setDisable(true);
                arrowP3.setVisible(false);
                break;
        }
    }

    public void nextStage() {
        gameLogic.nextStage();
        boardGame.setDisableBoxInStage(gameLogic.getCurrentStage() - 1);
        updateViews();
    }

    public void nextPlayer() {
        boardGame.closeAllBox();
        gameLogic.nextPlayer();
        gameLogic.setCurrentStage(1);
        map.getChildren().retainAll(map.getChildren().get(0));
//        map.getChildren().removeAll(map.getChildren());
        updateViews();
    }
    public void nextPlayerStage1(){
        boardGame.closeBoxInStage(gameLogic.getCurrentStage());
        gameLogic.nextPlayer();
        map.getChildren().retainAll(map.getChildren().get(0));
//        map.getChildren().removeAll(map.getChildren());
//        map.getChildren().get(0)
//        map.getChildren().clear();
//        updateViews();
        updateViewsStage1();
        System.out.println("nextPlayerStage1");
    }



    public void checkMove(GameLogic gameLogicI, ImageView boxImage, BOX boxI) {
        FadeTransition ft = new FadeTransition(Duration.seconds(1), boxImage);
        ft.setToValue(1);
        ft.playFrom(Duration.seconds(0.9));
        System.out.println("Row" + GridPane.getRowIndex(boxI));
        System.out.println("Col" + GridPane.getColumnIndex(boxI));
//        System.out.println("box: "+boxI.getColor());
//        System.out.println("player: "+team.getPlayers()[gameLogicI.getCurrentIndex()].getplayerUrl());
//        rowIndex = GridPane.getRowIndex(this);
        int colIndex = GridPane.getColumnIndex(boxI);
        if (gameLogicI.isWin(colIndex)) {
            updatePlayersName();
            team.getPlayers()[gameLogicI.getCurrentIndex()].addPoint(100);
            playGame.setVisible(false);
            endGame.setVisible(true);
            winPlayer.setText(team.getPlayers()[gameLogicI.getCurrentIndex()].getPlayerName());
//            System.out.println(team.getPlayers()[gameLogicI.getCurrentIndex()].getPlayerName());
            winTable.getColumns().clear();
            turnCol.setCellValueFactory(new PropertyValueFactory<>("turn"));
            playerNameCol.setCellValueFactory(new PropertyValueFactory<>("playerName"));
            colorCol.setCellValueFactory(new PropertyValueFactory<>("playerColor"));
            totalPointCol.setCellValueFactory(new PropertyValueFactory<>("point"));
            winTable.getColumns().add(turnCol);
            winTable.getColumns().add(playerNameCol);
            winTable.getColumns().add(colorCol);
            winTable.getColumns().add(totalPointCol);
            winTable.getItems().addAll(team.getPlayers());
        } else {
            if (gameLogicI.isValidMove(colIndex)) {
//            updateViews();
                team.getPlayers()[gameLogicI.getCurrentIndex()].addPoint(20);
                initPlayers(team.getPlayers());
                System.out.println("valid");
                nextStage();
            } else {
//            updateViews();
                System.out.println("invalid");
                if (gameLogic.getCurrentStage() == 1) {
                    boardGame.closeAllBox();
                    nextPlayerStage1();
                    System.out.println("stage1");
                } else {
                    nextPlayer();
                    System.out.println("stageN");
                }
            }
        }
    }

    public void switchToMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/view/menu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
