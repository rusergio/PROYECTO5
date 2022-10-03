package VISTA;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class ConsultorioMedico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	
	
	
	
	private JMenuItem mntmRegistroMedicos;
	private JMenuItem mntmRegistroDeEnfermerosas;
	private JMenuItem mntmRegistroDeConsultorios;
	private JMenuItem mntmRegistPacients;
	private JMenuItem mntmRegistMujer;
	private JMenuItem mntmMedico;
	private JMenuItem mntmComentarios;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultorioMedico frame = new ConsultorioMedico();
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
	public ConsultorioMedico() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_medical_services_black_24dp.png"));
		setResizable(false);
		setTitle("Consultorio Medico Familiar (CMF)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 504);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Consultorio");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(mnNewMenu);
		
		JMenu mnAgregar = new JMenu("Registrar");
		mnAgregar.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_article_black_24dp.png"));
		mnNewMenu.add(mnAgregar);
		
		mntmMedico = new JMenuItem("Medico");
		mntmMedico.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_person_black_24dp.png"));
		mntmMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegistrarMedico rm = new RegistrarMedico();
				rm.setVisible(true);
			}
		});
		
		JMenuItem mntmPaciente = new JMenuItem("Paciente");
		mntmPaciente.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_emoji_people_black_24dp.png"));
		mntmPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RegistrarPaciente rp = new RegistrarPaciente();
				rp.setVisible(true);
				
			}
		});
		mnAgregar.add(mntmPaciente);
		mnAgregar.add(mntmMedico);
		
		JMenuItem mntmEnfermera = new JMenuItem("Enfermera");
		mntmEnfermera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RegistrarEnfermera re = new RegistrarEnfermera();
				re.setVisible(true);
				
			}
		});
		mntmEnfermera.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_perm_identity_black_24dp.png"));
		mnAgregar.add(mntmEnfermera);
		
		JMenuItem mntmConsultorio = new JMenuItem("Consultorio");
		mntmConsultorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RegistrarConsultorio rc = new RegistrarConsultorio();
				rc.setVisible(true);
				
			}
		});
		mntmConsultorio.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_villa_black_24dp.png"));
		mnAgregar.add(mntmConsultorio);
		
		JMenuItem mntmActualizar = new JMenuItem("Actualizar");
		mntmActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		mntmActualizar.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_cached_black_24dp.png"));
		mnNewMenu.add(mntmActualizar);
		
		JMenuItem mntmTerminarSeccion = new JMenuItem("Terminar Secci\u00F3n");
		mntmTerminarSeccion.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_logout_black_24dp.png"));
		mntmTerminarSeccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ConsultorioMedico.this.setVisible(false);
				IniciarSesion is = new IniciarSesion();
				is.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmTerminarSeccion);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\round_power_settings_new_black_24dp.png"));
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		mnNewMenu.add(mntmSalir);
		
		JMenu mnReporte = new JMenu("Registros");
		menuBar.add(mnReporte);
		
		mntmRegistPacients = new JMenuItem("Registro de Pacientes");
		mntmRegistPacients.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_assignment_ind_black_24dp.png"));
		mntmRegistPacients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RegistroConsultorio rc = new RegistroConsultorio();
				rc.setVisible(true);
				
			}
		});
		mnReporte.add(mntmRegistPacients);
		
		mntmRegistMujer = new JMenuItem("Registro de Embarazadas");
		mntmRegistMujer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RegistroEmbarazada re = new RegistroEmbarazada();
				re.setVisible(true);
				
			}
		});
		mntmRegistMujer.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_assignment_ind_black_24dp.png"));
		mnReporte.add(mntmRegistMujer);
		
		mntmRegistroMedicos = new JMenuItem("Registro de Medicos");
		mntmRegistroMedicos.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_assignment_ind_black_24dp.png"));
		mntmRegistroMedicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RegistroMedico rm = new RegistroMedico();
				rm.setVisible(true);
				
			}
		});
		mnReporte.add(mntmRegistroMedicos);
		
		mntmRegistroDeEnfermerosas = new JMenuItem("Registro de Enfermeras");
		mntmRegistroDeEnfermerosas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegistroEnfermera re = new RegistroEnfermera();
				re.setVisible(true);
				
			}
		});
		mntmRegistroDeEnfermerosas.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_assignment_ind_black_24dp.png"));
		mnReporte.add(mntmRegistroDeEnfermerosas);
		
		mntmRegistroDeConsultorios = new JMenuItem("Registro de Consultorios");
		mntmRegistroDeConsultorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegistroConsultorio rc = new RegistroConsultorio();
				rc.setVisible(true);
				
			}
		});
		
		mntmRegistroDeConsultorios.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_real_estate_agent_black_24dp.png"));
		mnReporte.add(mntmRegistroDeConsultorios);
		
		JMenu mnHistoriales = new JMenu("Historiales");
		menuBar.add(mnHistoriales);
		
		JMenuItem mntmHistPacients = new JMenuItem("Historial de Pacientes");
		mntmHistPacients.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_assignment_black_24dp.png"));
		mnHistoriales.add(mntmHistPacients);
		
		JMenuItem mntmHistEmbarazdas = new JMenuItem("Historial de Embarazadas");
		mntmHistEmbarazdas.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_assignment_black_24dp.png"));
		mnHistoriales.add(mntmHistEmbarazdas);
		
		JMenuItem mntmHistNiños = new JMenuItem("Historial de Ni\u00F1os");
		mntmHistNiños.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_assignment_black_24dp.png"));
		mnHistoriales.add(mntmHistNiños);
		
		JMenu mnReporte_1 = new JMenu("Reporte");
		menuBar.add(mnReporte_1);
		
		JMenuItem mnReporteMedico = new JMenuItem("Reporte Medico(a)");
		mnReporteMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ReporteMedico rm = new ReporteMedico();
				rm.setVisible(true);
				
			}
		});
		mnReporteMedico.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_person_pin_black_24dp.png"));
		mnReporte_1.add(mnReporteMedico);
		
		JMenuItem mnReporteEnfermera = new JMenuItem("Reporte Enfermero(a)");
		mnReporteEnfermera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReporteEnfermera re = new ReporteEnfermera();
				re.setVisible(true);
			}
		});
		mnReporteEnfermera.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_person_pin_black_24dp.png"));
		mnReporte_1.add(mnReporteEnfermera);
		
		JMenu mnReportePaciente = new JMenu("Reporte Pacientes");
		mnReportePaciente.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_accessibility_black_24dp.png"));
		mnReporte_1.add(mnReportePaciente);
		
		JMenuItem mnPacienteNorm = new JMenuItem("Normal");
		mnPacienteNorm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ReportePaciente rp = new ReportePaciente();
				rp.setVisible(true);
				
			}
		});
		mnPacienteNorm.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_settings_accessibility_black_24dp.png"));
		mnReportePaciente.add(mnPacienteNorm);
		
		JMenuItem mnReporteEmb = new JMenuItem("Embarazada");
		mnReporteEmb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ReporteEmbarazada re = new ReporteEmbarazada();
				re.setVisible(true);
				
			}
		});
		mnReporteEmb.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_pregnant_woman_black_24dp.png"));
		mnReportePaciente.add(mnReporteEmb);
		
		JMenuItem mnNinos = new JMenuItem("Ni\u00F1os");
		mnNinos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnNinos.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_baby_changing_station_black_24dp.png"));
		mnReportePaciente.add(mnNinos);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mnSobreCMF = new JMenuItem("Sobre CMF");
		mnSobreCMF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SobreCMF scmf = new SobreCMF();
				scmf.setVisible(true);
				
			}
		});
		mnSobreCMF.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_medical_services_black_24dp.png"));
		mnAyuda.add(mnSobreCMF);
		
		mntmComentarios = new JMenuItem("Ayuda Comentada");
		mntmComentarios.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_help_black_24dp.png"));
		mntmComentarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AyudaComentado ac = new AyudaComentado();
				ac.setVisible(true);
				
			}
		});
		mnAyuda.add(mntmComentarios);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(21, 11, 657, 432);
		contentPane.add(panel);
		panel.setLayout(null);
		
	}
}
