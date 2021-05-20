package sample.view.ControllerView;


import javafx.event.ActionEvent;


import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
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

    private boolean isHidden;
    Font font=Font.font("castellar", 16);
    @FXML
    TextField p1name;
    @FXML
    TextField p2name;
    @FXML
    TextField p3name;
    @FXML
    TextField p4name;
    @FXML
    Label valid1;
    @FXML
    Label valid2;
    @FXML
    Label valid3;
    @FXML
    Label valid4;


    @FXML
    private ImageView bus;
    @FXML
    private AnchorPane subSceneHelp;
    @FXML
    private AnchorPane subScenePlay;
    @FXML
    private AnchorPane subSceneCredit;
    @FXML
    private AnchorPane subSceneSCore;


    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;

    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        TranslateTransition translate = new TranslateTransition();
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


    public void out(ActionEvent e) {
        System.exit(0);
    }
    public String[] getPlayersName(){
        String[] playersName = new String[4];
        playersName[0] = p1name.getText();
        playersName[1] = p2name.getText();
        playersName[2] = p3name.getText();
        playersName[3] = p4name.getText();
        return playersName;
    }
    public void switchToGamePlay(ActionEvent event) throws IOException {

            if(isValidSubmit() ){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/view/gamePlay.fxml"));
                Parent root2 = loader.load();
                GamePlayController gamePlayController = loader.getController();
                gamePlayController.displayPlayerName(getPlayersName());
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root2);
                stage.setScene(scene);
                stage.show();
            }else if(!isValidName(p1name.getText())){
                valid1.setText("Invalid Player Name");
                valid1.setStyle("-fx-text-fill:red");
                valid1.setFont(font);
            }else if(!isValidName(p2name.getText())){
                valid2.setText("Invalid Player Name");
                valid2.setStyle("-fx-text-fill:red");
                valid2.setFont(font);
            }else if(!isValidName(p3name.getText())){
                valid3.setText("Invalid Player Name");
                valid3.setStyle("-fx-text-fill:red");
                valid3.setFont(font);
            }else if(!isValidName(p4name.getText())){
                valid4.setText("Invalid Player Name");
                valid4.setStyle("-fx-text-fill:red");
                valid4.setFont(font);
            }

    }


    public void moveSubSceneHelp() {
        TranslateTransition trans = new TranslateTransition();
        trans.setDuration(Duration.seconds(0.3));
        trans.setNode(subSceneHelp);
        if (isHidden) {
            trans.setToX(675);
            isHidden = false;
        } else {
            trans.setToX(0);
            isHidden = true;
        }
        trans.play();
    }

    public void moveSubScenePlay() {
        TranslateTransition trans = new TranslateTransition();
        trans.setDuration(Duration.seconds(0.3));
        trans.setNode(subScenePlay);
        if (isHidden) {
            trans.setToX(675);
            isHidden = false;
        } else {
            trans.setToX(0);
            isHidden = true;
        }
        trans.play();
    }

    public void moveSubSceneCredit() {
        TranslateTransition trans = new TranslateTransition();
        trans.setDuration(Duration.seconds(0.3));
        trans.setNode(subSceneCredit);
        if (isHidden) {
            trans.setToX(675);
            isHidden = false;
        } else {
            trans.setToX(0);
            isHidden = true;
        }
        trans.play();
    }

    public void moveSubSceneScore() {
        TranslateTransition trans = new TranslateTransition();
        trans.setDuration(Duration.seconds(0.3));
        trans.setNode(subSceneSCore);
        if (isHidden) {
            trans.setToX(675);
            isHidden = false;
        } else {
            trans.setToX(0);
            isHidden = true;
        }
        trans.play();
    }
    public boolean isValidSubmit(){

        boolean check;
        if(isValidName(p1name.getText()) && isValidName(p2name.getText()) && isValidName(p3name.getText()) && isValidName(p4name.getText())){
            check = true;
        }
        else {
            check = false;
        }
        return check;
    }
    public boolean isValidName(String str){
        String regex = "[A-Za-z\\s]+";
        return str.matches(regex);
    }
}

