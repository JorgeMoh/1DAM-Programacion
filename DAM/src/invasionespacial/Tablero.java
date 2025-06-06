package invasionespacial;

public class Tablero {

	public static void main(String[] args) {
		
		Humano[] humanos=new Humano[10];
		Invasor[] invasores=new Invasor[10];
		
		for(int i=0;i<humanos.length;i++) {
			humanos[i]=new Humano(i);
			System.out.println(humanos[i]);
		}
	
		for(int i=0;i<invasores.length;i++) {
			invasores[i]=new Invasor(i);
			System.out.println(invasores[i]);		}
	}

	
}
