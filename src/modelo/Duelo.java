package modelo;

public class Duelo {

	
	private Turno turnoDeUnJugador;
	
	private Turno turnoDeOtroJugador;
	
	public Duelo() {
		
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		
		CampoDeJuego campo = new CampoDeJuego();
		CampoDeJuego campoEnemigo = new CampoDeJuego();
		
		campo.asignarCampoEnemigo(campoEnemigo);
		campoEnemigo.asignarCampoEnemigo(campo);
		
		unJugador.asignarCampo(campo);
		otroJugador.asignarCampo(campoEnemigo);
		
		unJugador.llenarMazo();
		otroJugador.llenarMazo();
		
		turnoDeUnJugador = new Turno(unJugador);
		turnoDeOtroJugador = new Turno(otroJugador);
		
	}
	
	
	
	public void iniciarDuelo() {
		
		while(!this.dueloTerminado()) {
			
			turnoDeUnJugador.jugar();
			turnoDeOtroJugador.jugar();
		}
	}



	public boolean dueloTerminado() {

		return (turnoDeUnJugador.seTerminoElJuego());
	}
	
}
