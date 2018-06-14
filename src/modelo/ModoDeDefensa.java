package modelo;

public class ModoDeDefensa implements Modo {

	
	int defensa;
	
	
	
	public ModoDeDefensa(int unaDefensa) {
		
		defensa = unaDefensa;
	}
	
	
	public boolean esModoDeAtaque() {

		return (false);
	}

	
	public boolean esModoDeDefensa() {
		
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