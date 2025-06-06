package clase;

import utils.Utils;

public class EjemplosMatrices {

	public static void main(String[] args) {
		
//		int[][] matriz=new int[3][3];
		int[][] matriz=new int[][] {{1,0,1},{0,1,1},{1,1,0}};
		
//		Utils.inicializarMatrizConNumerosleatorios(matriz, 0, 15);
		Utils.mostrarMatriz(matriz);
		Utils.convertirMatrizEnArray(matriz,3);

	}

}
