package controlador;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;



public class BotonEntrarHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private Scene proximaEscena;
	private MediaPlayer mediaPlayer;
	private MediaPlayer musicaAnterior;


    
    public BotonEntrarHandler(Stage stage, Scene proximaEscena, MediaPlayer mediaPlayerAnterior) {
    	
    	musicaAnterior = mediaPlayerAnterior;
    	
        this.stage = stage;
        this.proximaEscena = proximaEscena;
        
        String musicFile = "sounds/entrar_al_juego.mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
        
    }

    public void handle(ActionEvent actionEvent) {
    	
    	musicaAnterior.dispose();
    	
    	mediaPlayer.seek(Duration.ZERO);
    	mediaPlayer.play();
    	
    	String musicFile = "sounds/MusicaInicio.mp3";
    	AudioClip musicaDeFondo = new AudioClip(new File(musicFile).toURI().toString());
    	musicaDeFondo.play();

    	stage.setScene(proximaEscena);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
        
    }
}