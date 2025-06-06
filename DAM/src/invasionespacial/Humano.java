package invasionespacial;

import utils.Utils;

public class Humano extends Jugador {

	boolean escudo=true;
	private int danyoArma=Utils.numeroAleatorioEntreDosNumeros(0, 50);
	
	public Humano(int id) {
		super.setId(id);
	}
	
	public String toString() {
		return "Humano" + getId() + " vida: " + getPuntosDeVida() + " Escudo: " + escudo;
	}
	
}
