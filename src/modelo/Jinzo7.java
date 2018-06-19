package modelo;

public class Jinzo7 extends CartaMonstruo {
	
	
	public Jinzo7() {
		
		super(500, 400, 2);
	}
	
	
	protected boolean puedoAtacarDirectoA(Jugador enemigo) {
		
		return (true);
	}

}
