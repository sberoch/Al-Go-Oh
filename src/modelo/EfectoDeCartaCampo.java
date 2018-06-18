package modelo;

public interface EfectoDeCartaCampo extends Efecto {
	
	
	public void modificarAtaqueYDefensaDeMonstruoAliado(CartaMonstruo monstruoAliado);
	
	
	public void modificarAtaqueYDefensaDeMonstruoEnemigo(CartaMonstruo monstruoEnemigo);

}
