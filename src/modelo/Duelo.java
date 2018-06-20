package modelo;

public class Duelo {

	
	private Jugador unJugador;
	
	private Jugador otroJugador;
	
	public Duelo() {
		
		unJugador = new Jugador();
		otroJugador = new Jugador();
		
		CampoDeJuego campo = new CampoDeJuego();
		CampoDeJuego campoEnemigo = new CampoDeJuego();
		
		campo.asignarCampoEnemigo(campoEnemigo);
		campoEnemigo.asignarCampoEnemigo(campo);
		
		unJugador.asignarCampo(campo);
		otroJugador.asignarCampo(campoEnemigo);
		
		unJugador.llenarMazo();
		otroJugador.llenarMazo();
	}
	
}
