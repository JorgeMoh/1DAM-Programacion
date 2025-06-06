package ejercicioBasico2;

public class EmpleadoTiempoCompleto extends Empleado {

	double bono=0;
	
	EmpleadoTiempoCompleto(String nombre, int edad, double salarioBase) {
		super(nombre, edad, salarioBase);

	}
	
	@Override
	public double calcularSalario(){
		return super.salarioBase+bono;
	}

	public double getBono() {
		return bono;
	}

	public void setBono(double bono) {
		this.bono = bono;
	}

}
