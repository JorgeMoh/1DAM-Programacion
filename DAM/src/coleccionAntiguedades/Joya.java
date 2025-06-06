package coleccionAntiguedades;

public class Joya extends Antiguedades {

	String materiales="";
	
	Joya(){
		
	}
	
	@Override
	public String toString() {
		String texto="Nombre: "+super.nombre+" Materiales: "+this.materiales+" Año de fabricacion: "+super.anoDeFabri+" origen: "
				+super.origen+" Precio: "+super.precio;
		return texto;
	}

	public String getMateriales() {
		return materiales;
	}

	public void setMateriales(String materiales) {
		this.materiales = materiales;
	}
	
}
