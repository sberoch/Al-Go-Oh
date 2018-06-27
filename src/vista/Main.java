package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.CampoDeJuego;
import modelo.Jugador;
import modelo.cartas.CartaCilindroMagico;
import modelo.cartas.CartaJinzo7;
import modelo.cartas.CartaMonstruo;
import modelo.cartas.CartaRefuerzos;
import modelo.cartas.CreadorDeCartas;


public class Main extends Application {

	public static void main(String[] args) {

		launch(args);
	}
	

	 public void start(Stage stage) throws Exception {
		
		stage.setTitle("AL-GO-OH");
		
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		
		CampoDeJuego campo = new CampoDeJuego();
		CampoDeJuego campoEnemigo = new CampoDeJuego();
		
		campo.asignarCampoEnemigo(campoEnemigo);
		campoEnemigo.asignarCampoEnemigo(campo);
		
		unJugador.asignarCampo(campo);
		otroJugador.asignarCampo(campoEnemigo);
		
		unJugador.llenarMazo();
		otroJugador.llenarMazo();
		

		
		otroJugador.robarCartaDelMazo();
		otroJugador.robarCartaDelMazo();
		otroJugador.robarCartaDelMazo();
		otroJugador.robarCartaDelMazo();
		otroJugador.invocarMonstruoEnPosicionDeAtaque(CreadorDeCartas.crearBrazoIzquierdoExodia());
		otroJugador.invocarMonstruoEnPosicionDeAtaque(new CartaMonstruo(1500, 1800, 4, "Gamma el Guerrero Magnetico", "images/GuerreroGamma.jpeg"));
		otroJugador.invocarMonstruoEnPosicionDeDefensa(CreadorDeCartas.crearPiernaDerechaExodia());
		otroJugador.invocarCartaBocaAbajo(new CartaCilindroMagico());
		

		unJugador.robarCartaDelMazo();
		unJugador.robarCartaDelMazo();
		unJugador.robarCartaDelMazo();
		unJugador.robarCartaDelMazo();
		unJugador.robarCartaDelMazo();

		unJugador.invocarMonstruoEnPosicionDeAtaque(new CartaJinzo7());
		unJugador.invocarCartaTrampa(new CartaCilindroMagico());
		unJugador.invocarCartaTrampa(new CartaRefuerzos());
		
		VistaJuegoPrincipal contenedorPrincipal = new VistaJuegoPrincipal(stage, unJugador, otroJugador);
	 	Scene escenaPrincipal = new Scene(contenedorPrincipal, 1600, 900);
	 	
	 	
	 	ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaPrincipal);
	 	Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 1600, 900);
	 	
	 	stage.setScene(escenaBienvenidos);
	 	
	 	stage.setFullScreenExitHint("Presione ESC para salir de pantalla completa");
	 	stage.setFullScreen(true);
	 	
	 	stage.show();

	 }


}
