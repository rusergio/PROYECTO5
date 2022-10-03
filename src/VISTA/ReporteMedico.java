package VISTA;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import AUXILIAR.Datos;
import MODELO.Medico;
import VISTA.PoliclinAsignados;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import java.awt.Color;
import java.awt.Toolkit;

public class ReporteMedico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JTable reporteMedico;
	DefaultTableModel model = new DefaultTableModel();
	private JButton btnCerrar;
	private JButton btnVerConsult;
	static PoliclinAsignados pa;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteMedico frame = new ReporteMedico();
					frame.setVisible(true);
					pa = new PoliclinAsignados();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReporteMedico() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_assignment_ind_black_24dp.png"));
		setResizable(false);
		setTitle("Reporte de los medicos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 803, 315);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 769, 225);
		contentPane.add(scrollPane);
		
		reporteMedico = new JTable();
		model = new DefaultTableModel();
		
		reporteMedico.setSurrendersFocusOnKeystroke(true);
		reporteMedico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		reporteMedico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		reporteMedico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int i = reporteMedico.getSelectedRow();
				Medico m = Datos.getInstancia().obtenerMedicos().get(i);
				pa = new PoliclinAsignados();
				model = new DefaultTableModel();
				for(int j = 0; j < m.getConsultAsig().size(); j++) {
					
					Object[] fila = {
							m.getConsultAsig().get(j).getNumero(),
							m.getConsultAsig().get(j).getNombPoliclin(),
							m.getConsultAsig().get(j).getNombDirector()
					};
			      
			      PoliclinAsignados.model.addRow(fila);
				
				}
				
			}
		});
		
		scrollPane.setViewportView(reporteMedico);
		model.addColumn("Nº de Registro");
		model.addColumn("Nombre Completo");
		model.addColumn("Id medico");
		model.addColumn("Fecha de Alta");
		reporteMedico.setModel(model);
		
		// bloquear las celdas para que no sean movidas por el usuario
		reporteMedico.getColumnModel().getColumn(0).setResizable(false);
		reporteMedico.getColumnModel().getColumn(1).setResizable(false);
		reporteMedico.getColumnModel().getColumn(2).setResizable(false);
		reporteMedico.getColumnModel().getColumn(3).setResizable(false);
		
		// definir el volumen de las columnas 
		reporteMedico.getColumnModel().getColumn(0).setPreferredWidth(10);
		reporteMedico.getColumnModel().getColumn(1).setPreferredWidth(130);
		reporteMedico.getColumnModel().getColumn(2).setPreferredWidth(130);
		reporteMedico.getColumnModel().getColumn(3).setPreferredWidth(80);
				
		reporteMedico.getTableHeader().setReorderingAllowed(false);
		reporteMedico.setRowHeight(20);//tamaño de las celdas
		//table.setGridColor(new java.awt.Color(0, 0, 0));
		
		// coneccion para personalizar el encabezado de la tabla 
		JTableHeader jtableHeader = reporteMedico.getTableHeader();
	    jtableHeader.setDefaultRenderer(new PERSONALIZAR.Encabezado());
	    reporteMedico.setTableHeader(jtableHeader);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCerrar.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_close_black_24dp.png"));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCerrar.setBackground(Color.LIGHT_GRAY);
		btnCerrar.setBounds(632, 247, 110, 28);
		contentPane.add(btnCerrar);
		
		btnVerConsult = new JButton("Ver Consultorios ");
		btnVerConsult.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVerConsult.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_villa_black_24dp.png"));
		btnVerConsult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pa.setVisible(true);
				
			}
		});
		btnVerConsult.setBackground(Color.LIGHT_GRAY);
		btnVerConsult.setBounds(421, 247, 170, 28);
		contentPane.add(btnVerConsult);
		llenartablaReportemedico();
	}
	
	public void llenartablaReportemedico() {
		
		Datos.getInstancia().cargarMedicos();
		
		ArrayList<Medico> medicos = Datos.getInstancia().obtenerMedicos();
		
		for(int i = 0; i < medicos.size(); i++) {
			
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
