package vista;

import java.io.FileNotFoundException;

import controlador.CambiarDeModoHandler;
import controlador.DragEnCartaDelCampoHandler;
import modelo.CampoDeJuego;
import modelo.Turno;
import modelo.cartas.CartaMonstruo;

public class VistaCartaBocaArribaEnCampoJugador extends VistaCartaBocaArriba {

	
	private CampoDeJuego campoDeCarta;
	
	public VistaCartaBocaArribaEnCampoJugador(CartaMonstruo unaCarta, VistaInfoDeCarta acercamiento, CampoDeJuego campo, Turno turno, VistaJuegoPrincipal vistaJuego) throws FileNotFoundException {
		
		super(unaCarta, 100, acercamiento);
		
		campoDeCarta = campo;
		
		if (turno.puedeAtacar(unaCarta) && unaCarta.estaEnPosicionDeAtaque()) {			
			
			this.setOnDragDetected(new DragEnCartaDelCampoHandler(this));	
		}
		
		
		if (turno.puedeCambiarDeModo(unaCarta)) {
			
			this.setOnMousePressed(new CambiarDeModoHandler(unaCarta, vistaJuego, turno));
		}
		
		
	}
	
	
	public CampoDeJuego getCampo() {
		
		return (campoDeCarta);
	}




}
