package setting;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.mindrot.jbcrypt.BCrypt;

import entities.Employee;
import model.EmployeeModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePW extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel btnSubmit;
	private JPasswordField oldPW;
	private JPasswordField newPW;
	private JPasswordField repeatPW;
	private int xPosition, yPosition, mouseX, mouseY;
	private JLabel lockIcon3;
	private JLabel lockIcon2;
	private JLabel lockIcon1;
	private JCheckBox isShowPassword;

	// Declare Variable
	private String oldPass, newPass, repeatPass = "";
	private EmployeeModel employeeModel = new EmployeeModel();
	public static Employee employee = null;

	public static void main(String[] args) {
		try {
			ChangePW dialog = new ChangePW();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ChangePW() {
		setModal(true);
		setUndecorated(true);
		setBounds(100, 100, 307, 373);
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
		panelTitle.setBackground(new Color(0, 102, 204));
		panelTitle.setBounds(0, 0, 307, 34);
		contentPanel.add(panelTitle);
		panelTitle.setLayout(null);

		JPanel panelClose = new JPanel();
		panelClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelClose.setBackground(new Color(0, 102, 204));
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
				panelClose.setBackground(new Color(0, 112, 224));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelClose.setBackground(new Color(0, 102, 204));
			}
		});
		btnClose.setForeground(Color.WHITE);
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
		panel.setBounds(0, 33, 307, 340);
		contentPanel.add(panel);
		panel.setLayout(null);

		JPanel panelSubmit = new JPanel();
		panelSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelSubmit.setBackground(new Color(30, 144, 255));
		panelSubmit.setBounds(53, 275, 200, 40);
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

		lockIcon3 = new JLabel("");
		lockIcon3.setBounds(24, 11, 25, 25);
		panel.add(lockIcon3);

		JLabel lblNewLabel_1 = new JLabel("OLD PASSWORD");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(56, 11, 141, 25);
		panel.add(lblNewLabel_1);

		oldPW = new JPasswordField();
		oldPW.setBounds(24, 47, 258, 25);
		panel.add(oldPW);

		newPW = new JPasswordField();
		newPW.setBounds(24, 124, 258, 25);
		panel.add(newPW);

		lockIcon2 = new JLabel("");
		lockIcon2.setBounds(24, 88, 25, 25);
		panel.add(lockIcon2);

		JLabel lblNewLabel_1_1 = new JLabel("NEW PASSWORD");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(56, 88, 141, 25);
		panel.add(lblNewLabel_1_1);

		repeatPW = new JPasswordField();
		repeatPW.setBounds(24, 202, 258, 25);
		panel.add(repeatPW);

		lockIcon1 = new JLabel("");
		lockIcon1.setBounds(24, 166, 25, 25);
		panel.add(lockIcon1);

		JLabel lblNewLabel_1_1_1 = new JLabel("REPEAT PASSWORD");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(56, 166, 141, 25);
		panel.add(lblNewLabel_1_1_1);

		isShowPassword = new JCheckBox("Show password");
		isShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					isShowPassword_actionPerformed(arg0);
				} catch (Exception e) {
					showMessenger("Something was wrong! Please try again");
				}
			}
		});
		isShowPassword.setBounds(95, 245, 117, 23);
		panel.add(isShowPassword);

		loadData();
	}

	// Load data
	private void loadData() {
		ImageIcon lockIcon = resizeImg("src/data/loginForm/lock.png", lockIcon1);
		lockIcon1.setIcon(lockIcon);
		lockIcon2.setIcon(lockIcon);
		lockIcon3.setIcon(lockIcon);
	}

	// Submit change password
	private void btnSubmit_mouseClicked(MouseEvent e) {
		oldPass = String.valueOf(oldPW.getPassword());
		newPass = String.valueOf(newPW.getPassword());
		repeatPass = String.valueOf(repeatPW.getPassword());
		Employee employee_check = employeeModel.checkLogin(employee.getUsername());
		String passDB = employee_check.getPassword();
		if (oldPass.isEmpty() || newPass.isEmpty() || repeatPass.isEmpty()) {
			showMessenger("Please fill out all fields!");
		} else {
			if (BCrypt.checkpw(oldPass, passDB)) {
				if (oldPass.equals(newPass)) {
					showMessenger("New password must be different from old password");
				} else {
					if (newPass.equals(repeatPass)) {
						String password_hash = employeeModel.encryptPassword(newPass);
						if (employeeModel.changePassword(employee.getEmployee_ID(), password_hash)) {
							showMessenger("Change password success!");
							this.setVisible(false);
							this.dispose();
						} else {
							showMessenger("Something was wrong! Please try again");
						}
					} else {
						showMessenger("Repeat Password not match!");
					}
				}
			} else {
				showMessenger("Wrong password");
			}
		}
	}

	// Show password
	private void isShowPassword_actionPerformed(ActionEvent e) {
		if (isShowPassword.isSelected()) {
			newPW.setEchoChar((char) 0);
			repeatPW.setEchoChar((char) 0);
		} else {
			newPW.setEchoChar('*');
			repeatPW.setEchoChar('*');
		}
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
