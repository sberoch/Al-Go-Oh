package vista;

import java.io.FileNotFoundException;

import controlador.ActivarCartaMagicaHandler;
import controlador.MouseEncimaDeCartaHandler;
import modelo.CampoDeJuego;
import modelo.cartas.Carta;

public class VistaCartaBocaAbajoJugador extends VistaCartaBocaAbajo {

	public VistaCartaBocaAbajoJugador(Carta unaCarta, int altura, VistaInfoDeCarta acercamiento, CampoDeJuego campo, VistaJuegoPrincipal vistaJuego) throws FileNotFoundException {
		
		super(altura);
			
		this.setOnMouseEntered(new MouseEncimaDeCartaHandler(unaCarta, acercamiento));
		
		if (unaCarta.esMagica()) {
			
			this.setOnMousePressed(new ActivarCartaMagicaHandler(unaCarta, campo, vistaJuego));
		}

	}
	
	
}
