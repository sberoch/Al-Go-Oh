package modelo;

public class Estrellas {
	
	private int[] tabulacionSacrificios = {0,0,0,0,1,1,2,2,2};
	private int estrellas;
	
	public void asignarEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}
	
	public int determinarSacrificios() {
		return tabulacionSacrificios[estrellas - 1];
	}

}
