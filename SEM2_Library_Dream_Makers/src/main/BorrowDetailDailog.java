package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import entities.Author;
import entities.Books;
import entities.Borrow_bill;
import entities.Employee;
import entities.Member;
import model.generalClass;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;

public class BorrowDetailDailog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JTable tableBookBorrow;
	public static JLabel lblBorrowDate;
	public static JLabel lblDueDate;
	public static JLabel lblDepositFee;
	public static JLabel lblPhoneNumber;
	public static JLabel lblDateOfBirth;
	public static JLabel lblMemberCard;
	public static JLabel lblMemberName;
	public static JLabel lblMemberID;
	public static JLabel lblBorrowID;
	private int xPosition, yPosition, mouseX, mouseY;
	DefaultTableModel defaultTableModelListBook = new DefaultTableModel() {
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};
	
	generalClass general = new generalClass();
	public static Member member = null ;
	public static Borrow_bill borrowbill = null ; 
	public static List<Books> books = null;	
	public static List<String> authorNames = null ;
	
	private JButton jbtnBack;
	private JLabel lblTotalBook;
	private JLabel lblStatus;
	private JLabel lblReturnDate;
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BorrowDetailDailog dialog = new BorrowDetailDailog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BorrowDetailDailog() {
		setUndecorated(true);
		setBounds(100, 100, 454, 555);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Member ID :");
		lblNewLabel_1.setBounds(10, 96, 94, 14);
		contentPanel.add(lblNewLabel_1);
		
		lblMemberID = new JLabel(""); 
		lblMemberID.setBounds(94, 96, 99, 14);
		contentPanel.add(lblMemberID);
		
		JLabel lblMBName = new JLabel("Member Name :");
		lblMBName.setBounds(10, 126, 94, 14);
		contentPanel.add(lblMBName);
		
		lblMemberName = new JLabel("");
		lblMemberName.setBounds(114, 126, 228, 14);
		contentPanel.add(lblMemberName);
		
		JLabel lableDateOfBirth = new JLabel("Date of birth : ");
		lableDateOfBirth.setBounds(10, 186, 94, 14);
		contentPanel.add(lableDateOfBirth);
		
		lblDateOfBirth = new JLabel("");
		lblDateOfBirth.setBounds(114, 186, 99, 14);
		contentPanel.add(lblDateOfBirth);
		
		JLabel lablePhoneNumber = new JLabel("Phone Number : ");
		lablePhoneNumber.setBounds(10, 216, 94, 14);
		contentPanel.add(lablePhoneNumber);
		
		lblPhoneNumber = new JLabel("");
		lblPhoneNumber.setBounds(114, 216, 99, 14);
		contentPanel.add(lblPhoneNumber);
		
		JLabel lableDeposit = new JLabel("Deposit Fee :");
		lableDeposit.setBounds(10, 246, 94, 14);
		contentPanel.add(lableDeposit);
		
		lblDepositFee = new JLabel("");
		lblDepositFee.setBounds(114, 246, 99, 14);
		contentPanel.add(lblDepositFee);
		
		lblBorrowID = new JLabel("");
		lblBorrowID.setBounds(327, 96, 99, 14);
		contentPanel.add(lblBorrowID);
		
		JLabel lableBorrowId = new JLabel("Borrow ID :");
		lableBorrowId.setBounds(223, 96, 94, 14);
		contentPanel.add(lableBorrowId);
		
		JLabel lableMemberCard = new JLabel("Member Card :");
		lableMemberCard.setBounds(10, 156, 94, 14);
		contentPanel.add(lableMemberCard);
		
		lblMemberCard = new JLabel("");
		lblMemberCard.setBounds(114, 156, 99, 14);
		contentPanel.add(lblMemberCard);
		
		JLabel lableBorrowDate = new JLabel("Borrow Date :");
		lableBorrowDate.setBounds(10, 276, 94, 14);
		contentPanel.add(lableBorrowDate);
		
		lblBorrowDate = new JLabel("");
		lblBorrowDate.setBounds(94, 276, 99, 14);
		contentPanel.add(lblBorrowDate);
		
		JLabel lableDueDate = new JLabel("Due Date : ");
		lableDueDate.setBounds(223, 276, 94, 14);
		contentPanel.add(lableDueDate);
		
		lblDueDate = new JLabel("");
		lblDueDate.setBounds(327, 276, 99, 14);
		contentPanel.add(lblDueDate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 336, 434, 127);
		contentPanel.add(scrollPane);
		
		tableBookBorrow = new JTable();
		scrollPane.setViewportView(tableBookBorrow);
		
		JLabel lableStatus = new JLabel("Status :");
		lableStatus.setBounds(10, 306, 94, 14);
		contentPanel.add(lableStatus);
		
		lblStatus = new JLabel("");
		lblStatus.setBounds(94, 306, 99, 14);
		contentPanel.add(lblStatus);
		
		JLabel lableReturnDate = new JLabel("Return Date : ");
		lableReturnDate.setBounds(223, 306, 94, 14);
		contentPanel.add(lableReturnDate);
		
		lblReturnDate = new JLabel("");
		lblReturnDate.setBounds(327, 306, 99, 14);
		contentPanel.add(lblReturnDate);
		
		JLabel lableTotalBook = new JLabel("Total Book :");
		lableTotalBook.setBounds(223, 246, 94, 14);
		contentPanel.add(lableTotalBook);
		
		lblTotalBook = new JLabel("");
		lblTotalBook.setBounds(327, 246, 99, 14);
		contentPanel.add(lblTotalBook);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnOK_actionPerformed(e) ;
			}
		});
		btnOK.setBounds(311, 474, 99, 32);
		contentPanel.add(btnOK);
		
		JPanel panel = new JPanel();
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent arg0) {
				try {
					panel_2_mouseDragged(arg0);
				} catch (Exception e) {
					showMessenger("Something was wrong! Please try again");
				}
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				try {
					panel_2_mouseMoved(e);
				} catch (Exception e2) {
					showMessenger("Something was wrong! Please try again");
				}
			}
		});
		panel.setBackground(new Color(0, 102, 204));
		panel.setBounds(0, 0, 454, 50);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Borrow Bill Book Details");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label.setBounds(60, 0, 334, 50);
		panel.add(label);
		
		loadDataBook() ;
		showInformation() ; 
		
	}
	public void btnOK_actionPerformed(ActionEvent e) {
		tableBookBorrow.removeAll();
		this.dispose();
		setVisible(false);
	}
	public void showInformation() {
		String borrowDate = simpleDateFormat.format(borrowbill.getBorrow_date());
		lblBorrowDate.setText(borrowDate); 
		String termDate = simpleDateFormat.format(borrowbill.getTerm_date());
		String status = "" ;
		String returnDate = "" ;
		if(borrowbill.isStatus()) {
			status = "Returned" ;
			returnDate = simpleDateFormat.format(borrowbill.getReturn_date());
		} else {
			status = "Not Returned " ;
			returnDate = "--------" ; 
		}
		
		String idBook = null;
		String title = null;
		lblBorrowID.setText(borrowbill.getBorrow_ID()+"");
		lblMemberID.setText(member.getMember_ID());
		lblMemberName.setText(member.getName()); 
		lblMemberCard.setText(member.getCard_number()); 
		lblDateOfBirth.setText(simpleDateFormat.format(member.getDob()));
		lblPhoneNumber.setText(member.getPhone()); 
		lblDepositFee.setText("$" + borrowbill.getDeposit_fee());
		lblBorrowDate.setText(borrowDate);
		lblDueDate.setText(termDate);
		lblTotalBook.setText(books.size()+""); 
		lblStatus.setText(status);
		lblReturnDate.setText(returnDate);
		
		for (int i = 0 ; i < books.size() ; i++ ) {
			
			defaultTableModelListBook.addRow(new Object[] { defaultTableModelListBook.getRowCount() + 1 , books.get(i).getBook_ID() , books.get(i).getTitle()
					, authorNames.get(i) });
			tableBookBorrow.setModel(defaultTableModelListBook);
		}
	}
	
	public void loadDataBook() {
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		
		defaultTableModelListBook.getDataVector().removeAllElements();
		defaultTableModelListBook.fireTableDataChanged();

		String[] columns = { "No.", "ID Book", "Title" , "Author"  };
		defaultTableModelListBook.setColumnIdentifiers(columns);
		tableBookBorrow.setModel(defaultTableModelListBook);
		tableBookBorrow.getTableHeader().setReorderingAllowed(false);
		tableBookBorrow.getTableHeader().setResizingAllowed(false);

		// set width
		TableColumnModel columnModel = tableBookBorrow.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(30);
		columnModel.getColumn(1).setPreferredWidth(50);
		columnModel.getColumn(2).setPreferredWidth(200);
		columnModel.getColumn(3).setPreferredWidth(150);
		
		
		// set alignment 
		
		columnModel.getColumn(0).setCellRenderer(centerRenderer);
		columnModel.getColumn(1).setCellRenderer(centerRenderer);
		columnModel.getColumn(2).setCellRenderer(centerRenderer);
		columnModel.getColumn(3).setCellRenderer(centerRenderer);
		
		// set color
		JTableHeader header = tableBookBorrow.getTableHeader();
		header.setBackground(new Color(223, 233, 242));
		header.setForeground(Color.BLACK);
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
	
	// Show error message
	private void showMessenger(String mess) {
		JOptionPane.showMessageDialog(null, mess);
	}
}
