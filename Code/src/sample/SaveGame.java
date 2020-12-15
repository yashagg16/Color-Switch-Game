package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SaveGame {
    @FXML
    private Label g1,g2,g3,g4,g5;
    @FXML
    private TextField name;
    @FXML
    public void Game1Clicked(ActionEvent event){
        Loader game = new Loader();
        games newgame = new games(name.getText(), game.score, game.color,  game.obstacle, game.corX, game.corY);
        GameList.putAnewGame(newgame, "Game1");

    }
    @FXML
    public void Game2Clicked(ActionEvent event){
        Loader game = new Loader();
        games newgame = new games(name.getText(), game.score, game.color,  game.obstacle, game.corX, game.corY);
        GameList.putAnewGame(newgame, "Game2");

    }
    @FXML
    public void Game3Clicked(ActionEvent event){
        Loader game = new Loader();
        games newgame = new games(name.getText(), game.score, game.color,  game.obstacle, game.corX, game.corY);
        GameList.putAnewGame(newgame, "Game3");

    }
    @FXML
    public void Game4Clicked(ActionEvent event){
        Loader game = new Loader();
        games newgame = new games(name.getText(), game.score, game.color,  game.obstacle, game.corX, game.corY);
        GameList.putAnewGame(newgame, "Game4");

    }
    @FXML
    public void Game5Clicked(ActionEvent event){
        Loader game = new Loader();
        games newgame = new games(name.getText(), game.score, game.color,  game.obstacle, game.corX, game.corY);
        GameList.putAnewGame(newgame, "Game5");

    }
    public void init(ActionEvent event){
        GameList.getGames();

        g1.setText("Game 1 : "+GameList.listofGames.get("Game1").name);
        g2.setText("Game 2 : "+GameList.listofGames.get("Game2").name);
        g3.setText("Game 3 : "+GameList.listofGames.get("Game3").name);
        g4.setText("Game 4 : "+GameList.listofGames.get("Game4").name);
        g5.setText("Game 5 : "+GameList.listofGames.get("Game5").name);
    }

}
