package Management;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResidentMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	RoomType type;
	@SuppressWarnings("rawtypes")
	JComboBox comboBox;
	@SuppressWarnings("rawtypes")
	JComboBox comboBox_1;
	int i;
	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResidentMenu frame = new ResidentMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	*//**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ResidentMenu( int index) {
		i=index;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1134, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblResidentMenu = new JLabel("Resident Menu");
		lblResidentMenu.setFont(new Font("Monospaced", Font.BOLD, 45));
		lblResidentMenu.setBounds(349, 10, 354, 93);
		contentPane.add(lblResidentMenu);
		
		JLabel lblNewLabel_2_1 = new JLabel("Upgrade room type");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2_1.setBounds(184, 193, 234, 32);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Request Room service");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2_1_1.setBounds(184, 246, 234, 32);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Update credentials");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2_1_1_1.setBounds(184, 303, 234, 32);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		 comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(RoomType.values()));
		comboBox.setSelectedIndex(ResidentCollection.residents.get(i).getRoom().getType().ordinal());
		comboBox.setBounds(428, 202, 123, 21);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Upgrade");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				type = (RoomType) comboBox.getSelectedItem();
				Room upgrade = ResidentCollection.residents.get(i).getRoom();
				upgrade.setType(type);
				ResidentCollection.residents.get(i).setRoom(upgrade);
				JOptionPane.showMessageDialog(null, "Room has been upgraded to "+type.name()+", The updated bil will be provided at check-out.");
			}
		});
		btnNewButton.setForeground(new Color(0, 128, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(561, 202, 123, 21);
		contentPane.add(btnNewButton);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_1.setModel(new DefaultComboBoxModel(RoomService.values()));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setBounds(428, 257, 123, 21);
		contentPane.add(comboBox_1);
		
		JButton btnOrder = new JButton("Order");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomService order = (RoomService) comboBox_1.getSelectedItem();
				JOptionPane.showMessageDialog(null, order.toString()+" has been ordered, $"+order.getnumVal()+" has been added to your bill.");
				ResidentCollection.residents.get(i).setBill(order.getnumVal());
			}
		});
		btnOrder.setForeground(new Color(0, 128, 0));
		btnOrder.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnOrder.setBounds(561, 257, 123, 21);
		contentPane.add(btnOrder);
		
		JButton btnUsername = new JButton("Username");
		btnUsername.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateUsername update = new UpdateUsername(i);
				update.setVisible(true);
			}
		});
		btnUsername.setForeground(new Color(0, 128, 0));
		btnUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUsername.setBounds(428, 312, 123, 21);
		contentPane.add(btnUsername);
		
		JButton btnPassword = new JButton("Password");
		btnPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdatePassword update = new UpdatePassword(i);
				update.setVisible(true);
			}
		});
		btnPassword.setForeground(new Color(0, 128, 0));
		btnPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPassword.setBounds(561, 312, 123, 21);
		contentPane.add(btnPassword);
		
		JButton btnLogout = new JButton("Log-out");
		btnLogout.setForeground(new Color(255, 0, 0));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage window = new MainPage();
				JOptionPane.showMessageDialog(null,"You have been logged-out, please reach out to a Staff member if you wish to check-out");
				dispose();
				window.setVisible(true);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnLogout.setBounds(467, 438, 139, 60);
		contentPane.add(btnLogout);

	}
}
