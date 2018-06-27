package vista;

import java.io.FileInputStream;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import modelo.CampoDeJuego;
import modelo.Jugador;
import modelo.cartas.CartaCilindroMagico;
import modelo.cartas.CartaJinzo7;
import modelo.cartas.CartaMagica;
import modelo.cartas.CartaMonstruo;
import modelo.cartas.CartaRefuerzos;
import modelo.cartas.CreadorDeCartas;

public class ContenedorJuegoPrincipal extends BorderPane {

	public ContenedorJuegoPrincipal() throws Exception {
		
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		
		CampoDeJuego campo = new CampoDeJuego();
		CampoDeJuego campoEnemigo = new CampoDeJuego();
		
		campo.asignarCampoEnemigo(campoEnemigo);
		campoEnemigo.asignarCampoEnemigo(campo);
		
		jugador.asignarCampo(campo);
		oponente.asignarCampo(campoEnemigo);
		
		jugador.llenarMazo();
		oponente.llenarMazo();
		
		oponente.robarCartaDelMazo();
		oponente.robarCartaDelMazo();
		oponente.robarCartaDelMazo();
		oponente.robarCartaDelMazo();
		oponente.invocarMonstruoEnPosicionDeAtaque(CreadorDeCartas.crearBrazoIzquierdoExodia());
		oponente.invocarMonstruoEnPosicionDeAtaque(new CartaMonstruo(1500, 1800, 4, "Gamma el Guerrero Magnetico", "images/GuerreroGamma.jpeg"));
		oponente.invocarMonstruoEnPosicionDeDefensa(CreadorDeCartas.crearPiernaDerechaExodia());
		oponente.invocarCartaBocaAbajo(CartaMagica.crearAgujeroNegro(campoEnemigo));
		
		
		jugador.robarCartaDelMazo();
		jugador.robarCartaDelMazo();
		jugador.robarCartaDelMazo();
		jugador.robarCartaDelMazo();

		jugador.invocarMonstruoEnPosicionDeAtaque(new CartaJinzo7());
		jugador.invocarCartaTrampa(new CartaCilindroMagico());
		jugador.invocarCartaTrampa(new CartaRefuerzos());
		
	 	
		//Top
		BorderPane top = new VistaHUDEnemigo(oponente);
		this.setTop(top);
		
		//Right
		VistaInfoDeCarta right = new VistaInfoDeCarta();
		this.setRight(right);
		
		
		//Bottom
		BorderPane bottom = new VistaHUDJugador(jugador, right);
		this.setBottom(bottom);
		
		
		
		//Center
		VBox center = new VistaCampoDeJuego(jugador, oponente, this);
		this.setCenter(center);
		
		
		Image imagen = new Image(new FileInputStream("images/Background.jpeg"));
		BackgroundImage fondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		this.setBackground(new Background(fondo));
		
		
	}
	
	
}
