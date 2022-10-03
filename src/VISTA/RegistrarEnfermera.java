package VISTA;

import java.awt.Color;
//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;

import AUXILIAR.Datos;
import MODELO.Enfermera;
import MODELO.Metodo;
import MODELO.Registrar;

import java.awt.Font;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class RegistrarEnfermera extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNumID;
	private JTextField textNomComp;
	private JLabel lblAnioExp;
	private JButton btnSalir;
	ButtonGroup group = new ButtonGroup();
	Metodo met = new Metodo();
	private JRadioButton rdbtnSi;
	private JRadioButton rdbtnNo;
	private JSpinner spinnerAnioExp;
	private JDateChooser dateChooser;
	private JButton btnRegistrar;
	private JLabel lblNumID;
	private JLabel lblNomComp;
	private JLabel lblTieneLicen;
	private JLabel lblFechaComienzo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarEnfermera frame = new RegistrarEnfermera();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void cargarVentana() {
		lblNumID = new JLabel("N\u00BA de ID");
		lblNumID.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNumID.setBounds(122, 52, 58, 14);
		contentPane.add(lblNumID);
		
		textNumID = new JTextField();
		textNumID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNumID.setBounds(185, 50, 163, 20);
		contentPane.add(textNumID);
		textNumID.setColumns(10);
		
		// CARGAR ENFERMERAS
		Datos.getInstancia().cargarEnfermeras();
		
		lblNomComp = new JLabel("Nombre Completo");
		lblNomComp.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNomComp.setBounds(64, 87, 119, 14);
		contentPane.add(lblNomComp);
		
		textNomComp = new JTextField();
		textNomComp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNomComp.setBounds(186, 85, 284, 20);
		contentPane.add(textNomComp);
		textNomComp.setColumns(10);
		
		lblTieneLicen = new JLabel("Tiene licenciatura");
		lblTieneLicen.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTieneLicen.setBounds(69, 119, 119, 14);
		contentPane.add(lblTieneLicen);
		
		lblAnioExp = new JLabel("A\u00F1o de Experiencia");
		lblAnioExp.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAnioExp.setBounds(57, 150, 138, 14);
		contentPane.add(lblAnioExp);
		
		
		
		rdbtnNo = new JRadioButton("No");
		rdbtnNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNo.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				met.setTieneLicenc(rdbtnNo.getLabel());
			}
		});
		rdbtnNo.setBounds(232, 114, 40, 23);
		contentPane.add(rdbtnNo);
		
		rdbtnSi = new JRadioButton("Si");
		rdbtnSi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnSi.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				met.setTieneLicenc(rdbtnSi.getLabel());
			}
		});
		rdbtnSi.setBounds(184, 114, 46, 23);
		contentPane.add(rdbtnSi);
		
		// BUTTON GRUOP
			group.add(rdbtnSi);
			group.add(rdbtnNo);
		lblFechaComienzo = new JLabel("Fecha en que comenz\u00F3");
		lblFechaComienzo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFechaComienzo.setBounds(35, 185, 138, 14);
		contentPane.add(lblFechaComienzo);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(186, 182, 119, 20);
		contentPane.add(dateChooser);
		
		spinnerAnioExp = new JSpinner();
		spinnerAnioExp.setBounds(185, 148, 58, 20);
		contentPane.add(spinnerAnioExp);
	}

	/**
	 * Create the frame.
	 */
	public RegistrarEnfermera() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_assignment_ind_black_24dp.png"));
		setResizable(false);
		setTitle("Registrar Enfermero(a)");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 530, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cargarVentana();
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegistrar.setBackground(Color.LIGHT_GRAY);
		btnRegistrar.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_save_black_24dp.png"));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean datoIncorrecto = false;
				String numId = textNumID.getText();
				String nomComplet = textNomComp.getText();
				String tienelicenc = met.getTieneLicenc();
				int experiencia = Integer.parseInt(spinnerAnioExp.getValue().toString());
				
				boolean tiene = false;
				
				if(tienelicenc=="Si")
					tiene = true;
				
				if(numId.replace("", "").equalsIgnoreCase("")) {
					lblNumID.setForeground(Color.RED);
					datoIncorrecto = true;
				}else
					lblNumID.setForeground(Color.BLACK);
				
				if(nomComplet.replace("", "").equalsIgnoreCase("")) {
					lblNomComp.setForeground(Color.RED);
					datoIncorrecto = true;
				}else
					lblNomComp.setForeground(Color.BLACK);
				
				if(tienelicenc.replace("", "").equalsIgnoreCase("")) {
					lblTieneLicen.setForeground(Color.RED);
					datoIncorrecto = true;
				}else
					lblTieneLicen.setForeground(Color.BLACK);
				
				if(dateChooser.getDate()==null) {
					lblFechaComienzo.setForeground(Color.RED);
					datoIncorrecto = true;
				}else
					lblFechaComienzo.setForeground(Color.BLACK);
				
				if(datoIncorrecto) {
					JOptionPane.showMessageDialog(null, "No pueden estar vacios los campos marcados en rojo.");
					
				}else {
					
					SimpleDateFormat dformat = new SimpleDateFormat("dd-MM-yyyy");
					String fechaComienzo = dformat.format(dateChooser.getDate());
					
					Enfermera e = new Enfermera(nomComplet, numId, tiene, experiencia, fechaComienzo);
					
					int t = Datos.getInstancia().obtenerEnfermera().size();
					Datos.getInstancia().insertarEnfermera(e);
					
					Registrar.getInstancia().registrarEnfermera(t, Datos.getInstancia().obtenerEnfermera());
				}				
			}
		});
		btnRegistrar.setBounds(185, 234, 110, 28);
		contentPane.add(btnRegistrar);
		
		btnSalir = new JButton("Cancelar");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalir.setBackground(Color.LIGHT_GRAY);
		btnSalir.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_close_black_24dp.png"));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				System.out.println("aki sale");
				cargarVentana();
			}
		});
		btnSalir.setBounds(332, 234, 110, 28);
		contentPane.add(btnSalir);
		
		
		
	}
}
