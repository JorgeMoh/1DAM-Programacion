package entregas;

import java.util.Scanner;

import utils.Utils;

public class WeatherForecast {

	public static void main(String[] args) {
		
		int estacion=0;
		int clima=0;
		int tempMax=0;
		int tempMin=0;
		
		Scanner sc=new Scanner(System.in);

		System.out.println("1. Primavera");
		System.out.println("2. Verano");
		System.out.println("3. Otoño");
		System.out.println("4. Invierno");
		System.out.println("Seleccione epoca del año");
		estacion=sc.nextInt();
		
		System.out.println("       Pronostico       ");
		System.out.println("------------------------");
		switch(estacion){
			case 1:
				tempMax=Utils.numeroAleatorioEntreDosNumeros(10, 39);
				tempMin=Utils.numeroAleatorioEntreDosNumeros(10, tempMax);
				System.out.println("Temperatura maxima: "+tempMax+"º");
				System.out.println("Temperatura Minima: "+tempMin+"º");
				clima=Utils.numeroAleatorioEntreDosNumeros(0, 100);
				if(clima>=60) {
					System.out.println("Clima: Soleado");
				}else System.out.println("Clima: Nublado");
				break;
			case 2:
				tempMax=Utils.numeroAleatorioEntreDosNumeros(20, 45);
				tempMin=Utils.numeroAleatorioEntreDosNumeros(20, tempMax);
				System.out.println("Temperatura maxima: "+tempMax+"º");
				System.out.println("Temperatura Minima: "+tempMin+"º");
				clima=Utils.numeroAleatorioEntreDosNumeros(0, 100);
				if(clima>=90) {
					System.out.println("Clima: Soleado");
				}else System.out.println("Clima: Nublado");
				break;
			case 3:
				tempMax=Utils.numeroAleatorioEntreDosNumeros(5, 33);
				tempMin=Utils.numeroAleatorioEntreDosNumeros(5, tempMax);
				System.out.println("Temperatura maxima: "+tempMax+"º");
				System.out.println("Temperatura Minima: "+tempMin+"º");
				clima=Utils.numeroAleatorioEntreDosNumeros(0, 100);
				if(clima>50) {
					System.out.println("Clima: Soleado");
				}else System.out.println("Clima: Nublado");
				break;
			case 4:
				tempMax=Utils.numeroAleatorioEntreDosNumeros(1, 28);
				tempMin=Utils.numeroAleatorioEntreDosNumeros(1, tempMax);
				System.out.println("Temperatura maxima: "+tempMax+"º");
				System.out.println("Temperatura Minima: "+tempMin+"º");
				clima=Utils.numeroAleatorioEntreDosNumeros(0, 100);
				if(clima<=40) {
					System.out.println("Clima: Soleado");
				}else System.out.println("Clima: Nublado");
				break;
		}
		sc.close();
	}

}
