package modeloTest;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import modelo.Estrellas;

public class EstrellasTest {

	
	@Test
	public void test01CuatroEstrellasNoRequierenNingunSacrificio() {
		
		Estrellas estrellas = new Estrellas(4);
		
		assertEquals(0, estrellas.determinarSacrificios());
	}
	
	
	@Test
	public void test02CincoEstrellasRequierenUnSacrificio() {
		
		Estrellas estrellas = new Estrellas(5);
		
		assertEquals(1, estrellas.determinarSacrificios());
	}
	
	
	@Test
	public void test03SieteEstrellasRequierenDosSacrificios() {
		
		Estrellas estrellas = new Estrellas(7);
		
		assertEquals(2, estrellas.determinarSacrificios());
	}
	
}
