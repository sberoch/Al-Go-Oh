package modelo;

public class Jugador {

	private int puntosDeVida = 8000;
	
	
	public int getPuntosDeVida() {
		
		return puntosDeVida;
	}
	
	public void recibirDanio(int unDanio) {
		
		puntosDeVida = puntosDeVida - unDanio;
	}
	
	public void invocarMonstruoEnPosicionDeAtaque(CartaMonstruo monstruo) {
		
		monstruo.invocarEnPosicionDeAtaque(this);
		CampoDeJuego campo = CampoDeJuego.getInstancia();
		campo.agregarAlCampo(monstruo);
	}
	
	public void invocarMonstruoEnPosicionDeDefensa(CartaMonstruo monstruo) {
		
		monstruo.invocarEnPosicionDeDefensa(this);
		CampoDeJuego campo = CampoDeJuego.getInstancia();
		campo.agregarAlCampo(monstruo);
	}
	
	public void atacar(CartaMonstruo miMonstruo,CartaMonstruo otroMonstruo) {
		
		miMonstruo.atacarA(otroMonstruo);
	}
	
	public void invocarCartaMagicaBocaArriba(CartaMagica cartaMagica) {
		
		cartaMagica.invocarBocaArriba();
	}

}
