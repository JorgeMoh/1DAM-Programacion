package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Utils {
	
	/**
	 * Metodo para pedir un numero
	 * @param msg Es el mensaje definido por el codigo que se mostrara al pedir el numero
	 * @return devuelve el numero
	 */
	public static int pedirNumeroUsuario(String msg) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print(msg);
		int numeroUsuario = sc.nextInt();
//		sc.close();
		return numeroUsuario;
		
	}
	
	/**
	 * Metodo que genera un numero aleatorio entre 2 numeros dados
	 * @param min la variable que tiene el numero minimo
	 * @param max la variable que tiene el numero maximo
	 * @return devuelve el numero aleatorio
	 */
	public static int numeroAleatorioEntreDosNumeros(int min, int max) {
			
		int numero = (int)Math.floor(Math.random()* (max-min)) + min;
		return numero;	
	}
	
	/**
	 * Metodo que pide una cadena de texto al usuario
	 * @param msg el mensaje que quieres que se imprima en pantalla
	 * @return devuelve la cadena de texto pedida
	 */
	public static String pedirTextoUsuario(String msg) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print(msg);
		String pedirTexto = sc.nextLine();
//		sc.close();
		return pedirTexto;
		
	}

	/**
	 * Metodo que devuelve una cadena de texto al reves
	 * @param texto
	 */
	public static void mostrarTextoInvertido(String texto) {
		
		for(int i=texto.length()-1;i>-1;i--) {
			System.out.print(texto.charAt(i));
		}
		
	}

	/**
	 * Metodo que cuenta las vocales de una cadena de texto
	 * @param texto la cadena que se quiere contar
	 */
	public static void contarVocalesConsonantes(String texto) {
		
		int vocales=0;
		int consonates=0;
		for (int i = texto.length() - 1; i > -1; i--) {
			char letra=texto.charAt(i);
				if(letra=='A'|letra=='E'||letra=='I'||letra=='O'||letra=='U'||letra=='a'||letra=='e'||letra=='i'||letra=='o'||letra=='u') {
					vocales++;
				}else {
					consonates++;
				}
			}
			System.out.println("El texto tiene "+vocales+" vocales");
			System.out.println("El texto tiene "+consonates+" consonantes");
		}
	
	/**
	 * Metodo que comprueba si una palabra es un palindromo
	 * @param texto la palabra que se quiere comprobar
	 */
	public static void comprobarPalindromo(String texto) {
		
		boolean palindromo=true;
		texto=texto.toLowerCase();
		for(int i=0;i<texto.length();i++) {
			if(texto.charAt(i)==texto.charAt(texto.length()-1-i)) {
				
			}else {
				palindromo=false;
			}
		}
		if(palindromo) {
			System.out.println("Tu palabra es un palindromo");
		}else {
			System.out.println("Tu palabra no es un palindromo");
		}
		
	}

	/**
	 * Metodo que cuenta el numero de caracteres que tiene una cadena de texto
	 * @param texto cadena que se quiere contar
	 */
	public static void contarCaracteres(String texto) {

		int contador=0;
		texto=texto.toLowerCase();
		
		for(int i=0;i<texto.length();i++) {
			char caracter=texto.charAt(i);
			
			if(caracter>='a'&&caracter<='z') {
				contador++;
			}
		}
		System.out.println("El texto que has introducido tiene "+contador+" caracteres");
		
	}
		
	/**
	 * Metodo que inicializa un array con un numero
	 * @param array es el array que se quiere inicializar
	 * @param numero numero con el que se inicializa
	 */
	public static void inicializarArrayConUnNumero(int[] array, int numero) {
		
		for (int i = 0; i < array.length; i++) {
			array[i] = numero;
		}
	}
	
	/**
	 * Metodo que inicializa un array con numeros aleatorios
	 * @param array El array que se quiere inicializar
	 * @param min valor minimo del numero aleatorio
	 * @param max valor maximo del nuemro aleatorio
	 */
	public static void inicializarArrayConNumerosAleatorios(int[] array, int min, int max) {
		
		for (int i = 0; i < array.length; i++) {
			array[i] = Utils.numeroAleatorioEntreDosNumeros(min, max);
		}
	}
	
	/**
	 * Metodo que muestra un array
	 * @param array es el array que se quiere mostrar
	 */
	public static void mostrarArray(int[] array) {

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		} 
		System.out.println("");
	}
	
	/**
	 * Metodo que muestra un array y sus posiciones
	 * @param array es el array que se quiere mostrar
	 */
	public static void mostrarArrayConPosiciones(int[] array) {

		for (int i = 0; i < array.length; i++) {
			System.out.println("El numero en la posicion "+ i + " es: " + array[i] + " ");
		} 
	}
	
	/**
	 * Metodo que muestra un numero que pida el usuario en un array
	 * @param array es el array donde se va a buscar
	 */
	public static void buscarNumeroArray(int[] array) {
		
		int numero=0;
		boolean hayNumero= false;
		
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
	
	/**
	 * Metodo que invierte el orden de un array
	 * @param array es el array que se quiere invertir
	 */
	public static void invertirArray(int[] array) {
		int[] arrayAux = new int[array.length];
		int contador = 0;
		
		for(int i=array.length-1;i>=0;i--) {
			arrayAux[contador] = array[i];
			contador++;
	}
		for(int i=array.length-1;i>=0;i--) {
			array[i]=arrayAux[i];
	}
	}

	/**
	 * Metodo que cambia los numeros positivos a negativos y los negativos a positivos
	 * @param array es el array al que se le quiere cambiar los nuemros
	 */
	public static void cambiarSignoEnValroresDelArray(int[] array) {
		
		for(int i=0;i<array.length;i++) {
			array[i]*=-1;
		}
		
	}

	/**
	 * Metodo que crea un array a partir de otros con los numeros pares de uno y los impares de otro
	 * @param arrayImpar del array que sacaremos los numeros impares
	 * @param arrayPar del array que sacaresmos los numeros pares
	 * @return devuelve el nuevo array
	 */
	public static int[] crearTercerArray(int[] arrayImpar, int[] arrayPar) {
		
		int[] array3=new int[arrayImpar.length];
		
		for(int i=0;i<array3.length;i++) {
			if(i%2==0) {
				array3[i]=arrayPar[i];
			}else{
				array3[i]=arrayImpar[i];
			}
		}
		return array3;
	}
	
	/**
	 * Metodo que multiplica los numeros de un array por un numero establecido
	 * @param array esel array que se va a modificar
	 * @param factor el numero por el que se va a multiplicar los numeros del array
	 */
	public static void multiplicaValoresPorFactor (int array[], int factor) {
		 
		 for(int i=0;i<array.length;i++) {
			 array[i]*=factor;
		 }
		 
	 }

	/**
	 * Metodo que desplaza los numeros de un array una posicion a la derecha
	 * @param array es el array que vamos a modificar
	 */
	public static void desplazaCiclicoDerecha (int array[]) {
		
		int auxiliar=array[array.length];
		
		for(int i=array.length-1;i>0;i--) {
			array[i]=array[i-1];
		}
			
	}

	/**
	 * Muestra una matriz
	 * @param matriz Matriz que le vamos a pasar
	 */
	public static void mostrarMatriz (int matriz[][]) {
		
		for (int fila = 0; fila < matriz.length; fila++) {
	
			for (int columna = 0; columna < matriz.length; columna++) {
				System.out.print("\t"+matriz[fila][columna]);
			}
			
			System.out.println("\n");
		}
		
	}
	
	/**
	 * Inicializa una matriz con numeros aleatorios
	 * @param matriz Matriz que le vamos a pasar
	 * @param min Numero minimo que pede salir del numero aleatorio
	 * @param max numero maximo que puede salir en el numero aleatorio
	 */
	public static void inicializarMatrizConNumerosleatorios (int matriz[][], int min, int max) {
		
		for (int fila = 0; fila < matriz.length; fila++) {
			for (int columna = 0; columna < matriz.length; columna++) {
				matriz[fila][columna]=Utils.numeroAleatorioEntreDosNumeros(min,max);
			}
		}
		
	}
	
	/**
	 * Comprueba si la matriz es positiva
	 * @param matriz
	 */
	public static void comprobarMatrizPositiva (int matriz[][]) {
		
		boolean matrizPositiva=true;
		
		for (int fila = 0; fila < matriz.length; fila++) {
			
			for (int columna = 0; columna < matriz.length; columna++) {
				
				if(matriz[fila][columna]<0) {
					matrizPositiva=false;
					break;
				}
				
			}
			
			if(!matrizPositiva) {
				break;
			}
		}
		
		if(matrizPositiva) {
			System.out.println("La matriz es positiva");
		}else System.out.println("La matriz no es positiva");
		
	}
	
	/**
	 * Comprueba si la matriz es diagonal
	 * @param matriz Matriz que le vamos a pasar
	 */
	public static void comprobarMatrizDiagonal (int matriz[][]) {
		
		boolean matrizDiagonal=true;
		
		for (int fila = 0; fila < matriz.length; fila++) {
			
			for (int columna = 0; columna < matriz.length; columna++) {
				
				if(fila!=columna&&matriz[fila][columna]!=0 || fila==columna&&matriz[fila][columna]==0) {
					matrizDiagonal=false;
					break;
				}
				
			}
			
			if(!matrizDiagonal) {
				break;
			}
		}
		
		if(matrizDiagonal) {
			System.out.println("La matriz es diagonal");
		}else System.out.println("La matriz no es diagonal");
		
	}
	
	/**
	 * Comprueva si la matriz es triangular superior
	 * @param matriz Matriz que le vamos a pasar
	 */
	public static void comprobarMatrizTriangularSuperior (int matriz[][]) {
		
		boolean matrizTriangular=true;
		
		for (int fila = 0; fila < matriz.length; fila++) {
			
			for (int columna = 0; columna < matriz.length; columna++) {
				
				if(fila==columna) {
					break;
				}if(matriz[fila][columna]!=0) {
					matrizTriangular=false;
					break;
				}
				
			}
			
			if(!matrizTriangular) {
				break;
			}
		}
		
		if(matrizTriangular) {
			System.out.println("La matriz es triangular superior");
		}else System.out.println("La matriz no es triangular superior");
		
	}
	
	/**
	 * Comprueba si es una matriz dispersa
	 * @param matriz Matriz que le vamos a pasar
	 */
	public static void comprobarMatrizDispersa (int matriz[][]) {
		
		int contadorFila=0;
		int contadorColumna=0;
		
		for (int fila = 0; fila < matriz.length; fila++) {
			
			for (int columna = 0; columna < matriz.length; columna++) {
				
				if(matriz[fila][columna]==0) {
					contadorFila++;
					break;
				}

			}
			
		}
		
		for (int fila = 0; fila < matriz.length; fila++) {
			
			for (int columna = 0; columna < matriz.length; columna++) {
				
				if(matriz[columna][fila]==0) {
					contadorColumna++;
					break;
				}
				
			}
			
		}
		
		if(contadorFila==matriz.length&&contadorColumna==matriz.length) {
			System.out.println("La matriz es dispersa");
		}else System.out.println("La matriz no es dispersa");
		
	}
		
	/**
	 * Convierte la matriz en un array
	 * @param matriz Matriz que le vamos a pasar
	 * @param dimensionesMatriz
	 */
	public static void convertirMatrizEnArray (int matriz[][], int dimensionesMatriz) {
		
		int[] array=new int[dimensionesMatriz*=dimensionesMatriz];
		int indice=0;
		
		
		for (int fila = 0; fila < matriz.length; fila++) {
			
			for (int columna = 0; columna < matriz.length; columna++) {
				
				array[indice]=matriz[fila][columna];
				indice++;
				
			}
			
		}
		
		Utils.mostrarArray(array);
		
	}
	
	/**
	 * Muestra una fecha dentro de un Calendar con un farmato
	 * @param fechaParaMostrar el Calendar del que queremos mostrar la fecha
	 * @param msg Mensaje que aparecera junto a la fecha formateada
	 * @param patron Patron del formato de la fecha
	 */
	public static void mostrarFechaFormateada (Calendar fechaParaMostrar, String msg, String patron) {
		
		Date fecha =new Date();
		SimpleDateFormat filtro = new SimpleDateFormat(patron);
		
		fecha=fechaParaMostrar.getTime();
		
		if (msg==null) {
			
			System.out.println(filtro.format(fecha));
			
		}else System.out.println(msg+filtro.format(fecha));
		
	}

}