package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
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

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

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
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1062, 680);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 42, 173, 639);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setIcon(new ImageIcon(LoginFrame.class.getResource("/data/icon/icon_Document.png")));
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.setBounds(10, 48, 153, 32);
		panel.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 1064, 43);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel exitApp = new JLabel("X");
		exitApp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				exitApp_mouseClicked(arg0);
			}
		});
		exitApp.setFont(new Font("Tahoma", Font.BOLD, 15));
		exitApp.setHorizontalAlignment(SwingConstants.CENTER);
		exitApp.setForeground(Color.RED);
		exitApp.setBounds(1024, 11, 30, 21);
		panel_1.add(exitApp);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(171, 42, 893, 639);
		contentPane.add(panel_2);
		panel_2.setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabCategory = new JTabbedPane(JTabbedPane.TOP);
		panel_2.add(tabCategory, "name_2797975981045000");
		
		JPanel panel_3 = new JPanel();
		tabCategory.addTab("New tab", null, panel_3, null);
		
		JTabbedPane tabEmployee = new JTabbedPane(JTabbedPane.TOP);
		panel_2.add(tabEmployee, "name_2797979583462500");
		
		JTabbedPane tabAuthor = new JTabbedPane(JTabbedPane.TOP);
		panel_2.add(tabAuthor, "name_2797984222042100");
		
		JTabbedPane tabBook = new JTabbedPane(JTabbedPane.TOP);
		panel_2.add(tabBook, "name_2797988939095400");
		
		JTabbedPane tabMember = new JTabbedPane(JTabbedPane.TOP);
		panel_2.add(tabMember, "name_2798012403973800");
		
		JTabbedPane tabInvoice = new JTabbedPane(JTabbedPane.TOP);
		panel_2.add(tabInvoice, "name_2798014414156100");
		
		JTabbedPane tabStatistical = new JTabbedPane(JTabbedPane.TOP);
		panel_2.add(tabStatistical, "name_2798018378705900");
		
		JPanel Dashboard = new JPanel();
		panel_2.add(Dashboard, "name_2798020492336600");
		Dashboard.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 235, 873, 393);
		Dashboard.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.ORANGE);
		panel_4.setBounds(299, 11, 287, 84);
		Dashboard.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel bookNum = new JLabel("Book Num");
		bookNum.setBounds(131, 11, 131, 62);
		panel_4.add(bookNum);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBackground(new Color(154, 205, 50));
		panel_4_1.setBounds(299, 129, 287, 84);
		Dashboard.add(panel_4_1);
		
		JLabel memberNum = new JLabel("Member Num");
		memberNum.setBounds(131, 11, 131, 62);
		panel_4_1.add(memberNum);
		
		JPanel panel_4_2 = new JPanel();
		panel_4_2.setLayout(null);
		panel_4_2.setBackground(new Color(123, 104, 238));
		panel_4_2.setBounds(596, 11, 287, 84);
		Dashboard.add(panel_4_2);
		
		JLabel borrowNum = new JLabel("Borrow book num");
		borrowNum.setBounds(131, 11, 131, 62);
		panel_4_2.add(borrowNum);
		
		JPanel lateBookNum = new JPanel();
		lateBookNum.setLayout(null);
		lateBookNum.setBackground(new Color(139, 0, 0));
		lateBookNum.setBounds(596, 129, 287, 84);
		Dashboard.add(lateBookNum);
		
		JLabel lblLateBookNum = new JLabel("Late book Num");
		lblLateBookNum.setBounds(131, 11, 131, 62);
		lateBookNum.add(lblLateBookNum);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Quick search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(10, 11, 279, 202);
		Dashboard.add(panel_5);
		panel_5.setLayout(null);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(185, 53, 84, 25);
		panel_5.add(btnNewButton_1);
		btnNewButton.setBounds(185, 155, 84, 25);
		panel_5.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(10, 155, 177, 25);
		panel_5.add(textField);
		textField.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(0, 0, 255));
		panel_6.setBounds(10, 138, 90, 25);
		panel_5.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book title");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(0, 0, 90, 14);
		panel_6.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 53, 177, 25);
		panel_5.add(textField_1);
		
		JPanel panel_6_1 = new JPanel();
		panel_6_1.setLayout(null);
		panel_6_1.setBackground(Color.BLUE);
		panel_6_1.setBounds(10, 36, 90, 25);
		panel_5.add(panel_6_1);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeId.setForeground(Color.WHITE);
		lblEmployeeId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmployeeId.setBounds(0, 0, 90, 14);
		panel_6_1.add(lblEmployeeId);
	}
	
	private void exitApp_mouseClicked(MouseEvent e) {
		System.exit(0);
	}
}
