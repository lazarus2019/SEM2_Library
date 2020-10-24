package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.Book;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import entities.Author;
import entities.Books;
import entities.Category;
import entities.Publish_house;
import model.Au_BookModel;
import model.AuthorModel;
import model.BooksModel;
import model.Bor_bookModel;
import model.CategoryModel;
import model.PublishModel;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JMenuItem;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;

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
	private JTextField textFieldPrice;
	private JTextField textFieldAddTitle;
	private JComboBox comboBoxAddCate;
	private JTextField textFieldAddPrice;
	private JTextField textFieldAddQuan;
	private JPanel panel_4;
	private JTable tableAddAuthor;
	private JTextField textFieldAddAuthor;
	private JTextField textFieldAddNation;
	private JButton btnAddBook;
	private JComboBox comboBoxAddAuthor;
	private JComboBox comboBoxAddPublish;
	private static DefaultTableModel defaultTableModelAuthor = new DefaultTableModel() {

		@Override
		public boolean isCellEditable(int arg0, int arg1) {
			return false;
		}

	};
	private static DefaultTableModel defaultTableModel = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int arg0, int arg1) {
			return false;
		}

	};

	private static DefaultTableModel defaultTableModelCate = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int arg0, int arg1) {
			return false;
		}

	};

	private static DefaultTableModel defaultTableModelPublish = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int arg0, int arg1) {
			return false;
		}

	};
	int noAddAuthor = 1;
	private JButton btnAddAuthor;
	private JComboBox comboBoxAuthor;
	private JButton btnAuthor;
	private JMenuItem mntmDelete;
	private JScrollPane scrollPane;
	private JButton btnAddRefresh;
	private JButton btnReset_1;
	private JLabel lblCreateCategory;
	private JTextField textFieldAddPublisher;
	private JTextField textFieldAddAddressPub;
	private JTextField textFieldAddPhonePublish;
	private JButton btnCreateCate;
	private JButton btnCreateAuthor;
	private JButton btnAddPublisher;
	private JTextField textFieldCateID;
	private JTextField textFieldCateName;
	private JTextField textFieldPublishID;
	private JTextField textFieldPublishName;
	private JTextField textFieldPublishPhone;
	private JTextField textFieldPublishAddress;
	private JTable tableCategory;
	private JTable tablePublisher;
	private JButton btnUpdateCategory;
	private JButton btnUpdatePublish;
	private JButton btnDeletePublish;
	private JButton btnResetPublish;
	private JTextField textFieldCreateCate;

	/**
	 * Create the panel.
	 */
	public bookPanel() {
		setBounds(0, 0, 803, 617);
		setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);
		tabbedPane.setBackground(Color.GRAY);

		JPanel panelManage = new JPanel();
		panelManage.setBackground(Color.WHITE);
		tabbedPane.addTab("Manage Books", null, panelManage, null);
		panelManage.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 244, 252));
		panel_2.setBounds(10, 11, 778, 89);
		panelManage.add(panel_2);
		panel_2.setLayout(null);

		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(10, 45, 316, 28);
		panel_2.add(textFieldSearch);
		textFieldSearch.setColumns(10);

		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBackground(new Color(30, 106, 210));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearch_actionPerformed(e);
			}
		});
//		btnSearch.setIcon(new ImageIcon(bookPanel.class.getResource("/data/icon/search.png")));
		btnSearch.setBounds(336, 45, 122, 28);
		panel_2.add(btnSearch);

		CategoryModel categoryModel = new CategoryModel();
		List<Category> categories = categoryModel.findAll();

		comboBoxCateSearch = new JComboBox();
		comboBoxCateSearch.setBackground(Color.WHITE);
		comboBoxCateSearch.addItem("");
		for (Category category : categories) {
			comboBoxCateSearch.addItem(category.getName());
		}
		comboBoxCateSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxCateSearch_actionPerformed(e);
			}
		});
		comboBoxCateSearch.setBounds(627, 45, 139, 28);
		panel_2.add(comboBoxCateSearch);

		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblSearch.setBounds(347, 3, 83, 29);
		panel_2.add(lblSearch);

		JLabel lblCategory_1 = new JLabel("Category: ");
		lblCategory_1.setBounds(532, 51, 93, 16);
		panel_2.add(lblCategory_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(245, 244, 252));
		panel_3.setBounds(10, 108, 778, 283);
		panelManage.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel = new JLabel("Book ID : ");
		lblNewLabel.setBounds(21, 46, 74, 16);
		panel_3.add(lblNewLabel);

		textFieldBookID = new JTextField();
		textFieldBookID.setBackground(Color.WHITE);
		textFieldBookID.setEditable(false);
		textFieldBookID.setBounds(117, 40, 228, 28);
		panel_3.add(textFieldBookID);
		textFieldBookID.setColumns(10);

		JLabel lblCallNumber = new JLabel("Call Number :");
		lblCallNumber.setBounds(22, 86, 105, 16);
		panel_3.add(lblCallNumber);

		textFieldCallnumber = new JTextField();
		textFieldCallnumber.setColumns(10);
		textFieldCallnumber.setBounds(117, 81, 228, 28);
		panel_3.add(textFieldCallnumber);

		JLabel lblTiltle = new JLabel("Tiltle :");
		lblTiltle.setBounds(21, 126, 105, 16);
		panel_3.add(lblTiltle);

		textFieldTitle = new JTextField();
		textFieldTitle.setColumns(10);
		textFieldTitle.setBounds(117, 121, 228, 28);
		panel_3.add(textFieldTitle);

		JLabel lblIsbn = new JLabel("ISBN :");
		lblIsbn.setBounds(21, 166, 116, 16);
		panel_3.add(lblIsbn);

		textFieldIsbn = new JTextField();
		textFieldIsbn.setColumns(10);
		textFieldIsbn.setBounds(117, 160, 228, 28);
		panel_3.add(textFieldIsbn);

		JLabel lblPublishHouse = new JLabel("Publish House :");
		lblPublishHouse.setBounds(443, 86, 116, 16);
		panel_3.add(lblPublishHouse);

		JLabel lblCategory = new JLabel("Category :");
		lblCategory.setBounds(443, 126, 116, 16);
		panel_3.add(lblCategory);

		JLabel lblQuantity = new JLabel("Quantity :");
		lblQuantity.setBounds(443, 166, 116, 16);
		panel_3.add(lblQuantity);

		textFieldQuantity = new JTextField();
		textFieldQuantity.setColumns(10);
		textFieldQuantity.setBounds(558, 160, 208, 28);
		panel_3.add(textFieldQuantity);

		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReset.setForeground(Color.WHITE);
		btnReset.setBackground(new Color(30, 106, 210));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnReset_actionPerformed(e);
			}
		});
		btnReset.setBounds(676, 251, 90, 23);
		panel_3.add(btnReset);

		comboBoxCategory1 = new JComboBox();
		comboBoxCategory1.setBackground(Color.WHITE);
		comboBoxCategory1.setBounds(558, 122, 208, 25);
		panel_3.add(comboBoxCategory1);

		PublishModel publishModel = new PublishModel();
		List<Publish_house> publishes = publishModel.findAll();
		comboBoxPublish = new JComboBox();
		comboBoxPublish.setBackground(Color.WHITE);
		comboBoxPublish.setBounds(558, 82, 208, 25);

		panel_3.add(comboBoxPublish);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate.setBounds(440, 251, 107, 23);
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBackground(new Color(30, 106, 210));
		panel_3.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBounds(558, 251, 107, 23);
		btnDelete.setBackground(new Color(30, 106, 210));
		panel_3.add(btnDelete);

		JLabel lblAuthor = new JLabel("Author :");
		lblAuthor.setBounds(21, 209, 116, 16);
		panel_3.add(lblAuthor);

		textFieldAuthor = new JTextField();
		textFieldAuthor.setEditable(false);
		textFieldAuthor.setColumns(10);
		textFieldAuthor.setBounds(117, 244, 228, 28);
		panel_3.add(textFieldAuthor);

		textFieldPrice = new JTextField();
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(558, 199, 208, 28);
		panel_3.add(textFieldPrice);

		JLabel lblPrice = new JLabel("Price :");
		lblPrice.setBounds(440, 209, 105, 16);
		panel_3.add(lblPrice);

		comboBoxAuthor = new JComboBox();
		comboBoxAuthor.setBackground(Color.WHITE);
		comboBoxAuthor.setBounds(117, 206, 154, 23);
		AuthorModel authorModel = new AuthorModel();
		List<Author> authors = authorModel.findAll();
		comboBoxAuthor.addItem("");
		for (Author author : authors) {
			comboBoxAuthor.addItem(author.getName());
		}
		panel_3.add(comboBoxAuthor);

		btnAuthor = new JButton("Add");
		btnAuthor.setBackground(Color.WHITE);
		btnAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAuthor_actionPerformed(e);
			}
		});
		btnAuthor.setBounds(271, 205, 74, 24);
		panel_3.add(btnAuthor);

		JLabel lblDetails = new JLabel("Details");
		lblDetails.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblDetails.setBounds(347, 3, 83, 29);
		panel_3.add(lblDetails);

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(644, 26, 122, 32);
		panel_3.add(btnRefresh);
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRefresh.setForeground(Color.WHITE);
		btnRefresh.setBackground(new Color(30, 106, 210));

		btnReset_1 = new JButton("Reset");
		btnReset_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldAuthor.setText("");
			}
		});
		btnReset_1.setForeground(Color.WHITE);
		btnReset_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReset_1.setBackground(new Color(30, 106, 210));
		btnReset_1.setBounds(17, 244, 83, 23);
		panel_3.add(btnReset_1);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 244, 252));
		panel.setBounds(10, 398, 778, 176);
		panelManage.add(panel);
		panel.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 35, 757, 133);
		scrollPane.getViewport().setBackground(Color.WHITE);
		panel.add(scrollPane);
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		scrollPane.setBackground(new Color(245, 244, 252));

		jtableBooks = new JTable();
		jtableBooks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtableBooks_mouseClicked(e);
			}
		});
		jtableBooks.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtableBooks.setForeground(Color.BLACK);
		jtableBooks.setBackground(Color.WHITE);
		scrollPane.setViewportView(jtableBooks);

		JLabel lblListBook = new JLabel("List Books");
		lblListBook.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblListBook.setBounds(328, 3, 121, 29);
		panel.add(lblListBook);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRefresh_actionPerformed(e);
			}
		});
		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("Manage Cate & Publish", null, panel_7, null);
		panel_7.setLayout(null);

		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(245, 244, 252));
		panel_8.setBounds(10, 315, 385, 263);
		panel_7.add(panel_8);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBackground(new Color(245, 244, 252));
		scrollPane_2.setBounds(10, 35, 365, 217);
		panel_8.add(scrollPane_2);

		tableCategory = new JTable();
		tableCategory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableCategory_mouseClicked(e);
			}
		});

		scrollPane_2.setViewportView(tableCategory);

		JLabel lblListCat = new JLabel("List Category");
		lblListCat.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblListCat.setBounds(111, 0, 214, 29);
		panel_8.add(lblListCat);

		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBackground(new Color(245, 244, 252));
		panel_9.setBounds(10, 11, 385, 293);
		panel_7.add(panel_9);

		JLabel lblCategoryId = new JLabel("Category ID :");
		lblCategoryId.setBounds(10, 62, 75, 16);
		panel_9.add(lblCategoryId);

		textFieldCateID = new JTextField();
		textFieldCateID.setEditable(false);
		textFieldCateID.setColumns(10);
		textFieldCateID.setBounds(97, 56, 236, 28);
		panel_9.add(textFieldCateID);

		JLabel lblName_1 = new JLabel("Name : ");
		lblName_1.setBounds(10, 112, 83, 16);
		panel_9.add(lblName_1);

		textFieldCateName = new JTextField();
		textFieldCateName.setColumns(10);
		textFieldCateName.setBounds(97, 106, 236, 28);
		panel_9.add(textFieldCateName);

		btnUpdateCategory = new JButton("Update");
		btnUpdateCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateCategory_actionPerformed(e);
			}
		});
		btnUpdateCategory.setForeground(Color.WHITE);
		btnUpdateCategory.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdateCategory.setBackground(new Color(30, 106, 210));
		btnUpdateCategory.setBounds(10, 249, 107, 23);
		panel_9.add(btnUpdateCategory);

		JButton btnDeleteCategory = new JButton("Delete");
		btnDeleteCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteCategory_actionPerformed(e);
			}
		});
		btnDeleteCategory.setForeground(Color.WHITE);
		btnDeleteCategory.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDeleteCategory.setBackground(new Color(30, 106, 210));
		btnDeleteCategory.setBounds(133, 249, 107, 23);
		panel_9.add(btnDeleteCategory);

		JLabel lblCategoryDetails = new JLabel("Category Details");
		lblCategoryDetails.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblCategoryDetails.setBounds(86, 11, 259, 29);
		panel_9.add(lblCategoryDetails);

		JButton btnResetCategory = new JButton("Reset");
		btnResetCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnResetCategory_actionPerformed(e);
			}
		});
		btnResetCategory.setForeground(Color.WHITE);
		btnResetCategory.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnResetCategory.setBackground(new Color(30, 106, 210));
		btnResetCategory.setBounds(250, 249, 83, 23);
		panel_9.add(btnResetCategory);

		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBackground(new Color(245, 244, 252));
		panel_10.setBounds(405, 11, 383, 293);
		panel_7.add(panel_10);

		JLabel lblPublisherId = new JLabel("Publisher ID : ");
		lblPublisherId.setBounds(10, 62, 75, 16);
		panel_10.add(lblPublisherId);

		textFieldPublishID = new JTextField();
		textFieldPublishID.setEditable(false);
		textFieldPublishID.setColumns(10);
		textFieldPublishID.setBounds(97, 56, 236, 28);
		panel_10.add(textFieldPublishID);

		JLabel label_3 = new JLabel("Name : ");
		label_3.setBounds(10, 112, 83, 16);
		panel_10.add(label_3);

		textFieldPublishName = new JTextField();
		textFieldPublishName.setColumns(10);
		textFieldPublishName.setBounds(97, 106, 236, 28);
		panel_10.add(textFieldPublishName);

		btnUpdatePublish = new JButton("Update");
		btnUpdatePublish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdatePublish_actionPerformed(e);
			}
		});
		btnUpdatePublish.setForeground(Color.WHITE);
		btnUpdatePublish.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdatePublish.setBackground(new Color(30, 106, 210));
		btnUpdatePublish.setBounds(10, 249, 107, 23);
		panel_10.add(btnUpdatePublish);

		btnDeletePublish = new JButton("Delete");
		btnDeletePublish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeletePublish_actionPerformed(e);
			}
		});
		btnDeletePublish.setForeground(Color.WHITE);
		btnDeletePublish.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDeletePublish.setBackground(new Color(30, 106, 210));
		btnDeletePublish.setBounds(133, 249, 107, 23);
		panel_10.add(btnDeletePublish);

		JLabel lblPublisherDetails = new JLabel("Publisher Details");
		lblPublisherDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblPublisherDetails.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblPublisherDetails.setBounds(10, 11, 355, 29);
		panel_10.add(lblPublisherDetails);

		btnResetPublish = new JButton("Reset");
		btnResetPublish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnResetPublish_actionPerformed(e) ; 
			}
		});
		btnResetPublish.setForeground(Color.WHITE);
		btnResetPublish.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnResetPublish.setBackground(new Color(30, 106, 210));
		btnResetPublish.setBounds(250, 249, 83, 23);
		panel_10.add(btnResetPublish);

		textFieldPublishPhone = new JTextField();
		textFieldPublishPhone.setColumns(10);
		textFieldPublishPhone.setBounds(97, 145, 236, 28);
		panel_10.add(textFieldPublishPhone);

		JLabel lblPhone_1 = new JLabel("Phone : ");
		lblPhone_1.setBounds(10, 151, 75, 16);
		panel_10.add(lblPhone_1);

		JLabel lblAddress_1 = new JLabel("Address :");
		lblAddress_1.setBounds(10, 201, 83, 16);
		panel_10.add(lblAddress_1);

		textFieldPublishAddress = new JTextField();
		textFieldPublishAddress.setColumns(10);
		textFieldPublishAddress.setBounds(97, 195, 236, 28);
		panel_10.add(textFieldPublishAddress);

		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBackground(new Color(245, 244, 252));
		panel_11.setBounds(405, 315, 383, 263);
		panel_7.add(panel_11);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBackground(new Color(245, 244, 252));
		scrollPane_3.setBounds(10, 35, 363, 217);
		panel_11.add(scrollPane_3);

		tablePublisher = new JTable();
		tablePublisher.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tablePublisher_mouseClicked(e);
			}
		});
		scrollPane_3.setViewportView(tablePublisher);

		JLabel lblListPublisher = new JLabel("List Publisher");
		lblListPublisher.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblListPublisher.setBounds(111, 0, 214, 29);
		panel_11.add(lblListPublisher);

		JPanel panelAdd = new JPanel();
		panelAdd.setBackground(Color.WHITE);
		tabbedPane.addTab("Add Book", null, panelAdd, null);
		panelAdd.setLayout(null);

		panel_4 = new JPanel();
		panel_4.setBackground(new Color(245, 244, 252));
		panel_4.setBounds(10, 11, 393, 567);
		panelAdd.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Title : ");
		lblNewLabel_1.setBounds(10, 35, 104, 23);
		panel_4.add(lblNewLabel_1);

		textFieldAddTitle = new JTextField();
		textFieldAddTitle.setBounds(10, 69, 359, 23);
		panel_4.add(textFieldAddTitle);
		textFieldAddTitle.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Category : ");
		lblNewLabel_2.setBounds(10, 103, 104, 14);
		panel_4.add(lblNewLabel_2);

		comboBoxAddCate = new JComboBox();
		comboBoxAddCate.setBackground(Color.WHITE);
		comboBoxAddCate.setBounds(10, 128, 161, 22);
		comboBoxAddCate.addItem("");
		panel_4.add(comboBoxAddCate);

		JLabel lblPublisher = new JLabel("Publisher : ");
		lblPublisher.setBounds(208, 103, 104, 14);
		panel_4.add(lblPublisher);

		comboBoxAddPublish = new JComboBox();
		comboBoxAddPublish.setBackground(Color.WHITE);
		comboBoxAddPublish.setBounds(208, 128, 161, 22);
		comboBoxAddPublish.addItem("");
		panel_4.add(comboBoxAddPublish);

		textFieldAddPrice = new JTextField();
		textFieldAddPrice.setColumns(10);
		textFieldAddPrice.setBounds(10, 189, 161, 23);
		panel_4.add(textFieldAddPrice);

		JLabel lblPrice_1 = new JLabel("Price : ");
		lblPrice_1.setBounds(10, 158, 104, 23);
		panel_4.add(lblPrice_1);

		JLabel lblQuantity_1 = new JLabel("Quantity :");
		lblQuantity_1.setBounds(208, 158, 104, 23);
		panel_4.add(lblQuantity_1);

		textFieldAddQuan = new JTextField();
		textFieldAddQuan.setColumns(10);
		textFieldAddQuan.setBounds(208, 189, 161, 23);
		panel_4.add(textFieldAddQuan);

		JLabel lblAuthor_1 = new JLabel("Author :");
		lblAuthor_1.setBounds(10, 238, 122, 14);
		panel_4.add(lblAuthor_1);

		comboBoxAddAuthor = new JComboBox();
		comboBoxAddAuthor.setBackground(Color.WHITE);
		comboBoxAddAuthor.setBounds(10, 265, 161, 22);

		panel_4.add(comboBoxAddAuthor);

		btnAddAuthor = new JButton("Add");
		btnAddAuthor.setForeground(Color.BLACK);
		btnAddAuthor.setBackground(Color.WHITE);
		btnAddAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddAuthor_actionPerformed(e);
			}
		});
		btnAddAuthor.setBounds(171, 265, 77, 23);
		panel_4.add(btnAddAuthor);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 310, 372, 151);
		scrollPane_1.getViewport().setBackground(Color.WHITE);
		panel_4.add(scrollPane_1);

		tableAddAuthor = new JTable();
		scrollPane_1.setViewportView(tableAddAuthor);

		btnAddBook = new JButton("Add Book ");
		btnAddBook.setForeground(Color.WHITE);
		btnAddBook.setBackground(new Color(30, 106, 210));
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAddBook_actionPerformed(arg0);
			}
		});
		btnAddRefresh = new JButton("Refresh");
		btnAddRefresh.setForeground(Color.WHITE);
		btnAddRefresh.setBackground(new Color(30, 106, 210));
		btnAddRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddRefresh_actionPerformed(e);
			}
		});
		btnAddRefresh.setBounds(245, 509, 124, 29);
		panel_4.add(btnAddRefresh);
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(scrollPane_1, popupMenu);

		JMenuItem mnDeleteAuthor = new JMenuItem("Delete");
		mnDeleteAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mnDeleteAuthor_actionPerformed(e);
			}
		});

		popupMenu.add(mnDeleteAuthor);

		btnAddBook.setBounds(30, 509, 122, 29);
		panel_4.add(btnAddBook);

		JLabel lblCreateBook = new JLabel("Create Book");
		lblCreateBook.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblCreateBook.setBounds(126, 3, 140, 29);
		panel_4.add(lblCreateBook);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(245, 244, 252));
		panel_5.setBounds(413, 11, 362, 222);
		panelAdd.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(10, 35, 104, 23);
		panel_5.add(lblName);

		textFieldAddAuthor = new JTextField();
		textFieldAddAuthor.setColumns(10);
		textFieldAddAuthor.setBounds(10, 69, 342, 23);
		panel_5.add(textFieldAddAuthor);

		textFieldAddNation = new JTextField();
		textFieldAddNation.setColumns(10);
		textFieldAddNation.setBounds(10, 128, 342, 23);
		panel_5.add(textFieldAddNation);

		JLabel lblNation = new JLabel("Nation : ");
		lblNation.setBounds(10, 103, 104, 23);
		panel_5.add(lblNation);

		btnCreateAuthor = new JButton("Create ");
		btnCreateAuthor.setForeground(Color.WHITE);
		btnCreateAuthor.setBackground(new Color(30, 106, 210));
		btnCreateAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCreateAuthor_actionPerformed(e);
			}
		});
		btnCreateAuthor.setBounds(115, 184, 131, 29);
		panel_5.add(btnCreateAuthor);

		JLabel lblCreateAuthor = new JLabel("Create Author");
		lblCreateAuthor.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblCreateAuthor.setBounds(100, 3, 162, 29);
		panel_5.add(lblCreateAuthor);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(245, 244, 252));
		panel_1.setBounds(413, 244, 362, 133);
		panelAdd.add(panel_1);

		JLabel label = new JLabel("Name :");
		label.setBounds(10, 35, 104, 23);
		panel_1.add(label);

		btnCreateCate = new JButton("Create ");
		btnCreateCate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCreateCate_actionPerformed(e);
			}
		});
		btnCreateCate.setForeground(Color.WHITE);
		btnCreateCate.setBackground(new Color(30, 106, 210));
		btnCreateCate.setBounds(114, 95, 131, 29);
		panel_1.add(btnCreateCate);

		lblCreateCategory = new JLabel("Create Category");
		lblCreateCategory.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateCategory.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblCreateCategory.setBounds(0, 3, 362, 29);
		panel_1.add(lblCreateCategory);

		textFieldCreateCate = new JTextField();
		textFieldCreateCate.setColumns(10);
		textFieldCreateCate.setBounds(10, 61, 342, 23);
		panel_1.add(textFieldCreateCate);

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(245, 244, 252));
		panel_6.setBounds(413, 386, 362, 192);
		panelAdd.add(panel_6);

		JLabel label_1 = new JLabel("Name :");
		label_1.setBounds(10, 35, 104, 23);
		panel_6.add(label_1);

		textFieldAddPublisher = new JTextField();
		textFieldAddPublisher.setColumns(10);
		textFieldAddPublisher.setBounds(10, 57, 181, 23);
		panel_6.add(textFieldAddPublisher);

		textFieldAddAddressPub = new JTextField();
		textFieldAddAddressPub.setColumns(10);
		textFieldAddAddressPub.setBounds(10, 115, 342, 23);
		panel_6.add(textFieldAddAddressPub);

		JLabel lblAddress = new JLabel("Address : ");
		lblAddress.setBounds(10, 91, 104, 23);
		panel_6.add(lblAddress);

		btnAddPublisher = new JButton("Create ");
		btnAddPublisher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddPublisher_actionPerformed(e);
			}
		});
		btnAddPublisher.setForeground(Color.WHITE);
		btnAddPublisher.setBackground(new Color(30, 106, 210));
		btnAddPublisher.setBounds(116, 149, 131, 29);
		panel_6.add(btnAddPublisher);

		JLabel lblCreatePublisher = new JLabel("Create Publisher ");
		lblCreatePublisher.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreatePublisher.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblCreatePublisher.setBounds(10, 3, 342, 29);
		panel_6.add(lblCreatePublisher);

		JLabel lblPhone = new JLabel("Phone : ");
		lblPhone.setBounds(209, 35, 104, 23);
		panel_6.add(lblPhone);

		textFieldAddPhonePublish = new JTextField();
		textFieldAddPhonePublish.setColumns(10);
		textFieldAddPhonePublish.setBounds(209, 57, 143, 23);
		panel_6.add(textFieldAddPhonePublish);
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

		loadDataFirst();
		loadDataAddFirst();
		loadData();
		loadDataAdd();
		
		loadDataAddCategory();
		loadDataCateWidth();
		loadDataCate();
		
		loadDataAddPublisher();
		loadDataPublishWidth();
		loadDataPublisher();
	}
	// Manage Cate & Publish

	public void tableCategory_mouseClicked(MouseEvent e) {
		int selectedIndex = tableCategory.getSelectedRow();
		int category_ID = (int) tableCategory.getValueAt(selectedIndex, 0);

		CategoryModel categoryModel = new CategoryModel();
		Category category = categoryModel.find(category_ID);
		textFieldCateID.setText(category_ID + "");
		textFieldCateName.setText(category.getName());

	}

	public void tablePublisher_mouseClicked(MouseEvent e) {
		int selectedIndex = tablePublisher.getSelectedRow();
		int publish_ID = (int) tablePublisher.getValueAt(selectedIndex, 0);

		PublishModel publishModel = new PublishModel();
		Publish_house publish_house = publishModel.find(publish_ID);
		textFieldPublishID.setText(publish_ID + "");
		textFieldPublishName.setText(publish_house.getName());
		textFieldPublishPhone.setText(publish_house.getPhone());
		textFieldPublishAddress.setText(publish_house.getAddress());

	}

	public void btnUpdateCategory_actionPerformed(ActionEvent e) {
		boolean flag = true;
		int selectedIndex = tableCategory.getSelectedRow();
		if (selectedIndex == -1) {
			JOptionPane.showMessageDialog(null, "Please select a category !");
		} else {
			int category_ID = (int) tableCategory.getValueAt(selectedIndex, 0);
			CategoryModel categoryModel = new CategoryModel();
			Category category = categoryModel.find(category_ID);

			if (textFieldCateName.getText().trim() != null) {
				category.setName(textFieldCateName.getText().trim());
			} else {
				flag = false;
				JOptionPane.showMessageDialog(null, "Name must be enter !");
			}
			if (flag) {
				if (categoryModel.update(category, category_ID)) {
					JOptionPane.showMessageDialog(null, "Update Sucessfully ");
					comboBoxAddCate.removeAllItems();
					comboBoxCateSearch.removeAllItems();
					comboBoxCategory1.removeAllItems();
					loadDataAddCategory();
					loadDataCate();
				} else {
					JOptionPane.showMessageDialog(null, "Failed");
				}
			}
		}
	}

	public void btnDeleteCategory_actionPerformed(ActionEvent e) {
		try {
			CategoryModel categoryModel = new CategoryModel();
			int selectedIndex = tableCategory.getSelectedRow();
			int category_ID = (int) tableCategory.getValueAt(selectedIndex, 0);

			if (category_ID == -1) {
				JOptionPane.showMessageDialog(null, "Please select a category !");
			} else {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure ? ", "Comfirm",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {

					if (categoryModel.delete(category_ID)) {
						JOptionPane.showMessageDialog(null, "Successfully !");
						comboBoxAddCate.removeAllItems();
						comboBoxCateSearch.removeAllItems();
						comboBoxCategory1.removeAllItems();
						loadDataAddCategory();
						loadDataCate();
						btnResetCategory_actionPerformed(e);

					} else {
						JOptionPane.showMessageDialog(null, "Failed ");
					}

				}
			}

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}

	}

	public void btnResetCategory_actionPerformed(ActionEvent e) {
		textFieldCateID.setText("");
		textFieldCateName.setText("");
	}

	public void btnUpdatePublish_actionPerformed(ActionEvent e) {
		boolean flag = true;
		int selectedIndex = tablePublisher.getSelectedRow();
		if (selectedIndex == -1) {
			JOptionPane.showMessageDialog(null, "Please select a category !");
		} else {
			int publish_ID = (int) tablePublisher.getValueAt(selectedIndex, 0);
			PublishModel publishModel = new PublishModel();
			Publish_house publish_house = publishModel.find(publish_ID);

			if (textFieldPublishName.getText().trim() != null) {
				publish_house.setName(textFieldPublishName.getText().trim());
				if (textFieldPublishPhone.getText().trim() != null) {
					publish_house.setPhone(textFieldPublishPhone.getText().trim());
					if (textFieldPublishAddress.getText().trim() != null) {
						publish_house.setAddress(textFieldPublishAddress.getText().trim());
					} else {
						flag = false;
						JOptionPane.showMessageDialog(null, "Address must be enter !");
					}
				} else {
					flag = false;
					JOptionPane.showMessageDialog(null, "Phone must be enter !");
				}
			} else {
				flag = false;
				JOptionPane.showMessageDialog(null, "Name must be enter !");
			}
			if (flag) {
				if (publishModel.update(publish_house, publish_ID)) {
					JOptionPane.showMessageDialog(null, "Update Sucessfully ");
					comboBoxAddPublish.removeAllItems();
					comboBoxPublish.removeAllItems();
					loadDataAddPublisher();
					loadDataPublisher();
				} else {
					JOptionPane.showMessageDialog(null, "Failed");
				}
			}
		}
	}

	public void btnDeletePublish_actionPerformed(ActionEvent e) {
		try {
			PublishModel publishModel = new PublishModel();
			int selectedIndex = tablePublisher.getSelectedRow();
			int publish_ID = (int) tablePublisher.getValueAt(selectedIndex, 0);

			if (publish_ID == -1) {
				JOptionPane.showMessageDialog(null, "Please select a publisher !");
			} else {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure ? ", "Comfirm",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {

					if (publishModel.delete(publish_ID)) {
						JOptionPane.showMessageDialog(null, "Successfully !");
						comboBoxAddPublish.removeAllItems();
						comboBoxPublish.removeAllItems();
						loadDataAddPublisher();
						loadDataPublisher();
						btnResetPublish_actionPerformed(e);

					} else {
						JOptionPane.showMessageDialog(null, "Failed ");
					}
				}
			}

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}

	public void btnResetPublish_actionPerformed(ActionEvent e) {
		textFieldPublishID.setText("");
		textFieldPublishName.setText("");
		textFieldPublishAddress.setText("");
		textFieldPublishPhone.setText("");
	}
	// Add Book

	public void btnAddPublisher_actionPerformed(ActionEvent e) {
		String phone = null;
		String name = null;
		String address = null;
		PublishModel publishModel = new PublishModel();
		boolean flag = true;
		if (!textFieldAddPublisher.getText().trim().isEmpty()) {
			name = textFieldAddPublisher.getText().trim();
			if (!textFieldAddPhonePublish.getText().trim().isEmpty()) {
				if (Pattern.matches("[0]+[1-9]{9}", textFieldAddPhonePublish.getText().trim())) {
					phone = textFieldAddPhonePublish.getText().trim();
					if (!textFieldAddAddressPub.getText().trim().isEmpty()) {
						address = textFieldAddAddressPub.getText().trim();
					} else {
						JOptionPane.showMessageDialog(null, "You must enter address !");
						flag = false;
					}
				} else {
					JOptionPane.showMessageDialog(null, "Phone must be number !");
					flag = false;
				}
			} else {
				JOptionPane.showMessageDialog(null, "You must enter phone ! ");
				flag = false;
			}

		} else {
			JOptionPane.showMessageDialog(null, "You must enter name ! ");
			flag = false;
		}

		if (name == null || address == null || phone == null) {
			flag = false;
		}
		if (flag) {
			Publish_house publish_house = new Publish_house(name, address, phone);
			if (publishModel.create(publish_house)) {
				comboBoxAddPublish.removeAllItems();
				comboBoxPublish.removeAllItems();
				textFieldAddAddressPub.setText("");
				textFieldAddPublisher.setText("");
				textFieldAddPhonePublish.setText("");

				JOptionPane.showMessageDialog(null, "Add Successfully ! ");
				loadDataAddPublisher();
				loadDataPublisher();
			} else {
				JOptionPane.showMessageDialog(null, "Failed");
			}
		}
	}

	public void btnCreateCate_actionPerformed(ActionEvent e) {
		String name = null;
		CategoryModel categoryModel = new CategoryModel();
		boolean flag = true;
		if (!textFieldCreateCate.getText().trim().isEmpty()) {
			name = textFieldCreateCate.getText().trim();
		} else {
			JOptionPane.showMessageDialog(null, "You must enter Category's name ! ");
			flag = false;
		}
		if (flag) {
			Category category = new Category();
			category.setName(name);
			if (categoryModel.create(category)) {
				comboBoxAddCate.removeAllItems();
				comboBoxCateSearch.removeAllItems();
				comboBoxCategory1.removeAllItems();
				textFieldCreateCate.setText("");
				JOptionPane.showMessageDialog(null, "Add Successfully ! ");
				loadDataAddCategory();
				loadDataCate();
			} else {
				JOptionPane.showMessageDialog(null, "Failed");
			}
		}
	}

	public void mnDeleteAuthor_actionPerformed(ActionEvent e) {

		if (tableAddAuthor.getSelectedRow() != -1) {
			// remove selected row from the model
			int index = tableAddAuthor.getSelectedRow();
			defaultTableModelAuthor.removeRow(index);
			tableAddAuthor.setModel(defaultTableModelAuthor);
		}
	}

	public void btnAddAuthor_actionPerformed(ActionEvent e) {
		boolean flag = true;
		if (comboBoxAddAuthor.getSelectedIndex() != 0) {
			String name = (String) comboBoxAddAuthor.getSelectedItem();
			for (int i = 0; i < defaultTableModelAuthor.getRowCount(); i++) {
				String n_temp = (String) defaultTableModelAuthor.getValueAt(i, 1);
				if (name == n_temp) {
					flag = false;
					JOptionPane.showMessageDialog(null, "Duplicate author !");
					break;
				}
			}
			if (flag) {
				defaultTableModelAuthor.addRow(new Object[] { defaultTableModelAuthor.getRowCount() + 1, name });
				tableAddAuthor.setModel(defaultTableModelAuthor);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Please select an author !");
		}

	}

	public static boolean checkAuthorName(String author) {
		if (author.length() > 4) {
			return Pattern.matches("[a-zA-Z]{3,}+[\\s]+[a-zA-Z]{3,}", author);
		} else {
			return false;
		}
	}

	public void btnCreateAuthor_actionPerformed(ActionEvent e) {
		String nation = null;
		String name = null;
		AuthorModel authorModel = new AuthorModel();
		String author_ID = null;
		boolean flag = true;
		if (!textFieldAddAuthor.getText().trim().isEmpty()) {
			name = textFieldAddAuthor.getText().trim();
			if (checkAuthorName(name)) {
				String[] words = textFieldAddAuthor.getText().trim().split("\\s");
				for (int i = 0; i < 2; i++) {
					author_ID += words[i].toUpperCase().charAt(0);
					author_ID += words[i].toUpperCase().charAt(1);
				}
				if (!textFieldAddNation.getText().trim().isEmpty()) {
					nation = textFieldAddNation.getText().trim();
				} else {
					JOptionPane.showMessageDialog(null, "You must enter author's nation ! ");
					flag = false;
				}
			} else {
				JOptionPane.showMessageDialog(null, "Author' name : Firt name + Last name !  ");
				flag = false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "You must enter author's name ! ");
			flag = false;
		}

		if (author_ID == null || name == null || nation == null) {
			flag = false;
		}
		if (flag) {
			Author author = new Author(author_ID, name, nation);
			if (authorModel.create(author)) {
				comboBoxAddAuthor.removeAllItems();
				comboBoxAuthor.removeAllItems();
				textFieldAddAuthor.setText("");
				textFieldAddNation.setText("");
				JOptionPane.showMessageDialog(null, "Add Successfully ! ");
				loadDataAdd();
			} else {
				JOptionPane.showMessageDialog(null, "Failed");
			}
		}
	}

	public void btnAddBook_actionPerformed(ActionEvent arg0) {
		BooksModel booksModel = new BooksModel();
		AuthorModel authorModel = new AuthorModel();
		Au_BookModel au_BookModel = new Au_BookModel();
		boolean flag = true;
		int id = 1;
		String book_ID = "BK01";
		List<Books> books = BooksModel.findAlls();
		for (int i = 0; i < books.size(); i++) {
			if (book_ID.equals(books.get(i).getBook_ID())) {
				id++;
				if (id < 10) {
					book_ID = "BK" + "0" + id;
				} else {
					book_ID = "BK" + id;
				}
			}
		}
		String title = textFieldAddTitle.getText().trim();
		Random rand = new Random();
		String isbn = (rand.nextInt(900) + 100) + "-" + (rand.nextInt(9000) + 1000);

		String call_number = "";

		int category_ID = 0;
		int publish_ID = 0;
		double price = 0;
		int quantity = 0;
		List<String> authors_ID = new ArrayList<String>();
		if (title != null && title.length() >= 2) {
			textFieldAddTitle.setText(title);
			call_number += title.charAt(0);
			call_number += title.charAt(1) + "-";
			if (comboBoxAddCate.getSelectedIndex() != 0) {
				category_ID = comboBoxAddCate.getSelectedIndex();
				if (comboBoxAddPublish.getSelectedIndex() != 0) {
					publish_ID = comboBoxAddPublish.getSelectedIndex();
					try {
						price = Double.parseDouble(textFieldAddPrice.getText().trim());
						try {
							quantity = Integer.parseInt(textFieldAddQuan.getText().trim());
							for (int i = 0; i < defaultTableModelAuthor.getRowCount(); i++) {
								String authorName = defaultTableModelAuthor.getValueAt(i, 1).toString().trim();
								String author_ID = authorModel.findAuthorbyName(authorName).getAuthor_ID();
								authors_ID.add(author_ID);
							}
							if (defaultTableModelAuthor.getRowCount() != 0) {
								String authorName = defaultTableModelAuthor.getValueAt(0, 1).toString().trim();
								call_number += authorName.charAt(0);
								call_number += authorName.charAt(1) + "-" + (rand.nextInt(1000));
								call_number = call_number.toUpperCase();
							} else {
								JOptionPane.showMessageDialog(null, "You must add the least one author !");
								flag = false;
							}
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "You must enter a number in quantity ! ");
							textFieldAddQuan.setText("");
							flag = false;
						}
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "You must enter a number in price ! ");
						textFieldAddPrice.setText("");
						flag = false;
					}
				} else {
					JOptionPane.showMessageDialog(null, "You must choose a number in publisher ! ");
					flag = false;
				}
			} else {
				JOptionPane.showMessageDialog(null, "You must choose a number in category ! ");
				flag = false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Title must be enter !");
			flag = false;
		}

		if (flag) {
			Books addbook = new Books(book_ID, call_number, isbn, title, category_ID, publish_ID, price, quantity);
			if (booksModel.create(addbook)) {
				// sai o day
				for (String auid : authors_ID) {
					if (!au_BookModel.createAu_Book(book_ID, auid)) {
						JOptionPane.showMessageDialog(null, "Failed");
					}
					;
				}
				JOptionPane.showMessageDialog(null, "Add Successfully ! ");
				loadData();

			} else {
				JOptionPane.showMessageDialog(null, "Failed");
			}
		}

	}

	public void btnAddRefresh_actionPerformed(ActionEvent e) {

		textFieldAddTitle.setText("");
		comboBoxAddCate.setSelectedIndex(0);
		comboBoxAddPublish.setSelectedIndex(0);
		comboBoxAddAuthor.setSelectedIndex(0);
		textFieldAddPrice.setText("");
		textFieldAddQuan.setText("");
		if (defaultTableModelAuthor.getRowCount() > 0) {
			for (int i = defaultTableModelAuthor.getRowCount() - 1; i > -1; i--) {
				defaultTableModelAuthor.removeRow(i);
				tableAddAuthor.setModel(defaultTableModelAuthor);
			}
		}
		loadDataAddFirst();

	}

	private void loadDataAddCategory() {
		// cbBox Author
		CategoryModel categoryModel = new CategoryModel();
		List<Category> categories2 = categoryModel.findAll();
		comboBoxAddCate.addItem("");
		comboBoxCateSearch.addItem("");
		comboBoxCategory1.addItem("");
		for (Category cate : categories2) {
			comboBoxAddCate.addItem(cate.getName());
			comboBoxCateSearch.addItem(cate.getName());
			comboBoxCategory1.addItem(cate.getName());
		}
		// tableCategory.setModel(defaultTableModelCate);
	}

	private void loadDataAddPublisher() {
		// cbBox Author
		PublishModel publishModel = new PublishModel();
		List<Publish_house> publish_houses = publishModel.findAll();
		comboBoxAddPublish.addItem("");
		comboBoxPublish.addItem("");
		for (Publish_house publish : publish_houses) {
			comboBoxAddPublish.addItem(publish.getName());
			comboBoxPublish.addItem(publish.getName());
		}
		// tableCategory.setModel(defaultTableModelCate);
	}

	private void loadDataCateWidth() {

		String[] columns = { "ID ", "Name" };
		defaultTableModelCate.setColumnIdentifiers(columns);
		tableCategory.setModel(defaultTableModelCate);
		TableColumnModel columnModelFB = tableCategory.getColumnModel();
		columnModelFB.getColumn(0).setPreferredWidth(100);
		columnModelFB.getColumn(1).setPreferredWidth(282);
		tableCategory.getTableHeader().setReorderingAllowed(false);
		tableCategory.getTableHeader().setResizingAllowed(false);
		JTableHeader tableHeader = tableCategory.getTableHeader();
		tableHeader.setBackground(new Color(223, 233, 242));
		tableHeader.setForeground(Color.BLACK);

	}

	private void loadDataPublishWidth() {

		String[] columns = { "ID ", "Name", "Phone", "Address" };
		defaultTableModelPublish.setColumnIdentifiers(columns);
		tablePublisher.setModel(defaultTableModelPublish);
		TableColumnModel columnModelFB = tablePublisher.getColumnModel();
		columnModelFB.getColumn(0).setPreferredWidth(50);
		columnModelFB.getColumn(1).setPreferredWidth(150);
		columnModelFB.getColumn(2).setPreferredWidth(100);
		columnModelFB.getColumn(3).setPreferredWidth(200);

		tablePublisher.getTableHeader().setReorderingAllowed(false);
		tablePublisher.getTableHeader().setResizingAllowed(false);
		JTableHeader tableHeader = tablePublisher.getTableHeader();
		tableHeader.setBackground(new Color(223, 233, 242));
		tableHeader.setForeground(Color.BLACK);

	}

	private void loadDataCate() {
		CategoryModel categoryModel = new CategoryModel();
		defaultTableModelCate.getDataVector().removeAllElements();
		defaultTableModelCate.fireTableDataChanged();
		for (Category category : categoryModel.findAll()) {
			defaultTableModelCate.addRow(new Object[] { category.getCategory_ID(), category.getName() });
		}
		tableCategory.setModel(defaultTableModelCate);
	}

	private void loadDataPublisher() {
		PublishModel publishModel = new PublishModel();
		defaultTableModelPublish.getDataVector().removeAllElements();
		defaultTableModelPublish.fireTableDataChanged();
		for (Publish_house publish : publishModel.findAll()) {
			defaultTableModelPublish.addRow(new Object[] { publish.getPublish_ID(), publish.getName(),
					publish.getPhone(), publish.getAddress() });
		}
		tablePublisher.setModel(defaultTableModelPublish);
	}

	private void loadDataAdd() {
		// cbBox Author
		AuthorModel authorModel = new AuthorModel();
		List<Author> authors = authorModel.findAll();
		comboBoxAddAuthor.addItem("");
		for (Author author1 : authors) {
			comboBoxAddAuthor.addItem(author1.getName());
			comboBoxAuthor.addItem(author1.getName());
		}
		// tableAddAuthor.setModel(defaultTableModelAuthor);
	}

	private void loadDataAddFirst() {

		// tableAuthor Selected
		String[] columns = { "No. ", "Name" };
		defaultTableModelAuthor.setColumnIdentifiers(columns);
		tableAddAuthor.setModel(defaultTableModelAuthor);
		TableColumnModel columnModelFB = tableAddAuthor.getColumnModel();
		columnModelFB.getColumn(0).setPreferredWidth(75);
		columnModelFB.getColumn(1).setPreferredWidth(282);
		tableAddAuthor.getTableHeader().setReorderingAllowed(false);
		tableAddAuthor.getTableHeader().setResizingAllowed(false);
		JTableHeader tableHeader = tableAddAuthor.getTableHeader();
		tableHeader.setBackground(new Color(223, 233, 242));
		tableHeader.setForeground(Color.BLACK);

	}

	// Manage Book
	public void btnAuthor_actionPerformed(ActionEvent e) {
		boolean flag = true;
		String name = (String) comboBoxAuthor.getSelectedItem();
		String[] names = textFieldAuthor.getText().split("&");
		if (name != "") {
			for (int i = 0; i < names.length; i++) {
				String n_temp = names[i].trim();
				System.out.println(name + " = ? " + n_temp);
				if (name.trim().equals(n_temp)) {
					flag = false;
					JOptionPane.showMessageDialog(null, "Duplicate author !");
					break;
				}
			}
			if (flag) {
				if (textFieldAuthor.getText().isEmpty()) {
					textFieldAuthor.setText(textFieldAuthor.getText() + name);
				} else {
					textFieldAuthor.setText(textFieldAuthor.getText() + " & " + name);
				}
			}
		}
	}

	public void btnReset_actionPerformed(ActionEvent e) {
		textFieldBookID.setText("");
		textFieldCallnumber.setText("");
		textFieldTitle.setText("");
		textFieldIsbn.setText("");
		comboBoxCategory1.setSelectedIndex(0);
		comboBoxPublish.setSelectedIndex(0);
		comboBoxAuthor.setSelectedIndex(0);
		textFieldPrice.setText("");
		textFieldQuantity.setText("");
		textFieldAuthor.setText("");
	}

	public void btnUpdate_eactionPerformed(ActionEvent arg0) {
		boolean flag = true;
		int selectedIndex = jtableBooks.getSelectedRow();
		if (selectedIndex == -1) {
			JOptionPane.showMessageDialog(null, "Please select a book !");
		} else {
			String book_ID = jtableBooks.getValueAt(selectedIndex, 1).toString();
			BooksModel booksModel = new BooksModel();
			Books book = booksModel.find(book_ID);

			if (textFieldCallnumber.getText().trim() != null) {
				book.setCall_number(textFieldCallnumber.getText().trim());
				if (textFieldIsbn.getText().trim() != null) {
					book.setIsbn(textFieldIsbn.getText().trim());
					if (textFieldTitle.getText().trim() != null) {
						book.setTitle(textFieldTitle.getText().trim());
						if (comboBoxCategory1.getSelectedIndex() != 0) {
							book.setCategory_ID(comboBoxCategory1.getSelectedIndex());
							if (comboBoxPublish.getSelectedIndex() != 0) {
								book.setPublish_ID(comboBoxPublish.getSelectedIndex());
								if (textFieldPrice.getText().trim() != null) {
									try {
										Double price = Double.parseDouble(textFieldPrice.getText().trim());
										book.setPrice(price);
										if (textFieldQuantity.getText().trim() != null) {
											try {
												String quantityStr = textFieldQuantity.getText().trim();
												int quantity = Integer.parseInt(quantityStr);
												book.setQuantity(quantity);
											} catch (NumberFormatException e) {
												JOptionPane.showMessageDialog(null,
														"You must enter a number in quantity ! ");
												textFieldQuantity.setText("");
											}
										}
									} catch (NumberFormatException e) {
										JOptionPane.showMessageDialog(null, "You must enter a number in price ! ");
										textFieldPrice.setText("");
									}
								}
							} else {
								flag = false;
								JOptionPane.showMessageDialog(null, "Publish house must be select !");
							}
						} else {
							flag = false;
							JOptionPane.showMessageDialog(null, "Category must be select !");
						}
					} else {
						flag = false;
						JOptionPane.showMessageDialog(null, "Title must be enter !");
					}
				} else {
					flag = false;
					JOptionPane.showMessageDialog(null, "ISBN must be enter !");
				}
			} else {
				flag = false;
				JOptionPane.showMessageDialog(null, "Call number must be enter !");
			}
			if (textFieldAuthor.getText().trim() != null) {
				AuthorModel authorModel = new AuthorModel();
				Au_BookModel au_BookModel = new Au_BookModel();

				String[] authors = textFieldAuthor.getText().trim().split("&");
				au_BookModel.delete(book_ID);
				for (String a : authors) {

					Author author = new Author();
					String author_ID = authorModel.findAuthorbyName(a).getAuthor_ID();
					if (author_ID == null && flag) {
						String[] w = a.trim().split("\\s");
						author_ID = "";
						for (int i = 0; i < 2; i++) {
							author_ID += w[i].toUpperCase().charAt(0);
							author_ID += w[i].toUpperCase().charAt(1);
						}
						author.setAuthor_ID(author_ID);
						author.setName(a);
						authorModel.create(author);
					}
					au_BookModel.createAu_Book(book_ID, author_ID);
				}
			}
			if (flag) {
				if (booksModel.update(book, book_ID)) {
					JOptionPane.showMessageDialog(null, "Update Sucessfully ");
					loadData();
				} else {
					JOptionPane.showMessageDialog(null, "Failed");
				}
			}
		}

	}

	public void btnDelete_actionPerformed(ActionEvent e) {
		try {
			BooksModel booksModel = new BooksModel();
			Au_BookModel au_BookModel = new Au_BookModel();
			Bor_bookModel bor_bookModel = new Bor_bookModel();
			int selectedIndex = jtableBooks.getSelectedRow();
			String id = jtableBooks.getValueAt(selectedIndex, 1).toString();

			if (id == null) {
				JOptionPane.showMessageDialog(null, "Please select a book !");
			} else {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure ? ", "Comfirm",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					if (bor_bookModel.count(2, id) == 0) {

						if (au_BookModel.delete(id)) {

							if (booksModel.updateIsDelete(1, id)) {
								JOptionPane.showMessageDialog(null, "Successfully !");
								loadData();
							} else {
								JOptionPane.showMessageDialog(null, "Failed 1 ");
							}

						} else {
							JOptionPane.showMessageDialog(null, "Failed 2");
						}
					} else {
						JOptionPane.showMessageDialog(null, "The book has been borrowed !  ");
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
		comboBoxPublish.setSelectedIndex(book.getPublish_ID());
		;
		textFieldQuantity.setText(book.getQuantity() + "");
		textFieldPrice.setText(book.getPrice() + "");
		String authorName = "";
		int lengthAu = booksModel.findAuthor(book_ID).size();
		for (Author author : booksModel.findAuthor(book_ID)) {
			authorName += author.getName();
			if (lengthAu > 1) {
				authorName += " & ";
				lengthAu--;
			}
		}
		textFieldAuthor.setText(authorName);
	}

	public void comboBoxCateSearch_actionPerformed(ActionEvent e) {
		defaultTableModel.getDataVector().removeAllElements();
		defaultTableModel.fireTableDataChanged();
		BooksModel booksModel = new BooksModel();
		int category_ID = comboBoxCateSearch.getSelectedIndex();
		int no = 1;
		for (Books book : booksModel.searchBooksbyCate(category_ID)) {
			defaultTableModel.addRow(new Object[] { no, book.getBook_ID(), book.getTitle(),
					booksModel.findCategory(book.getCategory_ID()), booksModel.findPublish(book.getPublish_ID()),
					book.getPrice(), book.getQuantity() });
			no++;
		}
		jtableBooks.setModel(defaultTableModel);
	}

	public void btnSearch_actionPerformed(ActionEvent e) {
		defaultTableModel.getDataVector().removeAllElements();
		defaultTableModel.fireTableDataChanged();
		BooksModel booksModel = new BooksModel();
		String key = textFieldSearch.getText();
		int no = 1;
		for (Books book : booksModel.searchBooks(key)) {
			defaultTableModel.addRow(new Object[] { no, book.getBook_ID(), book.getTitle(),
					booksModel.findCategory(book.getCategory_ID()), booksModel.findPublish(book.getPublish_ID()),
					book.getPrice(), book.getQuantity() });
			no++;
		}
		jtableBooks.setModel(defaultTableModel);

	}

	public void btnRefresh_actionPerformed(ActionEvent e) {
		textFieldSearch.setText("");
		btnReset_actionPerformed(e);
		loadData();
	}

	private void loadDataFirst() {
		String[] columnBook = { "No. ", "Book ID", "Title", "Category", "Publish House", "Price", "Quantity" };
		defaultTableModel.setColumnIdentifiers(columnBook);
		jtableBooks.getTableHeader().setReorderingAllowed(false);
		jtableBooks.getTableHeader().setResizingAllowed(false);
		jtableBooks.setModel(defaultTableModel);
		TableColumnModel columnModelFB = jtableBooks.getColumnModel();
		columnModelFB.getColumn(0).setPreferredWidth(50);
		columnModelFB.getColumn(1).setPreferredWidth(50);
		columnModelFB.getColumn(2).setPreferredWidth(242);
		columnModelFB.getColumn(3).setPreferredWidth(80);
		columnModelFB.getColumn(4).setPreferredWidth(180);
		columnModelFB.getColumn(5).setPreferredWidth(70);
		columnModelFB.getColumn(6).setPreferredWidth(70);
		JTableHeader tableHeader = jtableBooks.getTableHeader();
		tableHeader.setBackground(new Color(223, 233, 242));
		tableHeader.setForeground(Color.BLACK);
	}

	private void loadData() {
		BooksModel booksModel = new BooksModel();
		defaultTableModel.getDataVector().removeAllElements();
		defaultTableModel.fireTableDataChanged();
		int no = 1;
		for (Books book : booksModel.findAll()) {
			if (!book.getIsDeleteBoolean()) {
				defaultTableModel.addRow(new Object[] { no, book.getBook_ID(), book.getTitle(),
						booksModel.findCategory(book.getCategory_ID()), booksModel.findPublish(book.getPublish_ID()),
						book.getPrice(), book.getQuantity() });
				no++;
			}
		}
		jtableBooks.setModel(defaultTableModel);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
