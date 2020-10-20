package main;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.mindrot.jbcrypt.BCrypt;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import checking.CheckValidate;
import entities.Author;
import entities.Books;
import entities.Employee;
import model.BooksModel;
import model.EmployeeModel;

import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JMenuItem;
import javax.swing.ListSelectionModel;

public class employeePanel extends JPanel {
	private JTextField JSearch;
	private JPasswordField JPassword;
	private JTextField JName;
	private JTextField JEmployee_ID;
	private JTextField JUsername;
	private JTextField JAddress;
	private JTextField JPhone;
	private JTextField JEmail;
	private final ButtonGroup buttonGroupGender = new ButtonGroup();
	private JDateChooser JDateOfBirth;
	private JComboBox JcomboBoxSearch;
	private JTable JTableEmployee;
	private JRadioButton female;
	private JRadioButton male;

	/**
	 * Create the panel.
	 */
	public employeePanel() {
		setBounds(0, 0, 803, 617);
		setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBorder(
				new TitledBorder(null, "More function", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_2.setBounds(0, 0, 798, 99);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_actionPerformed(e);
			}
		});
		btnAdd.setBounds(12, 35, 118, 32);
		panel_2.add(btnAdd);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Delete_actionPerformed(arg0);
			}
		});
		btnDelete.setBounds(149, 35, 118, 32);
		panel_2.add(btnDelete);

		JSearch = new JTextField();
		JSearch.setBounds(592, 35, 194, 32);
		panel_2.add(JSearch);
		JSearch.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Search_actionPerformed(arg0);
			}
		});
		btnSearch.setBounds(462, 35, 118, 32);
		panel_2.add(btnSearch);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Update_actionPerformed(arg0);
			}
		});
		btnUpdate.setBounds(281, 35, 118, 32);
		panel_2.add(btnUpdate);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Edit", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(0, 99, 798, 255);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel = new JLabel("Employee_ID :");
		lblNewLabel.setBounds(12, 31, 93, 16);
		panel_3.add(lblNewLabel);

		JLabel lblUserName = new JLabel("User Name :");
		lblUserName.setBounds(12, 79, 93, 16);
		panel_3.add(lblUserName);

		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(12, 121, 93, 16);
		panel_3.add(lblPassword);

		JPassword = new JPasswordField();
		JPassword.setBounds(128, 115, 163, 29);
		panel_3.add(JPassword);

		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(12, 165, 93, 16);
		panel_3.add(lblName);

		JName = new JTextField();
		JName.setColumns(10);
		JName.setBounds(128, 159, 163, 29);
		panel_3.add(JName);

		JLabel lblDateOfBirth = new JLabel("Date of Birth :");
		lblDateOfBirth.setBounds(12, 214, 93, 16);
		panel_3.add(lblDateOfBirth);

		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(318, 34, 93, 16);
		panel_3.add(lblGender);

		JEmployee_ID = new JTextField();
		JEmployee_ID.setColumns(10);
		JEmployee_ID.setBounds(128, 28, 163, 29);
		panel_3.add(JEmployee_ID);

		JUsername = new JTextField();

		JUsername.setColumns(10);
		JUsername.setBounds(128, 73, 163, 29);
		panel_3.add(JUsername);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Reset_actionPerformed(arg0);
			}
		});
		btnReset.setBounds(656, 31, 118, 32);
		panel_3.add(btnReset);

		JDateOfBirth = new JDateChooser();
		JDateOfBirth.setBounds(128, 205, 163, 29);
		panel_3.add(JDateOfBirth);

		JAddress = new JTextField();
		JAddress.setColumns(10);
		JAddress.setBounds(423, 73, 163, 29);
		panel_3.add(JAddress);

		JPhone = new JTextField();
		JPhone.setColumns(10);
		JPhone.setBounds(423, 118, 163, 29);
		panel_3.add(JPhone);

		JEmail = new JTextField();
		JEmail.setColumns(10);
		JEmail.setBounds(423, 162, 163, 29);
		panel_3.add(JEmail);

		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setBounds(318, 79, 93, 16);
		panel_3.add(lblAddress);

		JLabel lblPhone = new JLabel("Phone :");
		lblPhone.setBounds(318, 126, 93, 16);
		panel_3.add(lblPhone);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(318, 170, 93, 16);
		panel_3.add(lblEmail);

		male = new JRadioButton("Male");
		buttonGroupGender.add(male);
		male.setBounds(524, 30, 59, 25);
		panel_3.add(male);

		female = new JRadioButton("Female");
		buttonGroupGender.add(female);
		female.setBounds(424, 30, 86, 25);
		panel_3.add(female);

		JcomboBoxSearch = new JComboBox();
		JcomboBoxSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Search_Com_actionPerformed(arg0);
			}
		});
		JcomboBoxSearch.setBounds(656, 79, 118, 29);
		panel_3.add(JcomboBoxSearch);

		JLabel lblNewLabel_1 = new JLabel("    Find");
		lblNewLabel_1.setBounds(600, 85, 56, 16);
		panel_3.add(lblNewLabel_1);
		JcomboBoxSearch.addMouseListener(new MouseAdapter() {});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
		});
		scrollPane
				.setBorder(new TitledBorder(null, "List Employee", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setBackground(Color.LIGHT_GRAY);
		scrollPane.setBounds(0, 353, 798, 234);
		panel.add(scrollPane);

		JTableEmployee = new JTable();
		JTableEmployee.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JTableEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Click_mouseClicked(arg0);
			}
		});
		scrollPane.setViewportView(JTableEmployee);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);

		loadData();
	}

	// LoadData - NT
	private void loadData() {
		
		DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<String>();
		defaultComboBoxModel.addElement("admin");
		defaultComboBoxModel.addElement("librarian");
		JcomboBoxSearch.setModel(defaultComboBoxModel);

		EmployeeModel employeeModel = new EmployeeModel();
		String[] columns = { "No. ", "Emp_ID", "Username", "Name", "Dob", "Gender", "Address", "Phone", "Email",
				"Level" };
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
		for (Employee employee : employeeModel.findAll()) {
			defaultTableModel.addRow(new Object[] { no, employee.getEmployee_ID(), employee.getUsername(),
					employee.getName(), employee.getDob(), employee.isGender(), employee.getAddress(),
					employee.getPhone(), employee.getEmail(), employee.getLevel() });
			no++;
		}
		JTableEmployee.setModel(defaultTableModel);
		// Gennerate ID - NTanh
		int id = 1;
		String employee_ID1 = "emp01";
		List<Employee> employees = employeeModel.findAll();
		for (int i = 0; i < employees.size(); i++) {
			if (employee_ID1.equals(employees.get(i).getEmployee_ID())) {
				id++;
				if (id < 10) {
					employee_ID1 = "emp0" + id;
				} else {
					employee_ID1 = "emp" + id;
				}
			}
		}
		JEmployee_ID.setText(employee_ID1);
		setUneditable(JEmployee_ID);
	}

	// Search - NT
	public void Search_actionPerformed(ActionEvent e) {
		String[] columns = { "No. ", "Employee_ID", "Name", "Address", "Email", "Level" };
		String key = JSearch.getText();
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		for (String cl : columns) {
			defaultTableModel.addColumn(cl);
		}
		int no = 1;
		for (Employee employee : EmployeeModel.searchEmployee(key)) {
			defaultTableModel.addRow(new Object[] { no, employee.getEmployee_ID(), employee.getName(),
					employee.getAddress(), employee.getEmail(), employee.getLevel() });
			no++;
		}
		JTableEmployee.setModel(defaultTableModel);
		
		
	}

	public void Search_Com_actionPerformed(ActionEvent arg0) {
			
		String[] columns = { "No. ", "Employee_ID", "Name", "Address", "Email", "Level" };
		String key = JcomboBoxSearch.getSelectedItem().toString().toLowerCase();
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		for (String cl : columns) {
			defaultTableModel.addColumn(cl);
		}
		int no = 1;
		for (Employee employee : EmployeeModel.searchEmployeeCom(key)) {
			defaultTableModel.addRow(new Object[] { no, employee.getEmployee_ID(), employee.getName(),
					employee.getAddress(), employee.getEmail(), employee.getLevel() });
			no++;
		}
		JTableEmployee.setModel(defaultTableModel);
	}

	// Delete - NT
	public void Delete_actionPerformed(ActionEvent arg0) {
		try {
			int selectedIndex = JTableEmployee.getSelectedRow();
			String employee_ID = JTableEmployee.getValueAt(selectedIndex, 1).toString();
			int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				if (EmployeeModel.delete(employee_ID)) {
					loadData();
				}
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}

	// Add - NT
	public void Add_actionPerformed(ActionEvent e) {
		EmployeeModel employeeModel = new EmployeeModel();
		Employee employee = new Employee();

		employee.setEmployee_ID(JEmployee_ID.getText().trim());
		employee.setUsername(JUsername.getText().trim());
		if (CheckValidate.checkPassword(String.valueOf(JPassword.getPassword()))) {
			employee.setPassword(BCrypt.hashpw(JPassword.getPassword().toString(), BCrypt.gensalt()));
		} else {
			System.out.println("Password invalid");
		}
		employee.setName(JName.getText().trim());
		employee.setDob(JDateOfBirth.getDate());
		if (getGenderSelected(buttonGroupGender).equalsIgnoreCase("female")) {
			employee.setGender(false);
		} else {
			employee.setGender(true);
		}
		employee.setAddress(JAddress.getText().trim());
		if (CheckValidate.checkPhone(JPhone.getText().trim())) {
			employee.setPhone(JPhone.getText().trim());
		} else {
			JOptionPane.showMessageDialog(null, "Faild");
		}
		if (CheckValidate.checkEmail(JEmail.getText().trim())) {
			employee.setEmail(JEmail.getText().trim());
		}
		String level = "librarian";
		employee.setLevel(level);
		if (employeeModel.Add(employee)) {
			JOptionPane.showMessageDialog(null, "Completed");
			loadData();

			setEditable(JUsername);
			JEmployee_ID.setText("");
			JUsername.setText("");
			JPassword.setText("");
			female.setSelected(false);
			male.setSelected(false);
			JName.setText("");
			JAddress.setText("");
			JPhone.setText("");
			JEmail.setText("");
		} else {
			JOptionPane.showMessageDialog(null, "Faild");
		}
	}

	// Update - NT
	public void Update_actionPerformed(ActionEvent arg0) {
		int selectedIndex = JTableEmployee.getSelectedRow();
		String employee_ID = JTableEmployee.getValueAt(selectedIndex, 1).toString();

		EmployeeModel employeeModel = new EmployeeModel();
		Employee employee = employeeModel.getById(employee_ID);
		if (JEmployee_ID.getText().trim() != null) {
			employee.setName(JEmployee_ID.getText().trim());
		}
		if (JUsername.getText().trim() != null) {
			employee.setUsername(JUsername.getText().trim());
		}
		if (JPassword.getPassword() != null) {
			if (CheckValidate.checkPassword(String.valueOf(JPassword.getPassword()))) {
				String pass = BCrypt.hashpw(String.valueOf(JPassword.getPassword()), BCrypt.gensalt());
				employee.setPassword(pass);
			} else {
				JOptionPane.showMessageDialog(null, "Password invalid");
			}
		}
		if (JEmail.getText() != null) {
			if (CheckValidate.checkEmail(JEmail.getText().trim())) {
				employee.setEmail(JEmail.getText());
			} else {
				JOptionPane.showMessageDialog(null, "Email invalid");
			}

		}
		if (JDateOfBirth.getDate() != null) {

			employee.setDob(JDateOfBirth.getDate());

		}

		String genders = getGenderSelected(buttonGroupGender);
		if (genders != null) {
			if (genders.equalsIgnoreCase("female")) {
				employee.setGender(false);
			} else {
				employee.setGender(true);
			}
		}
		if (JAddress.getText().trim() != null) {
			employee.setAddress(JAddress.getText().trim());
		}
		if (JPhone.getText().trim() != null) {
			employee.setPhone(JPhone.getText().trim());
		}
		if (JName.getText().trim() != null) {
			employee.setName(JName.getText().trim());
		}
		String level = "librarian";
		employee.setLevel(level);

		if (employee_ID == null) {
			JOptionPane.showMessageDialog(null, "Please select a book !");
		} else {
			if (employeeModel.update(employee, employee_ID)) {
				JOptionPane.showMessageDialog(null, "Completed");
				loadData();
			} else {
				JOptionPane.showMessageDialog(null, "Faild");
			}
		}

	}

	// Click

	public void Click_mouseClicked(MouseEvent arg0) {
		int selectedIndex = JTableEmployee.getSelectedRow();
		String Employee_ID = JTableEmployee.getValueAt(selectedIndex, 1).toString();

		EmployeeModel employeeModel = new EmployeeModel();
		Employee employee = employeeModel.getById(Employee_ID);

		setUneditable(JEmployee_ID);
		setUneditable(JUsername);
		JUsername.setText(employee.getUsername());
		JName.setText(employee.getName());

		JDateOfBirth.setDate(employee.getDob());
		if (employee.isGender() == true) {
			male.setSelected(true);
		} else {
			female.setSelected(true);
		}
		JAddress.setText(employee.getAddress());
		JPhone.setText(employee.getPhone());
		JEmail.setText(employee.getEmail());
	}

	// Reset - NT
	public void Reset_actionPerformed(ActionEvent arg0) {

		// JEmployee_ID.setText(employee_ID1);
		setUneditable(JEmployee_ID);
		setEditable(JUsername);
		JEmployee_ID.setText("");
		JUsername.setText("");
		JPassword.setText("");
		female.setSelected(false);
		male.setSelected(false);
		JName.setText("");
		JAddress.setText("");
		JPhone.setText("");
		JEmail.setText("");
		loadData();
	}

	// Button-Group - NT
	private String getGenderSelected(ButtonGroup buttonGroup) {
		Enumeration<AbstractButton> buttons = buttonGroupGender.getElements();
		while (buttons.hasMoreElements()) {
			JRadioButton radio = (JRadioButton) buttons.nextElement();
			if (radio.isSelected()) {
				return radio.getText();
			}
		}
		return null;
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
