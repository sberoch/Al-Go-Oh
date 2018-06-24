package modelo.cartas;

import modelo.CampoDeJuego;
import modelo.exceptions.NoHaySuficientesMonstruosException;

public class CartaDragonDefinitivoDeOjosAzules extends CartaMonstruo {
	
	public CartaDragonDefinitivoDeOjosAzules() {
		
		super(4500, 3800, 12, "Dragon Definitivo de Ojos Azules", "images/DragonDefinitivo.jpeg");
	}
	
	
	protected void realizarSacrificios(CampoDeJuego campo) throws NoHaySuficientesMonstruosException {
		
		int cantidadDeDragones = campo.obtenerCantidadDeMonstruosConNombre("Dragon Blanco de Ojos Azules");
		
		if (3 > cantidadDeDragones) {
			
			throw new NoHaySuficientesMonstruosException();
		}
		
		for(int i = 0; i < 3; i++) {
			
			campo.destruirUnMonstruoConNombre("Dragon Blanco de Ojos Azules");
		}
	}
	
}
