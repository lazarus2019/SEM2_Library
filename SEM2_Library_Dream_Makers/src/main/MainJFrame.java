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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

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

	// Declare Frame, Dialog
	// Dialog
	private infoDialog infoDialog = new infoDialog();

	// Frame
	private dashboardPanel dashboardPanel = new dashboardPanel();
	private categoryPanel categoryPanel = new categoryPanel();
	private authorPanel authorPanel = new authorPanel();
	private bookPanel bookPanel = new bookPanel();
	private employeePanel employeePanel = new employeePanel();
	private memberPanel memberPanel = new memberPanel();
	private reportPanel reportPanel = new reportPanel();
	private settingPanel settingPanel = new settingPanel();
	private invoicePanel invoicePanel = new invoicePanel();

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
		btnDashboard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDashboard.setBorder(new LineBorder(new Color(230, 230, 250)));
		btnDashboard.setBackground(new Color(51, 51, 51));
		btnDashboard.setBounds(0, 171, 198, 37);
		sideBarPanel.add(btnDashboard);
		btnDashboard.setLayout(null);

		JPanel dashboardContainer = new JPanel();
		dashboardContainer.setBackground(new Color(6, 202, 254));
		dashboardContainer.setBounds(0, 0, 37, 37);
		btnDashboard.add(dashboardContainer);
		dashboardContainer.setLayout(null);

		JLabel iconDashboard = new JLabel("");
		iconDashboard.setBounds(0, 0, 37, 37);
		dashboardContainer.add(iconDashboard);

		JLabel dashboardTxt = new JLabel("DASHBOARD");
		dashboardTxt.setForeground(new Color(6, 202, 254));
		dashboardTxt.setFont(new Font("Tahoma", Font.BOLD, 15));
		dashboardTxt.setHorizontalAlignment(SwingConstants.LEFT);
		dashboardTxt.setBounds(58, 11, 130, 15);
		btnDashboard.add(dashboardTxt);

		JPanel btnCategory = new JPanel();
		btnCategory.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCategory.setLayout(null);
		btnCategory.setBorder(new LineBorder(new Color(230, 230, 250)));
		btnCategory.setBackground(new Color(51, 51, 51));
		btnCategory.setBounds(0, 207, 198, 37);
		sideBarPanel.add(btnCategory);

		JPanel categoryContainer = new JPanel();
		categoryContainer.setBorder(new LineBorder(new Color(230, 230, 250)));
		categoryContainer.setLayout(null);
		categoryContainer.setBackground(new Color(51, 51, 51));
		categoryContainer.setBounds(0, 0, 37, 37);
		btnCategory.add(categoryContainer);

		JLabel iconCategory = new JLabel("");
		iconCategory.setBounds(0, 0, 37, 37);
		categoryContainer.add(iconCategory);

		JLabel categoryTxt = new JLabel("CATEGORY");
		categoryTxt.setHorizontalAlignment(SwingConstants.LEFT);
		categoryTxt.setForeground(new Color(192, 192, 192));
		categoryTxt.setFont(new Font("Tahoma", Font.BOLD, 15));
		categoryTxt.setBounds(58, 11, 130, 15);
		btnCategory.add(categoryTxt);

		JPanel btnEmployee = new JPanel();
		btnEmployee.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEmployee.setLayout(null);
		btnEmployee.setBorder(new LineBorder(new Color(230, 230, 250)));
		btnEmployee.setBackground(new Color(51, 51, 51));
		btnEmployee.setBounds(0, 243, 198, 37);
		sideBarPanel.add(btnEmployee);

		JPanel employeeContainer = new JPanel();
		employeeContainer.setLayout(null);
		employeeContainer.setBorder(new LineBorder(new Color(230, 230, 250)));
		employeeContainer.setBackground(new Color(51, 51, 51));
		employeeContainer.setBounds(0, 0, 37, 37);
		btnEmployee.add(employeeContainer);

		JLabel iconEmployee = new JLabel("");
		iconEmployee.setBounds(0, 0, 37, 37);
		employeeContainer.add(iconEmployee);

		JLabel employeeTxt = new JLabel("EMPLOYEE");
		employeeTxt.setHorizontalAlignment(SwingConstants.LEFT);
		employeeTxt.setForeground(Color.LIGHT_GRAY);
		employeeTxt.setFont(new Font("Tahoma", Font.BOLD, 15));
		employeeTxt.setBounds(58, 11, 88, 15);
		btnEmployee.add(employeeTxt);

		JPanel btnAuthor = new JPanel();
		btnAuthor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAuthor.setLayout(null);
		btnAuthor.setBorder(new LineBorder(new Color(230, 230, 250)));
		btnAuthor.setBackground(new Color(51, 51, 51));
		btnAuthor.setBounds(0, 279, 198, 37);
		sideBarPanel.add(btnAuthor);

		JPanel authorContainer = new JPanel();
		authorContainer.setLayout(null);
		authorContainer.setBorder(new LineBorder(new Color(230, 230, 250)));
		authorContainer.setBackground(new Color(51, 51, 51));
		authorContainer.setBounds(0, 0, 37, 37);
		btnAuthor.add(authorContainer);

		JLabel iconAuthor = new JLabel("");
		iconAuthor.setBounds(0, 0, 37, 37);
		authorContainer.add(iconAuthor);

		JLabel authorTxt = new JLabel("AUTHOR");
		authorTxt.setHorizontalAlignment(SwingConstants.LEFT);
		authorTxt.setForeground(Color.LIGHT_GRAY);
		authorTxt.setFont(new Font("Tahoma", Font.BOLD, 15));
		authorTxt.setBounds(58, 11, 88, 15);
		btnAuthor.add(authorTxt);

		JPanel btnBook = new JPanel();
		btnBook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBook.setLayout(null);
		btnBook.setBorder(new LineBorder(new Color(230, 230, 250)));
		btnBook.setBackground(new Color(51, 51, 51));
		btnBook.setBounds(0, 315, 198, 37);
		sideBarPanel.add(btnBook);

		JPanel bookContainer = new JPanel();
		bookContainer.setLayout(null);
		bookContainer.setBorder(new LineBorder(new Color(230, 230, 250)));
		bookContainer.setBackground(new Color(51, 51, 51));
		bookContainer.setBounds(0, 0, 37, 37);
		btnBook.add(bookContainer);

		JLabel iconBook = new JLabel("");
		iconBook.setBounds(0, 0, 37, 37);
		bookContainer.add(iconBook);

		JLabel bookTxt = new JLabel("BOOK");
		bookTxt.setHorizontalAlignment(SwingConstants.LEFT);
		bookTxt.setForeground(Color.LIGHT_GRAY);
		bookTxt.setFont(new Font("Tahoma", Font.BOLD, 15));
		bookTxt.setBounds(58, 11, 88, 15);
		btnBook.add(bookTxt);

		JPanel btnMember = new JPanel();
		btnMember.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMember.setLayout(null);
		btnMember.setBorder(new LineBorder(new Color(230, 230, 250)));
		btnMember.setBackground(new Color(51, 51, 51));
		btnMember.setBounds(0, 351, 198, 37);
		sideBarPanel.add(btnMember);

		JPanel memberContainer = new JPanel();
		memberContainer.setLayout(null);
		memberContainer.setBorder(new LineBorder(new Color(230, 230, 250)));
		memberContainer.setBackground(new Color(51, 51, 51));
		memberContainer.setBounds(0, 0, 37, 37);
		btnMember.add(memberContainer);

		JLabel iconMember = new JLabel("");
		iconMember.setBounds(0, 0, 37, 37);
		memberContainer.add(iconMember);

		JLabel lblNewLabel_3_1_1_1_1_1 = new JLabel("MEMBER");
		lblNewLabel_3_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1_1_1_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1_1_1_1.setBounds(58, 11, 88, 15);
		btnMember.add(lblNewLabel_3_1_1_1_1_1);

		JPanel btnInvoice = new JPanel();
		btnInvoice.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInvoice.setLayout(null);
		btnInvoice.setBorder(new LineBorder(new Color(230, 230, 250)));
		btnInvoice.setBackground(new Color(51, 51, 51));
		btnInvoice.setBounds(0, 386, 198, 37);
		sideBarPanel.add(btnInvoice);

		JPanel invoiceContainer = new JPanel();
		invoiceContainer.setLayout(null);
		invoiceContainer.setBorder(new LineBorder(new Color(230, 230, 250)));
		invoiceContainer.setBackground(new Color(51, 51, 51));
		invoiceContainer.setBounds(0, 0, 37, 37);
		btnInvoice.add(invoiceContainer);

		JLabel iconInvoice = new JLabel("");
		iconInvoice.setBounds(0, 0, 37, 37);
		invoiceContainer.add(iconInvoice);

		JLabel invoiceTxt = new JLabel("INVOICE");
		invoiceTxt.setHorizontalAlignment(SwingConstants.LEFT);
		invoiceTxt.setForeground(Color.LIGHT_GRAY);
		invoiceTxt.setFont(new Font("Tahoma", Font.BOLD, 15));
		invoiceTxt.setBounds(58, 11, 88, 15);
		btnInvoice.add(invoiceTxt);

		JPanel btnStatistical = new JPanel();
		btnStatistical.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnStatistical.setLayout(null);
		btnStatistical.setBorder(new LineBorder(new Color(230, 230, 250)));
		btnStatistical.setBackground(new Color(51, 51, 51));
		btnStatistical.setBounds(0, 422, 198, 37);
		sideBarPanel.add(btnStatistical);

		JPanel statisticalContainer = new JPanel();
		statisticalContainer.setLayout(null);
		statisticalContainer.setBorder(new LineBorder(new Color(230, 230, 250)));
		statisticalContainer.setBackground(new Color(51, 51, 51));
		statisticalContainer.setBounds(0, 0, 37, 37);
		btnStatistical.add(statisticalContainer);

		JLabel iconStatistical = new JLabel("");
		iconStatistical.setBounds(0, 0, 37, 37);
		statisticalContainer.add(iconStatistical);

		JLabel statisticalTxt = new JLabel("STATISTICAL");
		statisticalTxt.setHorizontalAlignment(SwingConstants.LEFT);
		statisticalTxt.setForeground(Color.LIGHT_GRAY);
		statisticalTxt.setFont(new Font("Tahoma", Font.BOLD, 15));
		statisticalTxt.setBounds(58, 11, 130, 15);
		btnStatistical.add(statisticalTxt);

		JPanel btnSetting = new JPanel();
		btnSetting.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSetting.setLayout(null);
		btnSetting.setBorder(new LineBorder(new Color(230, 230, 250)));
		btnSetting.setBackground(new Color(51, 51, 51));
		btnSetting.setBounds(0, 491, 198, 37);
		sideBarPanel.add(btnSetting);

		JPanel settingContainer = new JPanel();
		settingContainer.setLayout(null);
		settingContainer.setBorder(new LineBorder(new Color(230, 230, 250)));
		settingContainer.setBackground(new Color(51, 51, 51));
		settingContainer.setBounds(0, 0, 37, 37);
		btnSetting.add(settingContainer);

		JLabel iconSetting = new JLabel("");
		iconSetting.setBounds(0, 0, 37, 37);
		settingContainer.add(iconSetting);

		JLabel settingTxt = new JLabel("SETTING");
		settingTxt.setHorizontalAlignment(SwingConstants.LEFT);
		settingTxt.setForeground(Color.LIGHT_GRAY);
		settingTxt.setFont(new Font("Tahoma", Font.BOLD, 15));
		settingTxt.setBounds(58, 11, 130, 15);
		btnSetting.add(settingTxt);

		JPanel btnInfo = new JPanel();
		btnInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					btnInfo_mouseClicked(arg0);
				} catch (Exception e) {
					showMessenger("Something was wrong! Please try again");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		btnInfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInfo.setLayout(null);
		btnInfo.setBorder(new LineBorder(new Color(230, 230, 250)));
		btnInfo.setBackground(new Color(51, 51, 51));
		btnInfo.setBounds(0, 527, 198, 37);
		sideBarPanel.add(btnInfo);

		JPanel infoContainer = new JPanel();
		infoContainer.setLayout(null);
		infoContainer.setBorder(new LineBorder(new Color(230, 230, 250)));
		infoContainer.setBackground(new Color(51, 51, 51));
		infoContainer.setBounds(0, 0, 37, 37);
		btnInfo.add(infoContainer);

		JLabel iconInfo = new JLabel("");
		iconInfo.setBounds(0, 0, 37, 37);
		infoContainer.add(iconInfo);

		JLabel infoTxt = new JLabel("APP INFO");
		infoTxt.setHorizontalAlignment(SwingConstants.LEFT);
		infoTxt.setForeground(Color.LIGHT_GRAY);
		infoTxt.setFont(new Font("Tahoma", Font.BOLD, 15));
		infoTxt.setBounds(58, 11, 130, 15);
		btnInfo.add(infoTxt);

		JPanel btnLogout = new JPanel();
		btnLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogout.setLayout(null);
		btnLogout.setBorder(new LineBorder(new Color(230, 230, 250)));
		btnLogout.setBackground(new Color(51, 51, 51));
		btnLogout.setBounds(0, 563, 198, 37);
		sideBarPanel.add(btnLogout);

		JPanel logoutContainer = new JPanel();
		logoutContainer.setLayout(null);
		logoutContainer.setBorder(new LineBorder(new Color(230, 230, 250)));
		logoutContainer.setBackground(Color.RED);
		logoutContainer.setBounds(0, 0, 37, 37);
		btnLogout.add(logoutContainer);

		JLabel iconLogout = new JLabel("");
		iconLogout.setBounds(0, 0, 37, 37);
		logoutContainer.add(iconLogout);

		JLabel logoutTxt = new JLabel("LOGOUT");
		logoutTxt.setHorizontalAlignment(SwingConstants.LEFT);
		logoutTxt.setForeground(Color.RED);
		logoutTxt.setFont(new Font("Tahoma", Font.BOLD, 15));
		logoutTxt.setBounds(58, 11, 130, 15);
		btnLogout.add(logoutTxt);

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

		loadData();
	}

	// Load data
	private void loadData() {
		// Load logo
		ImageIcon logoImage = resizeImg("src/data/Main/logo_Library.png", logo);
		logo.setIcon(logoImage);
		// Add panel for button sidebar
		
		// Dashboard
		dashboardPanel.setBounds(0, 0, 803, 617);
		dashboard.add(dashboardPanel);
		// Category
		category.setLayout(null);
		categoryPanel.setBounds(0, 0, 803, 617);
		category.add(categoryPanel);
		// Author
		author.setLayout(null);
		authorPanel.setBounds(0, 0, 803, 617);
		author.add(authorPanel);
		// Book
		book.setLayout(null);
		bookPanel.setBounds(0, 0, 803, 617);
		book.add(bookPanel);
		// Employee
		employee.setLayout(null);
		employeePanel.setBounds(0, 0, 803, 617);
		employee.add(employeePanel);
		// Member
		member.setLayout(null);
		memberPanel.setBounds(0, 0, 803, 617);
		member.add(memberPanel);
		// Report
		report.setLayout(null);
		reportPanel.setBounds(0, 0, 803, 617);
		report.add(reportPanel);
		// Setting
		setting.setLayout(null);
		settingPanel.setBounds(0, 0, 803, 617);
		setting.add(settingPanel);
		// Invoice
		invoice.add(invoicePanel);
		invoicePanel.setBounds(0, 0, 803, 617);
	}

	// Show info dialog
	private void btnInfo_mouseClicked(MouseEvent e) {
		infoDialog.setVisible(true);
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
