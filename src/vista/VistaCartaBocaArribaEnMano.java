package vista;

import java.io.FileNotFoundException;

import controlador.DragEnCartaDeLaManoHandler;
import modelo.Turno;
import modelo.cartas.Carta;

public class VistaCartaBocaArribaEnMano extends VistaCartaBocaArriba {
	
	
	public VistaCartaBocaArribaEnMano(Carta unaCarta, int altura, VistaInfoDeCarta acercamiento, Turno turno) throws FileNotFoundException {
		
		super(unaCarta, altura, acercamiento);
		
		if (turno.puedoInvocar(unaCarta)) {
			
			this.setOnDragDetected(new DragEnCartaDeLaManoHandler(this));
			
		}
		
	}

}
