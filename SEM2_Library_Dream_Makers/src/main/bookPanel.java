package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import entities.Books;
import model.BooksModel;



public class bookPanel extends JPanel {
	
	private JPanel contentPane;
	private JTextField textFieldSearch;
	private JComboBox comboBoxCategory;
	private JTable jtableBooks;
	private JTextField textFieldTitle;
	private JTextField textFieldIsbn;
	private JTextField textFieldPublish;
	private JTextField textFieldCategory;
	private JTextField textFieldQuantity;
	private JTextField textFieldBookID;
	private JTextField textFieldCallnumber;

	/**
	 * Create the panel.
	 */
	public bookPanel() {
		setBounds(0, 0, 803, 617);		
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);
		tabbedPane.setBackground(Color.GRAY);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "More function", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(10, 6, 778, 125);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnUpdate_eactionPerformed(arg0) ;
			}
		});
		//btnUpdate.setIcon(new ImageIcon(bookPanel.class.getResource("/data/icon/update.png")));
		btnUpdate.setBounds(18, 28, 107, 23);
		panel_2.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		//btnDelete.setIcon(new ImageIcon(bookPanel.class.getResource("/data/icon/delete.png")));
		btnDelete.setBounds(137, 28, 107, 23);
		panel_2.add(btnDelete);
		
		JButton btnDetails = new JButton("Details");
		//btnDetails.setIcon(new ImageIcon(bookPanel.class.getResource("/data/icon/details.png")));
		btnDetails.setBounds(256, 28, 107, 23);
		panel_2.add(btnDetails);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(18, 70, 316, 28);
		panel_2.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
//		btnSearch.setIcon(new ImageIcon(bookPanel.class.getResource("/data/icon/search.png")));
		btnSearch.setBounds(349, 70, 122, 28);
		panel_2.add(btnSearch);
		
		comboBoxCategory = new JComboBox();
		comboBoxCategory.setBounds(636, 71, 122, 27);
		panel_2.add(comboBoxCategory);
		
		JButton btnRefresh = new JButton("Refresh");
//		btnRefresh.setIcon(new ImageIcon(bookPanel.class.getResource("/data/icon/refresh.png")));
		btnRefresh.setBounds(626, 25, 122, 28);
		panel_2.add(btnRefresh);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane.setBackground(Color.LIGHT_GRAY);
		scrollPane.setBorder(new TitledBorder(null, "List Books", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(59, 59, 59)));
		scrollPane.setBounds(10, 341, 778, 202);
		panel.add(scrollPane);
		
		jtableBooks = new JTable();
		jtableBooks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		jtableBooks.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(jtableBooks);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBorder(new TitledBorder(null, "Edit", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(59, 59, 59)));
		panel_3.setBounds(10, 143, 771, 196);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book ID : ");
		lblNewLabel.setBounds(21, 30, 74, 16);
		panel_3.add(lblNewLabel);
		
		textFieldBookID = new JTextField();
		textFieldBookID.setEditable(false);
		textFieldBookID.setBounds(149, 24, 152, 28);
		panel_3.add(textFieldBookID);
		textFieldBookID.setColumns(10);
		
		JLabel lblCallNumber = new JLabel("Call Number :");
		lblCallNumber.setBounds(21, 71, 116, 16);
		panel_3.add(lblCallNumber);
		
		textFieldCallnumber = new JTextField();
		textFieldCallnumber.setColumns(10);
		textFieldCallnumber.setBounds(149, 65, 152, 28);
		panel_3.add(textFieldCallnumber);
		
		JLabel lblTiltle = new JLabel("Tiltle :");
		lblTiltle.setBounds(21, 111, 105, 16);
		panel_3.add(lblTiltle);
		
		textFieldTitle = new JTextField();
		textFieldTitle.setColumns(10);
		textFieldTitle.setBounds(149, 105, 152, 28);
		panel_3.add(textFieldTitle);
		
		JLabel lblIsbn = new JLabel("ISBN :");
		lblIsbn.setBounds(21, 151, 116, 16);
		panel_3.add(lblIsbn);
		
		textFieldIsbn = new JTextField();
		textFieldIsbn.setColumns(10);
		textFieldIsbn.setBounds(149, 145, 152, 28);
		panel_3.add(textFieldIsbn);
		
		JLabel lblPublishHouse = new JLabel("Publish House :");
		lblPublishHouse.setBounds(422, 30, 127, 16);
		panel_3.add(lblPublishHouse);
		
		textFieldPublish = new JTextField();
		textFieldPublish.setColumns(10);
		textFieldPublish.setBounds(561, 24, 152, 28);
		panel_3.add(textFieldPublish);
		
		JLabel lblCategory = new JLabel("Category :");
		lblCategory.setBounds(422, 71, 116, 16);
		panel_3.add(lblCategory);
		
		textFieldCategory = new JTextField();
		textFieldCategory.setColumns(10);
		textFieldCategory.setBounds(561, 65, 152, 28);
		panel_3.add(textFieldCategory);
		
		JLabel lblQuantity = new JLabel("Quantity :");
		lblQuantity.setBounds(422, 111, 116, 16);
		panel_3.add(lblQuantity);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setColumns(10);
		textFieldQuantity.setBounds(561, 105, 152, 28);
		panel_3.add(textFieldQuantity);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(422, 139, 90, 28);
		panel_3.add(btnSave);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(543, 139, 90, 28);
		panel_3.add(btnReset);
		
		loadData() ;
	}
	
	public void btnUpdate_eactionPerformed(ActionEvent arg0) {		
			int selectedIndex = jtableBooks.getSelectedRow();
			String book_ID = jtableBooks.getValueAt(selectedIndex, 0).toString();
			
			BooksModel booksModel = new BooksModel();
			Books book = booksModel.find(book_ID); 
			book.setCall_number(textFieldCallnumber.getText().trim());
			book.setIsbn(textFieldIsbn.getText().trim());
			book.setTitle(textFieldTitle.getText().trim());
			book.setCategory_ID(Integer.parseInt(textFieldCategory.getText().trim()));
			book.setPublish_ID(textFieldPublish.getText().trim());
			book.setQuantity(Integer.parseInt(textFieldQuantity.getText().trim()));
			if (booksModel.update(book , book_ID)) {
				loadData();
			} else {
				JOptionPane.showMessageDialog(null, "Failed");
			}		
	}
	
	
	private void loadData() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy") ; 
		
		BooksModel booksModel = new BooksModel() ;
		
		DefaultTableModel defaultTableModel = new DefaultTableModel() ; 
		String[] columns = { "No. " , "Book ID" , "Call NUmber" , "ISBN" , "Title" , "Category" , "Publish House" , "Quantity" } ;
		for ( String cl : columns ) {
			defaultTableModel.addColumn(cl);
		}
		int no = 1 ;
		for(Books book : booksModel.findAll()) {
			defaultTableModel.addRow(new Object[] {
				no,
				book.getBook_ID() , 
				book.getCall_number() , 
				book.getIsbn() ,
				book.getTitle() , 
				book.getCategory_ID() , 
				book.getPublish_ID()  , 
				book.getQuantity()
			});
			no++; 
		}
		jtableBooks.setModel(defaultTableModel);
	}
}
