package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import com.mysql.cj.x.protobuf.Mysqlx.Ok;

import entities.Books;
import entities.Bor_book;
import entities.Borrow_bill;
import entities.Employee;
import entities.Member;
import model.Bor_bookModel;
import model.Borrow_billModel;
import model.MemberModel;
import model.generalClass;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class BorrowBookDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField jtextFieldLibrarian;
	private JTextField jtextFieldIDCard;
	public static JTextField jtextFieldName;
	private JTextField jtextFieldDateBorrow;
	private JTextField jtextFieldTermDate;
	private JTable jtableListofBookBorrow;
	private JTextField jtextFieldDepositFee;
	private double depositFee = 0;

	DefaultTableModel defaultTableModelListBook = new DefaultTableModel() {
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};
	generalClass general = new generalClass();
	public static Employee employeeMain = null;
	public static Member member;
	public static String idCard;
	public static List<String> idBook = null;
	public static List<String> title = null;
	public static Date date;
	public static String name;
	public static String librarian = null;
	private JButton jbtnBack;

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BorrowBookDialog dialog = new BorrowBookDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BorrowBookDialog() {
		setLocationByPlatform(true);
		setModal(true);
		setUndecorated(true);
		setBounds(100, 100, 407, 434);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 204));
		panel.setBounds(0, 0, 407, 45);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Borrow Book Details");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(85, 8, 236, 29);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(173, 216, 255));
		panel_1.setBounds(0, 43, 407, 390);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 244, 252));
		panel_2.setBounds(21, 0, 365, 329);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel jlabelImage = new JLabel("");
		jlabelImage.setBorder(new LineBorder(Color.WHITE));
		jlabelImage.setBackground(Color.WHITE);
		jlabelImage.setBounds(215, 10, 138, 127);
		panel_2.add(jlabelImage);

		JLabel lblIdCard = new JLabel("Librarian");
		lblIdCard.setBounds(10, 10, 252, 25);
		panel_2.add(lblIdCard);

		jtextFieldLibrarian = new JTextField();
		jtextFieldLibrarian.setEditable(false);
		jtextFieldLibrarian.setColumns(10);
		jtextFieldLibrarian.setBackground(Color.WHITE);
		jtextFieldLibrarian.setBounds(10, 29, 197, 30);
		panel_2.add(jtextFieldLibrarian);

		JLabel lblName = new JLabel("ID Card");
		lblName.setBounds(10, 59, 252, 25);
		panel_2.add(lblName);

		jtextFieldIDCard = new JTextField();
		jtextFieldIDCard.setEditable(false);
		jtextFieldIDCard.setColumns(10);
		jtextFieldIDCard.setBackground(Color.WHITE);
		jtextFieldIDCard.setBounds(10, 78, 197, 30);
		panel_2.add(jtextFieldIDCard);

		jtextFieldName = new JTextField();
		jtextFieldName.setHorizontalAlignment(SwingConstants.CENTER);
		jtextFieldName.setEditable(false);
		jtextFieldName.setColumns(10);
		jtextFieldName.setBackground(new Color(245, 244, 252));
		jtextFieldName.setBounds(215, 138, 138, 20);
		panel_2.add(jtextFieldName);

		JLabel lblDateBorrowed = new JLabel("Date borrow");
		lblDateBorrowed.setBounds(10, 157, 165, 25);
		panel_2.add(lblDateBorrowed);

		JLabel lblDateReturned = new JLabel("Term date");
		lblDateReturned.setBounds(188, 157, 165, 25);
		panel_2.add(lblDateReturned);

		jtextFieldDateBorrow = new JTextField();
		jtextFieldDateBorrow.setEditable(false);
		jtextFieldDateBorrow.setColumns(10);
		jtextFieldDateBorrow.setBackground(Color.WHITE);
		jtextFieldDateBorrow.setBounds(10, 177, 165, 30);
		panel_2.add(jtextFieldDateBorrow);

		jtextFieldTermDate = new JTextField();
		jtextFieldTermDate.setEditable(false);
		jtextFieldTermDate.setColumns(10);
		jtextFieldTermDate.setBackground(Color.WHITE);
		jtextFieldTermDate.setBounds(188, 177, 165, 30);
		panel_2.add(jtextFieldTermDate);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 217, 343, 103);
		panel_2.add(scrollPane);

		jtableListofBookBorrow = new JTable();
		scrollPane.setViewportView(jtableListofBookBorrow);

		JLabel label = new JLabel("Deposit fee");
		label.setBounds(10, 108, 252, 25);
		panel_2.add(label);

		jtextFieldDepositFee = new JTextField();
		jtextFieldDepositFee.setEditable(false);
		jtextFieldDepositFee.setColumns(10);
		jtextFieldDepositFee.setBackground(Color.WHITE);
		jtextFieldDepositFee.setBounds(10, 128, 197, 30);
		panel_2.add(jtextFieldDepositFee);
		scrollPane.getViewport().setBackground(Color.WHITE);

		JButton jbtnBorrow = new JButton("Borrow");
		jbtnBorrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnBorrow_actionPerformed(e);
			}
		});
		jbtnBorrow.setForeground(Color.WHITE);
		jbtnBorrow.setBackground(new Color(30, 106, 210));
		jbtnBorrow.setBounds(285, 340, 100, 30);
		panel_1.add(jbtnBorrow);

		jbtnBack = new JButton("Back");
		jbtnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jbtnBack_actionPerformed(arg0);
			}
		});
		jbtnBack.setForeground(Color.WHITE);
		jbtnBack.setBackground(new Color(30, 106, 210));
		jbtnBack.setBounds(176, 340, 100, 30);
		panel_1.add(jbtnBack);

		loadDataBook();
		showInformation();
	}

	// Insert database
	public void jbtnBorrow_actionPerformed(ActionEvent e) {
		// Insert into borrow_bill
		MemberModel memberModel = new MemberModel();
		Borrow_bill borrow_bill = new Borrow_bill();
		Borrow_billModel borrow_billModel = new Borrow_billModel();
		Member member = memberModel.find(idCard);
		Date termDate = plusDate(date);
		int fee = idBook.size();
		Double depositFee = Double.valueOf(fee);
		borrow_bill.setMember_ID(member.getMember_ID());
		borrow_bill.setEmployee_ID(employeeMain.getEmployee_ID());
		borrow_bill.setStatus(false);
		borrow_bill.setBorrow_date(new java.sql.Date(date.getTime()));
		borrow_bill.setTerm_date(new java.sql.Date(termDate.getTime()));
		borrow_bill.setDeposit_fee(depositFee);
		if (borrow_billModel.create(borrow_bill)) {
			JOptionPane.showMessageDialog(null, "Successful!", "Notification", JOptionPane.OK_OPTION);
		} else {
			JOptionPane.showMessageDialog(null, "Failed", "Notification", JOptionPane.OK_OPTION);
		}

		// Insert into bor_book
		Bor_book bor_book = new Bor_book();
		Bor_bookModel bor_bookModel = new Bor_bookModel();
		int borrow_ID = borrow_billModel.getBorrowId();
		String idBookString = null;
		int status = 2;
		for (int i = 0; i < BorrowBookDialog.idBook.size(); i++) {
			idBookString = idBook.get(i);
			bor_book.setBook_ID(idBookString);
			bor_book.setBorrow_ID(borrow_ID);
			bor_book.setStatus(status);
			bor_bookModel.create(bor_book);
		}
		
		this.dispose();
		setVisible(false);
	}

	// List of Borrow Book header
	public void loadDataBook() {
		defaultTableModelListBook.getDataVector().removeAllElements();
		defaultTableModelListBook.fireTableDataChanged();

		String[] columns = { "No.", "ID Book", "Title" };
		defaultTableModelListBook.setColumnIdentifiers(columns);
		jtableListofBookBorrow.setModel(defaultTableModelListBook);
		jtableListofBookBorrow.getTableHeader().setReorderingAllowed(false);
		jtableListofBookBorrow.getTableHeader().setResizingAllowed(false);
		// set width
		TableColumnModel columnModel = jtableListofBookBorrow.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(40);
		columnModel.getColumn(1).setPreferredWidth(73);
		columnModel.getColumn(2).setPreferredWidth(230);
		// set color
		JTableHeader header = jtableListofBookBorrow.getTableHeader();
		header.setBackground(new Color(223, 233, 242));
		header.setForeground(Color.BLACK);
	}

	// Show all Information when borrow
	public void showInformation() {
		int number = 1;
		String createDate = simpleDateFormat.format(date);
		String termDate = simpleDateFormat.format(plusDate(date));
		depositFee = idBook.size();
		String idBookString = null;
		String titleString = null;
		jtextFieldLibrarian.setText(employeeMain.getName());
		jtextFieldIDCard.setText(idCard);
		jtextFieldName.setText(name);
		jtextFieldDepositFee.setText("$" + depositFee);
		jtextFieldDateBorrow.setText(createDate);
		jtextFieldTermDate.setText(termDate);
		for (int i = 0; i < idBook.size(); i++) {
			idBookString = idBook.get(i);
			titleString = title.get(i);
			defaultTableModelListBook.addRow(new Object[] { number++, idBookString, titleString });
			jtableListofBookBorrow.setModel(defaultTableModelListBook);
		}
	}

	public static Date plusDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, 5);
		date = c.getTime();
		return date;
	}

	// Click button to back jframe
	public void jbtnBack_actionPerformed(ActionEvent arg0) {
		jtableListofBookBorrow.removeAll();
		this.dispose();
		setVisible(false);
	}
}
