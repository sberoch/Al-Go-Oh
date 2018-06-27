package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

public class SeQuiereAtacarHandler implements EventHandler<DragEvent> {
	
	
	public void handle(DragEvent evento) {
		
    	
        if (evento.getDragboard().getString() == "Ataque") {
        	
            evento.acceptTransferModes(TransferMode.ANY);
        }
        
        evento.consume();

	}

}
