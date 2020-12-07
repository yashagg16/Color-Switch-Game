package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.w3c.dom.css.Rect;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static javafx.application.Application.launch;

public class Obstacle extends Application {
    final int LimitX = 200;
    protected int speedX;
    protected int speedY;
    protected int rotation_speed;
    @FXML
    protected  AnchorPane root;
    @FXML
    protected Group finalObstacle;
    @FXML
    protected  Rectangle bar1;
    @FXML
    protected  Rectangle bar2;
    @FXML
    protected Rectangle bar3;
    @FXML
    protected  Rectangle bar4;

    protected double dx = 0.1;
    public void setSpeedX(){
        speedX = 100;
    }
    public int getSpeedX(){
        return speedX;
    }
//    @Override
//    public void start(Stage stage) throws IOException {
//        Parent obstacle = FXMLLoader.load(getClass().getResource("Obstacle.fxml"));
//        setSpeedX();
//        Scene scene = new Scene(obstacle);
//
//        Timeline timeline = new Timeline();
//        timeline.setCycleCount(Timeline.INDEFINITE);
//        timeline.setAutoReverse(true);
//        final KeyValue kv = new KeyValue(obstacle.layoutXProperty(), random());
//        final KeyFrame kf = new KeyFrame(Duration.millis(4000), kv);
//        if(outOfWindow(bar1)){
//            System.out.println("HELLL");
//        }
//        timeline.getKeyFrames().add(kf);
//        timeline.play();
//        stage.setScene(scene);
//        stage.show();
//    }

//    public Obstacle() throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("Obstacle.fxml"));
//        Obstacle obstacle = loader.getController();
//        this.bar1 = obstacle.bar1;
//        this.bar2 = obstacle.bar2;
//        this.bar3 = obstacle.bar3;
//        this.bar4 = obstacle.bar4;
//        this.finalObstacle = obstacle.finalObstacle ;
//    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Obstacle.fxml"));
        Scene scene = new Scene(loader.load());
        Obstacle controller = loader.getController();
        Translate translate = new Translate();
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        final KeyValue kv = new KeyValue(translate.xProperty(), random());
        final KeyFrame kf = new KeyFrame(Duration.millis(4000), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
        controller.finalObstacle.getTransforms().add(translate);
        stage.setScene(scene);
        stage.show();
    }
    private void setTranslate(Group finalObstacle){
        Translate translate = new Translate();
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        final KeyValue kv = new KeyValue(translate.xProperty(), random());
        final KeyFrame kf = new KeyFrame(Duration.millis(4000), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
        finalObstacle.getTransforms().add(translate);
    }
    public Group getObstacle() throws IOException {
        setTranslate(finalObstacle);
        return finalObstacle;
    }
    private int random(){
        Random random = new Random();
        return random.nextInt(420) + 400;
    }
    private boolean outOfWindow(Node node) {
        if(node == null){
            return false;
        }
        if (node.getBoundsInParent().intersects(node.getBoundsInParent().getWidth(), node.getBoundsInParent().getHeight(),
                root.getPrefWidth() - node.getBoundsInParent().getWidth() * 2,
                root.getPrefHeight() - node.getBoundsInParent().getHeight() * 2)){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        launch(args);
    }

    public boolean intersectsWrongColour(Circle ball) {
        if(ball == null){
            System.out.println("Ball null hai");
        }
        return checkIntersection(bar1, ball) || checkIntersection(bar2, ball) || checkIntersection(bar3, ball) || checkIntersection(bar4, ball);
    }

    protected boolean checkIntersection(Shape bar, Circle ball){
        return bar.intersects(ball.getBoundsInParent()) && bar1.getStroke() != ball.getStroke();
    }
}
