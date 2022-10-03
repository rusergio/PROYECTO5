package VISTA;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Toolkit;

public class PoliclinAsignados extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTable tablaAsignados;
	public static DefaultTableModel model = new DefaultTableModel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PoliclinAsignados frame = new PoliclinAsignados();
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
	public PoliclinAsignados() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_night_shelter_black_24dp.png"));
		setTitle("Policlinicos Asignados");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 881, 207);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 845, 112);
		contentPane.add(scrollPane);
		
		tablaAsignados = new JTable();
		model = new DefaultTableModel();
		
		tablaAsignados.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tablaAsignados.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(tablaAsignados);
		model.addColumn("Nº de consultorio");
		model.addColumn("Nombre del consultorio");
		model.addColumn("Nombre del director");
		tablaAsignados.setModel(model);
		
		// bloquear las celdas para que no sean movidas por el usuario
		tablaAsignados.getColumnModel().getColumn(0).setResizable(false);
		tablaAsignados.getColumnModel().getColumn(1).setResizable(false);
		tablaAsignados.getColumnModel().getColumn(2).setResizable(false);
			
		// definir el volumen de las columnas 
		tablaAsignados.getColumnModel().getColumn(0).setPreferredWidth(10);
		tablaAsignados.getColumnModel().getColumn(1).setPreferredWidth(130);
		tablaAsignados.getColumnModel().getColumn(2).setPreferredWidth(130);
				
		tablaAsignados.getTableHeader().setReorderingAllowed(false);
		tablaAsignados.setRowHeight(20);//tamaño de las celdas
		//table.setGridColor(new java.awt.Color(0, 0, 0));
		
		// coneccion para personalizar el encabezado de la tabla 
		JTableHeader jtableHeader = tablaAsignados.getTableHeader();
	    jtableHeader.setDefaultRenderer(new PERSONALIZAR.Encabezado());
	    tablaAsignados.setTableHeader(jtableHeader);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_close_black_24dp.png"));
		btnCerrar.setBackground(Color.LIGHT_GRAY);
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setBounds(695, 134, 110, 28);
		contentPane.add(btnCerrar);
	}

}
