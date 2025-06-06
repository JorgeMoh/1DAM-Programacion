package clase;

import java.util.Scanner;

import utils.Utils;

public class Ejemplos {

	public static void main(String[] args) {

		// Estas son variables
		int aulas = 5;
		float nota = (float) 6.9;
		double pizza = 7.6666;
		
		// Imprime por pantalla
		System.out.println("Hello my name is, cual es tu my name?");

		// System.out.print sin el ln no tiene salto de linea
		System.out.print("Mi nota es " + nota + "" + " " + aulas);

		// Imprimo por pantalla + variable
		System.out.println("Mi calificacion es : " + pizza);


		// Boolean es una variable de verdadera o falsa
		boolean apruebo = false;
		apruebo = true;
		System.out.println("Estoy aprobado?  " + apruebo);
		
		//Preguntar algo -> Scanner "variable" = new Scanner(System.in);
		//Previamente se ha importado el escaner con -> import java.util.Scanner;
		//Si añades * se añadirian todos los utiles -> import java.util.*; 
		Scanner sc = new Scanner(System.in);
		System.out.println("Dame un número entero");
		int nEntero = sc.nextInt();
		System.out.println("Tu numero entero es: " + nEntero);
		sc.close();//"sc.close();" Cierra el escaner
		
		//If es un: si la variable es esto pasa tal
		//Else acompaña a if(puede ir seguido de if): si no pasa el if sera el else
		//Operadores logicos: &&->y ||->o
		System.out.print("dime tu nota: ");
		int nota2 = sc.nextInt();
		
		if(nota2 < 5){
			System.out.println("Has suspendido pringao");
		}else if(nota2 == 5) {
			System.out.println("No esta mal para ser tu");
		}else if(nota2 > 5) {
			System.out.println("Vaya puto pro");
		}
		
		//switch(variable) como un if pero para varos casos de forma mas simple
		System.out.print("dime tu nota: ");
		int nota3 = sc.nextInt();
		
		switch(nota3) {
		case 1,2,3,4:
			System.out.println("Has suspendido pringao");
			break;
		case 5:
			System.out.println("No esta mal para ser tu");
			break;
		case 6,7,8,9,10:
			System.out.println("Vaya puto pro");
			break;
			}
		
		//importar el paquete y clase donde esten los codigos que queremos utilizas
		//en este caso utils.Utils
		int pru1 = Utils.pedirNumeroUsuario("dime un numero maquina");
		int pru2 = Utils.pedirNumeroUsuario("dime un numero maquina");
		System.out.println(" los numeros que has puesto son "+pru1+" "+pru2);
		
		//Creació de una cadena de caracteres
		String cadenaCarac = "Tutorial de Lenguaje de Programación Java 8.";
		
		//Imprime una cadena de caracteres
		System.out.println("Valor de cadenaCarac: " + cadenaCarac);  
		
		// Imprime l alongitud de una cadena
		System.out.println("Longitud de cadenaCarac: " + cadenaCarac.length()); 
		
		// Índice en el que encontramos una cadena
		System.out.println("Localización por caracteres: " + cadenaCarac.indexOf("Lenguaje")); 
		
		// Carácter encontrado en el índice 12, empezando por 0 
		System.out.println("Localización por índices: " + cadenaCarac.charAt(12)); 
		
		// Obtener una subcadena dentro de una cadena
		System.out.println("Uso de subcadenas: " + cadenaCarac.substring(12, 20)); 
		
		// Convertir una cadena de caracteres en minúscula
		System.out.println("Uso de toLower: " + cadenaCarac.toLowerCase()); 
		
		// Convertir una cadena de caracteres en mayúscula.
		System.out.println("Uso de toUpper: " + cadenaCarac.toUpperCase()); 
		
	}
	
}

