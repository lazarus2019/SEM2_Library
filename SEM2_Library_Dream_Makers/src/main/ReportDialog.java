package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import com.sun.javafx.tk.Toolkit.Task;

import entities.Borrow_bill;
import entities.Member;
import javafx.scene.control.Tab;
import model.LibCardModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ReportDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	public static String[] columns = null;

	public static List<Borrow_bill> bills = null;
	public static List<Member> newMembers = null;
	public static String option = null;
	public static String titlePanel = null;

	private int xPosition, yPosition, mouseX, mouseY;
	private static SimpleDateFormat sdfm = new SimpleDateFormat("dd/MM/yyyy");
	private JLabel title;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReportDialog dialog = new ReportDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReportDialog() {
		setUndecorated(true);
		setModal(true);
		setBounds(100, 100, 510, 343);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 510, 33);
		panel.setBackground(new Color(51, 51, 51));
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				try {
					panel_2_mouseDragged(arg0);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Something was wrong! Please try again");
				}
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				try {
					panel_2_mouseMoved(e);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Something was wrong! Please try again");
				}
			}
		});
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel btnClose = new JLabel("X");
		btnClose.addMouseListener(new LabelButtonMouseAdapter(btnClose));
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					btnClose_mouseClicked(arg0);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Something was wrong! Please try again");
				}
			}
		});
		btnClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClose.setForeground(Color.RED);
		btnClose.setOpaque(true);
		btnClose.setBackground(new Color(51, 51, 51));
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClose.setHorizontalAlignment(SwingConstants.CENTER);
		btnClose.setBounds(477, 0, 33, 33);
		panel.add(btnClose);

		title = new JLabel("Title");
		title.setForeground(Color.WHITE);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Tahoma", Font.BOLD, 15));
		title.setBounds(124, 0, 261, 33);
		panel.add(title);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.white);
		scrollPane.setBounds(10, 44, 490, 288);
		contentPanel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		loadData();
	}

	private void loadData() {
		title.setText(titlePanel);
		Date created;
		DefaultTableModel tableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableModel.setColumnIdentifiers(columns);

		switch (option) {
		case "bill":
			for (Borrow_bill bill : bills) {
				tableModel.addRow(new Object[] { tableModel.getRowCount() + 1, bill.getBorrow_ID(), bill.getMember_ID(),
						bill.isStatus() ? "Returned" : "Unreturned", sdfm.format(bill.getBorrow_date()) });
			}
			break;
		case "member":
			for (Member member : newMembers) {
				created = LibCardModel.getCreatedByIDCard(member.getCard_number());
				tableModel.addRow(new Object[] { tableModel.getRowCount() + 1, member.getMember_ID(), member.getName(),
						member.getCard_number(), sdfm.format(created) });
			}
		default:
			break;
		}

		table.setModel(tableModel);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);

		// Set Header color
		JTableHeader tableFindBookHeader = table.getTableHeader();
		tableFindBookHeader.setBackground(new Color(223, 233, 242));
		tableFindBookHeader.setForeground(Color.BLACK);
		
		TableColumnModel columnModelFM = table.getColumnModel();
		// Set columns width
		columnModelFM.getColumn(0).setPreferredWidth(15);
	}

	private void btnClose_mouseClicked(MouseEvent e) {
		this.setVisible(false);
		this.dispose();
	}

	// MouseAdapter for button
	private class LabelButtonMouseAdapter extends MouseAdapter {
		JLabel label;

		public LabelButtonMouseAdapter(JLabel label) {
			this.label = label;
		}

		@Override
		public void mouseExited(MouseEvent e) {
			label.setBackground(new Color(51, 51, 51));
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			label.setBackground(new Color(87, 87, 87));
		}
	}

	// Drag & move window
	private void panel_2_mouseDragged(MouseEvent e) {
		xPosition = e.getXOnScreen();
		yPosition = e.getYOnScreen();
		this.setLocation(xPosition - mouseX, yPosition - mouseY);
	}

	private void panel_2_mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}
}
