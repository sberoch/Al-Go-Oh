package vista;

import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import modelo.CampoDeJuego;
import modelo.Jugador;
import modelo.cartas.Carta;

public class VistaCartasMonstruoOponente extends HBox {
	
	
	private CampoDeJuego campo;
	
	private VistaInfoDeCarta acercamiento;
	
	private ContenedorJuegoPrincipal vistaDelJuego;
	
	
	public VistaCartasMonstruoOponente(Jugador jugador, ContenedorJuegoPrincipal vistaJuego) {
		
		this.setMinHeight(110);
		
		acercamiento = (VistaInfoDeCarta) vistaJuego.getRight();
		
		campo = jugador.getCampo();
		
		vistaDelJuego = vistaJuego;
		
		this.actualizar();
		
	}

	public void actualizar() {
		
		this.getChildren().clear();
		
		int cantidadDeCartas = campo.obtenerCantidadDeMonstruos();
		
		for (int i = 0; i < cantidadDeCartas; i++) {
			
			try {
				
				Carta cartaActual = campo.obtenerCartaMonstruoEnPosicion(i);
				
				if(cartaActual.estaBocaAbajo()) {
					
					ImageView vistaDeCarta = new VistaCartaBocaAbajoEnDefensaEnCampoEnemigo(cartaActual, vistaDelJuego);
					
					vistaDeCarta.setRotate(180);
					
					this.getChildren().add(vistaDeCarta);
				
				} else {
					
					ImageView vistaDeCarta = new VistaCartaBocaArribaEnCampoEnemigo(cartaActual, acercamiento, vistaDelJuego);
					
					vistaDeCarta.setRotate(180);
					
					this.getChildren().add(vistaDeCarta);
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
