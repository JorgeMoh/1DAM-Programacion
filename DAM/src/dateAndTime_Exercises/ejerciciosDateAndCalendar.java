package dateAndTime_Exercises;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import utils.Utils;

public class ejerciciosDateAndCalendar {
	public static void main(String[] args) {
		
		ejercicio8();
		
	}

	private static void ejercicio1() {
		//1. Fecha y hora dentro de las semanas ingresadas por el usuario a partir de la fecha actual
		
		SimpleDateFormat filtro = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Calendar fecha = Calendar.getInstance();
		Date fechaFutura = new Date();
		int numSemanas= Utils.pedirNumeroUsuario("Dime cuantas semanas quieres que pasen");
		
		
		fecha.add(Calendar.WEEK_OF_MONTH, numSemanas);
		fechaFutura=fecha.getTime();
		System.out.println("La fecha dentro de " + numSemanas+ " es: " + filtro.format(fechaFutura));
		
	}
	
	private static void ejercicio2() {
//		2. El año anterior y posterior al año ingresado por el usuario.		
		
		SimpleDateFormat filtro = new SimpleDateFormat("yyyy");
		Calendar fecha = Calendar.getInstance();
		Date anioAnterior = new Date();
		Date anioPosterior = new Date();
		int anioUsuario = Utils.pedirNumeroUsuario("¿De que año quieres saber su año anterior y su año posterior?");
			
		fecha.set(Calendar.YEAR, anioUsuario);
		fecha.add(Calendar.YEAR, -1);
		anioAnterior=fecha.getTime();
		fecha.add(Calendar.YEAR, 2);
		anioPosterior=fecha.getTime();
		
		System.out.println("El año anterior y posterior al " + anioUsuario + " son: " + filtro.format(anioAnterior) 
							+ " y " + filtro.format(anioPosterior));
		
	}
	
	private static void ejercicio3() {
//		3. Horas, minutos y segundos antes de la hora actual.
		Calendar fecha = Calendar.getInstance();
		long miliseg = fecha.getTimeInMillis();
		long seg = miliseg/1000;
		long min = miliseg/1000/60;
		long horas = miliseg/1000/60/60;
		
		System.out.println("Horas antes de la hora actual: "+horas+"\nMinutos: "+min+"\nSegundos: "+seg);
		
		
	}
	
	private static void ejercicio4() {
//		4. Horas restantes para finalizar el curso.
		Calendar fechaActual = Calendar.getInstance();
		Calendar fechaFinDeCurso = Calendar.getInstance();
		long diferencia=0;
		
		
		fechaFinDeCurso.set(Calendar.MONTH, Calendar.JUNE);
		fechaFinDeCurso.set(Calendar.DAY_OF_MONTH, 24);
		
		diferencia=fechaFinDeCurso.getTimeInMillis()-fechaActual.getTimeInMillis();
		diferencia=diferencia/1000/60/60;
		
		System.out.println("Quedan un total de "+diferencia+" horas");

	}
	
	private static void ejercicio5() {
//		5. Semanas restantes para el inicio de la Feria de Córdoba 2025.
		
		Calendar fechaActual = Calendar.getInstance();
		Calendar fechaFeria = Calendar.getInstance();
		long diferencia=0;
		
		
		fechaFeria.set(Calendar.MONTH, Calendar.MAY);
		fechaFeria.set(Calendar.DAY_OF_MONTH, 24);
		
		diferencia=fechaFeria.getTimeInMillis()-fechaActual.getTimeInMillis();
		diferencia=diferencia/1000/60/60/24/7;
		
		System.out.println("Quedan un total de "+diferencia+" semanas para la feria");

	}
	
	private static void ejercicio6() {
//		6. Años restantes para la llegada del cometa Haley.
		
		Calendar fechaActual = Calendar.getInstance();
		Calendar fechaCometa = Calendar.getInstance();
		long diferencia=0;
		
		fechaCometa.set(Calendar.YEAR, 2061);
		fechaCometa.set(Calendar.MONTH, Calendar.JULY);
		fechaCometa.set(Calendar.DAY_OF_MONTH, 28);
		
		diferencia=fechaCometa.getTimeInMillis()-fechaActual.getTimeInMillis();
		diferencia=diferencia/1000/60/60/24/365;		
		
		System.out.println("Quedan un total de "+diferencia+" años para que pase el cometa Haley");

	}
	
	private static void ejercicio7() {
//		7. Días y meses restantes para finalizar este año.
		
		Calendar fechaActual = Calendar.getInstance();
		Calendar fechaFinAnio = Calendar.getInstance();
		long diferencia=0;
		
		fechaFinAnio.set(Calendar.YEAR, 2025);
		fechaFinAnio.set(Calendar.MONTH, Calendar.DECEMBER);
		fechaFinAnio.set(Calendar.DAY_OF_MONTH, 31);
		
		diferencia=fechaFinAnio.getTimeInMillis()-fechaActual.getTimeInMillis();
		diferencia=diferencia/1000/60/60/24;		
		System.out.println("Quedan un total de "+diferencia+" dias para que acabe el año");
		diferencia=diferencia/30;
		System.out.println("Que son "+diferencia+" meses");

	}
	
	private static void ejercicio8() {
//		8. Mostrar la fecha del 01/02/2024 con este formato.

		Calendar fecha = Calendar.getInstance();
		
		fecha.set(Calendar.YEAR, 2024);
		fecha.set(Calendar.MONTH, Calendar.FEBRUARY);
		fecha.set(Calendar.DAY_OF_MONTH, 1);
		
		//Pasa el Calendar a un metodo para lo meta en un date y lo formatee con el patron que pongamos.
		//Tambien le podemos pasar un mensaje para que lo muestra al mismo tiempo que la fecha formateada.
		Utils.mostrarFechaFormateada(fecha, null, "dd/MM/yyyy");
		
	}
	
	private static void ejercicio9() {
//		9. Comprobar si el año 2022 es bisiesto.
		
		Calendar anio = Calendar.getInstance();
		long dias=0;
		
		anio.set(Calendar.YEAR, 2022);
		anio.set(Calendar.MONTH, Calendar.DECEMBER);
		anio.set(Calendar.DAY_OF_MONTH, 31);
		
		dias=anio.getTimeInMillis();
		
		anio.set(Calendar.YEAR, 2021);
		anio.set(Calendar.MONTH, Calendar.DECEMBER);
		anio.set(Calendar.DAY_OF_MONTH, 31);
		
		dias=dias-anio.getTimeInMillis();
		dias=dias/1000/60/60/24;
		
		if (dias>365) {
			System.out.println("Es año bisiesto");
		} else System.out.println("No es año bisiesto");
		

	}
	
	private static void ejercicio10() {
//		10. Calcular cuántas horas hay entre dos horas introducidas por el usuario.
		
		Calendar hora = Calendar.getInstance();
		long diferencia=0;
		int hora1=Utils.pedirNumeroUsuario("Dime una hora(formato 24h): ");
		int hora2=Utils.pedirNumeroUsuario("Dime otra hora(formato 24h): ");
		
		if (hora1<23&&hora2<23) {
			
			if (hora1>hora2) {
				
				hora.set(Calendar.HOUR_OF_DAY, hora1);
				diferencia=hora.getTimeInMillis();
				
				hora.set(Calendar.HOUR_OF_DAY, hora2);
				diferencia=diferencia-hora.getTimeInMillis();
				
				diferencia=diferencia/1000/60/60;
				
				System.out.println("Hay " + diferencia + " horas de diferencia entre una y otra");
				
			} else {
				
				hora.set(Calendar.HOUR_OF_DAY, hora2);
				diferencia=hora.getTimeInMillis();
				
				hora.set(Calendar.HOUR_OF_DAY, hora1);
				diferencia=diferencia-hora.getTimeInMillis();
				
				diferencia=diferencia/1000/60/60;
				
				System.out.println("Hay " + diferencia + " horas de diferencia entre una y otra");
				
			}
			
		}else System.out.println("¿No sabes leer o que? He dicho formato 24 horas melón");
		
	}
	
	private static void ejercicio11() {
//		11. Calcular cuántas horas hay entre dos fechas introducidas por el usuario.

		Calendar fecha = Calendar.getInstance();
		long diferencia=0;
		
		System.out.println("Introduce la primera fecha");
		
		fecha.set(Calendar.DAY_OF_MONTH, Utils.pedirNumeroUsuario("Dia:"));
		fecha.set(Calendar.MONTH, Utils.pedirNumeroUsuario("Numero del mes(empezando desde el 0 que corresponde a enero):"));
		fecha.set(Calendar.YEAR, Utils.pedirNumeroUsuario("Año:"));
		diferencia=fecha.getTimeInMillis();
		
		System.out.println("Introduce la primera fecha");
		
		fecha.set(Calendar.DAY_OF_MONTH, Utils.pedirNumeroUsuario("Dia:"));
		fecha.set(Calendar.MONTH, Utils.pedirNumeroUsuario("Numero del mes(empezando desde el 0 que corresponde a enero):"));
		fecha.set(Calendar.YEAR, Utils.pedirNumeroUsuario("Año:"));
		
		if(diferencia>fecha.getTimeInMillis()) {
			
			diferencia=diferencia-fecha.getTimeInMillis();
			
		}else {
			
			diferencia=fecha.getTimeInMillis()-diferencia;
			
		}
		
		diferencia=diferencia/1000/60/60;
		
		System.out.println("Entre las dos fechas hay "+diferencia+" horas");
		
	}
	
	private static void ejercicio12() {
//		12. Mostrar el día de la semana que corresponde a una fecha introducida por el usuario.

		Locale locale = Locale.getDefault();
		Calendar fecha = Calendar.getInstance();
		
		System.out.println("Introduce una fecha\n");
		
		fecha.set(Calendar.DAY_OF_MONTH, Utils.pedirNumeroUsuario("Dia:"));
		fecha.set(Calendar.MONTH, Utils.pedirNumeroUsuario("Numero del mes(empezando desde el 0 que corresponde a enero):"));
		fecha.set(Calendar.YEAR, Utils.pedirNumeroUsuario("Año:"));
		
		System.out.println("El dia dela semana de esa fecha es: "+fecha.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, locale));
		
	}
	
	private static void ejercicio13() {
//		13. ¿Cuántos segundos han pasado desde las 16:04 hasta las 18:07?
		
		Calendar hora = Calendar.getInstance();
		long diferencia=0;
		
		hora.set(Calendar.HOUR_OF_DAY, 16);
		hora.set(Calendar.MINUTE, 4);
		diferencia=hora.getTimeInMillis();
		
		hora.set(Calendar.HOUR_OF_DAY, 18);
		hora.set(Calendar.MINUTE, 4);
		diferencia=hora.getTimeInMillis()-diferencia;
		
		diferencia=diferencia/1000;
		System.out.println("De las 16:04 ha las 18:07 hay " + diferencia + " segundos");
		
	}
	
	private static void ejercicio14() {
//		14. Muestra la fecha de la muerte de Galileo en español (miércoles, 8 de enero de 1642).

		Calendar fecha = Calendar.getInstance();
		
		fecha.set(Calendar.YEAR, 1642);
		fecha.set(Calendar.MONTH, Calendar.JANUARY);
		fecha.set(Calendar.DAY_OF_MONTH, 8);
		
		Utils.mostrarFechaFormateada(fecha, "Galileo murio el", "EEEEEEEEEE, dd 'de' MMMMMMM 'de' yyyy");
		
		
	}
	
	private static void ejercicio15() {
//		15. Muestra la fecha y hora del lanzamiento de la PS5 en español (19/11/20 00:01).

		Calendar fecha = Calendar.getInstance();
		
		fecha.set(Calendar.YEAR, 2020);
		fecha.set(Calendar.MONTH, 10);
		fecha.set(Calendar.DAY_OF_MONTH, 19);
		fecha.set(Calendar.HOUR_OF_DAY, 0);
		fecha.set(Calendar.MINUTE, 1);
		
		Utils.mostrarFechaFormateada(fecha, "El lanzamiento de la PS5 fue el: ", "dd/MM/yy HH:mm");
		
	}
	
}
