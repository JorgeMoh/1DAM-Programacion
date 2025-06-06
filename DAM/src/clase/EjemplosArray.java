package clase;

import utils.Utils;

public class EjemplosArray {
		
	public static void main(String[] args) {
//		ejB5();
		ejBP4();
	}
	
	public static void ejB1() {
		
		int suma=0,media=0,menor=0,mayor=0,aux=0;
		int[] array = new int[150];
		
		for(int i=0;i<array.length;i++) {
			array [i]=Utils.numeroAleatorioEntreDosNumeros(0, 100);
			System.out.println("El numero de la posicion "+ i + " es: " + array[i]);
		}
		
		for(int i=0;i<array.length;i++) {
			suma = suma + array[i];
		}
		System.out.println("La suma de todos los numeros del array es: " + suma);
	
		for(int i=0;i<array.length;i++) {
			aux=aux+1;
			media=media+array[i];
		}
		media=media/aux;
		System.out.println("La media de los numeros del array es: " + media);
		
		for(int i=0;i<array.length;i++) {
			if(i == 0) {
				menor=array[i];
			}
			if(array[i]<menor) {
				menor=array[i];
			}
		}
		System.out.println("El menor de todos los numeros del array es: " + menor);
		
		for(int i=0;i<array.length;i++) {
			if(i == 0) {
				mayor=array[i];
			}
			if(array[i]>mayor) {
				mayor=array[i];
			}
		}
		System.out.println("El menor de todos los numeros del array es: " + mayor);
		
		
	}
	public static void ejB2() {
		
		int min=Utils.pedirNumeroUsuario("Dime el numero minimo aleatorio que puede salir");
		int max=Utils.pedirNumeroUsuario("Dime el numero maximo aleatorio que puede salir");
		int[] array = new int[150];
		
		for(int i=0;i<array.length;i++) {
			array [i]=Utils.numeroAleatorioEntreDosNumeros(min, max);
			System.out.println("El numero de la posicion "+ i + " es: " + array[i]);
		}
	}
	public static void ejB3() {
		int[] array = new int[150];
		
		Utils.inicializarArrayConNumerosAleatorios(array, 0, 100);
		Utils.mostrarArray(array);
		Utils.invertirArray(array);
		Utils.mostrarArray(array);
		
	}
	public static void ejB4() {
		
		int[] array = new int[150];
		int numero=0;
		boolean hayNumero= false;
		
		Utils.inicializarArrayConNumerosAleatorios(array, 0, 100);
		Utils.mostrarArray(array);
		numero=Utils.pedirNumeroUsuario("¿Que numero quieres comprobar si esta en el array?");
		for(int i=0;i<array.length;i++) {
			if(numero==array[i]) {
				System.out.println("El numero esta registrado en la posicion " + i);
				hayNumero=true;
			}
		}
		if(hayNumero==false) {
			System.out.println("El numero no esta registrado");
		}
	}
	public static void ejB5() {
		
		int[] array=new int[150];
		int sumaPar=0, sumaImpar=0;
		
		Utils.inicializarArrayConNumerosAleatorios(array, 0, 100);
		Utils.mostrarArray(array);
		for(int i=0;i<array.length;i++) {
			if(array[i]%2==0) {
				sumaPar+=array[i];
			}
			if(array[i]%2!=0) {
				sumaImpar+=array[i];
			}
		}
		System.out.println("La suma de los nueros pares del array es: "+sumaPar);
		System.out.println("La suma de los nueros impares del array es: "+sumaImpar);
		
	}
	public static void ejB6() {
		
		int[] array=new int[150];
		int sumaPar=0, sumaImpar=0;
		
		Utils.inicializarArrayConNumerosAleatorios(array, 0, 100);
		Utils.mostrarArray(array);
		for(int i=0;i<array.length;i++) {
			if(i%2==0) {
				sumaPar+=array[i];
			}else if(i%2!=0) {
				sumaImpar+=array[i];
			}
		}
		System.out.println("La suma de los nueros en las posiciones pares del array es: "+sumaPar);
		System.out.println("La suma de los nueros en las posiciones impares del array es: "+sumaImpar);
		
	}

	public static void ejBP1() {
		
		int[] array=new int[150];

		Utils.inicializarArrayConNumerosAleatorios(array, -100, 100);
		Utils.mostrarArray(array);
		Utils.cambiarSignoEnValroresDelArray(array);
		Utils.mostrarArray(array);

		
	}
	public static void ejBP2() {
		
		int[] array1=new int[150];
		int[] array2=new int[150];
		int[] array3=new int[150];
		
		Utils.inicializarArrayConNumerosAleatorios(array1, 0, 100);
		Utils.mostrarArray(array1);
		Utils.inicializarArrayConNumerosAleatorios(array2, 0, 100);
		Utils.mostrarArray(array2);
		array3=Utils.crearTercerArray(array1, array2);
		Utils.mostrarArray(array3);
		
	}
	public static void ejBP3() {
	
		int[] array=new int[3];
		int multiplicador=Utils.pedirNumeroUsuario("¿Por cuanto quieres multiplicar el array?");
		
		Utils.inicializarArrayConNumerosAleatorios(array, 0, 100);
		Utils.mostrarArray(array);
		Utils.multiplicaValoresPorFactor(array, multiplicador);
		Utils.mostrarArray(array);
		
	}
	public static void ejBP4() {
	
		int[] array=new int[5];
		
		Utils.inicializarArrayConNumerosAleatorios(array, 0, 100);
		Utils.mostrarArray(array);
		int auxiliar=array[array.length-1];
		
		for(int i=array.length-1;i>0;i--) {
			array[i]=array[i-1];
		}
//		Utils.desplazaCiclicoDerecha(array);
		Utils.mostrarArray(array);
		
	}
	public static void ejBP5() {
		
	}
	public static void ejBP6() {
	
	}

}
