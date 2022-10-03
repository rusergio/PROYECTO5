package VISTA;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import AUXILIAR.Datos;
import MODELO.Embarazada;

//import javax.swing.GroupLayout;
//import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;
//import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class RegistroEmbarazada extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaEmbarazada;
	public static DefaultTableModel model = new DefaultTableModel();
	private JButton btnEliminar;
	private JButton btnCerrar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroEmbarazada frame = new RegistroEmbarazada();
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
	public RegistroEmbarazada() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_pregnant_woman_black_24dp.png"));
		setResizable(false);
		setTitle("Registro de embarazada");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1261, 291);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int i = tablaEmbarazada.getSelectedRow();
				if(i >= 0) {
					btnEliminar.setEnabled(true);
					
				}
				
			}
		});
		scrollPane.setBounds(5, 11, 1231, 204);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i = tablaEmbarazada.getSelectedRow();
				
				if(i>=0) 
					model.removeRow(i);
				else 
					JOptionPane.showMessageDialog(null, "No seleccionaste ninguna fila! Seleccione una fila."," Atención",JOptionPane.WARNING_MESSAGE);
				
			}
		});
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_delete_black_24dp.png"));
		btnEliminar.setEnabled(false);
		btnEliminar.setBackground(SystemColor.activeCaptionBorder);
		btnEliminar.setBounds(927, 225, 110, 28);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCerrar.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_close_black_24dp.png"));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCerrar.setBackground(Color.LIGHT_GRAY);
		btnCerrar.setBounds(1092, 225, 104, 28);
		contentPane.setLayout(null);
		contentPane.add(btnEliminar);
		contentPane.add(btnCerrar);
		contentPane.add(scrollPane);
		
		tablaEmbarazada = new JTable();
		tablaEmbarazada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int i = tablaEmbarazada.getSelectedRow();
				
				if(i>=0)
					btnEliminar.setEnabled(true);
				
			}
		});
		scrollPane.setViewportView(tablaEmbarazada);
		model.addColumn("Nº de Historial");
		model.addColumn("Nombre Completo");
		model.addColumn("Edad");
		model.addColumn("Sexo");
		model.addColumn("Enfermedad");
		model.addColumn("Vacunación");
		model.addColumn("Fecha de Citologia");
		tablaEmbarazada.setModel(model);
		
		// bloquear las celdas para que no sean movidas por el usuario
		tablaEmbarazada.getColumnModel().getColumn(0).setResizable(false);
		tablaEmbarazada.getColumnModel().getColumn(1).setResizable(false);
		tablaEmbarazada.getColumnModel().getColumn(2).setResizable(false);
		// definir el volumen de las columnas 
		tablaEmbarazada.getColumnModel().getColumn(0).setPreferredWidth(15);
		tablaEmbarazada.getColumnModel().getColumn(1).setPreferredWidth(150);
		tablaEmbarazada.getColumnModel().getColumn(2).setPreferredWidth(10);
		tablaEmbarazada.getColumnModel().getColumn(3).setPreferredWidth(10);
		tablaEmbarazada.getColumnModel().getColumn(4).setPreferredWidth(130);
		tablaEmbarazada.getColumnModel().getColumn(5).setPreferredWidth(100);
		tablaEmbarazada.getColumnModel().getColumn(6).setPreferredWidth(30);
		
		tablaEmbarazada.getTableHeader().setReorderingAllowed(false);
		tablaEmbarazada.setRowHeight(20);//tamaño de las celdas
		//table.setGridColor(new java.awt.Color(0, 0, 0));
		
		// coneccion para personalizar el encabezado de la tabla 
		JTableHeader jtableHeader = tablaEmbarazada.getTableHeader();
	    jtableHeader.setDefaultRenderer(new PERSONALIZAR.Encabezado());
	    tablaEmbarazada.setTableHeader(jtableHeader);
		
		
		cargarTablaEmbarazadas();
	}
	
	public void cargarTablaEmbarazadas() {
		
		Datos.getInstancia().CargarEmbarazadas();
		
		ArrayList<Embarazada>embarazadas = Datos.getInstancia().obtenerEmbarazadas();
		
		for(int i = 0; i < embarazadas.size(); i++) {
			
			Object[] fila = {
					
					embarazadas.get(i).getNumHist(),
					embarazadas.get(i).getNombre(),
					embarazadas.get(i).getEdad(),
					embarazadas.get(i).getSexo(),
					embarazadas.get(i).getEnfermedad(),
					embarazadas.get(i).getVacunacion(),
					embarazadas.get(i).getFechCitolog(),
					
			};
			model.addRow(fila);
		}
		
	}

}
