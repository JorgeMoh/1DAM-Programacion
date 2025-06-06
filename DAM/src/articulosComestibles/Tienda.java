package articulosComestibles;

import java.util.Iterator;

import utils.Utils;

public class Tienda {

	public static void main(String[] args) {
		
		int tipoArt=0;
		int artPere=0;
		int artNoPere=0;
		
		ArtPerecedero[] artPerecedero=new ArtPerecedero[2];
		artPerecedero[0]=new ArtPerecedero(0, null, 0, 0);
		artPerecedero[1]=new ArtPerecedero(0, null, 0, 0);
		
		ArtNoPerecedero[] artNoPerecedero=new ArtNoPerecedero[2];
		artNoPerecedero[0]=new ArtNoPerecedero(0, null, 0);
		artNoPerecedero[1]=new ArtNoPerecedero(0, null, 0);
		
		System.out.println("Inserta dos productos perecederos y dos no perecederos");
		
		for(int i=0;;i++) {

			System.out.println("¿Que tipo de ariculos vas a meter?");
			tipoArt=Utils.pedirNumeroUsuario("1.Perecedero\t2.No perecedero");
			
			if(tipoArt==1 && artPere<2) {
				introducirDatos(artPere, artPerecedero, artNoPerecedero,tipoArt);
				mostrarArt(artPere, artPerecedero, artNoPerecedero, tipoArt);
//				System.out.println(artPerecedero[artPere]);
				artPere++;
			}else if(tipoArt==1 && artPere==2){
				System.out.println("Ya has puesto los dos articulos perecederos");
			}
			
			if(tipoArt==2 && artNoPere<2) {
				introducirDatos(artNoPere, artPerecedero, artNoPerecedero,tipoArt);
				mostrarArt(artNoPere, artPerecedero, artNoPerecedero, tipoArt);
				artNoPere++;
			}else if(tipoArt==2 && artNoPere==2){
				System.out.println("Ya has puesto los dos articulos no perecederos");
			}
			
			if(artPere==2 && artNoPere==2) {
				System.out.println("Todos los datos ya han sido introducidos");
				break;
			}
		}
		
	}

	private static void introducirDatos(int i, ArtPerecedero[] artPerecedero, ArtNoPerecedero[] artNoPerecedero, int tipoArt) {
		
		if(tipoArt==1) {
			artPerecedero[i].setNombre(Utils.pedirTextoUsuario("¿Cual es el nombre del producto?"));
			artPerecedero[i].setCodigo(Utils.pedirNumeroUsuario("¿Cual es el codigo de este producto?"));
			artPerecedero[i].setPrecio(Utils.pedirNumeroUsuario("¿Cual es su precio?"));
			artPerecedero[i].setFechaCaducidad(Utils.pedirNumeroUsuario("¿Cuando caduca?"));
		}else{
			artNoPerecedero[i].setNombre(Utils.pedirTextoUsuario("¿Cual es el nombre del producto?"));
			artNoPerecedero[i].setCodigo(Utils.pedirNumeroUsuario("¿Cual es el codigo de este producto?"));
			artNoPerecedero[i].setPrecio(Utils.pedirNumeroUsuario("¿Cual es su precio?"));
		}
		
	}
	
	private static void mostrarArt(int i, ArtPerecedero[] artPerecedero, ArtNoPerecedero[] artNoPerecedero, int tipoArt) {

		if(tipoArt==1) {
			System.out.println("Nombre: "+artPerecedero[i].getNombre());
			System.out.println("Codigo: "+artPerecedero[i].getCodigo());
			System.out.println("Precio: "+artPerecedero[i].getPrecio()+"€");
			System.out.println("Fecha de caducidad: "+artPerecedero[i].getFechaCaducidad());
		}else{
			System.out.println("Nombre: "+artNoPerecedero[i].getNombre());
			System.out.println("Codigo: "+artNoPerecedero[i].getCodigo());
			System.out.println("Precio: "+artNoPerecedero[i].getPrecio()+"€");
		}

			
	}
}
