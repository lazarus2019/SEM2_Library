package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.RowFilter.Entry;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import entities.Borrow_bill;
import entities.Employee;
import entities.FamousBook;
import entities.FriendlyMember;
import entities.ObseleteBook;
import entities.StatisticalBook;
import entities.Member;
import model.BooksModel;
import model.Borrow_billModel;
import model.MemberModel;
import model.SendMail;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;

// Import apache poi excel

public class reportPanel extends JPanel {
	private JMonthChooser monthChooser;
	private JYearChooser yearChooser;
	private JTable tableFamousBook;
	private JTable tableFamousMember;
	private JTable tableObsolete;
	private static BooksModel booksModel = new BooksModel();
	private static SimpleDateFormat spdf = new SimpleDateFormat("MM/dd/yyyy");
	private JComboBox statusBox;
	private JMonthChooser monthChooser_1;
	private JDayChooser dayChooser;
	private JYearChooser yearChooser_1;
	private JCheckBox chbxDay;
	private JCheckBox chbxMonth;
	private static DefaultTableModel tableModel = null;
	private static DefaultTableModel fBookModel = null;
	private static DefaultTableModel fMemberModel = null;

	// Next, previous pageIndex
	private static TableRowSorter<TableModel> sorter = null;
	private final int itemsPerPage = 21;
	private int maxPageIndex;
	private int currentPageIndex = 1;

	private static String[] columns = null;
	private static List<ObseleteBook> obbs = null;
	private static List<FamousBook> boks = null;
	private static List<FriendlyMember> members = null;
	private static List<Member> newMembers = null;
	private static List<Borrow_bill> bills = null;
	private static List<StatisticalBook> allBooks = null;

	// Declare Direct mapping
	public static Employee employeeMain = null;
	private JLabel billBookAm;
	private JLabel BookAm;
	private JLabel newMemberAm;
	private JLabel tableTitle;
	private JCheckBox chbxMonthM;
	private JButton preBtn;
	private JButton firstBtn;
	private JButton nextBtn;
	private JButton lastBtn;
	private JTextField numPage;
	private JLabel maxIndex;

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
		btnSendToMail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					btnSendToMail_mouseClicked(arg0);
				} catch (Exception e) {
					showMessenger("Something was wrong! Please try again");
				}
			}
		});
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
		btnExport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					btnExport_mouseClicked(e);
				} catch (Exception e2) {
					showMessenger("Something was wrong! Please try again");
				}
			}
		});
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
		panel_2.setBounds(10, 11, 274, 107);
		panel.add(panel_2);
		panel_2.setLayout(null);

		yearChooser = new JYearChooser();
		yearChooser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		yearChooser.setBounds(151, 11, 113, 29);
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
		btnSearchObsolete.setIcon(new ImageIcon(reportPanel.class.getResource("/data/icon/Search.png")));
		btnSearchObsolete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearchObsolete.setForeground(Color.WHITE);
		btnSearchObsolete.setBackground(new Color(30, 106, 210));
		btnSearchObsolete.setOpaque(true);
		btnSearchObsolete.setFont(new Font("Arial", Font.BOLD, 15));
		btnSearchObsolete.setHorizontalAlignment(SwingConstants.CENTER);
		btnSearchObsolete.setBounds(151, 61, 113, 35);
		panel_2.add(btnSearchObsolete);

		chbxMonthM = new JCheckBox("Month");
		chbxMonthM.setBackground(new Color(245, 244, 252));
		chbxMonthM.setBounds(10, 47, 97, 23);
		panel_2.add(chbxMonthM);

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Year");
		chckbxNewCheckBox_1.setEnabled(false);
		chckbxNewCheckBox_1.setSelected(true);
		chckbxNewCheckBox_1.setBackground(new Color(245, 244, 252));
		chckbxNewCheckBox_1.setBounds(10, 73, 97, 23);
		panel_2.add(chckbxNewCheckBox_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(245, 244, 252));
		panel_3.setBounds(10, 129, 778, 449);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBounds(10, 45, 758, 359);
		panel_3.add(scrollPane);

		tableObsolete = new JTable();
		scrollPane.setViewportView(tableObsolete);

		tableTitle = new JLabel("Obsolete Books");
		tableTitle.setHorizontalAlignment(SwingConstants.CENTER);
		tableTitle.setFont(new Font("Tahoma", Font.PLAIN, 26));
		tableTitle.setBounds(268, 5, 239, 34);
		panel_3.add(tableTitle);

		statusBox = new JComboBox();
		statusBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					statusBox_actionPerformed(arg0);
				} catch (Exception e) {
					showMessenger("Something was wrong! Please try again");
				}
			}
		});
		statusBox.setBounds(679, 11, 89, 25);
		panel_3.add(statusBox);

		firstBtn = new JButton("|<");
		firstBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					firstBtn_actionPerformed(e);
				} catch (Exception e2) {
					showMessenger("Something was wrong! Please try again");
				}
			}
		});
		firstBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		firstBtn.setBackground(new Color(30, 106, 210));
		firstBtn.setForeground(new Color(255, 255, 255));
		firstBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		firstBtn.setBounds(482, 415, 50, 25);
		panel_3.add(firstBtn);

		preBtn = new JButton("<");
		preBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					preBtn_actionPerformed(e);
				} catch (Exception e2) {
					showMessenger("Something was wrong! Please try again");
				}
			}
		});
		preBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		preBtn.setBackground(new Color(30, 106, 210));
		preBtn.setForeground(new Color(255, 255, 255));
		preBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		preBtn.setBounds(540, 415, 50, 25);
		panel_3.add(preBtn);

		lastBtn = new JButton(">|");
		lastBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					lastBtn_actionPerformed(e);
				} catch (Exception e2) {
					showMessenger("Something was wrong! Please try again");
				}
			}
		});
		lastBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lastBtn.setBackground(new Color(30, 106, 210));
		lastBtn.setForeground(new Color(255, 255, 255));
		lastBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		lastBtn.setBounds(721, 415, 50, 25);
		panel_3.add(lastBtn);

		nextBtn = new JButton(">");
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					nextBtn_actionPerformed(e);
				} catch (Exception e2) {
					showMessenger("Something was wrong! Please try again");
				}
			}
		});
		nextBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		nextBtn.setBackground(new Color(30, 106, 210));
		nextBtn.setForeground(new Color(255, 255, 255));
		nextBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		nextBtn.setBounds(663, 415, 50, 25);
		panel_3.add(nextBtn);

		maxIndex = new JLabel("");
		maxIndex.setFont(new Font("Tahoma", Font.BOLD, 11));
		maxIndex.setBounds(626, 415, 34, 25);
		panel_3.add(maxIndex);

		numPage = new JTextField();
		numPage.setBounds(596, 415, 27, 25);
		panel_3.add(numPage);
		numPage.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Total", null, panel_1, null);
		panel_1.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(245, 244, 252));
		panel_6.setBounds(10, 308, 447, 270);
		panel_1.add(panel_6);
		panel_6.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.getViewport().setBackground(Color.white);
		scrollPane_1.setBounds(10, 48, 427, 211);
		panel_6.add(scrollPane_1);

		tableFamousBook = new JTable();
		scrollPane_1.setViewportView(tableFamousBook);

		JLabel lblNewLabel_4 = new JLabel("Famous Books");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_4.setBounds(135, 10, 176, 32);
		panel_6.add(lblNewLabel_4);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(245, 244, 252));
		panel_7.setBounds(467, 308, 321, 270);
		panel_1.add(panel_7);
		panel_7.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.getViewport().setBackground(Color.white);
		scrollPane_2.setBounds(10, 49, 302, 210);
		panel_7.add(scrollPane_2);

		tableFamousMember = new JTable();
		scrollPane_2.setViewportView(tableFamousMember);

		JLabel lblNewLabel_5 = new JLabel("Friendly Members");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_5.setBounds(27, 10, 266, 34);
		panel_7.add(lblNewLabel_5);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(245, 244, 252));
		panel_4.setBounds(10, 11, 778, 286);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(10, 11, 444, 264);
		panel_4.add(panel_5);
		panel_5.setLayout(null);

		dayChooser = new JDayChooser();
		dayChooser.setBounds(10, 31, 291, 222);
		panel_5.add(dayChooser);

		monthChooser_1 = new JMonthChooser();
		monthChooser_1.setBounds(311, 101, 106, 32);
		panel_5.add(monthChooser_1);

		yearChooser_1 = new JYearChooser();
		yearChooser_1.setBounds(311, 31, 94, 32);
		panel_5.add(yearChooser_1);

		JLabel lblNewLabel_2 = new JLabel("Day");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 6, 66, 16);
		panel_5.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Year");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(311, 7, 66, 16);
		panel_5.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Month");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_1.setBounds(311, 74, 66, 16);
		panel_5.add(lblNewLabel_2_1_1);

		JLabel btnSearch = new JLabel("Search");
		btnSearch.setIcon(new ImageIcon(reportPanel.class.getResource("/data/icon/Search.png")));
		btnSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					btnSearch_mouseClicked(e);
				} catch (Exception e2) {
					showMessenger("Something was wrong! Please try again");
				}
			}
		});
		btnSearch.addMouseListener(new LabelButtonMouseAdapter(btnSearch));
		btnSearch.setOpaque(true);
		btnSearch.setHorizontalAlignment(SwingConstants.CENTER);
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Arial", Font.BOLD, 15));
		btnSearch.setBackground(new Color(30, 106, 210));
		btnSearch.setBounds(311, 218, 113, 35);
		panel_5.add(btnSearch);

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(311, 144, 123, 66);
		panel_5.add(panel_9);
		panel_9.setLayout(null);

		chbxDay = new JCheckBox("Day");
		chbxDay.setBackground(Color.WHITE);
		chbxDay.setBounds(0, 0, 97, 22);
		panel_9.add(chbxDay);

		chbxMonth = new JCheckBox("Month");
		chbxMonth.setBackground(Color.WHITE);
		chbxMonth.setBounds(0, 22, 97, 22);
		panel_9.add(chbxMonth);

		JCheckBox chbxYear = new JCheckBox("Year");
		chbxYear.setSelected(true);
		chbxYear.setEnabled(false);
		chbxYear.setBackground(Color.WHITE);
		chbxYear.setBounds(0, 44, 97, 22);
		panel_9.add(chbxYear);

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(245, 244, 252));
		panel_8.setBounds(464, 11, 304, 136);
		panel_4.add(panel_8);
		panel_8.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Bill book:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 46, 104, 20);
		panel_8.add(lblNewLabel_1);

		billBookAm = new JLabel("0");
		billBookAm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		billBookAm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					billBookAm_mouseClicked(arg0);
				} catch (Exception e) {
					showMessenger("Something was wrong! Please try again");
				}
			}
		});
		billBookAm.setHorizontalAlignment(SwingConstants.RIGHT);
		billBookAm.setFont(new Font("Tahoma", Font.BOLD, 14));
		billBookAm.setBounds(98, 46, 54, 20);
		panel_8.add(billBookAm);

		JLabel lblNewLabel_1_1 = new JLabel("New member:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 81, 104, 20);
		panel_8.add(lblNewLabel_1_1);

		newMemberAm = new JLabel("0");
		newMemberAm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					newMemberAm_mouseClicked(arg0);
				} catch (Exception e) {
					showMessenger("Something was wrong! Please try again");
				}
			}
		});
		newMemberAm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		newMemberAm.setHorizontalAlignment(SwingConstants.RIGHT);
		newMemberAm.setFont(new Font("Tahoma", Font.BOLD, 14));
		newMemberAm.setBounds(98, 81, 54, 20);
		panel_8.add(newMemberAm);

		JLabel lblNewLabel_1_2 = new JLabel("Books:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 11, 104, 20);
		panel_8.add(lblNewLabel_1_2);

		BookAm = new JLabel("0");
		BookAm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					BookAm_mouseClicked(arg0);
				} catch (Exception e) {
					showMessenger("Something was wrong! Please try again");
				}
			}
		});
		BookAm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BookAm.setHorizontalAlignment(SwingConstants.RIGHT);
		BookAm.setFont(new Font("Tahoma", Font.BOLD, 14));
		BookAm.setBounds(98, 11, 54, 20);
		panel_8.add(BookAm);

		loadData();
	}

	// Load data
	private void loadData() {
		loadTableBook();
		loadStatusBox();
		loadTableFamousBook();
		loadTableFriendlyMember();
	}

	// ======Obselete & Lost Book Manage
	// Load table
	private void loadTableBook() {
		tableModel = new DefaultTableModel() {
			// Can't edit cell
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		columns = new String[] { "No", "ID Card", "Employee", "Title", "Invoice ID", "Return date", "Day late" };
		tableModel.setColumnIdentifiers(columns);
		sorter = new TableRowSorter<TableModel>(tableModel);
		tableObsolete.setModel(tableModel);

		tableObsolete.getTableHeader().setReorderingAllowed(false);
		tableObsolete.getTableHeader().setResizingAllowed(false);
		TableColumnModel columnModelF = tableObsolete.getColumnModel();
		// Set columns width
		columnModelF.getColumn(0).setPreferredWidth(30);
		columnModelF.getColumn(1).setPreferredWidth(100);
		columnModelF.getColumn(2).setPreferredWidth(90);
		columnModelF.getColumn(3).setPreferredWidth(280);
		columnModelF.getColumn(4).setPreferredWidth(75);
		columnModelF.getColumn(5).setPreferredWidth(80);
		columnModelF.getColumn(6).setPreferredWidth(80);

		// Set Header color
		JTableHeader tableFindBookHeader = tableObsolete.getTableHeader();
		tableFindBookHeader.setBackground(new Color(223, 233, 242));
		tableFindBookHeader.setForeground(Color.BLACK);

		firstBtn.setEnabled(false);
		preBtn.setEnabled(false);
		nextBtn.setEnabled(false);
		lastBtn.setEnabled(false);
		numPage.setEditable(false);
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

	// Load Status Combobox
	private void loadStatusBox() {
		DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<String>();
		comboBoxModel.addElement("Obselete");
		comboBoxModel.addElement("Lost");
		statusBox.setModel(comboBoxModel);
	}

	private void loadTableFamousBook() {
		fBookModel = new DefaultTableModel() {
			// Can't edit cell
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		String[] fBook = new String[] { "No", "Title", "Amount" };
		fBookModel.setColumnIdentifiers(fBook);
		tableFamousBook.setModel(fBookModel);
		tableFamousBook.getTableHeader().setReorderingAllowed(false);
		tableFamousBook.getTableHeader().setResizingAllowed(false);
		TableColumnModel columnModelFB = tableFamousBook.getColumnModel();
		// Set columns width
		columnModelFB.getColumn(0).setPreferredWidth(50);
		columnModelFB.getColumn(1).setPreferredWidth(307);
		columnModelFB.getColumn(2).setPreferredWidth(70);

		// Set Header color
		JTableHeader tableFindBookHeader = tableFamousBook.getTableHeader();
		tableFindBookHeader.setBackground(new Color(223, 233, 242));
		tableFindBookHeader.setForeground(Color.BLACK);
	}

	private void loadTableFriendlyMember() {
		fMemberModel = new DefaultTableModel() {
			// Can't edit cell
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		String[] fMember = new String[] { "No", "Name", "Amount Book" };
		fMemberModel.setColumnIdentifiers(fMember);
		tableFamousMember.setModel(fMemberModel);
		tableFamousMember.getTableHeader().setReorderingAllowed(false);
		tableFamousMember.getTableHeader().setResizingAllowed(false);
		TableColumnModel columnModelFM = tableFamousMember.getColumnModel();
		// Set columns width
		columnModelFM.getColumn(0).setPreferredWidth(50);
		columnModelFM.getColumn(1).setPreferredWidth(152);
		columnModelFM.getColumn(2).setPreferredWidth(100);

		// Set Header color
		JTableHeader tableFindBookHeader = tableFamousMember.getTableHeader();
		tableFindBookHeader.setBackground(new Color(223, 233, 242));
		tableFindBookHeader.setForeground(Color.BLACK);
	}

	// Search Obselete book
	private void btnSearchObsolete_mouseClicked(MouseEvent e) {
		getObselectData();
	}

	private void statusBox_actionPerformed(ActionEvent e) {
		getObselectData();
	}

	// Get obselete data
	private void getObselectData() {
		int month = monthChooser.getMonth() + 1;
		int year = yearChooser.getYear();
		int status = statusBox.getSelectedIndex() == 0 ? 1 : 3;
		int op = 1;
		if (chbxMonthM.isSelected()) {
			op = 2;
		}
		if (status == 1) {
			tableTitle.setText("Obselete Books");
		}
		if (status == 3) {
			tableTitle.setText("Lost Books");
		}
		List<Borrow_bill> books = booksModel.getBills(month, year, op, status);
		if (books != null) {
			obbs = booksModel.getObseleteBook(books, status);
			tableObsolete.setFillsViewportHeight(true);
			tableObsolete.setRowSorter(sorter);
			tableModel.getDataVector().removeAllElements();
			tableModel.fireTableDataChanged();
			for (ObseleteBook obb : obbs) {
				tableModel.addRow(new Object[] { tableModel.getRowCount() + 1, obb.getCard_number(),
						obb.getEmployee_name(), obb.getTitle(), obb.getInvoice_ID(), spdf.format(obb.getReturn_date()),
						spdf.format(obb.getTerm_date()) });
			}
			tableObsolete.setModel(tableModel);
			int rowCount = tableModel.getRowCount();
			int v = rowCount % itemsPerPage == 0 ? 0 : 1;
			maxPageIndex = rowCount / itemsPerPage + v;
			initFilterAndButton();
			maxIndex.setText(String.format("/ %d", maxPageIndex));
			// Goto index when input number of page
			KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
			numPage.setEditable(true);
			numPage.setText("1");
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
		} else {
			showMessenger("Don't have any record");
		}
	}

	// Export to excel file
	private void btnExport_mouseClicked(MouseEvent e) {
		openDialogAndCheck();
	}

	// Send export file to mail
	private void btnSendToMail_mouseClicked(MouseEvent e) {
		sendExportToMail();
	}

	// Send export file to mail
	private void sendExportToMail() {
		if (tableObsolete.getModel().getRowCount() > 0) {
			JFileChooser exChooser = new JFileChooser();
			// Change box title
			exChooser.setDialogTitle("Export to excel file");
			// Only filter files with extension "xls", "xlsx", "xlsm"
			FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILE - xls, xlsx", "xls", "xlsx");
			exChooser.setFileFilter(fnef);
			int result = exChooser.showSaveDialog(null);
			if (result == JFileChooser.APPROVE_OPTION) {
				// Get file path
				String filePath = exChooser.getSelectedFile().getAbsolutePath();
				if (filePath.endsWith(".xls") || filePath.endsWith(".XLS") || filePath.endsWith(".xlsx")
						|| filePath.endsWith(".XLSX")) {
					if (exportToFile(filePath)) {
						if (SendMail.sendMailExportFile(employeeMain.getEmail(), filePath)) {
							showMessenger("Please check your email");
						} else {
							showMessenger("Send Failed! Please try again");
						}
					} else {
						showMessenger("Can't save export file! Please try again");
					}
				} else {
					showMessenger("Wrong file type\n Sample: .xls or .xlsx");
				}
			}
		} else {
			showMessenger("Empty data, can't export!");
		}
	}

	// Save file export
	private void openDialogAndCheck() {
		if (tableObsolete.getModel().getRowCount() > 0) {
			JFileChooser exChooser = new JFileChooser();
			// Change box title
			exChooser.setDialogTitle("Export to excel file");
			// Only filter files with extension "xls", "xlsx", "xlsm"
			FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILE - xls, xlsx", "xls", "xlsx");
			exChooser.setFileFilter(fnef);
			int result = exChooser.showSaveDialog(null);
			if (result == JFileChooser.APPROVE_OPTION) {
				// Get file path
				String filePath = exChooser.getSelectedFile().getAbsolutePath();
				if (filePath.endsWith(".xls") || filePath.endsWith(".XLS") || filePath.endsWith(".xlsx")
						|| filePath.endsWith(".XLSX")) {
					if (exportToFile(filePath)) {
						showMessenger("Exported! Please check your file");
					} else {
						showMessenger("Can't save export file! Please try again");
					}
				} else {
					showMessenger("Wrong file type\n Sample: .xls or .xlsx");
				}
			}
		} else {
			showMessenger("Empty data, can't export!");
		}
	}

	private boolean exportToFile(String filePath) {
		Workbook workbook = new XSSFWorkbook();
		String sheetName = "";
		if (statusBox.getSelectedIndex() == 0) {
			sheetName = "Obselete Books";
		} else {
			sheetName = "Lost Books";
		}
		Sheet sheet = workbook.createSheet(sheetName);
		org.apache.poi.ss.usermodel.Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());

		// Create a CellStyle with the font
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont((org.apache.poi.ss.usermodel.Font) headerFont);

		Row createdDate = sheet.createRow(0);
		Cell date = createdDate.createCell(0);
		date.setCellValue("Created date: " + spdf.format(new Date()));

		Row headerRow = sheet.createRow(1);

		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}

		int rowNum = 2;
		int No = 1;

		for (ObseleteBook obb : obbs) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(No++);
			row.createCell(1).setCellValue(obb.getCard_number());
			row.createCell(2).setCellValue(obb.getEmployee_name());
			row.createCell(3).setCellValue(obb.getTitle());
			row.createCell(4).setCellValue(obb.getInvoice_ID());
			row.createCell(5).setCellValue(spdf.format(obb.getReturn_date()));
			row.createCell(6).setCellValue(spdf.format(obb.getTerm_date()));
		}

		for (int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}

		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(filePath);
			workbook.write(fileOut);
			fileOut.close();
			workbook.close();
			return true;
		} catch (Exception e1) {
			return false;
		}
	}

	// ======Famous Book & Friendly Member Statistical

	private void btnSearch_mouseClicked(MouseEvent e) {
		int day = dayChooser.getDay();
		int month = monthChooser_1.getMonth() + 1;
		int year = yearChooser_1.getYear();

		int option = 0;
		if (chbxDay.isSelected() && chbxMonth.isSelected()) {
			option = 1;
		}

		if (chbxDay.isSelected() && !chbxMonth.isSelected()) {
			option = 2;
		}

		if (!chbxDay.isSelected() && chbxMonth.isSelected()) {
			option = 3;
		}

		// List of famous books
		boks = BooksModel.getFamousBook(day, month, year, option);
		MemberModel memberModel = new MemberModel();
		// List of friendly members
		members = memberModel.getFriendlyMember(day, month, year, option);
		// Amount of new member
		newMembers = memberModel.getAllNewMember(day, month, year, option);
		int newMemberAmount = newMembers.size();
		// Amount of bill
		bills = Borrow_billModel.getAllBills(day, month, year, option);
		int billAmount = bills.size();
		// List of all books
		allBooks = BooksModel.getAllBooks(bills);
		int bookAmount = allBooks.size();
		// SET VALUE
		// Famous books
		if (boks != null) {
			fBookModel.getDataVector().removeAllElements();
			fBookModel.fireTableDataChanged();
			for (FamousBook bok : boks) {
				fBookModel.addRow(new Object[] { fBookModel.getRowCount() + 1, bok.getTitle(), bok.getAmount() });
			}
			tableFamousBook.setModel(fBookModel);
		}

		// Friendly members
		if (members != null) {
			fMemberModel.getDataVector().removeAllElements();
			fMemberModel.fireTableDataChanged();
			for (FriendlyMember member : members) {
				fMemberModel
						.addRow(new Object[] { fMemberModel.getRowCount() + 1, member.getName(), member.getAmountB() });
			}
			tableFamousMember.setModel(fMemberModel);
		}

		// Set amount of bill
		billBookAm.setText(String.valueOf(billAmount));
		newMemberAm.setText(String.valueOf(newMemberAmount));
		BookAm.setText(String.valueOf(bookAmount));
	}

	// Dialog details
	private void billBookAm_mouseClicked(MouseEvent e) {
		if (bills != null) {
			ReportDialog.titlePanel = "Borrow Bills";
			ReportDialog.bills = bills;
			ReportDialog.columns = new String[] { "No", "Bill ID", "Member", "Status", "Borrow date" };
			ReportDialog.option = "bill";
			ReportDialog reportDialog = new ReportDialog();
			reportDialog.setVisible(true);
		}
	}

	private void newMemberAm_mouseClicked(MouseEvent e) {
		if (newMembers != null) {
			ReportDialog.titlePanel = "New Members";
			ReportDialog.newMembers = newMembers;
			ReportDialog.columns = new String[] { "No", "ID", "Name", "ID Card", "Created date" };
			ReportDialog.option = "member";
			ReportDialog reportDialog = new ReportDialog();
			reportDialog.setVisible(true);
		}
	}

	private void BookAm_mouseClicked(MouseEvent e) {
		if(allBooks != null) {
			ReportDialog.titlePanel = "Books";
			ReportDialog.allBooks = allBooks;
			ReportDialog.columns = new String[] { "No", "Bill ID", "Member ID", "Title", "Status" };
			ReportDialog.option = "book";
			ReportDialog reportDialog = new ReportDialog();
			reportDialog.setVisible(true);
		}
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
