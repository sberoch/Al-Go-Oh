package vista;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import modelo.Jugador;
import modelo.Turno;

public class VistaJuegoPrincipal extends BorderPane {
	
	
	private VistaHUDEnemigo vistaHUDEnemigo;
	private VistaInfoDeCarta vistaInfoDeCarta;
	private VistaHUDJugador vistaHUDJugador;
	private VistaCampoDeJuego vistaCampoDeJuego;
	private Jugador jugadorActual;
	private Jugador oponenteActual;
	private Stage stageActual;
	private Turno turno;

	public VistaJuegoPrincipal(Stage stage, Jugador jugador, Jugador oponente) throws Exception {
		
	 	
		jugadorActual = jugador;
		oponenteActual = oponente;
		stageActual = stage;
		turno = new Turno();
		
		jugadorActual.robarCartaDelMazo();
		
		
		//Top
		vistaHUDEnemigo = new VistaHUDEnemigo(oponente, this);
		this.setTop(vistaHUDEnemigo);
		
		//Right
		vistaInfoDeCarta = new VistaInfoDeCarta();
		this.setRight(vistaInfoDeCarta);
		
		
		//Bottom
		vistaHUDJugador = new VistaHUDJugador(jugador, vistaInfoDeCarta, turno);
		this.setBottom(vistaHUDJugador);
		
		
		
		//Center
		vistaCampoDeJuego = new VistaCampoDeJuego(jugador, oponente, this, stage, turno);
		this.setCenter(vistaCampoDeJuego);
		
		
		Image imagen = new Image(new FileInputStream("images/Background.jpeg"));
		BackgroundImage fondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		this.setBackground(new Background(fondo));
		
		
	}

	public void actualizar() {
		
		vistaHUDEnemigo.actualizar();
		vistaHUDJugador.actualizar();
		vistaCampoDeJuego.actualizar();
		if(jugadorActual.gano() || oponenteActual.perdio()) {
		
			PantallaGanador ganaste = null;
			
			try {
				
				ganaste = new PantallaGanador(stageActual);
				
			} catch (FileNotFoundException e) {

			}
			
			stageActual.setScene(new Scene(ganaste, 1600, 900));
			
			stageActual.setFullScreen(true);
		
		} else if(jugadorActual.perdio() || oponenteActual.gano()) {
			
			PantallaDerrota perdiste = null;
			
			try {
			
				perdiste = new PantallaDerrota(stageActual);
			
			} catch (FileNotFoundException e) {
				
			}
		
			stageActual.setScene(new Scene(perdiste, 1600, 900));
			
			stageActual.setFullScreen(true);
		
		}
	}
	
	
}
