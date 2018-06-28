package modelo.cartas;

import modelo.CampoDeJuego;
import modelo.Jugador;
import modelo.efectos.Efecto;
import modelo.efectos.EfectoAgujeroNegro;
import modelo.efectos.EfectoFisura;
import modelo.efectos.EfectoOllaDeLaCodicia;
import modelo.estados.EstadoBocaArriba;

public class CartaMagica extends CartaMagiaOTrampa {
	
	private Efecto efecto;
	
	public CartaMagica(Efecto unEfecto, String unNombre, String direccionDeLaImagen) {
		
		efecto = unEfecto;
		
		nombre = unNombre;
		
		direccionImagen = direccionDeLaImagen;
		
		
	}
	
	

	public void invocarBocaArriba(Jugador unJugador, CampoDeJuego unCampo) {
		
		duenio = unJugador;
		
		estado = new EstadoBocaArriba();
		
		unCampo.jugarBocaArriba(this);
	}
	
	public void activar() {
		
		efecto.activarse();
	}
	
	
	public static CartaMagica crearAgujeroNegro(CampoDeJuego campo) {
		
		Efecto efecto = new EfectoAgujeroNegro(campo);
		
		return (new CartaMagica(efecto, "Agujero Negro", "images/AgujeroNegro.jpeg"));
	}
	
	public static CartaMagica crearOllaDeLaCodicia(Jugador jugador) {
	
		Efecto efecto = new EfectoOllaDeLaCodicia(jugador);
	
		return (new CartaMagica(efecto, "Olla De La Codicia", "images/OllaCodicia.jpeg"));
	}
	
	public static CartaMagica crearFisura(CampoDeJuego campoEnemigo) {
		
		Efecto efecto = new EfectoFisura(campoEnemigo);
	
		return (new CartaMagica(efecto, "Fisura", "images/Fisura.jpeg"));
	}

	
	public boolean esMagica() {
		
		return (true);
	}


	public boolean esMonstruo() {
		
		return (false);
	}
}
