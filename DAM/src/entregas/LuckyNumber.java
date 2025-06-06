package entregas;

import java.util.Scanner;

public class LuckyNumber {

	public static void main(String[] args) {

		int numero=0;
		int auxiliar=0;
		int buenaSuerte=0;
		int malaSuerte=0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Dime tu numero para comprobar si vas a tener suerte o no");
		numero=sc.nextInt();
		
		System.out.println("El numero: "+numero);
		for(int i=0;;i++){
			auxiliar=numero%10;
			numero/=10;
			switch(auxiliar) {
			case 3,7,8,9:
				buenaSuerte++;
				break;
			case 0,1,2,4,5,6:
				malaSuerte++;
				break;
			}
			if(numero==0) {
				break;
			}
		}
		if(buenaSuerte>malaSuerte) {
			System.out.println("Es un numero de la suerte");
		}else if(buenaSuerte<malaSuerte) {
			System.out.println("No es un numero de la suerte");
		}else System.out.println("No se si es un numero de la suerte");
		
		sc.close();
	}

}
