package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;

public class StartMenu {
    public void start(Stage PrimaryStage) throws IOException {
        Parent StartMenu = FXMLLoader.load(getClass().getResource("StartMenu.fxml"));
    }

    public static void main(String[] args){
        launch(args);
    }
}
