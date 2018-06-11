package modelo;

public interface PosicionDeMonstruo {

	
	public boolean esPosicionDeAtaque();
	
	public boolean esPosicionDeDefensa();
	
	public int fuerzaDePelea();
	
	public int fuerzaDeRetorno();
	
	public int obtenerDanioDeAtaque(int unAtaque);
	
}
