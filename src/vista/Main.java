package vista;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.CampoDeJuego;
import modelo.Jugador;
import modelo.cartas.*;

public class Main extends Application {

	public static void main(String[] args) {

		launch(args);
	}
	

	 public void start(Stage stage) throws Exception {
		
		stage.setTitle("AL-GO-OH");
		
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
		oponente.invocarMonstruoEnPosicionDeDefensa(CreadorDeCartas.crearPiernaDerechaExodia());
		oponente.invocarCartaTrampa(new CartaCilindroMagico());
		
		
		jugador.robarCartaDelMazo();
		jugador.robarCartaDelMazo();
		jugador.robarCartaDelMazo();
		jugador.invocarMonstruoEnPosicionDeAtaque(CreadorDeCartas.crearBrazoDerechoExodia());
		jugador.invocarMonstruoEnPosicionDeDefensa(CreadorDeCartas.crearCabezaDeExodia());
		jugador.invocarCartaTrampa(new CartaCilindroMagico());
		jugador.invocarCartaTrampa(new CartaRefuerzos());
		
	 	
		//Top
		VistaManoEnemiga top = new VistaManoEnemiga(oponente);
		
		//Right
		VistaInfoDeCarta right = new VistaInfoDeCarta();
		
		
		//Bottom
		HBox bottom = new VistaManoJugador(jugador, right);
		
		
		//Center
		VBox center = new VistaCampoDeJuego(jugador, oponente, right);
		
		
		/*HBox center = new HBox();
		center.setSpacing(10);
		center.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
				+ "-fx-border-width: 2;" + "-fx-border-insets: 5;"
				+ "-fx-border-radius: 5;" + "-fx-border-color: green;");
		center.setAlignment(Pos.CENTER);
		
		Text textCenter = new Text("Todas las cartas en juego");
		textCenter.setFill(Color.GREEN);
		textCenter.setStyle("-fx-font: 24 arial;");
		center.getChildren().add(textCenter);
		*/
		
		BorderPane layout = new BorderPane();
		layout.setTop(top);
		layout.setBottom(bottom);
		layout.setCenter(center);
		layout.setRight(right);
		
		Image imagen = new Image(new FileInputStream("images/Background.jpeg"));
		BackgroundImage fondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		layout.setBackground(new Background(fondo));
		
	 	Scene scene = new Scene(layout, 1600, 900);
	 	
	 	stage.setScene(scene);
	 	
	 	stage.setFullScreenExitHint("Presione ESC para salir de pantalla completa");
	 	stage.setFullScreen(true);
	 	
	 	stage.show();

	 }


}
