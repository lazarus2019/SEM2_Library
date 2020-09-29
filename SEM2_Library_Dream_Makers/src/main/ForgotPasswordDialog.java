package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
	private JTextField usernameField;
	private JTextField mailField;
	private JLabel userIcon;
	private JLabel mailIcon;
	private JLabel lblNewLabel_2;
	private JLabel btnClose;
	private JPanel panelClose;
	
	// Declare variable
	private String username = null;
	private String mail = null;
	private int xPosition, yPosition, mouseX, mouseY;
	private JPanel panel_1;
	private JPanel panel_2;

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
		setBounds(100, 100, 400, 339);
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
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(65, 86, 102, 25);
		contentPanel.add(lblNewLabel_1);
		
		usernameField = new JTextField();
		usernameField.setBorder(null);
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		usernameField.setBounds(32, 116, 335, 37);
		contentPanel.add(usernameField);
		usernameField.setColumns(10);
		
		JButton btnSend = new JButton("SEND");
		btnSend.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		btnSend.setBounds(32, 248, 335, 36);
		contentPanel.add(btnSend);
		
		userIcon = new JLabel("");
		userIcon.setBounds(34, 86, 25, 25);
		contentPanel.add(userIcon);
		
		JLabel lblNewLabel_1_1 = new JLabel("MAIL");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(65, 164, 102, 25);
		contentPanel.add(lblNewLabel_1_1);
		
		mailIcon = new JLabel("");
		mailIcon.setBounds(34, 164, 25, 25);
		contentPanel.add(mailIcon);
		
		mailField = new JTextField();
		mailField.setBorder(null);
		mailField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mailField.setColumns(10);
		mailField.setBounds(32, 194, 335, 37);
		contentPanel.add(mailField);
		
		lblNewLabel_2 = new JLabel("You must fill out all fields to get password back!");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_2.setBounds(34, 296, 334, 31);
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
		panelClose.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panelClose.setBackground(new Color(51, 51, 51));
		panelClose.setBounds(364, 0, 36, 36);
		panel.add(panelClose);
		panelClose.setLayout(null);
		
		btnClose = new JLabel("X");
		btnClose.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
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
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(32, 231, 335, 2);
		contentPanel.add(panel_2);
		
		loadData();
	}
	
	private void loadData() {
		ImageIcon imgUser = resizeImg("src/data/loginForm/user.png", userIcon);
		userIcon.setIcon(imgUser);
		ImageIcon imgMail = resizeImg("src/data/loginForm/mail.png", mailIcon);
		mailIcon.setIcon(imgMail);
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
		username = usernameField.getText().trim();
		mail = mailField.getText().trim();
		if(username.isEmpty() || mail.isEmpty()) {
			showMessenger("You must fill out all fields to get password back!");			
		}else {
			// Query username
			
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
