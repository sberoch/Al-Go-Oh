package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import modelo.Turno;
import modelo.cartas.CartaMonstruo;
import vista.VistaJuegoPrincipal;

public class CambiarDeModoHandler implements EventHandler<MouseEvent> {

	
	
	private VistaJuegoPrincipal vistaJuego;
	
	private Turno turno;

	private CartaMonstruo carta;
	

	public CambiarDeModoHandler(CartaMonstruo unaCarta, VistaJuegoPrincipal vistaDelJuego, Turno turnoActual) {

		carta = unaCarta;
		
		vistaJuego = vistaDelJuego;
		
		turno = turnoActual;
	}

	
	public void handle(MouseEvent evento) {
		
		carta.cambiarDeModo();
		
		turno.seCambioDeModoLaCarta(carta);
		
		vistaJuego.actualizar();
	}

}
