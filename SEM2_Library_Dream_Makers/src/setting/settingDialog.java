package setting;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Employee;

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

public class settingDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField usernameField;
	private JTextField emailField;
	private JLabel userIcon;
	private JLabel emailIcon;
	private JLabel editEmail;
	private JPanel panelTitle;
	private int xPosition, yPosition, mouseX, mouseY;
	
	public static Employee employee = null;

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
		setBounds(100, 100, 406, 481);
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
		panelTitle.setBackground(new Color(51, 51, 51));
		panelTitle.setBounds(0, 0, 406, 34);
		contentPanel.add(panelTitle);
		panelTitle.setLayout(null);

		JPanel panelClose = new JPanel();
		panelClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelClose.setBackground(new Color(51, 51, 51));
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
				panelClose.setBackground(new Color(87, 87, 87));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelClose.setBackground(new Color(51, 51, 51));
			}
		});
		btnClose.setForeground(Color.RED);
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClose.setHorizontalAlignment(SwingConstants.CENTER);
		btnClose.setBounds(0, 0, 34, 34);
		panelClose.add(btnClose);

		JLabel lblNewLabel = new JLabel("Employee Info");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(100, 0, 205, 34);
		panelTitle.add(lblNewLabel);

		JPanel panelInfo = new JPanel();
		panelInfo.setBounds(0, 34, 406, 447);
		contentPanel.add(panelInfo);
		panelInfo.setLayout(new CardLayout(0, 0));

		JPanel panelAdmin = new JPanel();
		panelAdmin.setBackground(new Color(192, 192, 192));
		panelInfo.add(panelAdmin, "name_3160409670766300");
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
		editEmail.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editEmail.setBounds(339, 152, 25, 25);
		panelAdmin.add(editEmail);

		JPanel panelPW = new JPanel();
		panelPW.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelPW.setBackground(new Color(30, 144, 255));
		panelPW.setBounds(36, 209, 145, 36);
		panelAdmin.add(panelPW);
		panelPW.setLayout(null);

		JLabel btnChangePW = new JLabel("Change Password");
		btnChangePW.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					btnChangePW_mouseClicked(e);
				} catch (Exception e2) {
					showMessenger("Something was wrong! Please try again");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panelPW.setBackground(new Color(255, 51, 51));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelPW.setBackground(new Color(30, 144, 255));
			}
		});
		btnChangePW.setForeground(new Color(255, 255, 255));
		btnChangePW.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnChangePW.setHorizontalAlignment(SwingConstants.CENTER);
		btnChangePW.setBounds(0, 0, 145, 36);
		panelPW.add(btnChangePW);

		JPanel panelEmployee = new JPanel();
		panelInfo.add(panelEmployee, "name_3160412534971100");
		panelEmployee.setLayout(null);
		
		loadData();
	}
	
	private void loadData() {
		ImageIcon imgUser = resizeImg("src/data/loginForm/user.png", userIcon);
		userIcon.setIcon(imgUser);
		ImageIcon imgMail = resizeImg("src/data/loginForm/mail.png", emailIcon);
		emailIcon.setIcon(imgMail);
		ImageIcon imgEdit = resizeImg("src/data/loginForm/edit.png", editEmail);
		editEmail.setIcon(imgEdit);
		usernameField.setText(employee.getUsername());
		emailField.setText(employee.getEmail());
	}

	// Close the dialog
	private void btnClose_mouseClicked(MouseEvent e) {
		this.setVisible(false);
		this.dispose();
	}

	// Show change password dialog
	private void btnChangePW_mouseClicked(MouseEvent e) {
		ChangePW.employee = employee;
		ChangePW changePW = new ChangePW();
		changePW.setVisible(true);
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
