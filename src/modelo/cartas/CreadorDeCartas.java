package modelo.cartas;

public class CreadorDeCartas {

	public static CartaMonstruo crearDragonBlancoDeOjosAzules() {
		CartaMonstruo dragonBlancoDeOjosAzules = new CartaMonstruo(3000, 2500, 8, "Dragon Blanco de Ojos Azules", "images/DragonBlanco.jpeg");
		return dragonBlancoDeOjosAzules;
	}
	
	public static CartaMonstruo crearCabezaDeExodia() {
		CartaMonstruo cabezaDeExodia = new CartaMonstruo(1000, 1000, 3, "Exodia, el Prohibido", "images/CabezaExodia.jpeg");
		return cabezaDeExodia;
	}
	
	public static CartaMonstruo crearBrazoIzquierdoExodia() {
		CartaMonstruo brazoIzquierdo = new CartaMonstruo(200, 300, 1, "Brazo Izquierdo del Prohibido", "images/BrazoIzquierdoExodia.jpeg");		
		return brazoIzquierdo;
	}
	
	public static CartaMonstruo crearBrazoDerechoExodia() {
		CartaMonstruo brazoDerecho = new CartaMonstruo(200, 300, 1, "Brazo Derecho del Prohibido", "images/BrazoDerechoExodia.jpeg");		
		return brazoDerecho;
	}
	
	public static CartaMonstruo crearPiernaIzquierdaExodia() {
		CartaMonstruo piernaIzquierda = new CartaMonstruo(200, 300, 1, "Pierna Izquierda del Prohibido", "images/PiernaIzquierdaExodia.jpeg");		
		return piernaIzquierda;
	}
	
	public static CartaMonstruo crearPiernaDerechaExodia() {
		CartaMonstruo piernaDerecha = new CartaMonstruo(200, 300, 1, "Pierna Derecha del Prohibido", "images/PiernaDerechaExodia.jpeg");
		return piernaDerecha;
	}
	
	
	
	
}
