package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.CardLayout;

public class MainJFrame extends JFrame {

	private JPanel contentPane;
	private JLabel logo;
	private JPanel dashboard;
	private JPanel category;
	private JPanel employee;
	private JPanel author;
	private JPanel book;
	private JPanel member;
	private JPanel invoice;
	private JPanel report;
	private JPanel setting;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainJFrame frame = new MainJFrame();
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
	public MainJFrame() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel sideBarPanel = new JPanel();
		sideBarPanel.setBackground(new Color(51, 51, 51));
		sideBarPanel.setBounds(0, 0, 198, 600);
		contentPane.add(sideBarPanel);
		sideBarPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 198, 171);
		sideBarPanel.add(panel);
		panel.setLayout(null);

		logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setBounds(0, 2, 198, 42);
		panel.add(logo);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(37, 45, 121, 2);
		panel.add(panel_2);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(74, 51, 49, 49);
		panel.add(lblNewLabel_1);

		JLabel usernamelavf = new JLabel("Username:");
		usernamelavf.setForeground(Color.WHITE);
		usernamelavf.setFont(new Font("Tahoma", Font.BOLD, 12));
		usernamelavf.setBounds(10, 105, 89, 22);
		panel.add(usernamelavf);

		JLabel levasfk = new JLabel("Level:");
		levasfk.setForeground(Color.WHITE);
		levasfk.setFont(new Font("Tahoma", Font.BOLD, 12));
		levasfk.setBounds(10, 125, 89, 22);
		panel.add(levasfk);

		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setForeground(Color.WHITE);
		lblAdmin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAdmin.setBounds(99, 105, 89, 22);
		panel.add(lblAdmin);

		JLabel lblAdmin_1 = new JLabel("Admin");
		lblAdmin_1.setForeground(Color.WHITE);
		lblAdmin_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdmin_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAdmin_1.setBounds(99, 125, 89, 22);
		panel.add(lblAdmin_1);

		JLabel lblNewLabel_2 = new JLabel("Dream Makers");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Giddyup Std", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(10, 546, 178, 43);
		sideBarPanel.add(lblNewLabel_2);

		JPanel btnEmployee = new JPanel();
		btnEmployee.setBorder(new LineBorder(new Color(230, 230, 250)));
		btnEmployee.setBackground(new Color(51, 51, 51));
		btnEmployee.setBounds(0, 171, 198, 37);
		sideBarPanel.add(btnEmployee);
		btnEmployee.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(6, 202, 254));
		panel_4.setBounds(0, 0, 37, 37);
		btnEmployee.add(panel_4);
		panel_4.setLayout(null);

		JLabel iconEmployee = new JLabel("");
		iconEmployee.setBounds(0, 0, 37, 37);
		panel_4.add(iconEmployee);

		JLabel lblNewLabel_3 = new JLabel("EMPLOYEE");
		lblNewLabel_3.setForeground(new Color(6, 202, 254));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setBounds(58, 11, 88, 15);
		btnEmployee.add(lblNewLabel_3);

		JPanel btnBooks = new JPanel();
		btnBooks.setLayout(null);
		btnBooks.setBorder(new LineBorder(new Color(230, 230, 250)));
		btnBooks.setBackground(new Color(51, 51, 51));
		btnBooks.setBounds(0, 207, 198, 37);
		sideBarPanel.add(btnBooks);

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBorder(new LineBorder(new Color(230, 230, 250)));
		panel_4_1.setLayout(null);
		panel_4_1.setBackground(new Color(51, 51, 51));
		panel_4_1.setBounds(0, 0, 37, 37);
		btnBooks.add(panel_4_1);

		JLabel iconEmployee_1 = new JLabel("");
		iconEmployee_1.setBounds(0, 0, 37, 37);
		panel_4_1.add(iconEmployee_1);

		JLabel lblNewLabel_3_1 = new JLabel("BOOKS");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1.setForeground(new Color(192, 192, 192));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(58, 11, 88, 15);
		btnBooks.add(lblNewLabel_3_1);

		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(197, 33, 803, 567);
		contentPane.add(mainPanel);
		mainPanel.setLayout(new CardLayout(0, 0));

		dashboard = new JPanel();
		mainPanel.add("dashboard", dashboard);
		dashboard.setLayout(null);

		category = new JPanel();
		mainPanel.add("category", category);

		employee = new JPanel();
		mainPanel.add("employee", employee);

		author = new JPanel();
		mainPanel.add("author", author);

		book = new JPanel();
		mainPanel.add("book", book);

		member = new JPanel();
		mainPanel.add("member", member);

		invoice = new JPanel();
		mainPanel.add("invoice", invoice);

		report = new JPanel();
		mainPanel.add("report", report);

		setting = new JPanel();
		mainPanel.add("setting", setting);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\Project_Interface.png"));
		lblNewLabel.setBounds(0, 0, 1000, 600);
		contentPane.add(lblNewLabel);

		loadData();
	}

	private void loadData() {
		ImageIcon logoImage = resizeImg("src/data/Main/logo_Library.png", logo);
		logo.setIcon(logoImage);
		// Add panel for button sidebar
		dashboardPanel dashboardPanel = new dashboardPanel();
		dashboard.add(dashboardPanel);
		categoryPanel categoryPanel = new categoryPanel();
		category.add(categoryPanel);
		authorPanel authorPanel = new authorPanel();
		author.add(authorPanel);
		bookPanel bookPanel = new bookPanel();
		book.add(bookPanel);
		employeePanel employeePanel = new employeePanel();
		employee.add(employeePanel);
		memberPanel memberPanel = new memberPanel();
		member.add(memberPanel);
		reportPanel reportPanel = new reportPanel();
		report.add(reportPanel);
		settingPanel settingPanel = new settingPanel();
		setting.add(settingPanel);
		
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
}
