package invasionespacial;

import utils.Utils;

public class Invasor extends Jugador {

	private int danyoArma=Utils.numeroAleatorioEntreDosNumeros(0, 100);
//	private String[] partesCuerpo= {"cabeza","brazo","pie","pecho"};
	
	public Invasor(int id) {
		setId(id);
	}
	
	public String toString() {
		return "Invasor: " + getId() + " vida: " + getPuntosDeVida() + " Daño del arma: " + danyoArma;
	}
	
}
