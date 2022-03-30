package Management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Login extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Resident current=null;
	int ticket=0;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1134, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblResidentsLogin = new JLabel("Residents Log-in");
		lblResidentsLogin.setFont(new Font("Monospaced", Font.BOLD, 45));
		lblResidentsLogin.setBounds(323, 10, 456, 93);
		contentPane.add(lblResidentsLogin);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(324, 190, 191, 48);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(446, 205, 201, 29);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_1.setBounds(323, 274, 191, 48);
		contentPane.add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(446, 289, 201, 29);
		contentPane.add(passwordField);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage window = new MainPage();
				dispose();
				window.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton_1.setBounds(376, 417, 139, 60);
		contentPane.add(btnNewButton_1);
		
		JButton btnLogin = new JButton("Log-in");
		btnLogin.setForeground(new Color(0, 128, 0));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username =textField.getText();
				String password="";
				for(int i=0;i<passwordField.getPassword().length;i++) {
					password+=passwordField.getPassword()[i];
				}
				try {
					current=ResidentCollection.residentLogin(username, password);
					int index = ResidentCollection.residents.indexOf(ResidentCollection.findResident(current.getCredentials().getUsername()));
					dispose();
					ResidentMenu menu = new ResidentMenu(index);
					menu.setVisible(true);
					JOptionPane.showMessageDialog(null, "Welcome, "+current.getFname());
					} catch (CredentialsException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnLogin.setBounds(541, 417, 139, 60);
		contentPane.add(btnLogin);
	}

}
