package examenes.examen20241106;

import utils.Utils;

public class Ejercicio3 {

	public static void main(String[] args) {

		boolean haySuma=false;
		int[]array=new int[10];
		Utils.inicializarArrayConNumerosAleatorios(array, 1, 30);
		Utils.mostrarArray(array);
		int numero=Utils.pedirNumeroUsuario("Dime un numero para buscar su suma");
		
		for(int i=0;i<array.length;i++) {
			//este bucle compara los numeros con las diferentes posiciones para ver
			for(int j=i+1;j<array.length;j++) {
				if(numero==array[i]+array[j]) {
					haySuma=true;
					System.out.println("La suma del nuemero "+array[i]+" en la posicion "+i+" y el numero "+array[j]
							+" en la posicion "+j+" dan tu numero");
				}
			}
		}
		//si no hay una suma posible enviara un mensaje al usuario
		if(haySuma==false) {
			System.out.println("No hay ninguna suma posible para tu numero");
		}
	}

}
