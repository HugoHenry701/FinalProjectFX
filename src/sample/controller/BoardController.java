package sample.controller;


import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import sample.module.BoardGame;
import sample.module.ListGameBoard;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

public class BoardController implements Initializable{
    private BoardGame mapGame;
    private boolean listCheck;
    private ListGameBoard listGameBoard ;

    @FXML
    private ColorPicker color00;
    @FXML
    private Pane pane00;
    @FXML
    private ChoiceBox <String>box01;
    @FXML
    private Pane pane01;
    @FXML
    private ChoiceBox<String> box11;
    @FXML
    private Pane pane11;
    private String [] mau ={"Red","Yellow","Blue","Green"};

    public void changeColor(ActionEvent event) {
        //color00.setValue(Color.RED);
        Color myColor = color00.getValue();
        pane00.setBackground(new Background(new BackgroundFill(myColor, null, null)));

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       // for(int i=0;i<1;i++){
        box01.getItems().addAll(mau);
        box01.setOnAction(this::changeColor01);
        box11.getItems().addAll(mau);
    }
    public void changeColor01(ActionEvent event) {
        String color01= box01.getValue();
        if(color01=="Red"){
        pane01.setBackground(new Background(new BackgroundFill( Color.RED,null, null)));}
        if(color01=="Yellow"){
            pane01.setBackground(new Background(new BackgroundFill( Color.YELLOW,null, null)));}
        if(color01=="Green"){
            pane01.setBackground(new Background(new BackgroundFill( Color.GREEN,null, null)));}
        if(color01=="Blue"){
            pane01.setBackground(new Background(new BackgroundFill( Color.BLUE,null, null)));}
    }
}
