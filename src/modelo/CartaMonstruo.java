package modelo;

public class CartaMonstruo {

	private int ataque;
	private PosicionDeMonstruo posicion;
	private Jugador duenio;
	private boolean destruido;
	
	
	public CartaMonstruo(int unAtaque) {
		
		ataque = unAtaque;
	}
	
	
	public void invocarEnPosicionDeAtaque(Jugador jugadorQueLoInvoca) {
		
		posicion = new PosicionDeAtaque();
		
		duenio = jugadorQueLoInvoca;
	}
	
	
	public void invocarEnPosicionDeDefensa() {
		
		posicion = new PosicionDeDefensa();
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
		
		if (ataque < unAtaque) {
			
			this.destruirConDanio(unAtaque - ataque);
			
			return (-1);
			
		} else {
			
			return (ataque);
		}
	}
	
	
	public boolean fueDestruido() {
		
		return (destruido);
	}
	
	
	
	
	private void destruirConDanio(int unDanio) {
		
		destruido = true;
		
		duenio.recibirDanio(unDanio);
	}
	
}
