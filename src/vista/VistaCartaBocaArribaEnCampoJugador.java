package vista;

import java.io.FileNotFoundException;
import controlador.DragEnCartaDelCampoHandler;
import modelo.CampoDeJuego;
import modelo.Turno;
import modelo.cartas.Carta;

public class VistaCartaBocaArribaEnCampoJugador extends VistaCartaBocaArriba {

	
	private CampoDeJuego campoDeCarta;
	
	public VistaCartaBocaArribaEnCampoJugador(Carta unaCarta, VistaInfoDeCarta acercamiento, CampoDeJuego campo, Turno turno) throws FileNotFoundException {
		
		super(unaCarta, 100, acercamiento);
		
		campoDeCarta = campo;
		
		if (turno.puedeAtacar(unaCarta)) {			
			
			this.setOnDragDetected(new DragEnCartaDelCampoHandler(this));
			
		}
		
		
	}
	
	
	public CampoDeJuego getCampo() {
		
		return (campoDeCarta);
	}




}
