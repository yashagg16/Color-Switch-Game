package sample;

import java.io.*;
import java.util.HashMap;

public class GameList {
    public static HashMap<String, games> listofGames = new HashMap<>();
    public static HashMap<String, games> getGames(){
        try {
            FileInputStream BringIn = new FileInputStream("SavedGames.txt");
            ObjectInputStream in = new ObjectInputStream(BringIn);
            for(int i = 1; i<=5 ; ++i) {
                games temp = (games) in.readObject();
                listofGames.put("Game"+i, temp);
            }
            in.close();
            BringIn.close();


        }
        catch (IOException i){

        }
        catch (ClassNotFoundException i){

        }
        return listofGames;
    }
    public static void putGames(){
        try {
            FileOutputStream WriteOut = new FileOutputStream("SavedGames.txt");
            ObjectOutputStream out = new ObjectOutputStream(WriteOut);

            for(int i = 1; i<=5 ; ++i) {
                out.writeObject(listofGames.get("Game"+i));
                }
            out.close();
            WriteOut.close();
        }
        catch(IOException e){

        }
    }
    public static void putAnewGame(games game, String id){
        getGames();
        listofGames.put(id,game);
        putGames();
    }
    public static void main(String[] args){
        listofGames.put("Game1", new games("Shashank", 12, 1,2,100,200));
        listofGames.put("Game2", new games("Yash", 15, 1,2,100,200));
        listofGames.put("Game3", new games("BadBoy", 18, 1,2,100,200));
        listofGames.put("Game4", new games("Shounak", 10, 1,2,100,200));
        listofGames.put("Game5", new games("Anony", 7, 1,2,100,200));
        putGames();
    }

}
class games implements Serializable{
    int score;
    int color;
    int obstacle;
    double corX,corY;
    String name;

    games(String ne ,int s,int c, int ob ,double x, double y){
        name = ne;
        score = s;
        color = c;
        obstacle = ob;
        corX = x;
        corY = y;
    }
}