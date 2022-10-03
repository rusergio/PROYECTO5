package VISTA;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableModel;
import javax.swing.table.JTableHeader;

import AUXILIAR.Datos;
import MODELO.Enfermera;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
//import javax.swing.border.TitledBorder;
//import javax.swing.SpinnerNumberModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class RegistroEnfermera extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnCerrar;
	private JButton btnEliminar;
	static JTable tablaEnfermera;
	
	public static DefaultTableModel model = new DefaultTableModel();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroEnfermera frame = new RegistroEnfermera();
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
	public RegistroEnfermera() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_perm_identity_black_24dp.png"));
		setTitle("Registro de Enfermeras(os)");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 927, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 890, 237);
		contentPane.add(scrollPane);
		
		
		tablaEnfermera = new JTable();
		tablaEnfermera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int i = tablaEnfermera.getSelectedRow();
				
				if(i>=0)
					btnEliminar.setEnabled(true);
			}
		});
		scrollPane.setViewportView(tablaEnfermera);
		model.addColumn("Nº ID");
		model.addColumn("Nombre completo");
		model.addColumn("Año de Experiencia");
		model.addColumn("¿Tiene licenciatura?");
		model.addColumn("Fecha que empezó");
		tablaEnfermera.setModel(model);
		
		
		// bloquear las celdas para que no sean movidas por el usuario
		tablaEnfermera.getColumnModel().getColumn(0).setResizable(false);
		tablaEnfermera.getColumnModel().getColumn(1).setResizable(false);
		tablaEnfermera.getColumnModel().getColumn(2).setResizable(false);
		// definir el volumen de las columnas 
		tablaEnfermera.getColumnModel().getColumn(0).setPreferredWidth(20);
		tablaEnfermera.getColumnModel().getColumn(1).setPreferredWidth(130);
		tablaEnfermera.getColumnModel().getColumn(2).setPreferredWidth(40);
		tablaEnfermera.getColumnModel().getColumn(3).setPreferredWidth(40);
		tablaEnfermera.getColumnModel().getColumn(4).setPreferredWidth(40);
		
		tablaEnfermera.getTableHeader().setReorderingAllowed(false);
		tablaEnfermera.setRowHeight(20);//tamaño de las celdas
		//table.setGridColor(new java.awt.Color(0, 0, 0));
		
		// coneccion para personalizar el encabezado de la tabla 
		JTableHeader jtableHeader = tablaEnfermera.getTableHeader();
	    jtableHeader.setDefaultRenderer(new PERSONALIZAR.Encabezado());
	    tablaEnfermera.setTableHeader(jtableHeader);
	    
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBackground(Color.LIGHT_GRAY);
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("aki");
				dispose();
			}
		});
		btnCerrar.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_close_black_24dp.png"));
		btnCerrar.setBounds(790, 259, 105, 28);
		contentPane.add(btnCerrar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEliminar.setBackground(Color.LIGHT_GRAY);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tablaEnfermera.getSelectedRow();
				
				if(i>=0) 
					model.removeRow(i);
				else 
					JOptionPane.showMessageDialog(null, "No seleccionaste ninguna fila! Seleccione una fila."," Atención",JOptionPane.WARNING_MESSAGE);
			
			}
		});
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_delete_black_24dp.png"));
		btnEliminar.setBounds(632, 259, 110, 28);
		contentPane.add(btnEliminar);
		llenarTablaRegistroEnferme();
		
	}
	public void llenarTablaRegistroEnferme() {
		
		Datos.getInstancia().cargarEnfermeras();
		
		ArrayList<Enfermera> enfermeras = Datos.getInstancia().obtenerEnfermera();
		
		for (int i = 0; i < enfermeras.size(); i++) {
			
			Object[] fila = {
					
					enfermeras.get(i).getNumId(),
					enfermeras.get(i).getNombre(),
					enfermeras.get(i).getAniosExperiencia(),
					enfermeras.get(i).isTieneLicenciatur(),
					enfermeras.get(i).getFechComienzo()
					
			};
			model.addRow(fila);
		}
		
	}
	
}
