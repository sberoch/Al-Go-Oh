package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import vista.VistaCartaBocaArriba;

public class DragEnCartaDelCampoHandler implements EventHandler<MouseEvent> {

	
	VistaCartaBocaArriba vista;
	
	
	public DragEnCartaDelCampoHandler(VistaCartaBocaArriba vistaCartaBocaArriba) {
		
		vista = vistaCartaBocaArriba;
	}
	
	
	public void handle(MouseEvent evento) {
		
		Dragboard dragDeCarta = vista.startDragAndDrop(TransferMode.ANY);
		
		ClipboardContent contenido = new ClipboardContent();
		
		contenido.putString("Ataque");
		
		contenido.putImage(vista.getImage());
		
		dragDeCarta.setContent(contenido);
		
		evento.consume();
	}
	
}
