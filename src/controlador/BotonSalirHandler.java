package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonSalirHandler implements EventHandler<ActionEvent> {

	private Stage stage;


	public BotonSalirHandler(Stage stageActual) {
		
		stage = stageActual;
	}
	
	
	public void handle(ActionEvent evento) {

		stage.close();
	}

}
