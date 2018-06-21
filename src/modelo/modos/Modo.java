package modelo.modos;

public interface Modo {

	
	public boolean esModoDeAtaque();
	
	public boolean esModoDeDefensa();
	
	public int fuerzaDePelea();
	
	public int fuerzaDeRetorno();
	
	public int obtenerDanioDeAtaque(int unAtaque);
	
	public void aumentarAtaque(int unAtaque);
	
	public void aumentarDefensa(int unaDefensa);

	
}
