package modelo.cartas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
public class CartaRefuerzos extends CartaTrampa {

	
	public CartaRefuerzos() {
		
		nombre = "Refuerzos";
		
		try {
			
			imagen = new FileInputStream("images/Refuerzos.jpeg");
			
		} catch (FileNotFoundException e) {

		}
	}
	
	public boolean activarEnAtaqueAMonstruo(CartaMonstruo atacante, CartaMonstruo atacado) {
		
		atacado.aumentarAtaque(500);
		
		atacante.atacarA(atacado);
		
		return (true);
	}
	
}
