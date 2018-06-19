package modelo;

public class CartaMonstruo {

	protected int ataque;
	protected int defensa;
	protected Estrellas estrellas;
	protected Modo modo;
	protected Jugador duenio;
	
	
	
	public CartaMonstruo(int unAtaque, int unaDefensa, int unasEstrellas) {
		
		ataque = unAtaque;
		defensa = unaDefensa;
		
		estrellas = new Estrellas(unasEstrellas);

	}
	
	
	public int ataque() {
		return (ataque);
	}
	
	
	public int defensa() {
		return (defensa);
	}
	
	public void invocarEnPosicionDeAtaque(Jugador jugadorQueLoInvoca) {
		
		modo = new ModoDeAtaque(ataque);
		
		duenio = jugadorQueLoInvoca;
	}
	
	
	public void invocarEnPosicionDeDefensa(Jugador jugadorQueLoInvoca) {
		
		modo = new ModoDeDefensa(defensa);
		
		duenio = jugadorQueLoInvoca;
	}
	
	
	public boolean estaEnPosicionDeAtaque() {
		
		return (modo.esModoDeAtaque());
	}
	
	
	public boolean estaEnPosicionDeDefensa() {
		
		return (modo.esModoDeDefensa());
	}
	
	
	public void atacarA(CartaMonstruo otroMonstruo) {
		
		int danioDeRetorno;
		
		danioDeRetorno = otroMonstruo.recibirDanio(ataque);
		
		this.recibirDanio(danioDeRetorno);
	}
	
	
	protected int recibirDanio(int unAtaque) {
		
		if (modo.fuerzaDePelea() <= unAtaque) {
			
			this.destruir();
			
			duenio.recibirDanio(modo.obtenerDanioDeAtaque(unAtaque));
		}
		
		return (modo.fuerzaDeRetorno());
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
	
	
	public void aumentarAtaque(int aumento) {
		
		ataque += aumento;
		
		modo.aumentarAtaque(aumento);
	}
	
	public void aumentarDefensa(int aumento) {
		
		defensa += aumento;
		
		modo.aumentarDefensa(aumento);
	}
	
	public void disminuirAtaque(int disminucion) {
		
		ataque += disminucion;
		
		modo.disminuirAtaque(disminucion);
	}
	
	public void disminuirDefensa(int disminucion) {
		
		defensa += disminucion;
		
		modo.disminuirDefensa(disminucion);
	}
	
	public boolean tieneMenosAtaqueQue(CartaMonstruo otroMonstruo) {
		
		return (ataque <= otroMonstruo.ataque());
	}


	public void atacarA(Jugador enemigo) {
		
		enemigo.recibirDanio(ataque);
	}
	
	
}