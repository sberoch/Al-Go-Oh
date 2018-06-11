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
	}
	
	public void atacar(CartaMonstruo miMonstruo,CartaMonstruo otroMonstruo) {
		
		miMonstruo.atacarA(otroMonstruo);
	}
	

}
