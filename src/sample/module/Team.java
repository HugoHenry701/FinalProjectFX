package sample.module;

import javafx.scene.image.Image;

public class Team {
    private Image teamColor;

    public Team( Image teamColor1){
        teamColor = teamColor1;
    }
    public Image getTeamColor(){return teamColor;}
    public void setTeamColor(Image image){
        teamColor = image;
    }
}
