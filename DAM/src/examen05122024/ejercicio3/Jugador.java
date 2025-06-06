package examen05122024.ejercicio3;

import utils.Utils;

public class Jugador {

	String nombreJugador="";
	int canastasMetidas=0;
	int probabilidadDeAcierto=0;
	int canastasFalladas=0;
	public Object[] getCanastasMetidas;
	
	Jugador(String nombreJugador,int canastasMetidas,int canastasFalladas,int probabilidadDeAcierto){
		
		this.nombreJugador=nombreJugador;
		this.canastasMetidas=canastasMetidas;
		this.canastasFalladas=canastasFalladas;
		this.probabilidadDeAcierto=Utils.numeroAleatorioEntreDosNumeros(20, 100);
		
	}
	
	@Override
	public String toString() {
		String texto= "Nombre: "+this.nombreJugador+" Canastas metidas: "+this.canastasMetidas+" Canastas falladas: "+this.canastasFalladas+" Probabilidad de acierto: "+this.probabilidadDeAcierto;
		return texto;
		
	}

	public String getNombreJugador() {
		return nombreJugador;
	}

	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}

	public int getCanastasMetidas() {
		return canastasMetidas;
	}

	public void setCanastasMetidas(int canastasMetidas) {
		this.canastasMetidas = canastasMetidas;
	}

	public int getProbabilidadDeAcierto() {
		return probabilidadDeAcierto;
	}

	public void setProbabilidadDeAcierto(int probabilidadDeAcierto) {
		this.probabilidadDeAcierto = probabilidadDeAcierto;
	}

	public int getCanastasFalladas() {
		return canastasFalladas;
	}

	public void setCanastasFalladas(int canastasFalladas) {
		this.canastasFalladas = canastasFalladas;
	}
	
}
