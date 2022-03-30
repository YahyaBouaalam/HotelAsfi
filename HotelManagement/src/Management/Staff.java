package Management;

import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class Staff extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	DefaultTableModel tableModel;
	@SuppressWarnings("rawtypes")
	JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Staff frame = new Staff();
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
	public Staff() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1134, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("Get Hotel's archive");
		lblNewLabel_2_1.setBounds(28, 193, 234, 32);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		contentPane.add(lblNewLabel_2_1);
		
		JButton btnArchive = new JButton("Download");
		btnArchive.setForeground(new Color(0, 128, 0));
		btnArchive.setBounds(240, 192, 165, 32);
		btnArchive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CSV.downloadArchive();
				JOptionPane.showMessageDialog(null, " Archive has been downloaded to Archive.csv\nPath: HotelManagement\\Archive.csv");
				try {
					Desktop.getDesktop().open(new File("Archive.csv"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnArchive.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(btnArchive);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(590, 146, 451, 317);
		contentPane.add(scrollPane);
		
		String col[]= {"Name", "Room", "Username","Password"};
		 tableModel = new DefaultTableModel(col, 0);
		table = new JTable(tableModel);
		table.setEnabled(false);
		for(int x= table.getRowCount();x<ResidentCollection.residents.size();x++) {
			Resident temp=ResidentCollection.residents.get(x);
			String toAdd[]= {temp.getFname()+" "+temp.getLname(),temp.getRoom().getNumber(),temp.getCredentials().getUsername(),temp.getCredentials().getPassword()};
			tableModel.addRow(toAdd);
		}
		
		scrollPane.setViewportView(table);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setRowHeaderView(scrollBar);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Residents' List");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2_1_1.setBounds(653, 115, 156, 32);
		contentPane.add(lblNewLabel_2_1_1);
		
		JButton btnNewButton = new JButton("Refresh");
		btnNewButton.setForeground(new Color(0, 128, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableModel.setRowCount(0);
				for(int x= table.getRowCount();x<ResidentCollection.residents.size();x++) {
					Resident temp=ResidentCollection.residents.get(x);
					String toAdd[]= {temp.getFname()+" "+temp.getLname(),temp.getRoom().getNumber(),temp.getCredentials().getUsername(),temp.getCredentials().getPassword()};
					tableModel.addRow(toAdd);
				}
			}
		});
		btnNewButton.setBounds(803, 126, 89, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblStaffMenu = new JLabel("Staff Menu");
		lblStaffMenu.setFont(new Font("Monospaced", Font.BOLD, 45));
		lblStaffMenu.setBounds(433, 10, 272, 93);
		contentPane.add(lblStaffMenu);
		
		JButton btnLogout = new JButton("Log-out");
		btnLogout.setForeground(new Color(255, 0, 0));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage window = new MainPage();
				dispose();
				window.setVisible(true);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnLogout.setBounds(510, 488, 139, 60);
		contentPane.add(btnLogout);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Check-out by username");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2_1_2.setBounds(10, 268, 252, 32);
		contentPane.add(lblNewLabel_2_1_2);
		
		String u="";
		Iterator<Resident> i = ResidentCollection.residents.listIterator();
		while(i.hasNext()) {
			u+=i.next().getCredentials().getUsername()+" ";
		}
		String[] usernames = u.split(" ");
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(usernames));
		comboBox.setBounds(246, 268, 139, 32);
		contentPane.add(comboBox);
		
		JButton btnCheckout = new JButton("Check-out");
		btnCheckout.setForeground(new Color(0, 128, 0));
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, ResidentCollection.checkout((String) comboBox.getSelectedItem()));
				String u="";
				Iterator<Resident> i = ResidentCollection.residents.listIterator();
				while(i.hasNext()) {
					u+=i.next().getCredentials().getUsername()+" ";
				}
				String[] usernames = u.split(" ");
				comboBox.setModel(new DefaultComboBoxModel(usernames));
			}
		});
		btnCheckout.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnCheckout.setBounds(395, 268, 165, 32);
		contentPane.add(btnCheckout);
		
		
		
	}
}
