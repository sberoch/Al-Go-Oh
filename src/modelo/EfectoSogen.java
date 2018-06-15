package modelo;

public class EfectoSogen implements Efecto {
	private CampoDeJuego campo;
	
	public EfectoSogen(CampoDeJuego unCampo) {
		campo = unCampo;
	}

	@Override
	public void activarse() {
		campo.aumentarDefensaDeLosMonstruos(500);
		campo.obtenerCampoEnemigo().aumentarAtaqueDeLosMonstruos(200);
	}
}
