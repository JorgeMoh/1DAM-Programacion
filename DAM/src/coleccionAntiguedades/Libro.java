package coleccionAntiguedades;

public class Libro extends Antiguedades {

	String autor="";
	
	Libro(){
		
	}
	
	@Override
	public String toString() {
		String texto="Nombre: "+super.nombre+" Autor: "+this.autor+" Año de fabricacion: "+super.anoDeFabri+" origen: "
				+super.origen+" Precio: "+super.precio;
		return texto;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	
}
