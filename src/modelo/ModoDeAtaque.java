package modelo;

public class ModoDeAtaque implements Modo {
	
	
	private int ataque;
	
	
	
	public ModoDeAtaque(int unAtaque) {
		
		ataque = unAtaque;
	}
	
	
	
	public boolean esModoDeAtaque() {
		
		return (true);
	}
	
	
	public boolean esModoDeDefensa() {
		
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
	
	
	public void aumentarAtaque(int unAtaque) {
		
		ataque += unAtaque;
	}
	
	
	public void aumentarDefensa(int unaDefensa) {
		
	}
	
	
	public void disminuirAtaque(int unAtaque) {
		
		ataque -= unAtaque;
	}
	
	
	public void disminuirDefensa(int unaDefensa) {
		
	}
	
}
