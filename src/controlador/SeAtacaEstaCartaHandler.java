package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import modelo.CampoDeJuego;
import modelo.cartas.Carta;
import modelo.cartas.CartaMonstruo;
import vista.ContenedorJuegoPrincipal;
import vista.VistaCampoDeJuego;
import vista.VistaCartaBocaArribaEnCampoJugador;
import vista.VistaHUDEnemigo;
import vista.VistaHUDJugador;
import vista.VistaPuntosDeVida;

public class SeAtacaEstaCartaHandler implements EventHandler<DragEvent> {
	
	
	private CartaMonstruo atacado;
	
	private ContenedorJuegoPrincipal vistaDelJuego;
	
	public SeAtacaEstaCartaHandler(Carta unaCarta, ContenedorJuegoPrincipal vistaJuego) {
		
		atacado = (CartaMonstruo) unaCarta;
		
		vistaDelJuego = vistaJuego;
	}

	
	public void handle(DragEvent evento) {
		
		VistaCartaBocaArribaEnCampoJugador vistaDeCartaAtacante = (VistaCartaBocaArribaEnCampoJugador) evento.getGestureSource();
		
		CartaMonstruo atacante = (CartaMonstruo) vistaDeCartaAtacante.getCarta();
		
		CampoDeJuego campoDeAtacante = vistaDeCartaAtacante.getCampo();
		
		campoDeAtacante.atacarConMonstruoAEnemigo(atacante, atacado);
		
		VistaCampoDeJuego vistaCampoDeJuego = (VistaCampoDeJuego) vistaDelJuego.getCenter();
		
		VistaHUDJugador contenedorDeVidaJugador = (VistaHUDJugador) vistaDelJuego.getBottom();
		VistaPuntosDeVida vidaJugador = (VistaPuntosDeVida) contenedorDeVidaJugador.getRight();
		
		VistaHUDEnemigo contenedorDeVidaOponente = (VistaHUDEnemigo) vistaDelJuego.getTop();
		VistaPuntosDeVida vidaOponente = (VistaPuntosDeVida) contenedorDeVidaOponente.getRight();
		
		vistaCampoDeJuego.actualizar();
		
		vidaJugador.actualizar();
		
		vidaOponente.actualizar();
	}

}
