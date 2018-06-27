package vista;

import controlador.SeAtacaDirectoHandler;
import controlador.SeQuiereAtacarHandler;
import javafx.scene.layout.BorderPane;
import modelo.Jugador;

public class VistaHUDEnemigo extends BorderPane {

	
	public VistaHUDEnemigo(Jugador oponente) {
		
		VistaManoEnemiga vistaMano = new VistaManoEnemiga(oponente);
		
		VistaPuntosDeVida vistaPuntosDeVida = new VistaPuntosDeVida(oponente);
		
		this.setLeft(vistaMano);
		
		this.setRight(vistaPuntosDeVida);
		
		this.setOnDragOver(new SeQuiereAtacarHandler());
		
		this.setOnDragDropped(new SeAtacaDirectoHandler(vistaPuntosDeVida));
	}
}
