package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sun.rmi.log.LogOutputStream;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.awt.event.MouseMotionAdapter;

public class infoDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	// Decalre variable
	private int xPosition, yPosition, mouseX, mouseY;

	private JLabel logo;
	private Image logoImage = new ImageIcon("src/data/Main/logo_Library.png").getImage();
	private final JLabel lblNewLabel = new JLabel(
			"<html><body>Mohan's Library V1.0<br>© 2020 Dream Makers Team. All rights reserved.<br><br>Aim of application is help Monica managing the things more effectively and also save her time. She can manage issued books, manage employees, statistical about rating how many the books get back and member who usually borrow book. The app will automatic</body></html>");
	private final JLabel lblNewLabel_1 = new JLabel("Go to source ->");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			infoDialog dialog = new infoDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public infoDialog() {
		setModal(true);
		setUndecorated(true);
		setBounds(100, 100, 450, 375);
		setLocationRelativeTo(null);
		contentPanel.setBackground(new Color(211, 211, 211));
		contentPanel.setBounds(0, 0, 450, 375);
		contentPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				try {
					panel_2_mouseDragged(arg0);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Something was wrong! Please try again");
				}				
			}
			@Override
			public void mouseMoved(MouseEvent e) {
				try {
					panel_2_mouseMoved(e);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Something was wrong! Please try again");
				}	
			}
		});
		getContentPane().setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setBounds(40, 11, 370, 80);
		logo.setIcon(new ImageIcon(infoDialog.class.getResource("/data/Main/info_logo.png")));
		contentPanel.add(logo);

		JSeparator separator = new JSeparator();
		separator.setBounds(40, 102, 370, 2);
		contentPanel.add(separator);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(40, 114, 370, 114);

		contentPanel.add(lblNewLabel);

		JButton btnClose = new JButton("Close");
		btnClose.setBorder(null);
		btnClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClose.setForeground(new Color(255, 255, 255));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					btnClose_actionPerformed(arg0);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Something was wrong! Please try again");
				}
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnClose.setBackground(new Color(30, 144, 255));
		btnClose.setBounds(351, 341, 89, 23);
		contentPanel.add(btnClose);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Desktop d = Desktop.getDesktop();
					d.browse(new URI("https://github.com/lazarus2019/SEM2_Library"));
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Something was wrong! Please try again");
				}
			}
		});
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setBounds(40, 272, 132, 23);
		
		contentPanel.add(lblNewLabel_1);
	}

	// Button close dialog
	private void btnClose_actionPerformed(ActionEvent e) {
		this.dispose();
		setVisible(false);
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
