package examenFinal15062025;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Principal {	
	
	Principal(){
		
	}

	public static void main(String[] args) {
		
		
		try {
			BusDAO app = new BusDAO();
			Principal principal = new Principal();
			
			JFrame main = new JFrame("Mostrar aunto");
			
			
			principal.inicializarComponentes(main, app);
			
			main.setVisible(true);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	 void inicializarComponentes(JFrame main, BusDAO app) {
		
		Calendar fechaHoy = Calendar.getInstance();
		Date fecha =new Date();
		SimpleDateFormat filtro = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		DefaultTableModel modeloTablaBus = new DefaultTableModel(new String[] {"Registro","Tipo","Licencia"},0);
		JTable tablaBus = new JTable(modeloTablaBus);

		JScrollPane panelTabla = new JScrollPane(tablaBus);
		
		JPanel panelCentral = new JPanel();
		JPanel panelBto = new JPanel();
		
		JButton btoBus = new JButton("Mostrar Buses");
		JButton insertBus = new JButton("Insertar Bus");
		JButton cerrarApp = new JButton("Cerrar Aplicacion");
		
		//Establece los parametros del jframe principal
		main.setLayout(new BorderLayout());
		main.setBounds(525, 250, 470, 300);
		main.add(panelCentral, BorderLayout.CENTER);
		main.add(panelBto, BorderLayout.SOUTH);
		main.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		main.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				int opcion = JOptionPane.showConfirmDialog(null, "¿Realmente desa salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
                
				if (opcion == JOptionPane.YES_OPTION){
                    main.dispose();
                }
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		
		//Establece los parametros del panel central y llama al metodo obtener buses
		//para introducir los datos dentro de la tabla
		panelCentral.setBackground(Color.GRAY);
		panelCentral.setLayout(new BorderLayout());
		panelCentral.add(panelTabla, BorderLayout.CENTER);
		app.obtenerBuses(main,tablaBus,modeloTablaBus);
		
		//establece la fecha de hoy en la variable date y la inserta en el lable con un formato
		fecha= fechaHoy.getTime();
		panelCentral.add(new JLabel("Hoy es: "+filtro.format(fecha)), BorderLayout.SOUTH);
		
		
		//Establece parametros del panel de botones
		panelBto.setBackground(Color.DARK_GRAY);
		panelBto.setLayout(new FlowLayout());
		
		
		//Personalizamos el boton que actualiza la tabla y 
		//añadimos el listaner para que al presionarlo la actualice
		panelBto.add(btoBus);
		btoBus.setBackground(Color.LIGHT_GRAY);
		btoBus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				app.obtenerBuses(main,tablaBus,modeloTablaBus);
				
			}
		});
		
		//Personalizamos el boton para insertar 
		panelBto.add(insertBus);
		insertBus.setBackground(Color.LIGHT_GRAY);
		insertBus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				app.insertarBus();
				
			}
		});

		
		
		
	}

}
