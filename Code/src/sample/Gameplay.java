package sample;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Gameplay {
    @FXML
    private Pane Pane
            ;
    @FXML
    private ImageView Star;
    @FXML
    private ImageView PauseButton_img;
    @FXML
    private Arc arc1;
    @FXML
    private Arc arc2;
    @FXML
    private Arc arc3;
    @FXML
    private Arc arc4;
    @FXML
    private Circle Incircle;

    @FXML
    public void initData(){
        System.out.println("Working??");
       final Group outerCircle = new Group(arc1, arc2, arc3, arc4,Incircle);
       Group star = new Group(Star);
        RotateTransition rotate = new RotateTransition();
        RotateTransition rotate_anti = new RotateTransition();
        rotate_anti.setAxis(Rotate.Z_AXIS);
        rotate_anti.setFromAngle(360);
        rotate_anti.setToAngle(0);
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setFromAngle(0);
        rotate.setToAngle(360);
        rotate_anti.setCycleCount(RotateTransition.INDEFINITE);
        rotate.setCycleCount(RotateTransition.INDEFINITE);
        rotate.setDuration(Duration.millis(1000));
        rotate_anti.setDuration(Duration.millis(5000));
        rotate.setNode(outerCircle);
        rotate_anti.setNode(star);
        rotate_anti.play();
        rotate.play();
       // Pane.

        Pane.getChildren().add(outerCircle);
        Pane.getChildren().add(star);
//        RotateTransition rotate = new RotateTransition();
//        rotate.setAxis(Rotate.Z_AXIS);
//        rotate.setFromAngle(0);
//        rotate.setToAngle(360);
//        rotate.setCycleCount(1);
//        rotate.setDuration(Duration.millis(1000));
//        rotate.setNode((Node)outerCircle);
//        rotate.play();
//
//
   }
   @FXML
   public void flippause(MouseEvent event) throws  IOException {
        flipIcon(PauseButton_img);
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
    void jump(){
        System.out.println("Jump");
    }

    @FXML
    void openPauseMenu(MouseEvent event) throws IOException {
        Parent Pause = FXMLLoader.load(getClass().getResource("pauseMenu.fxml"));
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

}
