package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Loadmenu {
    @FXML
    private AnchorPane pane;
    @FXML
    private Label G1,G2,G3,G4,G5;
    @FXML
    void BackToMainMenu(ActionEvent event) throws IOException {

        StartMenu startMenu = new StartMenu();
        startMenu.start((Stage) pane.getScene().getWindow());
    }

    @FXML
    public void Game1Clicked(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Gameplay.fxml"));
        AnchorPane pane=fxmlLoader.load();
        Loader loadgame = new Loader(GameList.listofGames.get("Game1").score, GameList.listofGames.get("Game1").color, GameList.listofGames.get("Game1").obstacle,GameList.listofGames.get("Game1").corX,GameList.listofGames.get("Game1").corY);
        //loadgame.bringIn();
        Gameplay controller = fxmlLoader.getController();
        controller.name.setText( GameList.listofGames.get("Game1").name);

        controller.loadfromPause(loadgame,event);
        this.pane.getChildren().setAll(pane);

    }
    @FXML
    public void Game2Clicked(ActionEvent event)throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Gameplay.fxml"));
        AnchorPane pane=fxmlLoader.load();
        Loader loadgame = new Loader(GameList.listofGames.get("Game2").score, GameList.listofGames.get("Game1").color, GameList.listofGames.get("Game1").obstacle,GameList.listofGames.get("Game1").corX,GameList.listofGames.get("Game1").corY);
        //loadgame.bringIn();
        Gameplay controller = fxmlLoader.getController();
        controller.name.setText( GameList.listofGames.get("Game2").name);

        controller.loadfromPause(loadgame,event);
        this.pane.getChildren().setAll(pane);


    }
    @FXML
    public void Game3Clicked(ActionEvent event)throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Gameplay.fxml"));
        AnchorPane pane=fxmlLoader.load();
        Loader loadgame = new Loader(GameList.listofGames.get("Game3").score, GameList.listofGames.get("Game1").color, GameList.listofGames.get("Game1").obstacle,GameList.listofGames.get("Game1").corX,GameList.listofGames.get("Game1").corY);
        //loadgame.bringIn();
        Gameplay controller = fxmlLoader.getController();
        controller.name.setText( GameList.listofGames.get("Game3").name);

        controller.loadfromPause(loadgame,event);
        this.pane.getChildren().setAll(pane);


    }
    @FXML
    public void Game4Clicked(ActionEvent event)throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Gameplay.fxml"));
        AnchorPane pane=fxmlLoader.load();
        Loader loadgame = new Loader(GameList.listofGames.get("Game4").score, GameList.listofGames.get("Game1").color, GameList.listofGames.get("Game1").obstacle,GameList.listofGames.get("Game1").corX,GameList.listofGames.get("Game1").corY);
        //loadgame.bringIn();
        Gameplay controller = fxmlLoader.getController();
        controller.name.setText( GameList.listofGames.get("Game4").name);

        controller.loadfromPause(loadgame,event);
        this.pane.getChildren().setAll(pane);


    }
    @FXML
    public void Game5Clicked(ActionEvent event)throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Gameplay.fxml"));
        AnchorPane pane=fxmlLoader.load();
        Loader loadgame = new Loader(GameList.listofGames.get("Game5").score, GameList.listofGames.get("Game1").color, GameList.listofGames.get("Game1").obstacle,GameList.listofGames.get("Game1").corX,GameList.listofGames.get("Game1").corY);
        //loadgame.bringIn();
        Gameplay controller = fxmlLoader.getController();
        controller.name.setText( GameList.listofGames.get("Game5").name);

        controller.loadfromPause(loadgame,event);
        this.pane.getChildren().setAll(pane);


    }
    public void init(ActionEvent event){
        GameList.getGames();

        G1.setText("Game 1 : "+GameList.listofGames.get("Game1").name);
        G2.setText("Game 2 : "+GameList.listofGames.get("Game2").name);
        G3.setText("Game 3 : "+GameList.listofGames.get("Game3").name);
        G4.setText("Game 4 : "+GameList.listofGames.get("Game4").name);
        G5.setText("Game 5 : "+GameList.listofGames.get("Game5").name);
    }

}
