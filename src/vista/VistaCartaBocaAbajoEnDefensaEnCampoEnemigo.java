package vista;

import java.io.FileNotFoundException;

import controlador.SeAtacaEstaCartaHandler;
import controlador.SeQuiereAtacarHandler;
import modelo.cartas.Carta;

public class VistaCartaBocaAbajoEnDefensaEnCampoEnemigo extends VistaCartaBocaAbajoEnDefensa {

	public VistaCartaBocaAbajoEnDefensaEnCampoEnemigo(Carta unaCarta, VistaJuegoPrincipal vistaJuego) throws FileNotFoundException {
		
		super(unaCarta, 100);
		
		this.setOnDragOver(new SeQuiereAtacarHandler());
		
		this.setOnDragDropped(new SeAtacaEstaCartaHandler(unaCarta, vistaJuego));
		
	}
	
	

}
