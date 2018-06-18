package modelo;

public class CartaDeCampo {
	
	private EstadoCarta estado;
	
	private EfectoDeCartaCampo efecto;
	
	
	
	private CartaDeCampo(EfectoDeCartaCampo unEfecto) {
		
		efecto = unEfecto;
	}
	
	public void invocarBocaAbajo() {
		estado = new EstadoBocaAbajo();
	}
	
	public boolean estaBocaAbajo() {
		return estado.estaBocaAbajo();
	}
	
	public void invocarBocaArriba() {
		estado = new EstadoBocaArriba();
		
		this.activarEfecto();
	}
	
	public void activarEfecto() {
		
		efecto.activarse();
	}
	
	public void desactivarEfectoTemporalmente() {
		efecto.desactivarse();
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
	
	
	public static CartaDeCampo crearWasteland(CampoDeJuego campo) {
		
		EfectoDeCartaCampo efecto = new EfectoWasteland(campo);
		
		return (new CartaDeCampo(efecto));
	}
	
	public static CartaDeCampo crearSogen(CampoDeJuego campo) {
		
		EfectoDeCartaCampo efecto = new EfectoSogen(campo);
		
		return (new CartaDeCampo(efecto));
	}



}
