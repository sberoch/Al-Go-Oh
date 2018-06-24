package modelo.cartas;

import modelo.CampoDeJuego;
import modelo.Jugador;
import modelo.efectos.EfectoCampoInicial;
import modelo.efectos.EfectoDeCartaCampo;
import modelo.efectos.EfectoSogen;
import modelo.efectos.EfectoWasteland;
import modelo.estados.EstadoBocaArriba;
import modelo.exceptions.ModoDeInvocacionInvalidoParaEstaCartaException;

public class CartaDeCampo extends Carta {
	
	private EfectoDeCartaCampo efecto;
	
	
	
	private CartaDeCampo(EfectoDeCartaCampo unEfecto, String unNombre, String direccionImagen) {
		
		efecto = unEfecto;
	}
	
	
	public void invocarBocaArriba(Jugador unJugador, CampoDeJuego unCampo) {
		
		estado = new EstadoBocaArriba();
		
		duenio = unJugador;
		
		unCampo.jugarBocaArriba(this);
		
	}

	
	
	public void modificarAtaqueYDefensaDeMonstruoAliado(CartaMonstruo monstruoAliado) {
		
		efecto.modificarAtaqueYDefensaDeMonstruoAliado(monstruoAliado);
	}
	
	
	public void modificarAtaqueYDefensaDeMonstruoEnemigo(CartaMonstruo monstruoEnemigo) {
		
		efecto.modificarAtaqueYDefensaDeMonstruoEnemigo(monstruoEnemigo);
	}
	
	
	public static CartaDeCampo crearCampoInicial() {
		
		EfectoDeCartaCampo efecto = new EfectoCampoInicial();
		
		return (new CartaDeCampo(efecto, null, ""));
	}
	
	
	public static CartaDeCampo crearWasteland() {
		
		EfectoDeCartaCampo efecto = new EfectoWasteland();
		
		return (new CartaDeCampo(efecto, "Wasteland", "images/Wasteland.jpeg"));
	}
	
	
	public static CartaDeCampo crearSogen() {
		
		EfectoDeCartaCampo efecto = new EfectoSogen();
		
		return (new CartaDeCampo(efecto, "Sogen", "images/Sogen.jpeg"));
	}


	public void invocarBocaAbajo(Jugador unJugador, CampoDeJuego unCampo) throws ModoDeInvocacionInvalidoParaEstaCartaException {
		
		throw (new ModoDeInvocacionInvalidoParaEstaCartaException());
		
	}



}
