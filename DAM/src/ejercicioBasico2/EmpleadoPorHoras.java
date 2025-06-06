package ejercicioBasico2;

public class EmpleadoPorHoras extends Empleado {

	int horasTrabajadas=0;
	double tarifaHoras=0;
	
	EmpleadoPorHoras(String nombre, int edad, double salarioBase) {
		super(nombre, edad, salarioBase);
	}
	
	@Override
	public double calcularSalario() {
		return horasTrabajadas*tarifaHoras;
		
	}

	public int getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(int horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	public double getTarifaHoras() {
		return tarifaHoras;
	}

	public void setTarifaHoras(double tarifaHoras) {
		this.tarifaHoras = tarifaHoras;
	}

}
