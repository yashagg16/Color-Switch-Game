package sample;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Main extends Application {

    public static void makeArc(Arc arc, double centerX, double centerY, double radius, double startAngle, Color color){
        arc.setType(ArcType.ROUND);
        arc.setCenterX(centerX);
        arc.setCenterY(centerY);
        arc.setRadiusX(radius);
        arc.setRadiusY(radius);
        arc.setStartAngle(startAngle);
        arc.setLength(90);
        arc.setFill(color);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Color Switch");

        //Creating the color switch logo
        Arc arc1 = new Arc();
        Arc arc2 = new Arc();
        Arc arc3 = new Arc();
        Arc arc4 = new Arc();
        makeArc(arc1, 400, 300, 100, 0, Color.RED);
        makeArc(arc2, 400, 300, 100, 90, Color.GREEN);
        makeArc(arc3, 400, 300, 100, 180, Color.YELLOW);
        makeArc(arc4, 400, 300, 100, 270, Color.BLUE);

        //grouping all the arcs together for the outside arcs
        final Group outerCircle = new Group(arc1, arc2, arc3, arc4);

        //loading the image using the mainPage.fxml
        Parent MainPage = FXMLLoader.load(getClass().getResource("Main.fxml"));
        MainPage.setLayoutX(320);
        MainPage.setLayoutY(20);

        //creating the rotation aspect of the program;
        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setFromAngle(0);
        rotate.setToAngle(360);
        rotate.setCycleCount(RotateTransition.INDEFINITE);
        rotate.setDuration(Duration.millis(1000));
        rotate.setNode(outerCircle);
        rotate.play();

        //creating the inner circle
        final Circle circ2 = new Circle(400, 300, 80, Color.BLACK);

        //adding the loading bar
        
        //final group to add all the elements into
        final Group root = new Group();
        root.getChildren().add(outerCircle);
        root.getChildren().add(circ2);
        root.getChildren().add(MainPage);


        //creating the scene and adding the root to it
        final Scene scene = new Scene(root,  800, 800, Color.BLACK);

        //display
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
