package vista;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import modelo.cartas.Carta;

public class VistaInfoDeCarta extends VBox {
	
	
	Text nombre;
	Text ataque;
	Text defensa;
	ImageView imagen;
	
	public VistaInfoDeCarta() {
		
		this.setAlignment(Pos.CENTER);
		
		nombre = new Text();
		ataque = new Text();
		defensa = new Text();
		
		try {
			
			imagen = new VistaCartaBocaAbajo(375);
			
		} catch (FileNotFoundException e) {

		}
		
		this.getChildren().add(imagen);
		this.getChildren().add(nombre);
		this.getChildren().add(ataque);
		this.getChildren().add(defensa);
		
	}

	public void mostrarCarta(Carta carta) throws FileNotFoundException {
		
		imagen.setImage(new Image(new FileInputStream(carta.getImagen())));
		
		nombre.setText(carta.getNombre());
		nombre.setStyle("-fx-font: 16 Verdana;");
		nombre.setFill(Color.WHITE);
		
		if (carta.esMonstruo()) {
			
			ataque.setText("Ataque: " + String.valueOf(carta.ataque()));
			ataque.setStyle("-fx-font: 16 Verdana;");
			ataque.setFill(Color.WHITE);
			
			defensa.setText("Defensa: " + String.valueOf(carta.defensa()));
			defensa.setStyle("-fx-font: 16 Verdana;");
			defensa.setFill(Color.WHITE);
			
		} else {
			
			ataque.setText("");
			defensa.setText("");
		}
	}


}
