package main;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import java.awt.Color;

public class reportPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public reportPanel() {
		setBounds(0, 0, 803, 617);
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setOpaque(true);
		tabbedPane.setBackground(Color.WHITE);
		add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		tabbedPane.addTab("Obsolete Books", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Total", null, panel_1, null);
	}

}
