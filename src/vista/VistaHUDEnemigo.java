package vista;

import controlador.SeAtacaDirectoHandler;
import controlador.SeQuiereAtacarHandler;
import javafx.scene.layout.BorderPane;
import modelo.Jugador;
import modelo.Turno;

public class VistaHUDEnemigo extends BorderPane {

	
	private VistaManoEnemiga vistaMano;
	private VistaPuntosDeVida vistaPuntosDeVida;

	public VistaHUDEnemigo(Jugador oponente, VistaJuegoPrincipal vistaJuego, Turno turno, VistaInfoDeCarta acercamiento) {
		
		vistaMano = new VistaManoEnemiga(oponente);
		
		vistaPuntosDeVida = new VistaPuntosDeVida(oponente, acercamiento);
		
		this.setLeft(vistaMano);
		
		this.setRight(vistaPuntosDeVida);
		
		this.setOnDragOver(new SeQuiereAtacarHandler());
		
		this.setOnDragDropped(new SeAtacaDirectoHandler(vistaJuego, turno));
	}

	public void actualizar() {
		
		vistaPuntosDeVida.actualizar();
	}
}
