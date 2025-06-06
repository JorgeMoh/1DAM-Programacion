package clase;

import java.util.HashMap;

public class EjemplosHashMap {

	public static void main(String[] args) {
		
		HashMap<String, String> pokedex = new HashMap<String, String>();

		pokedex.put("Siniestro","Umbreon");
		pokedex.put("Planta","Whimsicott");
		pokedex.put("Fantasma","Zoroark(hisui)");
		pokedex.put("Tierra","Ursaluna");
		pokedex.put("Bicho","Escavalier");
		pokedex.put("Volador","Lugia");
		
		System.out.println(pokedex+"\n");
		

		
//		for (String i : pokedex.values()) {
//			  System.out.println(i);
//			}
//		
//		System.out.println("");
//		
//		for (String i : pokedex.keySet()) {
//			  System.out.println(i);
//			}
		
//		pokedex.remove("Tierra");
//		
//		System.out.println("\n"+pokedex);
//		
//		pokedex.clear();
//		
//		System.out.println("\n"+pokedex);
		
		System.out.println("\n"+pokedex.keySet());
		

		
	}

}
