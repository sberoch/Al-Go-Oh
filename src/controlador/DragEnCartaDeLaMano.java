package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import modelo.cartas.Carta;
import vista.VistaCartaBocaArriba;

public class DragEnCartaDeLaMano implements EventHandler<MouseEvent> {
	
	
	Carta carta;
	
	VistaCartaBocaArriba vista;
	
	
	public DragEnCartaDeLaMano(Carta unaCarta, VistaCartaBocaArriba vistaCartaBocaArriba) {
		
		carta = unaCarta;
		
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
