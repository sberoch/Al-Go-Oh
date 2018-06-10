package modelo;


import java.util.Iterator;
import java.util.LinkedList;

public class Cementerio {
	
	private LinkedList<CartaMonstruo> cartas = new LinkedList<>();
	
	public void destruirCarta(CartaMonstruo unaCarta) {
		cartas.add(unaCarta);
	}
	
	public boolean verificarCarta(CartaMonstruo unaCarta) {
		
		boolean encontrada = false;
		
		Iterator<CartaMonstruo> iterador = cartas.iterator();
		while(iterador.hasNext()) {
			CartaMonstruo estaCarta = iterador.next();
			if(estaCarta == unaCarta) {
				encontrada = true;
			}
		}
		return encontrada;
	}
}
