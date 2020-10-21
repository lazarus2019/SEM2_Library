package model;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Tessss extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JTextArea textArea;
	ByteArrayOutputStream baos = null;
	PreparedStatement preparedStatement = null;
	Connection connection = null;
	Connection connection2 = null;
	Statement statement = null;
	ResultSet resultSet = null;
	FileOutputStream fileOuputStream = null;
	FileOutputStream fs = null;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tessss frame = new Tessss();
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
	public Tessss() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 136, 296, 153);
		contentPane.add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ttesssss(arg0);
			}
		});
		btnNewButton.setBounds(57, 39, 89, 23);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getImage(arg0);
			}
		});
		btnNewButton_1.setBounds(199, 39, 89, 23);
		contentPane.add(btnNewButton_1);
	}

	private void Ttesssss(ActionEvent e) {
		try {
			JFileChooser fileChooser = new JFileChooser();
			int result = fileChooser.showOpenDialog(null);
			if (result == JFileChooser.APPROVE_OPTION) {
				File path = fileChooser.getSelectedFile();
				BufferedImage originalImage = ImageIO.read(new File(path.getAbsolutePath()));

				baos = new ByteArrayOutputStream();
				ImageIO.write(originalImage, "jpg", baos);
				baos.flush();
				byte[] imageInByte = baos.toByteArray();

				connection = getConnection();
				String insertImageSql = "UPDATE member set src = ? WHERE member_ID = 'member4'";
				preparedStatement = connection.prepareStatement(insertImageSql);
				preparedStatement.setBytes(1, imageInByte);

				preparedStatement.executeUpdate();
				System.out.println("insert database");
			}

		} catch (Exception e2) {
			System.out.println("Failed to make connection!" + e);
		} finally {

			try {
				if (baos != null) {
					baos.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
				if (fileOuputStream != null) {
					fileOuputStream.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	private void getImage(ActionEvent e) {
		try {
			connection2 = getConnection();
			String insertImageSql = "SELECT src FROM member WHERE member_ID = 'member4'";
			preparedStatement = connection2.prepareStatement(insertImageSql);

			System.out.println("Image sucessfully inserted to the table");
			resultSet = preparedStatement.executeQuery();
			byte b[];
			Blob blob;
			int random = (int) Math.floor(Math.random() * 1000 + 1);
			if (resultSet.next()) {
				String url = "src/data/member/member" + random + ".jpg";
				File f = new File(url);
				fs = new FileOutputStream(f);
				blob = resultSet.getBlob("src");
				b = blob.getBytes(1, (int) blob.length());
				fs.write(b);
				insertImageSql = "UPDATE member set photo = ? WHERE member_ID = 'member4'";
				preparedStatement = connection2.prepareStatement(insertImageSql);
				preparedStatement.setString(1, url);
				preparedStatement.executeUpdate();
			}
		} catch (Exception e2) {
			System.out.println("Failed to make connection!" + e);
		} finally {

			try {
				if (baos != null) {
					baos.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
				if (fileOuputStream != null) {
					fileOuputStream.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	// Static method to get connection object
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qltv?serverTimeZone=UTC", "root", "");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			connection = null; // == Connect to database fail
		}
		return connection;
	}
}
