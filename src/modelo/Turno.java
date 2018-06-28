package modelo;

public class Turno {

	
	private boolean puedoInvocarUnMonstruo;
	
	private boolean puedoInvocarUnaCartaMagica;
	
	private boolean puedoAtacar;
	
	private boolean puedoPasarAFaseDeAtaque;
	
	private boolean puedoPasarAFaseFinal;
	
	
	public Turno() {
		
		puedoInvocarUnMonstruo = true;
		
		puedoInvocarUnaCartaMagica = true;
		
		puedoAtacar = false;
		
		puedoPasarAFaseDeAtaque = true;
		
		puedoPasarAFaseFinal = true;
	}
	
	public boolean sePuedeActivarCartaMagica() {
		
		return (puedoInvocarUnaCartaMagica);
	}
	
	
	public boolean sePuedeInvocarUnMonstruo() {
		
		return (puedoInvocarUnMonstruo);
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

}
