package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class PauseMenu  extends Application {
    @FXML
    private ImageView Background;
    @FXML
    private AnchorPane GamePlayRoot;
    @FXML
    private Button PalyButton;

    @FXML
    void play(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Gameplay.fxml"));
        AnchorPane pane=fxmlLoader.load();
        Loader loadgame = new Loader();
        loadgame.bringIn();
        Gameplay controller = fxmlLoader.getController();

        controller.loadfromPause(loadgame,event);
        GamePlayRoot.getChildren().setAll(pane);
        //GamePlayController controller = fxmlLoader.<GamePlayController>getController();



    }
    @FXML
    void save(ActionEvent event) throws Exception {
        System.out.println("Save clicked");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SaveGame.fxml"));
        AnchorPane pane=fxmlLoader.load();
        SaveGame controller = fxmlLoader.getController();
        controller.init(event);
        GamePlayRoot.getChildren().setAll(pane);

    }

    @FXML
    void exit(){
        System.out.println("Exit clicked");
    }
    
    @FXML
    public void Enterplayernamescreen(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Gameplay.fxml"));
        AnchorPane pane=fxmlLoader.load();
        Gameplay controller = fxmlLoader.getController();
        controller.initData(event);
        GamePlayRoot.getChildren().setAll(pane);
//        Parent Enterplayername = FXMLLoader.load(getClass().getResource("Gameplay.fxml"));
//        Scene playername = new Scene(Enterplayername);
//
//        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//        window.setScene(playername);
//        window.show();

    }

    @Override
    public void start(Stage PrimaryStage) throws IOException {
        Parent StartMenu = FXMLLoader.load(getClass().getResource("pauseMenu.fxml"));
        PrimaryStage.setTitle("Color Switch");
        final Scene scene = new Scene(StartMenu);
        //Gameplay game = new Gameplay();

        PrimaryStage.setScene(scene);
        PrimaryStage.show();
    }
}
