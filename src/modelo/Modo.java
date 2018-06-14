package modelo;

public interface Modo {

	
	public boolean esModoDeAtaque();
	
	public boolean esModoDeDefensa();
	
	public int fuerzaDePelea();
	
	public int fuerzaDeRetorno();
	
	public int obtenerDanioDeAtaque(int unAtaque);
	
}
