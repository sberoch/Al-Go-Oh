package controlador;

import java.io.File;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.DragEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import modelo.CampoDeJuego;
import modelo.Turno;
import modelo.cartas.CartaMonstruo;
import modelo.exceptions.NoSePuedeRealizarAtaqueException;
import vista.VistaJuegoPrincipal;
import vista.VistaCartaBocaArribaEnCampoJugador;

public class SeAtacaDirectoHandler implements EventHandler<DragEvent> {

	
	private VistaJuegoPrincipal vistaJuego;
	private MediaPlayer mediaPlayer;
	private Turno turno;

	public SeAtacaDirectoHandler(VistaJuegoPrincipal vistaDelJuego, Turno turnoActual) {
		
		turno = turnoActual;
		
		vistaJuego = vistaDelJuego;
		
		String musicFile = "sounds/ataque.mp3";    
		
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		
	}

	public void handle(DragEvent evento) {
		
		mediaPlayer.play();
		mediaPlayer.seek(Duration.ZERO);
		
		VistaCartaBocaArribaEnCampoJugador vistaDeCartaAtacante = (VistaCartaBocaArribaEnCampoJugador) evento.getGestureSource();
		
		CartaMonstruo atacante = (CartaMonstruo) vistaDeCartaAtacante.getCarta();
		
		CampoDeJuego campoDeAtacante = vistaDeCartaAtacante.getCampo();
		
		try {
			
			campoDeAtacante.atacarALaVidaConMonstruoEnPosicion(atacante);
			
			turno.atacaLaCarta(atacante);
			
		} catch (NoSePuedeRealizarAtaqueException e) {
			
			Alert alert = new Alert(AlertType.WARNING);
			
			alert.setTitle("No se realizo el ataque");
			alert.setHeaderText("No se puede atacar directo");
			alert.setContentText("El oponente tiene monstruos en el campo");

			alert.showAndWait();
		}
		
		
		vistaJuego.actualizar();
		
	}
	
	
	
	
}
