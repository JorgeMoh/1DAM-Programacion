package busDrivePlace;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.Utils;

public class ConexionSQL {
	
	Connection c =null;
	
	ConexionSQL(){
		
		try {
			System.out.println("----------------------------------------\n\tEstableciendo conexion\n----------------------------------------");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Drivers cargados correctamente");
			
			this.c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Aucorsa", "root", "");	
			System.out.println("Conexion establecida");
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
	
	public void mostrarDatosAutobuses() throws SQLException {
		
		
		Statement consulta = c.createStatement();
		ResultSet resultadoConsulta = consulta.executeQuery("SELECT * FROM Bus");
    	
            while (resultadoConsulta.next()) {
               System.out.println("Registros: " + resultadoConsulta.getString(1) 
               		+ "\nTipo: "  + resultadoConsulta.getString(2)
               		+ "\nLicencia: "  + resultadoConsulta.getString(3) + "\n");
            }
	}
	
	public void buscarAutobusePorRegistro(String registro) throws SQLException {
		
		Statement consulta = c.createStatement();
		ResultSet resultadoConsulta = consulta.executeQuery("select * from bus where register= '"+registro+"'");
		
		while (resultadoConsulta.next()) {
		System.out.println("Registro: "+resultadoConsulta.getString(1)+
							"\nTipo: " + resultadoConsulta.getString(2)+
							"\nLicencia: "+ resultadoConsulta.getString(3));
		 }
		c.close();
		resultadoConsulta.close();
		
	}
	
	public void buscarAutobusePorLicencia(String Licencia) throws SQLException {
		
		Statement consultaLicencia = c.createStatement();
		ResultSet resultasdoConsultaLicencia = consultaLicencia.executeQuery("select * from bus where license = '"+Licencia+"'");
		
		while(resultasdoConsultaLicencia.next()) {
			
			System.out.println("resgistro: "+resultasdoConsultaLicencia.getString(1)
								+"\nTipo: "+resultasdoConsultaLicencia.getString(2)
								+"\nLicencia: "+resultasdoConsultaLicencia.getString(3));
			
		}
		
		consultaLicencia.close();
		resultasdoConsultaLicencia.close();
		
	}
	
	/**
	 * Metodo que inserta un nuevo bus pidiendole los datos al usuario
	 * @throws SQLException
	 */
	public void insertarBus()throws SQLException {
		
		PreparedStatement consultaInsertBus = c.prepareStatement("insert into bus values (?, ?, ?)");
		int nInserciones=0;
		
		consultaInsertBus.setString(1, Utils.pedirTextoUsuario("Registro:"));
		consultaInsertBus.setString(2, Utils.pedirTextoUsuario("Tipo:"));
		consultaInsertBus.setString(3, Utils.pedirTextoUsuario("Licencia:"));
		
		nInserciones = consultaInsertBus.executeUpdate();
		
		if (nInserciones>0) {
			System.out.println("Se han insertado "+nInserciones+" filas\n");
		}else System.out.println("No se ha instertado nada\n");
		
	}
	
 	public void mostrarConductores() throws SQLException{
		
		Statement consultaConductores = c.createStatement();
		ResultSet resultadoConsultaConductores = consultaConductores.executeQuery("select * from driver");
		
		while(resultadoConsultaConductores.next()) {
			
			System.out.println("Numero: "+ resultadoConsultaConductores.getInt(1)
								+ "\tName: "+ resultadoConsultaConductores.getString(2)
								+"\tApellido: "+ resultadoConsultaConductores.getString(3));
			
		}
		
		resultadoConsultaConductores.close();
		consultaConductores.close();
		
	}
	
	/**
	 * Este metodo realiza una consulta select que pide al usuario el numero del conductor que busca el usuario para mostrarle sus datos
	 * @throws SQLException
	 */
	public void buscarConductorPorNumero() throws SQLException{
		
		int numero=Utils.pedirNumeroUsuario("\n----------------------------------------\nIntroduce los datos requeridos:\nNumero de conductor: ");
		Statement consultaConductorNumero = c.createStatement();
		ResultSet resultadoConsultaCondNum= consultaConductorNumero.executeQuery("select * from driver where numdriver='"+numero+"'");
		
		while(resultadoConsultaCondNum.next()) {
			
			System.out.println("Numero: "+resultadoConsultaCondNum.getInt(1)
								+"\tNombre:"+resultadoConsultaCondNum.getString(2)
								+"\tApellido: "+resultadoConsultaCondNum.getString(3));
			
		}
		consultaConductorNumero.close();
		resultadoConsultaCondNum.close();
		
	}
	
	public void buscarConductorPorNombreYApellido(String nombre,String apellido) throws SQLException{
		
		Statement consultaCondNombApell= c.createStatement();
		ResultSet resultadoCondNomApell= consultaCondNombApell.executeQuery("select * from driver where name='"+nombre+"' and surname='" 
																			+apellido+"'");
		
		while(resultadoCondNomApell.next()) {
			
			System.out.println("Numero: "+resultadoCondNomApell.getInt(1)
			+"\tNombre:"+resultadoCondNomApell.getString(2)
			+"\tApellido: "+resultadoCondNomApell.getString(3));
			
		}
		
		consultaCondNombApell.close();
		resultadoCondNomApell.close();
		
	}

	/**
	 * Metodo que busca al conductor de un bus por su registro pidiendole este al usuario
	 * @throws SQLException
	 */
	public void buscarCondPorRegistro() throws SQLException {
//		Datos de los conductores que conducen un autobús, solicitando el registro del número de autobús.
		
		PreparedStatement buscCondPorRegistro = c.prepareStatement("select driver.numdriver, driver.name, driver.surname from driver, bdp, bus "
				+ "where bus.register=bdp.register and bdp.numdriver=driver.numdriver and bus.register=?");
		ResultSet resulCondPorRegistro;
		
		buscCondPorRegistro.setString(1, Utils.pedirTextoUsuario("Reistro del bus: "));
		
		resulCondPorRegistro=buscCondPorRegistro.executeQuery();
		
		while(resulCondPorRegistro.next()) {
			
			System.out.println("\nNumero del conductor: "+resulCondPorRegistro.getInt(1)+"\nNombre: "+resulCondPorRegistro.getString(2)
								+"\nApellido: "+resulCondPorRegistro.getString(3)+"\n");
			
		}
		
	}
	
	/**
	 * Metodo que inserta un nuevo conductor pidiendole los datos al usuario
	 * @throws SQLException
	 */
	public void insertarUnConductor() throws SQLException{
	
		PreparedStatement consultaInsertCond = c.prepareStatement("insert into driver values (?, ?, ?)");
		int filasAfectadas=0;
		
		consultaInsertCond.setInt(1, Utils.pedirNumeroUsuario("Numero: "));
		consultaInsertCond.setString(2, Utils.pedirTextoUsuario("Nombre:"));
		consultaInsertCond.setString(3, Utils.pedirTextoUsuario("Apellido:"));
		
		filasAfectadas=consultaInsertCond.executeUpdate();
		
		if(filasAfectadas>0) {
			System.out.println("Se han actualizado "+filasAfectadas+ " filas\n");
		}else System.out.println("no se ha actualizado ninguna fila\n");
		
	}

	public void borrarConductor(int numero) throws SQLException{

		PreparedStatement borrarCond = c.prepareStatement("delete from driver where numdriver=?");
		int filasEliminadas=0;
		
		borrarCond.setInt(1, numero);
		
		filasEliminadas=borrarCond.executeUpdate();
		
		if(filasEliminadas>0) {
			System.out.println("Se han borrado "+filasEliminadas+" filas");
		}else System.out.println("No se ha borrado ni una fila");
		
		
	}
	
	/**
	 * Metodo que inserta un nuevo lugar pidiendole los datos al usuario
	 * @throws SQLException
	 */
	public void insertarLugar() throws SQLException{
		
		PreparedStatement insertLugar = c.prepareStatement("insert into place values (?, ?, ?, ?)");
		int nLugaresIntr = 0;
		
		insertLugar.setInt(1, Utils.pedirNumeroUsuario("Id: "));
		insertLugar.setInt(2, Utils.pedirNumeroUsuario("Cp: "));
		insertLugar.setString(3, Utils.pedirTextoUsuario("Ciudad:"));
		insertLugar.setString(4, Utils.pedirTextoUsuario("Sitio:"));
		
		nLugaresIntr = insertLugar.executeUpdate();
		
		if(nLugaresIntr>0) {
			System.out.println("Se han introducido "+nLugaresIntr+" lugares\n");
		}else System.out.println("No se ha indrucido ningun Lugar\n");
		
	}
	
	/**
	 * Este metodo muestra al usuario el dia que sale el bus pidiendole la ciudad
	 * @throws SQLException
	 */
	public void buscarDiaRutaPorCiudad() throws SQLException {
		
		PreparedStatement buscDiaRuta = c.prepareStatement("select day_of_week from bdp, place where bdp.idplace=place.idplace and city=?");
		ResultSet resultBuscDiaRuta;
		boolean hayResult=false;
		
		buscDiaRuta.setString(1, Utils.pedirTextoUsuario("Ciudad:"));
		
		resultBuscDiaRuta=buscDiaRuta.executeQuery();
		
		while(resultBuscDiaRuta.next()) {
			
			System.out.println("El bus sale el "+resultBuscDiaRuta.getString(1)+"\n");
			hayResult=true;
			
		}
		
		if(!hayResult) {
			System.out.println("No hay ruta para esa ciudad");
		}
		
	}
	
	/**
	 * Metodo que inserte una nueva ruta pidiendole los datos al usuario
	 * @throws SQLException
	 */
	public void insertarRuta() throws SQLException{
		
		PreparedStatement insertRuta = c.prepareStatement("insert into bdp values (?, ?, ?, ?)");
		int nInsertRutas=0;
		
		insertRuta.setString(1, Utils.pedirTextoUsuario("Registro: "));
		insertRuta.setInt(2, Utils.pedirNumeroUsuario("Numero de conductor: "));
		insertRuta.setInt(3, Utils.pedirNumeroUsuario("Id de lugar: "));
		insertRuta.setString(4, Utils.pedirTextoUsuario("Dia de la semana: "));
		
		nInsertRutas=insertRuta.executeUpdate();
		if(nInsertRutas>0) {
			System.out.println("Se han introducido "+nInsertRutas+" lugares\n");
		}else System.out.println("No se ha indrucido ningun Lugar\n");
		
		
	}
	
	/**
	 * Metodo que borra la ruta pidiendo el registro, nuemro de conductor y id del lugar al usuario
	 * @throws SQLException
	 */
	public void borrarRuta() throws SQLException {
		
		PreparedStatement borrRuta = c.prepareStatement("delete from bdp where register=? and numdriver=? and idplace=?");
		int nRutasBorradas=0;
		
		System.out.println("Introduzca los datos requeridos para eliminar la linea que desea\n");
		borrRuta.setString(1, Utils.pedirTextoUsuario("Registro: "));
		borrRuta.setInt(2, Utils.pedirNumeroUsuario("Numero de conductor: "));
		borrRuta.setInt(3, Utils.pedirNumeroUsuario("Id de lugar: "));
		
		nRutasBorradas=borrRuta.executeUpdate();
		
		if(nRutasBorradas>0) {
			System.out.println("Se han borrado "+nRutasBorradas+" rutas\n");
		}else System.out.println("No se ha borrado ninguna linea, compruebe los datos\n");
		
	}

	/**
	 * Metodo que actualiza los dias de las rutas por otro
	 * @throws SQLException
	 */
	public void actualizardiaDeLasRutas() throws SQLException {

		PreparedStatement ActuDiaRuta= c.prepareStatement("Update bdp set day_of_week=? where day_of_week=?");
		int nDiasActu =0;
		
		ActuDiaRuta.setString(2, Utils.pedirTextoUsuario("De que dia vas a cambiar las rutas: "));
		ActuDiaRuta.setString(1, Utils.pedirTextoUsuario("A que dia vas a cambiarlo: "));
		
		nDiasActu = ActuDiaRuta.executeUpdate();
		
		if(nDiasActu>0) {
			System.out.println("Se han actualizado "+nDiasActu+" rutas\n");
		}else System.out.println("no se han actualizado ninguna fila\n");
		
		ActuDiaRuta.close();
		
	}
	
}
