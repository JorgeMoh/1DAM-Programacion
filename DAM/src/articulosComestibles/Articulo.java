package articulosComestibles;

public class Articulo {

	int codigo=0;
	String nombre="";
	double precio=0;
	
	Articulo(int codigo,String nombre,double precio){
		this.codigo=codigo;
		this.nombre=nombre;
		this.precio=precio;
	}
	
	@Override
	public String toString() {
		return ""+this.nombre+""+this.codigo+""+this.precio;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}
