package vista;

import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import modelo.Jugador;
import modelo.Mano;
import modelo.cartas.Carta;

public class VistaManoJugador extends HBox {

	
	public VistaManoJugador(Jugador jugador, VistaInfoDeCarta acercamiento) {
		
		int cantidadDeCartas = jugador.cartasEnMano();
		
		Mano mano = jugador.getMano();
		
		
		for (int i = 0; i < cantidadDeCartas; i++) {
			
			try {
				
				Carta cartaActual = mano.obtenerCartaEnPosicion(i);
				
				this.getChildren().add(new VistaCartaBocaArriba(cartaActual, 100, acercamiento));
				
				this.setSpacing(10);
				
				this.setPadding(new Insets(10));
				
			} catch (FileNotFoundException e) {
				
				this.setAlignment(Pos.CENTER);
				
				Text textTop = new Text("Error");
				textTop.setFill(Color.RED);
				this.getChildren().add(textTop);
			}
		}
	}
	
}
