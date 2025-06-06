package examenes.examen20241106;

import utils.Utils;

public class Ejercicio4 {

	public static void main(String[] args) {

		int numeroMayor=0;
		int repeticiones=0;
		int contador=0;
		int[] array=new int[50];
		Utils.inicializarArrayConNumerosAleatorios(array, 1, 30);
		Utils.mostrarArray(array);
		
		//este bucle repite el proceso de comparacion con todas las posiciones
		for(int i=0;i<array.length;i++) {
			contador=0;
			//este Bucle suma el numero de veces que se repite un numero
			for(int j=0;j<array.length;j++) {
				
				if(array[i]==array[j]) {
					contador++;
				}	
			}
			//Aqui se compara si el numero anterior se ha repetido mas veces
			if(i==0) {
				numeroMayor=array[i];
				repeticiones=contador;
			}else if(contador>repeticiones) {
				numeroMayor=array[i];
				repeticiones=contador;
			}

		}
		System.out.println("El numero que mas se repite es "+numeroMayor+" y se repite "+repeticiones+" veces");

	}

}
