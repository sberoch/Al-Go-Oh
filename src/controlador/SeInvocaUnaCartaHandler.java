package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import modelo.Jugador;
import modelo.cartas.Carta;
import vista.VistaCampoDeJuego;
import vista.VistaCartaBocaArriba;

public class SeInvocaUnaCartaHandler implements EventHandler<DragEvent> {

	
	
	private Jugador duenio;
	
	private VistaCampoDeJuego vistaCampo;

	public SeInvocaUnaCartaHandler(Jugador jugador, VistaCampoDeJuego vistaCampoDeJuego) {

		duenio = jugador;
		
		vistaCampo = vistaCampoDeJuego;
	}

	public void handle(DragEvent evento) {
		
		
		VistaCartaBocaArriba vistaDeCartaInvocada = (VistaCartaBocaArriba) evento.getGestureSource();
		
		Carta cartaInvocada = vistaDeCartaInvocada.getCarta();
		
		try {
			
			duenio.invocarCartaBocaArriba(cartaInvocada);
			
		} catch (Exception e) {

		}
		
		vistaCampo.actualizar();
		
		
	}
	
	
	

}
