package examenes.examen20241106;

import utils.Utils;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		//Variables y array inicializado
		int contador=0;
		int primo=0;
		boolean esPrimo=true;
		int[] array=new int[100];
		
		Utils.inicializarArrayConNumerosAleatorios(array, 0, 100);
		Utils.mostrarArray(array);
		
		//Este doble bucle determina que numeros son primos y los muestra en pantalla
		for(int i=0;i<array.length;i++) {
			esPrimo=true;
			
			for(int j=array[i]-1;j>=2;j--) {
				if(array[i]%j == 0) {
				esPrimo=false;
				break;
				}
			}
			if(esPrimo) {
				primo=array[i];
				contador++;
				System.out.println("El nuemero "+primo+" en la posicion "+i+" es primo");
			}
			
		}
		System.out.println("Hay un total de "+contador+" numeros primos");
	}

}
