package sample.model;


public class GameLogic {
    private BoardGame boardGame;
    private Player[] players;
    private Player currentPlayer;
    private int currentIndex;
    private int currentStage;

    public GameLogic(BoardGame boardGame1, Player[] players1, int currentI, int currentStageI) {
        boardGame = boardGame1;
        players = players1;
        currentIndex = currentI;
        currentPlayer = players1[currentIndex];
        currentStage = currentStageI;
    }

    public boolean isValidMove() {
        boolean valid;
        if (currentPlayer.getPlayerImage() == boardGame.getBoard()[boardGame.getColIndex()][boardGame.getRowIndex()].getBox()) {
            currentPlayer.addPoint(20);
            currentStage++;
            valid = true;
        } else {
            currentIndex++;
            currentStage = 1;
            valid = false;
        }
        return valid;
    }

    public boolean isWin() {
        boolean winCheck;
        if ((currentStage == 4) && (currentPlayer.getPlayerImage() == boardGame.getBoard()[boardGame.getColIndex()][boardGame.getRowIndex()].getBox())) {
            currentPlayer.addPoint(100);
            winCheck = true;
        } else {
            winCheck = false;
        }
        return winCheck;
    }

    //set
    public void nextPlayer() {
        if (currentIndex < 4) {
            currentIndex++;
        } else {
            currentIndex = 1;
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


}