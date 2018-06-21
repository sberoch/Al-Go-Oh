package modelo.efectos;

import modelo.cartas.CartaMonstruo;

public interface EfectoDeCartaCampo {
	
	
	public void modificarAtaqueYDefensaDeMonstruoAliado(CartaMonstruo monstruoAliado);
	
	
	public void modificarAtaqueYDefensaDeMonstruoEnemigo(CartaMonstruo monstruoEnemigo);

}
