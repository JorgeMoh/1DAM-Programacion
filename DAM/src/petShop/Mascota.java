package petShop;

public class Mascota extends Animal {

	
	String nombre="";
	int chip=0;
	String nombreProp="";
	String apellidoProp="";
	String dniProp="";
	
	Mascota(String sexo,int edad,int codigoEAN,String nombreProp,
			String apellidoProp,String dniProp,String nombre,int chip){
		
		super(sexo,edad,codigoEAN);
		this.nombre=nombre;
		this.chip=chip;
		this.nombreProp=nombreProp;
		this.apellidoProp=apellidoProp;
		this.dniProp=dniProp;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreProp() {
		return nombreProp;
	}

	public void setNombreProp(String nombreProp) {
		this.nombreProp = nombreProp;
	}

	public String getApellidoProp() {
		return apellidoProp;
	}

	public void setApellidoProp(String apellidoProp) {
		this.apellidoProp = apellidoProp;
	}

	public String getDniProp() {
		return dniProp;
	}

	public void setDniProp(String dniProp) {
		this.dniProp = dniProp;
	}

	public int getChip() {
		return chip;
	}

	public void setChip(int chip) {
		this.chip = chip;
	}
}

