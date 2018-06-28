package vista;

import controlador.PasarAFaseDeAtaqueHandler;
import controlador.PasarAFaseFinalHandler;
import controlador.PasarDeTurnoHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Jugador;
import modelo.Turno;

public class BotoneraDeTurno extends VBox {

	
	private Jugador jugador;
	private Jugador oponente;
	private Stage stage;
	private Turno turno;
	private VistaJuegoPrincipal vistaJuego;



	public BotoneraDeTurno(Jugador jugadorActual, Jugador oponenteActual, Stage stageActual, Turno turnoActual, VistaJuegoPrincipal vistaDelJuego) {
		

		jugador = jugadorActual;
		
		oponente = oponenteActual;
		
		stage = stageActual;
		
		turno = turnoActual;
		
		vistaJuego = vistaDelJuego;
		
		this.setSpacing(10);
		
		this.actualizar();
           
	}
	


	private void crearBotonDePasarTurno(Jugador jugadorActual, Jugador oponenteActual, Stage stage) {
		
		Button botonPasarTurno = new Button();
        
        botonPasarTurno.setStyle("-fx-background-color: #AA0000;\n"
        		+ "-fx-text-fill: #FFFFFF;\n"
        		+ "-fx-font-size: 22px");
        botonPasarTurno.setMinSize(200, 60);
        botonPasarTurno.setText("Pasar turno");
        
        botonPasarTurno.setOnAction(new PasarDeTurnoHandler(stage, jugadorActual, oponenteActual));
        
        this.getChildren().add(botonPasarTurno);
	}
	
	
	private void crearBotonDePasarAFaseDeAtaque(Turno turno, VistaJuegoPrincipal vistaJuego) {
		
		Button botonPasarAFaseDeAtaque = new Button();
		
		botonPasarAFaseDeAtaque.setStyle("-fx-background-color: #222222;\n"
				+ "-fx-text-fill: #FFFFFF;\n"
				+ "-fx-font-size: 22px");
		botonPasarAFaseDeAtaque.setMinSize(200, 60);
		botonPasarAFaseDeAtaque.setText("Fase de ataque");
		
		botonPasarAFaseDeAtaque.setOnAction(new PasarAFaseDeAtaqueHandler(turno, vistaJuego));
		
		if (!turno.sePuedePasarAFaseDeAtaque()) {
			
			botonPasarAFaseDeAtaque.setDisable(true);
		}
		
		this.getChildren().add(botonPasarAFaseDeAtaque);
		
	}
	
	
	private void crearBotonDePasarAFaseFinal(Turno turno, VistaJuegoPrincipal vistaJuego) {
		
		Button botonPasarAFaseFinal= new Button();
		
		botonPasarAFaseFinal.setStyle("-fx-background-color: #222222;\n"
				+ "-fx-text-fill: #FFFFFF;\n"
				+ "-fx-font-size: 22px");
		botonPasarAFaseFinal.setMinSize(200, 60);
		botonPasarAFaseFinal.setText("Fase final");
		
		botonPasarAFaseFinal.setOnAction(new PasarAFaseFinalHandler(turno, vistaJuego));
		
		if (!turno.sePuedePasarAFaseFinal()) {
			
			botonPasarAFaseFinal.setDisable(true);
		}
		
		this.getChildren().add(botonPasarAFaseFinal);
	}



	public void actualizar() {
		
        this.getChildren().clear();
		
		this.crearBotonDePasarTurno(jugador, oponente, stage);
        	
        this.crearBotonDePasarAFaseDeAtaque(turno, vistaJuego);	
        	
        this.crearBotonDePasarAFaseFinal(turno, vistaJuego);
      
	}
}
