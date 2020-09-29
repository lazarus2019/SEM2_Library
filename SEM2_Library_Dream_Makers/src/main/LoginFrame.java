package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Cursor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.BoxLayout;
import java.awt.event.MouseMotionAdapter;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JLabel loginImage;
	private JLabel lockIcon;
	private JLabel userIcon;

	// Declare variable
	private String username = null;
	private String password = null;
	private int xPosition, yPosition, mouseX, mouseY;

	// Declare Frame
	private ForgotPasswordDialog forgotPasswordDialog = new ForgotPasswordDialog();

//	private Image img = new ImageIcon(LoginFrame.class.getResource("data/loginForm/loginImage.png")).getImage()
//			.getScaledInstance(90, 90, Image.SCALE_SMOOTH);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));
		panel.setBounds(0, 36, 248, 364);
		contentPane.add(panel);
		panel.setLayout(null);

		loginImage = new JLabel("");
		loginImage.setIcon(null);
		loginImage.setBounds(26, 36, 190, 179);
		panel.add(loginImage);

		JLabel lblNewLabel_5 = new JLabel("Monica's Library");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 21));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(26, 243, 190, 44);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_4 = new JLabel("---Stay hungry - Stay Foolish---");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(10, 286, 228, 22);
		panel.add(lblNewLabel_4);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(246, 36, 354, 364);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		usernameField = new JTextField();
		usernameField.setBorder(null);
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		usernameField.setBounds(31, 97, 276, 37);
		panel_1.add(usernameField);
		usernameField.setColumns(10);

		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(61, 69, 80, 22);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(120, 11, 114, 47);
		panel_1.add(lblNewLabel_1);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					btnLogin_actionPerformed(arg0);
				} catch (Exception e) {
					showMessenger("Something was wrong! Please try again");
				}
			}
		});
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setVerifyInputWhenFocusTarget(false);
		btnLogin.setDefaultCapable(false);
		btnLogin.setBorderPainted(false);
		btnLogin.setBackground(new Color(255, 51, 51));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Arial", Font.BOLD, 14));
		btnLogin.setBounds(31, 249, 276, 31);
		panel_1.add(btnLogin);

		JLabel FGPassword = new JLabel("Forgot password? CLick here");
		FGPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					FGPassword_mouseClicked(arg0);
				} catch (Exception e) {
					showMessenger("Something was wrong! Please try again");
				}
			}
		});
		FGPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		FGPassword.setForeground(Color.BLUE);
		FGPassword.setFont(new Font("Tahoma", Font.ITALIC, 11));
		FGPassword.setBounds(31, 301, 145, 22);
		panel_1.add(FGPassword);

		passwordField = new JPasswordField();
		passwordField.setBorder(null);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.setBounds(31, 183, 276, 37);
		panel_1.add(passwordField);

		userIcon = new JLabel("");
		userIcon.setBounds(31, 69, 25, 25);
		panel_1.add(userIcon);

		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBounds(61, 155, 80, 22);
		panel_1.add(lblPassword);

		lockIcon = new JLabel("");
		lockIcon.setBounds(31, 155, 25, 25);
		panel_1.add(lockIcon);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(31, 134, 276, 2);
		panel_1.add(panel_3);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(Color.BLACK);
		panel_3_1.setBounds(31, 220, 276, 2);
		panel_1.add(panel_3_1);

		JPanel panel_2 = new JPanel();
		panel_2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				try {
					panel_2_mouseDragged(arg0);
				} catch (Exception e) {
					showMessenger("Something was wrong! Please try again");
				}				
			}
			@Override
			public void mouseMoved(MouseEvent e) {
				try {
					panel_2_mouseMoved(e);
				} catch (Exception e2) {
					showMessenger("Something was wrong! Please try again");
				}	
			}
		});
		panel_2.setBackground(new Color(51, 51, 51));
		panel_2.setBounds(0, 0, 600, 36);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JPanel panelMininize = new JPanel();
		panelMininize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelMininize.setBackground(new Color(51, 51, 51));
		panelMininize.setBounds(528, 0, 36, 36);
		panel_2.add(panelMininize);
		panelMininize.setLayout(null);

		JLabel btnMinimize = new JLabel("_");
		btnMinimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMinimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					btnMinimize_mouseClicked(e);
				} catch (Exception e2) {
					showMessenger("Something was wrong! Please try again");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panelMininize.setBackground(new Color(87, 87, 87));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelMininize.setBackground(new Color(51, 51, 51));
			}
		});
		btnMinimize.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMinimize.setForeground(Color.RED);
		btnMinimize.setHorizontalAlignment(SwingConstants.CENTER);
		btnMinimize.setBounds(0, 0, 36, 36);
		panelMininize.add(btnMinimize);

		JPanel panelClose = new JPanel();
		panelClose.setLayout(null);
		panelClose.setBackground(new Color(51, 51, 51));
		panelClose.setBounds(564, 0, 36, 36);
		panel_2.add(panelClose);

		JLabel btnClose = new JLabel("X");
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
		btnClose.setHorizontalAlignment(SwingConstants.CENTER);
		btnClose.setForeground(Color.RED);
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClose.setBounds(0, 0, 36, 36);
		panelClose.add(btnClose);

		loadData();
	}

	private void loadData() {
		ImageIcon imgLogin = resizeImg("src/data/loginForm/loginImage.png", loginImage);
		loginImage.setIcon(imgLogin);
		ImageIcon imgUser = resizeImg("src/data/loginForm/user.png", userIcon);
		userIcon.setIcon(imgUser);
		ImageIcon imgLock = resizeImg("src/data/loginForm/lock.png", lockIcon);
		lockIcon.setIcon(imgLock);
	}

	// Login to system
	private void btnLogin_actionPerformed(ActionEvent e) {
		username = usernameField.getText().trim();
		password = String.valueOf(passwordField.getPassword());
		if (username.isEmpty() || password.isEmpty()) {
			showMessenger("Please fill out all fields!");
		} else {
			// Query account
		}
	}

	// Show Forgot Password Dialog
	private void FGPassword_mouseClicked(MouseEvent e) {
		forgotPasswordDialog.setVisible(true);
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

	// Minimize & Close button
	// Minimize app
	private void btnMinimize_mouseClicked(MouseEvent e) {
		this.setState(LoginFrame.ICONIFIED);
	}
	
	// Close app
	private void btnClose_mouseClicked(MouseEvent e) {
		System.exit(0);
	}
	
	// Drag & move window
	private void panel_2_mouseDragged(MouseEvent e) {
		xPosition = e.getXOnScreen();
		yPosition = e.getYOnScreen();
		this.setLocation(xPosition - mouseX, yPosition - mouseY);
	}
	
	private void panel_2_mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}
}
