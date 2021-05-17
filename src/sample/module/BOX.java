package sample.module;

import javafx.scene.image.Image;

import java.util.UUID;

public class BOX {
    private String boxColor;
    private Image boxImage;
    private UUID boxID;
    private boolean boxStatus;

    public BOX(String c, boolean bStatus) {
        boxColor = c;
        boxStatus = bStatus;
        boxID = UUID.randomUUID();
        boxImage = new Image("./resources/images/BOX/"+ boxColor);
    }

    public BOX() {
        this("", false);
    }

    public String getColor() {
        return boxColor;
    }
    public Image getBoxImage() {return boxImage;}

    public void setColor(String c) {
        boxColor = c;
    }

    public boolean getBoxStatus() {
        return boxStatus;
    }

    public void setBoxStatus(boolean bStatus) {
        boxStatus = bStatus;
    }

    public String getBoxID(){
        return boxID.toString();
    }
}
