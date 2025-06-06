package clase;

import utils.Utils;

public class pruebas {

	public static void main(String[] args) {

		int repeticiones=0;
		int numeroRepeticionesMayor=0;
		int indice=0;
		int[] numeros=new int[] {1,2,3,4,3,2,5};
		Utils.mostrarArray(numeros);
		int[] numerosMayores=new int[numeros.length];
		Utils.inicializarArrayConUnNumero(numerosMayores, -1);
		
		for (int i=0;i<numeros.length;i++) {
			repeticiones=0;
			
			for(int j=0;j<numeros.length;j++) {
				if(numeros[i]==numeros[j]) {
					repeticiones++;
				}	
			}
			
			if(repeticiones>numeroRepeticionesMayor) {
				Utils.inicializarArrayConUnNumero(numerosMayores, -1);
				indice=0;
				numerosMayores[indice]=numeros[i];
				numeroRepeticionesMayor=repeticiones;
			}else if (repeticiones==numeroRepeticionesMayor) {
				indice++;
				numerosMayores[indice]=numeros[i];
			}
			
		}
		for(int z=0;z<numerosMayores.length;z++) {
			
			if(numerosMayores[z]!=-1) {
				System.out.println("El numero que mas se repite es "+numerosMayores[z]+" y se repite "+repeticiones+" veces");
			}
		}


	}

}
