package modelo.cartas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CartaCilindroMagico extends CartaTrampa {

	
	public CartaCilindroMagico() {
		
		
		nombre = "Cilindro Magico";
		
		try {
			
			imagen = new FileInputStream("images/CilindroMagico.jpeg");
			
		} catch (FileNotFoundException e) {
			
		}
		
	}
	
	
	public boolean activarEnAtaqueAMonstruo(CartaMonstruo atacante, CartaMonstruo atacado) {
		
		atacante.atacarATuDuenio();
		
		return (true);
	}
	
	
	public boolean activarEnAtaqueDirecto(CartaMonstruo atacante) {
		
		atacante.atacarATuDuenio();
		
		return (true);
	}
	
}
