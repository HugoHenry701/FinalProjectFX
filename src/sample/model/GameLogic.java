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

    public boolean isValidMove(int rowIndex, int colIndex) {
        boolean valid;
        if (currentPlayer.getPlayerImage() == boardGame.getBoard()[colIndex][rowIndex].getBox()) {
            currentPlayer.addPoint(30);
            currentStage++;
            valid = true;
        } else {
            currentIndex++;
            currentStage = 0;
            valid = false;
        }
        return valid;
    }

    public boolean isWin(int playerChoice) {
        boolean winCheck;
        if ((currentStage == 4) && (currentPlayer.getPlayerImage() == boardGame.getBoard()[currentStage][playerChoice].getBox())) {
            currentPlayer.addPoint(100);
            winCheck = true;
        } else {
            winCheck = false;
        }
        return winCheck;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    public int getCurrentIndex(){
        return currentIndex;
    }
    public int getCurrentStage(){
        return currentStage;
    }
}
