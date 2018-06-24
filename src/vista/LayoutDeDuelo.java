package vista;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import modelo.Jugador;

public class LayoutDeDuelo extends BorderPane {
	
	
	public LayoutDeDuelo(Jugador jugador, Jugador oponente) {
		
		VistaInfoDeCarta acercamiento = new VistaInfoDeCarta();
		
		this.setRight(acercamiento);
		this.setTop(new VistaManoEnemiga(oponente));
		this.setBottom(new VistaManoJugador(jugador, acercamiento));
		this.setBackground(new Background(new BackgroundImage(new Image("images/Background.jpeg"), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
	}

}
