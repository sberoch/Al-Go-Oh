package modelo;

import java.util.LinkedList;

public class CampoDeJuego {
	
	private static CampoDeJuego INSTANCIA = new CampoDeJuego();
	private LinkedList<CartaMonstruo> monstruosEnJuego = new LinkedList<CartaMonstruo>();
	

	private CampoDeJuego() {
	}
	
	
	public static CampoDeJuego getInstancia() {
		 return INSTANCIA;
	}
	
	
	public void agregarAlCampo(CartaMonstruo monstruo) {
		monstruosEnJuego.add(monstruo);
	}
	
	
	public void destruirTodos() {
		for (CartaMonstruo monstruo : monstruosEnJuego) {
			monstruo.destruir();
		}
		monstruosEnJuego = new LinkedList<CartaMonstruo>();
	}
}
