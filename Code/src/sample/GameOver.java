package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class GameOver {
    @FXML
    private AnchorPane pane;
    @FXML
    private Label Score;

    public void init(String score){

        this.Score.setText(score);
    }

    @FXML
    public void MainMenu(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StartMenu.fxml"));
        AnchorPane pane=fxmlLoader.load();
        this.pane.getChildren().setAll(pane);
    }
    @FXML
    public void resume(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Gameplay.fxml"));
        AnchorPane pane=fxmlLoader.load();
        Loader loadgame = new Loader();
        loadgame.bringIn();
        Gameplay controller = fxmlLoader.getController();

        controller.loadfromPause(loadgame,event);
        this.pane.getChildren().setAll(pane);
    }
    @FXML
    public void restart(ActionEvent event)throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Gameplay.fxml"));
        AnchorPane pane=fxmlLoader.load();
        Gameplay controller = fxmlLoader.getController();

        controller.initData(event);
        this.pane.getChildren().setAll(pane);
    }
}
