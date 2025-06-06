package clase;

import java.util.ArrayList;

public class EjemplosArrayList {

	public static void main(String[] args) {

		//Se declara el arraylist
		ArrayList<String> pokedex= new ArrayList<String>();
		
		pokedex.add("Umbreon");
		pokedex.add("Whimsicott");
		pokedex.add("Zoroark(hisui)");
		pokedex.add("Ursaluna");
		pokedex.add("Escavalier");
		pokedex.add("Nidoking");
		pokedex.add("Lugia");
		pokedex.add(6, "Darkrai");
		
		System.out.println(pokedex);
		
		System.out.println("\n"+pokedex.size());

		
	}

}
