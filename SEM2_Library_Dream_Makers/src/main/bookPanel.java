package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entities.Books;
import model.BooksModel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class bookPanel extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSearch;
	private JComboBox comboBoxCategory;
	private JTable jtableBooks;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textFieldBookID;
	private JTextField textFieldCallnumber;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public bookPanel() {
		setTitle("Book Panel");
		setBounds(0, 0, 803, 651);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.GRAY);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
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
		btnUpdate.setIcon(new ImageIcon(bookPanel.class.getResource("/data/icon/update.png")));
		btnUpdate.setBounds(18, 28, 107, 23);
		panel_2.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setIcon(new ImageIcon(bookPanel.class.getResource("/data/icon/delete.png")));
		btnDelete.setBounds(137, 28, 107, 23);
		panel_2.add(btnDelete);
		
		JButton btnDetails = new JButton("Details");
		btnDetails.setIcon(new ImageIcon(bookPanel.class.getResource("/data/icon/details.png")));
		btnDetails.setBounds(256, 28, 107, 23);
		panel_2.add(btnDetails);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(18, 70, 316, 28);
		panel_2.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setIcon(new ImageIcon(bookPanel.class.getResource("/data/icon/search.png")));
		btnSearch.setBounds(349, 70, 122, 28);
		panel_2.add(btnSearch);
		
		comboBoxCategory = new JComboBox();
		comboBoxCategory.setBounds(636, 71, 122, 27);
		panel_2.add(comboBoxCategory);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setIcon(new ImageIcon(bookPanel.class.getResource("/data/icon/refresh.png")));
		btnRefresh.setBounds(626, 25, 122, 28);
		panel_2.add(btnRefresh);
		
		JScrollPane scrollPane = new JScrollPane();
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
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(149, 105, 152, 28);
		panel_3.add(textField_2);
		
		JLabel lblIsbn = new JLabel("ISBN :");
		lblIsbn.setBounds(21, 151, 116, 16);
		panel_3.add(lblIsbn);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(149, 145, 152, 28);
		panel_3.add(textField_3);
		
		JLabel lblPublishHouse = new JLabel("Publish House :");
		lblPublishHouse.setBounds(422, 30, 127, 16);
		panel_3.add(lblPublishHouse);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(561, 24, 152, 28);
		panel_3.add(textField_4);
		
		JLabel lblCategory = new JLabel("Category :");
		lblCategory.setBounds(422, 71, 116, 16);
		panel_3.add(lblCategory);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(561, 65, 152, 28);
		panel_3.add(textField_5);
		
		JLabel lblQuantity = new JLabel("Quantity :");
		lblQuantity.setBounds(422, 111, 116, 16);
		panel_3.add(lblQuantity);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(561, 105, 152, 28);
		panel_3.add(textField_6);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(422, 139, 90, 28);
		panel_3.add(btnSave);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(543, 139, 90, 28);
		panel_3.add(btnReset);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		
		loadData() ;
	}
	private void loadData() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy") ; 
		
		BooksModel booksModel = new BooksModel() ;
		
		DefaultTableModel defaultTableModel = new DefaultTableModel() ; 
		String[] columns = { "ID" , "Call NUmber" , "ISBN" , "Title" , "Category" , "Publish House" , "Quantity" } ;
		for ( String cl : columns ) {
			defaultTableModel.addColumn(cl);
		}
		for(Books book : booksModel.findAll()) {
			defaultTableModel.addRow(new Object[] {
				book.getBook_ID() , 
				book.getCall_number() , 
				book.getIsbn() ,
				book.getTitle() , 
				book.getCategory_ID() , 
				book.getPublish_ID()  , 
				book.getQuantity()
			});
		}
		jtableBooks.setModel(defaultTableModel);
	}
}
