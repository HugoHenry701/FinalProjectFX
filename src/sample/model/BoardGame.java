package sample.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BoardGame {
    private boolean boardStatus;
    private BOX[][] boxes;


    public BoardGame(int col, int row, boolean boardBool) {
        boardStatus = boardBool;
        boxes = new BOX[col][row];
        for (int i = 0; i < boxes.length; i++) {
            ArrayList<Integer> iBox = new ArrayList<>();
            iBox.add(Integer.valueOf(i));
            Collections.shuffle(iBox);
            for (int j = 0; j < boxes[i].length; j++) {

                boxes[i][j] = new BOX("box" + iBox.get(i) + ".png", false);
            }
        }
    }



//    public int getCOLS() {
//        return COLS;
//    }

//    public int getROWS() {
//        return ROWS;
//    }

//    public String getBoardName() {
//        return boardName;
//    }

    public boolean getBoardStatus() {
        return boardStatus;
    }
//
//    public void setCOLS(int col) {
//        COLS = col;
//    }

//    public void setROWS(int row) {
//        ROWS = row;
//    }

//    public void setBoardName(String bName) {
//        boardName = bName;
//    }

    public BOX[][] getBoard() {
        return boxes;
    }


//    public boolean fillBoard(int col, int row) {
//        COLS = col;
//        ROWS = row;
//        try {
//            boxes = new BOX[COLS][ROWS];
//            Random random = new Random();
//            int iBox = random.nextInt(4) + 1;
//            for (int i = 0; i < boxes.length; i++) {
//                for (int j = 0; j < boxes[j].length; j++) {
//                    boxes[i][j] = new BOX("box%s".formatted(iBox), false);
//                }
//            }
//            boardStatus = true;
//            //dang viet do 11:16 09/05/2021
//        } catch (Exception e) {
//            boardStatus = false;
//        }
//        return boardStatus;
//    }

//    public void editBoard(int x, int y, String boxID, int xAlt, int yAlt) {
//        for (int i = 0; i < boxes.length; i++) {
//            for (int j = 0; j < boxes[i].length; j++) {
//                if (boxes[i][j].getBoxID().equals(boxID)) {
//                    BOX temp = boxes[x][y];
//                    boxes[x][y] = boxes[xAlt][yAlt];
//                    boxes[xAlt][yAlt] = temp;
//                }
//            }
//        }
//    }

//    public String getBoardID() {
//        return boardID.toString();
//    }
}
