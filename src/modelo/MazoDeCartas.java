package modelo;

import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Stack;

public class MazoDeCartas {
	
	
	Stack<Carta> pilaDeCartas = new Stack<Carta>(); 
	
	
	public void llenar(Jugador duenioDelMazo, CampoDeJuego campoDelDuenio) {
		
		pilaDeCartas.push(CartaDeCampo.crearSogen());
		pilaDeCartas.push(CartaDeCampo.crearWasteland());
		pilaDeCartas.push(CartaMonstruo.crearDragonBlancoDeOjosAzules());
		pilaDeCartas.push(CartaMonstruo.crearDragonBlancoDeOjosAzules());
		pilaDeCartas.push(CartaMonstruo.crearDragonBlancoDeOjosAzules());
		pilaDeCartas.push(new CartaMonstruoDragonDefinitivoDeOjosAzules());
		pilaDeCartas.push(new CartaMonstruoJinzo7());
		pilaDeCartas.push(new CartaMonstruoInsectoComeHombres());
		pilaDeCartas.push(CartaMagica.crearOllaDeLaCodicia(duenioDelMazo));
		pilaDeCartas.push(CartaMagica.crearAgujeroNegro(campoDelDuenio));
		pilaDeCartas.push(CartaMagica.crearFisura(campoDelDuenio));
		
		
		Collections.shuffle(pilaDeCartas);
	}
	
	public Carta robar() {
		
		try {
			
			return (pilaDeCartas.pop());
			
		} catch (EmptyStackException error) {
			
			return (null);
		}
		
	}

	public boolean estaVacio() {
		
		return (pilaDeCartas.empty());
	}
	
	
}
