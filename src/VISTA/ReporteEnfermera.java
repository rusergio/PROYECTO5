package VISTA;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import AUXILIAR.Datos;
import MODELO.Consultorio;
import MODELO.Enfermera;
import VISTA.PoliclinAsignados;

//import AUXILIAR.Datos;
//import LOGICA.Consultorio;
//import LOGICA.Enfermera;
//import LOGICA.Medico;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;


public class ReporteEnfermera extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JTable tablaEnfermeras;
	private JButton btnCerrar;
	DefaultTableModel model = new DefaultTableModel();
	private JButton btnVerConsult;
	PoliclinAsignados pa = new PoliclinAsignados();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteEnfermera frame = new ReporteEnfermera();
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
	public ReporteEnfermera() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_assignment_ind_black_24dp.png"));
		setResizable(false);
		setTitle("Reporte de enfermeras");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1162, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCerrar.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_close_black_24dp.png"));
		btnCerrar.setBackground(Color.LIGHT_GRAY);
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setBounds(956, 243, 110, 28);
		contentPane.add(btnCerrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1126, 221);
		contentPane.add(scrollPane);
		
		tablaEnfermeras = new JTable();
		model = new DefaultTableModel();
		
		tablaEnfermeras.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tablaEnfermeras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int i = tablaEnfermeras.getSelectedRow();
				
				
				Enfermera enf = Datos.getInstancia().obtenerEnfermera().get(i);
				ArrayList<Consultorio> lista = enf.getConsultAsig();
				
				
				PoliclinAsignados.model.setRowCount(0);
				
				for(int j = 0; j < lista.size(); j++) {
					Object[] fila = {
							lista.get(j).getNumero(),
							lista.get(j).getNombPoliclin(),
							lista.get(j).getNombDirector()
					};
				PoliclinAsignados.model.addRow(fila);
				}
			}
		});
		scrollPane.setViewportView(tablaEnfermeras);
		model.addColumn("Nº de ID");
		model.addColumn("Nombre Completo");
		model.addColumn("Año de Experiencia");
		model.addColumn("¿Tiene Licenciatura?");
		model.addColumn("Fecha de empezo a trabajar");
		tablaEnfermeras.setModel(model);
		
		// bloquear las celdas para que no sean movidas por el usuario
		tablaEnfermeras.getColumnModel().getColumn(0).setResizable(false);
		tablaEnfermeras.getColumnModel().getColumn(1).setResizable(false);
		tablaEnfermeras.getColumnModel().getColumn(2).setResizable(false);
		tablaEnfermeras.getColumnModel().getColumn(3).setResizable(false);
				
				// definir el volumen de las columnas 
		tablaEnfermeras.getColumnModel().getColumn(0).setPreferredWidth(10);
		tablaEnfermeras.getColumnModel().getColumn(1).setPreferredWidth(130);
		tablaEnfermeras.getColumnModel().getColumn(2).setPreferredWidth(130);
		tablaEnfermeras.getColumnModel().getColumn(3).setPreferredWidth(80);
						
		tablaEnfermeras.getTableHeader().setReorderingAllowed(false);
		tablaEnfermeras.setRowHeight(20);//tamaño de las celdas
				//table.setGridColor(new java.awt.Color(0, 0, 0));
				
				// coneccion para personalizar el encabezado de la tabla 
				JTableHeader jtableHeader = tablaEnfermeras.getTableHeader();
			    jtableHeader.setDefaultRenderer(new PERSONALIZAR.Encabezado());
			    tablaEnfermeras.setTableHeader(jtableHeader);
		
		btnVerConsult = new JButton("Ver Consultorio ");
		btnVerConsult.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVerConsult.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_villa_black_24dp.png"));
		btnVerConsult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pa.setVisible(true);
			}
		});
		btnVerConsult.setBackground(Color.LIGHT_GRAY);
		btnVerConsult.setBounds(731, 243, 170, 28);
		contentPane.add(btnVerConsult);
		
		llenarTablaEnfermeras();
		
	}
	
	
	public void llenarTablaEnfermeras() {
		
		Datos.getInstancia().cargarEnfermeras();
		
		ArrayList<Enfermera> enfermera = Datos.getInstancia().obtenerEnfermera();
		
		for(int i = 0; i < enfermera.size(); i++) {
			
			Object[] filas = {
					
					enfermera.get(i).getNumId(),
					enfermera.get(i).getNombre(),
					enfermera.get(i).getAniosExperiencia(),
					enfermera.get(i).isTieneLicenciatur(),
					enfermera.get(i).getFechComienzo()
					
			};
			model.addRow(filas);
		}
	}

}
