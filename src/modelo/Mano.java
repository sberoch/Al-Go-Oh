package modelo;

import java.util.Iterator;
import java.util.LinkedList;

public class Mano {
	
	private LinkedList<Carta> mano = new LinkedList<Carta>();

	public void agregarCarta(Carta cartaRobada) {
		
		mano.add(cartaRobada);
	
	}

	public int obtenerCantidadDeCartas() {
		
		return (mano.size());
	}
	
	public boolean estaExodiaCompleto() {
		
		return (this.estaLaParteDeExodia("Exodia, el Prohibido") &&
				this.estaLaParteDeExodia("Brazo Izquierdo del Prohibido") &&
				this.estaLaParteDeExodia("Brazo Derecho del Prohibido") &&
				this.estaLaParteDeExodia("Pierna Izquierda del Prohibido") &&
				this.estaLaParteDeExodia("Pierna Derecha del Prohibido"));
	}

	private boolean estaLaParteDeExodia(String parteDeExodia) {
		
		boolean encontrado = false;
		
		Iterator<Carta> iterator = mano.iterator();
		
		while (iterator.hasNext() && !encontrado) {
			
			Carta carta = iterator.next();
			
			if(carta.tieneDeNombre(parteDeExodia)) {
				encontrado = true;
			}
		}
		
		return encontrado;
	}
	
	
	
	
}
