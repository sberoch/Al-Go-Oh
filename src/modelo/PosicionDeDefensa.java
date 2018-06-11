package modelo;

public class PosicionDeDefensa implements PosicionDeMonstruo {

	
	int defensa;
	
	
	
	public PosicionDeDefensa(int unaDefensa) {
		
		defensa = unaDefensa;
	}
	
	
	public boolean esPosicionDeAtaque() {

		return (false);
	}

	
	public boolean esPosicionDeDefensa() {
		
		return (true);
	}
	
	
	public int fuerzaDePelea() {
		
		return (defensa);
	}
	
	
	public int fuerzaDeRetorno() {
		
		return (0);
	}
	
	
	public int obtenerDanioDeAtaque(int unAtaque) {
		
		return (0);
	}

}
