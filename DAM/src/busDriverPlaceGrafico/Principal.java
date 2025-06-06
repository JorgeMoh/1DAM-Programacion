package busDriverPlaceGrafico;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Principal {

	public static void main(String[] args) {

		SentenciasAucorsa app = new SentenciasAucorsa();
		
		JFrame inicio = new JFrame("Mejorando Aucorsa");
		
		JPanel panelBto = new JPanel();
		JPanel panelBtoInsert = new JPanel();
		JPanel panelBtoSelect = new JPanel();
		JPanel panelText = new JPanel();
		
		JLabel titulo = new JLabel("AUCORSA 2.0");
		JLabel creador = new JLabel("Jorge Martin Mohigefer Jimenez");
		
		JButton select = new JButton("Una preguntita");
		JButton insert = new JButton("Insertar");
		JButton update = new JButton("Actualizar");
		JButton delete = new JButton("Borrar");
		JButton insBus = new JButton("Bus");
		JButton insCond = new JButton("Conductor");
		JButton insLugar = new JButton("Lugar");
		JButton insRuta = new JButton("Ruta");
		JButton condPorRegis = new JButton("Conductor por Registro");
		JButton condPorNum = new JButton("Conductor por numero");
		JButton diaRuta = new JButton("Dia de la ruta");
		JButton btBDD = new JButton("Mostrar base de datos");
		
//		Valores al frame
//		inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inicio.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		inicio.addWindowListener(new WindowListener() {
			
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
                    inicio.dispose();
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
		inicio.setBounds(525, 250, 470, 300);
		inicio.setLayout(new BorderLayout());
		
		panelBtoInsert.setBackground(Color.LIGHT_GRAY);
		panelBtoInsert.setLayout(new FlowLayout());		
		
//		Establecemos el panel del titulo
		inicio.add(panelText, BorderLayout.CENTER);
		panelText.setLayout(new FlowLayout());
		
		titulo.setFont(new Font(null, 0, 50));
		panelText.add(titulo);
		
		creador.setFont(new Font(null, 0, 20));
		creador.setForeground(Color.DARK_GRAY);
		panelText.add(creador);
		
		btBDD.setBackground(Color.DARK_GRAY);
		btBDD.setForeground(Color.WHITE);
		panelText.add(btBDD);
		btBDD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				app.verBDD();
				
			}
		});
		
//		Panel de botones
		inicio.add(panelBto,BorderLayout.SOUTH);
		panelBto.setBackground(Color.LIGHT_GRAY);
		
//		Añade boton que muestre los botones que buscar en la base de datos
		select.setBackground(Color.DARK_GRAY);
		select.setForeground(Color.WHITE);
		panelBto.add(select);
		select.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				inicio.remove(panelBtoInsert);
				inicio.add(panelBtoSelect, BorderLayout.NORTH);

				//Repinta el jframe para que los botones sean visibles
				inicio.revalidate();
				inicio.repaint();
			
			}
		});

//		Configuracion del panel de botonos select
		panelBtoSelect.setBackground(Color.LIGHT_GRAY);
		panelBtoSelect.setLayout(new FlowLayout());
		
		panelBtoSelect.add(condPorRegis);
		condPorRegis.setBackground(Color.DARK_GRAY);
		condPorRegis.setForeground(Color.WHITE);
		condPorRegis.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				app.buscarCondPorRegistro();
				
			}
		});
		
		panelBtoSelect.add(condPorNum);
		condPorNum.setBackground(Color.DARK_GRAY);
		condPorNum.setForeground(Color.WHITE);
		condPorNum.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				app.buscarConductorPorNumero();						
			}
		});
		
		panelBtoSelect.add(diaRuta);
		diaRuta.setBackground(Color.DARK_GRAY);
		diaRuta.setForeground(Color.WHITE);
		diaRuta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				app.buscarDiaRutaPorCiudad();						
			}
		});
			
//		Añade boton que muestre los botones que insertar en la base de datos
		insert.setBackground(Color.DARK_GRAY);
		insert.setForeground(Color.WHITE);
		panelBto.add(insert);
		insert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				inicio.remove(panelBtoSelect);
				inicio.add(panelBtoInsert, BorderLayout.NORTH);
				
				inicio.revalidate();
				inicio.repaint();
				
			}
		});
		
//		Configurar panel de botones insert
		panelBtoInsert.add(insBus);
		insBus.setBackground(Color.DARK_GRAY);
		insBus.setForeground(Color.WHITE);
		insBus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				app.insertarBus();
				
			}
		});
		
		panelBtoInsert.add(insCond);
		insCond.setBackground(Color.DARK_GRAY);
		insCond.setForeground(Color.WHITE);
		insCond.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				app.insertarUnConductor();
				
			}
		});
		
		panelBtoInsert.add(insLugar);
		insLugar.setBackground(Color.DARK_GRAY);
		insLugar.setForeground(Color.WHITE);
		insLugar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				app.insertarLugar();
				
			}
		});
		
		panelBtoInsert.add(insRuta);
		insRuta.setBackground(Color.DARK_GRAY);
		insRuta.setForeground(Color.WHITE);
		insRuta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				app.insertarRuta();
				
			}
		});
		
//		Añade boton que llame al metodo de actualizar
		update.setBackground(Color.DARK_GRAY);
		update.setForeground(Color.WHITE);
		panelBto.add(update);
		update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Actualizar");
				app.actualizardiaDeLasRutas();
			}
		});
		
//		Añade boton que llame al metodo de borrar
		delete.setBackground(Color.DARK_GRAY);
		delete.setForeground(Color.WHITE);
		panelBto.add(delete);
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Borrado");
				app.borrarRuta();
			}
		});
		
//		Establece que sea visible el frame
		inicio.setVisible(true);
	
	}

}
