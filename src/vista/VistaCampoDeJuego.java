package vista;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import modelo.Jugador;

public class VistaCampoDeJuego extends VBox {
	
	
	public VistaCampoDeJuego(Jugador jugador, Jugador oponente, VistaInfoDeCarta acercamiento) {
		
		HBox cartasMagicasOponente = new VistaCartasMagicasOponente(oponente);
		HBox cartasMonstruoJugador = new VistaCartasMonstruoJugador(jugador, acercamiento);
		HBox cartasMonstruoOponente = new VistaCartasMonstruoOponente(oponente, acercamiento);
		HBox cartasMagicasJugador = new VistaCartasMagicasJugador(jugador, acercamiento);
		
		this.getChildren().add(cartasMagicasOponente);
		this.getChildren().add(cartasMonstruoOponente);
		this.getChildren().add(cartasMonstruoJugador);
		this.getChildren().add(cartasMagicasJugador);
		
	}
	
	
}
