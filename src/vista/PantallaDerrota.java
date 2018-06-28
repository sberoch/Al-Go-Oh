package vista;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import controlador.BotonSalirHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PantallaDerrota extends VBox {
	
private MediaPlayer mediaPlayer;
	
	public PantallaDerrota(Stage stage) throws FileNotFoundException {

        super();

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(50));
        Image imagen = new Image(new FileInputStream("images/ImagenDerrota.jpg"));
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        Button botonSalir = new Button();
        
        botonSalir.setStyle("-fx-background-color: #FF0000;\n"
        		+ "-fx-text-fill: #FFFFFF;\n"
        		+ "-fx-font-size: 16px");
        botonSalir.setMinSize(160, 60);
        botonSalir.setText("Salir");

        Text texto = new Text();
        
        texto.setFont(Font.font("Arial", FontWeight.BOLD, 150));
        texto.setText("PERDISTE");
        texto.setFill(Color.RED);
        texto.setStrokeWidth(4);
        texto.setStroke(Color.ORANGE);
        
        botonSalir.setOnAction(new BotonSalirHandler(stage));
        
        this.getChildren().addAll(texto, botonSalir);
        
        String musicFile = "sounds/MusicaDerrota.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
		
        
	}

}
