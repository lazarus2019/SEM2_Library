package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
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
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.sun.javafx.tk.Toolkit.Task;

import entities.Books;
import entities.Borrow_bill;
import entities.Member;
import entities.StatisticalBook;
import javafx.scene.control.Tab;
import model.BooksModel;
import model.MemberModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.RowFilter.Entry;

import java.awt.Font;
import java.awt.Cursor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import java.awt.event.ActionListener;

public class ReportDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	public static String[] columns = null;

	public static List<Borrow_bill> bills = null;
	public static List<Member> newMembers = null;
	public static List<StatisticalBook> allBooks = null;
	public static String option = null;
	public static String titlePanel = null;

	private int xPosition, yPosition, mouseX, mouseY;
	private static SimpleDateFormat sdfm = new SimpleDateFormat("dd/MM/yyyy");
	private static DefaultTableModel tableModel = new DefaultTableModel(null, columns) {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}

		@Override
		public Class<?> getColumnClass(int column) {
			return (column == 0) ? Integer.class : Object.class;
		}
	};
	private final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
	private JLabel title;
	private JTextField numPage;
	private JLabel maxIndex;
	private JButton preBtn;
	private JButton firstBtn;
	private JButton nextBtn;

	private final int itemsPerPage = 15;
	private int maxPageIndex;
	private int currentPageIndex = 1;
	private JButton lastBtn;

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
		setBounds(100, 100, 510, 310);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 510, 33);
		panel.setBackground(new Color(0, 102, 204));
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
		btnClose.setForeground(Color.WHITE);
		btnClose.setOpaque(true);
		btnClose.setBackground(new Color(0, 102, 204));
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
		scrollPane.setBounds(10, 76, 490, 221);
		contentPanel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		firstBtn = new JButton("|<");
		firstBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					firstBtn_actionPerformed(arg0);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		firstBtn.setBackground(new Color(30, 106, 210));
		firstBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		firstBtn.setForeground(Color.WHITE);
		firstBtn.setBounds(10, 42, 89, 23);
		contentPanel.add(firstBtn);

		preBtn = new JButton("<");
		preBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					preBtn_actionPerformed(e);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		preBtn.setBackground(new Color(30, 106, 210));
		preBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		preBtn.setForeground(Color.WHITE);
		preBtn.setBounds(109, 42, 89, 23);
		contentPanel.add(preBtn);

		nextBtn = new JButton(">");
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					nextBtn_actionPerformed(e);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		nextBtn.setBackground(new Color(30, 106, 210));
		nextBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		nextBtn.setForeground(Color.WHITE);
		nextBtn.setBounds(312, 44, 89, 23);
		contentPanel.add(nextBtn);

		lastBtn = new JButton(">|");
		lastBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					lastBtn_actionPerformed(e);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		lastBtn.setBackground(new Color(30, 106, 210));
		lastBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		lastBtn.setForeground(Color.WHITE);
		lastBtn.setBounds(411, 44, 89, 23);
		contentPanel.add(lastBtn);

		numPage = new JTextField();
		numPage.setBounds(203, 44, 27, 20);
		contentPanel.add(numPage);
		numPage.setColumns(10);

		maxIndex = new JLabel("");
		maxIndex.setBounds(240, 44, 57, 20);
		contentPanel.add(maxIndex);

		loadData();
	}

	private void loadData() {
		tableModel.getDataVector().removeAllElements();
		tableModel.fireTableDataChanged();
		table.setFillsViewportHeight(true);
		table.setRowSorter(sorter);
		title.setText(titlePanel);
		Date created;
		String status;
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
				created = MemberModel.getStartDateCard(member.getMember_ID());
				tableModel.addRow(new Object[] { tableModel.getRowCount() + 1, member.getMember_ID(), member.getName(),
						member.getCard_number(), sdfm.format(created) });
			}
			break;
		case "book":
			for (StatisticalBook book : allBooks) {
				status = book.getStatus() == 1 ? "Retured" : (book.getStatus() == 2 ? "Not return" : "Lost") ;
				tableModel.addRow(new Object[] { tableModel.getRowCount() + 1, book.getBill_ID(), book.getMember_ID(),
						book.getTitle(), status });
			}
			break;
		default:
			break;
		}

		table.setModel(tableModel);
		int rowCount = tableModel.getRowCount();
		int v = rowCount % itemsPerPage == 0 ? 0 : 1;
		maxPageIndex = rowCount / itemsPerPage + v;
		initFilterAndButton();
		maxIndex.setText(String.format("/ %d", maxPageIndex));
		// Goto index when input number of page
		KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
		numPage.getInputMap(JComponent.WHEN_FOCUSED).put(enter, "Enter");
		numPage.getActionMap().put("Enter", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int v = Integer.parseInt(numPage.getText());
					if (v > 0 && v <= maxPageIndex) {
						currentPageIndex = v;
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				initFilterAndButton();
			}
		});
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

	// Go to first page
	private void firstBtn_actionPerformed(ActionEvent e) {
		currentPageIndex = 1;
		initFilterAndButton();
	}

	// Go to previous page
	private void preBtn_actionPerformed(ActionEvent e) {
		currentPageIndex -= 1;
		initFilterAndButton();
	}

	// Go to next page
	private void nextBtn_actionPerformed(ActionEvent e) {
		currentPageIndex += 1;
		initFilterAndButton();
	}

	// Go to last page
	private void lastBtn_actionPerformed(ActionEvent e) {
		currentPageIndex = maxPageIndex;
		initFilterAndButton();
	}

	// Change value of table
	private void initFilterAndButton() {
		sorter.setRowFilter(new RowFilter<TableModel, Integer>() {
			@Override
			public boolean include(Entry<? extends TableModel, ? extends Integer> entry) {
				int ti = currentPageIndex - 1;
				int ei = entry.getIdentifier();
				return ti * itemsPerPage <= ei && ei < ti * itemsPerPage + itemsPerPage;
			}
		});
		firstBtn.setEnabled(currentPageIndex > 1);
		preBtn.setEnabled(currentPageIndex > 1);
		nextBtn.setEnabled(currentPageIndex < maxPageIndex);
		lastBtn.setEnabled(currentPageIndex < maxPageIndex);
		numPage.setText(Integer.toString(currentPageIndex));
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
			label.setBackground(new Color(0, 102, 204));
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
