package vista;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import controlador.BotonEntrarHandler;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ContenedorBienvenidos extends VBox {
	
	Stage stage;
	private MediaPlayer mediaPlayer;
	
    public ContenedorBienvenidos(Stage stage, Scene escenaPrincipal/*, Scene escenaHackear*/) throws FileNotFoundException {

        super();

        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(50));
        Image imagen = new Image(new FileInputStream("images/CartaBocaAbajoDefensa.png"));
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
        
        String musicFile = "sounds/MusicaInicio.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();

        Text texto = new Text();
        
        texto.setFont(Font.font("Arial", FontWeight.BOLD, 150));
        texto.setText("AL-GO-OH");
        texto.setFill(Color.RED);
        texto.setStrokeWidth(4);
        texto.setStroke(Color.ORANGE);
        
        
        Button botonEntrar = new Button();
        
        botonEntrar.setStyle("-fx-background-color: #FF0000;\n"
        		+ "-fx-text-fill: #FFFFFF;\n"
        		+ "-fx-font-size: 16px");
        botonEntrar.setMinSize(160, 60);
        botonEntrar.setText("Entrar");

        BotonEntrarHandler botonEntrarHandler = new BotonEntrarHandler(stage, escenaPrincipal, mediaPlayer);
        botonEntrar.setOnAction(botonEntrarHandler);
        
        
        Button botonHackear = new Button();
        
        botonHackear.setStyle("-fx-background-color: #FF0000;\n"
        		+ "-fx-text-fill: #FFFFFF;\n"
        		+ "-fx-font-size: 16px");
        botonHackear.setMinSize(160, 60);
        botonHackear.setText("Hackear");

   //   BotonEntrarHandler botonHackearHandler = new BotonEntrarHandler(stage, escenaHackear, mediaPlayer);
   //   botonHackear.setOnAction(botonHackearHandler);
        
  
        HBox botonera = new HBox(botonEntrar, botonHackear);
        botonera.setAlignment(Pos.CENTER);
        botonera.setSpacing(30);
        this.getChildren().addAll(texto, botonera);
        
    }
}


