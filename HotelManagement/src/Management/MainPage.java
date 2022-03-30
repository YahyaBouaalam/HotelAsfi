package Management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import java.awt.Color;

public class MainPage extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int mp=1;
	Checkin checkin;
	Login login;
	Staff staff;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private String pin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1134, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().add(new JLabel(new ImageIcon("hotel_asfi.jpg")));
		JLabel lblNewLabel_1 = new JLabel("For New Residents");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(132, 169, 186, 48);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Welcome to Hotel Asfi");
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 45));
		lblNewLabel.setBounds(254, 24, 579, 93);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Check-in");
		btnNewButton.setForeground(new Color(0, 128, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkin = new Checkin();
				dispose();
				checkin.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(358, 162, 156, 60);
		contentPane.add(btnNewButton);
		
		JButton btnLogin = new JButton("Log-in");
		btnLogin.setForeground(new Color(0, 128, 0));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login = new Login();
				dispose();
				login.setVisible(true);
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnLogin.setBounds(358, 250, 156, 60);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel_2 = new JLabel("For Current Residents");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(132, 265, 216, 32);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(132, 342, 387, 159);
		contentPane.add(panel);
		
		JLabel lblNewLabel_3 = new JLabel("PIN Code");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(24, 65, 76, 22);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("For Staff");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2_1_1.setBounds(130, 11, 86, 27);
		panel.add(lblNewLabel_2_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(112, 60, 76, 39);
		panel.add(passwordField);
		
		JButton btnLogin_1 = new JButton("Log-in");
		btnLogin_1.setForeground(new Color(0, 128, 0));
		btnLogin_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=0;
				pin="";
				while(i<passwordField.getPassword().length) {
					pin+=passwordField.getPassword()[i];
					i++;
			}
				if(pin.equals("1921")) {

					staff = new Staff();
					dispose();
					staff.setVisible(true);
				}
			}
		});
		btnLogin_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnLogin_1.setBounds(221, 49, 139, 60);
		panel.add(btnLogin_1);
		Image img= new ImageIcon(this.getClass().getResource("/hotelasfi.jpg")).getImage();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 128));
		panel_1.setBounds(569, 116, 541, 385);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(10, 10, 522, 368);
		panel_1.add(lblNewLabel_4);
		lblNewLabel_4.setBackground(new Color(0, 0, 0));
		lblNewLabel_4.setIcon(new ImageIcon(img));
	}

}
