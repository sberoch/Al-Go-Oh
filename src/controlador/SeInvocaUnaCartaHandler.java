package controlador;

import java.io.File;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import modelo.Jugador;
import modelo.cartas.Carta;
import vista.VistaCampoDeJuego;
import vista.VistaCartaBocaArriba;

public class SeInvocaUnaCartaHandler implements EventHandler<DragEvent> {

	private MediaPlayer mediaPlayer;
	
	private Jugador duenio;
	
	private VistaCampoDeJuego vistaCampo;

	public SeInvocaUnaCartaHandler(Jugador jugador, VistaCampoDeJuego vistaCampoDeJuego) {

		duenio = jugador;
		
		vistaCampo = vistaCampoDeJuego;
		
		String musicFile = "sounds/ataque.wav";    
		
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
	}

	public void handle(DragEvent evento) {
		
		
		mediaPlayer.play();
		mediaPlayer.seek(Duration.ZERO);
		
		VistaCartaBocaArriba vistaDeCartaInvocada = (VistaCartaBocaArriba) evento.getGestureSource();
		
		Carta cartaInvocada = vistaDeCartaInvocada.getCarta();
		
		try {
			
			duenio.invocarCartaBocaArriba(cartaInvocada);
			
		} catch (Exception e) {

		}
		
		vistaCampo.actualizar();
		
		
	}
	
	
	

}
