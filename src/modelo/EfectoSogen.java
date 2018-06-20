package modelo;
	
public class EfectoSogen implements EfectoDeCartaCampo {
	
	
	
	public void modificarAtaqueYDefensaDeMonstruoAliado(CartaMonstruo monstruoAliado) {
		
		monstruoAliado.aumentarDefensa(500);
	}
	
	
	public void modificarAtaqueYDefensaDeMonstruoEnemigo(CartaMonstruo monstruoEnemigo) {
		
		monstruoEnemigo.aumentarAtaque(200);
	}
	
}	