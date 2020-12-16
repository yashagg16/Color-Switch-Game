package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

public class test extends Application {
    @Override
    public void start(Stage stage) {
        Pane canvas=new Pane();
        Line l=new Line();
        l.setStartX(125);
        l.setStartY(250);
        l.setEndY(250);
        l.setEndX(375);
        l.setStroke(Color.YELLOW);
        l.setStrokeWidth(10);
        Scene scene = new Scene(canvas, 500, 500, Color.BLACK);
        canvas.getChildren().add(l);
        Circle ball = new Circle(10, Color.DARKSLATEBLUE);
        ball.relocate(250,475);
        canvas.getChildren().add(ball);
        EventHandler<ActionEvent> a=new EventHandler<>() {


            @Override
            public void handle(ActionEvent t) {

                ball.setLayoutY(ball.getLayoutY() -2);
                Shape s=Shape.intersect(ball,l);
                if(!s.getBoundsInLocal().isEmpty()) {

                    System.out.println("Collision Detected");
                }

            }
        };
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(40),a));
        timeline.setCycleCount(Timeline.INDEFINITE);

        timeline.play();
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        launch(args);

    }

}