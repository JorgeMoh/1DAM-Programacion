package busDrivePlace;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.Utils;

public class Principal {
		
	public static void main(String[] args) {
			
		ConexionSQL c = new ConexionSQL();
		int eleccion = 0;
		boolean salir=false;
		
		try {
			
			do {
				
				eleccion=Utils.pedirNumeroUsuario("----------------------------------------\n\n\t¿Que quieres hacer?\n1.Buscar\n2.Insertar\n3.Actualizar dias de las rutas\n4.Borrar ruta\n5.Salir\n");
				
				switch(eleccion) {
				case 1:
					eleccion=Utils.pedirNumeroUsuario("\n----------------------------------------\n\n\t¿Que quieres buscar?"
													+ "\n1.Conductor\n2.Dia de una ruta\n3.Conductor de un bus\n4.Salir\n");
					switch(eleccion) {
					case 1:
						c.buscarConductorPorNumero();
						break;
						
					case 2:
						System.out.println("\n----------------------------------------\n\nIntroduce los datos requeridos\n");
						c.buscarDiaRutaPorCiudad();
						break;
						
					case 3:
						System.out.println("\n----------------------------------------\n\nIntroduce los datos requeridos\n");
						c.buscarCondPorRegistro();
						break;
					
					case 4:
						break;
					}
					break;
					
				case 2:
					eleccion=Utils.pedirNumeroUsuario("\n----------------------------------------\n\n\t¿Que quieres insertar?"
													+ "\n1.Bus\n2.Conductor\n3.Lugar\n4.Ruta\n5.Salir\n");			
					switch(eleccion) {
					case 1:
						System.out.println("\n----------------------------------------\n\nIntroduce los datos requeridos\n");
						c.insertarBus();
						break;
						
					case 2:
						System.out.println("\n----------------------------------------\n\nIntroduce los datos requeridos\n");
						c.insertarUnConductor();
						break;
						
					case 3:
						System.out.println("\n----------------------------------------\n\nIntroduce los datos requeridos\n");
						c.insertarLugar();
						break;
						
					case 4:
						System.out.println("\n----------------------------------------\n\nIntroduce los datos requeridos\n");
						c.insertarRuta();
						break;
						
					case 5:
						break;
					}
					break;
					
				case 3:
					System.out.println("\n----------------------------------------\n\nIntroduce los datos requeridos\n");
					c.actualizardiaDeLasRutas();
					break;
				
				case 4:
					c.borrarRuta();
					break;
					
				case 5:
					salir=true;
					break;
				
				}
				
			} while (!salir);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
