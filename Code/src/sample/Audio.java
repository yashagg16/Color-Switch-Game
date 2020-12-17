package sample;
import java.io.File;
import java.nio.file.Paths;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Audio {
    private static Audio sound = null;

    public static Audio getInstance(){
        if(sound == null){
            sound = new Audio();
        }
        return sound;
    }

    public MediaPlayer playMusic(String path, int st, int end){
        File file = new File(path);
        if(file == null){
            System.out.println("Error");
        }
        System.out.println(file.toURI().toString());
        Media media = new  Media(Audio.class.getResource(path).toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setStartTime(Duration.seconds(st));
        mediaPlayer.setStopTime(Duration.seconds(end));
        return mediaPlayer;
    }
}
