package passwordPattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExcepcionesPers {

	ExcepcionesPers(){
		
	}

	 void verificarContrasenia (String contrasenia) throws ComprobarContrasenia{

//		Comprueba si hay una letra
		Pattern patron = Pattern.compile("[a-zA-Z]+");
		Matcher comparador = patron.matcher(contrasenia);
		
		if(comparador.find()) {
			throw new ComprobarContrasenia("¿Sabes lo que es un numero maquina?", 0);
		};
		
//		Comprueba si hay un numero negativo
		patron = Pattern.compile("-[1-9]");
		comparador = patron.matcher(contrasenia);
		
		if(comparador.find()) {
			throw new ComprobarContrasenia("No me valen los numeros negativos monstruo", 1);
		};
		
//		Comprueba si hay 8 caracteres de los seleccionados
		patron = Pattern.compile("^[0-9#*]{8,}$");
		comparador = patron.matcher(contrasenia);
		
		if(!comparador.find()) {
			throw new ComprobarContrasenia("Un poco mas larga tifon", 2);
		};
		
//		Comprueba si hay una #
		patron = Pattern.compile("[#]");
		comparador = patron.matcher(contrasenia);
		
		if(!comparador.find()) {
			throw new ComprobarContrasenia("¿La # donde te lo dejas fiera?", 3);
		};
		
//		Comprueba si hay un *
		patron = Pattern.compile("[*]");
		comparador = patron.matcher(contrasenia);
		
		if(!comparador.find()) {
			throw new ComprobarContrasenia("¿El * donde te lo dejas mastodonte?", 4);
		};
		
//		Comprueba si algo no cuadra
		patron = Pattern.compile("^[0-9#*]{8}$");
		comparador = patron.matcher(contrasenia);

		if(!comparador.find()) {
			throw new ComprobarContrasenia("Ni pa seguir un patron sirves", 5);
		};
		
	}
	
	
	
}
