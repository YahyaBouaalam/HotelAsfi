package Management;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateUsername extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private int i;

	public UpdateUsername(int index) {
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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(165, 112, 201, 32);
		contentPane.add(textField);
		
		JButton btnUodate = new JButton("Update");
		btnUodate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResidentCollection.residents.get(i).getCredentials().setUsername(textField.getText());
				JOptionPane.showMessageDialog(null, "Username successfully updated.");
				dispose();
				}
		});
		btnUodate.setForeground(new Color(0, 128, 0));
		btnUodate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUodate.setBounds(134, 202, 155, 32);
		contentPane.add(btnUodate);
	}
}
