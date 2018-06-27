package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

	public static void main(String[] args) {

		launch(args);
	}
	

	 public void start(Stage stage) throws Exception {
		
		stage.setTitle("AL-GO-OH");
		
		ContenedorJuegoPrincipal contenedorPrincipal = new ContenedorJuegoPrincipal();
	 	Scene escenaPrincipal = new Scene(contenedorPrincipal, 1600, 900);
	 	
	 	
	 	ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaPrincipal);
	 	Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 1600, 900);
	 	
	 	stage.setScene(escenaBienvenidos);

	 	
	 	stage.setFullScreenExitHint("");
	 	stage.setFullScreen(true);
	 	
	 	stage.show();

	 }


}
