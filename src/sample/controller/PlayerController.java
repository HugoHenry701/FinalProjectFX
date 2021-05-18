package sample.controller;

import javafx.scene.image.Image;
import sample.model.Player;

import java.util.ArrayList;

public class PlayerController {
    private ArrayList<Player> players = new ArrayList<>();

    public PlayerController(){

    }
    public void setPlayers(String playerName, String playerColor, int playerPoint, int playerTurn, int x, int y){
        players.add(new Player(playerName,playerColor,playerPoint,playerTurn,x,y));
    }
    public ArrayList<Player> getPlayers(){return players;}
    public String getOnePlayerName(int playerTurn){
       return players.get(playerTurn).getPlayerName();
    }
    public Image getOnePlayerColor(int playerTurn){

        return players.get(playerTurn-1).getPlayerImage();
    }
    public ArrayList<String> getPlayersName(){
        ArrayList<String> playersName = new ArrayList<>();
        for (int i = 0; i < players.size() ; i++) {
            playersName.add(players.get(i).getPlayerName());
        }
        return playersName;
    }
}
