package sample.controller;

import java.io.IOException;

import javafx.event.ActionEvent;


public class menuSController {

    private SceneController sceneController = new SceneController();


    public void switchToSceneMenu  (ActionEvent event) throws IOException {
        sceneController.switchToScene1(event);
    }



}