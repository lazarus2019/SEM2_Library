package setting;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import checking.CheckValidate;
import entities.Employee;
import model.EmployeeModel;
import javax.swing.JTextField;

public class ChangeEmail extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel btnSubmit;
	private JPasswordField txtPW;
	private int xPosition, yPosition, mouseX, mouseY;
	private JLabel lockIcon;

	// Declare Variable
	private String oldPass, newPass, repeatPass = "";
	private EmployeeModel employeeModel = new EmployeeModel();
	public static Employee employee = null;
	private JLabel mailIcon;
	private JTextField newEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ChangeEmail dialog = new ChangeEmail();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ChangeEmail() {
		setModal(true);
		setUndecorated(true);
		setBounds(100, 100, 307, 282);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panelTitle = new JPanel();
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
		panelTitle.setBackground(new Color(51, 51, 51));
		panelTitle.setBounds(0, 0, 307, 34);
		contentPanel.add(panelTitle);
		panelTitle.setLayout(null);

		JPanel panelClose = new JPanel();
		panelClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelClose.setBackground(new Color(51, 51, 51));
		panelClose.setBounds(273, 0, 34, 34);
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
				panelClose.setBackground(new Color(87, 87, 87));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelClose.setBackground(new Color(51, 51, 51));
			}
		});
		btnClose.setForeground(Color.RED);
		btnClose.setHorizontalAlignment(SwingConstants.CENTER);
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClose.setBounds(0, 0, 34, 34);
		panelClose.add(btnClose);

		JLabel lblNewLabel_3 = new JLabel("Change Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(79, 0, 148, 34);
		panelTitle.add(lblNewLabel_3);

		JPanel panel = new JPanel();
		panel.setBounds(0, 33, 307, 248);
		contentPanel.add(panel);
		panel.setLayout(null);

		JPanel panelSubmit = new JPanel();
		panelSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelSubmit.setBackground(new Color(30, 144, 255));
		panelSubmit.setBounds(53, 180, 200, 40);
		panel.add(panelSubmit);
		panelSubmit.setLayout(null);

		btnSubmit = new JLabel("SUBMIT");
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
				panelSubmit.setBackground(new Color(255, 51, 51));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelSubmit.setBackground(new Color(30, 144, 255));
			}
		});
		btnSubmit.setForeground(new Color(255, 255, 255));
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSubmit.setHorizontalAlignment(SwingConstants.CENTER);
		btnSubmit.setBounds(0, 0, 200, 40);
		panelSubmit.add(btnSubmit);

		mailIcon = new JLabel("");
		mailIcon.setBounds(24, 11, 25, 25);
		panel.add(mailIcon);

		JLabel lblNewLabel_1 = new JLabel("NEW EMAIL");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(56, 11, 141, 25);
		panel.add(lblNewLabel_1);

		txtPW = new JPasswordField();
		txtPW.setBounds(24, 124, 258, 25);
		panel.add(txtPW);

		lockIcon = new JLabel("");
		lockIcon.setBounds(24, 88, 25, 25);
		panel.add(lockIcon);

		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(56, 88, 141, 25);
		panel.add(lblNewLabel_1_1);
		
		newEmail = new JTextField();
		newEmail.setBounds(24, 47, 258, 25);
		panel.add(newEmail);
		newEmail.setColumns(10);

		loadData();
	}
	
	// Load data
		private void loadData() {			
			ImageIcon lockIconn = resizeImg("src/data/loginForm/lock.png", lockIcon);			
			lockIcon.setIcon(lockIconn);
			ImageIcon mailIconn = resizeImg("src/data/loginForm/mail.png", mailIcon);
			mailIcon.setIcon(mailIconn);
			
		}

		// Submit change password
		private void btnSubmit_mouseClicked(MouseEvent e) {
			String newE = newEmail.getText().trim();
			String password = String.valueOf(txtPW.getPassword());
			if(newE.isEmpty() || password.isEmpty()) {
				showMessenger("Please fill out all fields!");
			}else {
				CheckValidate checkValidate = new CheckValidate();
				if(checkValidate.checkEmail(newE)) {
					Employee employee_check = employeeModel.checkLogin(employee.getUsername());
					String passDB = employee_check.getPassword();
					if(password.equals(employeeModel.decryptPassword(passDB))){
						if(employeeModel.changeEmail(employee.getEmployee_ID(), newE)) {
							showMessenger("Change email success!");
							this.setVisible(false);
							this.dispose();
						}else {
							showMessenger("Something was wrong! Please try again");
						}
					}else {
						showMessenger("Wrong password!");
					}
				}else {
					showMessenger("Wrong type mail\n" + "Sample: abcxyz@gmail.com\n" + "Or: abcxyz@GMAIL.COM");
				}
			}
		}

		// Show password
		private void isShowPassword_actionPerformed(ActionEvent e) {

		}

		// Close the dialog
		private void btnClose_mouseClicked(MouseEvent e) {
			this.setVisible(false);
			this.dispose();
		}

		// Show error message
		private void showMessenger(String mess) {
			JOptionPane.showMessageDialog(null, mess);
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
