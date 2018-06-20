package modelo;

public class CartaDeCampo extends Carta {
	
	private EstadoCarta estado;
	
	private EfectoDeCartaCampo efecto;
	
	
	
	private CartaDeCampo(EfectoDeCartaCampo unEfecto) {
		
		efecto = unEfecto;
	}
	
	
	public boolean estaBocaAbajo() {
		
		return estado.estaBocaAbajo();
	}
	
	public void invocarBocaArriba(Jugador unJugador, CampoDeJuego unCampo) {
		
		estado = new EstadoBocaArriba();
		
		duenio = unJugador;
		
		unCampo.jugarBocaArriba(this);
		
	}

	
	
	public void modificarAtaqueYDefensaDeMonstruoAliado(CartaMonstruo monstruoAliado) {
		
		efecto.modificarAtaqueYDefensaDeMonstruoAliado(monstruoAliado);
	}
	
	
	public void modificarAtaqueYDefensaDeMonstruoEnemigo(CartaMonstruo monstruoEnemigo) {
		
		efecto.modificarAtaqueYDefensaDeMonstruoEnemigo(monstruoEnemigo);
	}
	
	
	public static CartaDeCampo crearCampoInicial() {
		
		EfectoDeCartaCampo efecto = new EfectoCampoInicial();
		
		return (new CartaDeCampo(efecto));
	}
	
	
	public static CartaDeCampo crearWasteland() {
		
		EfectoDeCartaCampo efecto = new EfectoWasteland();
		
		return (new CartaDeCampo(efecto));
	}
	
	public static CartaDeCampo crearSogen() {
		
		EfectoDeCartaCampo efecto = new EfectoSogen();
		
		return (new CartaDeCampo(efecto));
	}


	public void invocarBocaAbajo(Jugador unJugador, CampoDeJuego unCampo) {
		
		this.invocarBocaArriba(unJugador, unCampo);
	}



}
