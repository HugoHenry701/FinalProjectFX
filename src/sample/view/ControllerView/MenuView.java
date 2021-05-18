package sample.view.ControllerView;


import javafx.event.ActionEvent;


import sample.application.Main;


import java.io.IOException;


import java.net.URL;

import java.util.ResourceBundle;

import javafx.animation.Interpolator;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.image.ImageView;


import javafx.util.Duration;


public class MenuView implements Initializable {
    private Main mainApp;
    private SceneController sceneController = new SceneController();
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

    public void switchToGamePlay(ActionEvent event) throws IOException {
        sceneController.switchToScene2(event);
    }
    public void switchToSceneOption(ActionEvent event) throws IOException {
        sceneController.switchToScene3(event);
    }
}

