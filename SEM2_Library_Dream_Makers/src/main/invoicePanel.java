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
import java.awt.Image;
import java.awt.SystemColor;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import com.toedter.calendar.JYearChooser;

import entities.Author;
import entities.Books;
import entities.Borrow_bill;
import entities.Employee;
import entities.Member;
import model.AuthorModel;
import model.BooksModel;
import model.Bor_bookModel;
import model.Borrow_billModel;
import model.LibCardModel;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.awt.Cursor;

public class invoicePanel extends JPanel {
	public JTable jtableFindBook;
	private JTable jtableSelectedBook;
	private JTextField jtextFieldIDCardR;
	private JTable jtableBorrowedBook;
	private JTextField jtextFieldNumberofLateDate;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton jradiobuttonReturn;
	private JRadioButton jradiobuttonLost;
	private JTable jtableReturningBook;
	private JLabel jlabelImage;
	private Date date = new Date();
	private JTextField jtextFieldIDCardB;
	private JTextField jtextFieldName;
	private JTextField jtextFieldTitle;
	private JTextField jtextFieldIDBook;
	private JDateChooser jdateChooserCreateDate;
	private JTextField jtextFieldLateFee;
	public static Employee employee = null;
	private double lateFee = 0;
	private double compendationFee = 0;
	private boolean f = true;
	private List<String> bookLost = new ArrayList<String>();

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	// Start NVT
	private JPanel panel_9;
	private JYearChooser yearChooser;
	private JMonthChooser monthChooser;
	private JLabel btnSearch;
	private JTable tableBorrowBill;
	private JTextField jtextFieldCompensationFee;
	// End NVT
	JPanel panel_2 = new JPanel();

	public static List<String> bookID = new ArrayList<String>();
	public static Member member = null;

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
	DefaultTableModel defaultTableModelBorrowedBook = new DefaultTableModel() {
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};
	DefaultTableModel defaultTableModelReturningBook = new DefaultTableModel() {
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};
	DefaultTableModel defaultTableModelBorrowBill = new DefaultTableModel() {
		public boolean isCellEditable(int arg0, int arg1) {
			return false;
		};
	};
	private JLabel lblNewLabelx;
	private JDateChooser jdateChooserReturnDate;

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
		jpanelissueBook.setBackground(Color.WHITE);
		tabbedPane.addTab("Borrow Book", null, jpanelissueBook, null);
		jpanelissueBook.setLayout(null);

		JPanel jpanelReturnBook = new JPanel();
		tabbedPane.addTab("Return Book", null, jpanelReturnBook, null);
		jpanelReturnBook.setLayout(null);
		jpanelReturnBook.setBackground(Color.WHITE);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 244, 252));
		panel_1.setBounds(11, 12, 471, 286);
		jpanelReturnBook.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Books Detail");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_2.setBounds(11, 3, 449, 29);
		panel_1.add(lblNewLabel_2);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Borrowed Books", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBackground(new Color(245, 244, 252));
		panel_5.setBounds(11, 66, 449, 209);
		panel_1.add(panel_5);
		panel_5.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 24, 428, 173);
		panel_5.add(scrollPane_2);

		jtableBorrowedBook = new JTable();
		jtableBorrowedBook.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtableBorrowedBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				jtableBorrowedBook_mouseClicked(arg0);
			}
		});
		scrollPane_2.setViewportView(jtableBorrowedBook);
		scrollPane_2.getViewport().setBackground(Color.WHITE);

		JLabel lblNewLabel_4 = new JLabel("ID Card");
		lblNewLabel_4.setBounds(21, 37, 48, 25);
		panel_1.add(lblNewLabel_4);

		jtextFieldIDCardR = new JTextField();
		jtextFieldIDCardR.setBounds(68, 34, 260, 30);
		panel_1.add(jtextFieldIDCardR);
		jtextFieldIDCardR.setFont(new Font("Tahoma", Font.PLAIN, 24));
		jtextFieldIDCardR.setColumns(10);

		JButton jbtnSearchIDCardR = new JButton("Search");
		jbtnSearchIDCardR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jbtnSearchIDCardR_actionPerformed(arg0);
			}
		});
		jbtnSearchIDCardR.setIcon(new ImageIcon(invoicePanel.class.getResource("/data/icon/Search.png")));
		jbtnSearchIDCardR.setForeground(Color.WHITE);
		jbtnSearchIDCardR.setFont(new Font("Tahoma", Font.PLAIN, 22));
		jbtnSearchIDCardR.setBackground(new Color(30, 106, 210));
		jbtnSearchIDCardR.setBounds(335, 34, 125, 30);
		panel_1.add(jbtnSearchIDCardR);

		JPanel panel = new JPanel();
		panel.setBounds(495, 68, 292, 507);
		jpanelReturnBook.add(panel);
		panel.setBackground(new Color(245, 244, 252));
		panel.setLayout(null);

		JLabel lblInfomationCheck = new JLabel("Info Check");
		lblInfomationCheck.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfomationCheck.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblInfomationCheck.setBounds(22, 3, 237, 29);
		panel.add(lblInfomationCheck);

		panel_2.setBackground(new Color(245, 244, 252));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBounds(11, 40, 270, 455);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Return date");
		lblNewLabel_5.setBounds(10, 57, 228, 25);
		panel_2.add(lblNewLabel_5);

		JLabel lblLateDate = new JLabel("Number of late date");
		lblLateDate.setBounds(10, 106, 228, 29);
		panel_2.add(lblLateDate);

		jtextFieldNumberofLateDate = new JTextField();
		jtextFieldNumberofLateDate.setBackground(Color.WHITE);
		jtextFieldNumberofLateDate.setEditable(false);
		jtextFieldNumberofLateDate.setFont(new Font("Tahoma", Font.PLAIN, 26));
		jtextFieldNumberofLateDate.setColumns(10);
		jtextFieldNumberofLateDate.setBounds(10, 129, 249, 30);
		panel_2.add(jtextFieldNumberofLateDate);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(234, 184, -137, 94);
		panel_2.add(textArea);

		jradiobuttonReturn = new JRadioButton("Returned");
		jradiobuttonReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (jradiobuttonReturn.isSelected()) {
					jtextFieldCompensationFee.setText("$0.0");
				}
			}
		});
		jradiobuttonReturn.setSelected(true);
		buttonGroup.add(jradiobuttonReturn);
		jradiobuttonReturn.setBackground(new Color(245, 244, 252));
		jradiobuttonReturn.setBounds(10, 218, 113, 30);
		panel_2.add(jradiobuttonReturn);

		jradiobuttonLost = new JRadioButton("Lost");
		jradiobuttonLost.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				jradiobuttonLost_mouseClicked(arg0);
			}
		});
		buttonGroup.add(jradiobuttonLost);
		jradiobuttonLost.setBackground(new Color(245, 244, 252));
		jradiobuttonLost.setBounds(131, 218, 107, 30);
		panel_2.add(jradiobuttonLost);

		JButton jbtnGiveBack = new JButton("Give back");
		jbtnGiveBack.setIcon(new ImageIcon(invoicePanel.class.getResource("/data/icon/giveBack.png")));
		jbtnGiveBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnGiveBack_actionPerformed(e);
			}
		});
		jbtnGiveBack.setForeground(Color.WHITE);
		jbtnGiveBack.setBackground(new Color(30, 106, 210));
		jbtnGiveBack.setBounds(73, 401, 123, 30);
		panel_2.add(jbtnGiveBack);

		JLabel lblNewLabel_6 = new JLabel("Late fee");
		lblNewLabel_6.setBounds(10, 159, 228, 25);
		panel_2.add(lblNewLabel_6);

		JLabel lblIdBook = new JLabel("ID Book");
		lblIdBook.setBounds(10, 8, 228, 25);
		panel_2.add(lblIdBook);

		jtextFieldIDBook = new JTextField();
		jtextFieldIDBook.setBackground(Color.WHITE);
		jtextFieldIDBook.setEditable(false);
		jtextFieldIDBook.setColumns(10);
		jtextFieldIDBook.setBounds(10, 27, 249, 30);
		panel_2.add(jtextFieldIDBook);

		// Start NVT
		JPanel jpanelstatistics = new JPanel();
		jpanelstatistics.setBackground(Color.WHITE);
		tabbedPane.addTab("Manage bill", null, jpanelstatistics, null);
		jpanelstatistics.setLayout(null);

		panel_9 = new JPanel();
		panel_9.setBackground(new Color(245, 244, 252));
		panel_9.setBounds(10, 119, 778, 459);
		jpanelstatistics.add(panel_9);
		panel_9.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 76, 758, 369);

		panel_9.add(scrollPane);
		scrollPane.getViewport().setBackground(Color.WHITE);

		tableBorrowBill = new JTable();
		scrollPane.setViewportView(tableBorrowBill);

		JLabel lblListBill = new JLabel("List Bill");
		lblListBill.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblListBill.setBounds(344, 3, 89, 29);
		panel_9.add(lblListBill);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(553, 42, 103, 23);
		panel_9.add(btnDelete);
		btnDelete.setIcon(new ImageIcon(invoicePanel.class.getResource("/data/icon/delete.png")));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDelete_actionPerformed(e);
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(new Color(30, 106, 210));

		JButton btnDetails = new JButton("Details");
		btnDetails.setBounds(665, 42, 103, 23);
		panel_9.add(btnDetails);
		btnDetails.setIcon(new ImageIcon(invoicePanel.class.getResource("/data/icon/.png")));
		btnDetails.setForeground(Color.WHITE);
		btnDetails.setBackground(new Color(30, 106, 210));
		btnDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDetails_actionPerformed(e);
			}
		});

		JPanel panel1 = new JPanel();
		panel1.setBounds(10, 10, 778, 99);
		jpanelstatistics.add(panel1);
		panel1.setLayout(null);
		panel1.setBackground(new Color(245, 244, 252));

		yearChooser = new JYearChooser();
		yearChooser.setBounds(133, 59, 96, 29);
		panel1.add(yearChooser);

		monthChooser = new JMonthChooser();
		monthChooser.getComboBox().setBackground(SystemColor.menu);
		monthChooser.setBounds(10, 59, 113, 29);
		panel1.add(monthChooser);

		btnSearch = new JLabel("Search");
		btnSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch.setIcon(new ImageIcon(invoicePanel.class.getResource("/data/icon/Search.png")));
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSearch_mouseClicked(e);
			}
		});
		btnSearch.setOpaque(true);
		btnSearch.setHorizontalAlignment(SwingConstants.CENTER);
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Arial", Font.BOLD, 15));
		btnSearch.setBackground(new Color(30, 106, 210));
		btnSearch.setBounds(242, 59, 113, 30);
		panel1.add(btnSearch);

		JLabel lblNewLabel = new JLabel("Search by time  :");
		lblNewLabel.setBounds(10, 32, 147, 23);
		panel1.add(lblNewLabel);

		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblSearch.setBounds(344, 3, 89, 29);
		panel1.add(lblSearch);
		// End NVT

		JPanel jpanelMember = new JPanel();
		jpanelMember.setBounds(11, 12, 547, 186);
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
		lblNewLabel_1.setBounds(32, 58, 343, 25);
		jpanelMember.add(lblNewLabel_1);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(32, 112, 343, 25);
		jpanelMember.add(lblName);

		jlabelImage = new JLabel("");
		jlabelImage.setBorder(new LineBorder(Color.WHITE));
		jlabelImage.setBackground(Color.WHITE);
		jlabelImage.setBounds(387, 27, 138, 135);
		jpanelMember.add(jlabelImage);

		jtextFieldIDCardB = new JTextField();
		jtextFieldIDCardB.setFont(new Font("Tahoma", Font.ITALIC, 18));
		jtextFieldIDCardB.setBounds(32, 78, 210, 30);
		jpanelMember.add(jtextFieldIDCardB);
		jtextFieldIDCardB.setColumns(10);

		jtextFieldName = new JTextField();
		jtextFieldName.setFont(new Font("Tahoma", Font.ITALIC, 18));
		jtextFieldName.setBackground(Color.WHITE);
		jtextFieldName.setEditable(false);
		jtextFieldName.setColumns(10);
		jtextFieldName.setBounds(32, 132, 343, 30);
		jpanelMember.add(jtextFieldName);

		JButton jbtnSearchIDCardB = new JButton("Search");
		jbtnSearchIDCardB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jbtnSearchIDCardB_actionPerformed(arg0);
			}
		});
		jbtnSearchIDCardB.setIcon(new ImageIcon(invoicePanel.class.getResource("/data/icon/Search.png")));
		jbtnSearchIDCardB.setForeground(Color.WHITE);
		jbtnSearchIDCardB.setFont(new Font("Tahoma", Font.PLAIN, 22));
		jbtnSearchIDCardB.setBackground(new Color(30, 106, 210));
		jbtnSearchIDCardB.setBounds(250, 78, 125, 30);
		jpanelMember.add(jbtnSearchIDCardB);

		JLabel lblCompensationFee = new JLabel("Compensation fee");
		lblCompensationFee.setBounds(10, 254, 228, 25);
		panel_2.add(lblCompensationFee);

		jtextFieldCompensationFee = new JTextField();
		jtextFieldCompensationFee.setFont(new Font("Tahoma", Font.PLAIN, 26));
		jtextFieldCompensationFee.setEditable(false);
		jtextFieldCompensationFee.setColumns(10);
		jtextFieldCompensationFee.setBackground(Color.WHITE);
		jtextFieldCompensationFee.setBounds(10, 274, 249, 30);
		panel_2.add(jtextFieldCompensationFee);

		jtextFieldLateFee = new JTextField();
		jtextFieldLateFee.setFont(new Font("Tahoma", Font.PLAIN, 26));
		jtextFieldLateFee.setEditable(false);
		jtextFieldLateFee.setColumns(10);
		jtextFieldLateFee.setBackground(Color.WHITE);
		jtextFieldLateFee.setBounds(10, 179, 249, 30);
		panel_2.add(jtextFieldLateFee);

		jdateChooserReturnDate = new JDateChooser();
		JTextFieldDateEditor editor2 = (JTextFieldDateEditor) jdateChooserReturnDate.getDateEditor();
		editor2.setEditable(false);
		jdateChooserReturnDate.getCalendarButton().setForeground(Color.WHITE);
		jdateChooserReturnDate.getCalendarButton().setFont(new Font("Tahoma", Font.BOLD, 24));
		jdateChooserReturnDate.getCalendarButton().setBackground(Color.WHITE);
		jdateChooserReturnDate.setForeground(Color.BLACK);
		jdateChooserReturnDate.setDateFormatString("dd/MM/yyyy");
		jdateChooserReturnDate.setBackground(Color.DARK_GRAY);
		jdateChooserReturnDate.setBounds(10, 75, 249, 30);
		jdateChooserReturnDate.setDate(date);
		panel_2.add(jdateChooserReturnDate);

		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(245, 244, 252));
		panel_8.setBounds(11, 309, 471, 265);
		jpanelReturnBook.add(panel_8);

		JLabel lblBooksAreReturning = new JLabel("List is Returned");
		lblBooksAreReturning.setHorizontalAlignment(SwingConstants.CENTER);
		lblBooksAreReturning.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblBooksAreReturning.setBounds(11, 3, 449, 29);
		panel_8.add(lblBooksAreReturning);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(11, 34, 450, 220);
		panel_8.add(panel_6);
		panel_6.setLayout(null);
		panel_6.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Returning Books", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_6.setBackground(new Color(245, 244, 252));

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 47, 428, 161);
		panel_6.add(scrollPane_3);

		jtableReturningBook = new JTable();
		jtableReturningBook.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_3.setViewportView(jtableReturningBook);

		JButton jbtnDeleteR = new JButton("Delete");
		jbtnDeleteR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jbtnDeleteR_actionPerformed(arg0);
			}
		});
		jbtnDeleteR.setIcon(new ImageIcon(invoicePanel.class.getResource("/data/icon/delete.png")));
		jbtnDeleteR.setForeground(Color.WHITE);
		jbtnDeleteR.setBackground(new Color(30, 106, 210));
		jbtnDeleteR.setBounds(348, 14, 90, 26);
		panel_6.add(jbtnDeleteR);

		JButton jbtnReturnBook = new JButton("Return Book");
		jbtnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jbtnReturnBook_actionPerformed(arg0);
			}
		});
		jbtnReturnBook.setIcon(new ImageIcon(invoicePanel.class.getResource("/data/icon/returnBook.png")));
		jbtnReturnBook.setForeground(Color.WHITE);
		jbtnReturnBook.setFont(new Font("Tahoma", Font.BOLD, 22));
		jbtnReturnBook.setBackground(new Color(30, 106, 210));
		jbtnReturnBook.setBounds(535, 12, 209, 37);
		jpanelReturnBook.add(jbtnReturnBook);
		scrollPane_3.getViewport().setBackground(Color.WHITE);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(567, 85, 219, 114);
		jpanelissueBook.add(panel_7);
		panel_7.setBackground(new Color(245, 244, 252));
		panel_7.setLayout(null);

		JLabel lblNewLabelc1 = new JLabel("Create date:");
		lblNewLabelc1.setBounds(19, 34, 184, 25);
		panel_7.add(lblNewLabelc1);
		lblNewLabelc1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabelc1.setForeground(Color.BLACK);

		jdateChooserCreateDate = new JDateChooser();
		JTextFieldDateEditor editor = (JTextFieldDateEditor) jdateChooserCreateDate.getDateEditor();
		editor.setEditable(false);
		jdateChooserCreateDate.getCalendarButton().setFont(new Font("Tahoma", Font.BOLD, 24));
		jdateChooserCreateDate.setDateFormatString("dd/MM/yyyy");
		jdateChooserCreateDate.setBounds(19, 59, 184, 30);
		panel_7.add(jdateChooserCreateDate);
		jdateChooserCreateDate.getCalendarButton().setBackground(Color.WHITE);
		jdateChooserCreateDate.getCalendarButton().setForeground(Color.WHITE);
		jdateChooserCreateDate.setBackground(Color.DARK_GRAY);
		jdateChooserCreateDate.setForeground(Color.BLACK);
		jdateChooserCreateDate.setDate(date);

		JPanel jpanelBook = new JPanel();
		jpanelBook.setBounds(11, 205, 775, 369);
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
		panel_3.setBounds(12, 30, 750, 175);
		jpanelBook.add(panel_3);
		panel_3.setLayout(null);

		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.getViewport().setBackground(Color.white);
		scrollPane1.setBackground(Color.WHITE);
		scrollPane1.setBounds(14, 63, 722, 103);
		panel_3.add(scrollPane1);

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
		scrollPane1.setViewportView(jtableFindBook);

		JLabel lblNewLabel_3 = new JLabel("Title");
		lblNewLabel_3.setBounds(11, 23, 45, 25);
		panel_3.add(lblNewLabel_3);

		jtextFieldTitle = new JTextField();
		jtextFieldTitle.setFont(new Font("Tahoma", Font.ITALIC, 18));
		jtextFieldTitle.setColumns(10);
		jtextFieldTitle.setBounds(54, 20, 275, 30);
		panel_3.add(jtextFieldTitle);

		JButton jbtnSearchTitle = new JButton("Search");
		jbtnSearchTitle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnSearchTitle_actionPerformed(e);
			}
		});
		jbtnSearchTitle.setIcon(new ImageIcon(invoicePanel.class.getResource("/data/icon/searchBook.png")));
		jbtnSearchTitle.setForeground(Color.WHITE);
		jbtnSearchTitle.setFont(new Font("Tahoma", Font.PLAIN, 22));
		jbtnSearchTitle.setBackground(new Color(30, 106, 210));
		jbtnSearchTitle.setBounds(337, 20, 125, 30);
		panel_3.add(jbtnSearchTitle);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Selected Book", TitledBorder.LEFT,
				TitledBorder.TOP, null, Color.BLACK));
		panel_4.setBackground(new Color(245, 244, 252));
		panel_4.setBounds(12, 203, 750, 159);
		jpanelBook.add(panel_4);
		panel_4.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.getViewport().setBackground(Color.white);
		scrollPane_1.setBackground(Color.WHITE);
		scrollPane_1.setBounds(14, 45, 722, 103);
		panel_4.add(scrollPane_1);

		jtableSelectedBook = new JTable();
		jtableSelectedBook.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtableSelectedBook.setForeground(Color.BLACK);
		scrollPane_1.setViewportView(jtableSelectedBook);

		JButton jbtnDeleteB = new JButton("Delete");
		jbtnDeleteB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnDeleteB_actionPerformed(e);
			}
		});
		jbtnDeleteB.setIcon(new ImageIcon(invoicePanel.class.getResource("/data/icon/delete.png")));
		jbtnDeleteB.setForeground(Color.WHITE);
		jbtnDeleteB.setBackground(new Color(30, 106, 210));
		jbtnDeleteB.setBounds(645, 13, 90, 26);
		panel_4.add(jbtnDeleteB);

		JLabel label_1 = new JLabel("Book Details");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		label_1.setBounds(305, 3, 143, 29);
		jpanelBook.add(label_1);

		JButton jbtnBorrowBook = new JButton("Borrow Book");
		jbtnBorrowBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnBorrowBook_actionPerformed(e);
			}
		});
		jbtnBorrowBook.setIcon(new ImageIcon(invoicePanel.class.getResource("/data/icon/borrowBook.png")));
		jbtnBorrowBook.setForeground(Color.WHITE);
		jbtnBorrowBook.setFont(new Font("Tahoma", Font.BOLD, 22));
		jbtnBorrowBook.setBackground(new Color(30, 106, 210));
		jbtnBorrowBook.setBounds(567, 12, 219, 37);
		jpanelissueBook.add(jbtnBorrowBook);

		loadDataFindBook();
		loadDataSelectedBook();
		loadDataBorrowedBook();
		loadDataReturningBook();
		loadDataBorrowBill();

		bookID.add("");
		bookLost.add("");
	}

	// Check Compensation fee
	public void jradiobuttonLost_mouseClicked(MouseEvent arg0) {
		if (jradiobuttonLost.isSelected()) {
			int selectedIndexRow = jtableBorrowedBook.getSelectedRow();
			String result = Double.toString(percent(selectedIndexRow));
			jtextFieldCompensationFee.setText("$" + result);
		}
	}

	// percent for Lost book
	public double percent(int selectedIndexRow) {
		String idBook = jtableBorrowedBook.getValueAt(selectedIndexRow, 1).toString();
		BooksModel booksModel = new BooksModel();
		double money = booksModel.getPrice(idBook);
		double percent = (money * 70) / 100;
		return percent;
	}

	// click Give Back and show into Returning Books
	public void jbtnGiveBack_actionPerformed(ActionEvent e) {
		int selectedIndexRow = jtableBorrowedBook.getSelectedRow();
		if(selectedIndexRow == -1) {
			JOptionPane.showMessageDialog(null, "Don't have any book to give back!", "Notification",
					JOptionPane.OK_OPTION);
		}else {
			int rows = jtableReturningBook.getRowCount();
			String idBook = jtableBorrowedBook.getValueAt(selectedIndexRow, 1).toString();
			String title = jtableBorrowedBook.getValueAt(selectedIndexRow, 2).toString();
			String returnDate = simpleDateFormat.format(jdateChooserReturnDate.getDate());
			int number = 1;
			for (int i = 0; i < rows; i++) {
				number++;
			}
			boolean flag = true;
			for (String id : bookID) {
				if (id == idBook) {
					JOptionPane.showMessageDialog(null, "You have chosen the book '" + title + "'!", "Notification",
							JOptionPane.OK_OPTION);
					flag = false;
				}
			}
			if (flag) {
				defaultTableModelReturningBook.addRow(new Object[] { number, idBook, title, returnDate });
				jtableReturningBook.setModel(defaultTableModelReturningBook);
				bookID.add(idBook);
				jtextFieldNumberofLateDate.setText("0");
				jtextFieldLateFee.setText("$0.0");
				jtextFieldCompensationFee.setText("$0.0");
				jtextFieldIDBook.setText("");
				jtextFieldCompensationFee.setText("$0.0");
				jradiobuttonReturn.setSelected(true);
			}
			if (getLateDate() > 0) {
				lateFee = getLateDate();
			} else {
				lateFee = 0;
			}
			if (jradiobuttonLost.isSelected()) {
				compendationFee += percent(selectedIndexRow);
				bookLost.add(idBook);
			}
		}		
	}

	// Check the card's expiry date
	public long getExpirationDate(String idCard) {
		try {
			long getDate;
			LibCardModel library_cardModel = new LibCardModel();
			Date endDate = library_cardModel.getExpirationDate(idCard);
			Date startDate = new Date();
			long date = endDate.getTime() - startDate.getTime();
			getDate = TimeUnit.MILLISECONDS.toDays(date);
			return getDate;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 0;
		}
	}

	// get number of date late
	public long getLateDate() {
		try {
			long getdate;
			int selectedIndexRow = jtableBorrowedBook.getSelectedRow();
			String returnDate = simpleDateFormat.format(jdateChooserReturnDate.getDate());
			String termDate = jtableBorrowedBook.getValueAt(selectedIndexRow, 3).toString();
			Date endDate = simpleDateFormat.parse(returnDate);
			Date startDate = simpleDateFormat.parse(termDate);
			long date = endDate.getTime() - startDate.getTime();
			getdate = TimeUnit.MILLISECONDS.toDays(date);
			return getdate;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 0;
		}
	}

	// click mouse select from Borrowed Books and show Info Check
	public void jtableBorrowedBook_mouseClicked(MouseEvent arg0) {
		jdateChooserReturnDate.setEnabled(false);
		int selectedIndexRow = jtableBorrowedBook.getSelectedRow();
		String idBook = jtableBorrowedBook.getValueAt(selectedIndexRow, 1).toString();
		jtextFieldIDBook.setText(idBook);
		jtextFieldCompensationFee.setText("$0.0");
		jradiobuttonReturn.setSelected(true);
		try {
			if (getLateDate() > 0) {
				long getDate = getLateDate();
				String day = Long.toString(getDate);
				jtextFieldNumberofLateDate.setText(day);
				long lateFee = getLateDate();
				String result = Long.toString(lateFee);
				jtextFieldLateFee.setText("$" + result);
			} else {
				jtextFieldNumberofLateDate.setText("0");
				jtextFieldLateFee.setText("$0.0");
				jtextFieldCompensationFee.setText("$0.0");
			}

		} catch (Exception e1) {
			System.err.println(e1.getMessage());
		}
	}

	// click mouse select from Find Books into Selected Books
	public void jtableFindBookmouseClicked(MouseEvent arg0) {

		try {
			int selectedIndexRowF = jtableFindBook.getSelectedRow();
			int rows = jtableSelectedBook.getRowCount();
			int number = 1;
			for (int i = 0; i < rows; i++) {
				number++;
			}
			String idBook = jtableFindBook.getValueAt(selectedIndexRowF, 1).toString();
			String title = jtableFindBook.getValueAt(selectedIndexRowF, 2).toString();
			String author = jtableFindBook.getValueAt(selectedIndexRowF, 3).toString();
			String status = jtableFindBook.getValueAt(selectedIndexRowF, 4).toString();
			Date createDate = jdateChooserCreateDate.getDate();
			String date = simpleDateFormat.format(createDate);
			boolean flag = true;
			if (defaultTableModelSelectedBook.getRowCount() < 5) {
				if (status == "Available") {
					for (String id : bookID) {
						if (id == idBook) {
							JOptionPane.showMessageDialog(null, "You have chosen the book '" + title + "'!",
									"Notification", JOptionPane.OK_OPTION);
							flag = false;
						}
					}
					if (flag) {
						defaultTableModelSelectedBook.addRow(new Object[] { number, idBook, title, author, date });
						jtableSelectedBook.setModel(defaultTableModelSelectedBook);
						if (jtableSelectedBook.getRowCount() > 0) {
							jdateChooserCreateDate.setEnabled(false);
						} else {
							jdateChooserCreateDate.setEnabled(true);
						}
						bookID.add(idBook);
					}
				} else {
					JOptionPane.showMessageDialog(null, "The book '" + title + "' is not available!", "Notification",
							JOptionPane.OK_OPTION);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Has enough amount of book!", "Notification",
						JOptionPane.OK_OPTION);
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	// Show ReturnBookDialog
	public void jbtnReturnBook_actionPerformed(ActionEvent arg0) {
		if (!jtextFieldIDCardR.getText().isEmpty() && defaultTableModelReturningBook.getRowCount() > 0) {
			try {
				int rowR = defaultTableModelReturningBook.getRowCount();
				int rowB = defaultTableModelBorrowedBook.getRowCount();
				if (rowR == rowB) {
					MemberModel memberModel = new MemberModel();
					member = memberModel.find(jtextFieldIDCardR.getText());
					ReturnBookDialog.idCard = jtextFieldIDCardR.getText();
					ReturnBookDialog.name = member.getName();
					ReturnBookDialog.date = jdateChooserReturnDate.getDate();
					ReturnBookDialog.lateFee = lateFee * defaultTableModelReturningBook.getRowCount();
					ReturnBookDialog.librarian = employee.getName();
					ReturnBookDialog.idBook = new ArrayList<String>();
					ReturnBookDialog.title = new ArrayList<String>();
					ReturnBookDialog.bookLost = new ArrayList<String>();
					for (int i = 0; i < bookLost.size(); i++) {
						ReturnBookDialog.bookLost.add(bookLost.get(i));
					}
					ReturnBookDialog.compensationFee = compendationFee;
					for (int i = 0; i < defaultTableModelReturningBook.getRowCount(); i++) {
						ReturnBookDialog.idBook.add(defaultTableModelReturningBook.getValueAt(i, 1).toString());
					}
					for (int i = 0; i < defaultTableModelReturningBook.getRowCount(); i++) {
						ReturnBookDialog.title.add(defaultTableModelReturningBook.getValueAt(i, 2).toString());
					}
					ReturnBookDialog returnBookDialog = new ReturnBookDialog();
					returnBookDialog.setVisible(true);
				} else if (rowR < rowB && rowR > 0) {
					JOptionPane.showMessageDialog(null, "Not enough books to return!", "Notification",
							JOptionPane.OK_OPTION);
				} else {
					JOptionPane.showMessageDialog(null, "Please select the book to return!", "Notification",
							JOptionPane.OK_OPTION);
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Required to enter information!", "Notification",
					JOptionPane.OK_OPTION);
		}
	}

	// Show BorrowBookDialog
	public void jbtnBorrowBook_actionPerformed(ActionEvent e) {
		Borrow_billModel borrow_billModel = new Borrow_billModel();
		MemberModel memberModel = new MemberModel();
		String idCard = jtextFieldIDCardB.getText();
		String member_ID = memberModel.getMemberID(idCard);
		if (!jtextFieldName.getText().isEmpty() && defaultTableModelSelectedBook.getRowCount() > 0) {
			if (getExpirationDate(jtextFieldIDCardB.getText()) < 0) {
				JOptionPane.showMessageDialog(null, "The card has expired!", "Notification", JOptionPane.OK_OPTION);

			} else if (borrow_billModel.countNotReturn(member_ID) == 1) {
				JOptionPane.showMessageDialog(null, "Return the book before borrowing, please!", "Notification",
						JOptionPane.OK_OPTION);
			} else {
				Date createDate = jdateChooserCreateDate.getDate();
				BorrowBookDialog.idCard = jtextFieldIDCardB.getText();
				BorrowBookDialog.name = jtextFieldName.getText();
				BorrowBookDialog.date = createDate;
				BorrowBookDialog.member = member;
				BorrowBookDialog.employeeMain = employee;
				BorrowBookDialog.idBook = new ArrayList<String>();
				BorrowBookDialog.title = new ArrayList<String>();
				for (int i = 0; i < defaultTableModelSelectedBook.getRowCount(); i++) {
					BorrowBookDialog.idBook.add(defaultTableModelSelectedBook.getValueAt(i, 1).toString());
				}
				for (int i = 0; i < defaultTableModelSelectedBook.getRowCount(); i++) {
					BorrowBookDialog.title.add(defaultTableModelSelectedBook.getValueAt(i, 2).toString());
				}
				BorrowBookDialog BorrowBookDialog = new BorrowBookDialog();
				BorrowBookDialog.setVisible(true);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Required to enter information!", "Notification",
					JOptionPane.OK_OPTION);
		}
	}

	// Remove 1 row of Returning Books: Delete button
	public void jbtnDeleteR_actionPerformed(ActionEvent arg0) {

		int number = 1;
		int selectedIndexRow = jtableReturningBook.getSelectedRow();
		if (selectedIndexRow == -1) {
			JOptionPane.showMessageDialog(null, "No book is select!", "Notification", JOptionPane.OK_OPTION);
		} else {
			String idBook = jtableReturningBook.getValueAt(selectedIndexRow, 1).toString();
			if (jtableReturningBook.isRowSelected(selectedIndexRow)) {
				for (int i = 0; i < bookLost.size(); i++) {
					if (idBook.equals(bookLost.get(i))) {
						bookLost.remove(idBook);
						compendationFee -= percent(selectedIndexRow);

					} else {
						compendationFee -= 0;
					}
				}
			}
			for (int i = 0; i < bookID.size(); i++) {
				if (idBook.equals(bookID.get(i))) {
					bookID.remove(i);
				}
			}
			defaultTableModelReturningBook.removeRow(selectedIndexRow);
			jtableReturningBook.setModel(defaultTableModelReturningBook);
			for (int i = 0; i < defaultTableModelReturningBook.getRowCount(); i++) {
				jtableReturningBook.setValueAt(number, i, 0);
				number++;
			}
			if (jtableReturningBook.getRowCount() == 0) {
				jdateChooserReturnDate.setEnabled(true);
			}
		}
	}

	// Remove 1 row of Selected Books: Delete button
	public void jbtnDeleteB_actionPerformed(ActionEvent e) {
		int number = 1;
		int selectedIndexRow = jtableSelectedBook.getSelectedRow();
		if (selectedIndexRow == -1) {
			JOptionPane.showMessageDialog(null, "No book is select", "Notification", JOptionPane.OK_OPTION);
		} else {
			String idBook = jtableSelectedBook.getValueAt(selectedIndexRow, 1).toString();
			for (int i = 0; i < bookID.size(); i++) {
				if (idBook.equals(bookID.get(i))) {
					bookID.remove(i);

				}
			}
			defaultTableModelSelectedBook.removeRow(selectedIndexRow);
			jtableSelectedBook.setModel(defaultTableModelSelectedBook);
			if (jtableSelectedBook.getRowCount() == 0) {
				jdateChooserCreateDate.setEnabled(true);
			}
			for (int i = 0; i < defaultTableModelSelectedBook.getRowCount(); i++) {
				jtableSelectedBook.setValueAt(number, i, 0);
				number++;
			}
		}
	}

	// Search "Title" for Book Details of BORROW BOOK
	public void jbtnSearchTitle_actionPerformed(ActionEvent e) {
		String title = jtextFieldTitle.getText().toLowerCase().trim();
		defaultTableModelFindBook.getDataVector().removeAllElements();
		defaultTableModelFindBook.fireTableDataChanged();
		if (!title.isEmpty()) {
			BooksModel bookModel = new BooksModel();
			AuthorModel authorModel = new AuthorModel();
			Bor_bookModel bor_bookModel = new Bor_bookModel();
			List<Books> books = bookModel.searchBooks(title);
			int number = 1;
			String status = null;
			String au = null;
			for (Books book : books) {
				if (bor_bookModel.count(2, book.getBook_ID()) < book.getQuantity()) {
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

	// Search "ID Card" of Return Book
	public void jbtnSearchIDCardR_actionPerformed(ActionEvent arg0) {
		jdateChooserReturnDate.setEnabled(true);
		ReturnBookDialog.compensationFee = 0;
		/* refresh */
		defaultTableModelBorrowedBook.getDataVector().removeAllElements();
		defaultTableModelBorrowedBook.fireTableDataChanged();
		defaultTableModelReturningBook.getDataVector().removeAllElements();
		defaultTableModelReturningBook.fireTableDataChanged();
		jtextFieldIDBook.setText(null);
		jtextFieldNumberofLateDate.setText(null);
		jtextFieldLateFee.setText(null);
		jradiobuttonReturn.isSelected();
		jtextFieldCompensationFee.setText(null);
		/**/
		String idCard = jtextFieldIDCardR.getText();
		if (!idCard.isEmpty()) {
			MemberModel memberModel = new MemberModel();
			Member IDCard = memberModel.find(idCard);
			if (IDCard == null) {
				JOptionPane.showMessageDialog(null, "ID Card does not exist or has expired!", "Notification",
						JOptionPane.OK_OPTION);
			} else {
				BooksModel booksModel = new BooksModel();
				Borrow_billModel borrow_billModel = new Borrow_billModel();
				int number = 1;
				String title = null;
				String idBook = null;
				int borrow_ID = 0;
				Borrow_bill borrow_bill = borrow_billModel.showBorrowBook(idCard, 2);
				if(borrow_bill != null) {
					borrow_ID = borrow_bill.getBorrow_ID();
					for (Books book : booksModel.getTitleBook(borrow_ID, 2)) {
						title = book.getTitle();
						idBook = book.getBook_ID();
						defaultTableModelBorrowedBook.addRow(new Object[] { number++, idBook, title,
								simpleDateFormat.format(borrow_bill.getTerm_date()) });
					}
					jtableBorrowedBook.setModel(defaultTableModelBorrowedBook);
				}else {
					JOptionPane.showMessageDialog(null, "Does have any bill!", "Notification", JOptionPane.OK_OPTION);
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "ID Card required, please!", "Notification", JOptionPane.OK_OPTION);
		}
	}

	// Search "ID Card" of Borrow Book
	public void jbtnSearchIDCardB_actionPerformed(ActionEvent arg0) {
		jdateChooserCreateDate.setEnabled(true);
		defaultTableModelFindBook.getDataVector().removeAllElements();
		defaultTableModelFindBook.fireTableDataChanged();
		defaultTableModelSelectedBook.getDataVector().removeAllElements();
		defaultTableModelSelectedBook.fireTableDataChanged();
		jtextFieldTitle.setText("");
		String idCard = jtextFieldIDCardB.getText();
		if (!idCard.isEmpty()) {
			Borrow_billModel borrow_billModel = new Borrow_billModel();
			MemberModel memberModel = new MemberModel();
			String member_ID = memberModel.getMemberID(idCard);
			member = memberModel.find(idCard);
			if (member == null) {
				jtextFieldName.setText("");
				JOptionPane.showMessageDialog(null, "ID Card does not exist!", "Notification", JOptionPane.OK_OPTION);
			} else if (getExpirationDate(idCard) < 0) {
				String name = member.getName();
				String photo = member.getPhoto().toString();
				jtextFieldName.setText(name);
				ImageIcon icon = resizeImg(photo, jlabelImage);
				jlabelImage.setIcon(icon);
				JOptionPane.showMessageDialog(null, "The card has expired!", "Notification", JOptionPane.OK_OPTION);
			} else if (borrow_billModel.countNotReturn(member_ID) == 1) {
				JOptionPane.showMessageDialog(null, "Return the book before borrowing, please!", "Notification",
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

	// Returning Book header
	public void loadDataReturningBook() {
		String[] columns = { "No.", "ID Book", "Title", "Return date" };
		defaultTableModelReturningBook.setColumnIdentifiers(columns);
		jtableReturningBook.setModel(defaultTableModelReturningBook);
		jtableReturningBook.getTableHeader().setResizingAllowed(false);
		jtableReturningBook.getTableHeader().setReorderingAllowed(false);
		// set width
		TableColumnModel columnModel = jtableReturningBook.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(40);
		columnModel.getColumn(1).setPreferredWidth(70);
		columnModel.getColumn(2).setPreferredWidth(230);
		columnModel.getColumn(3).setPreferredWidth(88);
		// set color
		JTableHeader header = jtableReturningBook.getTableHeader();
		header.setBackground(new Color(223, 233, 242));
		header.setForeground(Color.BLACK);
	}

	// Borrowed Book header
	public void loadDataBorrowedBook() {
		String[] columns = { "No.", "ID Book", "Title", "Term date" };
		defaultTableModelBorrowedBook.setColumnIdentifiers(columns);
		jtableBorrowedBook.setModel(defaultTableModelBorrowedBook);
		jtableBorrowedBook.getTableHeader().setResizingAllowed(false);
		jtableBorrowedBook.getTableHeader().setReorderingAllowed(false);
		// set width
		TableColumnModel columnModel = jtableBorrowedBook.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(40);
		columnModel.getColumn(1).setPreferredWidth(70);
		columnModel.getColumn(2).setPreferredWidth(230);
		columnModel.getColumn(3).setPreferredWidth(88);
		// set color
		JTableHeader header = jtableBorrowedBook.getTableHeader();
		header.setBackground(new Color(223, 233, 242));
		header.setForeground(Color.BLACK);
	}

	// Find Books header
	public void loadDataFindBook() {
		String[] columns = { "No.", "ID Book", "Title", "Author", "Status" };
		defaultTableModelFindBook.setColumnIdentifiers(columns);
		jtableFindBook.setModel(defaultTableModelFindBook);
		jtableFindBook.getTableHeader().setResizingAllowed(false);
		jtableFindBook.getTableHeader().setReorderingAllowed(false);
		// set width
		TableColumnModel columnModel = jtableFindBook.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(50);
		columnModel.getColumn(1).setPreferredWidth(100);
		columnModel.getColumn(2).setPreferredWidth(300);
		columnModel.getColumn(3).setPreferredWidth(180);
		columnModel.getColumn(4).setPreferredWidth(92);
		// set color
		JTableHeader header = jtableFindBook.getTableHeader();
		header.setBackground(new Color(223, 233, 242));
		header.setForeground(Color.BLACK);
	}

	// Selected Books header
	public void loadDataSelectedBook() {
		String[] columns = { "No.", "ID Book", "Title", "Author", "Borrow date" };
		defaultTableModelSelectedBook.setColumnIdentifiers(columns);
		jtableSelectedBook.setModel(defaultTableModelSelectedBook);
		jtableSelectedBook.getTableHeader().setReorderingAllowed(false);
		jtableSelectedBook.getTableHeader().setResizingAllowed(false);
		// set width
		TableColumnModel columnModel = jtableSelectedBook.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(50);
		columnModel.getColumn(1).setPreferredWidth(100);
		columnModel.getColumn(2).setPreferredWidth(300);
		columnModel.getColumn(3).setPreferredWidth(180);
		columnModel.getColumn(4).setPreferredWidth(92);
		// set color
		JTableHeader header = jtableSelectedBook.getTableHeader();
		header.setBackground(new Color(223, 233, 242));
		header.setForeground(Color.BLACK);
	}

	// Start NVT
	public void btnDelete_actionPerformed(ActionEvent e) {
		int selectedIndex = tableBorrowBill.getSelectedRow();
		Borrow_billModel borrow_billModel = new Borrow_billModel();
		Bor_bookModel bor_bookModel = new Bor_bookModel();

		if (selectedIndex != -1) {
			int borrow_ID = (int) tableBorrowBill.getValueAt(selectedIndex, 1);
			int result = JOptionPane.showConfirmDialog(null, "Are you sure ? ", "Comfirm", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				if (bor_bookModel.delete(borrow_ID)) {
					if (borrow_billModel.delete(borrow_ID)) {
						loadDataBorrowBill();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Failed");
				}
			}

		} else {
			JOptionPane.showMessageDialog(null, "Required to selected a bill !", "Notification", JOptionPane.OK_OPTION);
		}
	}

	public void btnDetails_actionPerformed(ActionEvent e) {
		int selectedIndex = tableBorrowBill.getSelectedRow();
		if (selectedIndex != -1) {
			int borrow_ID = (int) tableBorrowBill.getValueAt(selectedIndex, 1);
			System.out.println(borrow_ID);

			Borrow_billModel borrow_billModel = new Borrow_billModel();
			Borrow_bill bill = borrow_billModel.findByID(borrow_ID);

			BooksModel booksModel = new BooksModel();
			List<Books> books = booksModel.findByBill(borrow_ID);

			MemberModel memberModel = new MemberModel();
			Member member = memberModel.findByID(bill.getMember_ID());

			List<String> authorNames = new ArrayList<String>();
			for (Books book : books) {
				String authorName = "";
				int lengthAu = booksModel.findAuthor(book.getBook_ID()).size();
				for (Author author : booksModel.findAuthor(book.getBook_ID())) {
					authorName += author.getName();
					if (lengthAu > 1) {
						authorName += " & ";
						lengthAu--;
					}
				}
				authorNames.add(authorName);
			}

			BorrowDetailDailog.books = new ArrayList<Books>();
			BorrowDetailDailog.books = books;
			BorrowDetailDailog.member = member;
			BorrowDetailDailog.borrowbill = bill;
			BorrowDetailDailog.authorNames = new ArrayList<String>();
			BorrowDetailDailog.authorNames = authorNames;

			BorrowDetailDailog borrowDetailDailog = new BorrowDetailDailog();
			borrowDetailDailog.setVisible(true);

		} else {
			JOptionPane.showMessageDialog(null, "Required to selected a bill !", "Notification", JOptionPane.OK_OPTION);
		}

	}

	public void btnSearch_mouseClicked(MouseEvent e) {
		int month = monthChooser.getMonth() + 1;
		int year = yearChooser.getYear();
		loadWidthTable();
		BooksModel bookModel = new BooksModel();
		AuthorModel authorModel = new AuthorModel();
		MemberModel memberModel = new MemberModel();
		Borrow_billModel borrow_billModel = new Borrow_billModel();
		List<Borrow_bill> borrowbills = borrow_billModel.findByDate(month, year);
		int number = 1;
		String status = "";
		for (Borrow_bill bill : borrowbills) {
			double forfeit_fee = bill.getLate_fee() + bill.getCompensation_fee();
			String memberName = memberModel.findByID(bill.getMember_ID()).getName();
			int totalBook = borrow_billModel.countBook(bill.getBorrow_ID());
			if (bill.isStatus()) {
				status = "Returned";
			} else {
				status = "Not Returned";
			}

			defaultTableModelBorrowBill.addRow(new Object[] { number++, bill.getBorrow_ID(), memberName, totalBook,
					bill.getBorrow_date(), bill.getTerm_date(), bill.getReturn_date(), forfeit_fee, status });
			tableBorrowBill.setModel(defaultTableModelBorrowBill);
		}

	}

	public void loadWidthTable() {
		String[] borrowColumn = { "No.", "Borrow ID", "Member Name", "Amount", "Borrow Date", "Term Date",
				"Return Date", "Forfeit fee ", "Status" };
		defaultTableModelBorrowBill = new DefaultTableModel();
		for (String cl : borrowColumn) {
			defaultTableModelBorrowBill.addColumn(cl);
		}
		tableBorrowBill.setModel(defaultTableModelBorrowBill);
		tableBorrowBill.getTableHeader().setReorderingAllowed(false);
		tableBorrowBill.getTableHeader().setResizingAllowed(false);
		// set width
		TableColumnModel columnModel = tableBorrowBill.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(50);
		columnModel.getColumn(1).setPreferredWidth(75);
		columnModel.getColumn(2).setPreferredWidth(170);
		columnModel.getColumn(3).setPreferredWidth(75);
		columnModel.getColumn(4).setPreferredWidth(90);
		columnModel.getColumn(5).setPreferredWidth(90);
		columnModel.getColumn(6).setPreferredWidth(90);
		columnModel.getColumn(7).setPreferredWidth(90);
		columnModel.getColumn(8).setPreferredWidth(90);
		JTableHeader tableBorrowBillHeader = tableBorrowBill.getTableHeader();
		tableBorrowBillHeader.setBackground(new Color(223, 233, 242));
		tableBorrowBillHeader.setForeground(Color.BLACK);
	}

	public void loadDataBorrowBill() {
		// set Data
		loadWidthTable();
		BooksModel bookModel = new BooksModel();
		AuthorModel authorModel = new AuthorModel();
		MemberModel memberModel = new MemberModel();
		Borrow_billModel borrow_billModel = new Borrow_billModel();
		List<Borrow_bill> borrowbills = borrow_billModel.findAll();

		int number = 1;
		String status = "";
		for (Borrow_bill bill : borrowbills) {
			double forfeit_fee = bill.getLate_fee() + bill.getCompensation_fee();
			String memberName = memberModel.findByID(bill.getMember_ID()).getName();
			int totalBook = borrow_billModel.countBook(bill.getBorrow_ID());
			if (bill.isStatus()) {
				status = "Returned";
			} else {
				status = "Not Returned";
			}

			defaultTableModelBorrowBill.addRow(new Object[] { number++, bill.getBorrow_ID(), memberName, totalBook,
					bill.getBorrow_date(), bill.getTerm_date(), bill.getReturn_date(), forfeit_fee, status });
			tableBorrowBill.setModel(defaultTableModelBorrowBill);
		}
	}

	// Resize Image
	private ImageIcon resizeImg(String imgPath, JLabel jName) {
		if (imgPath != null) {
			ImageIcon myImg = null;
			myImg = new ImageIcon(imgPath);
			Image img = myImg.getImage();
			Image img2 = img.getScaledInstance(jName.getWidth(), jName.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(img2);
			return icon;
		} else {
			return null;
		}
	}
}
