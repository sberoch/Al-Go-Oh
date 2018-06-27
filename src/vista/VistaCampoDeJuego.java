package vista;

import controlador.SeInvocaUnaCartaHandler;
import controlador.SeQuiereInvocarUnaCartaHandler;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import modelo.Jugador;

public class VistaCampoDeJuego extends VBox {
	
	
	private Jugador jugadorActual;
	
	private Jugador oponenteActual;
	
	private VistaInfoDeCarta infoDeCarta;
	
	
	public VistaCampoDeJuego(Jugador jugador, Jugador oponente, ContenedorJuegoPrincipal contenedorJuegoPrincipal) {
		
		VistaInfoDeCarta acercamiento = (VistaInfoDeCarta) contenedorJuegoPrincipal.getRight();
		
		VistaHUDJugador contenedorDeManoDeJugador = (VistaHUDJugador) contenedorJuegoPrincipal.getBottom();
		
		VistaManoJugador manoDeJugador = (VistaManoJugador) contenedorDeManoDeJugador.getLeft();
		
		HBox cartasMagicasOponente = new VistaCartasMagicasOponente(oponente);
		HBox cartasMonstruoJugador = new VistaCartasMonstruoJugador(jugador, acercamiento);
		HBox cartasMonstruoOponente = new VistaCartasMonstruoOponente(oponente, acercamiento);
		HBox cartasMagicasJugador = new VistaCartasMagicasJugador(jugador, acercamiento);
		
		this.getChildren().add(cartasMagicasOponente);
		this.getChildren().add(cartasMonstruoOponente);
		this.getChildren().add(cartasMonstruoJugador);
		this.getChildren().add(cartasMagicasJugador);
		
		this.setOnDragOver(new SeQuiereInvocarUnaCartaHandler());
		
		this.setOnDragDropped(new SeInvocaUnaCartaHandler(jugador, this, manoDeJugador));
		
		jugadorActual = jugador;
		
		oponenteActual = oponente;
		
		infoDeCarta = acercamiento;
		
	}

	public void actualizar() {
		
		HBox cartasMagicasOponente = new VistaCartasMagicasOponente(oponenteActual);
		HBox cartasMonstruoJugador = new VistaCartasMonstruoJugador(jugadorActual, infoDeCarta);
		HBox cartasMonstruoOponente = new VistaCartasMonstruoOponente(oponenteActual, infoDeCarta);
		HBox cartasMagicasJugador = new VistaCartasMagicasJugador(jugadorActual, infoDeCarta);
		
		this.getChildren().clear();
		
		
		this.getChildren().add(cartasMagicasOponente);
		this.getChildren().add(cartasMonstruoOponente);
		this.getChildren().add(cartasMonstruoJugador);
		this.getChildren().add(cartasMagicasJugador);
		
		
	}
	
	
}
