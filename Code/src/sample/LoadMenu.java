package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoadMenu {
    @FXML
    private AnchorPane pane;
    @FXML
    void BackToMainMenu(ActionEvent event) throws IOException {

        StartMenu startMenu = new StartMenu();
        startMenu.start((Stage) pane.getScene().getWindow());
    }

}
