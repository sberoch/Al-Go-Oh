package modelo;

import java.util.LinkedList;

public class Jugador {

	private int puntosDeVida;
	
	private CampoDeJuego campo;
	
	private Cementerio cementerio;
	
	private LinkedList<CartaMonstruo> mano;
	
	
	
	
	public Jugador() {
		
		cementerio = new Cementerio();
		
		puntosDeVida = 8000;
		
		mano = new LinkedList<CartaMonstruo>();
	}
	
	
	public int getPuntosDeVida() {
		
		return puntosDeVida;
	}
	
	public void asignarCampo(CampoDeJuego unCampo) {
		
		campo = unCampo;
		
		campo.asignarDuenio(this);
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
		
		cartaDeCampo.invocarBocaArriba();
		campo.activarCartaDeCampo(cartaDeCampo);
		
	}
	
	public void enviarAlCementerio(Carta unaCarta) {
		
		cementerio.destruirCarta(unaCarta);
	}
	
	
	public boolean verificarSiEstaEnElCementerio(Carta unaCarta) {
		
		return (cementerio.seEncuentra(unaCarta));
	}

	public void tomarCartaDelMazo() {
		
		CartaMonstruo unaCarta = new CartaMonstruo(500, 500, 3);
		mano.add(unaCarta);
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