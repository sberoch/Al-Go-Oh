package modelo;

public class AgujeroNegro extends CartaMagica {

	public void activarEfecto() {
		CampoDeJuego campo = CampoDeJuego.getInstancia();
		campo.destruirTodos();
	}
}
