package modelo;

public class Jugador {

	private int puntosDeVida = 8000;
	
	
	public int getPuntosDeVida() {
		return puntosDeVida;
	}
	
	public void invocarMonstruoEnPosicionDeAtaque(CartaMonstruo monstruo) {
		monstruo.invocarEnPosicionDeAtaque();
	}
	
	public void atacar(CartaMonstruo miMonstruo,CartaMonstruo otroMonstruo) {
		miMonstruo.atacarA(otroMonstruo);
	}
	

}
