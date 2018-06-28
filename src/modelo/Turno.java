package modelo;

import java.util.LinkedList;

import modelo.cartas.Carta;
import modelo.cartas.CartaMonstruo;

public class Turno {

	
	private boolean puedoInvocarUnMonstruo;
	
	private boolean puedoInvocarUnaCartaMagica;
	
	private boolean puedoAtacar;
	
	private boolean puedoPasarAFaseDeAtaque;
	
	private boolean puedoPasarAFaseFinal;
	
	private LinkedList<Carta> cartasQueAtacaron;
	
	
	public Turno() {
		
		puedoInvocarUnMonstruo = true;
		
		puedoInvocarUnaCartaMagica = true;
		
		puedoAtacar = false;
		
		puedoPasarAFaseDeAtaque = true;
		
		puedoPasarAFaseFinal = true;
		
		cartasQueAtacaron = new LinkedList<Carta>();
	}
	
	
	public boolean sePuedeAtacar() {
		
		return (puedoAtacar);
	}
	
	
	public boolean sePuedePasarAFaseDeAtaque() {
		
		return (puedoPasarAFaseDeAtaque);
	}
	
	
	public boolean sePuedePasarAFaseFinal() {
		
		return (puedoPasarAFaseFinal);
	}
	
	
	public void seInvocaUnMOnstruo() {
		
		puedoInvocarUnMonstruo = false;
	}
	
	
	public void pasarAFaseDeAtaque() {
		
		puedoInvocarUnMonstruo = false;
		
		puedoAtacar = true;
		
		puedoInvocarUnaCartaMagica = false;
		
		puedoPasarAFaseDeAtaque = false;
	}
	
	public void pasarAFaseFinal() {
		
		puedoInvocarUnMonstruo = false;
		
		puedoAtacar = false;
		
		puedoInvocarUnaCartaMagica = true;
		
		puedoPasarAFaseDeAtaque = false;
		
		puedoPasarAFaseFinal = false;
	}

	public boolean puedoInvocar(Carta cartaInvocada) {
		
		boolean puedoInvocar;
		
		if (cartaInvocada.esMonstruo()) {
			
			puedoInvocar = puedoInvocarUnMonstruo;
			
			
		} else {
			
			puedoInvocar = puedoInvocarUnaCartaMagica;
		}
		
		return (puedoInvocar);
	}


	public boolean puedeAtacar(Carta unaCarta) {
		
		if (puedoAtacar && !cartasQueAtacaron.contains(unaCarta)) {
			
			return (true);
			
		} else {
			
			return (false);
		}
	}


	public void atacaLaCarta(CartaMonstruo atacante) {
		
		cartasQueAtacaron.add(atacante);
	}

}
