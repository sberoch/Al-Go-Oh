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

public class VistaCartasMonstruoJugador extends HBox {
	

	private CampoDeJuego campo;
	
	private VistaInfoDeCarta acercamiento;
	
	
	
	
	public VistaCartasMonstruoJugador(Jugador jugador, VistaJuegoPrincipal vistaJuego) {

		this.setMinHeight(110);
		
		acercamiento = (VistaInfoDeCarta) vistaJuego.getRight();

		campo = jugador.getCampo();
		
		this.actualizar();
	}

	public void actualizar() {
		
		this.getChildren().clear();
		
		int cantidadDeCartas = campo.obtenerCantidadDeMonstruos();
		
		for (int i = 0; i < cantidadDeCartas; i++) {
			
			try {
				
				Carta cartaActual = campo.obtenerCartaMonstruoEnPosicion(i);
				
				if(cartaActual.estaBocaAbajo()) {
					
					this.getChildren().add(new VistaCartaBocaAbajoEnDefensa(cartaActual, 100, acercamiento));
				
				} else {
					
					this.getChildren().add(new VistaCartaBocaArribaEnCampoJugador(cartaActual, acercamiento, campo));
				}
				
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
	}

}
