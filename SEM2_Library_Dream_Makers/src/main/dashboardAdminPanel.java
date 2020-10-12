package main;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import model.BooksModel;
import model.EmployeeModel;
import model.MemberModel;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormatSymbols;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.ScrollPaneConstants;

public class dashboardAdminPanel extends JPanel {
	private JLabel bookIssuedAm;
	private JLabel bookReturnAm;
	private JLabel memberAm;
	private JLabel employeeAm;
	private JPanel panelBorrowBook;
	private JScrollPane scrollPane_1;
	private JPanel panelNewMember;
	
	// Declare variable
	static Date today = new Date();
	static int monthNow = today.getMonth()+1;

	/**
	 * Create the panel.
	 */
	public dashboardAdminPanel() {
		setBackground(SystemColor.control);
		setBounds(0, 0, 803, 617);
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New Member");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_1.setBounds(320, 307, 244, 28);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Borrow Book");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(320, 16, 244, 28);
		add(lblNewLabel);
		
		JPanel book = new JPanel();
		book.setBounds(29, 26, 271, 126);
		book.setBackground(new Color(33, 118, 235));
		add(book);
		book.setLayout(null);
		
		JLabel bookIcon = new JLabel("");
		bookIcon.setIcon(new ImageIcon(dashboardAdminPanel.class.getResource("/data/icon/book.png")));
		bookIcon.setHorizontalAlignment(SwingConstants.CENTER);
		bookIcon.setBounds(10, 11, 100, 104);
		book.add(bookIcon);
		
		bookIssuedAm = new JLabel("10");
		bookIssuedAm.setHorizontalAlignment(SwingConstants.CENTER);
		bookIssuedAm.setForeground(new Color(245, 244, 252));
		bookIssuedAm.setFont(new Font("Arial", Font.BOLD, 30));
		bookIssuedAm.setBounds(196, 37, 70, 52);
		book.add(bookIssuedAm);
		
		JLabel lblNewLabel_2 = new JLabel("Issued Books");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setForeground(new Color(245, 244, 252));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_2.setBounds(140, 95, 122, 25);
		book.add(lblNewLabel_2);
		
		JPanel employee = new JPanel();
		employee.setBounds(29, 320, 271, 126);
		employee.setLayout(null);
		employee.setBackground(new Color(33, 118, 235));
		add(employee);
		
		JLabel employeeIcon = new JLabel("");
		employeeIcon.setIcon(new ImageIcon(dashboardAdminPanel.class.getResource("/data/icon/employee1.png")));
		employeeIcon.setHorizontalAlignment(SwingConstants.CENTER);
		employeeIcon.setBounds(10, 11, 100, 104);
		employee.add(employeeIcon);
		
		employeeAm = new JLabel("10");
		employeeAm.setHorizontalAlignment(SwingConstants.CENTER);
		employeeAm.setForeground(new Color(245, 244, 252));
		employeeAm.setFont(new Font("Arial", Font.BOLD, 30));
		employeeAm.setBounds(196, 37, 70, 52);
		employee.add(employeeAm);
		
		JLabel lblNewLabel_2_1 = new JLabel("Employees");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setForeground(new Color(245, 244, 252));
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(140, 95, 122, 25);
		employee.add(lblNewLabel_2_1);
		
		JPanel returnBook = new JPanel();
		returnBook.setBounds(29, 174, 271, 126);
		returnBook.setLayout(null);
		returnBook.setBackground(new Color(33, 118, 235));
		add(returnBook);
		
		JLabel returnBookIcon = new JLabel("");
		returnBookIcon.setIcon(new ImageIcon(dashboardAdminPanel.class.getResource("/data/icon/returnBook.png")));
		returnBookIcon.setHorizontalAlignment(SwingConstants.CENTER);
		returnBookIcon.setBounds(10, 11, 100, 104);
		returnBook.add(returnBookIcon);
		
		bookReturnAm = new JLabel("10");
		bookReturnAm.setHorizontalAlignment(SwingConstants.CENTER);
		bookReturnAm.setForeground(new Color(245, 244, 252));
		bookReturnAm.setFont(new Font("Arial", Font.BOLD, 30));
		bookReturnAm.setBounds(196, 37, 70, 52);
		returnBook.add(bookReturnAm);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Return Books");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_1.setForeground(new Color(245, 244, 252));
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_2_1_1.setBounds(140, 95, 122, 25);
		returnBook.add(lblNewLabel_2_1_1);
		
		JPanel member = new JPanel();
		member.setBounds(29, 467, 271, 126);
		member.setLayout(null);
		member.setBackground(new Color(33, 118, 235));
		add(member);
		
		JLabel memberIcon = new JLabel("");
		memberIcon.setIcon(new ImageIcon(dashboardAdminPanel.class.getResource("/data/icon/reader.png")));
		memberIcon.setHorizontalAlignment(SwingConstants.CENTER);
		memberIcon.setBounds(10, 11, 100, 104);
		member.add(memberIcon);
		
		memberAm = new JLabel("10");
		memberAm.setHorizontalAlignment(SwingConstants.CENTER);
		memberAm.setForeground(new Color(245, 244, 252));
		memberAm.setFont(new Font("Arial", Font.BOLD, 30));
		memberAm.setBounds(196, 37, 70, 52);
		member.add(memberAm);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Members");
		lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_1_1.setForeground(new Color(245, 244, 252));
		lblNewLabel_2_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_2_1_1_1.setBounds(140, 95, 122, 25);
		member.add(lblNewLabel_2_1_1_1);
		
		JLabel btnRefresh = new JLabel("Refresh");
		btnRefresh.setBounds(689, 16, 99, 28);
		btnRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnRefresh.setBackground(new Color(30, 106, 210));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRefresh.setBackground(new Color(33, 118, 235));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					btnRefresh_mouseClicked(arg0);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Something was wrong, Please try again!");
				}
			}
		});
		btnRefresh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRefresh.setBackground(new Color(30, 106, 210));
		btnRefresh.setOpaque(true);
		btnRefresh.setForeground(new Color(255, 255, 255));
		btnRefresh.setFont(new Font("Arial", Font.BOLD, 14));
		btnRefresh.setHorizontalAlignment(SwingConstants.CENTER);
		add(btnRefresh);
		
		JLabel background = new JLabel("");
		background.setHorizontalAlignment(SwingConstants.CENTER);
		background.setIcon(new ImageIcon(dashboardAdminPanel.class.getResource("/data/Main/background.png")));
		background.setBounds(0, 0, 803, 617);
		add(background);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(320, 63, 467, 225);
		add(scrollPane);
		
		panelBorrowBook = new JPanel();
		scrollPane.setViewportView(panelBorrowBook);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(320, 368, 467, 225);
		add(scrollPane_1);
		
		panelNewMember = new JPanel();
		scrollPane_1.setViewportView(panelNewMember);
		
		loadData();
		
	}
	
	// Load data
	private void loadData() {
		EmployeeModel emModel = new EmployeeModel();
		bookIssuedAm.setText(String.valueOf(emModel.getAmountIssuedBook()));
		bookReturnAm.setText(String.valueOf(emModel.getAmountReturnBook()));
		employeeAm.setText(String.valueOf(emModel.getAmountEmployee()));
		memberAm.setText(String.valueOf(emModel.getAmountMember()));
		getBookChart();
		getMemberChart();
	}
	
	// Button refresh
	private void btnRefresh_mouseClicked(MouseEvent e) {
		loadData();
	}
	
	// Get book borrow by month chart
	private void getBookChart() {
		BooksModel booksModel = new BooksModel();
		int s1 = booksModel.getAmountBookByMonth(monthNow-2);
		int s2 = booksModel.getAmountBookByMonth(monthNow-1);
		int s3 = booksModel.getAmountBookByMonth(monthNow);		
		getChart(s1, s2, s3, panelBorrowBook, "Book");
	}
	
	// Get new member by month chart
	private void getMemberChart() {
		MemberModel memberModel = new MemberModel();
		int s1 = memberModel.getNewMember(monthNow-2);
		int s2 = memberModel.getNewMember(monthNow-1);
		int s3 = memberModel.getNewMember(monthNow);		
		getChart(s1, s2, s3, panelNewMember, "Member");
	}
	
	private void getChart(int s1, int s2, int s3, JPanel panel, String content) {
		String firstM = getMonth(monthNow-2);
		String secondM = getMonth(monthNow-1);
		String thirtM = getMonth(monthNow);
		
		// Add value for chart
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(s1, String.valueOf(s1), firstM);
		dataset.setValue(s2, String.valueOf(s2), secondM);
		dataset.setValue(s3, String.valueOf(s3), thirtM);
		
		// Create new bar chart
		JFreeChart chart = ChartFactory.createBarChart("", "", content, dataset, PlotOrientation.VERTICAL, true, false, false);
		CategoryPlot catePlot = chart.getCategoryPlot();
		catePlot.setRangeGridlinePaint(Color.BLACK);
		
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setOpaque(false);
		// Set size for chart
		Dimension a = new Dimension(435, 180);
		chartPanel.setPreferredSize(a);
		
		panel.removeAll();
		panel.add(chartPanel, BorderLayout.CENTER);
		panel.validate();
	}
	
	// Convert month to string
	public static String getMonth(int month) {
	    return new DateFormatSymbols().getMonths()[month-1];
	}
}
