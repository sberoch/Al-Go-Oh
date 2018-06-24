package vista;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import controlador.MouseEncimaDeCartaHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.cartas.Carta;

public class VistaCartaBocaArriba extends ImageView {

	
	public VistaCartaBocaArriba(Carta unaCarta, int altura, VistaInfoDeCarta acercamiento) throws FileNotFoundException {
		
		this.setPreserveRatio(true);
		
		this.setImage(new Image(new FileInputStream(unaCarta.getImagen())));
		
		this.setFitHeight(altura);
		
		this.setOnMouseEntered(new MouseEncimaDeCartaHandler(unaCarta, acercamiento));

	}
	
	
	public VistaCartaBocaArriba(Carta unaCarta, int altura) throws FileNotFoundException {
		
		this.setPreserveRatio(true);
		
		this.setImage(new Image(unaCarta.getImagen()));
		
		this.setFitHeight(altura);

	}
	
}
