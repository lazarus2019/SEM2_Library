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
import entities.Borrow_bill;
import entities.Member;
import entities.Employee;
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

public class invoicePanel2 extends JPanel {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public static Employee employee = null;

	DefaultTableModel defaultTableModelFindBook = new DefaultTableModel() {
		public boolean isCellEditable(int arg0, int arg1) {
			return false;
		};
	};
	DefaultTableModel defaultTableModelBorrowBill = new DefaultTableModel() {
		public boolean isCellEditable(int arg0, int arg1) {
			return false;
		};
	};
	DefaultTableModel defaultTableModelSelectedBook = new DefaultTableModel() {
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private JTable tableBorrowBill;
	private JPanel panel_9;

	/**
	 * Create the panel.
	 */
	public invoicePanel2() {
		setBounds(0, 0, 803, 617);
		setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		add(tabbedPane, BorderLayout.CENTER);

		JPanel jpanelstatistics = new JPanel();
		tabbedPane.addTab("New tab", null, jpanelstatistics, null);
		jpanelstatistics.setLayout(null);

		JPanel panel_8 = new JPanel();
		panel_8.setBounds(10, 219, 778, 235);
		jpanelstatistics.add(panel_8);
		panel_8.setLayout(null);


		tableBorrowBill = new JTable();
		tableBorrowBill.setBounds(10, 54, 758, 181);
		panel_8.add(tableBorrowBill);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 21, 143, 22);
		panel_8.add(scrollPane);

		panel_9 = new JPanel();
		panel_9.setBounds(10, 11, 778, 187);
		jpanelstatistics.add(panel_9);

		Date date = new Date();

		loadDataBorrowBill() ;
	}

	// Find Books header
	
	public void loadDataBorrowBill() {
		String[] borrowColumn = { "No." , "Borrow ID" , "Member Name" ,
				"Total book borrowed" , "Borrow Date" , "Term Date" , "Forfeit fee " , "Status"
		};
		defaultTableModelBorrowBill.setColumnIdentifiers(borrowColumn);
		tableBorrowBill.setModel(defaultTableModelBorrowBill);
		tableBorrowBill.getTableHeader().setReorderingAllowed(false);
		tableBorrowBill.getTableHeader().setResizingAllowed(false);
		TableColumnModel clbill = tableBorrowBill.getColumnModel();
		// set width
		clbill.getColumn(0).setPreferredWidth(50);
		clbill.getColumn(1).setPreferredWidth(75);
		clbill.getColumn(2).setPreferredWidth(150);
		clbill.getColumn(3).setPreferredWidth(75);
		clbill.getColumn(4).setPreferredWidth(150);
		clbill.getColumn(5).setPreferredWidth(150);
		clbill.getColumn(6).setPreferredWidth(100);
		clbill.getColumn(7).setPreferredWidth(50);
		// set color
		JTableHeader tableBorrowBillHeader = tableBorrowBill.getTableHeader();
		tableBorrowBillHeader.setBackground(new Color(223, 233, 242));
		tableBorrowBillHeader.setForeground(Color.BLACK);
		
		// set Data 
		
		BooksModel bookModel6 = new BooksModel();
		AuthorModel authorModel6 = new AuthorModel();
		MemberModel memberModel6 = new MemberModel();
		Borrow_billModel borrow_billModel6 = new Borrow_billModel();
		List<Borrow_bill> borrowbills = borrow_billModel6.findAll();
		int number = 1;
		String status = "";
		for (Borrow_bill bill : borrowbills) {
			double forfeit_fee = 0;
			String memberName = "";
			int totalBook = 0;
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
}
