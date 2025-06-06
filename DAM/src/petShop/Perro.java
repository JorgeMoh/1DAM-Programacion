package petShop;

public class Perro extends Mascota {
	
	String color="";
	String raza="";
	String tipoPelo="";
	boolean pedigree=false;
	int precio=100;

	Perro(String sexo,int edad,int codigoEAN,int chip,String nombre,String nombreProp,
		  String apellidoProp,String dniProp,String color,String raza,
		  String tipoPelo,boolean pedigree,int precio){
		
		super(sexo,edad,codigoEAN,nombre,nombreProp,apellidoProp,dniProp,chip);
		this.color=color;
		this.raza=raza;
		this.tipoPelo=tipoPelo;
		
		if(pedigree) {
			this.precio=precio*2;	
		}else this.precio=precio;
		
	}
	
	@Override
	public String toString() {
		String texto= "Sexo: "+ super.sexo + " Edad: " + super.edad + " Codigo EAN: " + super.codigoEAN + " Chip: " + super.chip  + " Nombre: " 
					+ super.nombre + " Color: " + this.color + " Raza: " + this.raza + " Tipo de pelo: " + this.tipoPelo + " pedigree: " 
					+ this.pedigree + " Precio: " + this.precio + " Nombre del propietario: " + super.nombreProp + " Apellido del propietario: " 
					+ super.apellidoProp + " DNI del propietaro: " + super.dniProp;
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

	public boolean isPedigree() {
		return pedigree;
	}

	public void setPedigree(boolean pedigree) {
		this.pedigree = pedigree;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
}
