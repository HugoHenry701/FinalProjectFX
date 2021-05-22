package sample.model;


import javafx.animation.FadeTransition;

import javafx.scene.image.Image;

import javafx.scene.image.ImageView;


import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import javafx.util.Duration;


import java.util.UUID;

public class BOX extends Pane    {

    private String boxColor;
    private ImageView boxImage;
    private UUID boxID;
    private boolean boxStatus;
    private Image box;
    private Integer colIndex;
    private Integer rowIndex;
    private int clickCount = 1;


    public BOX(String c, boolean bStatus) {

        boxColor = c;
        boxStatus = bStatus;
        boxID = UUID.randomUUID();
        box = new Image("./resources/images/BOX/" + boxColor);
        boxImage = new ImageView(box);
        boxImage.setFitWidth(45);
        boxImage.setFitHeight(45);
        boxImage.setPreserveRatio(true);
        boxImage.setVisible(boxStatus);
        setOnMouseClicked(this::handleMouseClick);
        close();
    }

    public void handleMouseClick(MouseEvent event) {
        if(isOpen()||clickCount==0)return;
        open(() -> {
            rowIndex = GridPane.getRowIndex(this);
            colIndex = GridPane.getColumnIndex(this);
            clickCount--;
        });
    }

    public String getColor() {
        return boxColor;
    }

    public ImageView getBoxImage() {
        return boxImage;
    }

    public Image getBox() {
        return box;
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

    public String getBoxID() {
        return boxID.toString();
    }

    public Integer getRowIndex() {
        return rowIndex;
    }

    public Integer getColIndex() {
        return colIndex;
    }


    public boolean isOpen() {
        return boxImage.getOpacity() == 1;
    }

    public void open(Runnable action) {
        FadeTransition ft = new FadeTransition(Duration.seconds(0.5), boxImage);
        ft.setToValue(1);
        ft.setOnFinished(e -> action.run());
        ft.play();
//        System.out.println("Row"+ GridPane.getRowIndex(this));
//        System.out.println("Col"+ GridPane.getColumnIndex(this));
        rowIndex = GridPane.getRowIndex(this);
        colIndex = GridPane.getColumnIndex(this);
    }

    public void close() {
        FadeTransition ft = new FadeTransition(Duration.seconds(0.1), boxImage);
        ft.setToValue(0);
        ft.play();
    }

}
