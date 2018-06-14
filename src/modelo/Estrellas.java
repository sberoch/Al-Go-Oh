package modelo;

public class Estrellas {
	
	private int[] tabulacionSacrificios = {0,0,0,0,1,1,2,2,2};
	private int estrellas;
	
	public Estrellas(int cantidadDeEstrellas) {
		
		estrellas = cantidadDeEstrellas;
	}
	
	public int determinarSacrificios() {
		return tabulacionSacrificios[estrellas - 1];
	}

}
