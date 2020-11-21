package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Gameplay extends Application {

    @FXML
    private ImageView PauseButton_img;
    @FXML
    void jump(){
        System.out.println("Jump");
    }

    @FXML
    void openPauseMenu(MouseEvent event) throws IOException {
        Parent Pause = FXMLLoader.load(getClass().getResource("PauseMenu.fxml"));
        Scene player = new Scene(Pause);


        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(player);
        window.show();
    }
//    scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
//        @Override
//        public void handle(KeyEvent event) {
//            switch (event.getCode()) {
//                case UP:    goNorth = true; break;
//                case DOWN:  goSouth = true; break;
//                case LEFT:  goWest  = true; break;
//                case RIGHT: goEast  = true; break;
//                case SHIFT: running = true; break;
//            }
//        }
//    });
    @Override
    public void start(Stage PrimaryStage) throws IOException {
        Parent StartMenu = FXMLLoader.load(getClass().getResource("Gameplay.fxml"));
        final Scene scene = new Scene(StartMenu);

        PrimaryStage.setScene(scene);
        PrimaryStage.show();
    }
}