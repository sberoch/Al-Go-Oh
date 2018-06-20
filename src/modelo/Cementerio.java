package modelo;


import java.util.Iterator;
import java.util.LinkedList;

public class Cementerio {
	
	private LinkedList<Carta> cartas = new LinkedList<Carta>();
	
	public void destruirCarta(Carta unaCarta) {
		cartas.add(unaCarta);
	}
	
	public boolean seEncuentra(Carta unaCarta) {
		
		boolean encontrada = false;
		
		Iterator<Carta> iterador = cartas.iterator();
		
		while(iterador.hasNext()) {
			
			Carta estaCarta = iterador.next();
			
			if(estaCarta == unaCarta) {
				
				encontrada = true;
			}
		}
		
		return (encontrada);
	}
}
