package sample.module;


import java.util.Stack;

public class ListGameBoard {
    private Stack<BoardGame> listMap;
    private BoardGame boardGame;
    private boolean listStatus;
    public ListGameBoard(Stack<BoardGame> listMapP, boolean listCheck, BoardGame boardGame1){
        listMap = listMapP;
        listStatus = listCheck;
        boardGame = boardGame1;
    }
    public boolean addMapIntoList(){
        try{
            listMap.push(boardGame);
            listStatus = true;
        }
        catch (Exception e){
            listStatus = false;
        }
        return listStatus;
    }
    public Stack<BoardGame> getListMap(){
        return listMap;
    }
}
