package petShop;

public class Rata extends Animal {

	int peso=0;
	int tamaño=0;
	int precio=2;
	
	Rata(String sexo, int edad, int codigoEAN, int peso,
		int tamaño,int precio) {
		
		super(sexo, edad, codigoEAN);
		this.peso=peso;
		this.tamaño=tamaño;
		this.precio=precio;

	}
	
	@Override
	public String toString() {
		String texto= "Sexo: "+ super.sexo + " Edad: " + super.edad + " Codigo EAN: " + super.codigoEAN
					+ " Tamaño: " + this.tamaño + " Peso: " + this.peso + " Precio: " + this.precio;
		return texto;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getTamaño() {
		return tamaño;
	}

	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
}
