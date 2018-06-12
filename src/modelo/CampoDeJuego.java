package modelo;

import java.util.LinkedList;

public class CampoDeJuego {
	
	private LinkedList<CartaMonstruo> monstruosEnJuego = new LinkedList<CartaMonstruo>();
	
	private CampoDeJuego campoEnemigo;
	
	
	
	
	public void asignarCampoEnemigo(CampoDeJuego campo) {
		
		campoEnemigo = campo;
	}
	
	
	public void agregarAlCampo(CartaMonstruo monstruo) {
		
		monstruosEnJuego.add(monstruo);
	}
	
	
	public void destruirTodosLosMonstruos() {
		
		for (CartaMonstruo monstruo : monstruosEnJuego) {
			
			monstruo.destruir();
		}
		
		monstruosEnJuego.clear();
		
		campoEnemigo.destruirMonstruosPropios();
	}
	
	
	public void destruirMonstruosPropios() {
		
		for (CartaMonstruo monstruo : monstruosEnJuego) {
			
			monstruo.destruir();
		}
		
		monstruosEnJuego.clear();
	}
	
	public void atacarConMonstruoAEnemigo(int posicionDeMonstruo, int posicionDeEnemigo) {
		
		CartaMonstruo atacante = monstruosEnJuego.get(posicionDeMonstruo - 1);
		
		campoEnemigo.atacarAMonstruoCon(posicionDeEnemigo, atacante);
		
		if (atacante.fueDestruido()) {
			
			monstruosEnJuego.remove(posicionDeMonstruo - 1);
		}
		
	}
	
	public void atacarAMonstruoCon(int posicionDeMonstruo, CartaMonstruo atacante) {
		
		CartaMonstruo atacado = monstruosEnJuego.get(posicionDeMonstruo - 1);
		
		atacante.atacarA(atacado);
		
		if (atacado.fueDestruido()) {
			
			monstruosEnJuego.remove(posicionDeMonstruo - 1);
		}
	}
}
