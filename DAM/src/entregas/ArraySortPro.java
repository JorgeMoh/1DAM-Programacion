package entregas;

import utils.Utils;

public class ArraySortPro {

	public static void main(String[] args) {
		
		int auxiliar=0;
		boolean cambio=true;
		int[] array=new int[150];
		
		Utils.inicializarArrayConNumerosAleatorios(array, 0, 1000);
		Utils.mostrarArray(array);
		
		while (cambio) {
			cambio=false;
			for(int i=0;i<array.length-1;i++) {
				if(array[i]>array[i+1]) {
					cambio=true;
					auxiliar=array[i];
					array[i]=array[i+1];
					array[i+1]=auxiliar;
				}
			}
		}
		System.out.println("-----------------------------------"); 
		Utils.mostrarArray(array);

	}

}
