package vista;

import controlador.SeAtacaDirectoHandler;
import controlador.SeQuiereAtacarHandler;
import javafx.scene.layout.BorderPane;
import modelo.Jugador;

public class VistaHUDEnemigo extends BorderPane {

	
	private VistaManoEnemiga vistaMano;
	private VistaPuntosDeVida vistaPuntosDeVida;

	public VistaHUDEnemigo(Jugador oponente, VistaJuegoPrincipal vistaJuego) {
		
		vistaMano = new VistaManoEnemiga(oponente);
		
		vistaPuntosDeVida = new VistaPuntosDeVida(oponente);
		
		this.setLeft(vistaMano);
		
		this.setRight(vistaPuntosDeVida);
		
		this.setOnDragOver(new SeQuiereAtacarHandler());
		
		this.setOnDragDropped(new SeAtacaDirectoHandler(vistaJuego));
	}

	public void actualizar() {
		
		vistaPuntosDeVida.actualizar();
	}
}
