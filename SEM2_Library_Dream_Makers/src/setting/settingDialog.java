package setting;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Employee;
import model.EmployeeModel;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Cursor;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;

import com.sun.org.apache.xml.internal.security.keys.keyresolver.implementations.PrivateKeyResolver;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import checking.CheckValidate;

import java.awt.Rectangle;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

public class settingDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField usernameField;
	private static JTextField emailField;
	private JLabel userIcon;
	private JLabel emailIcon;
	private JLabel editEmail;
	private JPanel panelTitle;
	private int xPosition, yPosition, mouseX, mouseY;
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public static String employee_ID = null;
	public static Employee employee = null;

	private JPanel panelInfo;
	private JTextField txtEusername;
	private static JTextField txtEmail;
	private JTextField txtEname;
	private JTextField txtEphone;
	private JLabel titleLable;
	private JTextArea txtEaddress;
	private JDateChooser txtEdob;
	private JButton btnEdit;
	private final ButtonGroup genderGroup = new ButtonGroup();
	private JRadioButton radioFemale;
	private JRadioButton radioMale;
	private JLabel editEmail_1;
	private JLabel userIcon_1;
	private JLabel nameIcon;
	private JLabel phoneIcon;
	private JLabel emailIcon_1;
	private JLabel addressIcon;
	private JLabel calendarIcon;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			settingDialog dialog = new settingDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public settingDialog() {
		setModal(true);
		setUndecorated(true);
		setBounds(100, 100, 406, 645);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		panelTitle = new JPanel();
		panelTitle.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				try {
					panelTitle_mouseDragged(arg0);
				} catch (Exception e) {
					showMessenger("Something was wrong! Please try again");
				}
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				try {
					panelTitle_mouseMoved(e);
				} catch (Exception e2) {
					showMessenger("Something was wrong! Please try again");
				}
			}
		});
		panelTitle.setBackground(new Color(0, 102, 204));
		panelTitle.setBounds(0, 0, 406, 34);
		contentPanel.add(panelTitle);
		panelTitle.setLayout(null);

		JPanel panelClose = new JPanel();
		panelClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelClose.setBackground(new Color(0, 102, 204));
		panelClose.setBounds(372, 0, 34, 34);
		panelTitle.add(panelClose);
		panelClose.setLayout(null);

		JLabel btnClose = new JLabel("X");
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					btnClose_mouseClicked(e);
				} catch (Exception e2) {
					showMessenger("Something was wrong! Please try again");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panelClose.setBackground(new Color(0, 112, 224));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelClose.setBackground(new Color(0, 102, 204));
			}
		});
		btnClose.setForeground(Color.WHITE);
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClose.setHorizontalAlignment(SwingConstants.CENTER);
		btnClose.setBounds(0, 0, 34, 34);
		panelClose.add(btnClose);

		titleLable = new JLabel("Employee Info");
		titleLable.setFont(new Font("Tahoma", Font.BOLD, 15));
		titleLable.setForeground(Color.WHITE);
		titleLable.setHorizontalAlignment(SwingConstants.CENTER);
		titleLable.setBounds(100, 0, 205, 34);
		panelTitle.add(titleLable);

		panelInfo = new JPanel();
		panelInfo.setBounds(0, 34, 406, 611);
		contentPanel.add(panelInfo);
		panelInfo.setLayout(new CardLayout(0, 0));

		JPanel panelAdmin = new JPanel();
		panelAdmin.setBackground(new Color(192, 192, 192));
		panelInfo.add("adminSetting", panelAdmin);
		panelAdmin.setLayout(null);

		userIcon = new JLabel("");
		userIcon.setBounds(36, 31, 25, 25);
		panelAdmin.add(userIcon);

		JLabel usernameTxt = new JLabel("USERNAME");
		usernameTxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		usernameTxt.setBounds(74, 25, 132, 36);
		panelAdmin.add(usernameTxt);

		usernameField = new JTextField();
		usernameField.setBackground(new Color(255, 255, 255));
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		usernameField.setEditable(false);
		usernameField.setBounds(36, 61, 297, 29);
		panelAdmin.add(usernameField);
		usernameField.setColumns(10);

		emailIcon = new JLabel("");
		emailIcon.setBounds(36, 120, 25, 25);
		panelAdmin.add(emailIcon);

		JLabel emailTxt = new JLabel("MAIL");
		emailTxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		emailTxt.setBounds(74, 114, 132, 36);
		panelAdmin.add(emailTxt);

		emailField = new JTextField();
		emailField.setBackground(new Color(255, 255, 255));
		emailField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		emailField.setEditable(false);
		emailField.setColumns(10);
		emailField.setBounds(36, 150, 297, 29);
		panelAdmin.add(emailField);

		editEmail = new JLabel("");
		editEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					editEmail_mouseClicked(arg0);
				} catch (Exception e) {
					showMessenger("Something was wrong! Please try again");
				}
			}
		});
		editEmail.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editEmail.setBounds(339, 152, 25, 25);
		panelAdmin.add(editEmail);
		
		lblNewLabel = new JLabel("Change Password");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					btnChangePW_mouseClicked(arg0);
				} catch (Exception e) {
					showMessenger("Something was wrong! Please try again");
				}
			}
		});
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(36, 214, 109, 22);
		panelAdmin.add(lblNewLabel);

		JPanel panelEmployee = new JPanel();
		panelEmployee.setLayout(null);
		panelEmployee.setBackground(Color.LIGHT_GRAY);
		panelInfo.add("employeeSetting", panelEmployee);

		userIcon_1 = new JLabel("");
		userIcon_1.setBounds(36, 6, 25, 25);
		panelEmployee.add(userIcon_1);

		JLabel usernameTxt_1 = new JLabel("USERNAME");
		usernameTxt_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		usernameTxt_1.setBounds(74, 0, 132, 36);
		panelEmployee.add(usernameTxt_1);

		txtEusername = new JTextField();
		txtEusername.setBounds(new Rectangle(0, 0, 0, 25));
		txtEusername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEusername.setEditable(false);
		txtEusername.setColumns(10);
		txtEusername.setBackground(Color.WHITE);
		txtEusername.setBounds(36, 36, 297, 25);
		panelEmployee.add(txtEusername);

		emailIcon_1 = new JLabel("");
		emailIcon_1.setBounds(36, 270, 25, 25);
		panelEmployee.add(emailIcon_1);

		JLabel emailTxt_1 = new JLabel("MAIL");
		emailTxt_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		emailTxt_1.setBounds(74, 264, 132, 36);
		panelEmployee.add(emailTxt_1);

		txtEmail = new JTextField();
		txtEmail.setBounds(new Rectangle(0, 0, 0, 25));
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBackground(Color.WHITE);
		txtEmail.setBounds(36, 300, 297, 25);
		panelEmployee.add(txtEmail);

		editEmail_1 = new JLabel("");
		editEmail_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editEmail_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					editEmail_mouseClicked(arg0);
				} catch (Exception e) {
					showMessenger("Something was wrong! Please try again");
				}
			}
		});
		editEmail_1.setBounds(343, 300, 25, 25);
		panelEmployee.add(editEmail_1);

		nameIcon = new JLabel("");
		nameIcon.setBounds(36, 71, 25, 25);
		panelEmployee.add(nameIcon);

		JLabel usernameTxt_1_1 = new JLabel("NAME");
		usernameTxt_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		usernameTxt_1_1.setBounds(74, 65, 132, 36);
		panelEmployee.add(usernameTxt_1_1);

		txtEname = new JTextField();
		txtEname.setBounds(new Rectangle(0, 0, 0, 25));
		txtEname.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEname.setEditable(false);
		txtEname.setColumns(10);
		txtEname.setBackground(Color.WHITE);
		txtEname.setBounds(36, 101, 297, 25);
		panelEmployee.add(txtEname);

		phoneIcon = new JLabel("");
		phoneIcon.setBounds(36, 135, 25, 25);
		panelEmployee.add(phoneIcon);

		JLabel usernameTxt_1_1_1 = new JLabel("PHONE");
		usernameTxt_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		usernameTxt_1_1_1.setBounds(74, 129, 132, 36);
		panelEmployee.add(usernameTxt_1_1_1);

		txtEphone = new JTextField();
		txtEphone.setBounds(new Rectangle(0, 0, 0, 25));
		txtEphone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEphone.setEditable(false);
		txtEphone.setColumns(10);
		txtEphone.setBackground(Color.WHITE);
		txtEphone.setBounds(36, 165, 297, 25);
		panelEmployee.add(txtEphone);

		calendarIcon = new JLabel("");
		calendarIcon.setBounds(36, 199, 25, 25);
		panelEmployee.add(calendarIcon);

		JLabel usernameTxt_1_1_1_1 = new JLabel("DOB");
		usernameTxt_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		usernameTxt_1_1_1_1.setBounds(74, 193, 132, 36);
		panelEmployee.add(usernameTxt_1_1_1_1);

		txtEdob = new JDateChooser();
		txtEdob.setEnabled(false);
		JTextFieldDateEditor editor = (JTextFieldDateEditor) txtEdob.getDateEditor();
		editor.setEditable(false);
		txtEdob.setDateFormatString("dd/MM/yyyy");
		txtEdob.setBounds(new Rectangle(0, 0, 0, 25));
		txtEdob.setBounds(36, 235, 297, 25);
		panelEmployee.add(txtEdob);

		JPanel panelPW_1_1 = new JPanel();
		panelPW_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelPW_1_1.setLayout(null);
		panelPW_1_1.setBackground(new Color(30, 144, 255));
		panelPW_1_1.setBounds(130, 525, 145, 36);
		panelEmployee.add(panelPW_1_1);

		JLabel btnSubmit = new JLabel("SUBMIT");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					btnSubmit_mouseClicked(e);
				} catch (Exception e2) {
					showMessenger("Something was wrong! Please try again");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panelPW_1_1.setBackground(new Color(255, 51, 51));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelPW_1_1.setBackground(new Color(30, 144, 255));
			}
		});
		btnSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSubmit.setHorizontalAlignment(SwingConstants.CENTER);
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSubmit.setBounds(0, 0, 145, 36);
		panelPW_1_1.add(btnSubmit);

		addressIcon = new JLabel("");
		addressIcon.setBounds(36, 335, 25, 25);
		panelEmployee.add(addressIcon);

		JLabel emailTxt_1_1 = new JLabel("ADDRESS");
		emailTxt_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		emailTxt_1_1.setBounds(74, 329, 132, 36);
		panelEmployee.add(emailTxt_1_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 371, 297, 72);
		panelEmployee.add(scrollPane);

		txtEaddress = new JTextArea();
		txtEaddress.setEditable(false);
		txtEaddress.setWrapStyleWord(true);
		txtEaddress.setLineWrap(true);
		scrollPane.setViewportView(txtEaddress);

		btnEdit = new JButton("Edit");
		btnEdit.setBackground(new Color(30, 144, 255));
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					btnEdit_actionPerformed(arg0);
				} catch (Exception e) {
					showMessenger("Something was wrong! Please try again");
				}
			}
		});
		btnEdit.setBounds(339, 0, 67, 23);
		panelEmployee.add(btnEdit);

		radioFemale = new JRadioButton("Female");
		radioFemale.setBackground(Color.LIGHT_GRAY);
		genderGroup.add(radioFemale);
		radioFemale.setBounds(36, 450, 109, 23);
		panelEmployee.add(radioFemale);

		radioMale = new JRadioButton("Male");
		radioMale.setBackground(Color.LIGHT_GRAY);
		genderGroup.add(radioMale);
		radioMale.setBounds(188, 450, 109, 23);
		panelEmployee.add(radioMale);
		
		lblNewLabel_1 = new JLabel("Change Password");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					btnChangePW_mouseClicked(arg0);
				} catch (Exception e) {
					showMessenger("Something was wrong! Please try again");
				}
			}
		});
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_1.setBounds(36, 480, 119, 22);
		panelEmployee.add(lblNewLabel_1);

		loadData();
	}

	private void loadData() {
		// Declare Image
		ImageIcon imgUser = resizeImg("src/data/loginForm/user.png", userIcon);
		ImageIcon imgMail = resizeImg("src/data/loginForm/mail.png", emailIcon);
		ImageIcon imgEdit = resizeImg("src/data/loginForm/edit.png", editEmail);
		ImageIcon imgName = resizeImg("src/data/loginForm/name.png", nameIcon);
		ImageIcon imgAddress = resizeImg("src/data/loginForm/address.png", addressIcon);
		ImageIcon imgCalendarIcon = resizeImg("src/data/loginForm/calendar.png", calendarIcon);
		ImageIcon imgPhone = resizeImg("src/data/loginForm/phone.png", phoneIcon);
		CardLayout cl_panelInfo = (CardLayout) (panelInfo.getLayout());
		if (employee.getLevel().equals("admin")) {
			titleLable.setText("Admin Info");
			cl_panelInfo.show(panelInfo, "adminSetting");
			usernameField.setText(employee.getUsername());
			emailField.setText(employee.getEmail());
			editEmail.setIcon(imgEdit);
			emailIcon.setIcon(imgMail);
			userIcon.setIcon(imgUser);
		}
		if (employee.getLevel().equals("librarian")) {
			titleLable.setText("Employee Info");
			cl_panelInfo.show(panelInfo, "employeeSetting");
			editEmail_1.setIcon(imgEdit);
			emailIcon_1.setIcon(imgMail);
			userIcon_1.setIcon(imgUser);
			calendarIcon.setIcon(imgCalendarIcon);
			nameIcon.setIcon(imgName);
			addressIcon.setIcon(imgAddress);
			phoneIcon.setIcon(imgPhone);
			txtEusername.setText(employee.getUsername());
			txtEname.setText(employee.getName());
			txtEphone.setText(employee.getPhone());
			txtEmail.setText(employee.getEmail());
			txtEdob.setDate(employee.getDob());
			txtEaddress.setText(employee.getAddress());
			if (employee.isGender()) {
				radioMale.setSelected(true);
			} else {
				radioFemale.setSelected(true);
			}
		}
	}
	
	// Change email after submit
	public static void changeRealEmail(String email) {
		txtEmail.setText(email);
		emailField.setText(email);
	}

	// Close the dialog
	private void btnClose_mouseClicked(MouseEvent e) {
		this.setVisible(false);
		this.dispose();
	}

	// Show change password dialog
	private void btnChangePW_mouseClicked(MouseEvent e) {
		changePW();
	}

	private void changePW() {
		ChangePW.employee = employee;
		ChangePW changePW = new ChangePW();
		changePW.setVisible(true);
	}

	// Enable edit info
	private void btnEdit_actionPerformed(ActionEvent e) {
		txtEname.setEditable(true);
		txtEphone.setEditable(true);
		txtEaddress.setEditable(true);
		txtEdob.setEnabled(true);
	}

	// Change email button
	private void editEmail_mouseClicked(MouseEvent e) {
		changeEmail();
	}

	// Show change email dialog
	private void changeEmail() {
		ChangeEmail.employee = employee;
		ChangeEmail changeEmail = new ChangeEmail();
		changeEmail.setVisible(true);
	}

	// Submit change info
	private void btnSubmit_mouseClicked(MouseEvent e) {
		Employee employee_tmp = new Employee();
		String name = txtEname.getText().trim();
		Date dob = txtEdob.getDate();
		String address = txtEaddress.getText().trim();
		String phone = txtEphone.getText().trim();
		employee_tmp.setEmployee_ID(employee_ID);
		employee_tmp.setName(name);
		employee_tmp.setDob(dob);
		employee_tmp.setAddress(address);
		employee_tmp.setPhone(phone);
		employee_tmp.setPhoto("abc.png"); // Unfinish
		CheckValidate check = new CheckValidate();
		if (getRadioSelected(genderGroup).equalsIgnoreCase("female")) {
			employee_tmp.setGender(false);
		} else {
			employee_tmp.setGender(true);
		}
		if (name.isEmpty() || address.isEmpty() || phone.isEmpty()) {
			showMessenger("Please fill out all fields!");
		} else {
			if (!check.checkPhone(phone)) {
				showMessenger("Phone must be digit!");
			} else {
				if (!check.checkDate(dob)) {
					showMessenger("Must be than 18 years old!\nPlease choose DOB again");
				} else {
					if (!check.checkName(name)) {
						showMessenger("At least 2 characters of name!");
					} else {
						if (EmployeeModel.updateById(employee_tmp)) {
							showMessenger("Update success!");
						} else {
							showMessenger("Something was wrong! Please try again");
						}
					}
				}
			}

		}
	}

	// Get radio selected
	private String getRadioSelected(ButtonGroup buttonGroup) {
		Enumeration<AbstractButton> buttons = genderGroup.getElements();
		while (buttons.hasMoreElements()) {
			JRadioButton radioButton = (JRadioButton) buttons.nextElement();
			if (radioButton.isSelected()) {
				return radioButton.getText();
			}
		}
		return null;
	}

	// Drag & move window
	private void panelTitle_mouseDragged(MouseEvent e) {
		xPosition = e.getXOnScreen();
		yPosition = e.getYOnScreen();
		this.setLocation(xPosition - mouseX, yPosition - mouseY);
	}

	private void panelTitle_mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	// Show error message
	private void showMessenger(String mess) {
		JOptionPane.showMessageDialog(null, mess);
	}

	// Resize Image
	private ImageIcon resizeImg(String imgPath, JLabel jName) {
		if (imgPath != null) {
			ImageIcon myImg = null;
			myImg = new ImageIcon(imgPath);
			Image img = myImg.getImage();
			Image img2 = img.getScaledInstance(jName.getWidth(), jName.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(img2);
			return icon;
		} else {
			showMessenger("Image direction not path!");
			return null;
		}
	}
}
