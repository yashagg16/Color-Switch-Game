package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

import static javafx.application.Application.launch;

public class StartMenu extends Application {
    @FXML
    private AnchorPane startMenuScreen;

    @FXML
    private Button newGameButton;

    @FXML
    void openGamePlay(ActionEvent event) throws IOException {
        Parent gamePlay = FXMLLoader.load(getClass().getResource("Gameplay.fxml"));
        Scene scene = new Scene(gamePlay);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
//        Gameplay Gameplay = new Gameplay();
//        Stage newStage = new Stage();
//        Gameplay.start(newStage);
//    }
//
    }
    @Override
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
