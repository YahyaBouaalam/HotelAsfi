package Management;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;

public class Checkin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox1;
	Resident temp;
	Person credentials;
	Resident newResident;
	Room newRoom;
	String username, password, firstName, lastName, roomNumber;
	RoomType type;

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Checkin frame = new Checkin();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Checkin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 949, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCheckin = new JLabel("Check-in");
		lblCheckin.setFont(new Font("Monospaced", Font.BOLD, 45));
		lblCheckin.setBounds(317, 10, 225, 93);
		contentPane.add(lblCheckin);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(241, 272, 191, 48);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_1.setBounds(241, 315, 191, 48);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Last Name");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_3.setBounds(42, 193, 191, 48);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Room Number");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_4.setBounds(543, 135, 191, 48);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("First Name");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_5.setBounds(42, 135, 191, 48);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Room Type");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_6.setBounds(543, 193, 191, 48);
		contentPane.add(lblNewLabel_1_6);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					username = textField.getText();

			}
		});
		textField.setBounds(388, 287, 201, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=0;
				password="";
				while(i<passwordField.getPassword().length) {
					password+=passwordField.getPassword()[i];
					i++;
				}
			}
		});
		passwordField.setBounds(388, 330, 201, 29);
		contentPane.add(passwordField);
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstName = textField_1.getText();
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(193, 150, 201, 29);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lastName = textField_2.getText();
			}
		});
		textField_2.setColumns(10);
		textField_2.setBounds(193, 208, 201, 29);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				roomNumber = textField_3.getText();
			}
		});
		textField_3.setColumns(10);
		textField_3.setBounds(700, 150, 201, 29);
		contentPane.add(textField_3);
		
		comboBox1 = new JComboBox();
		comboBox1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox1.setToolTipText("");
		comboBox1.setModel(new DefaultComboBoxModel(RoomType.values()));
		comboBox1.setSelectedIndex(0);
		comboBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				type = (RoomType) comboBox1.getSelectedItem();
			}
		});
		comboBox1.setBounds(700, 205, 201, 29);
		contentPane.add(comboBox1);
		
		JButton btnNewButton = new JButton("Check-in");
		btnNewButton.setForeground(new Color(0, 128, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(485, 373, 149, 60);
		contentPane.add(btnNewButton);
		
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
		btnNewButton_1.setBounds(317, 373, 149, 60);
		contentPane.add(btnNewButton_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				type = (RoomType) comboBox1.getSelectedItem();
				username = textField.getText();
				int i=0;
				password="";
				while(i<passwordField.getPassword().length) {
					password+=passwordField.getPassword()[i];
					i++;
				}
				firstName = textField_1.getText();
				lastName = textField_2.getText();
				roomNumber = textField_3.getText();	
				try {
					ResidentCollection.checkin(firstName, lastName, roomNumber, type, username, password);
					MainPage window = new MainPage();
					dispose();
					window.setVisible(true);
					JOptionPane.showMessageDialog(null, " Check-in Succesful, Please log-in. ");
				} catch (FieldTakenException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (FieldIsNullException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		
	}
}
