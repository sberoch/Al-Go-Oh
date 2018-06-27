package controlador;

import java.io.File;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import modelo.CampoDeJuego;
import modelo.cartas.Carta;
import modelo.cartas.CartaMonstruo;
import vista.VistaJuegoPrincipal;
import vista.VistaCartaBocaArribaEnCampoJugador;

public class SeAtacaEstaCartaHandler implements EventHandler<DragEvent> {
	
	
	private CartaMonstruo atacado;
	
	private VistaJuegoPrincipal vistaJuego;

	private MediaPlayer mediaPlayer;
	
	public SeAtacaEstaCartaHandler(Carta unaCarta, VistaJuegoPrincipal vistaDelJuego) {
		
		atacado = (CartaMonstruo) unaCarta;
		
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
		
		campoDeAtacante.atacarConMonstruoAEnemigo(atacante, atacado);
		
		vistaJuego.actualizar();
	}

}
