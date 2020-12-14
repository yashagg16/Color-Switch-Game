package sample;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.io.IOException;

public class CircularObstacle extends Obstacle{
    @FXML
    protected Group finalObstacle;
    @FXML
    protected Arc arc_1;
    @FXML
    protected Arc arc_2;
    @FXML
    protected Arc arc_3;
    @FXML
    protected Arc arc_4;
    @FXML
    protected Circle inCircle;

//    public CircularObstacle() throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("CircularObstacle.fxml"));
//        loader.load();
//        CircularObstacle obs = loader.getController();
//        this.finalObstacle = obs.finalObstacle;
//        this.arc_1 = obs.arc_1;
//        this.arc_2 = obs.arc_2;
//        this.arc_3 = obs.arc_3;
//        this.arc_4 = obs.arc_4;
//        this.inCircle = obs.inCircle;
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
        rotateFunction(finalObstacle, 0, 360);
        return finalObstacle;
    }
    @Override
    public boolean WrongIntersection(Circle ball){
        if(checkInCircle(ball)){
            return false;
        }
        else{
            return checkIntersection(arc_1, ball) || checkIntersection(arc_2, ball) || checkIntersection(arc_3, ball) || checkIntersection(arc_4, ball);
        }
    }

    private boolean checkInCircle(Circle ball){
        Shape s = Shape.intersect(inCircle, ball);
        if(s.getBoundsInParent().getWidth() != -1){
            return true;
        }
        return false;
    }
}
