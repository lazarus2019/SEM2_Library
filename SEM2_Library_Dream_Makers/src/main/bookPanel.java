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
	int noAddAuthor = 1;
	private JButton btnAddAuthor;
	private JComboBox comboBoxAuthor;
	private JButton btnAuthor;
	private JMenuItem mntmDelete;
	private JScrollPane scrollPane;
	private JButton btnAddRefresh;

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
		panel_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Search ",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(new Color(245, 244, 252));
		panel_2.setBounds(10, 11, 778, 89);
		panelManage.add(panel_2);
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
				btnSearch_actionPerformed(e);
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
				btnRefresh_actionPerformed(e);
			}
		});
//		btnRefresh.setIcon(new ImageIcon(bookPanel.class.getResource("/data/icon/refresh.png")));
		btnRefresh.setBounds(626, 21, 122, 28);
		panel_2.add(btnRefresh);

		CategoryModel categoryModel = new CategoryModel();
		List<Category> categories = categoryModel.findAll();

		comboBoxCateSearch = new JComboBox();
		comboBoxCateSearch.addItem("");
		for (Category category : categories) {
			comboBoxCateSearch.addItem(category.getName());
		}
		comboBoxCateSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxCateSearch_actionPerformed(e);
			}
		});
		comboBoxCateSearch.setBounds(626, 50, 122, 28);
		panel_2.add(comboBoxCateSearch);

		scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		scrollPane.setBackground(new Color(245, 244, 252));
		scrollPane.setBorder(new TitledBorder(null, "List Books", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null,
				new Color(59, 59, 59)));
		scrollPane.setBounds(10, 376, 778, 202);
		panelManage.add(scrollPane);

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

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(245, 244, 252));
		panel_3.setBorder(new TitledBorder(null, "Edit", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null,
				new Color(59, 59, 59)));
		panel_3.setBounds(10, 111, 778, 254);
		panelManage.add(panel_3);
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
		textFieldCallnumber.setEditable(false);
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
		textFieldIsbn.setEditable(false);
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
				btnReset_actionPerformed(e);
			}
		});
		btnReset.setBounds(656, 185, 90, 23);
		panel_3.add(btnReset);

		comboBoxCategory1 = new JComboBox();
		comboBoxCategory1.setBounds(561, 68, 185, 25);
		comboBoxCategory1.addItem("");
		for (Category category : categories) {
			comboBoxCategory1.addItem(category.getName());
		}
		panel_3.add(comboBoxCategory1);

		PublishModel publishModel = new PublishModel();
		List<Publish_house> publishes = publishModel.findAll();
		comboBoxPublish = new JComboBox();
		comboBoxPublish.setBounds(561, 27, 185, 25);
		comboBoxPublish.addItem("");
		for (Publish_house publish : publishes) {
			comboBoxPublish.addItem(publish.getName());
		}

		panel_3.add(comboBoxPublish);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate.setBounds(422, 185, 107, 23);
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBackground(new Color(30, 106, 210));
		panel_3.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBounds(539, 185, 107, 23);
		btnDelete.setBackground(new Color(30, 106, 210));
		panel_3.add(btnDelete);

		JLabel lblAuthor = new JLabel("Author :");
		lblAuthor.setBounds(21, 190, 116, 16);
		panel_3.add(lblAuthor);

		textFieldAuthor = new JTextField();
		textFieldAuthor.setColumns(10);
		textFieldAuthor.setBounds(149, 215, 228, 28);
		panel_3.add(textFieldAuthor);

		textFieldPrice = new JTextField();
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(561, 145, 185, 28);
		panel_3.add(textFieldPrice);

		JLabel lblPrice = new JLabel("Price :");
		lblPrice.setBounds(422, 151, 116, 16);
		panel_3.add(lblPrice);

		comboBoxAuthor = new JComboBox();
		comboBoxAuthor.setBounds(149, 184, 154, 23);
		AuthorModel authorModel = new AuthorModel();
		List<Author> authors = authorModel.findAll();
		comboBoxAuthor.addItem("");
		for (Author author : authors) {
			comboBoxAuthor.addItem(author.getName());
		}
		panel_3.add(comboBoxAuthor);

		btnAuthor = new JButton("Add");
		btnAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAuthor_actionPerformed(e);
			}
		});
		btnAuthor.setBounds(303, 184, 74, 23);
		panel_3.add(btnAuthor);

		JPanel panelAdd = new JPanel();
		panelAdd.setBackground(Color.WHITE);
		tabbedPane.addTab("Add Book", null, panelAdd, null);
		panelAdd.setLayout(null);

		panel_4 = new JPanel();
		panel_4.setBackground(new Color(245, 244, 252));
		panel_4.setBorder(
				new TitledBorder(null, "Create Book", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_4.setBounds(10, 11, 393, 547);
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
		comboBoxAddCate.setBounds(10, 128, 161, 22);
		comboBoxAddCate.addItem("");
		for (Category category : categories) {
			comboBoxAddCate.addItem(category.getName());
		}
		panel_4.add(comboBoxAddCate);

		JLabel lblPublisher = new JLabel("Publisher : ");
		lblPublisher.setBounds(208, 103, 104, 14);
		panel_4.add(lblPublisher);

		comboBoxAddPublish = new JComboBox();
		comboBoxAddPublish.setBounds(208, 128, 161, 22);
		comboBoxAddPublish.addItem("");
		for (Publish_house publish : publishes) {
			comboBoxAddPublish.addItem(publish.getName());
		}
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
		comboBoxAddAuthor.setBounds(10, 265, 161, 22);

		panel_4.add(comboBoxAddAuthor);

		btnAddAuthor = new JButton("Add Author");
		btnAddAuthor.setForeground(Color.WHITE);
		btnAddAuthor.setBackground(new Color(30, 106, 210));
		btnAddAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddAuthor_actionPerformed(e);
			}
		});
		btnAddAuthor.setBounds(197, 265, 122, 23);
		panel_4.add(btnAddAuthor);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 310, 359, 151);
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
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(scrollPane_1, popupMenu);

		JMenuItem mnDeleteAuthor = new JMenuItem("Delete");
		mnDeleteAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mnDeleteAuthor_actionPerformed(e);
			}
		});

		popupMenu.add(mnDeleteAuthor);

		btnAddBook.setBounds(10, 494, 122, 23);
		panel_4.add(btnAddBook);

		btnAddRefresh = new JButton("Refresh");
		btnAddRefresh.setForeground(Color.WHITE);
		btnAddRefresh.setBackground(new Color(30, 106, 210));
		btnAddRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddRefresh_actionPerformed(e);
			}
		});
		btnAddRefresh.setBounds(257, 494, 112, 23);
		panel_4.add(btnAddRefresh);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(245, 244, 252));
		panel_5.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Create Author", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(413, 11, 362, 237);
		panelAdd.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(10, 35, 104, 23);
		panel_5.add(lblName);

		textFieldAddAuthor = new JTextField();
		textFieldAddAuthor.setColumns(10);
		textFieldAddAuthor.setBounds(10, 69, 306, 23);
		panel_5.add(textFieldAddAuthor);

		textFieldAddNation = new JTextField();
		textFieldAddNation.setColumns(10);
		textFieldAddNation.setBounds(10, 128, 306, 23);
		panel_5.add(textFieldAddNation);

		JLabel lblNation = new JLabel("Nation : ");
		lblNation.setBounds(10, 103, 104, 23);
		panel_5.add(lblNation);

		JButton btnCreateAuthor = new JButton("Create ");
		btnCreateAuthor.setForeground(Color.WHITE);
		btnCreateAuthor.setBackground(new Color(30, 106, 210));
		btnCreateAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCreateAuthor_actionPerformed(e);
			}
		});
		btnCreateAuthor.setBounds(10, 189, 104, 23);
		panel_5.add(btnCreateAuthor);
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
	}

	// Add Book

	public void mnDeleteAuthor_actionPerformed(ActionEvent e) {

		if (tableAddAuthor.getSelectedRow() != -1) {
			// remove selected row from the model
			int index = tableAddAuthor.getSelectedRow();
			defaultTableModelAuthor.removeRow(index);
			tableAddAuthor.setModel(defaultTableModelAuthor);
		}
	}

	public void btnAddAuthor_actionPerformed(ActionEvent e) {

		String name = (String) comboBoxAddAuthor.getSelectedItem();
		defaultTableModelAuthor.addRow(new Object[] { defaultTableModelAuthor.getRowCount() + 1, name });
		tableAddAuthor.setModel(defaultTableModelAuthor);

	}

	public void btnCreateAuthor_actionPerformed(ActionEvent e) {
		Author author = new Author();
		AuthorModel authorModel = new AuthorModel();
		String author_ID = "";
		String[] words = textFieldAddAuthor.getText().trim().split("\\s");
		for (int i = 0; i < 2; i++) {
			author_ID += words[i].toUpperCase().charAt(0);
			author_ID += words[i].toUpperCase().charAt(1);
		}
		author.setAuthor_ID(author_ID);
		author.setName(textFieldAddAuthor.getText().trim());
		author.setNation(textFieldAddNation.getText().trim());
		if (authorModel.create(author)) {
			comboBoxAddAuthor.removeAllItems();
			textFieldAddAuthor.setText("");
			textFieldAddNation.setText("");
			JOptionPane.showMessageDialog(null, "Add Successfully ! ");
			loadDataAdd();
		} else {
			JOptionPane.showMessageDialog(null, "Failed");
		}
	}

	public void btnAddBook_actionPerformed(ActionEvent arg0) {
		BooksModel booksModel = new BooksModel();
		AuthorModel authorModel = new AuthorModel();
		Au_BookModel au_BookModel = new Au_BookModel();
		boolean flag = true;
		int id = 1;
		String book_ID = "BK01";
		List<Books> books = BooksModel.findAll();
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
		call_number += title.charAt(0);
		call_number += title.charAt(1) + "-";
		call_number += comboBoxAddAuthor.getSelectedItem().toString().charAt(0);
		call_number += comboBoxAddAuthor.getSelectedItem().toString().charAt(1) + "-" + (rand.nextInt(1000));
		call_number = call_number.toUpperCase();
		int category_ID = comboBoxAddCate.getSelectedIndex();
		int publish_ID = comboBoxAddPublish.getSelectedIndex();
		double price = 0;
		int quantity = 0;
		if (title != null) {
			textFieldAddTitle.setText(title);
			flag = true;
		} else {
			flag = false;
			JOptionPane.showMessageDialog(null, "Call number must be enter !");
		}
		try {
			price = Double.parseDouble(textFieldAddPrice.getText().trim());
			flag = true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "You must enter a number in price ! ");
			textFieldAddPrice.setText("");
			flag = false;
		}
		try {
			quantity = Integer.parseInt(textFieldAddQuan.getText().trim());
			flag = true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "You must enter a number in quantity ! ");
			textFieldAddQuan.setText("");
			flag = false;
		}
		List<String> authors_ID = new ArrayList<String>();

		for (int i = 0; i < defaultTableModelAuthor.getRowCount(); i++) {
			String authorName = defaultTableModelAuthor.getValueAt(i, 1).toString().trim();
			String author_ID = authorModel.findAuthorbyName(authorName).getAuthor_ID();
			authors_ID.add(author_ID);
		}

		Books addbook = new Books(book_ID, call_number, isbn, title, category_ID, publish_ID, price, quantity);
		if (flag) {
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

	private void loadDataAdd() {
		// cbBox Author
		AuthorModel authorModel = new AuthorModel();
		List<Author> authors = authorModel.findAll();
		comboBoxAddAuthor.addItem("");
		for (Author author1 : authors) {
			comboBoxAddAuthor.addItem(author1.getName());
		}
		tableAddAuthor.setModel(defaultTableModelAuthor);
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
		String name = (String) comboBoxAuthor.getSelectedItem();
		if (name != "") {
			if (textFieldAuthor.getText().isEmpty()) {
				textFieldAuthor.setText(textFieldAuthor.getText() + name);
			} else {
				textFieldAuthor.setText(textFieldAuthor.getText() + " & " + name);
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
		textFieldPrice.setText("");
		textFieldQuantity.setText("");
		textFieldAuthor.setText("");
	}

	public void btnUpdate_eactionPerformed(ActionEvent arg0) {
		boolean flag = false;
		int selectedIndex = jtableBooks.getSelectedRow();
		String book_ID = jtableBooks.getValueAt(selectedIndex, 1).toString();
		if (book_ID == null) {
			JOptionPane.showMessageDialog(null, "Please select a book !");
		} else {
			BooksModel booksModel = new BooksModel();
			Books book = booksModel.find(book_ID);

			if (textFieldCallnumber.getText().trim() != null) {
				book.setCall_number(textFieldCallnumber.getText().trim());
				flag = true;
			} else {
				flag = false;
				JOptionPane.showMessageDialog(null, "Call number must be enter !");
			}
			if (textFieldIsbn.getText().trim() != null) {
				book.setIsbn(textFieldIsbn.getText().trim());
				flag = true;
			} else {
				flag = false;
				JOptionPane.showMessageDialog(null, "ISBN must be enter !");
			}
			if (textFieldTitle.getText().trim() != null) {
				book.setTitle(textFieldTitle.getText().trim());
				flag = true;
			} else {
				flag = false;
				JOptionPane.showMessageDialog(null, "Title must be enter !");
			}
			if (comboBoxCategory1.getSelectedIndex() != 0) {
				book.setCategory_ID(comboBoxCategory1.getSelectedIndex());
				flag = true;
			} else {
				flag = false;
				JOptionPane.showMessageDialog(null, "Category must be select !");
			}
			if (comboBoxPublish.getSelectedIndex() != 0) {
				book.setPublish_ID(comboBoxPublish.getSelectedIndex());
				flag = true;
			} else {
				flag = false;
				JOptionPane.showMessageDialog(null, "Publish house must be select !");
			}
			if (textFieldPrice.getText().trim() != null) {
				try {
					Double price = Double.parseDouble(textFieldPrice.getText().trim());
					book.setPrice(price);
					flag = true;
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "You must enter a number in price ! ");
					textFieldPrice.setText("");
				}
			}
			if (textFieldQuantity.getText().trim() != null) {
				try {
					String quantityStr = textFieldQuantity.getText().trim();
					int quantity = Integer.parseInt(quantityStr);
					book.setQuantity(quantity);
					flag = true;
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "You must enter a number in quantity ! ");
					textFieldQuantity.setText("");
				}
			}
			if (textFieldAuthor.getText().trim() != null) {
				AuthorModel authorModel = new AuthorModel();
				Au_BookModel au_BookModel = new Au_BookModel();

				String[] authors = textFieldAuthor.getText().trim().split("&");
				au_BookModel.delete(book_ID);
				for (String a : authors) {

					Author author = new Author();
					String author_ID = authorModel.findAuthorbyName(a).getAuthor_ID();
					if (author_ID == null) {
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
