package petShop;

import utils.Utils;

public class Tienda {
	
	int numeroAnimales=0;
	int numeroMascotas=0;
	int perrosComp=0;
	int gatosComp=0;
	int pajarosComp=0;
	int ratasComp=0;
	int precioFinal=0;
	Perro[] perro=new Perro[3];
	Gato[] gato=new Gato[4];
	Pajaro[] pajaro=new Pajaro[6];
	Rata[] rata=new Rata[7];
	
	public Tienda(int numeroAnimales,int numeroMascotas,int perrosComp,int gatosComp,int pajarosComp,int ratasComp,int precioFina){
		this.numeroAnimales=numeroAnimales;
		this.numeroMascotas=numeroMascotas;
		this.perrosComp=perrosComp;
		this.gatosComp=gatosComp;
		this.pajarosComp=pajarosComp;
		this.ratasComp=ratasComp;
		this.precioFinal=precioFina;
		
		//perros, gatos, pajaros y ratas instanciados
		perro[0] = new Perro("Macho", 3, 12345679,9358, "", "", "", "", "Marrón", "Labrador", "Corto", true, 100);
		perro[1] = new Perro("Hembra", 2, 98765431,3273, "", "", "", "", "Negro", "Caniche", "Rizado", false, 100);
		perro[2] = new Perro("Macho", 5, 11223345,6394, "", "", "", "", "Blanco", "Golden Retriever", "Largo", true, 100);
		
        gato[0] = new Gato("Macho", 2, 12345689,4234, "", "", "", "", "Gris", "Siames", "Corto", 50);
        gato[1] = new Gato("Hembra", 1, 98765321,1876, "", "", "", "", "Blanco", "Angora", "Largo", 50);
		gato[2] = new Gato("Macho", 4, 11223445,8360, "", "", "", "", "Negro", "Bombay", "Corto", 50);
		gato[3] = new Gato("Hembra", 3, 55667789,5493, "", "", "", "", "Atigrado", "Bengala", "Corto", 50);
		
        pajaro[0] = new Pajaro("Macho", 1, 12345789, "Amarillo", "Canario", 10);
        pajaro[1] = new Pajaro("Hembra", 2, 98754321, "Azul", "Guacamayo", 10);
        pajaro[2] = new Pajaro("Macho", 3, 12233445, "Verde", "Loro", 10);
        pajaro[3] = new Pajaro("Hembra", 1, 55667889, "Rojo", "Cacatúa", 10);
        pajaro[4] = new Pajaro("Macho", 4, 99887765, "Negro", "Cuervo", 10);
        pajaro[5] = new Pajaro("Hembra", 2, 66778990, "Blanco", "Paloma", 10);
		
        rata[0] = new Rata("Macho", 1, 12456789, 500, 15, 2);
        rata[1] = new Rata("Hembra", 2, 97654321, 450, 3, 2);
        rata[2] = new Rata("Macho", 3, 11223344, 100, 18, 2);
        rata[3] = new Rata("Hembra", 1, 56677889, 400, 10, 2);
        rata[4] = new Rata("Macho", 2, 98877665, 550, 2, 2);
        rata[5] = new Rata("Hembra", 3, 67788990, 50, 16, 2);
        rata[6] = new Rata("Macho", 4, 445566778, 700, 20, 2);
	}
	
	public void comprarAnimal(Perro[] carritoPerros,Gato[] carritoGatos,Pajaro[] carritoPajaros,Rata[] carritoRatas) {
		 
		int seleccionCompra=0;
		boolean salirCompra=true;
		
        //Aqui se desarrolla el menu de compra
		do {
			seleccionCompra=0;
			System.out.println("--------------------------------------------");
			seleccionCompra=Utils.pedirNumeroUsuario("¿Que tipo de animal esta buscando?\n1.Perros\n2.Gatos\n3.Pajaros\n4.Ratas\n5.Salir");
			
			
			switch(seleccionCompra) {
			//cada caso guarda en el array corespondiente el animal deseado y incrementea los contadores correspondientes
			case 1:
				System.out.println("Estos son los perros que tenemos disponibles");
				mostrarAnimales(seleccionCompra,perro,gato,pajaro,rata);
				System.out.println("--------------------------------------------");
				for (int i = 0;; i++) {
					seleccionCompra=Utils.pedirNumeroUsuario("Elige un perro que quieras llevarte");
					carritoPerros[perrosComp]=perro[seleccionCompra];
					perrosComp++;
					numeroMascotas++;
					numeroAnimales++;
					seleccionCompra=Utils.pedirNumeroUsuario("¿Quieres comprar otro?\n1.Si\n2.No");
					if (seleccionCompra==2) {
						break;
					}
				}
				break;
				
			case 2:
				System.out.println("Estos son los gatos que tenemos disponibles");
				mostrarAnimales(seleccionCompra,perro,gato,pajaro,rata);
				System.out.println("--------------------------------------------");
				for (int i = 0;; i++) {
					seleccionCompra=Utils.pedirNumeroUsuario("Elige un gato que quieras llevarte");
					carritoGatos[gatosComp]=gato[seleccionCompra];
					gatosComp++;
					numeroMascotas++;
					numeroAnimales++;
					seleccionCompra=Utils.pedirNumeroUsuario("¿Quieres comprar otro?\n1.Si\n2.No");
					if (seleccionCompra==2) {
						break;
					}
				}
				break;
				
			case 3:
				System.out.println("Estos son los pajaros que tenemos disponibles");
				mostrarAnimales(seleccionCompra,perro,gato,pajaro,rata);
				System.out.println("--------------------------------------------");
				for (int i = 0;; i++) {
					seleccionCompra=Utils.pedirNumeroUsuario("Elige un pajaro que quieras llevarte");
					carritoPajaros[pajarosComp]=pajaro[seleccionCompra];
					pajarosComp++;
					numeroAnimales++;
					seleccionCompra=Utils.pedirNumeroUsuario("¿Quieres comprar otro?\n1.Si\n2.No");
					if (seleccionCompra==2) {
						break;
					}
				}
				break;
				
			case 4:
				System.out.println("Estos son las ratas que tenemos disponibles");
				mostrarAnimales(seleccionCompra,perro,gato,pajaro,rata);
				System.out.println("--------------------------------------------");
				for (int i = 0;; i++) {
					seleccionCompra=Utils.pedirNumeroUsuario("Elige un rata que quieras llevarte");
					if(rata[seleccionCompra].getPeso()<5&&rata[seleccionCompra].getTamaño()<200) {
						carritoRatas[ratasComp]=rata[seleccionCompra];
						ratasComp++;
						numeroAnimales++;
					}else System.out.println("Esa no puedes comprala");
					seleccionCompra=Utils.pedirNumeroUsuario("¿Quieres comprar otro?\n1.Si\n2.No");
					if (seleccionCompra==2) {
						break;
					}
				}
				break;
				
			//sale del bucle
			case 5:
				salirCompra=false;
				break;
			}
			
		}while(salirCompra);
        
	}

	public void mostrarAnimales(int seleccionCompra,Perro[] perro,Gato[] gato,Pajaro[] pajaro,Rata[] rata) {

		//muestra el stock del tipo de animal seleccionado
		switch(seleccionCompra) {
		
		case 1:
			for(int i=0;i<perro.length;i++) {
				System.out.println("Perro "+i+" "+perro[i]);
			}
			break;
		case 2:
			for(int j=0;j<gato.length;j++) {
				System.out.println("Gato "+j+" "+gato[j]);
			}
			break;
		case 3:
			for(int z=0;z<pajaro.length;z++) {
				System.out.println("Pajaro "+z+" "+pajaro[z]);
			}
			break;
		case 4:
			for(int x=0;x<rata.length;x++) {
				System.out.println("Rata "+x+" "+rata[x]);
			}
			break;
		
		}
		
	}
	
	public void carrito(Perro[] carritoPerros,Gato[] carritoGatos,Pajaro[] carritoPajaros,Rata[] carritoRatas) {
		
		int seleccionCarrito=0;
		boolean salirCarrito=true;
		
		//muestra el numero de perros y los perros que has comprado
		System.out.println("--------------------------------------------");
		System.out.println("Perros: "+perrosComp);
		for(int i=0;i<carritoPerros.length;i++) {
			if(carritoPerros[i]!=null) {
				System.out.println("Perro "+i+": "+carritoPerros[i]);
				precioFinal+=carritoPerros[i].getPrecio();				
			}
		}
		
		//muestra el numero de gatos y los gatos que has comprado
		System.out.println("\nGatos: "+gatosComp);
		for(int i=0;i<carritoGatos.length;i++) {
			if(carritoGatos[i]!=null) {
				System.out.println("Gato "+i+": "+carritoGatos[i]);
				precioFinal+=carritoGatos[i].getPrecio();
			}
		}
		
		//muestra el numero de pajaros y los pajaros que has comprado
		System.out.println("\nPajaros: "+pajarosComp);
		for(int i=0;i<carritoPajaros.length;i++) {
			if(carritoPajaros[i]!=null) {
				System.out.println("Pajaro "+i+": "+carritoPajaros[i]);
				precioFinal+=carritoPajaros[i].getPrecio();
			}
		}
		
		//muestra el numero de ratas y los ratas que has comprado
		System.out.println("\nRatas: "+ratasComp);
		for(int i=0;i<carritoRatas.length;i++) {
			if(carritoRatas[i]!=null) {
				System.out.println("Rata "+i+": "+carritoRatas[i]);
				precioFinal+=carritoRatas[i].getPrecio();
			}
		}
		
		//muestra el numero de mascotas, nuemro de animales y el precio total
		System.out.println("\nMascotas compradas: "+numeroMascotas);
		System.out.println("Animales totales comprados: "+numeroAnimales);
		System.out.println("Precio Final: "+precioFinal);
		
		//el menu del carrito
		do {
			System.out.println("--------------------------------------------");
			seleccionCarrito=Utils.pedirNumeroUsuario("¿Que quieres hacer?\n1.Ver datos del animal\n2.Comprobar apareamiento de mascotas\n3.Salir");
			
			switch(seleccionCarrito) {
			
			//va al metodo que muestra el animal que quieres poniento 
			case 1:
				verDatosAnimal(carritoPerros, carritoGatos, carritoPajaros, carritoRatas);
				break;
			
			//va al metodo que comprueba si se pueden aparear
			case 2:
				comprobarApareamiento(carritoPerros, carritoGatos);
			
			//sale del carrito
			case 3:
				salirCarrito=false;
				break;
			}
		}while(salirCarrito);
		
	}

	private void verDatosAnimal(Perro[] carritoPerros,Gato[] carritoGatos,Pajaro[] carritoPajaros,Rata[] carritoRatas) {

		System.out.println("--------------------------------------------");
		
		int numeroEAN=Utils.pedirNumeroUsuario("Escribe el numero EAN del animal");
		boolean hayAnimal=false;
		
		//cada bucle comprueba si el codigo EAN introducido por el usuario es igual al de un animal
		for (int i = 0; i < carritoPerros.length; i++) {
			if(carritoPerros[i]!=null && carritoPerros[i].getCodigoEAN()==numeroEAN) {
				System.out.println(carritoPerros[i]);
				hayAnimal=true;
			}	
		}
		
		for (int i = 0; i < carritoGatos.length; i++) {
			if(carritoGatos[i]!=null && carritoGatos[i].getCodigoEAN()==numeroEAN ) {
				System.out.println(carritoGatos[i]);
				hayAnimal=true;
			}	
		}
		
		for (int i = 0; i < carritoPajaros.length; i++) {
			if(carritoPajaros[i]!=null && carritoPajaros[i].getCodigoEAN()==numeroEAN) {
				System.out.println(carritoPajaros[i]);
				hayAnimal=true;
			}	
		}
		
		for (int i = 0; i < carritoRatas.length; i++) {
			if(carritoRatas[i]!=null && carritoRatas[i].getCodigoEAN()==numeroEAN) {
				System.out.println(carritoRatas[i]);
				hayAnimal=true;
			}	
		}
		if(!hayAnimal) {
			System.out.println("No hay animal con ese codigo");
		}
		
	}
	
	private void comprobarApareamiento(Perro[] carritoPerros,Gato[] carritoGatos) {

		System.out.println("--------------------------------------------");
		
		int seleccionApa=Utils.pedirNumeroUsuario("¿De que tipo de mascota quieres saberlo?\n1.Perro\n2.Gato");
		int chip=0;
		int animal1=0;
		int animal2=0;
		
		//comprueba si el sexo de los perros y si es igual no se pueden aparean
		switch(seleccionApa) {
		case 1:
			chip=Utils.pedirNumeroUsuario("Escribe el codigo del chip del primer perro");
			for (int i = 0; i < carritoPerros.length; i++) {

				if(carritoPerros[i]!=null && carritoPerros[i].getChip()==chip) {
					animal1=i;
				}
			}
			
			chip=Utils.pedirNumeroUsuario("Escribe el codigo del chip del segundo perro");
			for (int i = 0; i < carritoPerros.length; i++) {
				
				if(carritoPerros[i]!=null && carritoPerros[i].getChip()==chip) {
					animal2=i;
				}
			}

			if(carritoPerros[animal1].getSexo().equals(carritoPerros[animal2].getSexo())) {
				System.out.println("No se aparean");
			}else System.out.println("Se pueden aparear");
			break;
			
		//comprueba si el sexo de los gatos y si es igual no se pueden aparean
		case 2:
			chip=Utils.pedirNumeroUsuario("Escribe el codigo del chip del primer gato");
			for (int i = 0; i < carritoGatos.length; i++) {

				if(carritoGatos[i]!=null && carritoGatos[i].getChip()==chip) {
					animal1=i;
				}
			}
			
			chip=Utils.pedirNumeroUsuario("Escribe el codigo del chip del segundo gato");
			for (int i = 0; i < carritoGatos.length; i++) {
				
				if(carritoGatos[i]!=null && carritoGatos[i].getChip()==chip) {
					animal2=i;
				}
			}

			if(carritoGatos[animal1].getSexo().equals(carritoGatos[animal2].getSexo())) {
				System.out.println("No se aparean");
			}else System.out.println("Se pueden aparear");
			break;
		}
		
	}

	public void verComida() {

		int seleccionComi=0;
		boolean salirComi=true;
		
		//dice la comida que le gusta al animal que selecciones
		do {
			System.out.println("--------------------------------------------");
			seleccionComi=Utils.pedirNumeroUsuario("¿De que animal deseas saber su comida?");
			switch(seleccionComi) {
			case 1:
				System.out.println("La comida ideal es carne, huesos y pienso");
				break;
			case 2:
				System.out.println("La comida ideal es pescado y pienso");
				break;
			case 3:
				System.out.println("La comida ideal es alpiste");
				break;
			case 4: 
				salirComi=false;
				break;
			}
		}while(salirComi);
		
	}

}
