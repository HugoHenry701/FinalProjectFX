package sample.model;

import java.util.ArrayList;

public class Team {
    private ArrayList<Player>players;

    public Team(){
        players = new ArrayList<>();
        players.add(new Player());
    }
}
