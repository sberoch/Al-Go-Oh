package controlador;

import java.io.File;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import modelo.Jugador;
import modelo.cartas.Carta;
import vista.VistaJuegoPrincipal;
import vista.VistaCartaBocaArriba;

public class SeInvocaUnaCartaHandler implements EventHandler<DragEvent> {

	private MediaPlayer mediaPlayer;
	
	private Jugador duenio;

	private VistaJuegoPrincipal vistaJuego;
	

	public SeInvocaUnaCartaHandler(Jugador jugador, VistaJuegoPrincipal vistaDelJuego) {
		
		duenio = jugador;
		
		vistaJuego = vistaDelJuego;
		
		String musicFile = "sounds/magia.mp3";    
		
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
	}

	public void handle(DragEvent evento) {
		
		
		if (evento.getDragboard().getString() == "Invocacion" ||
			evento.getDragboard().getString() == "Invocacion boca abajo") {
			
			mediaPlayer.play();
			mediaPlayer.seek(Duration.ZERO);
			
			VistaCartaBocaArriba vistaDeCartaInvocada = (VistaCartaBocaArriba) evento.getGestureSource();
			
			Carta cartaInvocada = vistaDeCartaInvocada.getCarta();
			
			try {
				
				if(evento.getDragboard().getString() == "Invocacion boca abajo") {
					
					duenio.invocarCartaBocaAbajo(cartaInvocada);
					
				} else {
					
					duenio.invocarCartaBocaArriba(cartaInvocada);
				
				}
				
			} catch (Exception e) {

			}
			
			vistaJuego.actualizar();
			
		}
		
	}
	
	
	

}
