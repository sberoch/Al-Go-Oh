package modelo.modos;

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
	
	
	public void aumentarAtaque(int unAtaque) {
		
	}
	
	
	public void aumentarDefensa(int unaDefensa) {
		
		defensa += unaDefensa;
	}


	public Modo cambiar(int ataque, int defensa) {
		
		return (new ModoDeAtaque(ataque));
	}


}
