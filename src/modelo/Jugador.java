package modelo;

import java.util.LinkedList;

public class Jugador {
	
	private int puntosDeVida;
	
	private CampoDeJuego campo;
	
	private Cementerio cementerio;
	
	private LinkedList<Carta> mano;
	
	private MazoDeCartas mazo;
	
	
	
	
	public Jugador() {
		
		cementerio = new Cementerio();
		
		puntosDeVida = 8000;
		
		mazo = new MazoDeCartas();
		
		mano = new LinkedList<Carta>();
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
	
	public void atacarConMonstruoAMonstruoEnemigoConPosiciones(int posicionAtacante, int posicionAtacado) {
		
		campo.atacarConMonstruoAEnemigo(posicionAtacante, posicionAtacado);
	}
	
	public void invocarCartaMagicaBocaArriba(CartaMagica cartaMagica) {
		
		cartaMagica.invocarBocaArriba(this, campo);
	}
	
	public void invocarCartaDeCampoBocaArriba(CartaDeCampo cartaDeCampo) {
		
		cartaDeCampo.invocarBocaArriba(this, campo);
	}
	
	public void enviarAlCementerio(Carta unaCarta) {
		
		cementerio.destruirCarta(unaCarta);
	}
	
	
	public boolean verificarSiEstaEnElCementerio(Carta unaCarta) {
		
		return (cementerio.seEncuentra(unaCarta));
	}

	public void tomarCartaDelMazo() {
		
		Carta cartaRobada = mazo.robar();
		
		mano.add(cartaRobada);
		
		if(mazo.estaVacio()) {
			//mensaje de fin de partida. metodo de perder
		}
	}
	
	public int cartasEnMano() {
		return (mano.size() );
	}

	public void atacarDirectoALaVidaCon(int posicionDeMonstruo) {
		
		campo.atacarALaVidaConMonstruoEnPosicion(posicionDeMonstruo);
	}


	public boolean tieneMonstruosEnElCampo() {

		return (campo.hayMonstruos());
	}
		
}