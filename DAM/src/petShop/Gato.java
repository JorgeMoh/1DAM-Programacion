package petShop;

public class Gato extends Mascota {

	String color="";
	String raza="";
	String tipoPelo="";
	int precio=50;
	
	Gato(String sexo,int edad,int codigoEAN,int chip,String nombreProp,String nombre,
		 String apellidoProp,String dniProp,String color,String raza,
		 String tipoPelo,int precio){
		
		super(sexo,edad,codigoEAN,nombreProp,apellidoProp,dniProp,nombre,chip);
		this.color=color;
		this.raza=raza;
		this.tipoPelo=tipoPelo;
		this.precio=precio;
		
	}
	
	@Override
	public String toString() {
		String texto= "Sexo: "+ super.sexo + " Edad: " + super.edad + " Codigo EAN: " + super.codigoEAN + " Chip: " + super.chip + " Nombre: " + super.nombre
					+ " Color: " + this.color + " Raza: " + this.raza + " Tipo de pelo: " + this.tipoPelo + " Precio: " + this.precio 
					+ " Nombre del propietario: " + super.nombreProp + " Apellido del propietario: " + super.apellidoProp 
					+ " DNI del propietaro: " + super.dniProp;
		return texto;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getTipoPelo() {
		return tipoPelo;
	}

	public void setTipoPelo(String tipoPelo) {
		this.tipoPelo = tipoPelo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
}
