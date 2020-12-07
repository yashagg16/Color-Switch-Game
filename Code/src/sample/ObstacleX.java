package sample;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class ObstacleX extends Obstacle {
    @FXML
    protected Group obstacle_x;
    @FXML
    protected Group obstacle_x1;
    @FXML
    protected Group finalObstacle;
    @FXML
    protected Rectangle rect_1;
    @FXML
    protected Rectangle rect_2;
    @FXML
    protected Rectangle rect_3;
    @FXML
    protected Rectangle rect_4;
    @FXML
    protected Rectangle rect_5;
    @FXML
    protected Rectangle rect_6;
    @FXML
    protected Rectangle rect_7;
    @FXML
    protected Rectangle rect_8;

//    public ObstacleX() throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("ObstacleX.fxml"));
//        loader.load();
//        ObstacleX obs = loader.getController();
//        this.obstacle_x1 = obs.obstacle_x1;
//        this.obstacle_x = obs.obstacle_x;
//        this.finalObstacle = obs.finalObstacle;
//        this.rect_1 = obs.rect_1;
//        this.rect_2 = obs.rect_2;
//        this.rect_3 = obs.rect_3;
//        this.rect_4 = obs.rect_4;
//        this.rect_5 = obs.rect_5;
//        this.rect_6 = obs.rect_6;
//        this.rect_7 = obs.rect_7;
//        this.rect_8 = obs.rect_8;
//    }
    public void rotateFunction(Parent parent, int stAngle, int endAngle){
        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setFromAngle(stAngle);
        rotate.setToAngle(endAngle);
        rotate.setCycleCount(RotateTransition.INDEFINITE);
        rotate.setDuration(Duration.millis(3000));
        rotate.setNode(parent);
        rotate.play();
    }
    public Group getObstacle() throws IOException {
        rotateFunction(obstacle_x, 0, 360);
        rotateFunction(obstacle_x1, 360, 0);
        return finalObstacle;
    }
    @Override
    public boolean intersectsWrongColour(Circle ball){
        return checkIntersection(rect_1, ball) || checkIntersection(rect_2, ball) || checkIntersection(rect_3, ball) || checkIntersection(rect_4, ball) || checkIntersection(rect_5, ball) || checkIntersection(rect_6, ball) || checkIntersection(rect_7, ball) || checkIntersection(rect_8, ball);
    }
}