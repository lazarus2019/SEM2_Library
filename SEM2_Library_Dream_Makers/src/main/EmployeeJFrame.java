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

import entities.Employee;
import login.LoginFrame;

import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class EmployeeJFrame extends JFrame {

	private JPanel contentPane;
	private JLabel logo;
	private JPanel dashboard;
	private JPanel category;
	private JPanel author;
	private JPanel book;
	private JPanel member;
	private JPanel invoice;
	private JPanel report;
	private JPanel mainPanel;
	private JPanel logoutContainer;
	private JPanel infoContainer;
	private JPanel statisticalContainer;
	private JPanel invoiceContainer;
	private JPanel memberContainer;
	private JPanel bookContainer;
	private JPanel authorContainer;
	private JPanel categoryContainer;
	private JPanel dashboardContainer;
	private JLabel btnClose;
	private JLabel btnMinimize;

	// Declare Direct mapping
	Employee employeeMain = null;

	// Declare Frame, Dialog, Panel
	// Frame

	// Panel
	private dashboardPanel dashboardPanel = new dashboardPanel();
	private categoryPanel categoryPanel = new categoryPanel();
	private authorPanel authorPanel = new authorPanel();
	private bookPanel bookPanel = new bookPanel();
	private memberPanel memberPanel = new memberPanel();
	private reportPanel reportPanel = new reportPanel();
	private invoicePanel invoicePanel = new invoicePanel();
	private JLabel titleTxt;
	private JLabel usernameTxt;
	private JLabel levelTxt;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeJFrame frame = new EmployeeJFrame();
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
	public EmployeeJFrame() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel sideBarPanel = new JPanel();
		sideBarPanel.setBounds(0, 0, 198, 650);
		sideBarPanel.setBackground(new Color(51, 51, 51));
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

		usernameTxt = new JLabel("Employee 1");
		usernameTxt.setForeground(Color.WHITE);
		usernameTxt.setHorizontalAlignment(SwingConstants.RIGHT);
		usernameTxt.setFont(new Font("Tahoma", Font.BOLD, 12));
		usernameTxt.setBounds(99, 105, 89, 22);
		panel.add(usernameTxt);

		levelTxt = new JLabel("employee");
		levelTxt.setForeground(Color.WHITE);
		levelTxt.setHorizontalAlignment(SwingConstants.RIGHT);
		levelTxt.setFont(new Font("Tahoma", Font.BOLD, 12));
		levelTxt.setBounds(99, 125, 89, 22);
		panel.add(levelTxt);

		JLabel lblNewLabel_2 = new JLabel("Dream Makers");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(45, 616, 107, 23);
		sideBarPanel.add(lblNewLabel_2);

		JPanel btnDashboard = new JPanel();
		btnDashboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					btnDashboard_mouseClicked(e);
				} catch (Exception e2) {
					showMessenger("Something was wrong! Please try again");
				}
			}
		});
		btnDashboard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDashboard.setBorder(new LineBorder(new Color(230, 230, 250)));
		btnDashboard.setBackground(new Color(51, 51, 51));
		btnDashboard.setBounds(0, 171, 198, 37);
		sideBarPanel.add(btnDashboard);
		btnDashboard.setLayout(null);

		dashboardContainer = new JPanel();
		dashboardContainer.setBorder(new LineBorder(new Color(230, 230, 250)));
		dashboardContainer.setBackground(new Color(6, 202, 254));
		dashboardContainer.setBounds(0, 0, 37, 37);
		btnDashboard.add(dashboardContainer);
		btnDashboard.addMouseListener(new PanelButtonMouseAdapter(dashboardContainer));
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
		btnCategory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					btnCategory_mouseClicked(e);
				} catch (Exception e2) {
					showMessenger("Something was wrong! Please try again");
				}
			}
		});
		btnCategory.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCategory.setLayout(null);
		btnCategory.setBorder(new LineBorder(new Color(230, 230, 250)));
		btnCategory.setBackground(new Color(51, 51, 51));
		btnCategory.setBounds(0, 207, 198, 37);
		sideBarPanel.add(btnCategory);

		categoryContainer = new JPanel();
		categoryContainer.setBorder(new LineBorder(new Color(230, 230, 250)));
		categoryContainer.setLayout(null);
		categoryContainer.setBackground(new Color(51, 51, 51));
		categoryContainer.setBounds(0, 0, 37, 37);
		btnCategory.add(categoryContainer);
		btnCategory.addMouseListener(new PanelButtonMouseAdapter(categoryContainer));

		JLabel iconCategory = new JLabel("");
		iconCategory.setBounds(0, 0, 37, 37);
		categoryContainer.add(iconCategory);

		JLabel categoryTxt = new JLabel("CATEGORY");
		categoryTxt.setHorizontalAlignment(SwingConstants.LEFT);
		categoryTxt.setForeground(new Color(192, 192, 192));
		categoryTxt.setFont(new Font("Tahoma", Font.BOLD, 15));
		categoryTxt.setBounds(58, 11, 130, 15);
		btnCategory.add(categoryTxt);

		JPanel btnAuthor = new JPanel();
		btnAuthor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					btnAuthor_mouseClicked(e);
				} catch (Exception e2) {
					showMessenger("Something was wrong! Please try again");
				}
			}
		});
		btnAuthor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAuthor.setLayout(null);
		btnAuthor.setBorder(new LineBorder(new Color(230, 230, 250)));
		btnAuthor.setBackground(new Color(51, 51, 51));
		btnAuthor.setBounds(0, 243, 198, 37);
		sideBarPanel.add(btnAuthor);

		authorContainer = new JPanel();
		authorContainer.setLayout(null);
		authorContainer.setBorder(new LineBorder(new Color(230, 230, 250)));
		authorContainer.setBackground(new Color(51, 51, 51));
		authorContainer.setBounds(0, 0, 37, 37);
		btnAuthor.add(authorContainer);
		btnAuthor.addMouseListener(new PanelButtonMouseAdapter(authorContainer));

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
		btnBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					btnBook_mouseClicked(e);
				} catch (Exception e2) {
					showMessenger("Something was wrong! Please try again");
				}
			}
		});
		btnBook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBook.setLayout(null);
		btnBook.setBorder(new LineBorder(new Color(230, 230, 250)));
		btnBook.setBackground(new Color(51, 51, 51));
		btnBook.setBounds(0, 279, 198, 37);
		sideBarPanel.add(btnBook);

		bookContainer = new JPanel();
		bookContainer.setLayout(null);
		bookContainer.setBorder(new LineBorder(new Color(230, 230, 250)));
		bookContainer.setBackground(new Color(51, 51, 51));
		bookContainer.setBounds(0, 0, 37, 37);
		btnBook.add(bookContainer);
		btnBook.addMouseListener(new PanelButtonMouseAdapter(bookContainer));

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
		btnMember.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					btnMember_mouseClicked(e);
				} catch (Exception e2) {
					showMessenger("Something was wrong! Please try again");
				}
			}
		});
		btnMember.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMember.setLayout(null);
		btnMember.setBorder(new LineBorder(new Color(230, 230, 250)));
		btnMember.setBackground(new Color(51, 51, 51));
		btnMember.setBounds(0, 315, 198, 37);
		sideBarPanel.add(btnMember);

		memberContainer = new JPanel();
		memberContainer.setLayout(null);
		memberContainer.setBorder(new LineBorder(new Color(230, 230, 250)));
		memberContainer.setBackground(new Color(51, 51, 51));
		memberContainer.setBounds(0, 0, 37, 37);
		btnMember.add(memberContainer);
		btnMember.addMouseListener(new PanelButtonMouseAdapter(memberContainer));

		JLabel iconMember = new JLabel("");
		iconMember.setBounds(0, 0, 37, 37);
		memberContainer.add(iconMember);

		JLabel memberTxt = new JLabel("MEMBER");
		memberTxt.setHorizontalAlignment(SwingConstants.LEFT);
		memberTxt.setForeground(Color.LIGHT_GRAY);
		memberTxt.setFont(new Font("Tahoma", Font.BOLD, 15));
		memberTxt.setBounds(58, 11, 88, 15);
		btnMember.add(memberTxt);

		JPanel btnInvoice = new JPanel();
		btnInvoice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					btnInvoice_mouseClicked(e);
				} catch (Exception e2) {
					showMessenger("Something was wrong! Please try again");
				}
			}
		});
		btnInvoice.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInvoice.setLayout(null);
		btnInvoice.setBorder(new LineBorder(new Color(230, 230, 250)));
		btnInvoice.setBackground(new Color(51, 51, 51));
		btnInvoice.setBounds(0, 350, 198, 37);
		sideBarPanel.add(btnInvoice);

		invoiceContainer = new JPanel();
		invoiceContainer.setLayout(null);
		invoiceContainer.setBorder(new LineBorder(new Color(230, 230, 250)));
		invoiceContainer.setBackground(new Color(51, 51, 51));
		invoiceContainer.setBounds(0, 0, 37, 37);
		btnInvoice.add(invoiceContainer);
		btnInvoice.addMouseListener(new PanelButtonMouseAdapter(invoiceContainer));

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
		btnStatistical.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					btnStatistical_mouseClicked(e);
				} catch (Exception e2) {
					showMessenger("Something was wrong! Please try again");
				}
			}
		});
		btnStatistical.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnStatistical.setLayout(null);
		btnStatistical.setBorder(new LineBorder(new Color(230, 230, 250)));
		btnStatistical.setBackground(new Color(51, 51, 51));
		btnStatistical.setBounds(0, 386, 198, 37);
		sideBarPanel.add(btnStatistical);

		statisticalContainer = new JPanel();
		statisticalContainer.setLayout(null);
		statisticalContainer.setBorder(new LineBorder(new Color(230, 230, 250)));
		statisticalContainer.setBackground(new Color(51, 51, 51));
		statisticalContainer.setBounds(0, 0, 37, 37);
		btnStatistical.add(statisticalContainer);
		btnStatistical.addMouseListener(new PanelButtonMouseAdapter(statisticalContainer));

		JLabel iconStatistical = new JLabel("");
		iconStatistical.setBounds(0, 0, 37, 37);
		statisticalContainer.add(iconStatistical);

		JLabel statisticalTxt = new JLabel("STATISTICAL");
		statisticalTxt.setHorizontalAlignment(SwingConstants.LEFT);
		statisticalTxt.setForeground(Color.LIGHT_GRAY);
		statisticalTxt.setFont(new Font("Tahoma", Font.BOLD, 15));
		statisticalTxt.setBounds(58, 11, 130, 15);
		btnStatistical.add(statisticalTxt);

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
		});
		btnInfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInfo.setLayout(null);
		btnInfo.setBorder(new LineBorder(new Color(230, 230, 250)));
		btnInfo.setBackground(new Color(51, 51, 51));
		btnInfo.setBounds(0, 527, 198, 37);
		sideBarPanel.add(btnInfo);

		infoContainer = new JPanel();
		infoContainer.setLayout(null);
		infoContainer.setBorder(new LineBorder(new Color(230, 230, 250)));
		infoContainer.setBackground(new Color(51, 51, 51));
		infoContainer.setBounds(0, 0, 37, 37);
		btnInfo.add(infoContainer);
		btnInfo.addMouseListener(new PanelButtonMouseAdapter(infoContainer));

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
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					btnLogout_mouseClicked(e);
				} catch (Exception e2) {
					showMessenger("Something was wrong! Please try again");
				}
			}
		});
		btnLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogout.setLayout(null);
		btnLogout.setBorder(new LineBorder(new Color(230, 230, 250)));
		btnLogout.setBackground(new Color(51, 51, 51));
		btnLogout.setBounds(0, 563, 198, 37);
		sideBarPanel.add(btnLogout);

		logoutContainer = new JPanel();
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

		mainPanel = new JPanel();
		mainPanel.setBounds(197, 33, 803, 617);
		contentPane.add(mainPanel);
		mainPanel.setLayout(new CardLayout(0, 0));

		dashboard = new JPanel();
		mainPanel.add("dashboard", dashboard);
		dashboard.setLayout(null);

		category = new JPanel();
		mainPanel.add("category", category);

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
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(197, 0, 803, 34);
		contentPane.add(titlePanel);
		titlePanel.setLayout(null);
		
		titleTxt = new JLabel("Dashboard");
		titleTxt.setFont(new Font("Tahoma", Font.BOLD, 17));
		titleTxt.setHorizontalAlignment(SwingConstants.CENTER);
		titleTxt.setBounds(287, 0, 229, 34);
		titlePanel.add(titleTxt);
		
		JPanel panelMinimize = new JPanel();
		panelMinimize.setBounds(735, 0, 34, 34);
		panelMinimize.setBackground(new Color(240, 240, 240));
		titlePanel.add(panelMinimize);
		panelMinimize.setLayout(null);

		btnMinimize = new JLabel("_");
		btnMinimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMinimize.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMinimize.setHorizontalAlignment(SwingConstants.CENTER);
		btnMinimize.setBounds(0, 0, 34, 34);
		btnMinimize.setForeground(Color.RED);
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
				panelMinimize.setBackground(new Color(227, 227, 227));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelMinimize.setBackground(new Color(240, 240, 240));
			}
		});
		panelMinimize.add(btnMinimize);

		JPanel panelClose = new JPanel();
		panelClose.setLayout(null);
		panelClose.setBackground(new Color(240, 240, 240));
		panelClose.setBounds(769, 0, 34, 34);
		titlePanel.add(panelClose);

		btnClose = new JLabel("X");
		btnClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClose.setHorizontalAlignment(SwingConstants.CENTER);
		btnClose.setForeground(Color.RED);
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClose.setBounds(0, 0, 34, 34);
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
				panelClose.setBackground(new Color(227, 227, 227));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelClose.setBackground(new Color(240, 240, 240));
			}
		});
		panelClose.add(btnClose);

		loadData();
	}
	// ======== Main Function ===========

		public void getAccount(Employee employee) {
			employeeMain = employee;
		}
	//
//		private void checkLogin() {
//			if (employeeMain != null) {
//				loadData();
//			} else {
//				this.setVisible(false);
//				new LoginFrame().setVisible(true);
//				this.dispose();
//			}
//		}

		// Load data
		private void loadData() {
			// Load logo
			ImageIcon logoImage = resizeImg("src/data/Main/logo_Library.png", logo);
			logo.setIcon(logoImage);
			// When user login success
//			Employee employeeLogin = 
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
			// Member
			member.setLayout(null);
			memberPanel.setBounds(0, 0, 803, 617);
			member.add(memberPanel);
			// Report
			report.setLayout(null);
			reportPanel.setBounds(0, 0, 803, 617);
			report.add(reportPanel);
			// Invoice
			invoice.setLayout(null);
			invoicePanel.setBounds(0, 0, 803, 617);
			invoice.add(invoicePanel);

			// Set Dashboard is the first layout
			CardLayout mainLayout = (CardLayout) (mainPanel.getLayout());
			mainLayout.show(mainPanel, "dashboard");
		}

		// Show Dashboard
		private void btnDashboard_mouseClicked(MouseEvent e) {
			titleTxt.setText("Dashboard");
			CardLayout mainLayout = (CardLayout) (mainPanel.getLayout());
			mainLayout.show(mainPanel, "dashboard");
		}

		// Show Category Manage
		private void btnCategory_mouseClicked(MouseEvent e) {
			titleTxt.setText("Category");
			CardLayout mainLayout = (CardLayout) (mainPanel.getLayout());
			mainLayout.show(mainPanel, "category");
		}

		// Show Author Manage
		private void btnAuthor_mouseClicked(MouseEvent e) {
			titleTxt.setText("Author");
			CardLayout mainLayout = (CardLayout) (mainPanel.getLayout());
			mainLayout.show(mainPanel, "author");
		}

		// Show Employee Manage
		private void btnEmployee_mouseClicked(MouseEvent e) {
			titleTxt.setText("Employee");
			CardLayout mainLayout = (CardLayout) (mainPanel.getLayout());
			mainLayout.show(mainPanel, "employee");
		}

		// Show Book Manage
		private void btnBook_mouseClicked(MouseEvent e) {
			titleTxt.setText("Book");
			CardLayout mainLayout = (CardLayout) (mainPanel.getLayout());
			mainLayout.show(mainPanel, "book");
		}

		// Show Member Manage
		private void btnMember_mouseClicked(MouseEvent e) {
			titleTxt.setText("Member");
			CardLayout mainLayout = (CardLayout) (mainPanel.getLayout());
			mainLayout.show(mainPanel, "member");
		}

		// Show Invoice Manage
		private void btnInvoice_mouseClicked(MouseEvent e) {
			titleTxt.setText("Invoice");
			CardLayout mainLayout = (CardLayout) (mainPanel.getLayout());
			mainLayout.show(mainPanel, "invoice");
		}

		// Show Statistical
		private void btnStatistical_mouseClicked(MouseEvent e) {
			titleTxt.setText("Report");
			CardLayout mainLayout = (CardLayout) (mainPanel.getLayout());
			mainLayout.show(mainPanel, "report");
		}

		// Show Setting
		private void btnSetting_mouseClicked(MouseEvent e) {
			titleTxt.setText("Setting");
			CardLayout mainLayout = (CardLayout) (mainPanel.getLayout());
			mainLayout.show(mainPanel, "setting");
		}

		// Show info dialog
		private void btnInfo_mouseClicked(MouseEvent e) {
			new infoDialog().setVisible(true);
		}

		// Logout & show Login Form
		private void btnLogout_mouseClicked(MouseEvent e) {
			this.setVisible(false);
			new LoginFrame().setVisible(true);
			this.dispose();
		}

		// ======= Reusability Function=========
		
		// Minimize & Close button
		// Minimize app
		private void btnMinimize_mouseClicked(MouseEvent e) {
			this.setState(LoginFrame.ICONIFIED);
		}

		// Close app
		private void btnClose_mouseClicked(MouseEvent e) {
			System.exit(0);
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

		// Show error message
		private void showMessenger(String mess) {
			JOptionPane.showMessageDialog(null, mess);
		}

		// Set color
		private void setBtnColor(JPanel panel) {
			panel.setBackground(new Color(6, 202, 254));
		}

		// Reset color
		private void resetBtnColor(JPanel panel) {
			JPanel[] panels = { dashboardContainer,  infoContainer, 
					statisticalContainer, invoiceContainer, memberContainer, bookContainer, authorContainer,
					categoryContainer };
			for (int i = 0; i < panels.length; i++) {
				if (panels[i] != panel) {
					panels[i].setBackground(new Color(51, 51, 51));
				}
			}
		}

		// MouseAdapter for button
		private class PanelButtonMouseAdapter extends MouseAdapter {
			JPanel panel;

			public PanelButtonMouseAdapter(JPanel panel) {
				this.panel = panel;
			}

//			@Override
//			public void mouseEntered(MouseEvent e) {
//				panel.setBackground(new Color(6, 202, 254));
//			}

//			@Override
//			public void mouseExited(MouseEvent e) {
//				panel.setBackground(new Color(51, 51, 51));
//			}

			@Override
			public void mousePressed(MouseEvent e) {
				resetBtnColor(panel);
				setBtnColor(panel);
			}

//			@Override
//			public void mouseReleased(MouseEvent e) {
//				panel.setBackground(new Color(6, 202, 254));
//			}
		}

}
