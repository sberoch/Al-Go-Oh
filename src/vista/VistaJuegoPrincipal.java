package vista;

import java.io.FileInputStream;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import modelo.Jugador;

public class VistaJuegoPrincipal extends BorderPane {
	
	
	private VistaHUDEnemigo vistaHUDEnemigo;
	private VistaInfoDeCarta vistaInfoDeCarta;
	private VistaHUDJugador vistaHUDJugador;
	private VistaCampoDeJuego vistaCampoDeJuego;

	public VistaJuegoPrincipal(Stage stage, Jugador jugador, Jugador oponente) throws Exception {
		
	 	
		//Top
		vistaHUDEnemigo = new VistaHUDEnemigo(oponente, this);
		this.setTop(vistaHUDEnemigo);
		
		//Right
		vistaInfoDeCarta = new VistaInfoDeCarta();
		this.setRight(vistaInfoDeCarta);
		
		
		//Bottom
		vistaHUDJugador = new VistaHUDJugador(jugador, vistaInfoDeCarta);
		this.setBottom(vistaHUDJugador);
		
		
		
		//Center
		vistaCampoDeJuego = new VistaCampoDeJuego(jugador, oponente, this, stage);
		this.setCenter(vistaCampoDeJuego);
		
		
		Image imagen = new Image(new FileInputStream("images/Background.jpeg"));
		BackgroundImage fondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		this.setBackground(new Background(fondo));
		
		
	}

	public void actualizar() {
		
		vistaHUDEnemigo.actualizar();
		vistaHUDJugador.actualizar();
		vistaCampoDeJuego.actualizar();
		
	}
	
	
}
