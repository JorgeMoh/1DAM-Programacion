package postOffice;

public class Usuario {

	
	String nombreUsuario="";
	int clave=0;
	boolean admin=false;
	
	Usuario(String nombreUsuario,int clave,boolean admin){
		
		this.nombreUsuario=nombreUsuario;
		this.clave=clave;
		this.admin=admin;
		
	}
	
	@Override
	public String toString() {
		String texto= "Nombre: "+this.nombreUsuario+"\nClave: "+this.clave;
		return texto;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public int getClave() {
		return clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
}
