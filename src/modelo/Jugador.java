package modelo;

public class Jugador {

	private int puntosDeVida;
	
	private CampoDeJuego campo;
	
	private Cementerio cementerio;
	
	
	
	public Jugador() {
		
		cementerio = new Cementerio();
		
		puntosDeVida = 8000;
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
	
	public void invocarMonstruoEnPosicionDeAtaque(CartaMonstruo monstruo) {
		
		monstruo.invocarEnPosicionDeAtaque(this);

		campo.agregarAlCampo(monstruo);
	}
	
	public void invocarMonstruoEnPosicionDeDefensa(CartaMonstruo monstruo) {
		
		monstruo.invocarEnPosicionDeDefensa(this);

		campo.agregarAlCampo(monstruo);
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

}
