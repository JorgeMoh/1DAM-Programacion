package coleccionAntiguedades;

public class Antiguedades {

	String nombre="";
	int anoDeFabri=0;
	String origen="";
	double precio=0;
	
	Antiguedades(){
		
	}

	@Override
	public String toString() {
		String texto="Nombre: "+this.nombre+" Año de fabricacion: "+this.anoDeFabri+" origen: "+this.origen
				+" Precio: "+this.precio;
		return texto;
	}

	public int getAnoDeFabri() {
		return anoDeFabri;
	}

	public void setAnoDeFabri(int añoDeFabri) {
		this.anoDeFabri = añoDeFabri;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
