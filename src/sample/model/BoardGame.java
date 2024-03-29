package sample.model;


import java.util.ArrayList;
import java.util.Collections;


public class BoardGame {
    private boolean boardStatus;
    private BOX[][] boxes;


    public BoardGame(int col, int row, boolean boardBool) {
        boardStatus = boardBool;
        boxes = new BOX[col][row];
        for (int i = 0; i < boxes.length; i++) {
            for (int k = 0; k < boxes[i].length; k++) {
                ArrayList<Integer> iBox = new ArrayList<>();
                for (int g = 0; g < 4; g++) {
                    iBox.add(Integer.valueOf(g));
                }
                Collections.shuffle(iBox);
                for (int j = 0; j < boxes.length; j++) {
                    boxes[j][k] = new BOX("box" + iBox.get(j));
                    boxes[j][k].getChildren().add(boxes[j][k].getBoxImage());
                }
            }
        }

    }

    public int getCurrentBoxColIndex(int currentStage){
        int colIndex = 0;
        for (int i = 0; i < boxes.length; i++) {
            if(boxes[i][currentStage].getBoxStatus()){
                colIndex = boxes[i][currentStage].getColIndex();
            }
        }
        return colIndex;
    }

    public boolean getClickedBox(int currentStage) {
        boolean clicked = false;
        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i][currentStage].isOpen()) {
                clicked = false;
            } else {
                clicked = true;
            }
        }
        return clicked;
    }
    public void closeAllBox(){
        for (int i = 0; i < boxes.length; i++) {
            for (int j = 0; j < boxes[i].length; j++) {
                boxes[i][j].close();
                boxes[i][j].setDisable(false);
            }
        }
    }
    public void closeBoxInStage(int currentStage){
        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i][currentStage].isOpen()){
                boxes[i][currentStage].close();
            }
        }
        System.out.println("closed");
    }
    public void setDisableBoxInStage(int previousStage){
        for (int i = 0; i < boxes.length; i++) {
            boxes[i][previousStage-1].setDisable(true);
        }
    }

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
