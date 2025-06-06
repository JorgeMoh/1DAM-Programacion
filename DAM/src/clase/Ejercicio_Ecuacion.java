package clase;

import java.util.Scanner;
import utils.Utils;

public class Ejercicio_Ecuacion {

	public static void main(String[] args) {
		ej2();
	}
	
	public static void resolver() {
		double vp, vn = 0;
		int a, b, c;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un valor para a: ");
		a = sc.nextInt();
		System.out.println("Introduzca un valor para b: ");
		b = sc.nextInt();
		System.out.println("Introduzca un valor para c: ");
		c = sc.nextInt();
		
		double determinante = Math.sqrt(b*b-4*a*c);
		vp= (-b + determinante)/2*a;
		vn= (-b - determinante)/2*a;
		
		
		System.out.println("Para la ecuacion " +  a +"x²+" + b + "x+" + c +" = 0 sus soluciones son: " + vp + " y " + vn);
		
	}
	public static void aleatorio() {
		System.out.println("Aqui tienes un numero aleatorio " + Math.round(Math.random () ));
		
	}
	public static void pedir_numero() {

		
		Scanner sc = new Scanner(System.in);
		System.out.println("Dame un numero maximo");
		int numMax = sc.nextInt();
		System.out.println("Dame un numero minimo");
		int numMin = sc.nextInt();
		
		System.out.println("Tu numero aleatorio es ... " + Math.round(Math.random()*(numMax-numMin)+numMin));
		
	}

	//Ejercicios de operaciones y escaner
	public static void ej1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dame un número entero");
		int nEntero = sc.nextInt();
		System.out.println("Dame un número flotante");
		float nFloat = sc.nextFloat();
		System.out.println("Dame un número doble");
		double nDouble = sc.nextDouble();
		System.out.print("Tus números son " 
					+ nEntero + ", " 
					+ nFloat + " y " 
					+ nDouble );
		
		sc.close();
		}
	public static void ej2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dame un número entero");
		int nEntero = sc.nextInt();
		System.out.println("Dame un número flotante");
		float nFloat = sc.nextFloat();
		System.out.println("Dame un número doble");
		double nDouble = sc.nextDouble();
		System.out.println("Tus números son " + nEntero+ ",");
		System.out.println(nFloat);
		System.out.println("y " + nDouble);
		
		sc.close();
		}
	public static void ej3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dame un numero");
		int n1 = sc.nextInt();
		System.out.println("Dame otro numero");
		int n2 = sc.nextInt();
		System.out.println("Dame otro mas numero");
		int n3 = sc.nextInt();
		int n = n1+n2+n3;
		System.out.println("La sumas de tus numeros es: " + n  );
		
		sc.close();
	}
	public static void ej4() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Vamos a calcular la media de 3 numeros");
		System.out.println("Dame un numero");
		int n1 = sc.nextInt();
		System.out.println("Dame otro numero");
		int n2 = sc.nextInt();
		System.out.println("Dame otro mas numero");
		int n3 = sc.nextInt();
		float media = (n1+n2+n3)/3;
		System.out.println("La media de tus numeros es: " + media );
		
		sc.close();
	}
	public static void ej5() {
		
		int v3 = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Dame una valor");
		int v1 = sc.nextInt();
		System.out.println("Dame otra variable");
		int v2 = sc.nextInt();
		v3 = v1; 
		System.out.println("Tu primera variable es " + v1 + " tu segunda variable es " + v2);
		v1 = v2;
		v2 = v3;
		System.out.println("Tu primera variables intercambiadas es  " + v1 + " y tu segunda variable es " + v2);
		
		sc.close();
	}
	public static void ej6() {
		Scanner sc = new Scanner(System.in);
		float euribor;
		float diferencial;
		float capital;
		int n;
		float in;
		float inM;
		float cm;
		System.out.println("Introduce el euribor");
		euribor = sc.nextFloat();
		System.out.println("Introduce el numero de plazos mensuales");
		n = sc.nextInt();
		System.out.println("Introduce el diferencial");
		diferencial = sc.nextFloat();
		System.out.println("Introduce el capital");
		capital = sc.nextFloat();
		in = euribor + diferencial;
		inM = (in/12)/100;
		cm = (float) (capital * (inM/1-Math.pow((1+inM),n)));
		sc.close();
		
		
		
		
		
		
}

	//Ejercicios de if
	public static void ej7() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Dime dos variables");
		int V1 = sc.nextInt();
		int V2 = sc.nextInt();
		
		if(V1 > V2) {
			System.out.println("la variable " + V1 + " es mayor");
		}else {
			System.out.println("la variable " + V2 + " es mayor");
		}
		sc.close();
		
	}
	public static void ej8() {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Dime dos variables");
		int V1 = sc.nextInt();
		int V2 = sc.nextInt();
		
		if(V1 < V2) {
			System.out.println("la variable " + V1 + " es menor");
		}else {
			System.out.println("la variable " + V2 + " es menor");
		}
		sc.close();
		
	}
	public static void ej9() {
		
		int N1 = Utils.pedirNumeroUsuario("Dime un numero");
		int N2 = Utils.pedirNumeroUsuario("Dime un numero");
		int N3 = Utils.pedirNumeroUsuario("Dime un numero");
		int N4 = Utils.pedirNumeroUsuario("Dime un numero");
		int N5 = Utils.pedirNumeroUsuario("Dime un numero");
		
		if(N1>N2 && N1>N3 && N1>N4 && N1>N5) {
			System.out.println("El numero mayor es: " + N1);
		} else if(N2>N3 && N2>N4 && N2>N5) {
			System.out.println("El numero mayor es: " + N2);
		} else if(N3>N4 && N3>N5) {
			System.out.println("El numero mayor es: " + N3);
		} else if(N4>N5) {
			System.out.println("El numero mayor es: " + N4);
		} else {
			System.out.println("El numero mayor es: " + N5);
		}
		
	}
	public static void ej10() {
		
		int N1 = Utils.pedirNumeroUsuario("Dime un numero");
		int N2 = Utils.pedirNumeroUsuario("Dime un numero");
		int N3 = Utils.pedirNumeroUsuario("Dime un numero");
		int N4 = Utils.pedirNumeroUsuario("Dime un numero");
		int N5 = Utils.pedirNumeroUsuario("Dime un numero");
		
		if(N1<N2 && N1<N3 && N1<N4 && N1<N5) {
			System.out.println("El numero menor es: " + N1);
		} else if(N2<N3 && N2<N4 && N2<N5) {
			System.out.println("El numero menor es: " + N2);
		} else if(N3<N4 && N3<N5) {
			System.out.println("El numero menor es: " + N3);
		} else if(N4<N5) {
			System.out.println("El numero menor es: " + N4);
		} else {
			System.out.println("El numero menor es: " + N5);
		}
		
	}		
	public static void ej11() {
		
		int N1 = Utils.pedirNumeroUsuario("Dime un numero");
		int N2 = Utils.pedirNumeroUsuario("Dime un numero");
		int N3 = Utils.pedirNumeroUsuario("Dime un numero");
		int N4 = Utils.pedirNumeroUsuario("Dime un numero");
		int N5 = Utils.pedirNumeroUsuario("Dime un numero");
		
		if(N1>N2 && N1>N3 && N1>N4 && N1>N5) {
			System.out.println("El numero mayor es: " + N1);
		} else if(N2>N3 && N2>N4 && N2>N5) {
			System.out.println("El numero mayor es: " + N2);
		} else if(N3>N4 && N3>N5) {
			System.out.println("El numero mayor es: " + N3);
		} else if(N4>N5) {
			System.out.println("El numero mayor es: " + N4);
		} else {
			System.out.println("El numero mayor es: " + N5);
		}
		
		if(N1<N2 && N1<N3 && N1<N4 && N1<N5) {
			System.out.println("El numero menor es: " + N1);
		} else if(N2<N3 && N2<N4 && N2<N5) {
			System.out.println("El numero menor es: " + N2);
		} else if(N3<N4 && N3<N5) {
			System.out.println("El numero menor es: " + N3);
		} else if(N4<N5) {
			System.out.println("El numero menor es: " + N4);
		} else {
			System.out.println("El numero menor es: " + N5);
		}
		
	}
	public static void ej12() {
		
		int N1 = Utils.pedirNumeroUsuario("Dime un numero");
		
		if(N1%2 == 0) {
			System.out.println("Es par");
		}else {
			System.out.println("Es impar");
		}
		
	}
	public static void ej13() {
		
int N1 = Utils.pedirNumeroUsuario("Dime un numero");
		
		if(N1%2 == 0 && N1%2 != 1) {
			System.out.println("Es par");
		}else {
			System.out.println("Es impar");
		}
		
	}
	public static void ej14() {
		
		int numNegativo = 0;
		int numBajo = 0;
		int numMedio = 0;
		int numAlto = 0;
		int N1 = Utils.pedirNumeroUsuario("Dime un numero");
		int N2 = Utils.pedirNumeroUsuario("Dime un numero");
		int N3 = Utils.pedirNumeroUsuario("Dime un numero");
		int N4 = Utils.pedirNumeroUsuario("Dime un numero");
		int N5 = Utils.pedirNumeroUsuario("Dime un numero");
	
		if(N1 < 0) {
			numNegativo = numNegativo + N1;
		}else if(N1 >= 0 && N1 <= 25) {
			numBajo = numBajo + N1;
		}else if(N1 > 25 && N1 <= 250) {
			numMedio = numMedio + N1;
		}else if(N1 > 250) {
			numAlto = numAlto + N1;
		}
		
		if(N2 < 0) {
			numNegativo = numNegativo + N2;
		}else if(N2 >= 0 && N2 <= 25) {
			numBajo = numBajo + N2;
		}else if(N2 > 25 && N2 <= 250) {
			numMedio = numMedio + N2;
		}else if(N2 > 250) {
			numAlto = numAlto + N2;
		}
		
		if(N3 < 0) {
			numNegativo = numNegativo + N3;
		}else if(N3 >= 0 && N3 <= 25) {
			numBajo = numBajo + N3;
		}else if(N3 > 25 && N3 <= 250) {
			numMedio = numMedio + N3;
		}else if(N3 > 250) {
			numAlto = numAlto + N3;
		}
		
		if(N4 < 0) {
			numNegativo = numNegativo + N4;
		}else if(N4 >= 0 && N4 <= 25) {
			numBajo = numBajo + N4;
		}else if(N4 > 25 && N4 <= 250) {
			numMedio = numMedio + N4;
		}else if(N4 > 250) {
			numAlto = numAlto + N4;
		}
		
		if(N5 < 0) {
			numNegativo = numNegativo + N5;
		}else if(N5 >= 0 && N5 <= 25) {
			numBajo = numBajo + N5;
		}else if(N5 > 25 && N5 <= 250) {
			numMedio = numMedio + N5;
		}else if(N5 > 250) {
			numAlto = numAlto + N5;
		}
	
		System.out.println("la suma de los numeros negativos es: " + numNegativo);
		System.out.println("la suma de los numeros bajos es: " + numBajo);
		System.out.println("la suma de los numeros medios es: " + numMedio);
		System.out.println("la suma de los numeros altos es: " + numAlto);
		
	}
	public static void ej15() {
		
		int numNegativo = 0;
		int numBajo = 0;
		int numMedio = 0;
		int numAlto = 0;
		int N1 = Utils.pedirNumeroUsuario("Dime un numero");
		int N2 = Utils.pedirNumeroUsuario("Dime un numero");
		int N3 = Utils.pedirNumeroUsuario("Dime un numero");
		int N4 = Utils.pedirNumeroUsuario("Dime un numero");
		int N5 = Utils.pedirNumeroUsuario("Dime un numero");
	
		if(N1 < 0) {
			numNegativo = numNegativo + 1;
		}else if(N1 >= 0 && N1 <= 25) {
			numBajo = numBajo + 1;
		}else if(N1 > 25 && N1 <= 250) {
			numMedio = numMedio + 1;
		}else if(N1 > 250) {
			numAlto = numAlto + 1;
		}
		
		if(N2 < 0) {
			numNegativo = numNegativo + 1;
		}else if(N2 >= 0 && N2 <= 25) {
			numBajo = numBajo + 1;
		}else if(N2 > 25 && N2 <= 250) {
			numMedio = numMedio + 1;
		}else if(N2 > 250) {
			numAlto = numAlto + 1;
		}
		
		if(N3 < 0) {
			numNegativo = numNegativo + 1;
		}else if(N3 >= 0 && N3 <= 25) {
			numBajo = numBajo + 1;
		}else if(N3 > 25 && N3 <= 250) {
			numMedio = numMedio + 1;
		}else if(N3 > 250) {
			numAlto = numAlto + 1;
		}
		
		if(N4 < 0) {
			numNegativo = numNegativo + 1;
		}else if(N4 >= 0 && N4 <= 25) {
			numBajo = numBajo + 1;
		}else if(N4 > 25 && N4 <= 250) {
			numMedio = numMedio + 1;
		}else if(N4 > 250) {
			numAlto = numAlto + 1;
		}
		
		if(N5 < 0) {
			numNegativo = numNegativo + 1;
		}else if(N5 >= 0 && N5 <= 25) {
			numBajo = numBajo + 1;
		}else if(N5 > 25 && N5 <= 250) {
			numMedio = numMedio + 1;
		}else if(N5 > 250) {
			numAlto = numAlto + 1;
		}
	
		System.out.println("El total de numeros negativos es: " + numNegativo);
		System.out.println("El total de numeros bajos es: " + numBajo);
		System.out.println("El total de numeros medios es: " + numMedio);
		System.out.println("El total de numeros altos es: " + numAlto);
		
	}
	

	
	}

