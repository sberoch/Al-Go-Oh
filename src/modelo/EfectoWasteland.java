package modelo;

public class EfectoWasteland implements EfectoDeCartaCampo {
	
	
	
	public void modificarAtaqueYDefensaDeMonstruoAliado(CartaMonstruo monstruoAliado) {
		
		monstruoAliado.aumentarAtaque(200);
	}
	
	
	public void modificarAtaqueYDefensaDeMonstruoEnemigo(CartaMonstruo monstruoEnemigo) {
		
		monstruoEnemigo.aumentarDefensa(300);
	}
}