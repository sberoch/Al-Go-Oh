package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Turno;
import vista.VistaJuegoPrincipal;

public class PasarAFaseDeAtaqueHandler implements EventHandler<ActionEvent> {

	
	private Turno turno;
	private VistaJuegoPrincipal vistaJuego;
	

	public PasarAFaseDeAtaqueHandler(Turno turnoActual, VistaJuegoPrincipal vistaDelJuego) {
		
		turno = turnoActual;
		
		vistaJuego = vistaDelJuego;
	}

	public void handle(ActionEvent event) {
		
		turno.pasarAFaseDeAtaque();
		
		vistaJuego.actualizar();
	}

}
