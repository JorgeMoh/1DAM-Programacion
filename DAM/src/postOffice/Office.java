package postOffice;

import java.util.ArrayList;
import java.util.HashMap;

import utils.Utils;

public class Office {

	String usuarioIntroducido="";
	int contrasenyaIntroducida=0000;
	Usuario usuarioLogueado=new Usuario("", 0, false);
	
	HashMap<Integer,Usuario> usuarios= new HashMap<Integer, Usuario>();
	ArrayList<Paquete> paquetes= new ArrayList<Paquete>();
	
	Office(){
		
		usuarios.put(4321, new Usuario("admin", 4321, true));
		usuarios.put(0000, new Usuario("usuario", 0000, false));
		
		while(true) {
			System.out.println("-------------------------------------------------");
			System.out.println("(si ya has enviado un paquete se habra creado un \nusuario con el nombre del destinatario y la clave \ncorresponde a la id del paquete)");
			System.out.println("-------------------------------------------------\n");
			this.usuarioIntroducido=Utils.pedirTextoUsuario("Nombre de Usuario:");	
			this.contrasenyaIntroducida=Utils.pedirNumeroUsuario("Pin:");
		
			for (Usuario usuario : usuarios.values()) {
			
				if (usuario.getNombreUsuario().equals(usuarioIntroducido) && usuario.getClave()==contrasenyaIntroducida && !usuario.isAdmin()) {
            	System.out.println("hay usuario");
            	this.usuarioLogueado=usuario;
            	menuUsuario(usuarioLogueado);

				}if(usuario.getNombreUsuario().equals(usuarioIntroducido) && usuario.getClave()==contrasenyaIntroducida && usuario.isAdmin()) {
            	System.out.println("Hay admin");
            	menuAdmin(usuarioLogueado);
				
				}
            
			}
			
		}
		
	}

	private void menuAdmin(Usuario usuarioLogueado) {
		
		boolean salirMenuAdmin=false;
		int seleccionAdmin=0;
		
		System.out.println("--------------------------------------------\nMenu de Administrador\n--------------------------------------------\n");
		
		do {
			
			seleccionAdmin=Utils.pedirNumeroUsuario("¿Que quiere hacer?\n1.Gestionar paquetes\n2.Enviar paquete\n3.Salir");
			switch(seleccionAdmin) {
			
			case 1:
				break;
				
			}
			
		}while(!salirMenuAdmin);
	}

	private void menuUsuario(Usuario usuarioLogueado) {
		
		int seleccionUsuario=0;
		boolean salirMenuUsuario=false;
	
		
		System.out.println("--------------------------------------------\nMenu de Usuario\n--------------------------------------------\n");
		do {
			
			seleccionUsuario=Utils.pedirNumeroUsuario("¿Que quiere hacer?\n1.Recivir paquete\n2.Enviar paquete\n3.Salir");
			
			switch(seleccionUsuario) {
				case 1:
					for (int i = 0; i < paquetes.size(); i++) {
						
						if(paquetes.get(i).getId()==usuarioLogueado.getClave()) {
							System.out.println("--------------------------------------------\nAqui teniene su paquete: \n"+paquetes.get(i));
							paquetes.remove(i);
						} else System.out.println("No tiene ningun paquete que recoger");
						
					}
					break;
				
				case 2:
					Paquete nuevoPaquete= new Paquete();
					Usuario nuevoUsuario= new Usuario(nuevoPaquete.getReceptor(), nuevoPaquete.getId(), false);
					usuarios.put(nuevoPaquete.getId(), nuevoUsuario);
					paquetes.add(nuevoPaquete);
					
					System.out.println("--------------------------------------------\nResumen del paquete:");
					for (int j = 0; j < paquetes.size(); j++) {
						System.out.println(paquetes.get(j));
					}
					break;
				
				case 3:
					salirMenuUsuario=true;
					break;
				
			}
			
		}while(!salirMenuUsuario);
		
	}
	
}
