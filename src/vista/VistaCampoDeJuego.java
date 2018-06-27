package vista;

import controlador.SeInvocaUnaCartaHandler;
import controlador.SeQuiereInvocarUnaCartaHandler;
import javafx.scene.layout.VBox;

import modelo.Jugador;

public class VistaCampoDeJuego extends VBox {
	
	
	private Jugador jugadorActual;
	
	private Jugador oponenteActual;
	
	VistaCartasMagicasOponente cartasMagicasOponente;
	VistaCartasMonstruoJugador cartasMonstruoJugador;
	VistaCartasMonstruoOponente cartasMonstruoOponente;
	VistaCartasMagicasJugador cartasMagicasJugador;
	
	public VistaCampoDeJuego(Jugador jugador, Jugador oponente, ContenedorJuegoPrincipal vistaJuego) {

		jugadorActual = jugador;
		
		oponenteActual = oponente;
		
		cartasMagicasOponente = new VistaCartasMagicasOponente(oponenteActual);
		cartasMonstruoJugador = new VistaCartasMonstruoJugador(jugadorActual, vistaJuego);
		cartasMonstruoOponente = new VistaCartasMonstruoOponente(oponenteActual, vistaJuego);
		cartasMagicasJugador = new VistaCartasMagicasJugador(jugadorActual, vistaJuego);
		
		this.getChildren().add(cartasMagicasOponente);
		this.getChildren().add(cartasMonstruoOponente);
		this.getChildren().add(cartasMonstruoJugador);
		this.getChildren().add(cartasMagicasJugador);
		
		this.setOnDragOver(new SeQuiereInvocarUnaCartaHandler());
		
		VistaHUDJugador contenedorDeMano = (VistaHUDJugador) vistaJuego.getBottom();
		
		VistaManoJugador manoDeJugador = (VistaManoJugador) contenedorDeMano.getLeft();
		
		this.setOnDragDropped(new SeInvocaUnaCartaHandler(jugador, this, manoDeJugador));
		
	}

	public void actualizar() {
				
		cartasMagicasOponente.actualizar();
		cartasMonstruoJugador.actualizar();
		cartasMonstruoOponente.actualizar();
		cartasMagicasJugador.actualizar();
		
		
	}
	
	
}
