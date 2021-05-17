package sample.module;

import java.util.Stack;

public class GameLogic {
    private Stack<Player> players;
    private BoardGame boardGame;
    private BOX[][] mapGame;

    public GameLogic(Stack<Player> playersI, BoardGame boardGameI) {
        players = playersI;
        boardGame = boardGameI;
        mapGame = boardGame.getBoard();
    }

    public boolean isValidMap() {
        boolean isValidMap;
        if (players.size() == boardGame.getCOLS()) {
            isValidMap = true;
        } else {
            isValidMap = false;
        }
        return isValidMap;
    }

    public boolean isWin(Player playerI) {
        boolean checkWin;
        if (playerI.getPlayerImage() == mapGame[playerI.getPlayerX()][boardGame.getROWS() - 1].getBoxImage()) {
            checkWin = true;
        } else {
            checkWin = false;
        }
        return checkWin;
    }

    public boolean isValidMove(Player playerI) {
        boolean checkMove = false;
        for (int i = 0; i < mapGame.length; i++) {
            for (int j = 0; j < mapGame[i].length; j++) {
                if (playerI.getPlayerImage() == mapGame[i][j].getBoxImage()) {
                    checkMove = true;
                    playerI.addPoint(10);
                } else {
                    checkMove = false;
                    playerI.subPoint(30);
                    playerI.setPlayerY(-1);
                }
            }
        }
        return checkMove;
    }

    public void setPlayersPosition() {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).setPlayerX(players.get(i).getTurn() - 1);
            players.get(i).setPlayerY(-1);
        }
    }


}
