package examenFinal15062025;

public class Bus {

	private String register;
	private String type;
	private String license;
	
	Bus(String register,String type,String license){
		
		this.register=register;
		this.type=type;
		this.license=license;
		
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}
	
	@Override
	public String toString() {
		String text = "Registro: " + register + " Tipo: "+ type + " Licencia: " + license;
		return text;
	}
	
	
}
