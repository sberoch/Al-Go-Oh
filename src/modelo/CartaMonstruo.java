package modelo;

public class CartaMonstruo {

	private int ataque;
	protected PosicionDeMonstruo posicion;
	
	
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	
	public int getAtaque() {
		return ataque;
	}
	
	
	public void invocarEnPosicionDeAtaque() {
		
		posicion = new PosicionDeAtaque();
	}
	
	
	public void invocarEnPosicionDeDefensa() {
		
		posicion = new PosicionDeDefensa();
	}
	
	
	public boolean estaEnPosicionDeAtaque() {
		
		return (posicion.esPosicionDeAtaque());
	}
	
	
	public boolean estaEnPosicionDeDefensa() {
		
		return (posicion.esPosicionDeDefensa());
	}
	
	
	public void atacarA(CartaMonstruo otroMonstruo) {
		
		
	}
}
