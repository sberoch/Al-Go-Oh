package modelo;

public class EfectoWasteland implements EfectoDeCartaCampo {
	
	private CampoDeJuego campo;
	
	public EfectoWasteland(CampoDeJuego unCampo) {
		
		campo = unCampo;
	}

	@Override
	public void activarse() {
		campo.aumentarAtaqueDeLosMonstruos(200);
		
		campo.obtenerCampoEnemigo().aumentarDefensaDeLosMonstruos(300);
	}
	
	public void desactivarse() {
		campo.disminuirAtaqueDeLosMonstruos(200);
		
		campo.obtenerCampoEnemigo().disminuirDefensaDeLosMonstruos(300);
	}
	
	
	public void modificarAtaqueYDefensaDeMonstruoAliado(CartaMonstruo monstruoAliado) {
		
		monstruoAliado.aumentarAtaque(200);
	}
	
	
	public void modificarAtaqueYDefensaDeMonstruoEnemigo(CartaMonstruo monstruoEnemigo) {
		
		monstruoEnemigo.aumentarDefensa(300);
	}
}