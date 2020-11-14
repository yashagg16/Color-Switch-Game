package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

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

//        final Circle circ1 = new Circle(400, 300, 100, Color.WHITE);
        Arc arc1 = new Arc();
        Arc arc2 = new Arc();
        Arc arc3 = new Arc();
        Arc arc4 = new Arc();
        makeArc(arc1, 400, 300, 100, 0, Color.RED);
        makeArc(arc2, 400, 300, 100, 90, Color.GREEN);
        makeArc(arc3, 400, 300, 100, 180, Color.YELLOW);
        makeArc(arc4, 400, 300, 100, 270, Color.BLUE);

        final Circle circ2 = new Circle(400, 300, 80, Color.BLACK);
        final Group root = new Group(arc1, arc2, arc3, arc4, circ2);
        final Scene scene = new Scene(root, 800, 600, Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
