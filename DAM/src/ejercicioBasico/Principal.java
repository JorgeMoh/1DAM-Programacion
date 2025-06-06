package ejercicioBasico;

import java.util.Scanner;

import utils.Utils;

public class Principal {

	public static void main(String[] args) {

		int numeroPersonas=Utils.pedirNumeroUsuario("¿Cuantas personas quieres introducir?");
		Persona[] persona=new Persona[numeroPersonas];
		int opcion=0;
		int nPersona=0;
		
		do {
			
			System.out.println("Introduce una opcion");
			opcion=Utils.pedirNumeroUsuario("\t0-Salir\n\t1-introducir datos\n\t2-Ver persona");
			switch(opcion) {
			case 0:
				System.out.println("Adios");
				break;
			case 1:
				if(nPersona!=persona.length-1) {
					introducirDatos(nPersona,persona);
				}else System.out.println("No puedes introducir mas personas");
				break;
			case 2: 
				mostrarDatos(nPersona,persona);
				break;
			default:
				System.out.println("Opcion invalida");
				break;
			}
			nPersona++;
		}while(opcion !=0 || nPersona<numeroPersonas);

		
	}

	private static void mostrarDatos(int nPersona,Persona[] persona) {

		System.out.println("Los datos:");
		
		for(int i = 0; i<persona.length;i++) {
			if(persona[i]!=null) {
				System.out.println("Nombre: "+persona[nPersona].getNombre());
				System.out.println("DNI: "+persona[nPersona].getDni());
				System.out.println("Edad: "+persona[nPersona].getEdad());
				System.out.println("Direccion:"+persona[nPersona].getDireccion());
			}
		}

		
	}

	private static void introducirDatos(int nPersona,Persona[] persona) {
		
		persona[nPersona]=new Persona();
		persona[nPersona].setNombre(Utils.pedirTextoUsuario("Dame un nombre"));
		persona[nPersona].setDni(Utils.pedirTextoUsuario("Dame tu DNI"));
		persona[nPersona].setEdad(Utils.pedirNumeroUsuario("Dame tu edad"));
		persona[nPersona].setDireccion(Utils.pedirTextoUsuario("Dame tu direccion"));
		
	}

}
