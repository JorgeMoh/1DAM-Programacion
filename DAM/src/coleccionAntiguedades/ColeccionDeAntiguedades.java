package coleccionAntiguedades;

import utils.Utils;

public class ColeccionDeAntiguedades {

	public static void main(String[] args) {

		int tipoAntig=0;
		int indiceJoya=0;
		int indiceLibro=0;
		int indiceMueble=0;
		int indiceCuadro=0;	
		
	Joya[] joya=new Joya[Utils.pedirNumeroUsuario("¿Cuantas joyas vas a meter?")];
	Libro[] libro=new Libro[Utils.pedirNumeroUsuario("¿Cuantos libros vas a meter?")];
	Mueble[] mueble=new Mueble[Utils.pedirNumeroUsuario("¿Cuantos muebles vas a meter?")];
	Cuadro[] cuadro=new Cuadro[Utils.pedirNumeroUsuario("¿Cuantos cuadros vas a meter?")];

	boolean capacidadMaxima = false;
	//Un blucle que se ejecutara hasta que el usuario quiera salir o se hayan registrado todos las
	//antiguedades que querias meter
	do {
		
		System.out.println("¿Que tipo de antiguedad deseas registrar?");
		tipoAntig=Utils.pedirNumeroUsuario("0.Joya\n1.Libro\n2.Mueble\n3.Cuadro\n4.Salir");
		
		//Este swich se usa para llamar al metodo y aumentar el indice asignado a cada array
		switch(tipoAntig) {
		case 0:
			if(indiceJoya<joya.length) {
				//Llama al metodo, al cual le pasa el indice de la antiguedad, los arrays y el 
				//tipo de antiguedad que has dicho que vas ha meter
				introducirDatosAntiguedades(tipoAntig, indiceJoya, joya, libro, mueble, cuadro);
				System.out.println(joya[indiceJoya]);
				indiceJoya++;
			}else System.out.println("Ya has metido todas las joyas");
			break;
			
		case 1:
			if(indiceLibro<libro.length) {
				introducirDatosAntiguedades(tipoAntig, indiceLibro, joya, libro, mueble, cuadro);
				System.out.println(libro[indiceLibro]);
				indiceLibro++;
			}else System.out.println("Ya has metido todos las libro");
			break;
			
		case 2:
			if(indiceMueble<mueble.length) {
				introducirDatosAntiguedades(tipoAntig, indiceMueble, joya, libro, mueble, cuadro);
				System.out.println(mueble[indiceMueble]);
				indiceMueble++;
			}else System.out.println("Ya has metido todos las mueble");
			break;
			
		case 3:
			if(indiceCuadro<cuadro.length) {
				introducirDatosAntiguedades(tipoAntig, indiceCuadro, joya, libro, mueble, cuadro);
				System.out.println(cuadro[indiceCuadro]);
				indiceCuadro++;
			}else System.out.println("Ya has metido todos las cuadro");
			break;
		}	
		//Este if identifica si todos los array estan llenos y si es asi
		if(joya.length==indiceJoya 
				&&indiceLibro==libro.length
				&&indiceMueble==mueble.length
				&&indiceCuadro==cuadro.length) {
			capacidadMaxima = true;
			System.out.println("---------------------------------------------------");
			System.out.println("Has introducido el máximo de todos las antiguedades");
		}
		
	//Por como funciona el while, no se usa ||, por que no funciona igual que en el if sino que su funcionamiento es similar al &&
	// y el && funciona similar al ||
	}while(tipoAntig!=4 && !capacidadMaxima);
	
	System.out.println("Registro realizado");
	
	}
	
	private static void introducirDatosAntiguedades(int tipoAntig,int indice, Joya[] joya, Libro[] libro, Mueble[] mueble,Cuadro[] cuadro) {
		
		//cada vez que se llama al metodo, este switch recibe el tipo de antiguedad que se va a registrar
		switch(tipoAntig) {
		//cada caso crea una nueva antiguedad, del tipo seleccionado, dentro de su array correspondiente
		case 0:
			joya[indice] = new Joya();
			joya[indice].setNombre(Utils.pedirTextoUsuario("¿Como se llama?"));
			joya[indice].setOrigen(Utils.pedirTextoUsuario("¿De donde es?"));
			joya[indice].setAnoDeFabri(Utils.pedirNumeroUsuario("¿En que año se fabrico?"));
			joya[indice].setMateriales(Utils.pedirTextoUsuario("¿De que esta hecho?"));
			joya[indice].setPrecio(Utils.pedirNumeroUsuario("¿Cuanto vale?"));
			break;
		
		case 1:
			libro[indice] = new Libro();
			libro[indice].setNombre(Utils.pedirTextoUsuario("¿Como se llama?"));
			libro[indice].setAutor(Utils.pedirTextoUsuario("¿Quien lo escribio?"));
			libro[indice].setOrigen(Utils.pedirTextoUsuario("¿De donde es?"));
			libro[indice].setAnoDeFabri(Utils.pedirNumeroUsuario("¿En que año se fabrico?"));
			libro[indice].setPrecio(Utils.pedirNumeroUsuario("¿Cuanto vale?"));
			break;
		
		case 2:
			mueble[indice] = new Mueble();
			mueble[indice].setNombre(Utils.pedirTextoUsuario("¿Como se llama?"));
			mueble[indice].setEstilo(Utils.pedirTextoUsuario("¿Que estilo tiene?"));
			mueble[indice].setOrigen(Utils.pedirTextoUsuario("¿De donde es?"));
			mueble[indice].setAnoDeFabri(Utils.pedirNumeroUsuario("¿En que año se fabrico?"));
			mueble[indice].setPrecio(Utils.pedirNumeroUsuario("¿Cuanto vale?"));
			break;
		
		case 3:
			cuadro[indice] = new Cuadro();
			cuadro[indice].setNombre(Utils.pedirTextoUsuario("¿Como se llama?"));
			cuadro[indice].setTipoPintura(Utils.pedirTextoUsuario("¿Que tipo de pintura es?"));
			cuadro[indice].setOrigen(Utils.pedirTextoUsuario("¿De donde es?"));
			cuadro[indice].setAnoDeFabri(Utils.pedirNumeroUsuario("¿En que año se fabrico?"));
			cuadro[indice].setPrecio(Utils.pedirNumeroUsuario("¿Cuanto vale?"));
			break;		
		}
		
	}

}
