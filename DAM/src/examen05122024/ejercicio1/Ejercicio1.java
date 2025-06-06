package examen05122024.ejercicio1;

import utils.Utils;

public class Ejercicio1 {

	public static void main(String[] args) {

		int array[]=new int[10];
		int numerosDescartados[]=new int[10];
		boolean numeroRepetido=true;
		int sumaMayor=0;
		int numero1=0;
		int numero2=0;
		
		Utils.inicializarArrayConNumerosAleatorios(array, 0, 20);
		Utils.mostrarArray(array);
		

		for (int i = 0; i < array.length; i++) {
		
			numeroRepetido=false;
			
			//buscasi el numero esta dentro
			for (int j = 0; j < numerosDescartados.length; j++) {
				
				if(array[i]==numerosDescartados[j]) {
					numeroRepetido=true;
				}
				
			}
			
			numerosDescartados[i]=array[i];
			
			//este bucle compara la suma de todo lo que hay dentro del array
			for (int z =i+1; z < array.length; z++) {
				
				if(numeroRepetido) {
					break;
				}
				
				if(array[i]+array[z]>sumaMayor) {
					
					sumaMayor=array[i]+array[z];
					numero1=array[i];
					numero2=array[z];
					
				}
				
			}
			numerosDescartados[i]=array[i];
		}
		
		System.out.println("La suma mayor es: "+numero1+"+"+numero2+" que da como resultado "+sumaMayor);
		
		
	}

}
