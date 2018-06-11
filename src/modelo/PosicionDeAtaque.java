package modelo;

public class PosicionDeAtaque implements PosicionDeMonstruo {
	
	
	private int ataque;
	
	
	
	public PosicionDeAtaque(int unAtaque) {
		
		ataque = unAtaque;
	}
	
	
	
	public boolean esPosicionDeAtaque() {
		
		return (true);
	}
	
	
	public boolean esPosicionDeDefensa() {
		
		return (false);
	}
	
	
	public int fuerzaDePelea() {
		
		return (ataque);
	}
	
	
	public int fuerzaDeRetorno() {
		
		return  (ataque);
	}
	
	
	public int obtenerDanioDeAtaque(int unAtaque) {
		
		return (unAtaque - ataque);
	}
	
}
