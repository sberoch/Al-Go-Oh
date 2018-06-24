package vista;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.CampoDeJuego;
import modelo.Jugador;

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
		
		jugador.robarCartaDelMazo();
		jugador.robarCartaDelMazo();
		jugador.robarCartaDelMazo();
		
	 	
		//Top
		HBox top = new VistaManoEnemiga(oponente);
		
		
		//Bottom
		HBox bottom = new VistaManoJugador(jugador);
		
		
		//Center
		HBox center = new HBox();
		center.setSpacing(10);
		center.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
		        + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
		        + "-fx-border-radius: 5;" + "-fx-border-color: green;");
		center.setAlignment(Pos.CENTER);
		
		Text textCenter = new Text("Todas las cartas en juego");
		textCenter.setFill(Color.GREEN);
		textCenter.setStyle("-fx-font: 24 arial;");
		center.getChildren().add(textCenter);
		
		
		//Right
		VBox right = new VBox();
		right.setSpacing(10);
		right.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
		        + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
		        + "-fx-border-radius: 5;" + "-fx-border-color: orange;");
		right.setAlignment(Pos.CENTER);
		right.setMinWidth(250);
		
		Text textRight = new Text("Acercamiento de Carta y descripcion de efecto");
		textRight.setFill(Color.ORANGE);
		textRight.setStyle("-fx-font: 24 arial;");
		right.getChildren().add(textRight);
		
		
		
		
		
		BorderPane layout = new BorderPane();
		layout.setTop(top);
		layout.setBottom(bottom);
		layout.setCenter(center);
		layout.setRight(right);
		
	 	Scene scene = new Scene(layout, 1600, 900);
	 	stage.setScene(scene);
	 	
	 	stage.setFullScreenExitHint("");
	 	stage.setFullScreen(true);
	 	
	 	stage.show();

	 }


}
