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

public class authorPanel extends JPanel {
	private JTable jtableAuthor;
	private JTextField jtextSearch;
	private JTextField jAuthor_ID;
	private JTextField jName;
	private JTextField jNation;
	private JComboBox jcomboBoxSearch;

	/**
	 * Create the panel.
	 */
	public authorPanel() {
		setBounds(0, 0, 803, 617);
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Manage", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(0, 0, 798, 98);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search_button_actionPerformed(e);
			}
		});
		btnSearch.setBounds(50, 36, 97, 33);
		panel_2.add(btnSearch);
		
		jtextSearch = new JTextField();
		jtextSearch.setBounds(178, 36, 181, 33);
		panel_2.add(jtextSearch);
		jtextSearch.setColumns(10);
		
		jcomboBoxSearch = new JComboBox();
		jcomboBoxSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click_checkbox_actionPerformed(e);
			}
		});
		
		jcomboBoxSearch.setBounds(474, 36, 118, 33);
		panel_2.add(jcomboBoxSearch);
		
		JLabel lblNewLabel_1 = new JLabel("Search :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(395, 43, 67, 16);
		panel_2.add(lblNewLabel_1);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Reset_actionPerformed(arg0);
			}
		});
		btnReset.setBounds(655, 40, 97, 33);
		panel_2.add(btnReset);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(0, 97, 798, 267);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Add_actionPerformed(arg0);
			}
		});
		btnAdd.setBounds(173, 205, 112, 33);
		panel_3.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete_actionPerformed(e);
			}
		});
		btnDelete.setBounds(528, 205, 112, 33);
		panel_3.add(btnDelete);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update_actionPerformed(e);
			}
		});
		btnNewButton.setBounds(352, 205, 112, 33);
		panel_3.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Author ID");
		lblNewLabel.setBounds(173, 37, 56, 16);
		panel_3.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(177, 93, 56, 16);
		panel_3.add(lblName);
		
		JLabel lblNation = new JLabel("Nation");
		lblNation.setBounds(177, 148, 56, 16);
		panel_3.add(lblNation);
		
		jNation = new JTextField();
		jNation.setBounds(279, 140, 305, 33);
		panel_3.add(jNation);
		jNation.setColumns(10);
		
		jName = new JTextField();
		jName.setBounds(279, 85, 305, 33);
		panel_3.add(jName);
		jName.setColumns(10);
		
		jAuthor_ID = new JTextField();
		jAuthor_ID.setBounds(279, 29, 305, 33);
		panel_3.add(jAuthor_ID);
		jAuthor_ID.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144)));
		scrollPane.setBounds(0, 364, 798, 223);
		panel.add(scrollPane);
		
		jtableAuthor = new JTable();
		jtableAuthor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Click_mouseClicked(arg0);
			}
		});
		scrollPane.setViewportView(jtableAuthor);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		
		loadData();
	}
	private void loadData() {
		// Combobox Level - NTanh
				DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<String>();
				String[] list = {"Ireland","American","China","Viet Nam","Japan"};
				for(String cs : list) {
					defaultComboBoxModel.addElement(cs);
				}
				jcomboBoxSearch.setModel(defaultComboBoxModel);

				AuthorModel authorModel = new AuthorModel();
				String[] columns = { "No. ", "Author_ID", "Name", "Nation" };
				DefaultTableModel defaultTableModel = new DefaultTableModel() {
					// Unedit
					@Override
					public boolean isCellEditable(int arg0, int arg1) {
						return false;
					}

				};
				for (String cl : columns) {
					defaultTableModel.addColumn(cl);
				}
				int no = 1;
				for (Author author : authorModel.findAll()) {
					defaultTableModel.addRow(new Object[] { no, author.getAuthor_ID(), author.getName(), author.getNation() });
					no++;
				}
				jtableAuthor.setModel(defaultTableModel);
				
	}
	
	//Add 
	public void Add_actionPerformed(ActionEvent arg0) {
		AuthorModel authorModel = new AuthorModel();
		Author author = new Author();
		author.setAuthor_ID(jAuthor_ID.getText().trim());
		author.setName(jName.getText().trim());		
		author.setNation(jNation.getText().trim());
		if (authorModel.create(author)) {
			loadData();
		} else {
			JOptionPane.showMessageDialog(null, "Faild");
		}
	}
	//Update
	public void Update_actionPerformed(ActionEvent e) {
		int selectedIndex = jtableAuthor.getSelectedRow();
		String author_ID = jtableAuthor.getValueAt(selectedIndex, 1).toString();

		AuthorModel authorModel = new AuthorModel();
		Author author = authorModel.getById(author_ID);
		if (jAuthor_ID.getText().trim() != null) {
			author.setAuthor_ID(jAuthor_ID.getText().trim());
		}
		if (jName.getText().trim() != null) {
			author.setName(jName.getText().trim());
		}
		if (jNation.getText().trim() != null) {
			author.setNation(jNation.getText().trim());
		}
		if (author_ID == null) {
			JOptionPane.showMessageDialog(null, "Please select a book !");
		} else {
			if (authorModel.update(author, author_ID)) {
				loadData();
			} else {
				JOptionPane.showMessageDialog(null, "Faild");
			}
		}

	}
	//Delete
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
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}
	//Search button
	public void Search_button_actionPerformed(ActionEvent e) {
		String[] columns = { "No. ", "Author_ID", "Name", "Nation" };
		String key = jtextSearch.getText().trim().toLowerCase();
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		for (String cl : columns) {
			defaultTableModel.addColumn(cl);
		}
		int no = 1;
		for (Author author : AuthorModel.searchAuthors(key)) {
			defaultTableModel.addRow(new Object[] { no, author.getAuthor_ID(), author.getName(), author.getNation() });
			no++;
		}
		jtableAuthor.setModel(defaultTableModel);
		
	}
	//Search combobox
	public void click_checkbox_actionPerformed(ActionEvent e) {
		String[] columns = { "No. ", "Author_ID", "Name", "Nation" };
		String key = jcomboBoxSearch.getSelectedItem().toString();
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		for (String cl : columns) {
			defaultTableModel.addColumn(cl);
		}
		int no = 1;
		for (Author author : AuthorModel.searchAuthor(key)) {
			defaultTableModel.addRow(new Object[] { no, author.getAuthor_ID(), author.getName(), author.getNation() });
			no++;
		}
		jtableAuthor.setModel(defaultTableModel);
		
	}
	//Reset
	public void Reset_actionPerformed(ActionEvent arg0) {
		jAuthor_ID.setText("");
		jName.setText("");
		jNation.setText("");
		setEditable(jAuthor_ID);
		setEditable(jNation);
		
	}
	
	//Click table
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
