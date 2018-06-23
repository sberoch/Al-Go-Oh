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

public class Main extends Application {

	public static void main(String[] args) {

		launch(args);
	}
	
	@Override
	 public void start(Stage stage) throws Exception {
		
		stage.setTitle("AL-GO-OH");
	 	
		//Top
		HBox top = new HBox();
		top.setSpacing(10);
		top.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
		        + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
		        + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
		top.setAlignment(Pos.CENTER);
		top.setMinHeight(150);
		
		Text textTop = new Text("Cartas del Enemigo (Mostradas boca abajo, solo para ver cantidad)");
		textTop.setFill(Color.BLUE);
		textTop.setStyle("-fx-font: 24 arial;");
		top.getChildren().add(textTop);
		
		
		//Bottom
		HBox bottom = new HBox();
		bottom.setSpacing(10);
		bottom.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
		        + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
		        + "-fx-border-radius: 5;" + "-fx-border-color: red;");
		bottom.setAlignment(Pos.CENTER);
		bottom.setMinHeight(200);
		
		Text textBottom = new Text("Mis cartas y mi mazo");
		textBottom.setFill(Color.RED);
		textBottom.setStyle("-fx-font: 24 arial;");
		bottom.getChildren().add(textBottom);
		
		
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
		
		Text textRight = new Text("Cementerios");
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
