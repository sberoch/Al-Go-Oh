package modelo.efectos;

import modelo.Jugador;

public class EfectoOllaDeLaCodicia implements Efecto {
	
	private Jugador jugador; 
	
	public EfectoOllaDeLaCodicia(Jugador unJugador) {
		
		jugador = unJugador;
	}


	public void activarse() {
		
		jugador.robarCartaDelMazo();
		jugador.robarCartaDelMazo();
	}
	


}
