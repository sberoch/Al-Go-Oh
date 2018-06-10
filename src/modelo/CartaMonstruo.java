package modelo;

public class CartaMonstruo {

	
	protected PosicionDeMonstruo posicion;
	
	
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
	
}
