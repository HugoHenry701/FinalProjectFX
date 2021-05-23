package sample.model;


import javafx.scene.layout.Pane;

import java.util.Objects;

public class GameLogic {
    private BoardGame boardGame;
    private Team team;
    private Player currentPlayer;
    private int currentIndex;
    private int currentStage;
    private String gameStatus;
    private boolean validMove;

    public GameLogic() {

    }

    public GameLogic(BoardGame boardGame1, Team teamI, int currentI, int currentStageI, String gameStatusI) {
        boardGame = boardGame1;
        team = teamI;
        gameStatus = gameStatusI;
        currentIndex = currentI;
        currentPlayer = team.getPlayers()[getCurrentIndex()];
        currentStage = currentStageI;

    }

    public boolean isValidMove(int colIndex) {
        boolean valid;
        if (team.getPlayers()[currentIndex].getPlayerColor().equals(boardGame.getBoard()[colIndex][currentStage-1].getColor())){
//            currentStage++;
//            currentPlayer.addPoint(20);
//            System.out.println("box:" + boardGame.getBoard()[colIndex][currentStage-1].getColor());
//            System.out.println("player: " + team.getPlayers()[currentIndex].getPlayerColor());
//            System.out.println("valid");
            valid = true;
        } else {
//            if (currentIndex < 4) {
//                currentIndex++;
//            } else {
//                currentIndex = 1;
//            }
//            System.out.println("box:" + boardGame.getBoard()[colIndex][currentStage-1].getColor());
//            System.out.println("player: " + team.getPlayers()[currentIndex].getPlayerColor());
//            System.out.println("invalid");
            valid = false;
        }
        return valid;
    }

    public boolean isWin() {
        boolean winCheck;
        if ((currentStage == 4) && (currentPlayer.getPlayerImage() == boardGame.getBoard()[boardGame.getCurrentBoxColIndex(currentStage)][currentStage].getBox())) {
            currentPlayer.addPoint(100);
            winCheck = true;
        } else {
            winCheck = false;
        }
        return winCheck;
    }

    //set
    public void nextPlayer() {
        if (currentIndex < 3) {
            currentIndex++;
        } else {
            currentIndex = 0;
        }
    }

    public void nextStage() {
        if (currentStage < 5) {
            currentStage++;
        } else {
//            isWin();
        }

    }

    public void setCurrentIndex(int currentIndex1) {
        currentIndex = currentIndex1;
    }

    public void setCurrentStage(int currentStage1) {
        currentStage = currentStage1;
    }

    public void addPoint(int point) {
        currentPlayer.addPoint(point);
    }

    //get
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public int getCurrentStage() {
        return currentStage;
    }

    public String getGameStatus() {
        return gameStatus;
    }

    public boolean getValidMove() {
        return validMove;
    }
}