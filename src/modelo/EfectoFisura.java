package modelo;

public class EfectoFisura implements Efecto {

	private CampoDeJuego campo; 

	public EfectoFisura(CampoDeJuego unCampo) {
		campo = unCampo;
	}
	

	public void activarse() {
		
		campo.destruirMonstruoDeMenorAtaqueDelOponente();
	}
	

}
