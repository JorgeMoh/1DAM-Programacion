package petShop;

import utils.Utils;

public class Principal {

	public static void main(String[] args) {
		
		Tienda badulake = new Tienda(0, 0, 0, 0, 0, 0, 0);		

		int seleccion=0;
		boolean salir=true;
		
		//donde se guardaran los animales que compremos
		Perro[] carritoPerros= new Perro[3];
		Gato[] carritoGatos= new Gato[4];
		Pajaro[] carritoPajaros=new Pajaro[6];
		Rata[] carritoRatas=new Rata[7];
		
		System.out.println("Bienvenido a la tienda");

		//El bucle desarrolla el menu
		do {
			seleccion=0;
			System.out.println("--------------------------------------------");
			System.out.println("¿Que quiere hacer?");
			seleccion=Utils.pedirNumeroUsuario("1.Comprar un animal\n2.Ver Carrito\n3.Consultar comidas\n4.Salir");
			
			switch(seleccion) {
			//En este caso llama al metodo que permite comprar animales
			case 1:
				badulake.comprarAnimal(carritoPerros, carritoGatos, carritoPajaros, carritoRatas);
				break;
				
			//Este metodo que lleva al menu del carrito donde podremos ver los animales por su codigo ean, ver si se pueden aparear, etc
			case 2:
				badulake.carrito(carritoPerros, carritoGatos, carritoPajaros, carritoRatas);
				break;
				
			//nos muestra la comida que le gusta al animal que selecciones
			case 3:
				badulake.verComida();
				break;
				
			//sale del bucle
			case 4:
				salir=false;
				break;
			}
			
		}while(salir);
		
	}

}
