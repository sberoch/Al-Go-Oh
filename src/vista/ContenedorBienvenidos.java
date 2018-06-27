package vista;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import controlador.BotonEntrarEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ContenedorBienvenidos extends VBox {
	
	Stage stage;

    public ContenedorBienvenidos(Stage stage, Scene proximaEscena) throws FileNotFoundException {

        super();

        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(50));
        Image imagen = new Image(new FileInputStream("images/CartaBocaAbajoDefensa.png"));
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        Button botonEntrar = new Button();
        
        botonEntrar.setStyle("-fx-background-color: #FF0000;\n"
        		+ "-fx-text-fill: #FFFFFF;\n"
        		+ "-fx-font-size: 16px");
        botonEntrar.setMinSize(160, 60);
        botonEntrar.setText("Entrar");

        Text texto = new Text();
        
        texto.setFont(Font.font("Arial", FontWeight.BOLD, 150));
        texto.setText("AL-GO-OH");
        texto.setFill(Color.RED);
        texto.setStrokeWidth(4);
        texto.setStroke(Color.ORANGE);

        BotonEntrarEventHandler botonEntrarHandler = new BotonEntrarEventHandler(stage, proximaEscena);
        botonEntrar.setOnAction(botonEntrarHandler);

        this.getChildren().addAll(texto, botonEntrar);
}

}
