package clase;

import utils.Utils;

public class EjemplosFor {

	public static void main(String[] args) {
		numeroPrimo();
		//listaNumeroPrimo();
		//factorial();
//		ej5();
	}
	
	public static void tablaMultiplicar() {
		
		int variable = Utils.pedirNumeroUsuario("Dime que tabla quieres");
		
		System.out.println("La tabla del " + variable + ":");
		
		//Aqui el bucle "for" establece la bariable "i" en 0, despues establece que no puede ser mayor de 10 y dice que vaya de 1 en 1
		for(int i=0;i<10;i++) {
			System.out.println(variable + "x" + i + "=" + variable*i);
		}
	
	}
	public static void numeroPrimo() {
		
		int numPrimo = Utils.pedirNumeroUsuario("Dame un numero para saber si es primo");
		boolean esPrimo = true;
		
		for(int i = numPrimo-1;i>=2;i--) {
			if(numPrimo%i == 0) {
				esPrimo = false;
			}
		}
		
		if(esPrimo) {
			System.out.println("El numero " + numPrimo + " es primo");
		}else {
			System.out.println("El numero " + numPrimo + " no es primo");
		}
	}
	public static void listaNumeroPrimo() {
		
		int numPrimo = Utils.pedirNumeroUsuario("Dame un numero para saber si es primo");
		boolean esPrimo = true;
		
	for(int j = numPrimo; j > 1; j--) {
		esPrimo = true;
		for(int i = j-1;i > 1;i --) {
			if(j%i == 0) {
				esPrimo = false;
			}
		}
	
		if(esPrimo) {
			System.out.println("El numero " + j + " es primo");
		}
	}	
	}
	public static void cuantosNumeroPrimo() {
		
	}
	public static void factorial() {
		int numFactorial = Utils.pedirNumeroUsuario("Dime un numero del que quieras saber tu factorial");
		int resultado = 1;
		
		for(int i=numFactorial;i>1;i++) {
			resultado = resultado*i;
		}
		System.out.println("Factorial: " + resultado);
	}

	//ejercicios for
	public static void ej1() {
		
		int acumulador = 0;
		int numero = 0;
		
		
		for(int i=0;i<4;i++) {
		
		numero = Utils.pedirNumeroUsuario("Dime un numero");
			if(numero >= 10) {
			acumulador= numero + acumulador;
			}
		}
		System.out.println("La suma de los numeros superiores a 10 es: " + acumulador);
		
	}
	public static void ej2() {
	
		int acumulador = 0;
		int numero = 0;
		int ciclos = Utils.pedirNumeroUsuario("Dime cuantas veces quieres que te pida un numero");
		
		for(int i=0;i<ciclos;i++) {
		
		numero = Utils.pedirNumeroUsuario("Dime un numero");
			if(numero >= 10) {
			acumulador= numero + acumulador;
			}
		}
		System.out.println("La suma de los numeros superiores a 10 es: " + acumulador);
		
	}
	public static void ej3() {
		
		int numNegativo = 0;
		int numPositivo = 0;
		int ciclos = Utils.pedirNumeroUsuario("Dime cuantas veces quieres que te pida un numero");
		
		for(int i=0;i<ciclos;i++) {
			int num = Utils.pedirNumeroUsuario("Dime un numero");
			if(num < 0) {
				numNegativo = numNegativo + 1;
			}else {
				numPositivo = numPositivo + 1;
			}
		}
		System.out.println("has puesto " + numNegativo + " numeros negativos y " + numPositivo + " numeros positivos");
	}
	public static void ej4() {
		
		int acumulador = 0;
		int ciclos = Utils.pedirNumeroUsuario("Dime cuantas veces quieres que te pida un numero");
		
		for(int i=0;i<ciclos;i++) {
			int num = Utils.pedirNumeroUsuario("Dime un numero: ");
			acumulador=acumulador+num;
		}
		acumulador=acumulador/ciclos;
		System.out.println("La media de los numeros que has dicho es: " + acumulador);
	}
	public static void ej5() {
	
		int numMax = 0;
		int numMin = 0;
		int ciclos = Utils.pedirNumeroUsuario("Dime cuantas veces quieres que te pida un numero");
		
		for(int i=0;i<ciclos;i++) {
			int numero = Utils.pedirNumeroUsuario("Dime un numeros: ");
			
			if(i == 0) {
				numMax = numero;
				numMin = numero;
			}
			if(numero > numMax) {
				numMax = numero;
			}
			if(numero < numMin) {
				numMin = numero;
			}
		}
		System.out.println("El numero maximo es " + numMax + " y el minimo es " + numMin);
		
	}
	public static void ej6() {
		
	}
	
}
