package petShop;

public class Pajaro extends Animal {

	String color="";
	String tipo="";
	int precio=10;
	
	Pajaro(String sexo,int edad,int codigoEAN,String color,
			String tipo,int precio){
		
		super(sexo,edad,codigoEAN);
		this.color=color;
		this.tipo=tipo;
		this.precio=precio;
		
		
	}
	
	@Override
	public String toString() {
		String texto= "Sexo: "+ super.sexo + " Edad: " + super.edad + " Codigo EAN: " + super.codigoEAN
					+ " Color: " + this.color + " Tipo: " + this.tipo + " Precio: " + this.precio;
		return texto;
	} 

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
}
