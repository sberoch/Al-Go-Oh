package modelo;

public class EfectoWasteland implements Efecto {
	
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
}