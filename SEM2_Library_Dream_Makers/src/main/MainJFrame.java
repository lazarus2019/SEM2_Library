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
		setBounds(100, 100, 1000, 650);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel sideBarPanel = new JPanel();
		sideBarPanel.setBackground(new Color(51, 51, 51));
		sideBarPanel.setBounds(0, 0, 198, 650);
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
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(45, 616, 107, 23);
		sideBarPanel.add(lblNewLabel_2);

		JPanel btnDashboard = new JPanel();
		btnDashboard.setBorder(new LineBorder(new Color(230, 230, 250)));
		btnDashboard.setBackground(new Color(51, 51, 51));
		btnDashboard.setBounds(0, 171, 198, 37);
		sideBarPanel.add(btnDashboard);
		btnDashboard.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(6, 202, 254));
		panel_4.setBounds(0, 0, 37, 37);
		btnDashboard.add(panel_4);
		panel_4.setLayout(null);

		JLabel iconEmployee = new JLabel("");
		iconEmployee.setBounds(0, 0, 37, 37);
		panel_4.add(iconEmployee);

		JLabel lblNewLabel_3 = new JLabel("DASHBOARD");
		lblNewLabel_3.setForeground(new Color(6, 202, 254));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setBounds(58, 11, 130, 15);
		btnDashboard.add(lblNewLabel_3);

		JPanel btnCategory = new JPanel();
		btnCategory.setLayout(null);
		btnCategory.setBorder(new LineBorder(new Color(230, 230, 250)));
		btnCategory.setBackground(new Color(51, 51, 51));
		btnCategory.setBounds(0, 207, 198, 37);
		sideBarPanel.add(btnCategory);

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBorder(new LineBorder(new Color(230, 230, 250)));
		panel_4_1.setLayout(null);
		panel_4_1.setBackground(new Color(51, 51, 51));
		panel_4_1.setBounds(0, 0, 37, 37);
		btnCategory.add(panel_4_1);

		JLabel iconEmployee_1 = new JLabel("");
		iconEmployee_1.setBounds(0, 0, 37, 37);
		panel_4_1.add(iconEmployee_1);

		JLabel lblNewLabel_3_1 = new JLabel("CATEGORY");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1.setForeground(new Color(192, 192, 192));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(58, 11, 130, 15);
		btnCategory.add(lblNewLabel_3_1);
		
		JPanel btnEmployee = new JPanel();
		btnEmployee.setLayout(null);
		btnEmployee.setBorder(new LineBorder(new Color(230, 230, 250)));
		btnEmployee.setBackground(new Color(51, 51, 51));
		btnEmployee.setBounds(0, 243, 198, 37);
		sideBarPanel.add(btnEmployee);
		
		JPanel panel_4_1_1 = new JPanel();
		panel_4_1_1.setLayout(null);
		panel_4_1_1.setBorder(new LineBorder(new Color(230, 230, 250)));
		panel_4_1_1.setBackground(new Color(51, 51, 51));
		panel_4_1_1.setBounds(0, 0, 37, 37);
		btnEmployee.add(panel_4_1_1);
		
		JLabel iconEmployee_1_1 = new JLabel("");
		iconEmployee_1_1.setBounds(0, 0, 37, 37);
		panel_4_1_1.add(iconEmployee_1_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("EMPLOYEE");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1.setBounds(58, 11, 88, 15);
		btnEmployee.add(lblNewLabel_3_1_1);
		
		JPanel btnAuthor = new JPanel();
		btnAuthor.setLayout(null);
		btnAuthor.setBorder(new LineBorder(new Color(230, 230, 250)));
		btnAuthor.setBackground(new Color(51, 51, 51));
		btnAuthor.setBounds(0, 279, 198, 37);
		sideBarPanel.add(btnAuthor);
		
		JPanel panel_4_1_1_1 = new JPanel();
		panel_4_1_1_1.setLayout(null);
		panel_4_1_1_1.setBorder(new LineBorder(new Color(230, 230, 250)));
		panel_4_1_1_1.setBackground(new Color(51, 51, 51));
		panel_4_1_1_1.setBounds(0, 0, 37, 37);
		btnAuthor.add(panel_4_1_1_1);
		
		JLabel iconEmployee_1_1_1 = new JLabel("");
		iconEmployee_1_1_1.setBounds(0, 0, 37, 37);
		panel_4_1_1_1.add(iconEmployee_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("AUTHOR");
		lblNewLabel_3_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1_1.setBounds(58, 11, 88, 15);
		btnAuthor.add(lblNewLabel_3_1_1_1);
		
		JPanel btnBook = new JPanel();
		btnBook.setLayout(null);
		btnBook.setBorder(new LineBorder(new Color(230, 230, 250)));
		btnBook.setBackground(new Color(51, 51, 51));
		btnBook.setBounds(0, 315, 198, 37);
		sideBarPanel.add(btnBook);
		
		JPanel panel_4_1_1_1_1 = new JPanel();
		panel_4_1_1_1_1.setLayout(null);
		panel_4_1_1_1_1.setBorder(new LineBorder(new Color(230, 230, 250)));
		panel_4_1_1_1_1.setBackground(new Color(51, 51, 51));
		panel_4_1_1_1_1.setBounds(0, 0, 37, 37);
		btnBook.add(panel_4_1_1_1_1);
		
		JLabel iconEmployee_1_1_1_1 = new JLabel("");
		iconEmployee_1_1_1_1.setBounds(0, 0, 37, 37);
		panel_4_1_1_1_1.add(iconEmployee_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("BOOK");
		lblNewLabel_3_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1_1_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1_1_1.setBounds(58, 11, 88, 15);
		btnBook.add(lblNewLabel_3_1_1_1_1);
		
		JPanel btnMember = new JPanel();
		btnMember.setLayout(null);
		btnMember.setBorder(new LineBorder(new Color(230, 230, 250)));
		btnMember.setBackground(new Color(51, 51, 51));
		btnMember.setBounds(0, 351, 198, 37);
		sideBarPanel.add(btnMember);
		
		JPanel panel_4_1_1_1_1_1 = new JPanel();
		panel_4_1_1_1_1_1.setLayout(null);
		panel_4_1_1_1_1_1.setBorder(new LineBorder(new Color(230, 230, 250)));
		panel_4_1_1_1_1_1.setBackground(new Color(51, 51, 51));
		panel_4_1_1_1_1_1.setBounds(0, 0, 37, 37);
		btnMember.add(panel_4_1_1_1_1_1);
		
		JLabel iconEmployee_1_1_1_1_1 = new JLabel("");
		iconEmployee_1_1_1_1_1.setBounds(0, 0, 37, 37);
		panel_4_1_1_1_1_1.add(iconEmployee_1_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1_1 = new JLabel("MEMBER");
		lblNewLabel_3_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1_1_1_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1_1_1_1.setBounds(58, 11, 88, 15);
		btnMember.add(lblNewLabel_3_1_1_1_1_1);
		
		JPanel btnInvoice = new JPanel();
		btnInvoice.setLayout(null);
		btnInvoice.setBorder(new LineBorder(new Color(230, 230, 250)));
		btnInvoice.setBackground(new Color(51, 51, 51));
		btnInvoice.setBounds(0, 386, 198, 37);
		sideBarPanel.add(btnInvoice);
		
		JPanel panel_4_1_1_1_1_1_1 = new JPanel();
		panel_4_1_1_1_1_1_1.setLayout(null);
		panel_4_1_1_1_1_1_1.setBorder(new LineBorder(new Color(230, 230, 250)));
		panel_4_1_1_1_1_1_1.setBackground(new Color(51, 51, 51));
		panel_4_1_1_1_1_1_1.setBounds(0, 0, 37, 37);
		btnInvoice.add(panel_4_1_1_1_1_1_1);
		
		JLabel iconEmployee_1_1_1_1_1_1 = new JLabel("");
		iconEmployee_1_1_1_1_1_1.setBounds(0, 0, 37, 37);
		panel_4_1_1_1_1_1_1.add(iconEmployee_1_1_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1_1_1 = new JLabel("INVOICE");
		lblNewLabel_3_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1_1_1_1_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1_1_1_1_1.setBounds(58, 11, 88, 15);
		btnInvoice.add(lblNewLabel_3_1_1_1_1_1_1);
		
		JPanel btnStatistical = new JPanel();
		btnStatistical.setLayout(null);
		btnStatistical.setBorder(new LineBorder(new Color(230, 230, 250)));
		btnStatistical.setBackground(new Color(51, 51, 51));
		btnStatistical.setBounds(0, 422, 198, 37);
		sideBarPanel.add(btnStatistical);
		
		JPanel panel_4_1_1_1_1_1_1_1 = new JPanel();
		panel_4_1_1_1_1_1_1_1.setLayout(null);
		panel_4_1_1_1_1_1_1_1.setBorder(new LineBorder(new Color(230, 230, 250)));
		panel_4_1_1_1_1_1_1_1.setBackground(new Color(51, 51, 51));
		panel_4_1_1_1_1_1_1_1.setBounds(0, 0, 37, 37);
		btnStatistical.add(panel_4_1_1_1_1_1_1_1);
		
		JLabel iconEmployee_1_1_1_1_1_1_1 = new JLabel("");
		iconEmployee_1_1_1_1_1_1_1.setBounds(0, 0, 37, 37);
		panel_4_1_1_1_1_1_1_1.add(iconEmployee_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1_1_1_1 = new JLabel("STATISTICAL");
		lblNewLabel_3_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1_1_1_1_1_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1_1_1_1_1_1.setBounds(58, 11, 130, 15);
		btnStatistical.add(lblNewLabel_3_1_1_1_1_1_1_1);
		
		JPanel btnSetting = new JPanel();
		btnSetting.setLayout(null);
		btnSetting.setBorder(new LineBorder(new Color(230, 230, 250)));
		btnSetting.setBackground(new Color(51, 51, 51));
		btnSetting.setBounds(0, 491, 198, 37);
		sideBarPanel.add(btnSetting);
		
		JPanel panel_4_1_1_1_1_1_1_1_1 = new JPanel();
		panel_4_1_1_1_1_1_1_1_1.setLayout(null);
		panel_4_1_1_1_1_1_1_1_1.setBorder(new LineBorder(new Color(230, 230, 250)));
		panel_4_1_1_1_1_1_1_1_1.setBackground(new Color(51, 51, 51));
		panel_4_1_1_1_1_1_1_1_1.setBounds(0, 0, 37, 37);
		btnSetting.add(panel_4_1_1_1_1_1_1_1_1);
		
		JLabel iconEmployee_1_1_1_1_1_1_1_1 = new JLabel("");
		iconEmployee_1_1_1_1_1_1_1_1.setBounds(0, 0, 37, 37);
		panel_4_1_1_1_1_1_1_1_1.add(iconEmployee_1_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1_1_1_1_1 = new JLabel("SETTING");
		lblNewLabel_3_1_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1_1_1_1_1_1_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1_1_1_1_1_1_1.setBounds(58, 11, 130, 15);
		btnSetting.add(lblNewLabel_3_1_1_1_1_1_1_1_1);
		
		JPanel btnInfo = new JPanel();
		btnInfo.setLayout(null);
		btnInfo.setBorder(new LineBorder(new Color(230, 230, 250)));
		btnInfo.setBackground(new Color(51, 51, 51));
		btnInfo.setBounds(0, 527, 198, 37);
		sideBarPanel.add(btnInfo);
		
		JPanel panel_4_1_1_1_1_1_1_1_1_1 = new JPanel();
		panel_4_1_1_1_1_1_1_1_1_1.setLayout(null);
		panel_4_1_1_1_1_1_1_1_1_1.setBorder(new LineBorder(new Color(230, 230, 250)));
		panel_4_1_1_1_1_1_1_1_1_1.setBackground(new Color(51, 51, 51));
		panel_4_1_1_1_1_1_1_1_1_1.setBounds(0, 0, 37, 37);
		btnInfo.add(panel_4_1_1_1_1_1_1_1_1_1);
		
		JLabel iconEmployee_1_1_1_1_1_1_1_1_1 = new JLabel("");
		iconEmployee_1_1_1_1_1_1_1_1_1.setBounds(0, 0, 37, 37);
		panel_4_1_1_1_1_1_1_1_1_1.add(iconEmployee_1_1_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1_1_1_1_1_1 = new JLabel("APP INFO");
		lblNewLabel_3_1_1_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1_1_1_1_1_1_1_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3_1_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1_1_1_1_1_1_1_1.setBounds(58, 11, 130, 15);
		btnInfo.add(lblNewLabel_3_1_1_1_1_1_1_1_1_1);
		
		JPanel btnLogout = new JPanel();
		btnLogout.setLayout(null);
		btnLogout.setBorder(new LineBorder(new Color(230, 230, 250)));
		btnLogout.setBackground(new Color(51, 51, 51));
		btnLogout.setBounds(0, 563, 198, 37);
		sideBarPanel.add(btnLogout);
		
		JPanel panel_4_1_1_1_1_1_1_1_1_1_1 = new JPanel();
		panel_4_1_1_1_1_1_1_1_1_1_1.setLayout(null);
		panel_4_1_1_1_1_1_1_1_1_1_1.setBorder(new LineBorder(new Color(230, 230, 250)));
		panel_4_1_1_1_1_1_1_1_1_1_1.setBackground(Color.RED);
		panel_4_1_1_1_1_1_1_1_1_1_1.setBounds(0, 0, 37, 37);
		btnLogout.add(panel_4_1_1_1_1_1_1_1_1_1_1);
		
		JLabel iconEmployee_1_1_1_1_1_1_1_1_1_1 = new JLabel("");
		iconEmployee_1_1_1_1_1_1_1_1_1_1.setBounds(0, 0, 37, 37);
		panel_4_1_1_1_1_1_1_1_1_1_1.add(iconEmployee_1_1_1_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1_1_1_1_1_1_1 = new JLabel("LOGOUT");
		lblNewLabel_3_1_1_1_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1_1_1_1_1_1_1_1_1_1.setForeground(Color.RED);
		lblNewLabel_3_1_1_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1_1_1_1_1_1_1_1_1.setBounds(58, 11, 130, 15);
		btnLogout.add(lblNewLabel_3_1_1_1_1_1_1_1_1_1_1);

		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(197, 33, 803, 617);
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
		invoice.setLayout(null);

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
		dashboardPanel.setBounds(0, 0, 803, 617);
		dashboard.add(dashboardPanel);
		category.setLayout(null);
		categoryPanel categoryPanel = new categoryPanel();
		categoryPanel.setBounds(0, 0, 803, 617);
		category.add(categoryPanel);
		author.setLayout(null);
		authorPanel authorPanel = new authorPanel();
		authorPanel.setBounds(0, 0, 803, 617);
		author.add(authorPanel);
		book.setLayout(null);
		bookPanel bookPanel = new bookPanel();
		bookPanel.setBounds(0, 0, 803, 617);
		book.add(bookPanel);
		employee.setLayout(null);
		employeePanel employeePanel = new employeePanel();
		employeePanel.setBounds(0, 0, 803, 617);
		employee.add(employeePanel);
		member.setLayout(null);
		memberPanel memberPanel = new memberPanel();
		memberPanel.setBounds(0, 0, 803, 617);
		member.add(memberPanel);
		report.setLayout(null);
		reportPanel reportPanel = new reportPanel();
		reportPanel.setBounds(0, 0, 803, 617);
		report.add(reportPanel);
		setting.setLayout(null);
		settingPanel settingPanel = new settingPanel();
		settingPanel.setBounds(0, 0, 803, 617);
		setting.add(settingPanel);	
		invoicePanel invoicePanel = new invoicePanel();
		invoice.add(invoicePanel);
		invoicePanel.setBounds(0, 0, 803, 617);
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
