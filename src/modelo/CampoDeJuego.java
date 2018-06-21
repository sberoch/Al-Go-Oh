package modelo;

import java.util.Iterator;
import java.util.LinkedList;

import modelo.cartas.CartaDeCampo;
import modelo.cartas.CartaMagiaOTrampa;
import modelo.cartas.CartaMagica;
import modelo.cartas.CartaMonstruo;
import modelo.exceptions.NoHaySuficientesMonstruosException;
import modelo.exceptions.NoSePuedeRealizarAtaqueException;

public class CampoDeJuego {
	
	private LinkedList<CartaMonstruo> monstruosEnJuego = new LinkedList<CartaMonstruo>();
	
	private LinkedList<CartaMagiaOTrampa> magiasYTrampasEnJuego = new LinkedList<CartaMagiaOTrampa>();
	
	private CampoDeJuego campoEnemigo;

	private CartaDeCampo cartaCampo = CartaDeCampo.crearCampoInicial();
	
	private Jugador duenio;
	
	
	
	
	public void asignarCampoEnemigo(CampoDeJuego campo) {
		
		campoEnemigo = campo;
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
		
		if (!activarTrampaEnAtaque(atacante, cartaAtacada)) {
			
			atacante.atacarA(cartaAtacada);
		}
	}

	
	private boolean activarTrampaEnAtaque(CartaMonstruo atacante, CartaMonstruo atacado) {
		
		Iterator<CartaMagiaOTrampa> iterator = magiasYTrampasEnJuego.iterator();
		
		boolean seActivo = false;
		
		while (iterator.hasNext() && !seActivo) {
			
			CartaMagiaOTrampa cartaActual = iterator.next();
			
			seActivo = cartaActual.activarEnAtaqueAMonstruo(atacante, atacado);
		}
		
		return (seActivo);
	}

	
	private boolean activarTrampaEnAtaqueDirecto(CartaMonstruo atacante) {
		
		Iterator<CartaMagiaOTrampa> iterator = magiasYTrampasEnJuego.iterator();
		
		boolean seActivo = false;
		
		while (iterator.hasNext() && !seActivo) {
			
			CartaMagiaOTrampa cartaActual = iterator.next();
			
			seActivo = cartaActual.activarEnAtaqueDirecto(atacante);
		}
		
		return (seActivo);
	}


	public void jugarBocaArriba(CartaDeCampo cartaDeCampo) {
		
		cartaCampo = cartaDeCampo;
		
		for (CartaMonstruo monstruo : monstruosEnJuego) {
			
			cartaCampo.modificarAtaqueYDefensaDeMonstruoAliado(monstruo);
		}
		
		campoEnemigo.modificarAtaqueYDefensaDeMonstruos();
		
	}


	public void modificarAtaqueYDefensaDeMonstruos() {
	
		for (CartaMonstruo monstruo : monstruosEnJuego) {
			
			campoEnemigo.modificarAtaqueYDefensaDeEnemigo(monstruo);
		}
	}


	public void atacarALaVidaConMonstruoEnPosicion(int posicionDeMonstruo) {
		
		CartaMonstruo atacante = monstruosEnJuego.get(posicionDeMonstruo - 1);
		
		campoEnemigo.recibirAtaqueDirectoDe(atacante);
		
	}


	public void recibirAtaqueDirectoDe(CartaMonstruo atacante) {
		
		try {
			
			if (!this.activarTrampaEnAtaqueDirecto(atacante)) {
				
				atacante.atacarA(duenio);
			}
			
			
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
		
		magiasYTrampasEnJuego.removeLast();
	}


	public void jugarMonstruo(CartaMonstruo monstruo) throws NoHaySuficientesMonstruosException {
		
		
		monstruosEnJuego.add(monstruo);
		
		cartaCampo.modificarAtaqueYDefensaDeMonstruoAliado(monstruo);
		
		campoEnemigo.modificarAtaqueYDefensaDeEnemigo(monstruo);
		
	}
	
	
	public int obtenerCantidadDeMonstruos() {
		
		return (monstruosEnJuego.size());
	}
	
	
	public void destruirUnMonstruo() {
		
		monstruosEnJuego.getLast().destruir();
		monstruosEnJuego.removeLast();
	}


	public int obtenerCantidadDeMonstruosConNombre(String unNombre) {
		
		int cantidad = 0;
		
		Iterator<CartaMonstruo> iterator = monstruosEnJuego.iterator();
		
		while (iterator.hasNext()) {
			
			CartaMonstruo monstruoActual = iterator.next();
			
			if (monstruoActual.tieneDeNombre(unNombre)) {
				
				cantidad++;
			}
		}
		
		return (cantidad);
	}


	public void destruirUnMonstruoConNombre(String unNombre) {
		
		Iterator<CartaMonstruo> iterator = monstruosEnJuego.iterator();
		
		boolean fueDestruido = false;
		
		while (iterator.hasNext() && !fueDestruido) {
			
			CartaMonstruo monstruoActual = iterator.next();
			
			if (monstruoActual.tieneDeNombre(unNombre)) {
				
				monstruoActual.destruir();
				
				monstruosEnJuego.remove(monstruoActual);
				
				fueDestruido = true;
			}
		}
	}


	public void destruirMonstruoDeMenorAtaque() {
		
		if (this.hayMonstruos()) {
			
			CartaMonstruo monstruoADestruir = monstruosEnJuego.getFirst();
			
			for (CartaMonstruo monstruo : monstruosEnJuego) {
				
				monstruoADestruir = monstruo.cartaConMenosAtaqueCon(monstruoADestruir);
			}
			
			monstruoADestruir.destruir();
			
			monstruosEnJuego.remove(monstruoADestruir);
		}
	}


	public void destruirMonstruoDeMenorAtaqueDelOponente() {
		
		campoEnemigo.destruirMonstruoDeMenorAtaque();
	}


	
	
}
