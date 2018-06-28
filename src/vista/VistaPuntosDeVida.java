package vista;

import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import modelo.Jugador;
import modelo.cartas.CartaDeCampo;

public class VistaPuntosDeVida extends HBox {
	
	private Jugador jugador;
	private VistaInfoDeCarta acercamiento;
	
	public VistaPuntosDeVida(Jugador jugadorVisto, VistaInfoDeCarta vistaInfoDeCarta) {
		
		jugador = jugadorVisto;
		
		acercamiento = vistaInfoDeCarta;
		
		this.actualizar();
	}

	public void actualizar() {
		
		this.getChildren().clear();
		
		CartaDeCampo cartaCampo = jugador.getCampo().getCartaDeCampo();
		
		try {
			
			VistaCartaBocaArriba vistaCartaCampo = new VistaCartaBocaArriba(cartaCampo, 100, acercamiento);
			
			this.getChildren().add(vistaCartaCampo);
			
		} catch (FileNotFoundException e) {
			

		}
		
		Text vida = new Text();
		
		vida.setText("Vida: " + Integer.toString(jugador.getPuntosDeVida()));
		
		vida.setFill(Color.WHITE);
		
		vida.setStyle("-fx-font: 30 Verdana;");
		
		this.setAlignment(Pos.CENTER);
		
		this.setSpacing(10);
		
		this.setPadding(new Insets(10));
		
		this.setMinWidth(250);

		this.getChildren().add(vida);
		
	}

}
