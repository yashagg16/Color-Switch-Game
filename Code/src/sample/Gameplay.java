package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Gameplay  extends Application {
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
    private Circle ball;
    private Group outerCircle;
    private Group Obstacle;
    private double dx;
    private double balljump;
    private boolean isplaying = false;
    @FXML
    public void initData(ActionEvent event){
        isplaying = false;
        System.out.println("Working??");
        
        Group outerCircle = new Group(arc1, arc2, arc3, arc4,Incircle);
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
        //outerCircle.setLayoutY(-200);
        Obstacle = new Group(outerCircle, star);
        Obstacle.setLayoutY(-400);
        dx = 3;
        balljump = ball.getLayoutY();

       // this.play();
       // Pane.

        Pane.getChildren().add(outerCircle);
        Pane.getChildren().add(star);
        Pane.getChildren().add(Obstacle);
        ball.toFront();

        Pane.onKeyPressedProperty( );
        ((Node) event.getSource()).getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override public void handle(KeyEvent event) {
                //System.out.println("Chara "+event.getCharacter());
//                System.out.println("Code"+event.getCode());
//                System.out.println("Text"+event.getText());
                // System.out.println(event.);
                isplaying = true;
                switch (event.getCode()) {
                    case W:
                        balljump = ball.getLayoutY()-100;
                        if(dx>0)
                            dx = -5;
                        else
                            dx -=3;
                        System.out.println("UP"); break;
                    case U:
                        System.out.println("UP Pressed"); break;
                    case D:
                        System.out.println("D Pressed"); break;
                    case R: System.out.println("Right"); break;
                    case O:  System.out.println("DOWN"); break;
                    case L:  System.out.println("LEFT"); break;
                    default:
                        System.out.println("Horha h");
                }
            }
        });

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {
            // double dx = 1; //Step on y or velocity


            @Override
            public void handle(ActionEvent t) {
                //move the ball
                outerCircle.setLayoutY(outerCircle.getLayoutY()+2);
                Obstacle.setLayoutY(Obstacle.getLayoutY()+2);

                if(outerCircle.getLayoutY()>=900){
                    outerCircle.setLayoutY(-150);
                    ball.toFront();
                }
                ball.setLayoutY(ball.getLayoutY() + dx);
                //If the ball reaches the left or right border make the step negative
                //If the ball reaches the bottom or top border make the step negative
                if(Math.abs(dx)<1){
                    dx = 1;
                }
                //Add damping effect to the ball
                if(dx>0){
                    dx += 0.03*dx;
                }
                else{
                    dx -= (0.03)*dx;
                }

            }
        }));



        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
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
    void jump (MouseEvent event) throws  IOException {
        ball.setCenterY(ball.getCenterY()-100);
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



    @Override
    public void start(Stage PrimaryStage) throws Exception {
        Parent StartMenu = FXMLLoader.load(getClass().getResource("Gameplay.fxml"));
        PrimaryStage.setTitle("Color Switch");
        final Scene scene = new Scene(StartMenu);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("Key press detected...");
            }
        });
        //Gameplay game = new Gameplay();

        PrimaryStage.setScene(scene);
        //initData();

        PrimaryStage.show();
        //initData();

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
