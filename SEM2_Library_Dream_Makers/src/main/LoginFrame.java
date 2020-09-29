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

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel loginImage;
	private JLabel lock;
	private JLabel user;

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

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(31, 97, 276, 37);
		panel_1.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(61, 69, 80, 22);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(120, 11, 114, 47);
		panel_1.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setVerifyInputWhenFocusTarget(false);
		btnNewButton.setDefaultCapable(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(255, 51, 51));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(31, 249, 276, 31);
		panel_1.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("Forgot password? CLick here");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_2.setBounds(31, 301, 145, 22);
		panel_1.add(lblNewLabel_2);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.setBounds(31, 183, 276, 37);
		panel_1.add(passwordField);
		
		user = new JLabel("");
		user.setBounds(31, 69, 25, 25);
		panel_1.add(user);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBounds(61, 155, 80, 22);
		panel_1.add(lblPassword);
		
		lock = new JLabel("");
		lock.setBounds(31, 155, 25, 25);
		panel_1.add(lock);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 51, 51));
		panel_2.setBounds(0, 0, 600, 36);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("X");
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					System.exit(0);
				} catch (Exception e) {
					showMessenger("Can't close application");
				}
			}
		});
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(569, 0, 31, 36);
		panel_2.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("_");
		lblNewLabel_3_1.addFocusListener(new FocusAdapter() {
			@Override
			// Close JFrame
			public void focusGained(FocusEvent arg0) {
				lblNewLabel_3_1.setBackground(Color.BLACK);
			}
		});
		lblNewLabel_3_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3_1.addMouseListener(new MouseAdapter() {
			@Override
			// Set minimize for JFrame
			public void mouseClicked(MouseEvent e) {
				try {
					setState(LoginFrame.ICONIFIED);
				} catch (Exception e2) {
					showMessenger("Can not minimize application!");
				}
			}
		});
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(Color.RED);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(535, 0, 31, 36);
		panel_2.add(lblNewLabel_3_1);
		
		loadData();
	}
	
	private void loadData() {
		ImageIcon imgLogin = resizeImg("src/data/loginForm/loginImage.png", loginImage);
		loginImage.setIcon(imgLogin);
		ImageIcon imgUser = resizeImg("src/data/loginForm/user.png", user);
		user.setIcon(imgUser);
		ImageIcon imgLock = resizeImg("src/data/loginForm/lock.png", lock);
		lock.setIcon(imgLock);
	}

	// Show error message
	private void showMessenger(String mess) {
		JOptionPane.showMessageDialog(null, mess);
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
			JOptionPane.showMessageDialog(null, "Image direction not path!");
			return null;
		}
	}
}
