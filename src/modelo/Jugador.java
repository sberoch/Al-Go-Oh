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
	}
	
	public void recibirDanio(int unDanio) {
		
		puntosDeVida = puntosDeVida - unDanio;
	}
	
	public void invocarMonstruoEnPosicionDeAtaque(CartaMonstruo monstruo) throws Exception {
		
		campo.agregarAlCampo(monstruo);

		monstruo.invocarEnPosicionDeAtaque(this);
		
	}
	
	public void invocarMonstruoEnPosicionDeDefensa(CartaMonstruo monstruo) throws Exception {
		
		campo.agregarAlCampo(monstruo);

		monstruo.invocarEnPosicionDeDefensa(this);
	}
	
	public void atacarConMonstruoAMonstruoEnemigoConPosiciones(int posicionAtacante, int posicionAtacado) {
		
		campo.atacarConMonstruoAEnemigo(posicionAtacante, posicionAtacado);
	}
	
	public void invocarCartaMagicaBocaArriba(CartaMagica cartaMagica) {
		
		cartaMagica.invocarBocaArriba();
	}
	
	
	public void enviarAlCementerio(CartaMonstruo unMonstruo) {
		
		cementerio.destruirCarta(unMonstruo);
	}
	
	
	public boolean verificarSiEstaEnElCementerio(CartaMonstruo monstruo) {
		
		return (cementerio.seEncuentra(monstruo));
	}

	public void tomarCartaDelMazo() {
		
		CartaMonstruo unaCarta = new CartaMonstruo(500, 500, 3);
		mano.add(unaCarta);
	}
	
	public int cartasEnMano() {
		return (mano.size() );
	}
}