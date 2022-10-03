package VISTA;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
//import javax.swing.JTextPane;
import javax.swing.JSpinner;
//import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class HojaDeCarga extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNomComp;
	private JTextField textDiagnostic;
	private JTextField textDireccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HojaDeCarga frame = new HojaDeCarga();
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
	public HojaDeCarga() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_article_black_24dp.png"));
		setResizable(false);
		setTitle("Hoja de cargas del dia ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 545, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre Completo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(27, 56, 127, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Edad");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(106, 100, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Direcci\u00F3n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(80, 180, 74, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Diagnostico");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(65, 142, 89, 14);
		contentPane.add(lblNewLabel_3);
		
		textNomComp = new JTextField();
		textNomComp.setEnabled(false);
		textNomComp.setBounds(153, 54, 294, 20);
		contentPane.add(textNomComp);
		textNomComp.setColumns(10);
		
		textDiagnostic = new JTextField();
		textDiagnostic.setBounds(153, 140, 342, 20);
		contentPane.add(textDiagnostic);
		textDiagnostic.setColumns(10);
		
		textDireccion = new JTextField();
		textDireccion.setBounds(153, 178, 342, 20);
		contentPane.add(textDireccion);
		textDireccion.setColumns(10);
		
		JSpinner spinnerEdad = new JSpinner();
		spinnerEdad.setEnabled(false);
		spinnerEdad.setBounds(153, 97, 56, 20);
		contentPane.add(spinnerEdad);
		
		JLabel lblDia = new JLabel("Fecha");
		lblDia.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDia.setBounds(100, 218, 45, 14);
		contentPane.add(lblDia);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(153, 215, 114, 20);
		contentPane.add(dateChooser);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_disabled_by_default_black_24dp.png"));
		btnSalir.setBackground(Color.LIGHT_GRAY);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(319, 268, 104, 28);
		contentPane.add(btnSalir);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setIcon(new ImageIcon("C:\\Users\\Rui Sergio Man\u00E9\\Downloads\\Icon\\icon\\outline_save_black_24dp.png"));
		btnRegistrar.setBackground(Color.LIGHT_GRAY);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRegistrar.setBounds(153, 268, 134, 28);
		contentPane.add(btnRegistrar);
	}
}
