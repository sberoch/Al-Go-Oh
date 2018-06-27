package vista;

import javafx.scene.layout.BorderPane;
import modelo.Jugador;

public class VistaHUDJugador extends BorderPane {
	
	private VistaManoJugador vistaMano;
	private VistaPuntosDeVida vistaPuntosDeVida;

	public VistaHUDJugador(Jugador jugador, VistaInfoDeCarta acercamiento) {
		
		vistaMano = new VistaManoJugador(jugador, acercamiento);
		
		vistaPuntosDeVida = new VistaPuntosDeVida(jugador);
		
		this.setLeft(vistaMano);
		
		this.setRight(vistaPuntosDeVida);
	}

	public void actualizar() {
		
		vistaMano.actualizar();
		vistaPuntosDeVida.actualizar();
	}

}
