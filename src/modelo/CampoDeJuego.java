package modelo;

import java.util.LinkedList;

public class CampoDeJuego {
	
	private LinkedList<CartaMonstruo> monstruosEnJuego = new LinkedList<CartaMonstruo>();
	
	private LinkedList<CartaMagiaOTrampa> magiasYTrampasEnJuego = new LinkedList<CartaMagiaOTrampa>();
	
	private CampoDeJuego campoEnemigo;

	private CartaDeCampo cartaCampo = CartaDeCampo.crearCampoInicial();
	
	private Jugador duenio;
	
	
	
	
	public void asignarCampoEnemigo(CampoDeJuego campo) {
		
		campoEnemigo = campo;
	}
	
	
	public LinkedList<CartaMonstruo> monstruos() {
		
		return (monstruosEnJuego);
	}
	
	
	
	public CampoDeJuego obtenerCampoEnemigo() {
		
		return (campoEnemigo);
	}
	
	
	public void modificarAtaqueYDefensaDeEnemigo(CartaMonstruo monstruoEnemigo) {
		
		cartaCampo.modificarAtaqueYDefensaDeMonstruoEnemigo(monstruoEnemigo);
	}
	
	
	public void destruirTodosLosMonstruos() {
		
		for (CartaMonstruo monstruo : monstruosEnJuego) {
			
			monstruo.destruir();
		}
		
		monstruosEnJuego.clear();
		
		campoEnemigo.destruirMonstruosPropios();
	}
	
	
	public void destruirMonstruosPropios() {
		
		for (CartaMonstruo monstruo : monstruosEnJuego) {
			
			monstruo.destruir();
		}
		
		monstruosEnJuego.clear();
	}
	
	public void atacarConMonstruoAEnemigo(int posicionDeMonstruo, int posicionDeEnemigo) {
		
		CartaMonstruo cartaAtacante = monstruosEnJuego.get(posicionDeMonstruo - 1);
		
		campoEnemigo.atacarAMonstruoCon(posicionDeEnemigo, cartaAtacante);
		
		if (cartaAtacante.fueDestruida()) {
			
			monstruosEnJuego.remove(posicionDeMonstruo - 1);
		}
		
	}
	
	public void atacarAMonstruoCon(int posicionDeMonstruo, CartaMonstruo atacante) {
		
		CartaMonstruo cartaAtacada = monstruosEnJuego.get(posicionDeMonstruo - 1);
		
		atacante.atacarA(cartaAtacada);
		
		if (cartaAtacada.fueDestruida()) {
			
			monstruosEnJuego.remove(posicionDeMonstruo - 1);
		}
	}


	public void aumentarAtaqueDeLosMonstruos(int valorATK) {
		for (CartaMonstruo monstruo : monstruosEnJuego) {
			monstruo.aumentarAtaque(valorATK);
		}
	}
	
	
	public void aumentarDefensaDeLosMonstruos(int valorDEF) {
		for (CartaMonstruo monstruo : monstruosEnJuego) {
			monstruo.aumentarDefensa(valorDEF);
		}
	}
	
	public void disminuirAtaqueDeLosMonstruos(int valorATK) {
		for (CartaMonstruo monstruo : monstruosEnJuego) {
			monstruo.disminuirAtaque(valorATK);
		}
	}
	
	
	public void disminuirDefensaDeLosMonstruos(int valorDEF) {
		
		for (CartaMonstruo monstruo : monstruosEnJuego) {
			monstruo.disminuirDefensa(valorDEF);
		}
	}


	public CartaDeCampo cartaCampo() {
		
		return cartaCampo;
	}
	
	public void activarCartaDeCampo(CartaDeCampo cartaDeCampo) {
		
		cartaCampo = cartaDeCampo;
	}


	public void atacarALaVidaConMonstruoEnPosicion(int posicionDeMonstruo) {
		
		CartaMonstruo atacante = monstruosEnJuego.get(posicionDeMonstruo - 1);
		
		campoEnemigo.recibirAtaqueDirectoDe(atacante);
		
	}


	public void recibirAtaqueDirectoDe(CartaMonstruo atacante) {
		
		try {
			
			atacante.atacarA(duenio);
			
		} catch (NoSePuedeRealizarAtaqueException error) {
		
			//enviar cartel en UI
		}
	}


	public void asignarDuenio(Jugador unJugador) {

		duenio = unJugador;
	}


	public boolean hayMonstruos() {

		return (!monstruosEnJuego.isEmpty());
	}


	public void jugarBocaAbajo(CartaMagiaOTrampa cartaTrampa) {
		
		magiasYTrampasEnJuego.add(cartaTrampa);
	}


	public void jugarBocaArriba(CartaMagica cartaMagica) {
		
		magiasYTrampasEnJuego.add(cartaMagica);
		
		cartaMagica.activar();
		
		cartaMagica.destruir();
	}


	public void jugarMonstruo(CartaMonstruo monstruo) throws NoHaySuficientesMonstruosException {
		
		int cantMonstruos = monstruosEnJuego.size();
		
		int sacrificios = monstruo.sacrificiosRequeridos();
		
		if (sacrificios > cantMonstruos) {
			throw new NoHaySuficientesMonstruosException();
		}
		
		for(int i = 0; i < sacrificios; i++) {
			monstruosEnJuego.getLast().destruir();
			monstruosEnJuego.removeLast();
		}
		
		monstruosEnJuego.add(monstruo);
		
		cartaCampo.modificarAtaqueYDefensaDeMonstruoAliado(monstruo);
		
		campoEnemigo.modificarAtaqueYDefensaDeEnemigo(monstruo);
		
	}


	
	
}
