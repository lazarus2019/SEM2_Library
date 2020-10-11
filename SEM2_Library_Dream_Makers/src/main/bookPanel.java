package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.List;

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
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import entities.Author;
import entities.Books;
import entities.Category;
import entities.Publish_house;
import model.BooksModel;
import model.CategoryModel;
import model.PublishModel;
import javax.swing.border.EtchedBorder;
import java.awt.Font;

public class bookPanel extends JPanel {

	private JPanel contentPane;
	private JTextField textFieldSearch;
	private JTable jtableBooks;
	private JTextField textFieldTitle;
	private JTextField textFieldIsbn;
	private JTextField textFieldQuantity;
	private JTextField textFieldBookID;
	private JTextField textFieldCallnumber;
	private JComboBox comboBoxCategory1;
	private JComboBox comboBoxPublish;
	private JTextField textFieldAuthor;
	private JButton btnSearch;
	private JComboBox comboBoxCateSearch;

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
		tabbedPane.addTab("Manage Books", null, panel, null);
		panel.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(
				new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Search ", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(new Color(245, 244, 252));
		panel_2.setBounds(10, 11, 778, 89);
		panel.add(panel_2);
		panel_2.setLayout(null);

		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(10, 39, 316, 28);
		panel_2.add(textFieldSearch);
		textFieldSearch.setColumns(10);

		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBackground(new Color(30, 106, 210));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearch_actionPerformed(e) ;
			}
		});
//		btnSearch.setIcon(new ImageIcon(bookPanel.class.getResource("/data/icon/search.png")));
		btnSearch.setBounds(336, 39, 122, 28);
		panel_2.add(btnSearch);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRefresh.setForeground(Color.WHITE);
		btnRefresh.setBackground(new Color(30, 106, 210));
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRefresh_actionPerformed(e) ;
			}
		});
//		btnRefresh.setIcon(new ImageIcon(bookPanel.class.getResource("/data/icon/refresh.png")));
		btnRefresh.setBounds(626, 21, 122, 28);
		panel_2.add(btnRefresh);
		
		CategoryModel categoryModel = new CategoryModel() ; 
		List<Category> categories = categoryModel.findAll() ;
		
		comboBoxCateSearch = new JComboBox();
		comboBoxCateSearch.addItem("") ;
		for( Category category : categories ) {
			comboBoxCateSearch.addItem(category.getName());
		}
		comboBoxCateSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxCateSearch_actionPerformed(e) ; 
			}
		});
		comboBoxCateSearch.setBounds(626, 50, 122, 28);
		panel_2.add(comboBoxCateSearch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		scrollPane.setBackground(new Color(245, 244, 252));
		scrollPane.setBorder(new TitledBorder(null, "List Books", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null,
				new Color(59, 59, 59)));
		scrollPane.setBounds(10, 376, 778, 202);
		panel.add(scrollPane);

		jtableBooks = new JTable() {
			public boolean isCellEditable(int row,int column){  
				return false;  
		       } 
		};
		jtableBooks.addMouseListener(new MouseAdapter() {
			@Override			
			public void mouseClicked(MouseEvent e) {
				jtableBooks_mouseClicked(e) ;
			}
		});		
		jtableBooks.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtableBooks.setForeground(Color.BLACK);
		jtableBooks.setBackground(Color.WHITE);
		scrollPane.setViewportView(jtableBooks);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(245, 244, 252));
		panel_3.setBorder(new TitledBorder(null, "Edit", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null,
				new Color(59, 59, 59)));
		panel_3.setBounds(10, 111, 778, 254);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel = new JLabel("Book ID : ");
		lblNewLabel.setBounds(21, 30, 74, 16);
		panel_3.add(lblNewLabel);

		textFieldBookID = new JTextField();
		textFieldBookID.setEditable(false);
		textFieldBookID.setBounds(149, 24, 228, 28);
		panel_3.add(textFieldBookID);
		textFieldBookID.setColumns(10);

		JLabel lblCallNumber = new JLabel("Call Number :");
		lblCallNumber.setBounds(21, 71, 116, 16);
		panel_3.add(lblCallNumber);

		textFieldCallnumber = new JTextField();
		textFieldCallnumber.setColumns(10);
		textFieldCallnumber.setBounds(149, 65, 228, 28);
		panel_3.add(textFieldCallnumber);

		JLabel lblTiltle = new JLabel("Tiltle :");
		lblTiltle.setBounds(21, 111, 105, 16);
		panel_3.add(lblTiltle);

		textFieldTitle = new JTextField();
		textFieldTitle.setColumns(10);
		textFieldTitle.setBounds(149, 105, 228, 28);
		panel_3.add(textFieldTitle);

		JLabel lblIsbn = new JLabel("ISBN :");
		lblIsbn.setBounds(21, 151, 116, 16);
		panel_3.add(lblIsbn);

		textFieldIsbn = new JTextField();
		textFieldIsbn.setColumns(10);
		textFieldIsbn.setBounds(149, 145, 228, 28);
		panel_3.add(textFieldIsbn);

		JLabel lblPublishHouse = new JLabel("Publish House :");
		lblPublishHouse.setBounds(422, 30, 127, 16);
		panel_3.add(lblPublishHouse);

		JLabel lblCategory = new JLabel("Category :");
		lblCategory.setBounds(422, 71, 116, 16);
		panel_3.add(lblCategory);

		JLabel lblQuantity = new JLabel("Quantity :");
		lblQuantity.setBounds(422, 111, 116, 16);
		panel_3.add(lblQuantity);

		textFieldQuantity = new JTextField();
		textFieldQuantity.setColumns(10);
		textFieldQuantity.setBounds(561, 105, 185, 28);
		panel_3.add(textFieldQuantity);

		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReset.setForeground(Color.WHITE);
		btnReset.setBackground(new Color(30, 106, 210));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnReset_actionPerformed(e) ;
			}
		});
		btnReset.setBounds(656, 145, 90, 28);
		panel_3.add(btnReset);
		
		comboBoxCategory1 = new JComboBox();
		comboBoxCategory1.setBounds(561, 68, 185, 25);
		comboBoxCategory1.addItem("");
		for( Category category : categories ) {
			comboBoxCategory1.addItem(category.getName());
		}
		panel_3.add(comboBoxCategory1);
		
		PublishModel publishModel = new PublishModel() ; 
		List<Publish_house> publishes = publishModel.findAll() ; 
		comboBoxPublish = new JComboBox();
		comboBoxPublish.setBounds(561, 27, 185, 25);
		comboBoxPublish.addItem("");
		for ( Publish_house publish : publishes ) {
			comboBoxPublish.addItem(publish.getName() );
		}
		
		panel_3.add(comboBoxPublish);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBounds(422, 148, 107, 23);
		btnUpdate.setBackground(new Color(30, 106, 210));
		panel_3.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBounds(539, 148, 107, 23);
		btnDelete.setBackground(new Color(30, 106, 210));
		panel_3.add(btnDelete);

		JLabel lblAuthor = new JLabel("Author :");
		lblAuthor.setBounds(21, 190, 116, 16);
		panel_3.add(lblAuthor);

		textFieldAuthor = new JTextField();
		textFieldAuthor.setColumns(10);
		textFieldAuthor.setBounds(149, 184, 228, 28);
		panel_3.add(textFieldAuthor);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 11, 778, 260);
		panel_1.add(panel_4);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDelete_actionPerformed(e);
			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnUpdate_eactionPerformed(arg0);
			}
		});

		loadData();
	}

	public void btnReset_actionPerformed(ActionEvent e) {
		textFieldBookID.setText("");
		textFieldCallnumber.setText("");
		textFieldTitle.setText("");
		textFieldIsbn.setText("");
		comboBoxCategory1.setSelectedIndex(0);
		comboBoxPublish.setSelectedIndex(0);
		textFieldQuantity.setText("");
		textFieldAuthor.setText("");
	}
	
	public void btnUpdate_eactionPerformed(ActionEvent arg0) {
		int selectedIndex = jtableBooks.getSelectedRow();
		String book_ID = jtableBooks.getValueAt(selectedIndex, 1).toString();

		BooksModel booksModel = new BooksModel();
		Books book = booksModel.find(book_ID);
		if(textFieldCallnumber.getText().trim() != null) {
			book.setCall_number(textFieldCallnumber.getText().trim());			
		}
		if(textFieldIsbn.getText().trim() != null) {
			book.setIsbn(textFieldIsbn.getText().trim());			
		}
		if( textFieldTitle.getText().trim() != null) {
			book.setTitle(textFieldTitle.getText().trim());
		}
		if( comboBoxCategory1.getSelectedIndex() !=  0 ) {
			book.setCategory_ID(comboBoxCategory1.getSelectedIndex());
		}
		if( comboBoxPublish.getSelectedIndex() !=  0 ) {
			book.setPublish_ID(comboBoxPublish.getSelectedIndex());
		}
		if( textFieldQuantity.getText().trim() != null) {
			book.setQuantity(Integer.parseInt(textFieldQuantity.getText().trim()));
		}		
		
		
		if( book_ID == null ) {
			JOptionPane.showMessageDialog(null, "Please select a book !");
		} 
		else {
			if (booksModel.update(book, book_ID)) {
				loadData();
			} else {
				JOptionPane.showMessageDialog(null, "Failed");
			}
		}
		
	}

	public void btnDelete_actionPerformed(ActionEvent e) {
		try {
			BooksModel accountModel = new BooksModel();
			int selectedIndex = jtableBooks.getSelectedRow();
			String id = jtableBooks.getValueAt(selectedIndex, 1).toString();
			if( id == null ) {
				JOptionPane.showMessageDialog(null, "Please select a book !");
			}
			else {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure ? ", "Comfirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					if (accountModel.delete(id)) {
						loadData();
					} else {
						JOptionPane.showMessageDialog(null, "Failed");
					}
				}
			}
			

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}
	
	public void jtableBooks_mouseClicked(MouseEvent e) {
		int selectedIndex = jtableBooks.getSelectedRow();
		String book_ID = jtableBooks.getValueAt(selectedIndex, 1).toString();
		
		BooksModel booksModel = new BooksModel();
		Books book = booksModel.find(book_ID);
		
		textFieldBookID.setText(book_ID);
		textFieldCallnumber.setText(book.getCall_number());
		textFieldTitle.setText(book.getTitle());
		textFieldIsbn.setText(book.getIsbn());
		comboBoxCategory1.setSelectedIndex(book.getCategory_ID());
		comboBoxPublish.setSelectedIndex(book.getPublish_ID());;
		textFieldQuantity.setText(book.getQuantity()+"");
		String authorName = "" ;
		int lengthAu = booksModel.findAuthor(book_ID).size() ;
		for ( Author author : booksModel.findAuthor(book_ID) ) {
			authorName += author.getName() ; 			
			if( lengthAu > 1) { 
				authorName += " & " ;
				lengthAu-- ; 
			}
		}
		textFieldAuthor.setText(authorName); 
	}
	
	public void comboBoxCateSearch_actionPerformed(ActionEvent e) {
		BooksModel booksModel = new BooksModel();		
		String[] columns = { "No. ", "Book ID", "Call Number", "ISBN", "Title", "Category", "Publish House","Quantity" };
		int category_ID = comboBoxCateSearch.getSelectedIndex() ; 
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		for (String cl : columns) {
			defaultTableModel.addColumn(cl);
		}
		int no = 1;
		for (Books book : booksModel.searchBooksbyCate(category_ID)) {
			defaultTableModel.addRow(new Object[] { no, book.getBook_ID(), book.getCall_number(), book.getIsbn(),
					book.getTitle(),booksModel.findCategory(book.getCategory_ID()) ,booksModel.findPublish(book.getPublish_ID()), book.getQuantity() });
			no++;
		}
		jtableBooks.setModel(defaultTableModel);
	}
	public void btnSearch_actionPerformed(ActionEvent e) {
		BooksModel booksModel = new BooksModel();		
		String[] columns = { "No. ", "Book ID", "Call Number", "ISBN", "Title", "Category", "Publish House","Quantity" };
		String key = textFieldSearch.getText() ; 
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		for (String cl : columns) {
			defaultTableModel.addColumn(cl);
		}
		int no = 1;
		for (Books book : booksModel.searchBooks(key)) {
			defaultTableModel.addRow(new Object[] { no, book.getBook_ID(), book.getCall_number(), book.getIsbn(),
					book.getTitle(),booksModel.findCategory(book.getCategory_ID()) ,booksModel.findPublish(book.getPublish_ID()), book.getQuantity() });
			no++;
		}
		jtableBooks.setModel(defaultTableModel);
		
	}
	
	
	public void btnRefresh_actionPerformed(ActionEvent e) {
		textFieldSearch.setText("");
		btnReset_actionPerformed(e);
		loadData() ;
	}
	
	private void loadData() {
		BooksModel booksModel = new BooksModel();		
		String[] columns = { "No. ", "Book ID", "Call Number", "ISBN", "Title", "Category", "Publish House","Quantity" };
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		for (String cl : columns) {
			defaultTableModel.addColumn(cl);
		}
		int no = 1;
		for (Books book : booksModel.findAll()) {
			defaultTableModel.addRow(new Object[] { no, book.getBook_ID(), book.getCall_number(), book.getIsbn(),
					book.getTitle(),booksModel.findCategory(book.getCategory_ID()) ,booksModel.findPublish(book.getPublish_ID()), book.getQuantity() });
			no++;
		}
		jtableBooks.setModel(defaultTableModel);
	}
}

