package VISTA;


import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import AUXILIAR.Datos;
import MODELO.Medico;
import MODELO.Registrar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;


public class RegistrarMedico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNumRegistro;
	private JTextField textNombre;
	private JTextField textNumId;
	private JDateChooser dateChooser;
	private JLabel lblNumRegist;
	private JLabel lblNomComp;
	private JLabel lblNumID;
	private JLabel lblFechaAlta;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarMedico frame = new RegistrarMedico();
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
	public RegistrarMedico() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_person_black_24dp.png"));
		setResizable(false);
		setTitle("Registrar Medico");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 528, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNomComp = new JLabel("Nombre Completo");
		lblNomComp.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNomComp.setBounds(45, 101, 115, 14);
		contentPane.add(lblNomComp);
		
		textNumRegistro = new JTextField();
		textNumRegistro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNumRegistro.setBounds(174, 55, 117, 20);
		contentPane.add(textNumRegistro);
		textNumRegistro.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNombre.setBounds(174, 98, 310, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		lblNumRegist = new JLabel("N\u00FAmero de Registro");
		lblNumRegist.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNumRegist.setBounds(34, 58, 130, 14);
		contentPane.add(lblNumRegist);
		
		// CARGAR DATOS DE PACIENTES
		Datos.getInstancia().cargarPacientes();
		
		lblNumID = new JLabel("N\u00FAmero de Id");
		lblNumID.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNumID.setBounds(70, 144, 90, 14);
		contentPane.add(lblNumID);
		
		textNumId = new JTextField();
		textNumId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNumId.setBounds(174, 141, 195, 20);
		contentPane.add(textNumId);
		textNumId.setColumns(10);
		
		lblFechaAlta = new JLabel("Fecha de alta");
		lblFechaAlta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFechaAlta.setBounds(74, 187, 81, 14);
		contentPane.add(lblFechaAlta);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(174, 182, 117, 22);
		contentPane.add(dateChooser);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegistrar.setBackground(Color.LIGHT_GRAY);
		btnRegistrar.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_save_black_24dp.png"));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean datoIncorrecto = false;
				String numRegistro = textNumRegistro.getText();
				String nomComplet = textNombre.getText();
				String numID = textNumId.getText();
				
				if(numRegistro.replace("", "").equalsIgnoreCase("")) {
					lblNumRegist.setForeground(Color.RED);
					datoIncorrecto = true;
				}else
					lblNumRegist.setForeground(Color.BLACK);
				
				if(nomComplet.replace("", "").equalsIgnoreCase("")) {
					lblNomComp.setForeground(Color.RED);
					datoIncorrecto = true;
				}else
					lblNomComp.setForeground(Color.BLACK);
				
				if(numID.replace("", "").equalsIgnoreCase("")) {
					lblNumID.setForeground(Color.RED);
					
					datoIncorrecto = true;
				}else
					lblNumID.setForeground(Color.BLACK);
				
				
				if(dateChooser.getDate()==null) {
					lblFechaAlta.setForeground(Color.RED);
					datoIncorrecto = true;
				}else
					lblFechaAlta.setForeground(Color.BLACK);
				
				
				
				if(datoIncorrecto) {
					JOptionPane.showMessageDialog(null, "No pueden estar vacios los campos marcados en rojo.");
				}else {
					
					try {
						SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
						String fechaAlta = dformat.format(dateChooser.getDate());
						
						int numR = Integer.parseInt(textNumRegistro.getText());
						Medico m = new Medico(numR, nomComplet, numID, fechaAlta);
						
						int t = Datos.getInstancia().obtenerMedicos().size();
						Datos.getInstancia().insertarMedico(m);
						
						Registrar.getInstancia().registrarMedico(t, Datos.getInstancia().obtenerMedicos());
						 JOptionPane.showMessageDialog(null, "Datos registrado con suceso");
					}catch (Exception exception) {
						// TODO: handle exception
						System.out.println("El numero de registro no puede tener letras");
					}	
				}
					
				
							
			}
		  
		});
		btnRegistrar.setBounds(173, 237, 110, 28);
		contentPane.add(btnRegistrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.LIGHT_GRAY);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_close_black_24dp.png"));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(319, 236, 110, 28);
		contentPane.add(btnCancelar);
		
	}
	
}
