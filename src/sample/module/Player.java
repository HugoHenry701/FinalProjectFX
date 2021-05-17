package sample.module;

import javafx.scene.image.Image;

import java.util.UUID;

public class Player {
    private String playerName;
    private UUID playerID;
    private Image playerImage;
    private int point;
    private int turn;
    private int playerX;
    private int playerY;

    public Player(String name,Image playerImageI, int p, int t, int x, int y) {
        playerID = UUID.randomUUID();
        playerName = name;
        playerImage = playerImageI;
        point = p;
        turn = t;
        playerX = x;
        playerY = y;
    }



    //get
    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerID() {
        return playerID.toString();
    }

//    public String getPlayerColor() {
//        return playerColor;
//    }

    public int getPoint() {
        return point;
    }
    public int getTurn(){
        return turn;
    }
    public int getPlayerX(){return playerX;}
    public int getPlayerY(){return playerY;}
    public Image getPlayerImage(){return playerImage;}
    //set
    public void setPlayerName(String name) {
        playerName = name;
    }

    public void setPlayerID(UUID id) {
        playerID = id;
    }

//    public void setPlayerColor(String colorP) {
//        playerColor = colorP;
//    }
    public void setPoint(int p){
        point = p;
    }
    public void setTurn (int t){
        turn = t;
    }
    public void addPoint (int p){
        point += p;
    }
    public void subPoint (int p){
        point -= p;
    }
    public void setPlayerX (int x){playerX = x;}
    public void setPlayerY (int y){playerY = y;}
    public void movePlayer(){playerY++;}
    public void setPlayerImage(Image playerImage1){playerImage = playerImage1;}
}
