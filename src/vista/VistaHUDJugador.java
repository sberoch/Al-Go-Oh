package vista;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import modelo.Jugador;

public class VistaHUDJugador extends BorderPane {
	
	public VistaHUDJugador(Jugador jugador, VistaInfoDeCarta acercamiento) {
		
		
		
		HBox vistaMano = new VistaManoJugador(jugador, acercamiento);
		
		HBox vistaPuntosDeVida = new VistaPuntosDeVida(jugador);
		
		this.setLeft(vistaMano);
		
		this.setRight(vistaPuntosDeVida);
	}
		
	public VistaHUDJugador(Jugador oponente) {
		
		HBox vistaMano = new VistaManoEnemiga(oponente);
		
		HBox vistaPuntosDeVida = new VistaPuntosDeVida(oponente);
		
		this.setLeft(vistaMano);
		
		this.setRight(vistaPuntosDeVida);
	}

}
