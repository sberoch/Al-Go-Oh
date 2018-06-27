package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.Jugador;
import vista.VistaJuegoPrincipal;

public class PasarDeTurnoHandler implements EventHandler<ActionEvent> {

	
	private Stage stageAModificar;
	private Jugador oponente;
	private Jugador jugador;
	
	public PasarDeTurnoHandler(Stage stage, Jugador jugadorActual, Jugador oponenteActual) {
		
		stageAModificar = stage;
		
		oponente = jugadorActual;
		
		jugador = oponenteActual;
		
	}

	public void handle(ActionEvent evento) {
		
		VistaJuegoPrincipal contenedorPrincipal = null;
		
		try {
			
			contenedorPrincipal = new VistaJuegoPrincipal(stageAModificar, jugador, oponente);
			
		} catch (Exception e) {
		}
		
	 	Scene escenaPrincipal = new Scene(contenedorPrincipal, 1600, 900);
	 	
	 	stageAModificar.setScene(escenaPrincipal);
	 	stageAModificar.setFullScreen(true);

	}

}
