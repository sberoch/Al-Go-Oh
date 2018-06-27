package vista;

import java.io.FileNotFoundException;
import controlador.SeAtacaEstaCartaHandler;
import controlador.SeQuiereAtacarEstaCartaHandler;
import modelo.cartas.Carta;

public class VistaCartaBocaArribaEnCampoEnemigo extends VistaCartaBocaArriba {
	
	
	public VistaCartaBocaArribaEnCampoEnemigo(Carta unaCarta, VistaInfoDeCarta acercamiento, ContenedorJuegoPrincipal vistaJuego) throws FileNotFoundException {
		
		super(unaCarta, 100, acercamiento);
		
		this.setOnDragOver(new SeQuiereAtacarEstaCartaHandler());

		this.setOnDragDropped(new SeAtacaEstaCartaHandler(unaCarta, vistaJuego));
	}

}
