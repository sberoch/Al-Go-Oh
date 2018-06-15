package modelo;

import java.util.LinkedList;

public class CampoDeJuego {
	
	private LinkedList<CartaMonstruo> monstruosEnJuego = new LinkedList<CartaMonstruo>();
	
	private CampoDeJuego campoEnemigo;
	
	
	
	
	public void asignarCampoEnemigo(CampoDeJuego campo) {
		
		campoEnemigo = campo;
	}
	
	
	public LinkedList<CartaMonstruo> monstruos() {
		return (monstruosEnJuego);
	}
	
	
	
	public CampoDeJuego obtenerCampoEnemigo() {
		
		return (campoEnemigo);
	}
	
	
	public void agregarAlCampo(CartaMonstruo monstruo) throws Exception {
		
		int cantMonstruos = monstruosEnJuego.size();
		int sacrificios = monstruo.sacrificiosRequeridos();
		
		if (sacrificios > cantMonstruos) {
			throw new NoHaySuficientesMonstruosException();
		}
		
		for(int i = 0; i < sacrificios; i++) {
			monstruosEnJuego.getLast().destruir();
			monstruosEnJuego.removeLast();
		}
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


	public void aumentarAtaqueDeLosMonstruos() {
		for (CartaMonstruo monstruo : monstruosEnJuego) {
			monstruo.aumentarAtaque(200);
		}
	}
	
	
	public void aumentarDefensaDeLosMonstruos() {
		for (CartaMonstruo monstruo : monstruosEnJuego) {
			monstruo.aumentarDefensa(300);
		}
	}
	
	
	
}
