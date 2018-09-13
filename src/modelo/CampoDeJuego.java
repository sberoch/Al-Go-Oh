package modelo;

import java.util.Iterator;
import java.util.LinkedList;

import modelo.cartas.Carta;
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
	
	
	public void activarCartaMagica(CartaMagica unaCarta) {
		
		unaCarta.activar();
		
		unaCarta.destruir();
		
		magiasYTrampasEnJuego.remove(unaCarta);
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
	
	public void atacarConMonstruoAEnemigo(CartaMonstruo atacante, CartaMonstruo atacado) {

		campoEnemigo.atacarAMonstruoCon(atacado, atacante);
		
		if (atacante.fueDestruida()) {
			
			monstruosEnJuego.remove(atacante);
		}
		
	}
	
	public void atacarAMonstruoCon(CartaMonstruo atacado, CartaMonstruo atacante) {
		
		if (!activarTrampaEnAtaque(atacante, atacado)) {
			
			atacante.atacarA(atacado);
		}
		
		if (atacado.fueDestruida()) {
			
			monstruosEnJuego.remove(atacado);
		}
		
		
	}

	
	private boolean activarTrampaEnAtaque(CartaMonstruo atacante, CartaMonstruo atacado) {
		
		Iterator<CartaMagiaOTrampa> iterator = magiasYTrampasEnJuego.iterator();
		
		boolean seActivo = false;
		
		CartaMagiaOTrampa cartaActual = null;
		
		while (iterator.hasNext() && !seActivo) {
			
			cartaActual = iterator.next();
			
			seActivo = cartaActual.activarEnAtaqueAMonstruo(atacante, atacado);
		
		}
		
		if(seActivo) {
			
			magiasYTrampasEnJuego.remove(cartaActual);	
		}
		
		return (seActivo);
	}

	
	private boolean activarTrampaEnAtaqueDirecto(CartaMonstruo atacante) {
		
		Iterator<CartaMagiaOTrampa> iterator = magiasYTrampasEnJuego.iterator();
		
		boolean seActivo = false;
		
		CartaMagiaOTrampa cartaActual = null;
		
		while (iterator.hasNext() && !seActivo) {
			
			cartaActual = iterator.next();
			
			seActivo = cartaActual.activarEnAtaqueDirecto(atacante);
		}
		
		if(seActivo) {
			
			magiasYTrampasEnJuego.remove(cartaActual);	
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


	public void atacarALaVidaConMonstruoEnPosicion(CartaMonstruo atacante) throws NoSePuedeRealizarAtaqueException {
		
		campoEnemigo.recibirAtaqueDirectoDe(atacante);
		
	}


	public void recibirAtaqueDirectoDe(CartaMonstruo atacante) throws NoSePuedeRealizarAtaqueException {
			

		if (!this.activarTrampaEnAtaqueDirecto(atacante)) {
				
			atacante.atacarA(duenio);
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
	
	
	public int obtenerCantidadDeMagicas() {
		
		return (magiasYTrampasEnJuego.size());
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
				
				if (!monstruo.estaBocaAbajo()) {
					
					monstruoADestruir = monstruo.cartaConMenosAtaqueCon(monstruoADestruir);
					
				}
				
			}
			
			monstruoADestruir.destruir();
			
			monstruosEnJuego.remove(monstruoADestruir);
		}
	}


	public void destruirMonstruoDeMenorAtaqueDelOponente() {
		
		campoEnemigo.destruirMonstruoDeMenorAtaque();
	}



	public Carta obtenerCartaMagicaEnPosicion(int posicion) {
		
		return (magiasYTrampasEnJuego.get(posicion));
	}
	
	public CartaMonstruo obtenerCartaMonstruoEnPosicion(int posicion) {
		
		return (monstruosEnJuego.get(posicion));
	}



	public CartaDeCampo getCartaDeCampo() {
		
		return (cartaCampo);
	}


	
	
}
