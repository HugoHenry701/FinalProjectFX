package sample.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

import java.util.UUID;

public class Player {
    private String playerName;
    private UUID playerID;
    private Image playerImage;
    private String playerColor;
    private int point;
    private int turn;
    private int playerX;
    private int playerY;

    public Player(){

    }
    public Player(String name,String playerColorI, int p, int t, int x, int y) {
        playerID = UUID.randomUUID();
        playerName = name;
        playerColor = playerColorI;
        playerImage = new Image("images/PLAYER/"+ getPlayerColor() +".png");
        point = p;
        turn = t;
        playerX = x;
        playerY = y;
    }

    //get
    public String getPlayerName() {
        return playerName;
    }
    public String getPlayerColor(){return playerColor;}
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
//    public StringProperty playerNameProperty(){
//        if(playerName == null){
//            playerName = new SimpleStringProperty();
//        }
//        return playerName;
//    }
//    public final void setPlayerName(String name) {
//        this.playerNameProperty().set(name);
//    }

//    public StringProperty playerColorProperty(){
//        if(playerColor == null){
//            playerColor = new SimpleStringProperty();
//        }
//        return playerColor;
//    }
//    public final void setPlayerColor(String color){this.playerColorProperty().set(color);}

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
    public void setPlayerName(String name){
        playerName = name;
    }

}
