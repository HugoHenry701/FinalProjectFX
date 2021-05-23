package sample.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

import java.util.UUID;

public class Player {
    private String playerName;
    private UUID playerID;
    private Image playerImage;
    private String playerUrl;
    private String playerColor;
    private int point;
    private int turn;


    public Player(String playerUrlI, int p, int t) {
        playerID = UUID.randomUUID();
        playerUrl = playerUrlI;
        playerImage = new Image("images/PLAYER/"+ getplayerUrl() +".png");
        point = p;
        turn = t;

        switch (getplayerUrl()){
            case "box0": playerColor = "Blue";break;
            case "box1": playerColor = "Green";break;
            case "box2": playerColor = "Red";break;
            case "box3": playerColor = "Yellow";break;
        }
    }

    //get
    public String getPlayerName() {
        return playerName;
    }
    public String getplayerUrl(){return playerUrl;}
    public String getPlayerID() {
        return playerID.toString();
    }

//    public String getplayerUrl() {
//        return playerUrl;
//    }

    public int getPoint() {
        return point;
    }
    public int getTurn(){
        return turn;
    }

    public String getPlayerColor(){return playerColor;}
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

//    public StringProperty playerUrlProperty(){
//        if(playerUrl == null){
//            playerUrl = new SimpleStringProperty();
//        }
//        return playerUrl;
//    }
//    public final void setplayerUrl(String color){this.playerUrlProperty().set(color);}

    public void setPlayerID(UUID id) {
        playerID = id;
    }

//    public void setplayerUrl(String colorP) {
//        playerUrl = colorP;
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


    public void setPlayerImage(Image playerImage1){playerImage = playerImage1;}
    public void setPlayerName(String name){
        playerName = name;
    }

}
