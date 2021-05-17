package sample.module;


import java.util.Random;
import java.util.UUID;

public class BoardGame {
    private int COLS;
    private int ROWS;
    private String boardName;
    private UUID boardID;
    private boolean boardStatus;
    protected BOX[][] boxes;


    public BoardGame(int col, int row, String bName, boolean boardBool) {
        COLS = col;
        ROWS = row;
        boardName = bName;
        boardStatus = boardBool;
        boardID = UUID.randomUUID();
    }

    public BoardGame() {
        this(0, 0, "", false);
    }

    public int getCOLS() {
        return COLS;
    }

    public int getROWS() {
        return ROWS;
    }

    public String getBoardName() {
        return boardName;
    }

    public boolean getBoardStatus() {
        return boardStatus;
    }

    public void setCOLS(int col) {
        COLS = col;
    }

    public void setROWS(int row) {
        ROWS = row;
    }

    public void setBoardName(String bName) {
        boardName = bName;
    }

    public boolean initBoard() {
        try {
            boxes = new BOX[COLS][ROWS];
            Random random = new Random();
            int iBox = random.nextInt(4) + 1;
            for (int i = 0; i < boxes.length; i++) {
                for (int j = 0; j < boxes[j].length; j++) {
                    boxes[i][j] = new BOX("box"+iBox+".png", false);

                }
            }
            boardStatus = true;
            //dang viet do 11:16 09/05/2021
        } catch (Exception e) {
            boardStatus = false;
        }
        return boardStatus;
    }

    public BOX[][] getBoard() {
        return boxes;
    }

    public boolean clearBoard() {
        boardStatus = false;
        return false;
    }

    public boolean fillBoard(int col, int row) {
        COLS = col;
        ROWS = row;
        try {
            boxes = new BOX[COLS][ROWS];
            Random random = new Random();
            int iBox = random.nextInt(4) + 1;
            for (int i = 0; i < boxes.length; i++) {
                for (int j = 0; j < boxes[j].length; j++) {
                    boxes[i][j] = new BOX("box%s".formatted(iBox), false);
                }
            }
            boardStatus = true;
            //dang viet do 11:16 09/05/2021
        } catch (Exception e) {
            boardStatus = false;
        }
        return boardStatus;
    }

    public void editBoard(int x, int y, String boxID, int xAlt, int yAlt) {
        for (int i = 0; i < boxes.length; i++) {
            for (int j = 0; j < boxes[i].length; j++) {
                if (boxes[i][j].getBoxID().equals(boxID)) {
                    BOX temp = boxes[x][y];
                    boxes[x][y] = boxes[xAlt][yAlt];
                    boxes[xAlt][yAlt] = temp;
                }
            }
        }
    }

    public String getBoardID() {
        return boardID.toString();
    }
}
