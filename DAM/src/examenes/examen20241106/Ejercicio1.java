package examenes.examen20241106;

import utils.Utils;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		int numero=Utils.pedirNumeroUsuario("¿Que numero quieres que comprueve si es un numero perfecto?");
		int auxiliar=0;
		
		//Este bucle identifica si un numero es divisor del numero que hemos dicho y los suma
		for(int i=1;i<numero;i++) {
			if(numero%i==0) {
				System.out.println(i+ " es divisor de "+numero);
				auxiliar+=i;
			}
		}
		//este if compara la suma de los divisores y en base al resultado dice si es un numero perfecto o no
		if(auxiliar==numero) {
			System.out.println(numero+" es un numero perfecto");
		}else System.out.println(numero+" no es un numero perfecto");
	}

}
