package VISTA;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import AUXILIAR.Datos;
import MODELO.Paciente;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
//import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class ReportePaciente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnVerEquipMed;
	private JButton btnVerConsultorio;
	private JButton btnCerrar;
	DefaultTableModel model = new DefaultTableModel();
	private JTable tablaPaciente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportePaciente frame = new ReportePaciente();
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
	public ReportePaciente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_assignment_ind_black_24dp.png"));
		setResizable(false);
		setTitle("Reporte de Pacientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1304, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1266, 201);
		contentPane.add(scrollPane);
		
		tablaPaciente = new JTable();
		tablaPaciente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tablaPaciente.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollPane.setViewportView(tablaPaciente);
		model.addColumn("Nº Historial");
		model.addColumn("Nombre");
		model.addColumn("Edad");
		model.addColumn("Sexo");
		model.addColumn("Enfermedad");
		model.addColumn("Vacunacion");
		tablaPaciente.setModel(model);
		
		// bloquear las celdas para que no sean movidas por el usuario
		tablaPaciente.getColumnModel().getColumn(0).setResizable(false);
		tablaPaciente.getColumnModel().getColumn(1).setResizable(false);
		tablaPaciente.getColumnModel().getColumn(2).setResizable(false);
		tablaPaciente.getColumnModel().getColumn(3).setResizable(false);
		tablaPaciente.getColumnModel().getColumn(4).setResizable(false);
		tablaPaciente.getColumnModel().getColumn(5).setResizable(false);
				
		// definir el volumen de las columnas 
		tablaPaciente.getColumnModel().getColumn(0).setPreferredWidth(10);
		tablaPaciente.getColumnModel().getColumn(1).setPreferredWidth(130);
		tablaPaciente.getColumnModel().getColumn(2).setPreferredWidth(20);
		tablaPaciente.getColumnModel().getColumn(3).setPreferredWidth(20);
		tablaPaciente.getColumnModel().getColumn(4).setPreferredWidth(130);
		tablaPaciente.getColumnModel().getColumn(5).setPreferredWidth(120);
						
		tablaPaciente.getTableHeader().setReorderingAllowed(false);
		tablaPaciente.setRowHeight(20);//tamaño de las celdas
		//table.setGridColor(new java.awt.Color(0, 0, 0));
				
		// coneccion para personalizar el encabezado de la tabla 
		JTableHeader jtableHeader = tablaPaciente.getTableHeader();
		jtableHeader.setDefaultRenderer(new PERSONALIZAR.Encabezado());
		tablaPaciente.setTableHeader(jtableHeader);
				
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCerrar.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_close_black_24dp.png"));
		btnCerrar.setBackground(Color.LIGHT_GRAY);
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setBounds(1129, 223, 110, 28);
		contentPane.add(btnCerrar);
		
		btnVerConsultorio = new JButton("Ver Consultorio");
		btnVerConsultorio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVerConsultorio.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_villa_black_24dp.png"));
		btnVerConsultorio.setBackground(Color.LIGHT_GRAY);
		btnVerConsultorio.setBounds(868, 223, 150, 28);
		contentPane.add(btnVerConsultorio);
		
		btnVerEquipMed = new JButton("Ver Equipo Medico");
		btnVerEquipMed.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVerEquipMed.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_groups_black_24dp.png"));
		btnVerEquipMed.setBackground(Color.LIGHT_GRAY);
		btnVerEquipMed.setBounds(660, 223, 168, 28);
		contentPane.add(btnVerEquipMed);
		Datos.getInstancia().cargarPacientes();
		llenarTablaPaciente();
		
	}
	public void llenarTablaPaciente() {
		
		ArrayList<Paciente> pacientes = Datos.getInstancia().obtenerPacientes();
		
		for(int i = 0; i < pacientes.size(); i++) {
			
			Object[] filas = {
					pacientes.get(i).getNumHist(),
					pacientes.get(i).getNombre(),
					pacientes.get(i).getEdad(),
					pacientes.get(i).getSexo(),
					pacientes.get(i).getEnfermedad(),
					pacientes.get(i).getVacunacion()
			};
			model.addRow(filas);
		}
		
	}
}
