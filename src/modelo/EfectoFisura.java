package modelo;

public class EfectoFisura implements Efecto {

	private CampoDeJuego campoEnemigo; 

	public EfectoFisura(CampoDeJuego unCampoEnemigo) {
		campoEnemigo = unCampoEnemigo;
	}
	
	@Override
	public void activarse() {
		
		CartaMonstruo aDestruir = new CartaMonstruo(999999, 0 ,1);
		
		for (CartaMonstruo monstruo : campoEnemigo.monstruos()) {
			if (monstruo.tieneMenosAtaqueQue(aDestruir))
				aDestruir = monstruo;
		}
		
		aDestruir.destruir();
	}
	
	public void desactivarse() {
		
	}

}
