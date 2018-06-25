package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import modelo.Jugador;
import modelo.cartas.Carta;
import modelo.cartas.CartaMonstruo;
import vista.VistaCampoDeJuego;
import vista.VistaCartaBocaArriba;

public class SeInvocaUnaCartaHandler implements EventHandler<DragEvent> {

	
	
	private Jugador duenio;
	
	private Jugador jugadorOpuesto;
	
	private VistaCampoDeJuego vistaCampo;

	public SeInvocaUnaCartaHandler(Jugador jugador, Jugador oponente, VistaCampoDeJuego vistaCampoDeJuego) {

		duenio = jugador;
		
		vistaCampo = vistaCampoDeJuego;
	}

	public void handle(DragEvent evento) {
		
		VistaCartaBocaArriba vistaDeCartaInvocada = (VistaCartaBocaArriba) evento.getAcceptingObject();
		
		Carta cartaInvocada = vistaDeCartaInvocada.getCarta();
		
		try {
			
			duenio.invocarMonstruoEnPosicionDeAtaque((CartaMonstruo) cartaInvocada);
			
		} catch (Exception e) {

		}
		
		vistaCampo.actualizar();
		
		
	}
	
	
	

}
