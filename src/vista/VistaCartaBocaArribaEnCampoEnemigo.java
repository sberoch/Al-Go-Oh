package vista;

import java.io.FileNotFoundException;
import controlador.SeAtacaEstaCartaHandler;
import controlador.SeQuiereAtacarHandler;
import modelo.Turno;
import modelo.cartas.Carta;

public class VistaCartaBocaArribaEnCampoEnemigo extends VistaCartaBocaArriba {
	
	
	public VistaCartaBocaArribaEnCampoEnemigo(Carta unaCarta, VistaInfoDeCarta acercamiento, VistaJuegoPrincipal vistaJuego, Turno turno) throws FileNotFoundException {
		
		super(unaCarta, 100, acercamiento);
		
		this.setOnDragOver(new SeQuiereAtacarHandler());

		this.setOnDragDropped(new SeAtacaEstaCartaHandler(unaCarta, vistaJuego, turno));
	}

}
