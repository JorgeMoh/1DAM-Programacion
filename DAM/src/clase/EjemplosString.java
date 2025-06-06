package clase;

import utils.Utils;

public class EjemplosString {

	public static void main(String[] args) {

		String texto=Utils.pedirTextoUsuario("Escribe algo");
		
//		Utils.mostrarTextoInvertido(texto);
//		Utils.contarVocalesConsonantes(texto);
//		Utils.comprobarPalindromo(texto);
		Utils.contarCaracteres(texto);
		
		texto.charAt(3);
		System.out.println(texto);
		
	}
	
}
