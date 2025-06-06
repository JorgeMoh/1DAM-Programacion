package passwordPattern;

public class ComprobarContrasenia extends Exception{

	int numeroDeError = 0;
	
	ComprobarContrasenia(String msg, int numeroDeError){
		
		super(msg);
		this.numeroDeError=numeroDeError;
		
	}

	public int getNumeroDeError() {
		return numeroDeError;
	}

	public void setNumeroDeError(int numeroDeError) {
		this.numeroDeError = numeroDeError;
	}
	
}
