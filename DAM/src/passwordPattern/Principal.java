package passwordPattern;

import utils.Utils;

public class Principal {

	public static void main(String[] args) {

		ExcepcionesPers validarContrasenia = new ExcepcionesPers();
		String contrasenia = Utils.pedirTextoUsuario("--------------------------------------------------------\n\t\tIntroduce una contraseña\n"
				+ "(Esta debe estar compuesta por: 6 numeros, un # y un *)\n--------------------------------------------------------\nContraseña: ");
		
		try {
			validarContrasenia.verificarContrasenia(contrasenia);
			System.out.println("\nEnhorabuena, eres capaz de seguir un patron");
		} catch (ComprobarContrasenia e) {
			e.printStackTrace();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	}

}
