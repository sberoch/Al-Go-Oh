package vista;

import controlador.PasarDeTurnoHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import modelo.Jugador;
import modelo.Turno;

public class BotoneraDeTurno extends HBox {

	public BotoneraDeTurno(Jugador jugadorAcutal, Jugador oponenteActual, Stage stage, Turno turno) {
		
		Button botonPasarTurno = new Button();
        
        botonPasarTurno.setStyle("-fx-background-color: #111111;\n"
        		+ "-fx-text-fill: #FFFFFF;\n"
        		+ "-fx-font-size: 22px");
        botonPasarTurno.setMinSize(160, 60);
        botonPasarTurno.setText("Pasar turno");
        
        botonPasarTurno.setOnAction(new PasarDeTurnoHandler(stage, jugadorAcutal, oponenteActual));
        
        this.getChildren().add(botonPasarTurno);
        
        
        
	}
}
