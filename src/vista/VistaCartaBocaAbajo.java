package vista;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import controlador.MouseEncimaDeCartaHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.cartas.Carta;

public class VistaCartaBocaAbajo extends ImageView {

	
	public VistaCartaBocaAbajo(int altura) throws FileNotFoundException {
		
		this.setPreserveRatio(true);
		
		this.setImage(new Image(new FileInputStream("images/CartaBocaAbajo.png")));
		
		this.setFitHeight(altura);

	}

	public VistaCartaBocaAbajo(Carta unaCarta, int altura, VistaInfoDeCarta acercamiento) throws FileNotFoundException {
		this.setPreserveRatio(true);
		
		this.setImage(new Image(new FileInputStream("images/CartaBocaAbajo.png")));
		
		this.setOnMouseEntered(new MouseEncimaDeCartaHandler(unaCarta, acercamiento));
		
		this.setFitHeight(altura);
	}
	
}
