package modelo;

import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Stack;

import modelo.cartas.Carta;
import modelo.cartas.CartaDeCampo;
import modelo.cartas.CartaDragonDefinitivoDeOjosAzules;
import modelo.cartas.CartaInsectoComeHombres;
import modelo.cartas.CartaJinzo7;
import modelo.cartas.CartaMagica;
import modelo.cartas.CartaMonstruo;

public class MazoDeCartas {
	
	
	Stack<Carta> pilaDeCartas = new Stack<Carta>(); 
	
	
	public void llenar(Jugador duenioDelMazo, CampoDeJuego campoDelDuenio) {
		
		pilaDeCartas.push(CartaDeCampo.crearSogen());
		pilaDeCartas.push(CartaDeCampo.crearWasteland());
		pilaDeCartas.push(CartaMonstruo.crearDragonBlancoDeOjosAzules());
		pilaDeCartas.push(CartaMonstruo.crearDragonBlancoDeOjosAzules());
		pilaDeCartas.push(CartaMonstruo.crearDragonBlancoDeOjosAzules());
		pilaDeCartas.push(new CartaDragonDefinitivoDeOjosAzules());
		pilaDeCartas.push(new CartaJinzo7());
		pilaDeCartas.push(new CartaInsectoComeHombres());
		pilaDeCartas.push(CartaMagica.crearOllaDeLaCodicia(duenioDelMazo));
		pilaDeCartas.push(CartaMagica.crearAgujeroNegro(campoDelDuenio));
		pilaDeCartas.push(CartaMagica.crearFisura(campoDelDuenio));
		pilaDeCartas.push(CartaMonstruo.crearCabezaDeExodia());
		pilaDeCartas.push(CartaMonstruo.crearBrazoDerechoExodia());
		pilaDeCartas.push(CartaMonstruo.crearBrazoIzquierdoExodia());
		pilaDeCartas.push(CartaMonstruo.crearPiernaDerechaExodia());
		pilaDeCartas.push(CartaMonstruo.crearPiernaIzquierdaExodia());
		
		
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
