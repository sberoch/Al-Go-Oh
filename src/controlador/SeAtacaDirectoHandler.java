package controlador;

import java.io.File;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import modelo.CampoDeJuego;
import modelo.cartas.CartaMonstruo;
import vista.VistaJuegoPrincipal;
import vista.VistaCartaBocaArribaEnCampoJugador;

public class SeAtacaDirectoHandler implements EventHandler<DragEvent> {

	
	private VistaJuegoPrincipal vistaJuego;
	private MediaPlayer mediaPlayer;

	public SeAtacaDirectoHandler(VistaJuegoPrincipal vistaDelJuego) {
		
		vistaJuego = vistaDelJuego;
		
		String musicFile = "sounds/ataque.wav";    
		
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		
	}

	public void handle(DragEvent evento) {
		
		mediaPlayer.play();
		mediaPlayer.seek(Duration.ZERO);
		
		VistaCartaBocaArribaEnCampoJugador vistaDeCartaAtacante = (VistaCartaBocaArribaEnCampoJugador) evento.getGestureSource();
		
		CartaMonstruo atacante = (CartaMonstruo) vistaDeCartaAtacante.getCarta();
		
		CampoDeJuego campoDeAtacante = vistaDeCartaAtacante.getCampo();
		
		campoDeAtacante.atacarALaVidaConMonstruoEnPosicion(atacante);
		
		vistaJuego.actualizar();
		
	}
	
	
	
	
}
