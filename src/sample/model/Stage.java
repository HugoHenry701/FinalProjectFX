package sample.model;

import javafx.scene.image.Image;

public class Stage {
    private int step;
    private Image arrow;

    public Stage(int step1){
        step = step1;
        arrow = new Image("images/coolArrow.png");
    }
}
