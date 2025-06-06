package articulosComestibles;

public class ArtPerecedero extends Articulo {

	int fechaCaducidad=0;
	
	ArtPerecedero(int codigo, String nombre, double precio,int fechaCaducidad) {
		super(codigo, nombre, precio);
	}

	public int getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(int fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	
	@Override
	public String toString() {
		
		String texto= super.nombre+" "+super.codigo+" "+super.precio+" "+this.fechaCaducidad;
		return texto;
	}

}
