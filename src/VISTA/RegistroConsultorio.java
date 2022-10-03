package VISTA;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
//import javax.swing.table.TableModel;

import AUXILIAR.Datos;
import MODELO.Consultorio;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;


public class RegistroConsultorio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JTable tablaConsultorio;
	public static DefaultTableModel model = new DefaultTableModel();
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroConsultorio frame = new RegistroConsultorio();
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
	public RegistroConsultorio() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_villa_black_24dp.png"));
		setTitle("Registro de Consultorio Medico");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 813, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 777, 223);
		contentPane.add(scrollPane);
		
		tablaConsultorio = new JTable();
		tablaConsultorio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int i = tablaConsultorio.getSelectedRow();
				
				if(i>=0)
					btnEliminar.setEnabled(true);
				
			}
		});
		tablaConsultorio.setSurrendersFocusOnKeystroke(true);
		tablaConsultorio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		scrollPane.setViewportView(tablaConsultorio);
		model.addColumn("Nº de Consultorio");
		model.addColumn("Nombre del Policlínico");
		model.addColumn("Nombre del Director");
		tablaConsultorio.setModel(model);
		
		
		// bloquear las celdas para que no sean movidas por el usuario
		tablaConsultorio.getColumnModel().getColumn(0).setResizable(false);
		tablaConsultorio.getColumnModel().getColumn(1).setResizable(false);
		tablaConsultorio.getColumnModel().getColumn(2).setResizable(false);
		// definir el volumen de las columnas 
		tablaConsultorio.getColumnModel().getColumn(0).setPreferredWidth(20);
		tablaConsultorio.getColumnModel().getColumn(1).setPreferredWidth(130);
		tablaConsultorio.getColumnModel().getColumn(2).setPreferredWidth(130);
		
		tablaConsultorio.getTableHeader().setReorderingAllowed(false);
		tablaConsultorio.setRowHeight(20);//tamaño de las celdas
		//table.setGridColor(new java.awt.Color(0, 0, 0));
		
		// coneccion para personalizar el encabezado de la tabla 
		JTableHeader jtableHeader = tablaConsultorio.getTableHeader();
	    jtableHeader.setDefaultRenderer(new PERSONALIZAR.Encabezado());
	    tablaConsultorio.setTableHeader(jtableHeader);
	    
	    //se asigna la tabla al scrollPane
	    scrollPane.setViewportView(tablaConsultorio);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBackground(Color.LIGHT_GRAY);
		btnCerrar.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_close_black_24dp.png"));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCerrar.setBounds(638, 244, 102, 28);
		contentPane.add(btnCerrar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tablaConsultorio.getSelectedRow();
				
				if(i>=0) {
					model.removeRow(i);
				}
				else {
					JOptionPane.showMessageDialog(null, "No seleccionaste ninguna fila! Seleccione una fila."," Atención",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnEliminar.setBackground(Color.LIGHT_GRAY);
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_delete_black_24dp.png"));
		btnEliminar.setBounds(481, 245, 110, 28);
		contentPane.add(btnEliminar);
		
		llenarTablaConsultorio();
	}
	
	public void llenarTablaConsultorio() {
		
		Datos.getInstancia().cargarConsultorios();
		
		ArrayList<Consultorio> listaConsul = Datos.getInstancia().obtenerConsultorios();
		
		for(int i = 0; i < listaConsul.size(); i++) {
			
			Object[] fila = {
					listaConsul.get(i).getNumero(),
					listaConsul.get(i).getNombPoliclin(),
					listaConsul.get(i).getNombDirector()
			};
			
			model.addRow(fila);
		}
	}
}
