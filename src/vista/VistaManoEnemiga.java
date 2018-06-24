package vista;

import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import modelo.Jugador;

public class VistaManoEnemiga extends HBox {
	
	
	

	public VistaManoEnemiga(Jugador oponente) {
		
		int cantidadDeCartas = oponente.cartasEnMano();
		
		
		for (int i = 0; i < cantidadDeCartas; i++) {
			
			try {
				
				this.getChildren().add(new VistaCartaBocaAbajo(100));
				
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
