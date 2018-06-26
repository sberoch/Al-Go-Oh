package controlador;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BotonEntrarEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Scene proximaEscena;
   
	MediaPlayer mediaPlayer;


    
    public BotonEntrarEventHandler(Stage stage, Scene proximaEscena) {
    	
        this.stage = stage;
        this.proximaEscena = proximaEscena;
        
        String musicFile = "sounds/entrar_al_juego.wav";
		
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
        
    }

    
    public void handle(ActionEvent actionEvent) {
    	
    	mediaPlayer.seek(Duration.ZERO);
    	mediaPlayer.play();
    	
        stage.setScene(proximaEscena);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
        
    }
}