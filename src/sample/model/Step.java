package sample.model;

import javafx.scene.image.Image;

public class Step {
    private int step;
    private Image arrow;

    public Step(int step1){
        step = step1;
        arrow = new Image("images/coolArrow.png");
    }
}
