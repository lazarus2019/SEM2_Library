package main;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;

import entities.Author;
import entities.Books;
import entities.Member;
import model.AuthorModel;
import model.BooksModel;
import model.Borrow_billModel;
import model.MemberModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

public class invoicePanel extends JPanel {
	private JTable jtableFindBook;
	private JTable jtableSelectedBook;
	private JTextField jtextFieldIDCardR;
	private JTable jtableBookBorrowed;
	private JTextField jtextFieldReturnDate;
	private JTextField jtextFieldNumberofLateDate;
	private JTextField jtextFieldLateFee;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextArea jtextAreaCondition;
	private JRadioButton jradiobuttonReturn;
	private JRadioButton jradiobuttonLost;
	private JTable jtableBooksReturning;
	private JLabel jlabelImage;

	DefaultTableModel defaultTableModelFindBook = new DefaultTableModel() {
		public boolean isCellEditable(int arg0, int arg1) {
			return false;
		};
	};
	DefaultTableModel defaultTableModelSelectedBook = new DefaultTableModel() {
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};
	private JTextField jtextFieldIDCardB;
	private JTextField jtextFieldName;
	private JTextField jtextFieldTitle;
	private JTextField jtextFieldIDBook;
	private JDateChooser jdateChooserCreateDate;

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Create the panel.
	 */
	public invoicePanel() {
		setBounds(0, 0, 803, 617);
		setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		add(tabbedPane, BorderLayout.CENTER);

		JPanel jpanelissueBook = new JPanel();
		jpanelissueBook.setToolTipText("Issue Book");
		jpanelissueBook.setFont(new Font("Arial", Font.PLAIN, 24));
		jpanelissueBook.setBackground(Color.WHITE);
		tabbedPane.addTab("Issue Book", null, jpanelissueBook, null);
		jpanelissueBook.setLayout(null);

		JPanel jpanelReturnBook = new JPanel();
		tabbedPane.addTab("Return Book", null, jpanelReturnBook, null);
		jpanelReturnBook.setLayout(null);
		jpanelReturnBook.setBackground(Color.WHITE);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 244, 252));
		panel_1.setBounds(22, 24, 471, 550);
		jpanelReturnBook.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Books borrow");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_2.setBounds(11, 3, 449, 29);
		panel_1.add(lblNewLabel_2);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Books borrowed", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBackground(new Color(245, 244, 252));
		panel_5.setBounds(11, 66, 449, 236);
		panel_1.add(panel_5);
		panel_5.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 24, 428, 200);
		panel_5.add(scrollPane_2);

		jtableBookBorrowed = new JTable();
		scrollPane_2.setViewportView(jtableBookBorrowed);
		scrollPane_2.getViewport().setBackground(Color.WHITE);

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Books returning", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_6.setBackground(new Color(245, 244, 252));
		panel_6.setBounds(11, 302, 449, 236);
		panel_1.add(panel_6);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 24, 428, 200);
		panel_6.add(scrollPane_3);

		jtableBooksReturning = new JTable();
		scrollPane_3.setViewportView(jtableBooksReturning);
		scrollPane_3.getViewport().setBackground(Color.WHITE);

		JLabel lblNewLabel_4 = new JLabel("ID Card");
		lblNewLabel_4.setBounds(21, 37, 48, 25);
		panel_1.add(lblNewLabel_4);

		jtextFieldIDCardR = new JTextField();
		jtextFieldIDCardR.setBounds(68, 34, 266, 30);
		panel_1.add(jtextFieldIDCardR);
		jtextFieldIDCardR.setFont(new Font("Tahoma", Font.PLAIN, 24));
		jtextFieldIDCardR.setColumns(10);

		JButton jbtnSearchIDCardR = new JButton("Search");
		jbtnSearchIDCardR.setBounds(343, 34, 117, 30);
		panel_1.add(jbtnSearchIDCardR);
		jbtnSearchIDCardR.setForeground(Color.WHITE);
		jbtnSearchIDCardR.setBackground(new Color(30, 106, 210));
		jbtnSearchIDCardR.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JPanel panel = new JPanel();
		panel.setBounds(504, 73, 272, 501);
		jpanelReturnBook.add(panel);
		panel.setBackground(new Color(245, 244, 252));
		panel.setLayout(null);

		JLabel lblInfomationCheck = new JLabel("Info check");
		lblInfomationCheck.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfomationCheck.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblInfomationCheck.setBounds(22, 3, 237, 29);
		panel.add(lblInfomationCheck);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 244, 252));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBounds(11, 34, 248, 455);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Return date(dd/MM/yyy)");
		lblNewLabel_5.setBounds(10, 57, 228, 25);
		panel_2.add(lblNewLabel_5);

		jtextFieldReturnDate = new JTextField();
		jtextFieldReturnDate.setBounds(10, 76, 228, 30);
		panel_2.add(jtextFieldReturnDate);
		jtextFieldReturnDate.setColumns(10);

		JLabel lblLateDate = new JLabel("Number of late date");
		lblLateDate.setBounds(10, 106, 228, 29);
		panel_2.add(lblLateDate);

		jtextFieldNumberofLateDate = new JTextField();
		jtextFieldNumberofLateDate.setBackground(Color.WHITE);
		jtextFieldNumberofLateDate.setEditable(false);
		jtextFieldNumberofLateDate.setFont(new Font("Tahoma", Font.PLAIN, 24));
		jtextFieldNumberofLateDate.setColumns(10);
		jtextFieldNumberofLateDate.setBounds(10, 129, 228, 30);
		panel_2.add(jtextFieldNumberofLateDate);

		JLabel lblStatus = new JLabel("Status when return");
		lblStatus.setBounds(10, 208, 228, 29);
		panel_2.add(lblStatus);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(234, 184, -137, 94);
		panel_2.add(textArea);

		jradiobuttonReturn = new JRadioButton("Returned");
		jradiobuttonReturn.setSelected(true);
		buttonGroup.add(jradiobuttonReturn);
		jradiobuttonReturn.setBackground(new Color(245, 244, 252));
		jradiobuttonReturn.setBounds(10, 321, 113, 30);
		panel_2.add(jradiobuttonReturn);

		jradiobuttonLost = new JRadioButton("Lost");
		buttonGroup.add(jradiobuttonLost);
		jradiobuttonLost.setBackground(new Color(245, 244, 252));
		jradiobuttonLost.setBounds(131, 321, 107, 30);
		panel_2.add(jradiobuttonLost);

		JButton btnNewButton = new JButton("Give back");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(30, 106, 210));
		btnNewButton.setBounds(65, 405, 123, 30);
		panel_2.add(btnNewButton);

		JLabel lblNewLabel_6 = new JLabel("Late fee");
		lblNewLabel_6.setBounds(10, 159, 228, 25);
		panel_2.add(lblNewLabel_6);

		jtextFieldLateFee = new JTextField();
		jtextFieldLateFee.setBackground(Color.WHITE);
		jtextFieldLateFee.setEditable(false);
		jtextFieldLateFee.setColumns(10);
		jtextFieldLateFee.setBounds(10, 179, 228, 30);
		panel_2.add(jtextFieldLateFee);

		jtextAreaCondition = new JTextArea();
		jtextAreaCondition.setBounds(10, 233, 228, 80);
		panel_2.add(jtextAreaCondition);

		JLabel lblIdBook = new JLabel("ID Book");
		lblIdBook.setBounds(10, 8, 228, 25);
		panel_2.add(lblIdBook);

		jtextFieldIDBook = new JTextField();
		jtextFieldIDBook.setBackground(Color.WHITE);
		jtextFieldIDBook.setEditable(false);
		jtextFieldIDBook.setColumns(10);
		jtextFieldIDBook.setBounds(10, 27, 228, 30);
		panel_2.add(jtextFieldIDBook);

		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.setForeground(Color.WHITE);
		btnReturnBook.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnReturnBook.setBackground(new Color(30, 106, 210));
		btnReturnBook.setBounds(541, 24, 196, 37);
		jpanelReturnBook.add(btnReturnBook);

		JPanel jpanelstatistics = new JPanel();
		tabbedPane.addTab("New tab", null, jpanelstatistics, null);

		Date date = new Date();

		JPanel jpanelMember = new JPanel();
		jpanelMember.setBounds(22, 24, 536, 174);
		jpanelissueBook.add(jpanelMember);
		jpanelMember.setFont(new Font("Tahoma", Font.PLAIN, 26));
		jpanelMember.setBackground(new Color(245, 244, 252));
		jpanelMember.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		jpanelMember.setLayout(null);

		JLabel label = new JLabel("Member Details");
		label.setFont(new Font("Tahoma", Font.PLAIN, 26));
		label.setBounds(170, 3, 196, 29);
		jpanelMember.add(label);

		JLabel lblNewLabel_1 = new JLabel("\u206FID Card");
		lblNewLabel_1.setBounds(22, 55, 343, 25);
		jpanelMember.add(lblNewLabel_1);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(22, 109, 343, 25);
		jpanelMember.add(lblName);

		JButton jbtnSearchIDCardB = new JButton("Search");
		jbtnSearchIDCardB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jbtnSearchIDCardB_actionPerformed(arg0);
			}
		});
		jbtnSearchIDCardB.setForeground(Color.WHITE);
		jbtnSearchIDCardB.setFont(new Font("Tahoma", Font.PLAIN, 24));
		jbtnSearchIDCardB.setBackground(new Color(30, 106, 210));
		jbtnSearchIDCardB.setBounds(248, 75, 117, 30);
		jpanelMember.add(jbtnSearchIDCardB);

		jlabelImage = new JLabel("");
		jlabelImage.setBorder(new LineBorder(Color.WHITE));
		jlabelImage.setBackground(Color.WHITE);
		jlabelImage.setBounds(376, 24, 138, 135);
		jpanelMember.add(jlabelImage);

		jtextFieldIDCardB = new JTextField();
		jtextFieldIDCardB.setFont(new Font("Tahoma", Font.ITALIC, 18));
		jtextFieldIDCardB.setBounds(22, 75, 215, 30);
		jpanelMember.add(jtextFieldIDCardB);
		jtextFieldIDCardB.setColumns(10);

		jtextFieldName = new JTextField();
		jtextFieldName.setFont(new Font("Tahoma", Font.ITALIC, 18));
		jtextFieldName.setBackground(Color.WHITE);
		jtextFieldName.setEditable(false);
		jtextFieldName.setColumns(10);
		jtextFieldName.setBounds(22, 129, 343, 30);
		jpanelMember.add(jtextFieldName);

		JButton jbtnIssueBook = new JButton("Issue Book");
		jbtnIssueBook.setBounds(580, 24, 196, 37);
		jpanelissueBook.add(jbtnIssueBook);
		jbtnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jbtnIssueBook_actionPerformed(arg0);
			}
		});
		jbtnIssueBook.setFont(new Font("Tahoma", Font.BOLD, 24));
		jbtnIssueBook.setBackground(new Color(30, 106, 210));
		jbtnIssueBook.setForeground(Color.WHITE);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(567, 85, 209, 114);
		jpanelissueBook.add(panel_7);
		panel_7.setBackground(new Color(245, 244, 252));
		panel_7.setLayout(null);

		JLabel lblNewLabel = new JLabel("Create date:");
		lblNewLabel.setBounds(9, 35, 184, 25);
		panel_7.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setForeground(Color.BLACK);

		jdateChooserCreateDate = new JDateChooser();
		jdateChooserCreateDate.getCalendarButton().setFont(new Font("Tahoma", Font.BOLD, 24));
		jdateChooserCreateDate.setDateFormatString("dd/MM/yyyy");
		jdateChooserCreateDate.setBounds(9, 70, 184, 30);
		panel_7.add(jdateChooserCreateDate);
		jdateChooserCreateDate.getCalendarButton().setBackground(Color.WHITE);
		jdateChooserCreateDate.getCalendarButton().setForeground(Color.WHITE);
		jdateChooserCreateDate.setBackground(Color.DARK_GRAY);
		jdateChooserCreateDate.setForeground(Color.BLACK);
		jdateChooserCreateDate.setDate(date);

		JPanel jpanelBook = new JPanel();
		jpanelBook.setBounds(22, 205, 754, 369);
		jpanelissueBook.add(jpanelBook);
		jpanelBook.setForeground(new Color(51, 153, 204));
		jpanelBook.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		jpanelBook.setBackground(new Color(245, 244, 252));
		jpanelBook.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		jpanelBook.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Find Books", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBackground(new Color(245, 244, 252));
		panel_3.setBounds(5, 30, 745, 175);
		jpanelBook.add(panel_3);
		panel_3.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.white);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(11, 63, 722, 103);
		panel_3.add(scrollPane);

		jtableFindBook = new JTable();
		jtableFindBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				jtableFindBookmouseClicked(arg0);
			}
		});
		jtableFindBook.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtableFindBook.setForeground(Color.BLACK);
		jtableFindBook.setBackground(Color.WHITE);
		scrollPane.setViewportView(jtableFindBook);

		JLabel lblNewLabel_3 = new JLabel("Title");
		lblNewLabel_3.setBounds(11, 23, 45, 25);
		panel_3.add(lblNewLabel_3);

		JButton jbtnSearchTitle = new JButton("Search");
		jbtnSearchTitle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jbtnSearchTitle_actionPerformed(arg0);
			}
		});
		jbtnSearchTitle.setForeground(Color.WHITE);
		jbtnSearchTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		jbtnSearchTitle.setBackground(new Color(30, 106, 210));
		jbtnSearchTitle.setBounds(340, 20, 117, 30);
		panel_3.add(jbtnSearchTitle);

		jtextFieldTitle = new JTextField();
		jtextFieldTitle.setFont(new Font("Tahoma", Font.ITALIC, 18));
		jtextFieldTitle.setColumns(10);
		jtextFieldTitle.setBounds(54, 20, 275, 30);
		panel_3.add(jtextFieldTitle);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Selected Book", TitledBorder.LEFT,
				TitledBorder.TOP, null, Color.BLACK));
		panel_4.setBackground(new Color(245, 244, 252));
		panel_4.setBounds(5, 203, 745, 159);
		jpanelBook.add(panel_4);
		panel_4.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.getViewport().setBackground(Color.white);
		scrollPane_1.setBackground(Color.WHITE);
		scrollPane_1.setBounds(11, 45, 722, 103);
		panel_4.add(scrollPane_1);

		jtableSelectedBook = new JTable();
		jtableSelectedBook.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtableSelectedBook.setForeground(Color.BLACK);
		scrollPane_1.setViewportView(jtableSelectedBook);

		JButton jbtnDelete = new JButton("Delete");
		jbtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jbtnDelete_actionPerformed(arg0);
			}
		});
		jbtnDelete.setForeground(Color.WHITE);
		jbtnDelete.setBackground(new Color(30, 106, 210));
		jbtnDelete.setBounds(646, 14, 87, 26);
		panel_4.add(jbtnDelete);

		JLabel label_1 = new JLabel("Book Details");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		label_1.setBounds(305, 3, 143, 29);
		jpanelBook.add(label_1);

		loadDataFindBook();
		loadDataSelectedBook();
	}

	// Issue Button
	public void jbtnIssueBook_actionPerformed(ActionEvent arg0) {
	}

	// Delete 1 row of Selected Books
	public void jbtnDelete_actionPerformed(ActionEvent arg0) {
		int selectedIndexRow = jtableSelectedBook.getSelectedRow();
		defaultTableModelSelectedBook.removeRow(selectedIndexRow);
		jtableSelectedBook.setModel(defaultTableModelSelectedBook);
	}

	// click mouse select from Find Books to Selected Books
	public void jtableFindBookmouseClicked(MouseEvent arg0) {
		try {
			int selectedIndexRowF = jtableFindBook.getSelectedRow();
			int selectedIndexRowS = jtableSelectedBook.getSelectedRow();
			int rows = jtableSelectedBook.getRowCount();
			int number = 1;
			for (int i = 0; i < rows; i++) {
				number++;
			}
			String idBook = jtableFindBook.getValueAt(selectedIndexRowF, 1).toString();
			String title = jtableFindBook.getValueAt(selectedIndexRowF, 2).toString();
			String author = jtableFindBook.getValueAt(selectedIndexRowF, 3).toString();
			String status = jtableFindBook.getValueAt(selectedIndexRowF, 4).toString();
			Date jdatechooser = jdateChooserCreateDate.getDate();
			String date = simpleDateFormat.format(jdatechooser);
			if (status == "Available") {
//				if (jtableSelectedBook != null) {
//					if (idBook != jtableSelectedBook.getValueAt(selectedIndexRowS, 1).toString()) {
//						defaultTableModelSelectedBook.addRow(new Object[] {number, idBook, title, author });
//						jtableSelectedBook.setModel(defaultTableModelSelectedBook);
//					} else {
//						JOptionPane.showMessageDialog(null, "You have chosen book '" + title + "'!", "Notification",
//								JOptionPane.OK_OPTION);
//					}
//				} else {
//					defaultTableModelSelectedBook.addRow(new Object[] { number, idBook, title, author, date });
//					jtableSelectedBook.setModel(defaultTableModelSelectedBook);
//				}
				defaultTableModelSelectedBook.addRow(new Object[] { number, idBook, title, author, date });
				jtableSelectedBook.setModel(defaultTableModelSelectedBook);
			} else {
				JOptionPane.showMessageDialog(null, "The book '" + title + "' is not available", "Notification",
						JOptionPane.OK_OPTION);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	// Search "Title" for Book Details of BORROW BOOK
	public void jbtnSearchTitle_actionPerformed(ActionEvent arg0) {
		String title = jtextFieldTitle.getText().toLowerCase().trim();
		defaultTableModelFindBook.getDataVector().removeAllElements();
		defaultTableModelFindBook.fireTableDataChanged();
		if (!title.isEmpty()) {
			BooksModel bookModel = new BooksModel();
			AuthorModel authorModel = new AuthorModel();
			Borrow_billModel borrow_billModel = new Borrow_billModel();
			List<Books> books = bookModel.searchBooks(title);
			int number = 1;
			String status = null;
			String au = null;
			for (Books book : books) {
				if (borrow_billModel.count(false) < book.getQuantity()) {
					status = "Available";
				} else {
					status = "Unavailable";
				}
				for (Author author : authorModel.searchBooks(book.getBook_ID())) {
					au = author.getName();
				}

				defaultTableModelFindBook
						.addRow(new Object[] { number++, book.getBook_ID(), book.getTitle(), au, status });
				jtableFindBook.setModel(defaultTableModelFindBook);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Title required, please!", "Notification", JOptionPane.OK_OPTION);
		}

	}

	// Search "ID Card" for Member Details of BORROW BOOK
	public void jbtnSearchIDCardB_actionPerformed(ActionEvent arg0) {
		String idCard = jtextFieldIDCardB.getText();
		if (!idCard.isEmpty()) {
			MemberModel memberModel = new MemberModel();
			Member member = memberModel.find(idCard);
			if (member == null) {
				JOptionPane.showMessageDialog(null, "ID Card does not exist or has expired!", "Notification",
						JOptionPane.OK_OPTION);
			} else {
				String name = member.getName();
				String photo = member.getPhoto().toString();
				jtextFieldName.setText(name);
				ImageIcon icon = new ImageIcon(photo);
				jlabelImage.setIcon(icon);
			}
		} else {
			JOptionPane.showMessageDialog(null, "ID Card required, please!", "Notification", JOptionPane.OK_OPTION);
		}

	}

	// Find Books header
	public void loadDataFindBook() {
		String[] F_columns = { "No", "ID", "Title", "Author", "Status" };
		defaultTableModelFindBook.setColumnIdentifiers(F_columns);
		jtableFindBook.setModel(defaultTableModelFindBook);
		jtableFindBook.getTableHeader().setResizingAllowed(false);
		jtableFindBook.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModelF = jtableFindBook.getColumnModel();
		// set width
		columnModelF.getColumn(0).setPreferredWidth(50);
		columnModelF.getColumn(1).setPreferredWidth(100);
		columnModelF.getColumn(2).setPreferredWidth(300);
		columnModelF.getColumn(3).setPreferredWidth(180);
		columnModelF.getColumn(4).setPreferredWidth(92);
		// set color
		JTableHeader tableFindBookHeader = jtableFindBook.getTableHeader();
		tableFindBookHeader.setBackground(new Color(223, 233, 242));
		tableFindBookHeader.setForeground(Color.BLACK);
	}

	// Selected Books header
	public void loadDataSelectedBook() {
		String[] S_columns = { "No", "ID", "Title", "Author", "Borrow date" };
		defaultTableModelSelectedBook.setColumnIdentifiers(S_columns);
		jtableSelectedBook.setModel(defaultTableModelSelectedBook);
		jtableSelectedBook.getTableHeader().setReorderingAllowed(false);
		jtableSelectedBook.getTableHeader().setResizingAllowed(false);
		TableColumnModel columnModelS = jtableSelectedBook.getColumnModel();
		// set width
		columnModelS.getColumn(0).setPreferredWidth(50);
		columnModelS.getColumn(1).setPreferredWidth(100);
		columnModelS.getColumn(2).setPreferredWidth(300);
		columnModelS.getColumn(3).setPreferredWidth(180);
		columnModelS.getColumn(4).setPreferredWidth(92);
		// set color
		JTableHeader tableSelectedBookHeader = jtableSelectedBook.getTableHeader();
		tableSelectedBookHeader.setBackground(new Color(223, 233, 242));
		tableSelectedBookHeader.setForeground(Color.BLACK);
	}
}
