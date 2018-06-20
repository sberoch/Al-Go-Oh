package modelo;

public class CartaMonstruo extends Carta {

	protected int ataque;
	protected int defensa;
	protected Estrellas estrellas;
	protected Modo modo;
	
	
	public CartaMonstruo(int unAtaque, int unaDefensa, int unasEstrellas) {
		
		ataque = unAtaque;
		defensa = unaDefensa;
		estrellas = new Estrellas(unasEstrellas);

	}
	
	
	public CartaMonstruo(int unAtaque, int unaDefensa, int unasEstrellas, String unNombre) {

		ataque = unAtaque;
		defensa = unaDefensa;
		
		estrellas = new Estrellas(unasEstrellas);
		nombre = unNombre;
		
	}
	
	public int ataque() {
		return (ataque);
	}
	
	
	public int defensa() {
		return (defensa);
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
		
		if (estado.estaBocaAbajo()) {
			
			estado = new EstadoBocaArriba();
		}
		
		if (modo.fuerzaDePelea() <= unAtaque) {
			
			this.destruir();
			
			duenio.recibirDanio(modo.obtenerDanioDeAtaque(unAtaque));
		}
		
		return (modo.fuerzaDeRetorno());
	}
	
	
	public void aumentarAtaque(int aumento) {
		
		ataque += aumento;
		
		modo.aumentarAtaque(aumento);
	}
	
	public void aumentarDefensa(int aumento) {
		
		defensa += aumento;
		
		modo.aumentarDefensa(aumento);
	}
	

	
	public boolean tieneMenosAtaqueQue(int unAtaque) {
		
		return (ataque <= unAtaque);
	}
	
	
	public CartaMonstruo cartaConMenosAtaqueCon(CartaMonstruo otroMonstruo) {
		
		if (otroMonstruo.tieneMenosAtaqueQue(ataque)) {
			
			return (otroMonstruo);
			
		} else {
			
			return (this);
		}
	}


	public void atacarA(Jugador enemigo) throws NoSePuedeRealizarAtaqueException {
		
		if (!this.puedoAtacarDirectoA(enemigo)) {
			
			throw (new NoSePuedeRealizarAtaqueException());
		}
		
		enemigo.recibirDanio(ataque);
	}


	protected boolean puedoAtacarDirectoA(Jugador enemigo) {
		
		return (!enemigo.tieneMonstruosEnElCampo());
	}
	
	



	public void invocarBocaAbajo(Jugador unJugador, CampoDeJuego unCampo) throws NoHaySuficientesMonstruosException {

		this.realizarSacrificios(unCampo);
		
		duenio = unJugador;
		
		estado = new EstadoBocaAbajo();
		
		modo = new ModoDeDefensa(defensa);
		
		unCampo.jugarMonstruo(this);
	}


	public void invocarBocaArriba(Jugador unJugador, CampoDeJuego unCampo) throws NoHaySuficientesMonstruosException {
		
		this.realizarSacrificios(unCampo);
		
		duenio = unJugador;
		
		estado = new EstadoBocaArriba();
		
		modo = new ModoDeAtaque(ataque);
		
		unCampo.jugarMonstruo(this);
	}
	
	
	
	protected void realizarSacrificios(CampoDeJuego campo) throws NoHaySuficientesMonstruosException {
		
		int cantMonstruos = campo.obtenerCantidadDeMonstruos();
		
		int sacrificios = estrellas.determinarSacrificios();
		
		if (sacrificios > cantMonstruos) {
			throw new NoHaySuficientesMonstruosException();
		}
		
		for(int i = 0; i < sacrificios; i++) {
			
			campo.destruirUnMonstruo();
		}
	}

	public void atacarATuDuenio() {
		
		duenio.recibirDanio(ataque);
	}
	
	
	public static CartaMonstruo crearDragonBlancoDeOjosAzules() {
		
		CartaMonstruo dragonBlancoDeOjosAzules = new CartaMonstruo(3000, 2500, 8, "Dragon Blanco de Ojos Azules");
		return dragonBlancoDeOjosAzules;
	}
	
	
	public static CartaMonstruo crearCabezaDeExodia() {
		CartaMonstruo cabezaDeExodia = new CartaMonstruo(1000, 1000, 3, "Exodia, el Prohibido");
		return cabezaDeExodia;
	}
	
	public static CartaMonstruo crearBrazoIzquierdoExodia() {
		CartaMonstruo brazoIzquierdo = new CartaMonstruo(200, 300, 1, "Brazo Izquierdo del Prohibido");		
		return brazoIzquierdo;
	}
	
	public static CartaMonstruo crearBrazoDerechoExodia() {
		CartaMonstruo brazoDerecho = new CartaMonstruo(200, 300, 1, "Brazo Derecho del Prohibido");		
		return brazoDerecho;
	}
	
	public static CartaMonstruo crearPiernaIzquierdaExodia() {
		CartaMonstruo piernaIzquierda = new CartaMonstruo(200, 300, 1, "Pierna Izquierda del Prohibido");		
		return piernaIzquierda;
	}
	
	public static CartaMonstruo crearPiernaDerechaExodia() {
		CartaMonstruo piernaDerecha = new CartaMonstruo(200, 300, 1, "Pierna Derecha del Prohibido");
		return piernaDerecha;
	}


	
	
	
	
	
}