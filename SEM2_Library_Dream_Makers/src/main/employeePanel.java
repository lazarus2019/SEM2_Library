package main;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.codec.language.bm.Rule.Phoneme;
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
import com.toedter.calendar.JTextFieldDateEditor;

import checking.CheckValidate;
import entities.Author;
import entities.Books;
import entities.Employee;
import model.BooksModel;
import model.EmployeeModel;
import sun.security.util.Password;

import java.awt.event.ActionListener;
import java.util.Date;
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
import java.awt.Font;
import javax.swing.SwingConstants;

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
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Manage", null, panel, null);
		panel.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(245, 244, 252));
		panel_4.setBounds(11, 405, 776, 169);
		panel.add(panel_4);
		panel_4.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 755, 116);
		panel_4.add(scrollPane);
		scrollPane.addMouseListener(new MouseAdapter() {
		});
		scrollPane.setBackground(Color.LIGHT_GRAY);
		scrollPane.getViewport().setBackground(Color.WHITE);

		JTableEmployee = new JTable();
		JTableEmployee.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JTableEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Click_mouseClicked(arg0);
			}
		});
		scrollPane.setViewportView(JTableEmployee);

		JLabel lblListEmployee = new JLabel("List Employee");
		lblListEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblListEmployee.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblListEmployee.setBounds(305, 3, 165, 29);
		panel_4.add(lblListEmployee);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 244, 252));
		panel_2.setBounds(11, 11, 776, 88);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JButton btnAdd = new JButton("Add");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBackground(new Color(30, 106, 210));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_actionPerformed(e);
			}
		});
		btnAdd.setBounds(11, 45, 118, 32);
		panel_2.add(btnAdd);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(new Color(30, 106, 210));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Delete_actionPerformed(arg0);
			}
		});
		btnDelete.setBounds(139, 45, 118, 32);
		panel_2.add(btnDelete);

		JSearch = new JTextField();
		JSearch.setBounds(457, 45, 194, 32);
		panel_2.add(JSearch);
		JSearch.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBackground(new Color(30, 106, 210));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Search_actionPerformed(arg0);
			}
		});
		btnSearch.setBounds(660, 45, 105, 32);
		panel_2.add(btnSearch);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBackground(new Color(30, 106, 210));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Update_actionPerformed(arg0);
			}
		});
		btnUpdate.setBounds(267, 45, 118, 32);
		panel_2.add(btnUpdate);

		JLabel lblNewLabel_2 = new JLabel("Feature");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_2.setBounds(339, 3, 98, 29);
		panel_2.add(lblNewLabel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(245, 244, 252));
		panel_3.setBounds(11, 109, 776, 285);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel = new JLabel("Employee_ID :");
		lblNewLabel.setBounds(12, 79, 93, 16);
		panel_3.add(lblNewLabel);

		JLabel lblUserName = new JLabel("User Name :");
		lblUserName.setBounds(12, 125, 93, 16);
		panel_3.add(lblUserName);

		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(12, 165, 93, 16);
		panel_3.add(lblPassword);

		JPassword = new JPasswordField();
		JPassword.setBounds(110, 159, 163, 29);
		panel_3.add(JPassword);

		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(12, 205, 93, 16);
		panel_3.add(lblName);

		JName = new JTextField();
		JName.setColumns(10);
		JName.setBounds(110, 199, 163, 29);
		panel_3.add(JName);

		JLabel lblDateOfBirth = new JLabel("Date of Birth :");
		lblDateOfBirth.setBounds(12, 245, 93, 16);
		panel_3.add(lblDateOfBirth);

		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(336, 79, 80, 16);
		panel_3.add(lblGender);

		JEmployee_ID = new JTextField();
		JEmployee_ID.setForeground(Color.BLACK);
		JEmployee_ID.setBackground(Color.WHITE);
		JEmployee_ID.setColumns(10);
		JEmployee_ID.setBounds(110, 73, 163, 29);
		panel_3.add(JEmployee_ID);

		JUsername = new JTextField();
		JUsername.setBackground(Color.WHITE);
		JUsername.setForeground(Color.BLACK);

		JUsername.setColumns(10);
		JUsername.setBounds(110, 119, 163, 29);
		panel_3.add(JUsername);

		JButton btnReset = new JButton("Reset");
		btnReset.setForeground(Color.WHITE);
		btnReset.setBackground(new Color(30, 106, 210));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Reset_actionPerformed(arg0);
			}
		});
		btnReset.setBounds(646, 26, 118, 32);
		panel_3.add(btnReset);

		JDateOfBirth = new JDateChooser();
		JTextFieldDateEditor editor2 = (JTextFieldDateEditor) JDateOfBirth.getDateEditor();
		editor2.setEditable(false);
		JDateOfBirth.setDateFormatString("dd/MM/yyyy");
		JDateOfBirth.setBounds(110, 242, 163, 29);
		panel_3.add(JDateOfBirth);

		JAddress = new JTextField();
		JAddress.setColumns(10);
		JAddress.setBounds(411, 119, 163, 29);
		panel_3.add(JAddress);

		JPhone = new JTextField();
		JPhone.setColumns(10);
		JPhone.setBounds(411, 159, 163, 29);
		panel_3.add(JPhone);

		JEmail = new JTextField();
		JEmail.setColumns(10);
		JEmail.setBounds(411, 199, 163, 29);
		panel_3.add(JEmail);

		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setBounds(336, 125, 80, 16);
		panel_3.add(lblAddress);

		JLabel lblPhone = new JLabel("Phone :");
		lblPhone.setBounds(336, 165, 80, 16);
		panel_3.add(lblPhone);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(336, 205, 80, 16);
		panel_3.add(lblEmail);

		male = new JRadioButton("Male");
		male.setBackground(new Color(245, 244, 252));
		buttonGroupGender.add(male);
		male.setBounds(500, 75, 74, 25);
		panel_3.add(male);

		female = new JRadioButton("Female");
		female.setSelected(true);
		female.setBackground(new Color(245, 244, 252));
		buttonGroupGender.add(female);
		female.setBounds(411, 75, 80, 25);
		panel_3.add(female);

		JLabel lblEdit = new JLabel("Details");
		lblEdit.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdit.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblEdit.setBounds(345, 3, 86, 29);
		panel_3.add(lblEdit);

		loadData();
		gennerate();
	}

	// LoadData - NT
	private void loadData() {

		EmployeeModel employeeModel = new EmployeeModel();
		String[] columns = { "No. ", "Employee_ID", "Name", "Address", "Email", "Phone" };
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
			if (employee.getLevel().equals("librarian")) {
				defaultTableModel.addRow(new Object[] { no, employee.getEmployee_ID(), employee.getName(),
						employee.getAddress(), employee.getEmail(), employee.getPhone() });
				no++;
			}
		}
		JTableEmployee.setModel(defaultTableModel);

	}

	private void gennerate() {
		// Gennerate ID - NTanh
		EmployeeModel employeeModel = new EmployeeModel();
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
		String[] columns = { "No. ", "Employee_ID", "Name", "Address", "Email", "Phone" };
		String key = JSearch.getText();
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		for (String cl : columns) {
			defaultTableModel.addColumn(cl);
		}
		int no = 1;
		for (Employee employee : EmployeeModel.searchEmployee(key)) {
			defaultTableModel.addRow(new Object[] { no, employee.getEmployee_ID(), employee.getName(),
					employee.getAddress(), employee.getEmail(), employee.getPhone() });
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
			JOptionPane.showMessageDialog(null, "Please select a employee");
		}
	}

	// Add - NT
	public void Add_actionPerformed(ActionEvent e) {
		boolean flag = true;
		EmployeeModel employeeModel = new EmployeeModel();
		String employee_IDs = JEmployee_ID.getText().trim();
		String usernames = null;
		String names = null;
		String password = null;
		Boolean gender = true;
		String addresss = null;
		Date dob = null;
		String phone = null;
		String email = null;
		String level = "librarian";

		if (!JUsername.getText().trim().isEmpty()) {
			// employee.setEmployee_ID(employee_IDs);
			List<Employee> employees = employeeModel.findAll();
			for (Employee emp : employees) {
				if (JUsername.getText().trim().equals(emp.getName().trim())) {
					flag = false;
					JOptionPane.showMessageDialog(null, "Username has been existed !");
					break;
				}
			}
			if (flag)
				usernames = JUsername.getText().trim();
			if (!JPassword.getPassword().toString().equals("")) {
				if (CheckValidate.checkPassword(String.valueOf(JPassword.getPassword()))) {
					password = BCrypt.hashpw(JPassword.getPassword().toString(), BCrypt.gensalt());
					// employee.setPassword(BCrypt.hashpw(JPassword.getPassword().toString(),
					// BCrypt.gensalt()));
					if (CheckValidate.checkName(JName.getText().trim())) {
						names = JName.getText().trim();
						// employee.setName(names);
						if (JDateOfBirth.getDate() != null) {
							if (CheckValidate.checkDate(JDateOfBirth.getDate())) {
								dob = JDateOfBirth.getDate();
								// employee.setDob(JDateOfBirth.getDate());
								gender = true;
								if (getGenderSelected(buttonGroupGender).equalsIgnoreCase("female")) {
									gender = false;
									// employee.setGender(false);
								} else {
									gender = true;
									// employee.setGender(true);
								}

								if (!JAddress.getText().trim().isEmpty()) {
									addresss = JAddress.getText().trim();
//									employee.setAddress(addresss);

									if (CheckValidate.checkPhone(JPhone.getText().trim())) {
										phone = JPhone.getText().trim();
										// employee.setPhone(JPhone.getText().trim());

										if (CheckValidate.checkEmail(JEmail.getText().trim())) {
											email = JEmail.getText().trim();
											// employee.setEmail(JEmail.getText().trim());

											// employee.setLevel(level);
										} else {
											flag = false;
											JOptionPane.showMessageDialog(null, "Email must be emter");
										}
									} else {
										flag = false;
										JOptionPane.showMessageDialog(null, "Phone must be enter !");
									}
								} else {
									flag = false;
									JOptionPane.showMessageDialog(null, "Address must be enter");
								}
							} else {
								flag = false;
								JOptionPane.showMessageDialog(null, "You must be older than 18 ");
							}
						} else {
							flag = false;
							JOptionPane.showMessageDialog(null, "Date must be enter !");
						}
					} else {
						flag = false;
						JOptionPane.showMessageDialog(null, "Name must be enter and longer than 2 !");
					}
				} else {
					flag = false;
					JOptionPane.showMessageDialog(null, "Password must be longer");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Password must be enter !");
				flag = false;
			}
		} else {
			flag = false;
			JOptionPane.showMessageDialog(null, "Username must be enter !");
		}

		if (flag) {
			Employee employee = new Employee(employee_IDs, usernames, password, names, dob, gender, addresss, phone,
					email, level);
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
				JOptionPane.showMessageDialog(null, "Failed");
			}

		}

	}

	// Update - NT
	public void Update_actionPerformed(ActionEvent arg0) {
		boolean f = false;
		try {
			int selectedIndex = JTableEmployee.getSelectedRow();
			String employee_ID = JTableEmployee.getValueAt(selectedIndex, 1).toString();
			EmployeeModel employeeModel = new EmployeeModel();
			Employee employee = employeeModel.getById(employee_ID);

			if (JEmployee_ID.getText().trim() != null) {
				employee.setName(JEmployee_ID.getText().trim());
				f = true;
			} else {
				f = false;
				JOptionPane.showMessageDialog(null, "Employee_ID must be enter !");
			}
			if (JUsername.getText().trim() != null) {
				employee.setUsername(JUsername.getText().trim());
				f = true;
			} else {
				f = false;
				JOptionPane.showMessageDialog(null, "Username must be enter !");
			}
			if (CheckValidate.checkPassword(String.valueOf(JPassword.getPassword()))) {
				String pass = BCrypt.hashpw(String.valueOf(JPassword.getPassword()), BCrypt.gensalt());
				employee.setPassword(pass);
				f = true;
			}
			String emails = JEmail.getText().trim();
			if (emails != null && emails.length() >= 2) {
				if (CheckValidate.checkEmail(JEmail.getText().trim())) {
					employee.setEmail(JEmail.getText());
					f = true;
				}
			} else {
				f = false;
				JOptionPane.showMessageDialog(null, "Email must be enter !");
			}
			if (JDateOfBirth.getDate() != null) {
				if (CheckValidate.checkDate(JDateOfBirth.getDate())) {
					employee.setDob(JDateOfBirth.getDate());
					f = true;
				}
			} else {
				f = false;
				JOptionPane.showMessageDialog(null, "Date must be enter !");
			}
			String genders = getGenderSelected(buttonGroupGender);
			if (genders != null) {
				if (genders.equalsIgnoreCase("female")) {
					employee.setGender(false);
				} else {
					employee.setGender(true);
				}
				f = true;
			} else {
				f = false;
				JOptionPane.showMessageDialog(null, "Gender must be checked !");
			}
			String addresss = JAddress.getText().trim();
			if (addresss != null && addresss.length() >= 2) {
				employee.setAddress(addresss);
				f = true;
			} else {
				f = false;
				JOptionPane.showMessageDialog(null, "Address must be enter !");
			}
			String phones = JPhone.getText().trim();

			if (phones != null && phones.length() >= 2) {
				if (CheckValidate.checkPhone(phones)) {
					employee.setPhone(JPhone.getText().trim());
					f = true;
				}
			} else {
				f = false;
				JOptionPane.showMessageDialog(null, "Phone must be enter !");
			}
			String names = JName.getText().trim();

			if (names != null && names.length() >= 2) {
				if (CheckValidate.checkName(names)) {
					employee.setName(JName.getText().trim());
					f = true;
				}
			} else {
				f = false;
				JOptionPane.showMessageDialog(null, "Name must be enter !");
			}
			String level = "librarian";
			employee.setLevel(level);

			System.err.println(employee_ID);
			if (employee_ID == null) {
				JOptionPane.showMessageDialog(null, "Please Select a employee");
			} else {
				if (f) {
					if (employeeModel.update(employee, employee_ID)) {
						JOptionPane.showMessageDialog(null, "Update Sucessfully");
						loadData();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Failed");
				}
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Please select a Employee");
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
		JEmployee_ID.setText(Employee_ID);
		JUsername.setText(employee.getUsername());
		JName.setText(employee.getName());
		JPassword.setText("");
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
		gennerate();
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
