package VISTA;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
//import javax.swing.table.TableModel;

import AUXILIAR.Datos;
import MODELO.Medico;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
//import java.text.SimpleDateFormat;
//import java.util.Date;
import java.awt.event.ActionEvent;
//import javax.swing.JTextField;
//import javax.swing.JLabel;
//import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
//import java.awt.font.TextMeasurer;


public class RegistroMedico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static DefaultTableModel model = new DefaultTableModel();
	private JScrollPane scrollPane;
	public static JTable tablaMedico;
	private JButton btnCerrar;
	private JButton btnEliminar;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroMedico frame = new RegistroMedico();
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
	public RegistroMedico() {
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(348, 171, 89, 23);
		setResizable(false);
		setTitle("Registro de los Medicos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 934, 261);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		model = new DefaultTableModel();
		
		scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int i = tablaMedico.getSelectedRow();
				if(i >= 0) {
					btnEliminar.setEnabled(true);
				
				}
			}
		});
		scrollPane.setBounds(10, 11, 908, 172);
		contentPane.add(scrollPane);
		
		tablaMedico = new JTable();
		tablaMedico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int i = tablaMedico.getSelectedRow();
				
				if(i >= 0) {
					btnEliminar.setEnabled(true);
					;
				}
					
			}
		});
		
		scrollPane.setViewportView(tablaMedico);
		model.addColumn("Nº de Registro");
		model.addColumn("Nombre Completo");
		model.addColumn("Número de ID");
		model.addColumn("Fecha de alta");
		tablaMedico.setModel(model);
		
		// bloquear las celdas para que no sean movidas por el usuario
		tablaMedico.getColumnModel().getColumn(0).setResizable(false);
		tablaMedico.getColumnModel().getColumn(1).setResizable(false);
		tablaMedico.getColumnModel().getColumn(2).setResizable(false);
		// definir el volumen de las columnas 
		tablaMedico.getColumnModel().getColumn(0).setPreferredWidth(20);
		tablaMedico.getColumnModel().getColumn(1).setPreferredWidth(130);
		tablaMedico.getColumnModel().getColumn(2).setPreferredWidth(130);
		
		tablaMedico.getTableHeader().setReorderingAllowed(false);
		tablaMedico.setRowHeight(20);//tamaño de las celdas
		//table.setGridColor(new java.awt.Color(0, 0, 0));
		
		// coneccion para personalizar el encabezado de la tabla 
		JTableHeader jtableHeader = tablaMedico.getTableHeader();
	    jtableHeader.setDefaultRenderer(new PERSONALIZAR.Encabezado());
	    tablaMedico.setTableHeader(jtableHeader);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCerrar.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_close_black_24dp.png"));
		btnCerrar.setBackground(Color.LIGHT_GRAY);
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCerrar.setBounds(801, 194, 102, 28);
		contentPane.add(btnCerrar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_delete_black_24dp.png"));
		btnEliminar.setBackground(Color.LIGHT_GRAY);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int i = tablaMedico.getSelectedRow();
				
				if(i>=0) 
					model.removeRow(i);
				else 
					JOptionPane.showMessageDialog(null, "No seleccionaste ninguna fila! Seleccione una fila."," Atención",JOptionPane.WARNING_MESSAGE);
				
			}
		});
		btnEliminar.setBounds(653, 194, 110, 28);
		contentPane.add(btnEliminar);
		llenarTablaRegistroMedico();
		
	}
	
	public void llenarTablaRegistroMedico() {
		
		Datos.getInstancia().cargarMedicos();
		
		ArrayList<Medico> medicos = Datos.getInstancia().obtenerMedicos();
		
		for (int i = 0; i < medicos.size(); i++) {
			
			Object[] fila = {
					
					medicos.get(i).getNumRegistro(),
					medicos.get(i).getNomComplet(),
					medicos.get(i).getIdMedico(),
					medicos.get(i).getFechaAlta()
					
			};
			model.addRow(fila);
		}
		
	}
	
	
	
}
