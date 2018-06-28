package vista;

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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ContenedorHackearEscenarios extends VBox {
	
	Stage stage;
	//private MediaPlayer mediaPlayer;
	
    public ContenedorHackearEscenarios(Stage stage, Scene proximaEscena) throws FileNotFoundException {

        super();

        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(50));
        Image imagen = new Image(new FileInputStream("images/CartaBocaAbajoDefensa.png"));
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        Button completarExodia = new Button();
        completarExodia.setStyle("-fx-background-color: #FF0000;\n"
        		+ "-fx-text-fill: #FFFFFF;\n"
        		+ "-fx-font-size: 16px");
        completarExodia.setMinSize(160, 60);
        completarExodia.setText("Completar Exodia");
        
        BotonEntrarHandler completarExodiaHandler = new BotonEntrarHandler(stage, proximaEscena, null);
        completarExodia.setOnAction(completarExodiaHandler);
        
        Button tresDragonesDeOjosAzules = new Button();
        tresDragonesDeOjosAzules.setStyle("-fx-background-color: #FF0000;\n"
        		+ "-fx-text-fill: #FFFFFF;\n"
        		+ "-fx-font-size: 16px");
        tresDragonesDeOjosAzules.setMinSize(160, 60);
        tresDragonesDeOjosAzules.setText("Dragon definitivo de ojos azules");
        
        BotonEntrarHandler ojosAzulesHandler = new BotonEntrarHandler(stage, proximaEscena, null);
        tresDragonesDeOjosAzules.setOnAction(ojosAzulesHandler);
        
        Button cartasMagiaTrampaYCampo = new Button();
        cartasMagiaTrampaYCampo.setStyle("-fx-background-color: #FF0000;\n"
        		+ "-fx-text-fill: #FFFFFF;\n"
        		+ "-fx-font-size: 16px");
        cartasMagiaTrampaYCampo.setMinSize(160, 60);
        cartasMagiaTrampaYCampo.setText("Probar cartas campo, magia y trampa");
        
        BotonEntrarHandler magicasHandler = new BotonEntrarHandler(stage, proximaEscena, null);
        cartasMagiaTrampaYCampo.setOnAction(magicasHandler);

        this.getChildren().addAll(completarExodia, tresDragonesDeOjosAzules, cartasMagiaTrampaYCampo);
        
}

}
