package sample;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

import static javafx.application.Application.launch;

public class StartMenu extends Application {
    @FXML
    private AnchorPane startMenuScreen;

    @FXML
    private ImageView newGameIcon;
    @FXML
    private ImageView resumeGameIcon;
    @FXML
    private ImageView highScoreIcon;
    @FXML
    private  ImageView exitIcon;
    @FXML
    void openGamePlay(ActionEvent event) throws IOException {
        //Parent gamePlay = FXMLLoader.load(getClass().getResource("Gameplay.fxml"));
        //Scene scene = new Scene(gamePlay);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Gameplay.fxml"));
        AnchorPane pane=fxmlLoader.load();
        Gameplay controller = fxmlLoader.getController();
        controller.initData(event);
        startMenuScreen.getChildren().setAll(pane);
//        Gameplay Gameplay = new Gameplay();
//        Stage newStage = new Stage();
//        Gameplay.start(newStage);
//    }
//
    }

    private void flipIcon(ImageView Icon){
        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setFromAngle(0);
        rotate.setToAngle(360);
        rotate.setCycleCount(1);
        rotate.setDuration(Duration.millis(1000));
        rotate.setNode((Node)Icon);
        rotate.play();
    }
    @FXML
    void flipNewGameIcon (MouseEvent event) throws  IOException {
        flipIcon(newGameIcon);
    }
    @FXML
    void flipResumeGameIcon (MouseEvent event) throws  IOException {
        flipIcon(resumeGameIcon);
    }
    @FXML
    void flipHighScoreIcon (MouseEvent event) throws  IOException {
        flipIcon(highScoreIcon);
    }
    @FXML
    void flipExitIcon (MouseEvent event) throws IOException {
        flipIcon(exitIcon);
    }
    @FXML
    void exitStartMenu(ActionEvent event) throws IOException {
    }
    private static MediaPlayer mediaPlayer;
    @Override
    public void start(Stage PrimaryStage) throws IOException {
//            Audio.getInstance().playMusic("/assets/Sounds/gameStart.wav").play();
            Parent StartMenu = FXMLLoader.load(getClass().getResource("StartMenu.fxml"));
            final Scene scene = new Scene(StartMenu);


            PrimaryStage.setScene(scene);
            PrimaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
    @FXML
    void LoadMenu(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoadMenu.fxml"));
        AnchorPane pane=fxmlLoader.load();
        Loadmenu controller = fxmlLoader.getController();
        controller.init(event);
        startMenuScreen.getChildren().setAll(pane);
    }

}
