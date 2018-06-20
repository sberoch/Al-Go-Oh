package modelo;

public class EfectoOllaDeLaCodicia implements Efecto {
	
	private Jugador jugador; 
	
	public EfectoOllaDeLaCodicia(Jugador unJugador) {
		
		jugador = unJugador;
	}


	public void activarse() {
		
		jugador.tomarCartaDelMazo();
		jugador.tomarCartaDelMazo();
	}
	


}
