package modelo;

import modelo.cartas.Carta;
import modelo.cartas.CartaDeCampo;
import modelo.cartas.CartaMagica;
import modelo.cartas.CartaMonstruo;
import modelo.cartas.CartaTrampa;

public class Jugador {
	
	private int puntosDeVida;
	
	private CampoDeJuego campo;
	
	private Cementerio cementerio;
	
	private Mano mano;
	
	private MazoDeCartas mazo;
	
	
	
	
	public Jugador() {
		
		cementerio = new Cementerio();
		
		puntosDeVida = 8000;
		
		mazo = new MazoDeCartas();
		
		mano = new Mano();
	}
	
	
	public void invocarCartaBocaArriba(Carta carta) throws Exception {
		
		carta.invocarBocaArriba(this, campo);
		
		mano.removerCarta(carta);
		
	}
	
	public void invocarCartaBocaAbajo(Carta carta) throws Exception {
		
		carta.invocarBocaAbajo(this, campo);
		
		mano.removerCarta(carta);
		
	}
	
	public int getPuntosDeVida() {
		
		return puntosDeVida;
	}
	
	public void asignarCampo(CampoDeJuego unCampo) {
		
		campo = unCampo;
		
		campo.asignarDuenio(this);
	}
	
	
	public void llenarMazo() {
		
		mazo.llenar(this, campo);
	}
	
	
	public void recibirDanio(int unDanio) {
		
		puntosDeVida = puntosDeVida - unDanio;
	}
	
	public void invocarMonstruoEnPosicionDeAtaque(CartaMonstruo monstruo) throws Exception {
		
		monstruo.invocarBocaArriba(this, campo);
		
	}
	
	public void invocarMonstruoEnPosicionDeDefensa(CartaMonstruo monstruo) throws Exception {
		
		monstruo.invocarBocaAbajo(this, campo);
		
	}

	
	public void invocarCartaMagicaBocaArriba(CartaMagica cartaMagica) {
		
		cartaMagica.invocarBocaArriba(this, campo);
	}
	
	public void invocarCartaTrampa(CartaTrampa trampa) {
		
		trampa.invocarBocaAbajo(this, campo);
	}
	
	public void invocarCartaDeCampo(CartaDeCampo cartaDeCampo) {
		
		cartaDeCampo.invocarBocaArriba(this, campo);
	}
	
	public void enviarAlCementerio(Carta unaCarta) {
		
		cementerio.destruirCarta(unaCarta);
	}
	
	
	public boolean verificarSiEstaEnElCementerio(Carta unaCarta) {
		
		return (cementerio.seEncuentra(unaCarta));
	}

	public void robarCartaDelMazo() {
		
		Carta cartaRobada = mazo.robar();
		
		mano.agregarCarta(cartaRobada);
		
		if(mazo.estaVacio()) {
			//mensaje de fin de partida. metodo de perder
		}
	}
	
	public int cartasEnMano() {
		return (mano.obtenerCantidadDeCartas() );
	}

	public void atacarDirectoALaVidaCon(CartaMonstruo atacante) {
		
		campo.atacarALaVidaConMonstruoEnPosicion(atacante);
	}


	public boolean tieneMonstruosEnElCampo() {

		return (campo.hayMonstruos());
	}


	public boolean gano() {
		
		return (mano.estaExodiaCompleto());
	}


	public boolean acaboSuMazo() {

		return (mazo.estaVacio());
	}


	public Mano getMano() {
		
		return (mano);
	}


	public boolean perdio() {
		
		return (this.acaboSuMazo() || (puntosDeVida <= 0));
	}


	public CampoDeJuego getCampo() {
		return campo;
	}
		
}