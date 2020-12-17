package sample;

import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import static javafx.application.Platform.exit;

public class Gameplay  extends Application {
    @FXML
    private Pane Pane
            ;
    @FXML
    private Label ScoreLabel;
    @FXML
    public Label name;
    @FXML
    private ImageView Star;
    @FXML
    private ImageView PauseButton_img;
    @FXML
    private Circle ball;
    private Group outerCircle;
    private Group obstacleOnScreen;
    private Obstacle obstacleOnTop;
    private FXMLLoader loader ;
    private Obstacle obstacleToCome;
    private Group Obstacle;
    private double dx;
    private double balljump;
    private Queue<Obstacle> obstacleQueue = new LinkedList<>();
    private boolean isplaying = false;
    public FXMLLoader loadTheLoader(String name) throws IOException {
        return new FXMLLoader(getClass().getResource(name));
    }
    public void getNewObstacle() throws IOException {

        obstacleQueue.add(obstacleOnTop);
        obstacleOnTop = obstacleQueue.poll();
        if(obstacleOnTop instanceof ObstacleX){
            loader = loadTheLoader("ObstacleX.fxml");
        }
        else if(obstacleOnTop instanceof CircularObstacle){
            loader = loadTheLoader("CircularObstacle.fxml");
        }
        else if(obstacleOnTop instanceof rectangularObstacle){
            loader = loadTheLoader("rectangularObstacle.fxml");
        }
        else{
            loader = loadTheLoader("Obstacle.fxml");
        }
        loader.load();
        obstacleOnTop = loader.getController();
        obstacleToCome = obstacleQueue.peek();
        System.out.println("ObstacleOnTop new Class :  " + obstacleOnTop.getClass().toString());
        obstacleOnScreen = obstacleOnTop.getObstacle(ball.getFill());
        obstacleOnScreen.setLayoutY(0);
        Pane.getChildren().add(obstacleOnScreen);
    }
    public boolean checkIntersection(){
        System.out.println(obstacleOnTop.getClass().toString());
        return obstacleOnTop.WrongIntersection(ball);
    }
    public int checkStars(){
        int val = obstacleOnTop.checkStars(ball) ;
        System.out.println("stars intersected : " + val);
        return val;
    }
    public void increaseScore(int val){
        ScoreLabel.setText(Integer.toString(Integer.parseInt(ScoreLabel.getText()) + val));
    }
    @FXML
    public void initData(ActionEvent event) throws IOException {
        isplaying = false;
        System.out.println("Working??");
        dx = 3;
        balljump = ball.getLayoutY();

        ball.toFront();

        Random random = new Random();
        for(int i=0; i<10; i++){
            int val = random.nextInt(99) + 1;
            if(val%4 == 0){
                obstacleQueue.add(new Obstacle());
            }
            else if(val %4 == 1){
                obstacleQueue.add(new ObstacleX());
            }
            else if(val % 4 == 2){
                obstacleQueue.add(new CircularObstacle());
            }
            else if(val%4 == 3){
                obstacleQueue.add(new rectangularObstacle());
            }
        }
        obstacleOnTop = obstacleQueue.poll();

        if(obstacleOnTop instanceof ObstacleX){
            loader = loadTheLoader("ObstacleX.fxml");
        }
        else if(obstacleOnTop instanceof CircularObstacle){
            loader = loadTheLoader("CircularObstacle.fxml");
        }
        else if(obstacleOnTop instanceof  rectangularObstacle){
            loader = loadTheLoader("rectangularObstacle.fxml");
        }
        else{
            loader = loadTheLoader("Obstacle.fxml");
        }
        loader.load();
        obstacleOnTop = loader.getController();
        obstacleToCome = obstacleQueue.peek();
        obstacleOnScreen = obstacleOnTop.getObstacle(ball.getFill());
        if(obstacleOnScreen == null){
            System.out.println("Nahi hua nahi hua");
            exit();
        }
        else{
            System.out.println("AA GAYA");
        }
        obstacleOnScreen.setLayoutY(0);
        Pane.getChildren().add(obstacleOnScreen);
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
                        //Pane.setLayoutY(Pane.getLayoutY() +2);
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

        sample.Obstacle finalObstacleOnTop = obstacleOnTop;
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {



            @Override
            public void handle(ActionEvent t) {
                //move the ball
//                outerCircle.setLayoutY(outerCircle.getLayoutY()+2);
                obstacleOnScreen.setLayoutY(obstacleOnScreen.getLayoutY()+2);

                if(obstacleOnScreen.getLayoutY()>=900){
                    ball.toFront();
                }
                ball.setLayoutY(ball.getLayoutY() + dx);
                //Checking if ball touches any star
//                if(Star.getBoundsInParent().intersects(ball.getBoundsInParent())){
//                    System.out.println("Hell yeah");
//                    Star.setLayoutY((Star.getLayoutY()+150)%600);
////                    ScoreLabel.setText(String.valueOf(Integer.parseInt(ScoreLabel.getText())+1));
//                }

                increaseScore(checkStars());
                obstacleOnTop.checkColorChanger(ball);
                if(checkIntersection()){
                    System.out.println("Intersection detect Ho gaya");
                    isplaying = false;
                    //exit();
                }

                //Detecting collision with obstacle
//                if(obstacleOnScreen.getBoundsInParent().intersects(ball.getBoundsInParent())){
//                    System.out.println("Here ");
//                    if(obstacleOnTop.intersectsWrongColour(ball)){
//                        System.out.println("Game Over Ho Gaya");
//                        isplaying = false;
//                    }
//                }


                if(obstacleOnScreen.getLayoutY() > 1024) {
                    try {
                        //obstacleOnScreen = obstacleToCome;
                        getNewObstacle();
                        ball.toFront();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
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
        int color, obstacle, x, y,score;
        if(ball.getStroke()== Color.RED){
            color = 1;
        }
        else if(ball.getStroke() == Color.BLUE){
            color =2;
        }
        else if(ball.getStroke() == Color.GREEN){
            color = 3;
        }
        else{
            // Yellow
            color = 4;
        }
        //default case for trying now.....
        obstacle =1;
        //Uncomment following if statements to make it working
        if(obstacleOnTop instanceof ObstacleX){
            obstacle = 1;
        }
        else if(obstacleOnTop instanceof CircularObstacle){
            obstacle = 2;
        }
        else{
            obstacle = 3;
        }
        Loader pausegame = new Loader(Integer.parseInt(ScoreLabel.getText()),color,obstacle,ball.getCenterX(),ball.getCenterY());
        pausegame.writeOut();
        System.out.println("Writeout completed");
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
    public void loadfromPause(Loader load, ActionEvent event) throws IOException{
        isplaying = false;
        System.out.println("Loading from the pause Menu");
        ScoreLabel.setText(String.valueOf(load.score));
        ScoreLabel.toFront();
        dx = 3;
        balljump = ball.getLayoutY();
        ball.toFront();

        int val = load.obstacle;
        Random random = new Random();
        for(int i =0; i<10;i++){
            if(val%3 == 0){
                obstacleQueue.add(new Obstacle());
            }
            else if(val %3 == 1){
                obstacleQueue.add(new ObstacleX());
            }
            else if(val % 3 == 2){
                obstacleQueue.add(new CircularObstacle());
            }
            val = random.nextInt(99)+1;
        }
        obstacleOnTop = obstacleQueue.poll();

        if(obstacleOnTop instanceof ObstacleX){
            loader = loadTheLoader("ObstacleX.fxml");
        }
        else if(obstacleOnTop instanceof CircularObstacle){
            loader = loadTheLoader("CircularObstacle.fxml");
        }
        else{
            loader = loadTheLoader("Obstacle.fxml");
        }
        loader.load();
        obstacleOnTop = loader.getController();
        obstacleToCome = obstacleQueue.peek();
        obstacleOnScreen = obstacleOnTop.getObstacle(ball.getFill());
        if(obstacleOnScreen == null){
            System.out.println("Nahi hua nahi hua");
            exit();
        }
        else{
            System.out.println("AA GAYA");
        }
        obstacleOnScreen.setLayoutY(0);
        Pane.getChildren().add(obstacleOnScreen);
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
                        //Pane.setLayoutY(Pane.getLayoutY() +2);
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

        sample.Obstacle finalObstacleOnTop = obstacleOnTop;
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {



            @Override
            public void handle(ActionEvent t) {
                //move the ball
//                outerCircle.setLayoutY(outerCircle.getLayoutY()+2);
                obstacleOnScreen.setLayoutY(obstacleOnScreen.getLayoutY()+2);
                //obstacleOnTop.move(2);

                if(obstacleOnScreen.getLayoutY()>=900){
                    ball.toFront();
                }
                ball.setLayoutY(ball.getLayoutY() + dx);


                increaseScore(checkStars());
                obstacleOnTop.checkColorChanger(ball);
                if(checkIntersection()){
                    System.out.println("Intersection detect Ho gaya");
                    isplaying = false;
                    //exit();
                }

                if(obstacleOnScreen.getLayoutY() > 1024) {
                    try {
                        //obstacleOnScreen = obstacleToCome;
                        getNewObstacle();
                        ball.toFront();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
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

}
