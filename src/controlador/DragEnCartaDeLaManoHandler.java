package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import vista.VistaCartaBocaArriba;

public class DragEnCartaDeLaManoHandler implements EventHandler<MouseEvent> {
	
	
	VistaCartaBocaArriba vista;
	
	
	public DragEnCartaDeLaManoHandler(VistaCartaBocaArriba vistaCartaBocaArriba) {
		
		vista = vistaCartaBocaArriba;
	}
	
	public void handle(MouseEvent evento) {
			
		Dragboard dragDeCarta = vista.startDragAndDrop(TransferMode.MOVE);
		
		ClipboardContent contenido = new ClipboardContent();
		
		contenido.putString("Invocacion");
		//		contenido.putString("Invicacion"); ????????????????????????
		
		contenido.putImage(vista.getImage());
		
		dragDeCarta.setContent(contenido);
		
		evento.consume();
	}

}