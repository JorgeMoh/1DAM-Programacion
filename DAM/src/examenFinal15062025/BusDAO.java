package examenFinal15062025;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class BusDAO {

	private ArrayList<Bus> buses = new ArrayList<Bus>();
	private Connection c;
	
	BusDAO() throws SQLException, ClassNotFoundException {
		
		System.out.println("----------------------------------------");
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Drivers cargados correctamente");
		
		this.c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Aucorsa", "root", "");	
		System.out.println("Conexion establecida\n----------------------------------------");
		
	}
	
	void obtenerBuses(JFrame main, JTable tablaBus,DefaultTableModel modeloTablaBus) {
		
		try {
			
			PreparedStatement selectBus = c.prepareStatement("Select * from bus");
			ResultSet resultSelectBus = selectBus.executeQuery();
			
			//limpia el array para la nueva inserccion de datos
			buses.clear();
			
			//inicializa el array con los resultados de la consulta
			while(resultSelectBus.next()) {
				
				buses.add(new Bus(resultSelectBus.getString(1), resultSelectBus.getString(2), resultSelectBus.getString(3)));
				
			}
		
			//establece el numero de filas a 0
			modeloTablaBus.setRowCount(0);
			
			//carga los datos del array en la tabla
			for (Bus bus : buses) {
				
				modeloTablaBus.addRow(new String[] {bus.getRegister(),bus.getType(),bus.getLicense()});
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

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
		
		//Establece los parametros del frame
		insertBus.setBounds(650, 350, 300, 180);
		insertBus.setLayout(new BorderLayout());
		
		
		insertBus.add(panelMsgResul, BorderLayout.NORTH);
		panelMsgResul.add(msgResult);
		
		//establece el layaut y el contenido dentro del framen
		insertBus.add(panelDatoInsBus, BorderLayout.CENTER);
		panelDatoInsBus.setBorder(BorderFactory.createEmptyBorder(7, 5, 7, 5));
		panelDatoInsBus.setLayout(new GridLayout(3,2));
		panelDatoInsBus.add(new JLabel("Registro:"));
		panelDatoInsBus.add(regisItro);
		panelDatoInsBus.add(new JLabel("Tipo:"));
		panelDatoInsBus.add(tipoItro);
		panelDatoInsBus.add(new JLabel("Licencia:"));
		panelDatoInsBus.add(LicenciaItro);
		
		//añade el boton, lo mete en el panel sur y establece la accion del boton
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
	
}
