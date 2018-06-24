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
import modelo.cartas.CreadorDeCartas;

public class MazoDeCartas {
	
	
	Stack<Carta> pilaDeCartas = new Stack<Carta>(); 
	
	
	public void llenar(Jugador duenioDelMazo, CampoDeJuego campoDelDuenio) {
		
		//Cartas Campo
		pilaDeCartas.push(CartaDeCampo.crearSogen());
		pilaDeCartas.push(CartaDeCampo.crearWasteland());
		
		//Cartas Monstruo Normales
		pilaDeCartas.push(new CartaMonstruo(900, 800, 3, "Raiz de Agua", "images/RaizDeAgua.jpeg"));
		pilaDeCartas.push(new CartaMonstruo(600, 900, 3, "Huevo Monstruoso", "images/HuevoMonstruoso.jpeg"));
		pilaDeCartas.push(new CartaMonstruo(1200, 900, 3, "Espinas De Darkworld", "images/EspinasDarkworld.jpeg"));
		pilaDeCartas.push(new CartaMonstruo(500, 1200, 3, "Espadachin De Landstar", "images/EspadachinLandstar.jpeg"));
		pilaDeCartas.push(new CartaMonstruo(1200, 0, 3, "Chu-Suke El Raton Guerrero", "images/RatonGuerrero.jpeg"));
		pilaDeCartas.push(new CartaMonstruo(200, 2000, 3, "Chambelan De Los Samurais", "images/SamuraiChambelan.jpeg"));
		pilaDeCartas.push(new CartaMonstruo(1200, 700, 3, "Bebe Dragon", "images/BebeDragon.jpeg"));
		pilaDeCartas.push(new CartaMonstruo(0, 1000, 2, "Ojama Negro", "images/Ojama.jpeg"));
		pilaDeCartas.push(new CartaMonstruo(1500, 1800, 4, "Gamma el Guerrero Magnetico", "images/GuerreroGamma.jpeg"));
		pilaDeCartas.push(new CartaMonstruo(1700, 1600, 4, "Beta el Guerrero Magnetico", "images/GuerreroBeta.jpeg"));
		pilaDeCartas.push(new CartaMonstruo(1400, 1700, 4, "Alfa el Guerrero Magnetico", "images/GuerreroAlfa.jpeg"));
		pilaDeCartas.push(new CartaMonstruo(1200, 1200, 4, "Agresor Oscuro", "images/AgresorOscuro.jpeg"));
		pilaDeCartas.push(new CartaMonstruo(2000, 1500, 5, "Maldicion De Dragon", "images/MaldicionDeDragon.jpeg"));
		pilaDeCartas.push(new CartaMonstruo(2500, 1200, 6, "Craneo Convocado", "images/CraneoConvocado.jpeg"));
		pilaDeCartas.push(new CartaMonstruo(1200, 3000, 6, "Neo Madoor De Aqua", "images/AquaMadoor.jpeg"));
		pilaDeCartas.push(new CartaMonstruo(2500, 2100, 7, "Mago Oscuro", "images/MagoOscuro.jpeg"));
		pilaDeCartas.push(new CartaMonstruo(2400, 2000, 7, "Dragon Negro De Ojos Rojos", "images/DragonNegro.jpeg"));
		
		//Cartas Monstruo especiales
		pilaDeCartas.push(CreadorDeCartas.crearDragonBlancoDeOjosAzules());
		pilaDeCartas.push(CreadorDeCartas.crearDragonBlancoDeOjosAzules());
		pilaDeCartas.push(CreadorDeCartas.crearDragonBlancoDeOjosAzules());
		pilaDeCartas.push(CreadorDeCartas.crearCabezaDeExodia());
		pilaDeCartas.push(CreadorDeCartas.crearBrazoDerechoExodia());
		pilaDeCartas.push(CreadorDeCartas.crearBrazoIzquierdoExodia());
		pilaDeCartas.push(CreadorDeCartas.crearPiernaDerechaExodia());
		pilaDeCartas.push(CreadorDeCartas.crearPiernaIzquierdaExodia());
		
		//Cartas Monstruo con Efecto
		pilaDeCartas.push(new CartaDragonDefinitivoDeOjosAzules());
		pilaDeCartas.push(new CartaJinzo7());
		pilaDeCartas.push(new CartaJinzo7());
		pilaDeCartas.push(new CartaInsectoComeHombres());
		
		//Cartas Trampa
		pilaDeCartas.push(new CartaCilindroMagico());
		pilaDeCartas.push(new CartaRefuerzos());
		pilaDeCartas.push(new CartaCilindroMagico());
		pilaDeCartas.push(new CartaRefuerzos());
		
		//Cartas Magicas
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
