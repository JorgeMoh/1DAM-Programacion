package busDriverPlaceGrafico;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.PopupMenu;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import utils.Utils;

public class SentenciasAucorsa {

	Connection c;
	
	SentenciasAucorsa(){
		
		try {
			System.out.println("----------------------------------------");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Drivers cargados correctamente");
			
			this.c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Aucorsa", "root", "");	
			System.out.println("Conexion establecida\n----------------------------------------");
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * metodo que muestra toda la base de datos
	 */
	public void verBDD () {
	
		JFrame mostrarBDD = new JFrame("Ver BDD");
		
		//Modelos de las tablas, el array de string setea las columnas
		DefaultTableModel modelBus = new DefaultTableModel(new String[] {"Registro","Tipo","Licencia"},0);
		DefaultTableModel modelCond = new DefaultTableModel(new String[] {"Nº Conductor","Nombre","Apellidos"},0);
		DefaultTableModel modelLug = new DefaultTableModel(new String[] {"Id","Cp","Ciudad","Sitio"},0);
		DefaultTableModel modelRuta = new DefaultTableModel(new String[] {"Registro","Nº Conductor","Id","Dia"},0);
		
		JTable tablabus = new JTable();
		JTable tablaConduc= new JTable();
		JTable tablaLugar = new JTable();
		JTable tablaRuta = new JTable();
		
		JPanel panelBTO = new JPanel();
		
		//Tinen que tener la tabla en el constructor para que se vean
		JScrollPane panelTablaBus = new JScrollPane(tablabus);
		JScrollPane panelTablaCon = new JScrollPane(tablaConduc);
		JScrollPane panelTablaLugar = new JScrollPane(tablaLugar);
		JScrollPane panelTablaRuta = new JScrollPane(tablaRuta);
		
		JButton selectBtoBus = new JButton("Buses");
		JButton selectBtoCond = new JButton("Conductores");
		JButton selectBtoLug = new JButton("Lugares");
		JButton selectBtoRuta = new JButton("Rutas");
		
		mostrarBDD.setLayout(new BorderLayout());
		mostrarBDD.setBounds(525, 250, 470, 300);
		
		
		mostrarBDD.add(panelBTO, BorderLayout.NORTH);
		panelBTO.setBackground(Color.LIGHT_GRAY);
		
		panelBTO.add(selectBtoBus);
		selectBtoBus.setBackground(Color.DARK_GRAY);
		selectBtoBus.setForeground(Color.white);
		selectBtoBus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					PreparedStatement busSelect = c.prepareStatement("select * from bus");
					ResultSet resultBus = busSelect.executeQuery();
					
					mostrarBDD.remove(panelTablaCon);
					mostrarBDD.remove(panelTablaLugar);
					mostrarBDD.remove(panelTablaRuta);
					
					
					mostrarBDD.add(panelTablaBus, BorderLayout.CENTER);
					//Añade el modelo a la tabla
					tablabus.setModel(modelBus);
					//Elimina todas las tablas
					modelBus.setRowCount(0);
					
					//setea las filas
					while(resultBus.next()) {
						modelBus.addRow(new String[] {resultBus.getString(1),resultBus.getString(2),resultBus.getString(3)});
					}
					
					mostrarBDD.revalidate();
					mostrarBDD.repaint();
				
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
			
		});
		
		panelBTO.add(selectBtoCond);
		selectBtoCond.setBackground(Color.DARK_GRAY);
		selectBtoCond.setForeground(Color.white);
		selectBtoCond.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					PreparedStatement condSelect = c.prepareStatement("select * from driver");
					ResultSet resultCond = condSelect.executeQuery();
					
					mostrarBDD.remove(panelTablaBus);
					mostrarBDD.remove(panelTablaLugar);
					mostrarBDD.remove(panelTablaRuta);
					
					mostrarBDD.add(panelTablaCon, BorderLayout.CENTER);
					//Añade el modelo a la tabla
					tablaConduc.setModel(modelCond);
					//Elimina todas las tablas
					modelCond.setRowCount(0);
					
					//setea las filas
					while(resultCond.next()) {
						modelCond.addRow(new String[] {resultCond.getString(1),resultCond.getString(2),resultCond.getString(3)});
					}
					
					mostrarBDD.revalidate();
					mostrarBDD.repaint();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		panelBTO.add(selectBtoLug);
		selectBtoLug.setBackground(Color.DARK_GRAY);
		selectBtoLug.setForeground(Color.white);
		selectBtoLug.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					PreparedStatement selectLug = c.prepareStatement("select * from place");
					ResultSet resultLug = selectLug.executeQuery();
					
					mostrarBDD.remove(panelTablaBus);
					mostrarBDD.remove(panelTablaCon);
					mostrarBDD.remove(panelTablaRuta);
					
					mostrarBDD.add(panelTablaLugar);
					
					tablaLugar.setModel(modelLug);
					modelLug.setRowCount(0);
					
					while(resultLug.next()) {
						
						modelLug.addRow(new String[] {resultLug.getString(1),resultLug.getString(2),resultLug.getString(3),resultLug.getString(4)});
						
					}
					
					mostrarBDD.revalidate();
					mostrarBDD.repaint();
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		panelBTO.add(selectBtoRuta);
		selectBtoRuta.setBackground(Color.DARK_GRAY);
		selectBtoRuta.setForeground(Color.white);
		selectBtoRuta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					PreparedStatement selectRuta = c.prepareStatement("select * from bdp");
					ResultSet resultRuta = selectRuta.executeQuery();
					
					mostrarBDD.remove(panelTablaBus);
					mostrarBDD.remove(panelTablaCon);
					mostrarBDD.remove(panelTablaLugar);
					
					mostrarBDD.add(panelTablaRuta);
					
					tablaRuta.setModel(modelRuta);
					modelRuta.setRowCount(0);
					
					while(resultRuta.next()) {
						
						modelRuta.addRow(new String[] {resultRuta.getString(1),resultRuta.getString(2),resultRuta.getString(3),resultRuta.getString(4)});
						
					}
					
					mostrarBDD.revalidate();
					mostrarBDD.repaint();
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		mostrarBDD.setVisible(true);
		
	}
	
	
	
	/**
	 * Metodo que busca al conductor de un bus por su registro pidiendole este al usuario
	 * @throws SQLException
	 */
	public void buscarCondPorRegistro() {
		
		JFrame busCondRegis = new JFrame("Buscar conductor por registro");
		JPanel panelCondRegis = new JPanel();
		JLabel regis = new JLabel("Registro: ");
		JTextField regisIntro = new JTextField();
		
		
		busCondRegis.setBounds(630, 350, 300, 100);
		
		busCondRegis.add(panelCondRegis);
		panelCondRegis.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
		panelCondRegis.setLayout(new GridLayout(1,2));
		panelCondRegis.add(regis);
		panelCondRegis.add(regisIntro);
		
		regisIntro.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
//				System.out.println(e.getKeyCode());
				
				if (e.getKeyCode()==10) {
					
					busCondRegis.dispose();
					
					try {
						PreparedStatement buscCondPorRegistro;
						
						JFrame resultadoCon = new JFrame("Conductor encontrado");
						JPanel panelresultCon = new JPanel();
						JLabel name = new JLabel();
						JLabel surname = new JLabel();
						JLabel numDriver = new JLabel();
						
						buscCondPorRegistro = c.prepareStatement("select driver.numdriver, driver.name, driver.surname from driver, bdp, bus "
						+ "where bus.register=bdp.register and bdp.numdriver=driver.numdriver and bus.register=?");
						ResultSet resulCondPorRegistro;
						
						buscCondPorRegistro.setString(1, regisIntro.getText());
						
						resulCondPorRegistro=buscCondPorRegistro.executeQuery();
						
						while(resulCondPorRegistro.next()) {
							
							
							resultadoCon.setBounds(650, 350, 200, 180);
							resultadoCon.add(panelresultCon);
							panelresultCon.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
							panelresultCon.setLayout(new FlowLayout(FlowLayout.LEADING));
							
							panelresultCon.add(name);
							name.setText("Nombre: "+ resulCondPorRegistro.getString(2));
							name.setFont(new Font(null, 0, 20));
							
							panelresultCon.add(surname);
							surname.setFont(new Font(null, 0, 20));
							surname.setText("Apellido: "+resulCondPorRegistro.getString(3));
							
							panelresultCon.add(numDriver);
							numDriver.setFont(new Font(null, 0, 20));
							numDriver.setText("Nº conductor: " + resulCondPorRegistro.getInt(1));
							
							resultadoCon.setVisible(true);
							
						}
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
				}
				
			}
		});
		
		busCondRegis.setVisible(true);
		
	}
	
	/**
	 * Este metodo realiza una consulta select que pide al usuario el numero del conductor que busca el usuario para mostrarle sus datos
	 * @throws SQLException
	 */
	public void buscarConductorPorNumero() {
		
		JFrame busCondNum = new JFrame("Buscar conductor por registro");
		JPanel panelCondNum = new JPanel();
		JLabel Num = new JLabel("Nº conductor: ");
		JTextField numIntro = new JTextField();
		
		
		busCondNum.setBounds(630, 350, 300, 100);
		
		busCondNum.add(panelCondNum);
		panelCondNum.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
		panelCondNum.setLayout(new GridLayout(1,2));
		panelCondNum.add(Num);
		panelCondNum.add(numIntro);
		
		numIntro.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
//				System.out.println(e.getKeyCode());
				
				if (e.getKeyCode()==10) {
					
					busCondNum.dispose();
					
					try {
						
						PreparedStatement buscCondPorNum;
						int numCond = Integer.parseInt(numIntro.getText());
						
						buscCondPorNum = c.prepareStatement("select * from driver where numdriver=?");
						ResultSet resulCondPorRegistro;
						
						buscCondPorNum.setInt(1, numCond);
						
						resulCondPorRegistro=buscCondPorNum.executeQuery();
						
						while(resulCondPorRegistro.next()) {
							
							JFrame resultadoCon = new JFrame("Conductor encontrado");
							JPanel panelresultCon = new JPanel();
							JLabel name = new JLabel("Nombre: "+ resulCondPorRegistro.getString(2));
							JLabel surname = new JLabel("Apellido: "+resulCondPorRegistro.getString(3));
							JLabel numDriver = new JLabel("Nº conductor: " + resulCondPorRegistro.getInt(1));
							
							resultadoCon.setBounds(650, 350, 200, 180);
							resultadoCon.add(panelresultCon);
							panelresultCon.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
							panelresultCon.setLayout(new FlowLayout(FlowLayout.LEADING));
							
							panelresultCon.add(name);
							name.setFont(new Font(null, 0, 20));
							panelresultCon.add(surname);
							surname.setFont(new Font(null, 0, 20));
							panelresultCon.add(numDriver);
							numDriver.setFont(new Font(null, 0, 20));
							
							resultadoCon.setVisible(true);
							
						}
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (Exception e2) {
						
					}
					
				}
				
			}
		});
		
		busCondNum.setVisible(true);
		
	}
	
	/**
	 * Este metodo muestra al usuario el dia que sale el bus pidiendole la ciudad
	 * @throws SQLException
	 */
	public void buscarDiaRutaPorCiudad() {
		
		JFrame diaRutaPorCiudad = new JFrame("Buscar dia por ciudad");
		JPanel panelDiaCiudad = new JPanel();
		JLabel ciudad = new JLabel("Destino: ");
		JTextField ciudadIntro = new JTextField();
		
		
		diaRutaPorCiudad.setBounds(630, 350, 300, 100);
		
		diaRutaPorCiudad.add(panelDiaCiudad);
		panelDiaCiudad.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
		panelDiaCiudad.setLayout(new GridLayout(1,2));
		panelDiaCiudad.add(ciudad);
		panelDiaCiudad.add(ciudadIntro);
		
		ciudadIntro.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
//				System.out.println(e.getKeyCode());
				
				if (e.getKeyCode()==10) {
					
					diaRutaPorCiudad.dispose();
					
					try {
						
						PreparedStatement buscDiaRuta = c.prepareStatement("select day_of_week from bdp, place "
																			+ "where bdp.idplace=place.idplace and city=?");
						ResultSet resultBuscDiaRuta;
						boolean hayResult=false;
						
						buscDiaRuta.setString(1, ciudadIntro.getText());
						
						resultBuscDiaRuta=buscDiaRuta.executeQuery();
						
						
						while(resultBuscDiaRuta.next()) {
							
							JFrame resultadoCon = new JFrame("Conductor encontrado");
							JPanel panelresultCon = new JPanel();
							JLabel dia = new JLabel("El autobus con destino "+ ciudadIntro.getText() + " sale el " + resultBuscDiaRuta.getString(1));
							
							resultadoCon.setBounds(535, 350, 480, 100);
							resultadoCon.add(panelresultCon);
							panelresultCon.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
							panelresultCon.setLayout(new FlowLayout());
							
							panelresultCon.add(dia);
							dia.setFont(new Font(null, 0, 20));
							
							resultadoCon.setVisible(true);
							
						}
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
				}
				
			}
		});
		
		diaRutaPorCiudad.setVisible(true);
		
	}


	
	/**
	 * Metodo que inserta un nuevo bus pidiendole los datos al usuario
	 * @throws SQLException
	 */
	public void insertarBus() {
		
		JFrame insertBus = new JFrame("Insertar Bus");
		JPanel panelDatoInsBus = new JPanel();
		JPanel panelBtoInsBus = new JPanel();
		JPanel panelMsgResul = new JPanel();
		
		JLabel msgResult = new JLabel();
		
		JTextField regisItro = new JTextField();
		JTextField tipoItro = new JTextField();
		JTextField LicenciaItro = new JTextField();
		
		JButton btoInsBus = new JButton("Insertar");
		
		insertBus.setBounds(650, 350, 300, 180);
		insertBus.setLayout(new BorderLayout());
		
		insertBus.add(panelMsgResul, BorderLayout.NORTH);
		panelMsgResul.add(msgResult);
		
		insertBus.add(panelDatoInsBus, BorderLayout.CENTER);
		panelDatoInsBus.setBorder(BorderFactory.createEmptyBorder(7, 5, 7, 5));
		panelDatoInsBus.setLayout(new GridLayout(3,2));
		panelDatoInsBus.add(new JLabel("Registro:"));
		panelDatoInsBus.add(regisItro);
		panelDatoInsBus.add(new JLabel("Tipo:"));
		panelDatoInsBus.add(tipoItro);
		panelDatoInsBus.add(new JLabel("Licencia:"));
		panelDatoInsBus.add(LicenciaItro);
		
		insertBus.add(panelBtoInsBus, BorderLayout.SOUTH);
		panelBtoInsBus.setBackground(Color.LIGHT_GRAY);
		panelBtoInsBus.add(btoInsBus);
		btoInsBus.setBackground(Color.DARK_GRAY);
		btoInsBus.setForeground(Color.WHITE);
		btoInsBus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e){
			
				try {
					
					PreparedStatement consultaInsertBus = c.prepareStatement("insert into bus values (?, ?, ?)");
					int nInserciones=0;
					
					consultaInsertBus.setString(1, regisItro.getText());
					consultaInsertBus.setString(2, tipoItro.getText());
					consultaInsertBus.setString(3, LicenciaItro.getText());
					
					nInserciones = consultaInsertBus.executeUpdate();
					
					if (nInserciones>0) {
						msgResult.setText("Se han insertado "+nInserciones+" filas");
						msgResult.setForeground(Color.GREEN);
					}else {
						msgResult.setText("No se ha instertado nada");
						msgResult.setForeground(Color.RED);
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
					
			}
		});
		
		insertBus.setVisible(true);
				
	}
	
	/**
	 * Metodo que inserta un nuevo conductor pidiendole los datos al usuario
	 * @throws SQLException
	 */
	public void insertarUnConductor() {
	
		JFrame insertCond = new JFrame("Insertar Conductor");
		JPanel panelDatoInsCond = new JPanel();
		JPanel panelBtoInsCond = new JPanel();
		JPanel panelMsgResul = new JPanel();
		
		JLabel msgResult = new JLabel();
		
		JTextField numItro = new JTextField();
		JTextField nombreItro = new JTextField();
		JTextField apellidoItro = new JTextField();
		
		JButton btoInsCond = new JButton("Insertar");
		
		insertCond.setBounds(650, 350, 300, 180);
		insertCond.setLayout(new BorderLayout());
		
		insertCond.add(panelMsgResul, BorderLayout.NORTH);
		panelMsgResul.add(msgResult);
		
		insertCond.add(panelDatoInsCond, BorderLayout.CENTER);
		panelDatoInsCond.setBorder(BorderFactory.createEmptyBorder(7, 5, 7, 5));
		panelDatoInsCond.setLayout(new GridLayout(3,2));
		panelDatoInsCond.add(new JLabel("Numero:"));
		panelDatoInsCond.add(numItro);
		panelDatoInsCond.add(new JLabel("Nombre:"));
		panelDatoInsCond.add(nombreItro);
		panelDatoInsCond.add(new JLabel("Apellido:"));
		panelDatoInsCond.add(apellidoItro);
		
		insertCond.add(panelBtoInsCond, BorderLayout.SOUTH);
		panelBtoInsCond.setBackground(Color.LIGHT_GRAY);
		panelBtoInsCond.add(btoInsCond);
		btoInsCond.setBackground(Color.DARK_GRAY);
		btoInsCond.setForeground(Color.WHITE);
		btoInsCond.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e){
			
				try {
					PreparedStatement consultaInsertCond = c.prepareStatement("insert into driver values (?, ?, ?)");
					int filasAfectadas=0;
					int numero = Integer.parseInt(numItro.getText());
					
					consultaInsertCond.setInt(1, numero);
					consultaInsertCond.setString(2, nombreItro.getText());
					consultaInsertCond.setString(3, apellidoItro.getText());
					
					filasAfectadas=consultaInsertCond.executeUpdate();
					
					if (filasAfectadas>0) {
						msgResult.setText("Se han insertado "+filasAfectadas+" filas");
						msgResult.setForeground(Color.GREEN);
					}else {
						msgResult.setText("No se ha instertado nada");
						msgResult.setForeground(Color.RED);
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
					
			}
		});
		
		insertCond.setVisible(true);
		
	}
	
	/**
	 * Metodo que inserta un nuevo lugar pidiendole los datos al usuario
	 * @throws SQLException
	 */
	public void insertarLugar() {
		
		JFrame insertLugar = new JFrame("Insertar Lugar");
		JPanel panelDatoInsLugar = new JPanel();
		JPanel panelBtoInsLugar = new JPanel();
		JPanel panelMsgResul = new JPanel();
		
		JLabel msgResult = new JLabel();
		
		JTextField idItro = new JTextField();
		JTextField cpItro = new JTextField();
		JTextField ciudadItro = new JTextField();
		JTextField sitioItro = new JTextField();
		
		JButton btoInsLugar = new JButton("Insertar");
		
		insertLugar.setBounds(650, 350, 300, 200);
		insertLugar.setLayout(new BorderLayout());
		
		insertLugar.add(panelMsgResul, BorderLayout.NORTH);
		panelMsgResul.add(msgResult);
		
		insertLugar.add(panelDatoInsLugar, BorderLayout.CENTER);
		panelDatoInsLugar.setBorder(BorderFactory.createEmptyBorder(7, 5, 7, 5));
		panelDatoInsLugar.setLayout(new GridLayout(4,2));
		panelDatoInsLugar.add(new JLabel("Id:"));
		panelDatoInsLugar.add(idItro);
		panelDatoInsLugar.add(new JLabel("Cp:"));
		panelDatoInsLugar.add(cpItro);
		panelDatoInsLugar.add(new JLabel("Ciudad:"));
		panelDatoInsLugar.add(ciudadItro);
		panelDatoInsLugar.add(new JLabel("Sitio:"));
		panelDatoInsLugar.add(sitioItro);
		
		insertLugar.add(panelBtoInsLugar, BorderLayout.SOUTH);
		panelBtoInsLugar.setBackground(Color.LIGHT_GRAY);
		panelBtoInsLugar.add(btoInsLugar);
		btoInsLugar.setBackground(Color.DARK_GRAY);
		btoInsLugar.setForeground(Color.WHITE);
		btoInsLugar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e){
			
				try {
					PreparedStatement insertLugar = c.prepareStatement("insert into place values (?, ?, ?, ?)");
					int nLugaresIntr = 0;
					int id = Integer.parseInt(idItro.getText());
					int cp = Integer.parseInt(cpItro.getText());
					
					insertLugar.setInt(1, id);
					insertLugar.setInt(2, cp);
					insertLugar.setString(3, ciudadItro.getText());
					insertLugar.setString(4,sitioItro.getText());
					
					nLugaresIntr = insertLugar.executeUpdate();
					
					if (nLugaresIntr>0) {
						msgResult.setText("Se han insertado "+nLugaresIntr+" filas");
						msgResult.setForeground(Color.GREEN);
					}else {
						msgResult.setText("No se ha instertado nada");
						msgResult.setForeground(Color.RED);
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
					
			}
		});
		
		insertLugar.setVisible(true);
		
	}
	
	/**
	 * Metodo que inserte una nueva ruta pidiendole los datos al usuario
	 * @throws SQLException
	 */
	public void insertarRuta() {
		
		JFrame insertRuta = new JFrame("Insertar Ruta");
		JPanel panelDatoInsRuta = new JPanel();
		JPanel panelBtoInsRuta = new JPanel();
		JPanel panelMsgResul = new JPanel();
		
		JLabel msgResult = new JLabel();
		
		JTextField idItro = new JTextField();
		JTextField nCondItro = new JTextField();
		JTextField regisItro = new JTextField();
		JTextField diaItro = new JTextField();
		
		JButton btoInsLugar = new JButton("Insertar");
		
		insertRuta.setBounds(650, 350, 300, 200);
		insertRuta.setLayout(new BorderLayout());
		
		insertRuta.add(panelMsgResul, BorderLayout.NORTH);
		panelMsgResul.add(msgResult);
		
		insertRuta.add(panelDatoInsRuta, BorderLayout.CENTER);
		panelDatoInsRuta.setBorder(BorderFactory.createEmptyBorder(7, 5, 7, 5));
		panelDatoInsRuta.setLayout(new GridLayout(4,2));
		panelDatoInsRuta.add(new JLabel("Registro:"));
		panelDatoInsRuta.add(regisItro);
		panelDatoInsRuta.add(new JLabel("Numero de conductor:"));
		panelDatoInsRuta.add(nCondItro);
		panelDatoInsRuta.add(new JLabel("Id de lugar:"));
		panelDatoInsRuta.add(idItro);
		panelDatoInsRuta.add(new JLabel("Dia de la semana:"));
		panelDatoInsRuta.add(diaItro);
		
		insertRuta.add(panelBtoInsRuta, BorderLayout.SOUTH);
		panelBtoInsRuta.setBackground(Color.LIGHT_GRAY);
		panelBtoInsRuta.add(btoInsLugar);
		btoInsLugar.setBackground(Color.DARK_GRAY);
		btoInsLugar.setForeground(Color.WHITE);
		btoInsLugar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e){
			
				try {
					PreparedStatement insertRuta = c.prepareStatement("insert into bdp values (?, ?, ?, ?)");
					int nInsertRutas=0;
					int id = Integer.parseInt(idItro.getText());
					int nCond = Integer.parseInt(nCondItro.getText());
					
					insertRuta.setString(1, regisItro.getText());
					insertRuta.setInt(2, nCond);
					insertRuta.setInt(3, id);
					insertRuta.setString(4, diaItro.getText());
					
					nInsertRutas=insertRuta.executeUpdate();
					
					if (nInsertRutas>0) {
						msgResult.setText("Se han insertado "+nInsertRutas+" filas");
						msgResult.setForeground(Color.GREEN);
					}else {
						msgResult.setText("No se ha instertado nada");
						msgResult.setForeground(Color.RED);
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
					
			}
		});
		
		insertRuta.setVisible(true);
		
	}
	
	
	
	/**
	 * Metodo que actualiza los dias de las rutas por otro
	 * @throws SQLException
	 */
	public void actualizardiaDeLasRutas() {

		JFrame actDiasRutas = new JFrame("Actualizar dias de las rutas");
		JPanel panelSeleccion = new JPanel();
		JPanel panelBtn = new JPanel();
		JButton botonUpd = new JButton("Actualizar");
		JComboBox<String> diaACambiar = new JComboBox<String>();
		JComboBox<String> diaCambiado = new JComboBox<String>();
		ArrayList<String> diasSemana = new ArrayList<String>();
		
//		Instanciamos el arrayList
		diasSemana.add("");
		diasSemana.add("Monday");
		diasSemana.add("Tuesday");
		diasSemana.add("Wednesday");
		diasSemana.add("Thursday");
		diasSemana.add("Friday");
		diasSemana.add("Saturday");
		diasSemana.add("Sunday");
		
//		Metemos la info del array en los comboBox
		for (String dia : diasSemana) {
			diaACambiar.addItem(dia);
			diaCambiado.addItem(dia);
		}
		
		actDiasRutas.setBounds(650, 350, 300, 170);
		actDiasRutas.setLayout(new BorderLayout());
		
//		Diseño del panenl central
		actDiasRutas.add(panelSeleccion, BorderLayout.CENTER);
		panelSeleccion.setLayout(new GridLayout(2,2));
		panelSeleccion.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
		panelSeleccion.add(new JLabel("Dia de rutas a cambiar"));
		panelSeleccion.add(diaACambiar);
		diaACambiar.setBackground(Color.LIGHT_GRAY);
		panelSeleccion.add(new JLabel("Dia de rutas a cambiar"));
		panelSeleccion.add(diaCambiado);
		diaCambiado.setBackground(Color.LIGHT_GRAY);
		
//		Diseño panel de boton
		actDiasRutas.add(panelBtn, BorderLayout.SOUTH);
		panelBtn.setBackground(Color.LIGHT_GRAY);
		panelBtn.add(botonUpd);
		botonUpd.setBackground(Color.DARK_GRAY);
		botonUpd.setForeground(Color.WHITE);
		
		botonUpd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String diaACambiarSelec = (String) diaACambiar.getSelectedItem();
				String diaCambiadoSelec = (String) diaCambiado.getSelectedItem();
				
				if (diaACambiarSelec != "" && diaCambiadoSelec != "") {
				
					try {
						PreparedStatement ActuDiaRuta;
						ActuDiaRuta = c.prepareStatement("Update bdp set day_of_week=? where day_of_week=?");
						int nDiasActu =0;

						
						ActuDiaRuta.setString(1, diaCambiadoSelec);
						ActuDiaRuta.setString(2, diaACambiarSelec);
						
						nDiasActu = ActuDiaRuta.executeUpdate();
						
						if(nDiasActu>0) {
							System.out.println("Se han actualizado "+nDiasActu+" rutas\n");
						}else System.out.println("no se han actualizado ninguna fila\n");
						
						ActuDiaRuta.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
				}else System.out.println("Selecciona un valor maquina");
				
			}
		});
		
		actDiasRutas.setVisible(true);
		
	}
		
		
	
	/**
	 * Metodo que borra la ruta pidiendo el registro, nuemro de conductor y id del lugar al usuario
	 * @throws SQLException
	 */
	public void borrarRuta() {
		
		JFrame borrarRuta = new JFrame("Borrar Ruta");
		
		JPanel panelDatosPedidos = new JPanel();
		JPanel panelBoton = new JPanel();
		JPanel panelresult = new JPanel();
		
		JLabel etiqRegis = new JLabel("Registro: ");
		JLabel etiqNumConduc = new JLabel("Numero de conductor: ");
		JLabel etiqIdLugar = new JLabel("Id de lugar: ");
		JLabel resulBorrado = new JLabel("");
		
		JTextField areaRegis = new JTextField();
		JTextField areaNumConduc = new JTextField();
		JTextField areaIdLugar = new JTextField();
		
		JButton botonBorrar = new JButton("Borrar ruta");

		
		borrarRuta.setBounds(650, 350, 300, 180);
		borrarRuta.setLayout(new BorderLayout());
		borrarRuta.add(panelDatosPedidos, BorderLayout.CENTER);
		borrarRuta.add(panelresult, BorderLayout.NORTH);
		
//		Añadimos las etiquetas y los textfield
		panelDatosPedidos.setLayout(new GridLayout(3,2));
		panelDatosPedidos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panelDatosPedidos.add(etiqRegis);
		panelDatosPedidos.add(areaRegis);
		panelDatosPedidos.add(etiqNumConduc);
		panelDatosPedidos.add(areaNumConduc);
		panelDatosPedidos.add(etiqIdLugar);
		panelDatosPedidos.add(areaIdLugar);

		panelresult.add(resulBorrado);
		
//		Añadimos y configuramos el panel del boton
		borrarRuta.add(panelBoton,BorderLayout.SOUTH);
		panelBoton.setLayout(new FlowLayout());
		panelBoton.setBackground(Color.LIGHT_GRAY);
		panelBoton.add(botonBorrar);
		botonBorrar.setBackground(Color.DARK_GRAY);
		botonBorrar.setForeground(Color.WHITE);
		
		botonBorrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					PreparedStatement borrRuta = c.prepareStatement("delete from bdp where register=? and numdriver=? and idplace=?");
					int numDriver = Integer.parseInt(areaNumConduc.getText());
					int idPlace = Integer.parseInt(areaIdLugar.getText());
					int nRutasBorradas=0;
					
					borrRuta.setString(1, areaRegis.getText());
					borrRuta.setInt(2, numDriver);
					borrRuta.setInt(3, idPlace);
					
					nRutasBorradas=borrRuta.executeUpdate();
					
					if(nRutasBorradas>0) {
						resulBorrado.setForeground(Color.GREEN);
						resulBorrado.setText("Se han borrado con exito "+nRutasBorradas+" rutas");
					}else {
						;
						resulBorrado.setForeground(Color.RED);
						resulBorrado.setText("No existen rutas con esos datos");
					}
					
				} catch (SQLException e2) {
					e2.printStackTrace();
				} catch(Exception e3) {
					e3.printStackTrace();
				}
				
			}
		});

		
		borrarRuta.setVisible(true);
		

		
	}
 	
}
