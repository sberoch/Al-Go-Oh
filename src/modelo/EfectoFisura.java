package modelo;

public class EfectoFisura implements Efecto {

	private CampoDeJuego campoEnemigo; 

	public EfectoFisura(CampoDeJuego unCampoEnemigo) {
		campoEnemigo = unCampoEnemigo;
	}
	

	public void activarse() {
		
		campoEnemigo.destruirMonstruoDeMenorAtaque();
	}
	

}
