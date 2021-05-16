package sample.controller;


import javafx.event.ActionEvent;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import  sample.Main;

import java.awt.*;
import java.io.IOException;


import java.awt.image.AffineTransformOp;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;


public class MenuController implements Initializable {
    private Main mainApp;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Stage stage2;
    private Scene scene2;
    private Parent root2;
    @FXML
    private ImageView bus;


    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;

    }



    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

            TranslateTransition translate=new TranslateTransition();
            translate.setNode(bus);
            translate.setCycleCount(TranslateTransition.INDEFINITE);
            translate.setToX(500);
            translate.setToY(500);
            translate.setFromX(25);
            translate.setFromY(-100);
            translate.setToX(50);
            translate.setToZ(0);
            translate.setDuration(Duration.seconds(3));
            translate.setAutoReverse(true);
            translate.play();
            ScaleTransition scale = new ScaleTransition();
            scale.setNode(bus);
            scale.setDuration(Duration.millis(1000));
            scale.setCycleCount(TranslateTransition.INDEFINITE);
            scale.setInterpolator(Interpolator.LINEAR);
            scale.setByX(1.5);
            scale.setByY(1.5);

            scale.play();
    }
   public void out(ActionEvent e){
     System.exit(0);
   }

    public void switchToScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/src/sample/View/menuS.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToScene3(ActionEvent event) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("/src/sample/View/BoxAndPlayer.fxml"));
        stage2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene2 = new Scene(root2);
        stage2.setScene(scene2);
        stage2.show();
    }
}

