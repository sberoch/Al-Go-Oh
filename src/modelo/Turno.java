package modelo;

public class Turno {

	
	private Jugador jugador;
	
	private static boolean terminoElJuego;
	
	
	public Turno(Jugador unJugador) {
		
		jugador = unJugador;
		
		terminoElJuego = false;
	}
	
	
	public void jugar() {
		
		if (!terminoElJuego) {
			
			jugador.tomarCartaDelMazo();
			
			if (jugador.gano()) {
				
				terminoElJuego = true;
			}
		}
	}


	public boolean seTerminoElJuego() {
		
		return (terminoElJuego);
	}
	
}
