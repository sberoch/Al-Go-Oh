package vista;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import controlador.MouseEncimaDeCartaHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.cartas.Carta;

public class VistaCartaBocaAbajoEnDefensa extends ImageView {

	
	private Carta carta;
	
	
	
	public VistaCartaBocaAbajoEnDefensa(Carta unaCarta, int ancho, VistaInfoDeCarta acercamiento) throws FileNotFoundException {
		
		carta = unaCarta;
		
		this.setPreserveRatio(true);
		
		this.setImage(new Image(new FileInputStream("images/CartaBocaAbajoDefensa.png")));
		
		this.setOnMouseEntered(new MouseEncimaDeCartaHandler(unaCarta, acercamiento));
		
		this.setFitWidth(ancho);

	}

	public VistaCartaBocaAbajoEnDefensa(Carta cartaActual, int ancho) throws FileNotFoundException {
		
		this.setPreserveRatio(true);
		
		this.setImage(new Image(new FileInputStream("images/CartaBocaAbajoDefensa.png")));
		
		this.setFitWidth(ancho);
	}
	
	
	public Carta getCarta() {
		
		return (carta);
	}
}
