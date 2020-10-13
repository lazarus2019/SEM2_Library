package main;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.toedter.calendar.JYearChooser;

import entities.Bor_book;
import entities.Borrow_bill;
import entities.Employee;
import entities.FamousBook;
import entities.ObseleteBook;
import model.BooksModel;
import model.SendMail;

import com.toedter.calendar.JMonthChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.toedter.calendar.JDayChooser;
import javax.swing.JCheckBox;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

// Import apache poi excel

public class reportPanel extends JPanel {
	private static DefaultTableModel tableModel = null;
	private JMonthChooser monthChooser;
	private JYearChooser yearChooser;
	private JTable tableFamousBook;
	private JTable tableFamousMember;
	private JTable tableObsolete;
	private static BooksModel booksModel = new BooksModel();
	private static SimpleDateFormat spdf = new SimpleDateFormat("MM/dd/yyyy");
	private JComboBox statusBox;

	private static String[] columns = null;
	private static List<ObseleteBook> obbs = null;

	// Declare Direct mapping
	public static Employee employeeMain = null;
	private JMonthChooser monthChooser_1;
	private JDayChooser dayChooser;
	private JYearChooser yearChooser_1;
	private JCheckBox chbxDay;
	private JCheckBox chbxMonth;

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

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(245, 244, 252));
		panel_3.setBounds(10, 129, 778, 449);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 45, 758, 383);
		panel_3.add(scrollPane);

		tableObsolete = new JTable();
		scrollPane.setViewportView(tableObsolete);

		JLabel lblNewLabel = new JLabel("Obsolete Books");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(268, 0, 239, 34);
		panel_3.add(lblNewLabel);

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

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Total", null, panel_1, null);
		panel_1.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 308, 321, 270);
		panel_1.add(panel_6);
		panel_6.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 48, 301, 211);
		panel_6.add(scrollPane_1);

		tableFamousBook = new JTable();
		scrollPane_1.setViewportView(tableFamousBook);

		JLabel lblNewLabel_4 = new JLabel("Famous Books");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_4.setBounds(72, 11, 176, 32);
		panel_6.add(lblNewLabel_4);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(344, 308, 444, 270);
		panel_1.add(panel_7);
		panel_7.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 49, 424, 210);
		panel_7.add(scrollPane_2);

		tableFamousMember = new JTable();
		scrollPane_2.setViewportView(tableFamousMember);

		JLabel lblNewLabel_5 = new JLabel("Famous Members");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_5.setBounds(89, 11, 266, 34);
		panel_7.add(lblNewLabel_5);

		JPanel panel_4 = new JPanel();
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
		btnSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSearch_mouseClicked(e);
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
		panel_8.setBounds(464, 11, 304, 136);
		panel_4.add(panel_8);
		panel_8.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Bill book:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 11, 132, 20);
		panel_8.add(lblNewLabel_1);

		JLabel billBookAm = new JLabel("0");
		billBookAm.setFont(new Font("Tahoma", Font.BOLD, 14));
		billBookAm.setBounds(156, 11, 54, 20);
		panel_8.add(billBookAm);

		JLabel lblNewLabel_1_1 = new JLabel("New member:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 46, 132, 20);
		panel_8.add(lblNewLabel_1_1);

		JLabel newMemberAm = new JLabel("0");
		newMemberAm.setFont(new Font("Tahoma", Font.BOLD, 14));
		newMemberAm.setBounds(156, 46, 54, 20);
		panel_8.add(newMemberAm);

		loadData();
	}

	// Load data
	private void loadData() {
		loadTableBook();
		loadStatusBox();
	}

	//======Obselete & Lost Book Manage
	// Load table
	private void loadTableBook() {
		tableModel = new DefaultTableModel() {
			// Can't edit cell
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		columns = new String[] { "No", "ID Card", "Employee", "Title", "Invoice ID", "Return date", "Day late"};
		tableModel.setColumnIdentifiers(columns);
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
	}

	// Load Status Combobox
	private void loadStatusBox() {
		DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<String>();
		comboBoxModel.addElement("Obselete");
		comboBoxModel.addElement("Lost");
		statusBox.setModel(comboBoxModel);
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
		int status = statusBox.getSelectedIndex() == 0 ? 2 : 3;
		List<Borrow_bill> books = booksModel.getBills(month, year);
		if (books != null) {
			obbs = booksModel.getObseleteBook(books, status);
			tableModel.getDataVector().removeAllElements();
			tableModel.fireTableDataChanged();
			long diff;
			for (ObseleteBook obb : obbs) {
				diff = obb.getReturn_date().getTime() - obb.getTerm_date().getTime();
				tableModel.addRow(new Object[] { tableModel.getRowCount() + 1, obb.getCard_number(),
						obb.getEmployee_name(), obb.getTitle(), obb.getInvoice_ID(), spdf.format(obb.getReturn_date()),
						TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + " days"});
			}
			tableObsolete.setModel(tableModel);
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

	
	//======Famous Book & Friendly Member Statistical
	// 
	
	private void btnSearch_mouseClicked(MouseEvent e) {
		int day = dayChooser.getDay();
		int month = monthChooser_1.getMonth()+1;
		int year = yearChooser_1.getYear();
		
		int option = 0;
		if(chbxDay.isSelected() && chbxMonth.isSelected()) {
			option = 1;
		}
		
		if(chbxDay.isSelected() && !chbxMonth.isSelected()) {
			option = 2;
		}
		
		if(!chbxDay.isSelected() && chbxMonth.isSelected()) {
			option = 3;
		}
		
		List<FamousBook> boks = BooksModel.getFamousBook(day, month, year, option);
		if(boks != null) {
			for(FamousBook bok : boks) {
				System.out.println(bok.getTitle());
			}
			System.out.println("----");
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
