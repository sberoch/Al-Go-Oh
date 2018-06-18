package modelo;

public class CartaMonstruoConEfecto extends CartaMonstruo {

	private Efecto efecto;
	
	public CartaMonstruoConEfecto(int unAtaque, int unaDefensa, int unasEstrellas, Efecto unEfecto) {
		
		super(unAtaque, unaDefensa, unasEstrellas);
		
		efecto = unEfecto;

	}
}
