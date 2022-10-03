package VISTA;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import AUXILIAR.Datos;
import MODELO.Consultorio;
import MODELO.Registrar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class RegistrarConsultorio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField textNumConsult;
	public static JTextField textNomDirec;
	public static JTextField textnombPolic;
	private JButton btnRegistrar;
	private JButton btnCancelar;
	private JLabel lblNumConsult;
	private JLabel lblNomDirec;
	private JLabel lblNomPolic;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarConsultorio frame = new RegistrarConsultorio();
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
	public RegistrarConsultorio() {
		setTitle("Registrar Consultorio");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 508, 252);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblNumConsult = new JLabel("N\u00BA de Consultorio");
		lblNumConsult.setBounds(56, 55, 121, 17);
		lblNumConsult.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textNumConsult = new JTextField();
		textNumConsult.setBounds(175, 54, 157, 20);
		textNumConsult.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNumConsult.setColumns(10);
		
		lblNomPolic = new JLabel("Nombre del Policlinico");
		lblNomPolic.setBounds(34, 98, 143, 14);
		lblNomPolic.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		lblNomDirec = new JLabel("Nombre del Director");
		lblNomDirec.setBounds(42, 138, 134, 14);
		lblNomDirec.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textNomDirec = new JTextField();
		textNomDirec.setBounds(175, 134, 302, 20);
		textNomDirec.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNomDirec.setColumns(10);
		
		// CARGAR DATOS DE CONSULTORIOS
		Datos.getInstancia().cargarConsultorios();
		
		textnombPolic = new JTextField();
		textnombPolic.setBounds(175, 96, 302, 20);
		textnombPolic.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textnombPolic.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(Color.LIGHT_GRAY);
		btnRegistrar.setBounds(175, 180, 110, 28);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 boolean datoIncorrecto = false;
				 
				 String numHist = textNumConsult.getText();
				 String nomPoliclin = textnombPolic.getText();
				 String nomDirector = textNomDirec.getText();
				 
				 if(numHist.replace("", "").equalsIgnoreCase("")) {
					 lblNumConsult.setForeground(Color.RED);
					 datoIncorrecto = true;
				 }else
					 lblNumConsult.setForeground(Color.BLACK);
				 
				 if(nomPoliclin.replace("", "").equalsIgnoreCase("")) {
					 lblNomPolic.setForeground(Color.RED);
					 datoIncorrecto = true;
				 }else
					 lblNomPolic.setForeground(Color.BLACK);
				 
				 if(nomDirector.replace("", "").equalsIgnoreCase("")) {
					 lblNomDirec.setForeground(Color.RED);
					 datoIncorrecto = true;
				 }else
					 lblNomDirec.setForeground(Color.BLACK);
				
				 if(datoIncorrecto) {
					 JOptionPane.showMessageDialog(null, "No pueden estar vacios los campos marcados en rojo!","  Alerta!",JOptionPane.WARNING_MESSAGE);
				 }else {
					 try {
				 int num = Integer.parseInt(textNumConsult.getText());
				 Consultorio c = new Consultorio(num, nomPoliclin, nomDirector);				 
				 
				 int t = Datos.getInstancia().obtenerConsultorios().size();
				 Datos.getInstancia().insertarConsultorio(c);
				 
				 Registrar.getInstancia().registrarConsultorio(t, Datos.getInstancia().obtenerConsultorios());
				 
				 textnombPolic.setText("");
				 textNomDirec.setText("");
				 textNumConsult.setText("");
				 
				 JOptionPane.showMessageDialog(null, "Datos registrado con suceso");
				 
				 int i = JOptionPane.showConfirmDialog(null, "Deseas Continuar?");
				 
				 if(i==0) {
					 
				 } 
				 else if(i==1) {
					 dispose();
				 }
				 
					 }catch (Exception ex) {
						// TODO: handle exception
						 ///System.out.println("atencion en numero de consultorio no puede contener letras");
					}
				 }
				  
			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegistrar.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_save_black_24dp.png"));
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.LIGHT_GRAY);
		btnCancelar.setBounds(315, 180, 110, 28);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_close_black_24dp.png"));
		contentPane.setLayout(null);
		contentPane.add(textNumConsult);
		contentPane.add(lblNumConsult);
		contentPane.add(textnombPolic);
		contentPane.add(lblNomPolic);
		contentPane.add(textNomDirec);
		contentPane.add(lblNomDirec);
		contentPane.add(btnRegistrar);
		contentPane.add(btnCancelar);
	}
}
