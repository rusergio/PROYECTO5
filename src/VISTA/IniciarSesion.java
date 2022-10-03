package VISTA;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import AUXILIAR.Seguridad;

import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
//import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JSeparator;
//import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IniciarSesion extends JFrame {

	/**
	 * Rui Sergio Mané
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField passwordField;
	private JLabel lblMensajenError;
	Seguridad seguro = new Seguridad();
	private JButton btnEntrar;
	private JButton btnCancelar;
	private JLabel lblImage;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IniciarSesion frame = new IniciarSesion();
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
	public IniciarSesion() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_settings_accessibility_black_24dp.png"));
		setTitle("Iniciar Sesi\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 399, 432);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Nirmala UI", Font.BOLD, 16));
		lblNewLabel.setBounds(49, 168, 74, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setFont(new Font("Nirmala UI", Font.BOLD, 16));
		lblNewLabel_1.setBounds(49, 256, 130, 14);
		contentPane.add(lblNewLabel_1);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEntrar.setBackground(Color.LIGHT_GRAY);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String usuario = textUsuario.getText();
				@SuppressWarnings("deprecation")
				String contra = passwordField.getText();
				try {
				if(seguro.comprobar(usuario, contra)) {
					ConsultorioMedico cm = new ConsultorioMedico();
					IniciarSesion.this.dispose();
					
					cm.setVisible(true);
				}else {
					textUsuario.setText("");
					passwordField.setText("");
					lblMensajenError.setVisible(true);
				}
				}catch (Exception exception) {
					System.out.println("Error de concepto.");
				}
				
			}
		});
		btnEntrar.setBounds(92, 354, 98, 28);
		contentPane.add(btnEntrar);
		
		btnCancelar = new JButton("Cancelar\r\n");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBackground(Color.LIGHT_GRAY);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(216, 354, 110, 28);
		contentPane.add(btnCancelar);
		
		lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Pictures\\ICONES\\Usuario\\account_avatar_face_man_people_profile_user_icon_123197.png"));
		lblImage.setBounds(127, 25, 134, 128);
		contentPane.add(lblImage);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(SystemColor.windowBorder);
		separator.setBounds(49, 299, 298, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(160, 160, 160));
		separator_1.setBackground(SystemColor.windowBorder);
		separator_1.setBounds(49, 215, 298, 2);
		contentPane.add(separator_1);
		
		textUsuario = new JTextField();
		textUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textUsuario.setText("");
				
			}
		});
		textUsuario.setText("Ingrese su nombre de usuario");
		textUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textUsuario.setForeground(SystemColor.windowBorder);
		textUsuario.setBackground(SystemColor.inactiveCaption);
		textUsuario.setBounds(49, 194, 298, 20);
		textUsuario.setBorder(null);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				passwordField.setText("");
			}
		});
		passwordField.setToolTipText("");
		passwordField.setText("***********************");
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setForeground(SystemColor.windowBorder);
		passwordField.setBackground(SystemColor.inactiveCaption);
		passwordField.setBounds(49, 278, 298, 20);
		passwordField.setBorder(null);
		contentPane.add(passwordField);
		
		lblMensajenError = new JLabel("Usuario o contrase\u00F1a incorrecto!");
		lblMensajenError.setForeground(new Color(139, 0, 0));
		lblMensajenError.setBackground(Color.WHITE);
		lblMensajenError.setVisible(false);
		lblMensajenError.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMensajenError.setBounds(112, 320, 189, 14);
		contentPane.add(lblMensajenError);
	}
}
