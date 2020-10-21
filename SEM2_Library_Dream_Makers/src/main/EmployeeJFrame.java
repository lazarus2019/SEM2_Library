package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
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
import model.EmployeeModel;
import setting.settingDialog;

import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Cursor;

public class EmployeeJFrame extends JFrame {

	private JPanel contentPane;
	private JLabel logo;
	private JPanel dashboard;
	private JPanel author;
	private JPanel book;
	private JPanel member;
	private JPanel invoice;
	private JPanel report;
	private JPanel mainPanel;
	private JLabel btnClose;
	private JLabel btnMinimize;

	private JPanel btnDashboard;
	private JPanel btnAuthor;
	private JPanel btnBook;
	private JPanel btnMember;
	private JPanel btnInvoice;
	private JPanel btnInfo;
	private JPanel btnLogout;
	
	// Declare Variables
	private int xPosition, yPosition, mouseX, mouseY;

	// Declare Direct mapping
	public static Employee employeeMain = null;

	// Declare Frame, Dialog, Panel
	// Frame

	// Panel
	private dashboardEmployeePanel dashboardEmployeePanel = new dashboardEmployeePanel();
	private authorPanel authorPanel = new authorPanel();
	private bookPanel bookPanel = new bookPanel();
	private memberPanel memberPanel = new memberPanel();
	private JLabel titleTxt;
	private JLabel usernameTxt;
	private JLabel levelTxt;
	private JLabel setting;

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
		setBounds(100, 100, 971, 650);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel sideBarPanel = new JPanel();
		sideBarPanel.setBounds(0, 0, 168, 650);
		sideBarPanel.setBackground(new Color(22, 33, 53));
		contentPane.add(sideBarPanel);
		sideBarPanel.setLayout(null);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(SystemColor.menu);
		separator_1.setBounds(0, 170, 168, 1);
		sideBarPanel.add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(SystemColor.control);
		separator.setBounds(0, 519, 168, 1);
		sideBarPanel.add(separator);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(22, 33, 53));
		panel.setBounds(0, 0, 168, 171);
		sideBarPanel.add(panel);
		panel.setLayout(null);

		logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setBounds(0, 2, 168, 42);
		panel.add(logo);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(23, 45, 121, 2);
		panel.add(panel_2);

		setting = new JLabel("");
		setting.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setting.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					employeeInfo_mouseClicked(e);
				} catch (Exception e2) {
					showMessenger("Something was wrong! Please try again");
				}
			}
		});
		setting.setForeground(SystemColor.control);
		setting.setBounds(59, 51, 49, 49);
		panel.add(setting);

		JLabel usernamelavf = new JLabel("Username:");
		usernamelavf.setForeground(SystemColor.control);
		usernamelavf.setFont(new Font("Tahoma", Font.BOLD, 11));
		usernamelavf.setBounds(10, 105, 89, 22);
		panel.add(usernamelavf);

		JLabel levasfk = new JLabel("Level:");
		levasfk.setForeground(SystemColor.control);
		levasfk.setFont(new Font("Tahoma", Font.BOLD, 11));
		levasfk.setBounds(10, 125, 89, 22);
		panel.add(levasfk);

		usernameTxt = new JLabel("Admin");
		usernameTxt.setForeground(SystemColor.control);
		usernameTxt.setHorizontalAlignment(SwingConstants.RIGHT);
		usernameTxt.setFont(new Font("Tahoma", Font.BOLD, 11));
		usernameTxt.setBounds(75, 105, 89, 22);
		panel.add(usernameTxt);

		levelTxt = new JLabel("Admin");
		levelTxt.setForeground(SystemColor.control);
		levelTxt.setHorizontalAlignment(SwingConstants.RIGHT);
		levelTxt.setFont(new Font("Tahoma", Font.BOLD, 11));
		levelTxt.setBounds(75, 125, 89, 22);
		panel.add(levelTxt);

		JLabel lblNewLabel_2 = new JLabel("Dream Makers");
		lblNewLabel_2.setForeground(SystemColor.control);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(30, 616, 107, 23);
		sideBarPanel.add(lblNewLabel_2);

		btnDashboard = new JPanel();
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
		btnDashboard.setBorder(null);
		btnDashboard.setBackground(new Color(22, 33, 53));
		btnDashboard.setBounds(0, 171, 168, 37);
		btnDashboard.addMouseListener(new PanelButtonMouseAdapter(btnDashboard));
		sideBarPanel.add(btnDashboard);
		btnDashboard.setLayout(null);

		JLabel dashboardTxt = new JLabel("Dashboard");
		dashboardTxt.setForeground(SystemColor.control);
		dashboardTxt.setFont(new Font("Arial", Font.BOLD, 15));
		dashboardTxt.setHorizontalAlignment(SwingConstants.LEFT);
		dashboardTxt.setBounds(15, 11, 130, 15);
		btnDashboard.add(dashboardTxt);

		btnAuthor = new JPanel();
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
		btnAuthor.setBorder(null);
		btnAuthor.setBackground(new Color(22, 33, 53));
		btnAuthor.setBounds(0, 208, 168, 37);
		btnAuthor.addMouseListener(new PanelButtonMouseAdapter(btnAuthor));
		sideBarPanel.add(btnAuthor);

		JLabel authorTxt = new JLabel("Author");
		authorTxt.setHorizontalAlignment(SwingConstants.LEFT);
		authorTxt.setForeground(SystemColor.control);
		authorTxt.setFont(new Font("Arial", Font.BOLD, 15));
		authorTxt.setBounds(15, 11, 88, 15);
		btnAuthor.add(authorTxt);

		btnBook = new JPanel();
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
		btnBook.setBorder(null);
		btnBook.setBackground(new Color(22, 33, 53));
		btnBook.setBounds(0, 244, 168, 37);
		btnBook.addMouseListener(new PanelButtonMouseAdapter(btnBook));
		sideBarPanel.add(btnBook);

		JLabel bookTxt = new JLabel("Book");
		bookTxt.setHorizontalAlignment(SwingConstants.LEFT);
		bookTxt.setForeground(SystemColor.control);
		bookTxt.setFont(new Font("Arial", Font.BOLD, 15));
		bookTxt.setBounds(15, 11, 88, 15);
		btnBook.add(bookTxt);

		btnMember = new JPanel();
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
		btnMember.setBorder(null);
		btnMember.setBackground(new Color(22, 33, 53));
		btnMember.setBounds(0, 280, 168, 37);
		btnMember.addMouseListener(new PanelButtonMouseAdapter(btnMember));
		sideBarPanel.add(btnMember);

		JLabel memberTxt = new JLabel("Member");
		memberTxt.setHorizontalAlignment(SwingConstants.LEFT);
		memberTxt.setForeground(SystemColor.control);
		memberTxt.setFont(new Font("Arial", Font.BOLD, 15));
		memberTxt.setBounds(15, 11, 88, 15);
		btnMember.add(memberTxt);

		btnInvoice = new JPanel();
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
		btnInvoice.setBorder(null);
		btnInvoice.setBackground(new Color(22, 33, 53));
		btnInvoice.setBounds(0, 315, 168, 37);
		btnInvoice.addMouseListener(new PanelButtonMouseAdapter(btnInvoice));
		sideBarPanel.add(btnInvoice);

		JLabel invoiceTxt = new JLabel("Borrow Book");
		invoiceTxt.setHorizontalAlignment(SwingConstants.LEFT);
		invoiceTxt.setForeground(SystemColor.control);
		invoiceTxt.setFont(new Font("Arial", Font.BOLD, 15));
		invoiceTxt.setBounds(15, 11, 130, 15);
		btnInvoice.add(invoiceTxt);

		btnInfo = new JPanel();
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
		btnInfo.setBorder(null);
		btnInfo.setBackground(new Color(22, 33, 53));
		btnInfo.setBounds(0, 520, 168, 37);
		btnInfo.addMouseListener(new PanelButtonMouseAdapter(btnInfo));
		sideBarPanel.add(btnInfo);

		JLabel infoTxt = new JLabel("App Info");
		infoTxt.setHorizontalAlignment(SwingConstants.LEFT);
		infoTxt.setForeground(SystemColor.control);
		infoTxt.setFont(new Font("Arial", Font.BOLD, 15));
		infoTxt.setBounds(15, 11, 130, 15);
		btnInfo.add(infoTxt);

		btnLogout = new JPanel();
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
		btnLogout.setBorder(null);
		btnLogout.setBackground(new Color(22, 33, 53));
		btnLogout.setBounds(0, 556, 168, 37);
		btnLogout.addMouseListener(new PanelButtonMouseAdapter(btnLogout));
		sideBarPanel.add(btnLogout);

		JLabel logoutTxt = new JLabel("Logout");
		logoutTxt.setHorizontalAlignment(SwingConstants.LEFT);
		logoutTxt.setForeground(SystemColor.control);
		logoutTxt.setFont(new Font("Arial", Font.BOLD, 15));
		logoutTxt.setBounds(15, 11, 130, 15);
		btnLogout.add(logoutTxt);

		mainPanel = new JPanel();
		mainPanel.setBounds(168, 33, 803, 617);
		contentPane.add(mainPanel);
		mainPanel.setLayout(new CardLayout(0, 0));

		dashboard = new JPanel();
		mainPanel.add("dashboard", dashboard);
		dashboard.setLayout(null);

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
		titlePanel.addMouseMotionListener(new MouseMotionAdapter() {
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
		titlePanel.setBounds(168, 0, 803, 34);
		titlePanel.setBackground(new Color(67, 119, 203));
		contentPane.add(titlePanel);
		titlePanel.setLayout(null);

		titleTxt = new JLabel("Dashboard");
		titleTxt.setForeground(SystemColor.control);
		titleTxt.setFont(new Font("Tahoma", Font.BOLD, 17));
		titleTxt.setHorizontalAlignment(SwingConstants.CENTER);
		titleTxt.setBounds(287, 0, 229, 33);
		titlePanel.add(titleTxt);

		JPanel panelMinimize = new JPanel();
		panelMinimize.setBounds(735, 0, 34, 33);
		panelMinimize.setBackground(new Color(67, 119, 203));
		titlePanel.add(panelMinimize);
		panelMinimize.setLayout(null);

		btnMinimize = new JLabel("_");
		btnMinimize.setBackground(SystemColor.control);
		btnMinimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMinimize.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMinimize.setHorizontalAlignment(SwingConstants.CENTER);
		btnMinimize.setBounds(0, 0, 34, 33);
		btnMinimize.setForeground(SystemColor.control);
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
				panelMinimize.setBackground(new Color(52, 93, 158));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelMinimize.setBackground(new Color(67, 119, 203));
			}
		});
		panelMinimize.add(btnMinimize);

		JPanel panelClose = new JPanel();
		panelClose.setLayout(null);
		panelClose.setBackground(new Color(67, 119, 203));
		panelClose.setBounds(769, 0, 34, 33);
		titlePanel.add(panelClose);

		btnClose = new JLabel("X");
		btnClose.setBackground(SystemColor.control);
		btnClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClose.setHorizontalAlignment(SwingConstants.CENTER);
		btnClose.setForeground(SystemColor.control);
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClose.setBounds(0, 0, 34, 33);
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
				panelClose.setBackground(new Color(52, 93, 158));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelClose.setBackground(new Color(67, 119, 203));
			}
		});
		panelClose.add(btnClose);

		loadData();
	}
	// ======== Main Function ===========
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
		ImageIcon settingIcon = resizeImg("src/data/icon/icon_employee1.png", setting);
		ImageIcon logoImage = resizeImg("src/data/Main/logo_Library.png", logo);
		logo.setIcon(logoImage);
		setting.setIcon(settingIcon);
		// When user login success
		usernameTxt.setText(employeeMain.getUsername());
		levelTxt.setText(employeeMain.getLevel());
		// Add panel for button sidebar

		// Dashboard
		dashboardEmployeePanel.setBounds(0, 0, 803, 617);
		dashboard.add(dashboardEmployeePanel);
		// Author
		author.setLayout(null);
		authorPanel.setBounds(0, 0, 803, 617);
		author.add(authorPanel);
		// Book
		book.setLayout(null);
//			bookPanel.setBounds(0, 0, 803, 617);
			book.add(bookPanel);
		// Member
		member.setLayout(null);
		memberPanel.setBounds(0, 0, 803, 617);
		member.add(memberPanel);
		// Invoice
		invoice.setLayout(null);
		invoicePanel.employee = employeeMain;
		invoicePanel invoicePanelx = new invoicePanel();
		invoicePanelx.setBounds(0, 0, 803, 617);
		invoice.add(invoicePanelx);

		// Set Dashboard is the first layout
		CardLayout mainLayout = (CardLayout) (mainPanel.getLayout());
		mainLayout.show(mainPanel, "dashboard");
	}

	// Show Employee Info
	private void employeeInfo_mouseClicked(MouseEvent e) {
		settingDialog.employee_ID = employeeMain.getEmployee_ID();
		settingDialog settingDialog = new settingDialog();
		if (employeeMain.getLevel().equals("labrarian")) {
			settingDialog.setBounds(100, 100, 406, 615);
		}
		settingDialog.setLocationRelativeTo(null);
		settingDialog.setVisible(true);
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

	// Drag & move window
	private void panel_2_mouseDragged(MouseEvent e) {
		xPosition = e.getXOnScreen();
		yPosition = e.getYOnScreen();
		this.setLocation(xPosition - mouseX - 168, yPosition - mouseY);
	}

	private void panel_2_mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
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
		JPanel[] panels = { btnDashboard, btnAuthor, btnInvoice, btnLogout, btnInfo, btnMember };
		for (int i = 0; i < panels.length; i++) {
			if (panels[i] != panel) {
				panels[i].setBackground(new Color(22, 33, 53));
			}
		}
	}

	// MouseAdapter for button
	private class PanelButtonMouseAdapter extends MouseAdapter {
		JPanel panel;

		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}

		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(22, 33, 53));
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(40, 54, 79));
		}

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
