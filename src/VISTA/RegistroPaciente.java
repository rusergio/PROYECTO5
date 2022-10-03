package VISTA;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import AUXILIAR.Datos;
import MODELO.Paciente;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
//import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
//import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class RegistroPaciente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static DefaultTableModel model = new DefaultTableModel();
	private JScrollPane scrollPane;
	public static JTable tablaPaciente;
	private JButton btnEliminar;
	private JButton btnCerrar;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroPaciente frame = new RegistroPaciente();
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
	public RegistroPaciente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_emoji_people_black_24dp.png"));
		setResizable(false);
		setTitle("Registro de los pacientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1075, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1049, 227);
		
		tablaPaciente = new JTable();
		tablaPaciente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tablaPaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = tablaPaciente.getSelectedRow();
				
				if(i>=0)
					btnEliminar.setEnabled(true);
				
			}
		});
		scrollPane.setViewportView(tablaPaciente);
		contentPane.add(scrollPane);
		model.addColumn("Nº de Historial");
		model.addColumn("Nombre completo");
		model.addColumn("Edad");
		model.addColumn("Sexo");
		model.addColumn("Enfermedad");
		model.addColumn("Vacunacion");
		tablaPaciente.setModel(model);
		
		// bloquear las celdas para que no sean movidas por el usuario
		tablaPaciente.getColumnModel().getColumn(0).setResizable(false);
		tablaPaciente.getColumnModel().getColumn(1).setResizable(false);
		tablaPaciente.getColumnModel().getColumn(2).setResizable(false);
		// definir el volumen de las columnas 
		tablaPaciente.getColumnModel().getColumn(0).setPreferredWidth(30);
		tablaPaciente.getColumnModel().getColumn(1).setPreferredWidth(170);
		tablaPaciente.getColumnModel().getColumn(2).setPreferredWidth(5);
		tablaPaciente.getColumnModel().getColumn(3).setPreferredWidth(5);
		tablaPaciente.getColumnModel().getColumn(4).setPreferredWidth(170);
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
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCerrar.setBackground(Color.LIGHT_GRAY);
		btnCerrar.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_close_black_24dp.png"));
		btnCerrar.setBounds(925, 249, 110, 28);
		contentPane.add(btnCerrar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tablaPaciente.getSelectedRow();
				
				if(i>=0)
					model.removeRow(i);
				else
					JOptionPane.showMessageDialog(null, "No seleccionaste ninguna fila! Seleccione una fila.","Atención",JOptionPane.WARNING_MESSAGE);
			}
		});
		btnEliminar.setEnabled(false);
		btnEliminar.setBackground(Color.LIGHT_GRAY);
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_delete_black_24dp.png"));
		btnEliminar.setBounds(771, 249, 110, 28);
		contentPane.add(btnEliminar);
		
		llenarTablaPacientes();
		
	}
	
	public void llenarTablaPacientes() {
		
		Datos.getInstancia().cargarPacientes();
		
		ArrayList<Paciente> pacientes = Datos.getInstancia().obtenerPacientes();
		for(int i = 0; i < pacientes.size(); i++) {
			
			Object[] fila = {
					
					pacientes.get(i).getNumHist(),
					pacientes.get(i).getNombre(),
					pacientes.get(i).getEdad(),
					pacientes.get(i).getSexo(),
					pacientes.get(i).getEnfermedad(),
					pacientes.get(i).getVacunacion()
					
			};
			model.addRow(fila);
		}
		
	}
}
