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
import modelo.Turno;
import modelo.cartas.CartaMonstruo;

public class VistaCartasMonstruoOponente extends HBox {
	
	
	private CampoDeJuego campo;
	
	private VistaInfoDeCarta acercamiento;
	
	private VistaJuegoPrincipal vistaDelJuego;

	private Turno turno;
	
	
	public VistaCartasMonstruoOponente(Jugador jugador, VistaJuegoPrincipal vistaJuego, Turno turnoActual) {
		
		turno = turnoActual;
		
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
				
				CartaMonstruo cartaActual = campo.obtenerCartaMonstruoEnPosicion(i);
				
				if(cartaActual.estaBocaAbajo()) {
					
					ImageView vistaDeCarta = new VistaCartaBocaAbajoEnDefensaEnCampoEnemigo(cartaActual, vistaDelJuego, turno);
					
					vistaDeCarta.setRotate(180);
					
					this.getChildren().add(vistaDeCarta);
				
				} else {
					
					ImageView vistaDeCarta = new VistaCartaBocaArribaEnCampoEnemigo(cartaActual, acercamiento, vistaDelJuego, turno);
					
					vistaDeCarta.setRotate(180);
					
					if (cartaActual.estaEnPosicionDeDefensa()) {
						
						vistaDeCarta.setRotate(90);
					}
					
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
