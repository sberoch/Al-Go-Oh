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
import vista.VistaManoJugador;

public class SeInvocaUnaCartaHandler implements EventHandler<DragEvent> {

	private MediaPlayer mediaPlayer;
	
	private Jugador duenio;
	
	private VistaCampoDeJuego vistaCampo;
	
	private VistaManoJugador vistaMano;

	public SeInvocaUnaCartaHandler(Jugador jugador, VistaCampoDeJuego vistaCampoDeJuego, VistaManoJugador manoDeJugador) {

		duenio = jugador;
		
		vistaCampo = vistaCampoDeJuego;
		
		vistaMano = manoDeJugador;
		
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
		
		vistaMano.actualizar();		
		
	}
	
	
	

}
