package main;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class dashboardEmployeePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public dashboardEmployeePanel() {
		setBounds(0, 0, 803, 617);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 803, 606);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(dashboardEmployeePanel.class.getResource("/data/Main/background.png")));
		lblNewLabel.setBounds(0, 0, 803, 606);
		panel.add(lblNewLabel);
	}
}
