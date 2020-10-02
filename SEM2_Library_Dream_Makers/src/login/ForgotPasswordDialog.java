package login;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Employee;
import main.AdminJFrame;
import main.EmployeeJFrame;
import model.EmployeeModel;
import model.SendMail;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.event.MouseMotionAdapter;

public class ForgotPasswordDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField emailField;
	private JLabel mailIcon;
	private JLabel lblNewLabel_2;
	private JLabel btnClose;
	private JPanel panelClose;
	
	// Declare variable
	private String email = null;
	private int xPosition, yPosition, mouseX, mouseY;
	private JPanel panel_1;
	
	// Declare Frame

	// Declare Class
	private EmployeeModel employeeModel = new EmployeeModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ForgotPasswordDialog dialog = new ForgotPasswordDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ForgotPasswordDialog() {
		setModal(true);
		getContentPane().setEnabled(false);
		setUndecorated(true);
		setBounds(100, 100, 400, 285);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Forgot Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(100, 39, 199, 36);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("EMAIL");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(65, 86, 102, 25);
		contentPanel.add(lblNewLabel_1);
		
		emailField = new JTextField();
		emailField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		emailField.setBorder(null);
		emailField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		emailField.setBounds(32, 116, 335, 37);
		contentPanel.add(emailField);
		emailField.setColumns(10);
		
		JButton btnSend = new JButton("SEND");
		btnSend.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					btnSend_actionPerformed(arg0);					
				} catch (Exception e) {
					showMessenger("Something was wrong! Please try again Please try again");
				}
			}
		});
		btnSend.setForeground(Color.WHITE);
		btnSend.setBackground(new Color(255, 51, 51));
		btnSend.setFont(new Font("Arial", Font.BOLD, 14));
		btnSend.setBounds(31, 193, 335, 36);
		contentPanel.add(btnSend);
		
		mailIcon = new JLabel("");
		mailIcon.setBounds(34, 86, 25, 25);
		contentPanel.add(mailIcon);
		
		lblNewLabel_2 = new JLabel("You must fill out all fields to get password back!");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_2.setBounds(33, 241, 334, 31);
		contentPanel.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				try {
					panel_mouseDragged(arg0);
				} catch (Exception e) {
					showMessenger("Something was wrong! Please try again");
				}				
			}
			@Override
			public void mouseMoved(MouseEvent e) {
				try {
					panel_mouseMoved(e);
				} catch (Exception e2) {
					showMessenger("Something was wrong! Please try again");
				}	
			}
		});
		panel.setBackground(new Color(51, 51, 51));
		panel.setBounds(0, 0, 400, 36);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		panelClose = new JPanel();
		panelClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelClose.setBackground(new Color(51, 51, 51));
		panelClose.setBounds(364, 0, 36, 36);
		panel.add(panelClose);
		panelClose.setLayout(null);
		
		btnClose = new JLabel("X");
		btnClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClose.setForeground(Color.RED);
		btnClose.setHorizontalAlignment(SwingConstants.CENTER);
		btnClose.setBounds(0, 0, 36, 36);
		panelClose.add(btnClose);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(32, 153, 335, 2);
		contentPanel.add(panel_1);
		
		loadData();
	}
	
	private void loadData() {
		ImageIcon imgUser = resizeImg("src/data/loginForm/user.png", mailIcon);
		mailIcon.setIcon(imgUser);
	}
	
	// =====Resize Image=====
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

	// Show error message
	private void showMessenger(String mess) {
		JOptionPane.showMessageDialog(null, mess);
	}
	
	// Send password to email
	private void btnSend_actionPerformed(ActionEvent e) {
		email = emailField.getText().trim();
		if(email.isEmpty()) {
			showMessenger("You must fill out all fields to get password back!");			
		}else {
			// Query username
			Employee employee = employeeModel.forGotPass(email);
			if (employee == null) {
				showMessenger("Email does not exist!");
			} else {				
				String password = employee.getPassword();
				SendMail sendMail = new SendMail();
				if(sendMail.sendMailPassword(email, password)) {
					showMessenger("Please check your mail!");
					this.setVisible(false);
					this.dispose();
				}else {
					showMessenger("Send Failed! Please try again");
				};
				
			}
		}
	}
	
	// Close button
	private void btnClose_mouseClicked(MouseEvent e) {
		this.dispose();
		this.setVisible(false);
	}
	
	// Drag & move window
	private void panel_mouseDragged(MouseEvent e) {
		xPosition = e.getXOnScreen();
		yPosition = e.getYOnScreen();
		this.setLocation(xPosition - mouseX, yPosition - mouseY);
	}
	
	private void panel_mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}
}
