package VISTA;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import AUXILIAR.Datos;
import MODELO.Embarazada;

//import AUXILIAR.Datos;
//import LOGICA.Embarazada;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.awt.event.ActionEvent;
//import java.awt.SystemColor;
import javax.swing.JTable;
import java.awt.Font;
//import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class ReporteEmbarazada extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnVerPersonSalud;
	DefaultTableModel model = new DefaultTableModel();
	private JTable tablaEmbarazada;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteEmbarazada frame = new ReporteEmbarazada();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReporteEmbarazada() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_pregnant_woman_black_24dp.png"));
		setResizable(false);
		setTitle("Reporte de Embarazadas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1280, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1254, 191);
		contentPane.add(scrollPane);
		
		tablaEmbarazada = new JTable();
		tablaEmbarazada.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(tablaEmbarazada);
		model.addColumn("Nº Historial");
		model.addColumn("Nombre");
		model.addColumn("Edad");
		model.addColumn("Sexo");
		model.addColumn("Enfermedad");
		model.addColumn("vacunacion");
		model.addColumn("Fecha");
		tablaEmbarazada.setModel(model);
		
		tablaEmbarazada.getColumnModel().getColumn(0).setResizable(false);
		tablaEmbarazada.getColumnModel().getColumn(1).setResizable(false);
		tablaEmbarazada.getColumnModel().getColumn(2).setResizable(false);
		tablaEmbarazada.getColumnModel().getColumn(3).setResizable(false);
		tablaEmbarazada.getColumnModel().getColumn(4).setResizable(false);
		tablaEmbarazada.getColumnModel().getColumn(5).setResizable(false);
		tablaEmbarazada.getColumnModel().getColumn(6).setResizable(false);
				
				// definir el volumen de las columnas 
		tablaEmbarazada.getColumnModel().getColumn(0).setPreferredWidth(10);
		tablaEmbarazada.getColumnModel().getColumn(1).setPreferredWidth(130);
		tablaEmbarazada.getColumnModel().getColumn(2).setPreferredWidth(30);
		tablaEmbarazada.getColumnModel().getColumn(3).setPreferredWidth(30);
		tablaEmbarazada.getColumnModel().getColumn(4).setPreferredWidth(130);
		tablaEmbarazada.getColumnModel().getColumn(5).setPreferredWidth(120);
		tablaEmbarazada.getColumnModel().getColumn(6).setPreferredWidth(80);
						
		tablaEmbarazada.getTableHeader().setReorderingAllowed(false);
		tablaEmbarazada.setRowHeight(20);//tamaño de las celdas
		//table.setGridColor(new java.awt.Color(0, 0, 0));
				
		// coneccion para personalizar el encabezado de la tabla 
		JTableHeader jtableHeader = tablaEmbarazada.getTableHeader();
		jtableHeader.setDefaultRenderer(new PERSONALIZAR.Encabezado());
		tablaEmbarazada.setTableHeader(jtableHeader);
		
		JButton btnVerConsultorio = new JButton("Ver Consultorios");
		btnVerConsultorio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVerConsultorio.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_villa_black_24dp.png"));
		btnVerConsultorio.setBackground(Color.LIGHT_GRAY);
		btnVerConsultorio.setBounds(897, 214, 170, 28);
		contentPane.add(btnVerConsultorio);
		
		btnVerPersonSalud = new JButton("Ver Equipo Medico");
		btnVerPersonSalud.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVerPersonSalud.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_groups_black_24dp.png"));
		btnVerPersonSalud.setBackground(Color.LIGHT_GRAY);
		btnVerPersonSalud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnVerPersonSalud.setBounds(699, 214, 170, 28);
		contentPane.add(btnVerPersonSalud);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_close_black_24dp.png"));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setBackground(Color.LIGHT_GRAY);
		btnCerrar.setBounds(1129, 213, 110, 28);
		contentPane.add(btnCerrar);
		 cargarTablaEmbarazada();
		
	}
	
	public void cargarTablaEmbarazada() {
		
		Datos.getInstancia().CargarEmbarazadas();
		
		ArrayList<Embarazada> embarazadas = Datos.getInstancia().obtenerEmbarazadas();
	    
		for(int i = 0; i < embarazadas.size(); i++) {
			
			Object[] filas = {
					
					embarazadas.get(i).getNumHist(),
					embarazadas.get(i).getNombre(),
					embarazadas.get(i).getEdad(),
					embarazadas.get(i).getSexo(),
					embarazadas.get(i).getEnfermedad(),
					embarazadas.get(i).getVacunacion(),
					embarazadas.get(i).getFechCitolog()
					
			};
			
			model.addRow(filas);
		}
		
	}
}
