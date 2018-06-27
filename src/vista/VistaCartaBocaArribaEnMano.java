package vista;

import java.io.FileNotFoundException;

import controlador.DragEnCartaDeLaManoHandler;
import modelo.cartas.Carta;

public class VistaCartaBocaArribaEnMano extends VistaCartaBocaArriba {
	
	
	public VistaCartaBocaArribaEnMano(Carta unaCarta, int altura, VistaInfoDeCarta acercamiento) throws FileNotFoundException {
		
		super(unaCarta, altura, acercamiento);
		
		this.setOnDragDetected(new DragEnCartaDeLaManoHandler(this));
		
	}

}
