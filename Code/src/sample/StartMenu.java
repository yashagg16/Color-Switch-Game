package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;

public class StartMenu extends Application {
    public void start(Stage PrimaryStage) throws IOException {
        Parent StartMenu = FXMLLoader.load(getClass().getResource("StartMenu.fxml"));
        final Scene scene = new Scene(StartMenu);

        PrimaryStage.setScene(scene);
        PrimaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
