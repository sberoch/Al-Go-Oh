package vista;

import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import modelo.CampoDeJuego;
import modelo.Jugador;
import modelo.cartas.Carta;

public class VistaCartasMagicasJugador extends HBox {

	
	private CampoDeJuego campo;
	
	private VistaInfoDeCarta acercamiento;

	private VistaJuegoPrincipal vistaJuego;
	
	
	
	
	
	public VistaCartasMagicasJugador(Jugador jugador, VistaJuegoPrincipal vistaDelJuego) {

		this.setMinHeight(110);
		
		vistaJuego = vistaDelJuego;
		
		acercamiento = (VistaInfoDeCarta) vistaJuego.getRight();
		
		campo = jugador.getCampo();
		
		this.actualizar();
		
	}

	public void actualizar() {
		
		this.getChildren().clear();
		
		int cantidadDeCartas = campo.obtenerCantidadDeMagicas();
		
		for (int i = 0; i < cantidadDeCartas; i++) {
			
			try {
				
				Carta cartaActual = campo.obtenerCartaMagicaEnPosicion(i);
				
				this.getChildren().add(new VistaCartaBocaAbajoJugador(cartaActual, 100, acercamiento, campo, vistaJuego));
				
				this.setSpacing(10);
				
				this.setAlignment(Pos.CENTER);
				
				this.setPadding(new Insets(10));
				
			} catch (FileNotFoundException e) {
				
				this.setAlignment(Pos.CENTER);
				
				Text textTop = new Text("Error");
				textTop.setFill(Color.RED);
				this.getChildren().add(textTop);
			}
		}
		
		this.setSpacing(10);
	}
}
