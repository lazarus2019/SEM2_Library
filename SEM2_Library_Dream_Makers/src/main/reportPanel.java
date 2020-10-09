package main;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JMonthChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Cursor;

public class reportPanel extends JPanel {
	private JTable tableObsolete;

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
		panel.setBackground(Color.WHITE);
		panel.setBorder(null);
		tabbedPane.addTab("Obsolete Books", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(SystemColor.control);
		scrollPane.setBounds(10, 154, 778, 424);
		panel.add(scrollPane);
		
		tableObsolete = new JTable();
		scrollPane.setViewportView(tableObsolete);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.control);
		panel_2.setBounds(10, 11, 309, 132);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		yearChooser.setBounds(164, 11, 84, 29);
		panel_2.add(yearChooser);
		
		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		monthChooser.setOpaque(false);
		monthChooser.setBackground(SystemColor.control);
		monthChooser.getComboBox().setBackground(SystemColor.control);
		monthChooser.setBounds(27, 11, 113, 29);
		panel_2.add(monthChooser);
		
		JLabel btnSearchObsolete = new JLabel("Search");
		btnSearchObsolete.setIcon(new ImageIcon(reportPanel.class.getResource("/data/Main/search.png")));
		btnSearchObsolete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearchObsolete.setForeground(Color.WHITE);
		btnSearchObsolete.setBackground(new Color(30, 106, 210));
		btnSearchObsolete.setOpaque(true);
		btnSearchObsolete.setFont(new Font("Arial", Font.BOLD, 15));
		btnSearchObsolete.setHorizontalAlignment(SwingConstants.CENTER);
		btnSearchObsolete.setBounds(27, 86, 113, 35);
		panel_2.add(btnSearchObsolete);
		
		JLabel btnExport = new JLabel("Export");
		btnExport.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExport.setIcon(new ImageIcon(reportPanel.class.getResource("/data/Main/export.png")));
		btnExport.setForeground(Color.WHITE);
		btnExport.setBackground(new Color(30, 106, 210));
		btnExport.setOpaque(true);
		btnExport.setFont(new Font("Arial", Font.BOLD, 15));
		btnExport.setHorizontalAlignment(SwingConstants.CENTER);
		btnExport.setBounds(363, 11, 138, 37);
		panel.add(btnExport);
		
		JLabel btnSendToMail = new JLabel("Send to mail");
		btnSendToMail.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSendToMail.setIcon(new ImageIcon(reportPanel.class.getResource("/data/Main/send.png")));
		btnSendToMail.setForeground(Color.WHITE);
		btnSendToMail.setBackground(new Color(30, 106, 210));
		btnSendToMail.setOpaque(true);
		btnSendToMail.setFont(new Font("Arial", Font.BOLD, 15));
		btnSendToMail.setHorizontalAlignment(SwingConstants.CENTER);
		btnSendToMail.setBounds(562, 11, 138, 37);
		panel.add(btnSendToMail);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Total", null, panel_1, null);
		
		loadData();
	}
	
	private void loadData() {
		DefaultTableModel tableModel = new DefaultTableModel() {
			// Can't edit cell 
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}			
		};
		String[] columns = new String[] {"Member ID", "Book ID", "Invoice ID", "Borrow date", "Return date", "Term date", "Late fee"};
		tableModel.setColumnIdentifiers(columns);
		tableObsolete.setModel(tableModel);
		// Set can't change columns size
		tableObsolete.getTableHeader().setResizingAllowed(false);
		// Set can't change columns position
		tableObsolete.getTableHeader().setReorderingAllowed(false);
	}
	
	// ======= Reusability Function=========
	
	// Show error message
	private void showMessenger(String mess) {
		JOptionPane.showMessageDialog(null, mess);
	}
	
	// MouseAdapter for button
	private class LabelButtonMouseAdapter extends MouseAdapter {
		JLabel label;

		public LabelButtonMouseAdapter(JLabel label) {
			this.label = label;
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			label.setBackground(new Color(30, 106, 210));
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			label.setBackground(new Color(34, 121, 242));
		}
	}
}
