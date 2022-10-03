package VISTA;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;

import AUXILIAR.Datos;
import MODELO.Embarazada;
import MODELO.Metodo;
import MODELO.Paciente;
import MODELO.Registrar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SpinnerNumberModel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerListModel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

@SuppressWarnings("unused")
public class RegistrarPaciente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNumHist;
	private JTextField textNomComp;
	private JTextField textEnfermed;
	private JDateChooser dateChooser;
	ButtonGroup g1 = new ButtonGroup();
	ButtonGroup g2 = new ButtonGroup();
	private JSpinner spinnerEdad;
	private JButton btnRegistrar;
	private JButton btnCancelar;
	private JLabel lblFechaPrueba;
	private JLabel lblEmbarazada;
	private JRadioButton rdbtnSi;
	private JRadioButton rdbtnNo;
	private JRadioButton rdbtnM;
	private JRadioButton rdbtnF;
	@SuppressWarnings("rawtypes")
	private JComboBox cmboxVacunar;
	/**
	 * Launch the application.
	 */
	
	Metodo met = new Metodo();
	private JLabel lblNumHist;
	private JLabel lblSexo;
	private JLabel lblEdad;
	private JLabel lblNombComp;
	private JLabel lblEnfermedad;
	private JLabel lblVacunacion;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarPaciente frame = new RegistrarPaciente();
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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public RegistrarPaciente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_assignment_ind_black_24dp.png"));
		setResizable(false);
		setTitle("Registrar Paciente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 430, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNumHist = new JLabel("N\u00BA de Historial");
		lblNumHist.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNumHist.setBounds(56, 48, 97, 14);
		contentPane.add(lblNumHist);
		
		textNumHist = new JTextField();
		textNumHist.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNumHist.setBounds(155, 45, 86, 20);
		contentPane.add(textNumHist);
		textNumHist.setColumns(10);
		
		lblNombComp = new JLabel("Nombre Completo");
		lblNombComp.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombComp.setBounds(33, 85, 120, 14);
		contentPane.add(lblNombComp);
		
		textNomComp = new JTextField();
		textNomComp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNomComp.setBounds(155, 82, 224, 20);
		contentPane.add(textNomComp);
		textNomComp.setColumns(10);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEdad.setBounds(112, 120, 40, 14);
		contentPane.add(lblEdad);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegistrar.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_save_black_24dp.png"));
		btnRegistrar.setBackground(Color.LIGHT_GRAY);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean datoIncorrecto = false;
				
				String numHist = textNumHist.getText();
				String nombre = textNomComp.getText();
				int edad = Integer.parseInt(spinnerEdad.getValue().toString());
				String sexo = met.getSexo();
				String enferm = textEnfermed.getText();
				
				String vac = (String) cmboxVacunar.getSelectedItem();
				String estaEmb = met.getConfirma();
				
				if(numHist.replace("", "").equalsIgnoreCase("")) {
					lblNumHist.setForeground(Color.RED);
					datoIncorrecto = true;
				}else
					lblNumHist.setForeground(Color.BLACK);
				
				if(nombre.replace("", "").equalsIgnoreCase("")) {
					lblNombComp.setForeground(Color.RED);
					datoIncorrecto = true;
				}else
					lblNombComp.setForeground(Color.BLACK);
				
				if(sexo.replace("", "").equalsIgnoreCase("")) {
					lblSexo.setForeground(Color.RED);
					datoIncorrecto = true;
				}else
					lblSexo.setForeground(Color.BLACK);
				
				if(enferm.replace("", "").equalsIgnoreCase("")) {
					lblEnfermedad.setForeground(Color.RED);
					datoIncorrecto = true;
				}else
					lblEnfermedad.setForeground(Color.BLACK);
				
				if(cmboxVacunar.getSelectedIndex()==0) {
					lblVacunacion.setForeground(Color.RED);
					datoIncorrecto = true;
				}else
					lblVacunacion.setForeground(Color.BLACK);
				
				
				if(datoIncorrecto) {
					JOptionPane.showMessageDialog(null, "No pueden estar vacios los campos marcados en rojo.");
					
				}else {
					try {
						
						if(edad >= 15 && sexo=="F") {
							
							if(estaEmb.replace("", "").equalsIgnoreCase("")) {
								lblEmbarazada.setForeground(Color.RED);
								datoIncorrecto = true;
							}else
								lblEmbarazada.setForeground(Color.BLACK);
							
							if(datoIncorrecto) {
								JOptionPane.showMessageDialog(null, "No pueden estar vacios los campos marcados en rojo.");
								
							}else {
								
								if(estaEmb == "Si") {
									
									if(dateChooser.getDate()==null) {
										lblFechaPrueba.setForeground(Color.RED);
										datoIncorrecto = true;
									}else
										lblFechaPrueba.setForeground(Color.BLACK);
									
									if(datoIncorrecto) {
										JOptionPane.showMessageDialog(null, "No pueden estar vacios los campos marcados en rojo.");
										
									}else {
										SimpleDateFormat dformat = new SimpleDateFormat("dd-MM-yyyy");
										String fecha = dformat.format(dateChooser.getDate());
										
										Embarazada e = new Embarazada(numHist, nombre, edad, sexo, enferm, vac, fecha);
										
										System.out.println("Embarazada insertada!");
										
										int t = Datos.getInstancia().obtenerEmbarazadas().size();
										Datos.getInstancia().insertarEmbarazada(e);
										
										Registrar.getInstancia().registrarEmbarazada(t, Datos.getInstancia().obtenerEmbarazadas());
										
										JOptionPane.showMessageDialog(null, "Datos registrado con suceso");
									}
								}else {
									Paciente p = new Paciente(numHist, nombre, edad, sexo, enferm, vac);
									
									System.out.println("Paciente insertado");
									
									int t = Datos.getInstancia().obtenerPacientes().size();
									Datos.getInstancia().insertarPaciente(p);
									
									Registrar.registrarPaciente(t, Datos.getInstancia().obtenerPacientes());
								
									JOptionPane.showMessageDialog(null, "Datos registrado con suceso");
									
								}
								
							}
														
						}else {
							Paciente p = new Paciente(numHist, nombre, edad, sexo, enferm, vac);
							
							System.out.println("Paciente insertado");
							
							int t = Datos.getInstancia().obtenerPacientes().size();
							Datos.getInstancia().insertarPaciente(p);
							
							Registrar.registrarPaciente(t, Datos.getInstancia().obtenerPacientes());
						
							JOptionPane.showMessageDialog(null, "Datos registrado con suceso");
							
						}
									
					}
					catch (Exception e) {
						// TODO: handle exception
						System.out.println("Error, analise bien los datos o el codigo!");
					}
				}

			}
			
		});
		btnRegistrar.setBounds(125, 325, 110, 28);
		contentPane.add(btnRegistrar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_close_black_24dp.png"));
		btnCancelar.setBackground(Color.LIGHT_GRAY);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(265, 325, 110, 28);
		contentPane.add(btnCancelar);
		
		spinnerEdad = new JSpinner();
		spinnerEdad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinnerEdad.setModel(new SpinnerNumberModel(0, 0, 120, 1));
		spinnerEdad.setBounds(155, 117, 53, 20);
		contentPane.add(spinnerEdad);
		
		lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSexo.setBounds(110, 147, 34, 14);
		contentPane.add(lblSexo);
		
		rdbtnM = new JRadioButton("M");
		rdbtnM.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnM.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				
				met.setSexo(rdbtnM.getLabel());
				
				lblFechaPrueba.setEnabled(false);
				dateChooser.setEnabled(false);
				lblEmbarazada.setEnabled(false);
				rdbtnSi.setEnabled(false);
				rdbtnNo.setEnabled(false);
			}
		});
		rdbtnM.setBounds(151, 144, 40, 23);
		contentPane.add(rdbtnM);
		
		rdbtnF = new JRadioButton("F");
		rdbtnF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnF.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				met.setSexo(rdbtnF.getLabel());
				
				int edad = Integer.parseInt(spinnerEdad.getValue().toString());
				
				if(edad >= 15) {
					lblEmbarazada.setEnabled(true);
					rdbtnSi.setEnabled(true);
					rdbtnNo.setEnabled(true);
				}
			}
		});
		rdbtnF.setBounds(193, 144, 40, 23);
		contentPane.add(rdbtnF);
		
		// Button Group
		g1.add(rdbtnM);
		g1.add(rdbtnF);
		
		lblEnfermedad = new JLabel("Enfermedad");
		lblEnfermedad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEnfermedad.setBounds(70, 182, 74, 14);
		contentPane.add(lblEnfermedad);
		
		lblVacunacion = new JLabel("Vacunaci\u00F3n");
		lblVacunacion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVacunacion.setBounds(75, 217, 74, 14);
		contentPane.add(lblVacunacion);
		
		textEnfermed = new JTextField();
		textEnfermed.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textEnfermed.setBounds(155, 179, 224, 20);
		contentPane.add(textEnfermed);
		textEnfermed.setColumns(10);
		
		rdbtnSi = new JRadioButton("Si");
		rdbtnSi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnSi.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				
				met.setConfirma(rdbtnSi.getLabel());
				lblFechaPrueba.setEnabled(true);
				dateChooser.setEnabled(true);
				
			}
		});
		rdbtnSi.setEnabled(false);
		rdbtnSi.setBounds(155, 252, 40, 23);
		contentPane.add(rdbtnSi);
		
		rdbtnNo = new JRadioButton("No");
		rdbtnNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNo.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				
				met.setConfirma(rdbtnNo.getLabel());
				lblFechaPrueba.setEnabled(false);
				dateChooser.setEnabled(false);
			}
		});
		rdbtnNo.setEnabled(false);
		rdbtnNo.setBounds(193, 252, 44, 23);
		contentPane.add(rdbtnNo);
		
		// Radio2 Button
		g2.add(rdbtnSi);
		g2.add(rdbtnNo);
		
		lblEmbarazada = new JLabel("Embarazada:");
		lblEmbarazada.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmbarazada.setEnabled(false);
		lblEmbarazada.setBounds(67, 256, 86, 14);
		contentPane.add(lblEmbarazada);
		
		lblFechaPrueba = new JLabel("Fecha de Ultima Prueba Citologica");
		lblFechaPrueba.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFechaPrueba.setEnabled(false);
		lblFechaPrueba.setBounds(56, 282, 210, 14);
		contentPane.add(lblFechaPrueba);
		
		dateChooser = new JDateChooser();
		dateChooser.setEnabled(false);
		dateChooser.setBounds(276, 282, 114, 20);
		contentPane.add(dateChooser);
		
		cmboxVacunar = new JComboBox();
		cmboxVacunar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmboxVacunar.setModel(new DefaultComboBoxModel(new String[] {"Seleccione ", "Recomendado", "No Recomendado"}));
		cmboxVacunar.setBounds(155, 215, 141, 20);
		contentPane.add(cmboxVacunar);
		
	}
}
