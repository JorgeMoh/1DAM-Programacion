package examen05122024.ejercicio3;

import utils.Utils;

public class Partido {

	Jugador[] equipo1=new Jugador[5];
	Jugador[] equipo2=new Jugador[5];
	Jugador[] totalJugadores=new Jugador[10];
	int canastasMetidas=0;
	int canastasFalladas=0;
	int probTiro=0;
	int indice=0;
	
	Partido() {
		
		//inicializa los jugadores
		equipo1[0]=new Jugador("Hugo", 0, 0, 0);
		equipo1[1]=new Jugador("Ivan", 0, 0, 0);
		equipo1[2]=new Jugador("Alex", 0, 0, 0);
		equipo1[3]=new Jugador("Sergio", 0, 0, 0);
		equipo1[4]=new Jugador("Jorge", 0, 0, 0);
		
		equipo2[0]=new Jugador("Stefan", 0, 0, 0);
		equipo2[1]=new Jugador("Lukas", 0, 0, 0);
		equipo2[2]=new Jugador("Adri", 0, 0, 0);
		equipo2[3]=new Jugador("Arrollo", 0, 0, 0);
		equipo2[4]=new Jugador("Luis", 0, 0, 0);
		
		
		
	}

	public void mostrarJuagadores() {

		//muestra a los jugadores del equipo 1
		System.out.println("\nEquipo 1:");
		for (int i = 0; i < equipo1.length; i++) {
			System.out.println(equipo1[i]);
		}
		
		//muestra a los jugadores del equipo 2
		System.out.println("\nEquipo 2:");
		for (int i = 0; i < equipo2.length; i++) {
			System.out.println(equipo2[i]);
		}
		
	}

	public void jugarpartido() {
		
		//Este bucle realiza va cambiando el jugador
		for (int i = 0; i < equipo1.length; i++) {
			
			System.out.println("\nEs el turno de "+equipo1[i].getNombreJugador()+" del equipo 1");
			canastasMetidas=0;
			canastasFalladas=0;
			
			//este bucle realiza los tiros del jugador del equipo 1
			for (int j = 0; j < 10; j++) {
				
				probTiro=Utils.numeroAleatorioEntreDosNumeros(20, 100);
				System.out.println("Probabilidad de acierto: "+probTiro);
				
				if(equipo1[i].getProbabilidadDeAcierto()>=probTiro) {
					System.out.println("¡Ha entrado!");
					canastasMetidas++;
				}else {
					System.out.println("¡Vaya matao!");
					canastasFalladas++;
				}
						
			}
			
			//Aqui se establecen loslos puntos metidos y fallados
			equipo1[i].setCanastasMetidas(canastasMetidas);
			equipo1[i].setCanastasFalladas(canastasFalladas);
			
			System.out.println("\nEs el turno de "+equipo2[i].getNombreJugador()+" del equipo 2");
			//se pone a cero los contadores de canastas y fallos
			canastasMetidas=0;
			canastasFalladas=0;
			
			//este bucle realiza los tiros del jugador del equipo 2
			for (int j = 0; j < 10; j++) {
				
				probTiro=Utils.numeroAleatorioEntreDosNumeros(20, 100);
				System.out.println("Probabilidad de acierto: "+probTiro);
				
				if(equipo2[i].getProbabilidadDeAcierto()>=probTiro) {
					System.out.println("¡Ha entrado!");
					canastasMetidas++;
				}else {
					System.out.println("¡Vaya matao!");
					canastasFalladas++;
				}
						
			}
			
			equipo2[i].setCanastasMetidas(canastasMetidas);
			equipo2[i].setCanastasFalladas(canastasFalladas);
			
		}
			
	}

	public void verLosMejoresJugadores() {

		indice=0;
		
		//estos dos metodos meten a los jugadores en un mismo array
		for (int i = 0; i < equipo1.length; i++) {
			totalJugadores[indice]=equipo1[i];
			indice++;
		}
		
		for (int i = 0; i < equipo2.length; i++) {
			totalJugadores[indice]=equipo2[i];
			indice++;
		}
		
		ordenarJugadores(totalJugadores);
		
		System.out.println("\nLos mejores jugadores son:");
		for (int i = 0; i < totalJugadores.length; i++) {
			System.out.println(totalJugadores[i]);
		}
		
	}

	public void ordenarJugadores(Jugador[] totalJugadores) {

		Jugador auxiliar=new Jugador(null, 0, 0, 0);
		boolean cambio=true;

		//Compara las canastas metidas y ordena a los jugadores de mayor a menor
		while (cambio) {
			cambio=false;
			for(int i=0;i<totalJugadores.length-1;i++) {
				if(totalJugadores[i].getCanastasMetidas()<totalJugadores[i+1].getCanastasMetidas()) {
					cambio=true;
					auxiliar=totalJugadores[i];
					totalJugadores[i]=totalJugadores[i+1];
					totalJugadores[i+1]=auxiliar;
				}
			}
		}
		
	}

	
	
}
