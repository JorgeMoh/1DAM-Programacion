package coleccionAntiguedades;

public class Mueble extends Antiguedades {

	String estilo="";
	
	Mueble(){
		
	}
	
	@Override
	public String toString() {
		String texto="Nombre: "+super.nombre+" Estilo: "+this.estilo+" Año de fabricacion: "+super.anoDeFabri+" origen: "
				+super.origen+" Precio: "+super.precio;
		return texto;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	
}
