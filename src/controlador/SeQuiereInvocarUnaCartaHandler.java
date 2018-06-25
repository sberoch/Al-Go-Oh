package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

public class SeQuiereInvocarUnaCartaHandler implements EventHandler<DragEvent> {


	public void handle(DragEvent evento) {
		
        if (evento.getDragboard().getString() == "invocacion") {
           
            evento.acceptTransferModes(TransferMode.ANY);
        }
        
        evento.consume();

	}

}
