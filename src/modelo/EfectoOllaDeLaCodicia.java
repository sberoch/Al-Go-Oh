package modelo;

public class EfectoOllaDeLaCodicia implements Efecto {
	
	private Jugador jugador; 
	
	public EfectoOllaDeLaCodicia(Jugador unJugador) {
		jugador = unJugador;
	}

	@Override
	public void activarse() {
		
		jugador.tomarCartaDelMazo();
		jugador.tomarCartaDelMazo();
	}
	
	public void desactivarse() {
		
	}

}
