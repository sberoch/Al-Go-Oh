package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import modelo.CampoDeJuego;
import modelo.cartas.CartaMonstruo;
import vista.VistaCartaBocaArribaEnCampoJugador;
import vista.VistaPuntosDeVida;

public class SeAtacaDirectoHandler implements EventHandler<DragEvent> {

	
	private VistaPuntosDeVida vistaVida;

	public SeAtacaDirectoHandler(VistaPuntosDeVida vistaPuntosDeVida) {
		
		vistaVida = vistaPuntosDeVida;
	}

	public void handle(DragEvent evento) {
		
		VistaCartaBocaArribaEnCampoJugador vistaDeCartaAtacante = (VistaCartaBocaArribaEnCampoJugador) evento.getGestureSource();
		
		CartaMonstruo atacante = (CartaMonstruo) vistaDeCartaAtacante.getCarta();
		
		CampoDeJuego campoDeAtacante = vistaDeCartaAtacante.getCampo();
		
		campoDeAtacante.atacarALaVidaConMonstruoEnPosicion(atacante);
		
		vistaVida.actualizar();
		
	}
	
	
	
	
}
