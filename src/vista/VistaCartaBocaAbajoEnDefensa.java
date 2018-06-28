package vista;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import controlador.CambiarDeModoHandler;
import controlador.MouseEncimaDeCartaHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Turno;
import modelo.cartas.Carta;
import modelo.cartas.CartaMonstruo;

public class VistaCartaBocaAbajoEnDefensa extends ImageView {

	
	private CartaMonstruo carta;
	
	
	
	public VistaCartaBocaAbajoEnDefensa(Carta unaCarta, int ancho, VistaInfoDeCarta acercamiento, Turno turno, VistaJuegoPrincipal vistaJuego) throws FileNotFoundException {
		
		carta = (CartaMonstruo) unaCarta;
		
		this.setPreserveRatio(true);
		
		this.setImage(new Image(new FileInputStream("images/CartaBocaAbajoDefensa.png")));
		
		this.setOnMouseEntered(new MouseEncimaDeCartaHandler(unaCarta, acercamiento));
		
		this.setFitWidth(ancho);
		
		if (turno.puedeCambiarDeModo(carta)) {
			
			this.setOnMousePressed(new CambiarDeModoHandler(carta, vistaJuego, turno));
		}

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
