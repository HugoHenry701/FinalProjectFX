package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.security.SecureRandom;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
public class PlayerController implements Initializable {

    @FXML
    private Label xem1;
    @FXML
    private Label xem2;
    @FXML
    private TextField playerID;
    @FXML
    private TextField playerName;
    @FXML
    private Button me;
    @FXML
    private Button you;
    @FXML
            private ChoiceBox <String>color;
    @FXML
    private ChoiceBox <String>playerduo;
    private String[] mau ={"Red","Green","Blue","Yellow"};
    private String[] player ={"Player1","Player2","Player3","Player4"};
    double id;
    String name;

    public void submitID(ActionEvent event) {

        try {
            id = Double.parseDouble(playerID.getText());

        } catch (NumberFormatException e) {
            xem2.setText("enter only numbers plz");
        } catch (Exception e) {
            xem2.setText("error");
        }
    }

    public void submitName(ActionEvent event) {

        try {
            name = (playerName.getText());


        } catch (Exception e) {
            if (Pattern.matches("[a-zA-Z]+", name)) {
                xem1.setText("enter alphabet only plz");
            }
            xem1.setText("error");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        color.getItems().addAll(mau);
        playerduo.getItems().addAll(player);

    }
}


