package Management;

import java.awt.EventQueue;

public class Main {

	static int i=1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
					window.setVisible(true);


				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
