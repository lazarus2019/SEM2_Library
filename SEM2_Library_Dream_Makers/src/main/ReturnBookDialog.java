package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import entities.Borrow_bill;
import model.BooksModel;
import model.Bor_bookModel;
import model.Borrow_billModel;
import model.MemberModel;

import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ReturnBookDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField jtextFieldLibrarian;
	private JTextField jtextFieldIDCard;
	private JTextField jtextFieldDateReturn;
	private JTextField jtextFieldLateFee;
	private JTextField jtextFieldName;
	private JTextField jtextFieldCompensationFee;
	private JTable jtableListofBookReturn;

	public static String idCard;
	public static Date date;
	public static String name;
	public static double lateFee;
	public static String status;
	public static double compensationFee;
	public static String librarian = null;
	public static List<String> idBook = null;
	public static List<String> title = null;
	public static List<String> bookLost = null;

	DefaultTableModel defaultTableModelListBook = new DefaultTableModel() {
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};

	
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReturnBookDialog dialog = new ReturnBookDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReturnBookDialog() {
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

		JLabel lblNewLabel = new JLabel("Return Book Details");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(86, 8, 234, 29);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(173, 216, 255));
		panel_1.setBounds(0, 43, 407, 391);
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

		JLabel lblName = new JLabel("ID Card");
		lblName.setBounds(10, 59, 252, 25);
		panel_2.add(lblName);

		JLabel lblDateBorrowed = new JLabel("Date Return");
		lblDateBorrowed.setBounds(10, 108, 252, 25);
		panel_2.add(lblDateBorrowed);

		jtextFieldLibrarian = new JTextField();
		jtextFieldLibrarian.setEditable(false);
		jtextFieldLibrarian.setColumns(10);
		jtextFieldLibrarian.setBackground(Color.WHITE);
		jtextFieldLibrarian.setBounds(10, 29, 197, 30);
		panel_2.add(jtextFieldLibrarian);

		jtextFieldIDCard = new JTextField();
		jtextFieldIDCard.setEditable(false);
		jtextFieldIDCard.setColumns(10);
		jtextFieldIDCard.setBackground(Color.WHITE);
		jtextFieldIDCard.setBounds(10, 78, 197, 30);
		panel_2.add(jtextFieldIDCard);

		jtextFieldDateReturn = new JTextField();
		jtextFieldDateReturn.setEditable(false);
		jtextFieldDateReturn.setColumns(10);
		jtextFieldDateReturn.setBackground(Color.WHITE);
		jtextFieldDateReturn.setBounds(10, 128, 197, 30);
		panel_2.add(jtextFieldDateReturn);

		JLabel lblLateFee = new JLabel("Late fee");
		lblLateFee.setBounds(10, 157, 165, 25);
		panel_2.add(lblLateFee);

		jtextFieldLateFee = new JTextField();
		jtextFieldLateFee.setEditable(false);
		jtextFieldLateFee.setColumns(10);
		jtextFieldLateFee.setBackground(Color.WHITE);
		jtextFieldLateFee.setBounds(10, 177, 165, 30);
		panel_2.add(jtextFieldLateFee);

		jtextFieldName = new JTextField();
		jtextFieldName.setHorizontalAlignment(SwingConstants.CENTER);
		jtextFieldName.setEditable(false);
		jtextFieldName.setColumns(10);
		jtextFieldName.setBackground(new Color(245, 244, 252));
		jtextFieldName.setBounds(215, 138, 138, 20);
		panel_2.add(jtextFieldName);

		JLabel lblCompensationFee = new JLabel("Compensation Fee");
		lblCompensationFee.setBounds(190, 157, 165, 25);
		panel_2.add(lblCompensationFee);

		jtextFieldCompensationFee = new JTextField();
		jtextFieldCompensationFee.setEditable(false);
		jtextFieldCompensationFee.setColumns(10);
		jtextFieldCompensationFee.setBackground(Color.WHITE);
		jtextFieldCompensationFee.setBounds(190, 177, 165, 30);
		panel_2.add(jtextFieldCompensationFee);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 217, 343, 103);
		panel_2.add(scrollPane);

		jtableListofBookReturn = new JTable();
		scrollPane.setViewportView(jtableListofBookReturn);
		scrollPane.getViewport().setBackground(Color.WHITE);

		JButton jbtnReturn = new JButton("Return");
		jbtnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jbtnReturn_actionPerformed(arg0);
			}
		});
		jbtnReturn.setForeground(Color.WHITE);
		jbtnReturn.setBackground(new Color(30, 106, 210));
		jbtnReturn.setBounds(286, 341, 100, 30);
		panel_1.add(jbtnReturn);

		JButton jbtnBack = new JButton("Back");
		jbtnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jbtnBack_actionPerformed(arg0);
			}
		});
		jbtnBack.setForeground(Color.WHITE);
		jbtnBack.setBackground(new Color(30, 106, 210));
		jbtnBack.setBounds(176, 341, 100, 30);
		panel_1.add(jbtnBack);

		loadDataBook();
		showInformation();
	}

	// Update database
	public void jbtnReturn_actionPerformed(ActionEvent arg0) {
		// update borrow_bill
		Borrow_bill borrow_bill = new Borrow_bill();
		Borrow_billModel borrow_billModel = new Borrow_billModel();
		MemberModel memberModel = new MemberModel();
		String member_ID = memberModel.getMemberID(idCard);
		borrow_bill.setStatus(true);
		borrow_bill.setReturn_date(new java.sql.Date(date.getTime()));
		borrow_bill.setLate_fee(lateFee);
		borrow_bill.setCompensation_fee(compensationFee);
		if (borrow_billModel.update(borrow_bill, member_ID)) {
			JOptionPane.showMessageDialog(null, "Successful!", "Notification", JOptionPane.OK_OPTION);
		} else {
			JOptionPane.showMessageDialog(null, "Failed", "Notification", JOptionPane.OK_OPTION);
		}

		// update bor_book
		Bor_bookModel bor_bookModel = new Bor_bookModel();
		int borrow_ID = borrow_billModel.getReturnId(member_ID, false);
		int status = 1;
		bor_bookModel.update(status, borrow_ID);
		
		//update quantity of Books when Lost
		BooksModel booksModel = new BooksModel();
		for(String idBookLost : bookLost) {
			booksModel.updateBookLost(idBookLost);			
		}

		
		this.dispose();
		setVisible(false);
	}

	// List of Return Book header
	public void loadDataBook() {
		defaultTableModelListBook.getDataVector().removeAllElements();
		defaultTableModelListBook.fireTableDataChanged();
		String[] columns = { "No.", "ID Book", "Title" };
		defaultTableModelListBook.setColumnIdentifiers(columns);
		jtableListofBookReturn.setModel(defaultTableModelListBook);
		jtableListofBookReturn.getTableHeader().setReorderingAllowed(false);
		jtableListofBookReturn.getTableHeader().setResizingAllowed(false);
		// set width
		TableColumnModel columnModel = jtableListofBookReturn.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(40);
		columnModel.getColumn(1).setPreferredWidth(73);
		columnModel.getColumn(2).setPreferredWidth(230);
		// set color
		JTableHeader header = jtableListofBookReturn.getTableHeader();
		header.setBackground(new Color(223, 233, 242));
		header.setForeground(Color.BLACK);
	}

	// Show all Information when return
	public void showInformation() {
		int number = 1;
		String idBook = null;
		String title = null;
		String lateFeeString = Double.toString(lateFee);
		String compensationFeeString = Double.toString(compensationFee);
		jtextFieldLibrarian.setText(librarian);
		jtextFieldIDCard.setText(idCard);
		jtextFieldName.setText(name);
		jtextFieldDateReturn.setText(simpleDateFormat.format(date));
		jtextFieldLateFee.setText("$" + lateFeeString);
		jtextFieldCompensationFee.setText("$" + compensationFeeString);
		for (int i = 0; i < ReturnBookDialog.idBook.size(); i++) {
			idBook = ReturnBookDialog.idBook.get(i);
			title = ReturnBookDialog.title.get(i);
			defaultTableModelListBook.addRow(new Object[] { number++, idBook, title });
			jtableListofBookReturn.setModel(defaultTableModelListBook);
		}

	}

	// Click button to back invoicePanel
	public void jbtnBack_actionPerformed(ActionEvent arg0) {
		this.dispose();
		setVisible(false);
	}
}
