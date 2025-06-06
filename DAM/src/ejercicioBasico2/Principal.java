package ejercicioBasico2;

public class Principal {

	public static void main(String[] args) {

		int Salario=0;
		EmpleadoTiempoCompleto[] empleadoTiempoCompleto=new EmpleadoTiempoCompleto[2];
		
		empleadoTiempoCompleto[0]= new EmpleadoTiempoCompleto("Omar",22,1200);
		empleadoTiempoCompleto[1]= new EmpleadoTiempoCompleto("Pedro",21,900);
		
		EmpleadoPorHoras[] empleadoPorHoras=new EmpleadoPorHoras[2];
		
		empleadoPorHoras[0]= new EmpleadoPorHoras("Antonio",21,1000);
		empleadoPorHoras[1]= new EmpleadoPorHoras("Alberto",25,1500);
		
		
		
	}

}
