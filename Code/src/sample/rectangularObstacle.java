package sample;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class rectangularObstacle extends Obstacle{
    @FXML
    protected Group finalObstacle;
    @FXML
    protected Rectangle side_1;
    @FXML
    protected Rectangle side_2;
    @FXML
    protected Rectangle side_3;
    @FXML
    protected Rectangle side_4;

    @Override
    public Group getObstacle(){
        rotateFunction(finalObstacle, 0, 360);
        return finalObstacle;
    }

    @Override
    public boolean WrongIntersection(Circle ball){
        if(ball == null){
            System.out.println("ball is null");
            return false;
        }
        return checkIntersection(side_1, ball) || checkIntersection(side_2,ball) || checkIntersection(side_3, ball)|| checkIntersection(side_4, ball);
    }

    @Override
    public int checkStars(Circle ball){
        return starIntersects(star_1, ball);
    }
}
