package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import modelo.Jugador;

public class VistaPuntosDeVida extends HBox {
	
	
	public VistaPuntosDeVida(Jugador jugador) {
		
		Text vida = new Text();
		
		vida.setText("Vida: " + Integer.toString(jugador.getPuntosDeVida()));
		
		vida.setFill(Color.WHITE);
		
		vida.setStyle("-fx-font: 30 Verdana;");
		
		this.setAlignment(Pos.CENTER);
		
		this.setSpacing(10);
		
		this.setPadding(new Insets(10));
		
		this.setMinWidth(250);

		this.getChildren().add(vida);
		
		
	}

}
