package vista;

import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.cartas.Carta;

public class VistaCartaBocaArriba extends ImageView {

	
	public VistaCartaBocaArriba(Carta unaCarta) throws FileNotFoundException {
		
		this.setPreserveRatio(true);
		
		this.setImage(new Image(unaCarta.getImagen()));
		
		this.setFitHeight(100);

	}
	
}
