package vista;

import controlador.SeInvocaUnaCartaHandler;
import controlador.SeQuiereInvocarUnaCartaHandler;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Jugador;
import modelo.Turno;

public class VistaCampoDeJuego extends VBox {
	
	
	private Jugador jugadorActual;
	
	private Jugador oponenteActual;
	
	private VistaCartasMagicasOponente cartasMagicasOponente;
	private VistaCartasMonstruoJugador cartasMonstruoJugador;
	private VistaCartasMonstruoOponente cartasMonstruoOponente;
	private VistaCartasMagicasJugador cartasMagicasJugador;

	private Turno turno;
	
	public VistaCampoDeJuego(Jugador jugador, Jugador oponente, VistaJuegoPrincipal vistaJuego, Stage stage, Turno turnoActual) {

		jugadorActual = jugador;
		
		oponenteActual = oponente;
		
		turno = turnoActual;
		
		cartasMagicasOponente = new VistaCartasMagicasOponente(oponenteActual);
		cartasMonstruoJugador = new VistaCartasMonstruoJugador(jugadorActual, vistaJuego);
		cartasMonstruoOponente = new VistaCartasMonstruoOponente(oponenteActual, vistaJuego);
		cartasMagicasJugador = new VistaCartasMagicasJugador(jugadorActual, vistaJuego);
		
		this.getChildren().add(cartasMagicasOponente);
		this.getChildren().add(cartasMonstruoOponente);
		this.getChildren().add(new BotoneraDeTurno(jugador, oponente, stage, turno));
		this.getChildren().add(cartasMonstruoJugador);
		this.getChildren().add(cartasMagicasJugador);
		
		this.setOnDragOver(new SeQuiereInvocarUnaCartaHandler());
		
		this.setOnDragDropped(new SeInvocaUnaCartaHandler(jugador, vistaJuego));
		
	}

	public void actualizar() {
				
		cartasMagicasOponente.actualizar();
		cartasMonstruoJugador.actualizar();
		cartasMonstruoOponente.actualizar();
		cartasMagicasJugador.actualizar();
		
		
	}
	
	
}
