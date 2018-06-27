package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import modelo.CampoDeJuego;
import modelo.cartas.Carta;
import modelo.cartas.CartaMagica;
import vista.VistaJuegoPrincipal;

public class ActivarCartaMagicaHandler implements EventHandler<MouseEvent> {

	private CartaMagica carta;
	
	private CampoDeJuego campo;

	private VistaJuegoPrincipal vistaJuego;
	
	
	
	public ActivarCartaMagicaHandler(Carta unaCarta, CampoDeJuego campoJugador, VistaJuegoPrincipal vistaDelJuego) {
		
		carta = (CartaMagica) unaCarta;
		
		campo = campoJugador;
		
		vistaJuego = vistaDelJuego;
	}

	public void handle(MouseEvent evento) {
		
		campo.activarCartaMagica(carta);
		
		vistaJuego.actualizar();
	}

	
	
}
