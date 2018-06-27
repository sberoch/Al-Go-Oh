package vista;

import java.io.FileNotFoundException;
import controlador.DragEnCartaDelCampoHandler;
import modelo.CampoDeJuego;
import modelo.cartas.Carta;

public class VistaCartaBocaArribaEnCampoJugador extends VistaCartaBocaArriba {

	
	private CampoDeJuego campoDeCarta;
	
	public VistaCartaBocaArribaEnCampoJugador(Carta unaCarta, VistaInfoDeCarta acercamiento, CampoDeJuego campo) throws FileNotFoundException {
		
		super(unaCarta, 100, acercamiento);
		
		campoDeCarta = campo;
		
		this.setOnDragDetected(new DragEnCartaDelCampoHandler(this));
		
	}
	
	
	public CampoDeJuego getCampo() {
		
		return (campoDeCarta);
	}


}
