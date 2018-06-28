package vista;

import javafx.scene.layout.BorderPane;
import modelo.Jugador;
import modelo.Turno;

public class VistaHUDJugador extends BorderPane {
	
	private VistaManoJugador vistaMano;
	private VistaPuntosDeVida vistaPuntosDeVida;

	public VistaHUDJugador(Jugador jugador, VistaInfoDeCarta acercamiento, Turno turno) {
		
		vistaMano = new VistaManoJugador(jugador, acercamiento, turno);
		
		vistaPuntosDeVida = new VistaPuntosDeVida(jugador, acercamiento);
		
		this.setLeft(vistaMano);
		
		this.setRight(vistaPuntosDeVida);
	}

	public void actualizar() {
		
		vistaMano.actualizar();
		vistaPuntosDeVida.actualizar();
	}

}
