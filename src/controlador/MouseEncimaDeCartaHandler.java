package controlador;

import java.io.FileNotFoundException;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import modelo.cartas.Carta;
import vista.VistaInfoDeCarta;

public class MouseEncimaDeCartaHandler implements EventHandler<MouseEvent> {

	Carta carta;
	
	VistaInfoDeCarta infoDeCarta;
	
	public MouseEncimaDeCartaHandler(Carta unaCarta, VistaInfoDeCarta acercamiento) {
		
		carta = unaCarta;
		
		infoDeCarta = acercamiento;
	}

	public void handle(MouseEvent evento) {
		
		try {
			
			infoDeCarta.mostrarCarta(carta);
			
		} catch (FileNotFoundException e) {

		}
	}
	
}
