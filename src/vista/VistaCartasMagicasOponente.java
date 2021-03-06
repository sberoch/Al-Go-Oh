package vista;

import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import modelo.Jugador;

public class VistaCartasMagicasOponente extends HBox {
	
	private Jugador oponente;
	
	
	
	public VistaCartasMagicasOponente(Jugador oponenteActual) {
		
		oponente = oponenteActual;
		
		this.setMinHeight(110);
		
		this.actualizar();
		
	}

	public void actualizar() {
		
		this.getChildren().clear();
		
		int cantidadDeCartas = oponente.getCampo().obtenerCantidadDeMagicas();
		
		for (int i = 0; i < cantidadDeCartas; i++) {
			
			try {
				
				ImageView vistaDeCarta = new VistaCartaBocaAbajo(100);
				
				vistaDeCarta.setRotate(180);
				
				this.getChildren().add(vistaDeCarta);
				
				this.setSpacing(10);
				
				this.setAlignment(Pos.CENTER);
				
				this.setPadding(new Insets(10));
				
			} catch (FileNotFoundException e) {
				
				this.setAlignment(Pos.CENTER);
				
				Text textTop = new Text("Error");
				textTop.setFill(Color.RED);
				this.getChildren().add(textTop);
			}
		}
		
		this.setSpacing(10);
	}

}
