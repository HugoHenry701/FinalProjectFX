package sample.module;

import java.util.UUID;

public class BOX {
    private String boxColor;
    private UUID boxID;
    private boolean boxStatus;

    public BOX(String c, boolean bStatus) {
        boxColor = c;
        boxStatus = bStatus;
        boxID = UUID.randomUUID();
    }

    public BOX() {
        this("", false);
    }

    public String getColor() {
        return boxColor;
    }

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
