package vista;

import java.io.FileNotFoundException;

import controlador.SeAtacaEstaCartaHandler;
import controlador.SeQuiereAtacarEstaCartaHandler;
import modelo.cartas.Carta;

public class VistaCartaBocaAbajoEnDefensaEnCampoEnemigo extends VistaCartaBocaAbajoEnDefensa {

	public VistaCartaBocaAbajoEnDefensaEnCampoEnemigo(Carta unaCarta, ContenedorJuegoPrincipal vistaJuego) throws FileNotFoundException {
		
		super(unaCarta, 100);
		
		this.setOnDragOver(new SeQuiereAtacarEstaCartaHandler());
		
		this.setOnDragDropped(new SeAtacaEstaCartaHandler(unaCarta, vistaJuego));
		
	}
	
	

}
