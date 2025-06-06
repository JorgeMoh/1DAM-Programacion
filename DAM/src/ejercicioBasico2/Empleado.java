package ejercicioBasico2;

public class Empleado {

	String nombre="";
	int edad=0;
	double salarioBase=0;
	
	Empleado(String nombre, int edad, double salarioBase){
		this.nombre=nombre;
		this.edad=edad;
		this.salarioBase=salarioBase;
	}
	
	public double calcularSalario() {
		return this.salarioBase;
	}
	
	@Override
	public String toString() {
		String texto = this.nombre+this.edad+this.salarioBase;
		return texto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}
	
	
	
}
