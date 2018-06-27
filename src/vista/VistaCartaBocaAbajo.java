package vista;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaCartaBocaAbajo extends ImageView {

	
	public VistaCartaBocaAbajo(int altura) throws FileNotFoundException {
		
		this.setPreserveRatio(true);
		
		this.setImage(new Image(new FileInputStream("images/CartaBocaAbajo.png")));
		
		this.setFitHeight(altura);

	}
	
}
