package controlador;

import java.io.File;
import java.io.FileNotFoundException;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import modelo.cartas.Carta;
import vista.VistaInfoDeCarta;

public class MouseEncimaDeCartaHandler implements EventHandler<MouseEvent> {

	Carta carta;
	
	VistaInfoDeCarta infoDeCarta;
	
	MediaPlayer mediaPlayer;
	
	public MouseEncimaDeCartaHandler(Carta unaCarta, VistaInfoDeCarta acercamiento) {
		
		carta = unaCarta;
		
		infoDeCarta = acercamiento;


		String musicFile = "sounds/interaccion_con_carta.mp3";    
		
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		
	}

	public void handle(MouseEvent evento) {
		
		try {
			
			infoDeCarta.mostrarCarta(carta);
			
			mediaPlayer.seek(Duration.ZERO);
			mediaPlayer.play();
			
			
		} catch (FileNotFoundException e) {

		}
		
		
	}
	
}
