package modelo;

public class EfectoAgujeroNegro implements Efecto {

	CampoDeJuego campo;
	
	
	public EfectoAgujeroNegro(CampoDeJuego unCampo) {
		
		campo = unCampo;
	}
	
	public void activarse() {
		
		campo.destruirTodosLosMonstruos();
	}
}
