package modelo;

public class CartaMonstruo {

	private int ataque;
	private int defensa;
	private Estrellas estrellas;
	private PosicionDeMonstruo posicion;
	private Jugador duenio;
	
	
	
	public CartaMonstruo(int unAtaque, int unaDefensa, int unasEstrellas) {
		
		ataque = unAtaque;
		defensa = unaDefensa;
		
		estrellas = new Estrellas();
		estrellas.asignarEstrellas(unasEstrellas);

	}
	
	
	public void invocarEnPosicionDeAtaque(Jugador jugadorQueLoInvoca) {
		
		posicion = new PosicionDeAtaque(ataque);
		
		duenio = jugadorQueLoInvoca;
	}
	
	
	public void invocarEnPosicionDeDefensa(Jugador jugadorQueLoInvoca) {
		
		posicion = new PosicionDeDefensa(defensa);
		
		duenio = jugadorQueLoInvoca;
	}
	
	
	public boolean estaEnPosicionDeAtaque() {
		
		return (posicion.esPosicionDeAtaque());
	}
	
	
	public boolean estaEnPosicionDeDefensa() {
		
		return (posicion.esPosicionDeDefensa());
	}
	
	
	public void atacarA(CartaMonstruo otroMonstruo) {
		
		int danioDeRetorno;
		
		danioDeRetorno = otroMonstruo.recibirDanio(ataque);
		
		this.recibirDanio(danioDeRetorno);
	}
	
	
	public int recibirDanio(int unAtaque) {
		
		if (posicion.fuerzaDePelea() <= unAtaque) {
			
			this.destruir();
			
			duenio.recibirDanio(posicion.obtenerDanioDeAtaque(unAtaque));
		}
		
		return (posicion.fuerzaDeRetorno());
	}
	
	
	public boolean fueDestruido() {
		
		return (duenio.verificarSiEstaEnElCementerio(this));
	}
	
	
	public void destruir()  {
		
		duenio.enviarAlCementerio(this);
		
	}
	
	
	public int sacrificiosRequeridos() {
		return estrellas.determinarSacrificios();
	}
	
	
	
}
