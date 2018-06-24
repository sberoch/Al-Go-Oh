package vista;

import javafx.scene.layout.BorderPane;
import modelo.Jugador;

public class LayoutDeDuelo extends BorderPane {
	
	
	public LayoutDeDuelo(Jugador jugador, Jugador oponente) {
		
		VistaInfoDeCarta acercamiento = new VistaInfoDeCarta();
		
		this.setRight(acercamiento);
		this.setTop(new VistaManoEnemiga(oponente));
		this.setBottom(new VistaManoJugador(jugador, acercamiento));
	}

}
