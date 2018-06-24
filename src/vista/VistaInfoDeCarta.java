package vista;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import modelo.cartas.Carta;

public class VistaInfoDeCarta extends VBox {
	
	
	Text nombre;
	ImageView imagen;
	
	public VistaInfoDeCarta() {
		
		this.setAlignment(Pos.TOP_CENTER);
		
		nombre = new Text();
		
		try {
			
			imagen = new VistaCartaBocaAbajo(375);
			
		} catch (FileNotFoundException e) {

		}
		
		this.getChildren().add(imagen);
		this.getChildren().add(nombre);
		
	}

	public void mostrarCarta(Carta carta) throws FileNotFoundException {
		
		imagen.setImage(new Image(new FileInputStream(carta.getImagen())));
		
		nombre.setText(carta.getNombre());
	}


}
