package sample;

import javafx.application.Application;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.util.Queue;

import static javafx.application.Application.launch;

public class newG extends Application {
    protected Obstacle obstacleOnScreen;
    protected Obstacle obstacleAfter;
    protected Queue<Obstacle> obstacleQueue;
    public void initData(ActionEvent e){
        for(int i=0; i<10; i++){
            if(i%3 == 0){
                obstacleQueue.add(new ObstacleX());

            }
            else if(i%3 == 1){
                obstacleQueue.add(new Obstacle());
            }
            else{
                obstacleQueue.add(new CircularObstacle());
            }
        }
    }
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
