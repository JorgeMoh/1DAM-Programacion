package entregas;

import java.util.Scanner;

public class Cinema {

	public static void main(String[] args) {
		
		int numeroDePersonas=0;
		int dia=0;
		double precioEntrada=0;		
		double precioFinal=0;
		int carnetEstudiante=0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("¿Cuantas personas sois?");
		numeroDePersonas=sc.nextInt();
		
		System.out.println("Selecciona el dia que quieres ir:");
		System.out.println("1-Lunes     2-Martes   3-Miercoles   4-Jueves");
		System.out.println("5-Viernes   6-Sabado   7-Domingo");
		dia=sc.nextInt();
		if(dia==3) {
			precioEntrada=5;
		}else if(dia==4 && numeroDePersonas==2) {
			precioEntrada=5.5;
		} else precioEntrada=8;
		precioFinal=precioEntrada*numeroDePersonas;
		
		System.out.println("¿Tiene el carnet de estudiante?");
		System.out.println("1-Si   2-No");
		carnetEstudiante=sc.nextInt();
		if(carnetEstudiante==1){
			precioFinal*=0.9;
		}
		
		System.out.println("           Ticket           ");
		System.out.println("----------------------------");
		System.out.println("nº de personas: "+numeroDePersonas);
		if(dia==1) {
			System.out.println("Dia: Lunes");
		}else if(dia==2) {
			System.out.println("Dia: Martes");
		}else if(dia==3) {
			System.out.println("Dia: Miercoles");
		}else if(dia==4) {
			System.out.println("Dia: Jueves");
		}else if(dia==5) {
			System.out.println("Dia: Viernes");
		}else if(dia==6) {
			System.out.println("Dia: Sabado");
		}else System.out.println("Dia: Domino");
		if(carnetEstudiante==1){
			System.out.println("Targeta de estudiante: Si");
		}else System.out.println("Targeta de estudiante: No");
		System.out.println("Precio: "+precioFinal+"€");
		sc.close();
		
	}

}
