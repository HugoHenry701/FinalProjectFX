package sample.model;

import java.util.ArrayList;

public class Team {
    private Player[]players;

    public Team(int playerNumber){
        players = new Player[playerNumber];
        for (int i = 0; i < players.length ; i++) {
            players[i] = new Player("","player"+i,0,i,-1,-1);
        }
    }
    public Player[] getPlayers(){return players;}
}
