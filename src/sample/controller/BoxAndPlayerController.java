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


public class BoxAndPlayerController {


    private Stage stage;
    private Scene scene;
    private Parent root;
    private Stage stage2;
    private Scene scene2;
    private Parent root2;

    public void switchToPlayer(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/src/sample/View/player.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

