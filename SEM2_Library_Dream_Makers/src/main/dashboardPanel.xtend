package main

import javax.swing.JPanel
import java.awt.BorderLayout
import javax.swing.JTabbedPane
import javax.swing.JButton

class dashboardPanel extends JPanel {
	/** 
	 * Create the panel.
	 */
	new() {
		setBounds(0, 0, 803, 617)
		setLayout(new BorderLayout(0, 0))
		var JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP)
		add(tabbedPane, BorderLayout.CENTER)
		var JPanel panel = new JPanel()
		tabbedPane.addTab("New tab", null, panel, null)
		panel.setLayout(null)
		var JPanel panel_1 = new JPanel()
		tabbedPane.addTab("New tab", null, panel_1, null)
	}
}
