package Management;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

public class UpdatePassword extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	int i;


	public UpdatePassword(int index) {
		i=index;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("New Username");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2_1_1_1.setBounds(10, 106, 234, 32);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(165, 112, 201, 32);
		contentPane.add(passwordField);
		
		JButton btnUodate = new JButton("Update");
		btnUodate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password="";
				for(int i=0;i<passwordField.getPassword().length;i++) {
					password+=passwordField.getPassword()[i];
				}
				ResidentCollection.residents.get(i).getCredentials().setPassword(password);
				JOptionPane.showMessageDialog(null, "Password successfully updated.");
				dispose();
				}
		});
		btnUodate.setForeground(new Color(0, 128, 0));
		btnUodate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUodate.setBounds(134, 202, 155, 32);
		contentPane.add(btnUodate);
	}

}
