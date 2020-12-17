package sample;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
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
    @FXML
    protected Rectangle star_5;
    @FXML
    protected Rectangle star_6;
    @FXML
    protected Rectangle star_7;
    @FXML
    protected  Rectangle star_8;
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

    public Group getObstacle(Paint paint) throws IOException {
        rotateFunction(obstacle_x, 0, 360);
        rotateFunction(obstacle_x1, 360, 0);
        setImage();
        setStar(star_1);
        setStar(star_2);
        setStar(star_3);
        setStar(star_4);
        setStar(star_5);
        setStar(star_6);
        setStar(star_7);
        setStar(star_8);
        return finalObstacle;
    }
    @Override
    public boolean WrongIntersection(Circle ball){
        System.out.println("IDHAR");

        boolean result = checkIntersection(rect_1, ball) || checkIntersection(rect_2, ball) || checkIntersection(rect_3, ball) || checkIntersection(rect_4, ball) || checkIntersection(rect_5, ball) || checkIntersection(rect_6, ball) || checkIntersection(rect_7, ball) || checkIntersection(rect_8, ball);
        System.out.println(result);
        return result;
    }

    @Override
    public int checkStars(Circle ball){
        return starIntersects(star_1, ball) + starIntersects(star_2, ball) + starIntersects(star_3, ball) + starIntersects(star_4, ball) + starIntersects(star_5, ball) + starIntersects(star_6, ball) + starIntersects(star_7, ball) + starIntersects(star_8, ball);
    }

    @Override
    public void removeImage(Rectangle image) {
        if (obstacle_x.getChildren().contains(image)) {
            obstacle_x.getChildren().remove(image);
        } else {
            obstacle_x1.getChildren().remove(image);
        }
    }
//    public boolean checkForBar(Rectangle bar, Circle ball){
//        if(bar == null){
//            System.out.println("O NO");
//            return false;
//        }
//
//        if(ball == null){
//            System.out.println("Ball is null");
//            return false;
//        }
//
////        System.out.println("bar : " + bar.getFill() + " " + "ball : " + ball.getFill()) ;
////        System.out.println("bar : " + bar.getBoundsInParent() + " ball : " + ball.getBoundsInParent());
//        boolean fillNotSame = bar.getFill() != ball.getFill();
//        Shape s = Shape.intersect(bar, ball);
//        System.out.println(s.getBoundsInParent().getWidth());
//        boolean collides = (s.getBoundsInParent().getWidth() != -1);
////        boolean intersect = bar.getBoundsInParent().intersects(ball.getBoundsInParent());
//        System.out.println("Fill Not Same : " + fillNotSame);
//        System.out.println("Intersect : " + collides);
////        return bar.getBoundsInParent().intersects(ball.getBoundsInParent()) && (!bar.getFill().equals(ball.getFill()));
//        return fillNotSame && collides;
//    }
}
