package main;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.mindrot.jbcrypt.BCrypt;

import checking.CheckValidate;
import entities.Author;
import entities.Employee;
import model.AuthorModel;
import model.EmployeeModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class authorPanel extends JPanel {
	private JTable jtableAuthor;
	private JTextField jtextSearch;
	private JTextField jAuthor_ID;
	private JTextField jName;
	private JTextField jNation;
	private JComboBox jcomboBoxSearch;

	private static DefaultTableModel defaultTableModel = new DefaultTableModel() {

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}

	};

	/**
	 * Create the panel.
	 */
	public authorPanel() {
		setBounds(0, 0, 803, 617);
		setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Manage", null, panel, null);
		panel.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 244, 252));
		panel_2.setBounds(11, 10, 776, 88);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JButton btnSearch = new JButton("Search");
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBackground(new Color(30, 106, 210));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search_button_actionPerformed(e);
			}
		});
		btnSearch.setBounds(320, 45, 105, 33);
		panel_2.add(btnSearch);

		jtextSearch = new JTextField();
		jtextSearch.setBounds(11, 45, 299, 33);
		panel_2.add(jtextSearch);
		jtextSearch.setColumns(10);

		jcomboBoxSearch = new JComboBox();
		jcomboBoxSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click_checkbox_actionPerformed(e);
			}
		});

		jcomboBoxSearch.setBounds(591, 45, 173, 33);
		panel_2.add(jcomboBoxSearch);

		JLabel lblNewLabel_1 = new JLabel("Nation:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(524, 57, 67, 16);
		panel_2.add(lblNewLabel_1);

		JLabel lblSearch = new JLabel("Find Author");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblSearch.setBounds(316, 3, 143, 29);
		panel_2.add(lblSearch);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(245, 244, 252));
		panel_3.setBounds(10, 109, 777, 255);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JButton btnAdd = new JButton("Add");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBackground(new Color(30, 106, 210));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Add_actionPerformed(arg0);
			}
		});
		btnAdd.setBounds(172, 210, 112, 33);
		panel_3.add(btnAdd);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(new Color(30, 106, 210));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete_actionPerformed(e);
			}
		});
		btnDelete.setBounds(528, 210, 112, 33);
		panel_3.add(btnDelete);

		JButton btnNewButton = new JButton("Update");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(30, 106, 210));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update_actionPerformed(e);
			}
		});
		btnNewButton.setBounds(352, 210, 112, 33);
		panel_3.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Author ID:");
		lblNewLabel.setBounds(211, 81, 73, 16);
		panel_3.add(lblNewLabel);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(211, 126, 73, 16);
		panel_3.add(lblName);

		JLabel lblNation = new JLabel("Nation:");
		lblNation.setBounds(211, 170, 73, 16);
		panel_3.add(lblNation);

		jNation = new JTextField();
		jNation.setBounds(304, 164, 305, 33);
		panel_3.add(jNation);
		jNation.setColumns(10);

		jName = new JTextField();
		jName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				createAuthorID(e);
			}
		});
		jName.setBounds(304, 118, 305, 33);
		panel_3.add(jName);
		jName.setColumns(10);

		jAuthor_ID = new JTextField();
		jAuthor_ID.setEditable(false);
		jAuthor_ID.setBounds(304, 73, 305, 33);
		panel_3.add(jAuthor_ID);
		jAuthor_ID.setColumns(10);

		JButton btnReset = new JButton("Refresh");
		btnReset.setForeground(Color.WHITE);
		btnReset.setBackground(new Color(30, 106, 210));
		btnReset.setBounds(647, 26, 118, 33);
		panel_3.add(btnReset);

		JLabel lblDetails = new JLabel("Details");
		lblDetails.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblDetails.setBounds(345, 3, 86, 29);
		panel_3.add(lblDetails);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Reset_actionPerformed(arg0);
			}
		});

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(245, 244, 252));
		panel_4.setBounds(11, 375, 776, 199);
		panel.add(panel_4);
		panel_4.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 766, 146);
		scrollPane.getViewport().setBackground(Color.WHITE);
		panel_4.add(scrollPane);
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144)));

		jtableAuthor = new JTable();
		jtableAuthor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Click_mouseClicked(arg0);
			}
		});
		scrollPane.setViewportView(jtableAuthor);

		JLabel lblListAuthor = new JLabel("List Author");
		lblListAuthor.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblListAuthor.setBounds(321, 3, 134, 29);
		panel_4.add(lblListAuthor);

		loadData();
	}

	private void loadData() {
		// Combobox Level - NTanh
		defaultTableModel.getDataVector().removeAllElements();
		defaultTableModel.fireTableDataChanged();
		DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<String>();
		String[] list = { "Ireland", "American", "China", "Viet Nam", "Japan" };
		for (String cs : list) {
			defaultComboBoxModel.addElement(cs);
		}
		jcomboBoxSearch.setModel(defaultComboBoxModel);

		AuthorModel authorModel = new AuthorModel();
		String[] columns = { "No. ", "Author_ID", "Name", "Nation" };
		defaultTableModel.setColumnIdentifiers(columns);
		int no = 1;
		for (Author author : authorModel.findAll()) {
			defaultTableModel.addRow(new Object[] { no, author.getAuthor_ID(), author.getName(), author.getNation() });
			no++;
		}
		jtableAuthor.setModel(defaultTableModel);

	}

	// Add
	public void Add_actionPerformed(ActionEvent arg0) {
		boolean f = false;
		AuthorModel authorModel = new AuthorModel();
		Author author = new Author();
		if (jAuthor_ID.getText().trim() != null) {
			author.setAuthor_ID(jAuthor_ID.getText().trim());
		}

		if (CheckValidate.checkName(jName.getText().trim())) {
			if (CheckValidate.checkAuthorName(jName.getText().trim())) {
				author.setName(jName.getText().trim());
				f = true;
			} else {
				JOptionPane.showMessageDialog(null, "Author' name : Firt name + Last name !  ");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Please input Name");
			f = false;
		}
		if (jNation.getText().trim() != null) {
			author.setNation(jNation.getText().trim());
			f = true;
		} else {
			JOptionPane.showMessageDialog(null, "Please input Nation");
			f = false;
		}
		if (f) {
			if (authorModel.create(author)) {
				loadData();
			} else {
				JOptionPane.showMessageDialog(null, "Faild");
			}
		}
	}

	private void createAuthorID(KeyEvent e) {
		String author_ID = "";
		String[] words = jName.getText().trim().split("\\s");
		if (CheckValidate.checkAuthorName(jName.getText().trim())) {
			for (int i = 0; i < 2; i++) {
				author_ID += words[i].toUpperCase().charAt(0);
				author_ID += words[i].toUpperCase().charAt(1);
			}
			jAuthor_ID.setText(author_ID);
		}
	}

	// Update
	public void Update_actionPerformed(ActionEvent e) {
		boolean f = false;
		try {
			int selectedIndex = jtableAuthor.getSelectedRow();
			String author_ID = jtableAuthor.getValueAt(selectedIndex, 1).toString();

			AuthorModel authorModel = new AuthorModel();
			Author author = authorModel.getById(author_ID);
			if (jAuthor_ID.getText().trim() != null) {
				author.setAuthor_ID(jAuthor_ID.getText().trim());
			}
			if (jName.getText().trim() != null) {
				if (CheckValidate.checkAuthorName(jName.getText().trim())) {
					author.setName(jName.getText().trim());
					f = true;
				} else {
					JOptionPane.showMessageDialog(null, "Author' name : Firt name + Last name !  ");
				}
			} else {
				f = false;
			}
			if (jNation.getText().trim() != null) {
				author.setNation(jNation.getText().trim());
				f = true;
			} else {
				JOptionPane.showMessageDialog(null, "Please input Nation");
				f = false;
			}
			if (author_ID == null) {
				JOptionPane.showMessageDialog(null, "Please select an author !");
			} else {
				if (f) {
					if (authorModel.update(author, author_ID)) {
						loadData();
					} else {
						JOptionPane.showMessageDialog(null, "Faild");
					}
				}
			}

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Please select a author !");
		}

	}

	// Delete
	public void Delete_actionPerformed(ActionEvent e) {
		try {
			int selectedIndex = jtableAuthor.getSelectedRow();
			String author_ID = jtableAuthor.getValueAt(selectedIndex, 1).toString();
			System.out.println(author_ID);
			int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				if (AuthorModel.delete(author_ID)) {
					loadData();
				}
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Please select a author !");
		}
	}

	// Search button
	public void Search_button_actionPerformed(ActionEvent e) {
		defaultTableModel.getDataVector().removeAllElements();
		defaultTableModel.fireTableDataChanged();
		String key = jtextSearch.getText().trim().toLowerCase();
		int no = 1;
		for (Author author : AuthorModel.searchAuthors(key)) {
			defaultTableModel.addRow(new Object[] { no, author.getAuthor_ID(), author.getName(), author.getNation() });
			no++;
		}
		jtableAuthor.setModel(defaultTableModel);

	}

	// Search combobox
	public void click_checkbox_actionPerformed(ActionEvent e) {
		defaultTableModel.getDataVector().removeAllElements();
		defaultTableModel.fireTableDataChanged();
		String key = jcomboBoxSearch.getSelectedItem().toString();
		int no = 1;
		for (Author author : AuthorModel.searchAuthor(key)) {
			defaultTableModel.addRow(new Object[] { no, author.getAuthor_ID(), author.getName(), author.getNation() });
			no++;
		}
		jtableAuthor.setModel(defaultTableModel);

	}

	// Reset
	public void Reset_actionPerformed(ActionEvent arg0) {
		jAuthor_ID.setText("");
		jName.setText("");
		jNation.setText("");
		setEditable(jNation);

	}

	// Click table
	public void Click_mouseClicked(MouseEvent arg0) {
		int selectedIndex = jtableAuthor.getSelectedRow();
		String author_ID = jtableAuthor.getValueAt(selectedIndex, 1).toString();

		AuthorModel authorModel = new AuthorModel();
		Author author = authorModel.getById(author_ID);

		jAuthor_ID.setText(author_ID);
		setUneditable(jAuthor_ID);
		setUneditable(jNation);
		jName.setText(author.getName());
		jNation.setText(author.getNation());

	}

	// Set edit
	private void setUneditable(JTextField j) {
		j.setEnabled(false);
		j.setEditable(false);
	}

	private void setEditable(JTextField ji) {
		ji.setEnabled(true);
		ji.setEditable(true);
	}
}
