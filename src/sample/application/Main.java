package sample.application;
import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.IOException;

public class Main extends Application {
    private Stage primaryStage;

    public static void main(String[] args) {

        launch(args);

    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("The last passenger");

        // Set the application icon
        this.primaryStage.getIcons().add(new Image("file:resources/images/hkcc.png"));
        this.primaryStage.setResizable(false);

        showMainLayout();
    }

    public void showMainLayout() {
        try {
            // Load the fxml file and set into the center of the main layout
            Parent root= FXMLLoader.load(this.getClass().getResource("/sample/view/menu.fxml"));
            Scene scene =new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            // Give the controller access to the main app
            //MenuController controller = .getController();
            //controller.setMainApp(this);

        } catch (IOException e) {
            // Exception gets thrown if the fxml file could not be loaded
            e.printStackTrace();
        }
    }
}
