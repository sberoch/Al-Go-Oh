package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.CampoDeJuego;
import modelo.Jugador;
import modelo.cartas.CartaCilindroMagico;
import modelo.cartas.CartaDeCampo;
import modelo.cartas.CartaDragonDefinitivoDeOjosAzules;
import modelo.cartas.CartaMagica;
import modelo.cartas.CartaMonstruo;
import modelo.cartas.CartaRefuerzos;
import modelo.cartas.CreadorDeCartas;



public class Main extends Application {
	
	Jugador unJugador;
	Jugador otroJugador;

	public static void main(String[] args) {

		launch(args);
	}
	

	 public void start(Stage stage) throws Exception {
		
		stage.setTitle("AL-GO-OH");
		
		unJugador = new Jugador();
		otroJugador = new Jugador();
		
		CampoDeJuego campo = new CampoDeJuego();
		CampoDeJuego campoEnemigo = new CampoDeJuego();
		
		campo.asignarCampoEnemigo(campoEnemigo);
		campoEnemigo.asignarCampoEnemigo(campo);
		
		unJugador.asignarCampo(campo);
		otroJugador.asignarCampo(campoEnemigo);
		
		unJugador.llenarMazo();
		otroJugador.llenarMazo();
		
		cargarManos();
		
		/*
		 * Escenarios para probar funcionalidades especiales
		 * 
		escenarioExodia();
		escenarioDragonDefinitivo();
		escenarioProbarTrampasMagiasYCampo();
		*/
		
		VistaJuegoPrincipal contenedorPrincipal = new VistaJuegoPrincipal(stage, unJugador, otroJugador);
	 	Scene escenaPrincipal = new Scene(contenedorPrincipal, 1600, 900);
	 	
	 	ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaPrincipal);
	 	Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 1600, 900);
	 	
	 	stage.setScene(escenaBienvenidos);
	 	
	 	stage.setFullScreenExitHint("Presione ESC para salir de pantalla completa");
	 	stage.setFullScreen(true);
	 	
	 	stage.show();

	 	
	 }
	 
	 
	 private void cargarManos() {
		 
		otroJugador.robarCartaDelMazo();
		otroJugador.robarCartaDelMazo();
		otroJugador.robarCartaDelMazo();
		otroJugador.robarCartaDelMazo();
		otroJugador.robarCartaDelMazo();

		unJugador.robarCartaDelMazo();
		unJugador.robarCartaDelMazo();
		unJugador.robarCartaDelMazo();
		unJugador.robarCartaDelMazo();
	 }
	 
	 
	 private void escenarioExodia() {
		 
		 unJugador.getMano().agregarCarta(CreadorDeCartas.crearBrazoDerechoExodia());
		 unJugador.getMano().agregarCarta(CreadorDeCartas.crearBrazoIzquierdoExodia());
		 unJugador.getMano().agregarCarta(CreadorDeCartas.crearPiernaDerechaExodia());
		 unJugador.getMano().agregarCarta(CreadorDeCartas.crearPiernaIzquierdaExodia());

		 
	 }
	 
	 
	 private void escenarioDragonDefinitivo() throws Exception {
		 
		 unJugador.invocarMonstruoEnPosicionDeAtaque(new CartaMonstruo(900, 800, 3, "Raiz de Agua", "images/RaizDeAgua.jpeg"));
		 unJugador.invocarMonstruoEnPosicionDeAtaque(new CartaMonstruo(900, 800, 3, "Raiz de Agua", "images/RaizDeAgua.jpeg"));
		 unJugador.invocarMonstruoEnPosicionDeAtaque(CreadorDeCartas.crearDragonBlancoDeOjosAzules());
		 unJugador.invocarMonstruoEnPosicionDeAtaque(new CartaMonstruo(900, 800, 3, "Raiz de Agua", "images/RaizDeAgua.jpeg"));
		 unJugador.invocarMonstruoEnPosicionDeAtaque(new CartaMonstruo(900, 800, 3, "Raiz de Agua", "images/RaizDeAgua.jpeg"));
		 unJugador.invocarMonstruoEnPosicionDeAtaque(CreadorDeCartas.crearDragonBlancoDeOjosAzules());
		 unJugador.invocarMonstruoEnPosicionDeAtaque(new CartaMonstruo(900, 800, 3, "Raiz de Agua", "images/RaizDeAgua.jpeg"));
		 unJugador.invocarMonstruoEnPosicionDeAtaque(new CartaMonstruo(900, 800, 3, "Raiz de Agua", "images/RaizDeAgua.jpeg"));
		 unJugador.invocarMonstruoEnPosicionDeAtaque(CreadorDeCartas.crearDragonBlancoDeOjosAzules());
		 
		 unJugador.getMano().agregarCarta(new CartaDragonDefinitivoDeOjosAzules());

	 }
	 
	 
	 private void escenarioProbarTrampasMagiasYCampo() throws Exception {
		 
		 unJugador.getMano().agregarCarta(new CartaCilindroMagico());
		 unJugador.getMano().agregarCarta(new CartaRefuerzos());
		 unJugador.getMano().agregarCarta(CartaMagica.crearOllaDeLaCodicia(unJugador));
		 unJugador.getMano().agregarCarta(CartaMagica.crearAgujeroNegro(unJugador.getCampo()));
		 unJugador.getMano().agregarCarta(CartaMagica.crearFisura(otroJugador.getCampo()));
		 unJugador.getMano().agregarCarta(CartaDeCampo.crearWasteland());
		 unJugador.getMano().agregarCarta(CartaDeCampo.crearSogen());
		 
	 }


}
