package modelo;

import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Stack;

import modelo.cartas.Carta;
import modelo.cartas.CartaCilindroMagico;
import modelo.cartas.CartaDeCampo;
import modelo.cartas.CartaDragonDefinitivoDeOjosAzules;
import modelo.cartas.CartaInsectoComeHombres;
import modelo.cartas.CartaJinzo7;
import modelo.cartas.CartaMagica;
import modelo.cartas.CartaMonstruo;
import modelo.cartas.CartaRefuerzos;

public class MazoDeCartas {
	
	
	Stack<Carta> pilaDeCartas = new Stack<Carta>(); 
	
	
	public void llenar(Jugador duenioDelMazo, CampoDeJuego campoDelDuenio) {
		
		pilaDeCartas.push(CartaDeCampo.crearSogen());
		pilaDeCartas.push(CartaDeCampo.crearWasteland());
		
		pilaDeCartas.push(CartaMonstruo.crearDragonBlancoDeOjosAzules());
		pilaDeCartas.push(CartaMonstruo.crearDragonBlancoDeOjosAzules());
		pilaDeCartas.push(CartaMonstruo.crearDragonBlancoDeOjosAzules());
		pilaDeCartas.push(CartaMonstruo.crearCabezaDeExodia());
		pilaDeCartas.push(CartaMonstruo.crearBrazoDerechoExodia());
		pilaDeCartas.push(CartaMonstruo.crearBrazoIzquierdoExodia());
		pilaDeCartas.push(CartaMonstruo.crearPiernaDerechaExodia());
		pilaDeCartas.push(CartaMonstruo.crearPiernaIzquierdaExodia());
		
		pilaDeCartas.push(new CartaMonstruo(800, 600, 3, "HalloHallo"));
		pilaDeCartas.push(new CartaMonstruo(1200, 900, 3, "Espinas De Darkworld"));
		pilaDeCartas.push(new CartaMonstruo(500, 1200, 3, "Espadachin De Landstar"));
		pilaDeCartas.push(new CartaMonstruo(1200, 0, 3, "Chu-Suke El Raton Guerrero"));
		pilaDeCartas.push(new CartaMonstruo(200, 2000, 3, "Chambelan De Los Samurais"));
		pilaDeCartas.push(new CartaMonstruo(1200, 700, 3, "Bebe Dragon"));
		pilaDeCartas.push(new CartaMonstruo(0, 1000, 2, "Ojama Negro"));
		pilaDeCartas.push(new CartaMonstruo(900, 800, 3, "Acechador Del Craneo"));
		pilaDeCartas.push(new CartaMonstruo(1500, 1800, 4, "Gamma el Guerrero Magnetico"));
		pilaDeCartas.push(new CartaMonstruo(1700, 1600, 4, "Beta el Guerrero Magnetico"));
		pilaDeCartas.push(new CartaMonstruo(1400, 1700, 4, "Alfa el Guerrero Magnetico"));
		pilaDeCartas.push(new CartaMonstruo(1200, 1200, 4, "Agresor Oscuro"));
		pilaDeCartas.push(new CartaMonstruo(2000, 1500, 5, "Maldicion De Dragon"));
		pilaDeCartas.push(new CartaMonstruo(2500, 1200, 6, "Craneo Convocado"));
		pilaDeCartas.push(new CartaMonstruo(1200, 3000, 6, "Neo Madoor De Aqua"));
		pilaDeCartas.push(new CartaMonstruo(2500, 2100, 7, "Mago Oscuro"));
		pilaDeCartas.push(new CartaMonstruo(2400, 2000, 7, "Dragon Negro De Ojos Rojos"));
		pilaDeCartas.push(new CartaDragonDefinitivoDeOjosAzules());
		pilaDeCartas.push(new CartaJinzo7());
		pilaDeCartas.push(new CartaInsectoComeHombres());
		pilaDeCartas.push(new CartaCilindroMagico());
		pilaDeCartas.push(new CartaRefuerzos());
		pilaDeCartas.push(new CartaCilindroMagico());
		pilaDeCartas.push(new CartaRefuerzos());
		
		pilaDeCartas.push(CartaMagica.crearOllaDeLaCodicia(duenioDelMazo));
		pilaDeCartas.push(CartaMagica.crearOllaDeLaCodicia(duenioDelMazo));
		pilaDeCartas.push(CartaMagica.crearAgujeroNegro(campoDelDuenio));
		pilaDeCartas.push(CartaMagica.crearFisura(campoDelDuenio));
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
