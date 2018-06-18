package modelo;
	
public class EfectoSogen implements EfectoDeCartaCampo {
	
	private CampoDeJuego campo;
	
	public EfectoSogen(CampoDeJuego unCampo) {
		
		campo = unCampo;
	}
	
	public void activarse() {
		campo.aumentarDefensaDeLosMonstruos(500);
		
		campo.obtenerCampoEnemigo().aumentarAtaqueDeLosMonstruos(200);
	}
	
	public void desactivarse() {
		campo.disminuirDefensaDeLosMonstruos(500);
		
		campo.obtenerCampoEnemigo().disminuirAtaqueDeLosMonstruos(200);
	}
	
	
	public void modificarAtaqueYDefensaDeMonstruoAliado(CartaMonstruo monstruoAliado) {
		
		monstruoAliado.aumentarDefensa(500);
	}
	
	
	public void modificarAtaqueYDefensaDeMonstruoEnemigo(CartaMonstruo monstruoEnemigo) {
		
		monstruoEnemigo.aumentarAtaque(200);
	}
	
}	