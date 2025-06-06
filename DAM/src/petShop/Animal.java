package petShop;

public class Animal {

	String sexo="";
	int edad=0;
	int codigoEAN=0;
	
	Animal(String sexo,int edad,int codigoEAN){
		
		this.sexo=sexo;
		this.edad=edad;
		this.codigoEAN=codigoEAN;
		
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getCodigoEAN() {
		return codigoEAN;
	}

	public void setCodigoEAN(int codigoEAN) {
		this.codigoEAN = codigoEAN;
	}
		
	
}
