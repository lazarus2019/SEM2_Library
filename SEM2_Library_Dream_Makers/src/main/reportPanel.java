package main;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.toedter.calendar.JYearChooser;

import model.BooksModel;

import com.toedter.calendar.JMonthChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.JComboBox;

public class reportPanel extends JPanel {
	private static DefaultTableModel tableModel = null;
	private JMonthChooser monthChooser;
	private JYearChooser yearChooser;

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

		JLabel btnSendToMail = new JLabel("Send to mail");
		btnSendToMail.addMouseListener(new LabelButtonMouseAdapter(btnSendToMail));
		btnSendToMail.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSendToMail.setIcon(new ImageIcon(reportPanel.class.getResource("/data/Main/send.png")));
		btnSendToMail.setForeground(Color.WHITE);
		btnSendToMail.setBackground(new Color(30, 106, 210));
		btnSendToMail.setOpaque(true);
		btnSendToMail.setFont(new Font("Arial", Font.BOLD, 15));
		btnSendToMail.setHorizontalAlignment(SwingConstants.CENTER);
		btnSendToMail.setBounds(299, 11, 138, 37);
		panel.add(btnSendToMail);

		JLabel btnExport = new JLabel("Export");
		btnExport.addMouseListener(new LabelButtonMouseAdapter(btnExport));
		btnExport.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExport.setIcon(new ImageIcon(reportPanel.class.getResource("/data/Main/export.png")));
		btnExport.setForeground(Color.WHITE);
		btnExport.setBackground(new Color(30, 106, 210));
		btnExport.setOpaque(true);
		btnExport.setFont(new Font("Arial", Font.BOLD, 15));
		btnExport.setHorizontalAlignment(SwingConstants.CENTER);
		btnExport.setBounds(299, 80, 138, 37);
		panel.add(btnExport);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 244, 252));
		panel_2.setBounds(10, 11, 274, 127);
		panel.add(panel_2);
		panel_2.setLayout(null);

		yearChooser = new JYearChooser();
		yearChooser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		yearChooser.setBounds(168, 11, 96, 29);
		panel_2.add(yearChooser);

		monthChooser = new JMonthChooser();
		monthChooser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		monthChooser.setOpaque(false);
		monthChooser.setBackground(SystemColor.control);
		monthChooser.getComboBox().setBackground(SystemColor.control);
		monthChooser.setBounds(10, 11, 113, 29);
		panel_2.add(monthChooser);

		JLabel btnSearchObsolete = new JLabel("Search");
		btnSearchObsolete.addMouseListener(new LabelButtonMouseAdapter(btnSearchObsolete));
		btnSearchObsolete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					btnSearchObsolete_mouseClicked(arg0);
				} catch (Exception e) {
					showMessenger("Something was wrong! Please try again");
				}
			}
		});
		btnSearchObsolete.setIcon(new ImageIcon(reportPanel.class.getResource("/data/Main/search.png")));
		btnSearchObsolete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearchObsolete.setForeground(Color.WHITE);
		btnSearchObsolete.setBackground(new Color(30, 106, 210));
		btnSearchObsolete.setOpaque(true);
		btnSearchObsolete.setFont(new Font("Arial", Font.BOLD, 15));
		btnSearchObsolete.setHorizontalAlignment(SwingConstants.CENTER);
		btnSearchObsolete.setBounds(80, 60, 113, 35);
		panel_2.add(btnSearchObsolete);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 96, 96, 20);
		panel_2.add(comboBox);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(245, 244, 252));
		panel_3.setBounds(10, 139, 778, 439);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 45, 758, 383);
		panel_3.add(scrollPane);

		JLabel lblNewLabel = new JLabel("Obsolete Books");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(270, 0, 239, 34);
		panel_3.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Total", null, panel_1, null);

		loadData();
	}

	private void loadData() {
		tableModel = new DefaultTableModel() {
			// Can't edit cell
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		String[] columns = new String[] { "Member ID", "Book ID", "Invoice ID", "Borrow date", "Return date",
				"Term date", "Late fee" };
		tableModel.setColumnIdentifiers(columns);
	}

	// Searcg Obselete book
	private void btnSearchObsolete_mouseClicked(MouseEvent e) {
		int month = monthChooser.getMonth()+1;
		int year = yearChooser.getYear();
		List<String> test = BooksModel.getObseleteBill(month, year);
		System.out.println(test);
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
