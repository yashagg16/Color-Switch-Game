package sample;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.transform.Rotate;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

import static javafx.application.Application.launch;
import static javafx.application.Platform.exit;

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
        Audio.getInstance().playMusic("/assets/Sounds/spinning.wav",0,1).play();
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
        exit();
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
    @FXML
    void highScore(ActionEvent event) throws FileNotFoundException {
        int val = 0;
        try{
            File file = new File("HighScore.txt");
            Scanner sc = new Scanner(file);
            val = sc.nextInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Alert.AlertType type = Alert.AlertType.INFORMATION;
        Alert al = new Alert(type, "");
        al.initModality(Modality.APPLICATION_MODAL);
        al.initOwner(startMenuScreen.getScene().getWindow());
        al.getDialogPane().setContentText("Current Highscore is " + val);
        al.getDialogPane().setHeaderText("Highscore");
        Optional<ButtonType> input = al.showAndWait();
        if(input.get() == ButtonType.OK){
            al.close();
            //pane.close();
        }
        else if(input.get() == ButtonType.CANCEL){
            al.close();
        }
    }

}
