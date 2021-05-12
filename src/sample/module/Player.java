package sample.module;

import java.util.UUID;

public class Player {
    private String playerName;
    private UUID playerID;
    private String playerColor;
    private int point;
    private int turn;

    public Player(String name,  String colorP, int p, int t) {
        playerColor = colorP;
        playerID = UUID.randomUUID();
        playerName = name;
        point = p;
        turn = t;
    }

    public Player() {
        this("",  "", 0,0);
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerID() {
        return playerID.toString();
    }

    public String getPlayerColor() {
        return playerColor;
    }

    public int getPoint() {
        return point;
    }
    public int getTurn(){
        return turn;
    }
    public void setPlayerName(String name) {
        playerName = name;
    }

    public void setPlayerID(UUID id) {
        playerID = id;
    }

    public void setPlayerColor(String colorP) {
        playerColor = colorP;
    }
    public void setPoint(int p){
        point = p;
    }
    public void setTurn (int t){
        turn = t;
    }
    public void addPoint (int p){
        point += p;
    }

}