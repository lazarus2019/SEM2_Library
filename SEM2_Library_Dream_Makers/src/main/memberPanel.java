package main;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import entities.Author;
import entities.Books;
import entities.Employee;
import entities.Member;
import model.EmployeeModel;
import model.MemberModel;
import model.MemberModel;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;

import java.util.Enumeration;
import java.util.List;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import checking.CheckValidate;

import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.text.SimpleDateFormat;

import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;

public class memberPanel extends JPanel {
	private JTextField JSearch;
	private JTextField JtextMember_ID;
	private JTextField JtextName;
	private JTextField JtextAddress;
	private JTextField JtextPhone;
	private JTextField JtextCardNumber;
	private final ButtonGroup buttonGender = new ButtonGroup();
	private static byte[] imageInByte = null;
	private static String imageType = null;
	private static SimpleDateFormat sdfm = new SimpleDateFormat("dd/MM/yyyy");
	private static DefaultTableModel defaultTableModel = new DefaultTableModel() {

		@Override
		public boolean isCellEditable(int arg0, int arg1) {
			return false;
		}

	};
	private JDateChooser JTextDate;
	private JRadioButton male;
	private JRadioButton female;
	private JTable JTablemember;
	private JComboBox JComboboxSearch;

	/**
	 * Create the panel.
	 */
	public memberPanel() {
		setBounds(0, 0, 803, 617);
		setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Manage", null, panel, null);
		panel.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 244, 252));
		panel_2.setBounds(11, 11, 775, 88);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JSearch = new JTextField();
		JSearch.setBounds(485, 45, 174, 33);
		panel_2.add(JSearch);
		JSearch.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(30, 106, 210));
		btnSearch.setForeground(Color.WHITE);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BtnSearch_actionPerformed(arg0);
			}
		});
		btnSearch.setBounds(667, 45, 97, 33);
		panel_2.add(btnSearch);

		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(30, 106, 210));
		btnAdd.setForeground(Color.WHITE);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Create_actionPerformed(arg0);
			}
		});
		btnAdd.setBounds(11, 45, 121, 33);
		panel_2.add(btnAdd);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(new Color(30, 106, 210));
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Update_actionPerformed(arg0);
			}
		});
		btnUpdate.setBounds(141, 45, 121, 33);
		panel_2.add(btnUpdate);

		JButton btnDetele = new JButton("Detele");
		btnDetele.setBackground(new Color(30, 106, 210));
		btnDetele.setForeground(Color.WHITE);
		btnDetele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Delete_actionPerformed(arg0);
			}
		});
		btnDetele.setBounds(269, 45, 121, 33);
		panel_2.add(btnDetele);

		JLabel label = new JLabel("Feature");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 26));
		label.setBounds(338, 3, 98, 29);
		panel_2.add(label);

		JComboboxSearch = new JComboBox();
		JComboboxSearch.setBackground(Color.WHITE);
		JComboboxSearch.setBounds(413, 45, 72, 33);
		panel_2.add(JComboboxSearch);
		JComboboxSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Search_Gender_actionPerformed(arg0);
			}
		});

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(245, 244, 252));
		panel_3.setBounds(11, 116, 775, 228);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel = new JLabel("Member_ID");
		lblNewLabel.setBounds(37, 34, 75, 24);
		panel_3.add(lblNewLabel);

		JtextMember_ID = new JTextField();
		JtextMember_ID.setEditable(false);
		JtextMember_ID.setBackground(Color.WHITE);
		JtextMember_ID.setBounds(136, 34, 198, 24);
		panel_3.add(JtextMember_ID);
		JtextMember_ID.setColumns(10);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(37, 79, 75, 24);
		panel_3.add(lblName);

		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(37, 130, 75, 24);
		panel_3.add(lblDate);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(37, 178, 75, 24);
		panel_3.add(lblAddress);

		JtextName = new JTextField();
		JtextName.setColumns(10);
		JtextName.setBounds(136, 80, 198, 24);
		panel_3.add(JtextName);

		JtextAddress = new JTextField();
		JtextAddress.setColumns(10);
		JtextAddress.setBounds(136, 179, 198, 24);
		panel_3.add(JtextAddress);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(361, 34, 75, 24);
		panel_3.add(lblGender);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(361, 79, 75, 24);
		panel_3.add(lblPhone);

		JLabel lblCardNumber = new JLabel("Card Number");
		lblCardNumber.setBounds(361, 130, 86, 24);
		panel_3.add(lblCardNumber);

		male = new JRadioButton("Male");
		male.setBackground(new Color(245, 244, 252));
		buttonGender.add(male);
		male.setBounds(459, 34, 75, 25);
		panel_3.add(male);

		female = new JRadioButton("Female");
		female.setSelected(true);
		female.setBackground(new Color(245, 244, 252));
		buttonGender.add(female);
		female.setBounds(538, 34, 86, 25);
		panel_3.add(female);

		JtextPhone = new JTextField();
		JtextPhone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				checkKeyTyped(arg0);
			}
		});
		JtextPhone.setColumns(10);
		JtextPhone.setBounds(459, 79, 214, 24);
		panel_3.add(JtextPhone);

		JLabel lblPhoto = new JLabel("Photo");
		lblPhoto.setBounds(361, 179, 86, 24);
		panel_3.add(lblPhoto);

		JtextCardNumber = new JTextField();
		JtextCardNumber.setEditable(false);
		JtextCardNumber.setColumns(10);
		JtextCardNumber.setBounds(459, 130, 214, 24);
		panel_3.add(JtextCardNumber);

		JTextDate = new JDateChooser();
		JTextFieldDateEditor editor2 = (JTextFieldDateEditor) JTextDate.getDateEditor();
		editor2.setEditable(false);
		JTextDate.setDateFormatString("dd/MM/yyyy");
		JTextDate.setBounds(136, 132, 198, 22);
		panel_3.add(JTextDate);

		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(30, 106, 210));
		btnReset.setForeground(Color.WHITE);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BtnReset_actionPerformed(arg0);
			}
		});
		btnReset.setBounds(678, 30, 86, 33);
		panel_3.add(btnReset);

		JLabel lblDetails = new JLabel("Details");
		lblDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetails.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblDetails.setBounds(344, 3, 86, 29);
		panel_3.add(lblDetails);

		JButton btnUpload = new JButton("Upload");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnUpload_actionPerformed(arg0);
			}
		});
		btnUpload.setForeground(Color.WHITE);
		btnUpload.setBackground(new Color(30, 106, 210));
		btnUpload.setBounds(459, 178, 86, 24);
		panel_3.add(btnUpload);

		JButton btnExtend = new JButton("Extend");
		btnExtend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnExtend.setForeground(Color.WHITE);
		btnExtend.setBackground(new Color(30, 106, 210));
		btnExtend.setBounds(678, 169, 86, 33);
		panel_3.add(btnExtend);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 244, 252));
		panel_1.setBounds(11, 354, 775, 220);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 754, 167);
		scrollPane.getViewport().setBackground(Color.WHITE);
		panel_1.add(scrollPane);
		scrollPane.setBorder(null);

		JTablemember = new JTable();
		JTablemember.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JTablemember.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Click_mouseClicked(arg0);
			}
		});
		scrollPane.setViewportView(JTablemember);

		JLabel lblListMember = new JLabel("List Member");
		lblListMember.setHorizontalAlignment(SwingConstants.CENTER);
		lblListMember.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblListMember.setBounds(317, 0, 141, 29);
		panel_1.add(lblListMember);
		name();
		loadData();
	}

	private void name() {
		DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<String>();
		defaultComboBoxModel.addElement("male");
		defaultComboBoxModel.addElement("female");
		JComboboxSearch.setModel(defaultComboBoxModel);
	}

	// loadData
	private void loadData() {
		defaultTableModel.getDataVector().removeAllElements();
		defaultTableModel.fireTableDataChanged();
		MemberModel memberModel = new MemberModel();
		String[] colums = { "No. ", "Member_ID", "Name", "Gender", "Phone", "Card_Number" };

		defaultTableModel.setColumnIdentifiers(colums);

		DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<String>();
		defaultComboBoxModel.addElement("Male");
		defaultComboBoxModel.addElement("Female");
		JComboboxSearch.setModel(defaultComboBoxModel);

		int no = 1;
		for (Member member : memberModel.findAll()) {
			defaultTableModel.addRow(new Object[] { no, member.getMember_ID(), member.getName(),
					member.isGender() ? "Male" : "Female", member.getPhone(), member.getCard_number() });
			no++;
		}
		JTablemember.setModel(defaultTableModel);
		TableColumnModel columnModelFB = JTablemember.getColumnModel();
		columnModelFB.getColumn(0).setPreferredWidth(50);
		columnModelFB.getColumn(1).setPreferredWidth(150);
		columnModelFB.getColumn(2).setPreferredWidth(150);
		columnModelFB.getColumn(3).setPreferredWidth(149);
		columnModelFB.getColumn(4).setPreferredWidth(149);
		columnModelFB.getColumn(5).setPreferredWidth(150);
		JTablemember.getTableHeader().setReorderingAllowed(false);
		JTablemember.getTableHeader().setResizingAllowed(false);
		JTableHeader tableHeader = JTablemember.getTableHeader();
		tableHeader.setBackground(new Color(223, 233, 242));
		tableHeader.setForeground(Color.BLACK);
		setUneditable(JtextMember_ID);

		generateID();
		cardNumberID();
	}

	private void generateID() {
		// Generate ID - NTanh
		MemberModel memberModel = new MemberModel();
		int id = 1;
		String member_ID = "member1";
		List<Member> members = memberModel.findAll();
		for (int i = 0; i < members.size(); i++) {
			if (member_ID.equals(members.get(i).getMember_ID())) {
				id++;
				member_ID = "member" + id;
			}
		}
		JtextMember_ID.setText(member_ID);
	}

	private void cardNumberID() {
		// Generate Card number ID - NTanh
		MemberModel memberModel = new MemberModel();
		int id = 0;
		String cardNum = "";
		boolean flag = false;
		int count = 0;
		List<Member> members = memberModel.findAll();
		while (count < members.size()) {
			id = (int) (Math.random() * (8999998) + 1000000);
			cardNum = "Std" + id;
			for (Member member : members) {
				if (!cardNum.equals(member.getCard_number())) {
					count++;
				}
			}
		}
		JtextCardNumber.setText(cardNum);
	}

	// Add - NTanh
	public void Create_actionPerformed(ActionEvent arg0) {
		MemberModel memberModel = new MemberModel();
		String memberID = JtextMember_ID.getText();
		String name = JtextName.getText().trim();
		String address = JtextAddress.getText().trim();
		String phone = JtextPhone.getText().trim();
		String cardNumber = JtextCardNumber.getText();
		boolean isMale = male.isSelected() ? true : false;
		Date dateOB = JTextDate.getDate();
		if (name.isEmpty() || address.isEmpty() || phone.isEmpty() || dateOB == null) {
			JOptionPane.showMessageDialog(null, "Please fill out all fields");
		} else {
			if (name.length() < 5) {
				JOptionPane.showMessageDialog(null, "Name must at least 5 characters");
			} else {
				if (address.length() < 5) {
					JOptionPane.showMessageDialog(null, "Address too short, please give us details address");
				} else {
					if (!CheckValidate.checkPhone(phone)) {
						JOptionPane.showMessageDialog(null, "Phone must be a number and at least 9 characters");
					} else {
						if (!CheckValidate.checkDate10(dateOB)) {
							JOptionPane.showMessageDialog(null, "Member age must than 10 years old");
						} else {

							if (checkMemberID(memberID)) {
								if (imageInByte != null) {
									Member member = new Member(memberID, name, dateOB, isMale, address,
											String.valueOf(phone), cardNumber, "", getStartDate(),
											getExpiredDate(getStartDate()), imageInByte);
									if (memberModel.Add(member)) {
										if (memberModel.savePhoto(member.getMember_ID(), imageType)) {
											JOptionPane.showMessageDialog(null, "Completed");
											resetEverything();
											loadData();
											imageType = null;
											imageInByte = null;
										} else {
											JOptionPane.showMessageDialog(null, "Cant upload photo");
										}
									} else {
										JOptionPane.showMessageDialog(null, "Failed");
									}
								} else {
									JOptionPane.showMessageDialog(null, "Please upload photo for member");
								}
							} else {
								JOptionPane.showMessageDialog(null, "This info must update not create");
							}
						}
					}

				}
			}
		}
	}

	private Date getStartDate() {
		return new Date();
	}

	private Date getExpiredDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.YEAR, 3);
		Date newDate = c.getTime();
		return newDate;
	}

	private boolean checkMemberID(String id) {
		MemberModel memberModel = new MemberModel();
		List<Member> members = memberModel.findAll();
		for (int i = 0; i < members.size(); i++) {
			if (id.equals(members.get(i).getMember_ID())) {
				return false;
			}
		}
		return true;
	}

	// Update - NTanh
	public void Update_actionPerformed(ActionEvent arg0) {
		int selectedIndex = JTablemember.getSelectedRow();
		if (selectedIndex == -1) {
			JOptionPane.showMessageDialog(null, "Please select a member before press update");
		} else {
			MemberModel memberModel = new MemberModel();
			String memberID = JtextMember_ID.getText();
			String name = JtextName.getText().trim();
			String address = JtextAddress.getText().trim();
			String phone = JtextPhone.getText().trim();
			String cardNumber = JtextCardNumber.getText();
			boolean isMale = male.isSelected() ? true : false;
			Date dateOB = JTextDate.getDate();
			if (name.isEmpty() || address.isEmpty() || phone.isEmpty() || dateOB == null) {
				JOptionPane.showMessageDialog(null, "Please fill out all fields");
			} else {
				if (name.length() < 5) {
					JOptionPane.showMessageDialog(null, "Name must at least 5 characters");
				} else {
					if (address.length() < 5) {
						JOptionPane.showMessageDialog(null, "Address too short, please give us details address");
					} else {
						if (!CheckValidate.checkPhone(phone)) {
							JOptionPane.showMessageDialog(null, "Phone must be a number and at least 9 characters");
						} else {
							if (!CheckValidate.checkDate10(dateOB)) {
								JOptionPane.showMessageDialog(null, "Member age must than 10 years old");
							} else {
								Member member = new Member(memberID, name, dateOB, isMale, address,
										String.valueOf(phone), cardNumber, "", null, null, null);
								if (memberModel.update(member, memberID)) {
									if (imageInByte != null) {
										if (memberModel.savePhoto(member.getMember_ID(), imageType)) {
											JOptionPane.showMessageDialog(null, "Completed");
										} else {
											JOptionPane.showMessageDialog(null, "Cant upload photo");
										}
									}
									JOptionPane.showMessageDialog(null, "Completed");
									resetEverything();
									loadData();
									imageType = null;
									imageInByte = null;
								} else {
									JOptionPane.showMessageDialog(null, "Failed");
								}
							}
						}

					}
				}
			}
		}
	}

	// delete - NT
	public void Delete_actionPerformed(ActionEvent arg0) {
		try {
			MemberModel memberModel = new MemberModel();
			int selectedIndex = JTablemember.getSelectedRow();
			if (selectedIndex == -1) {
				JOptionPane.showMessageDialog(null, "Please select a member before push delete");
			} else {
				String id = JTablemember.getValueAt(selectedIndex, 1).toString();
				if (id == null) {
					JOptionPane.showMessageDialog(null, "Please select a member !");
				} else {
					int result = JOptionPane.showConfirmDialog(null, "Are you sure ? ", "Comfirm",
							JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						if (memberModel.delete(id)) {
							resetEverything();
							loadData();
						} else {
							JOptionPane.showMessageDialog(null, "Failed");
						}
					}
				}
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}

	}

	// Btn search
	public void BtnSearch_actionPerformed(ActionEvent arg0) {
		defaultTableModel.getDataVector().removeAllElements();
		defaultTableModel.fireTableDataChanged();
		MemberModel memberModel = new MemberModel();
		String key = JSearch.getText();
		int no = 1;
		for (Member member : memberModel.searchMember(key)) {
			defaultTableModel.addRow(new Object[] { no, member.getMember_ID(), member.getName(),
					member.isGender() ? "Male" : "Female", member.getPhone(), member.getCard_number() });
			no++;
		}
		JTablemember.setModel(defaultTableModel);
	}

	public void Search_Gender_actionPerformed(ActionEvent arg0) {
		defaultTableModel.getDataVector().removeAllElements();
		defaultTableModel.fireTableDataChanged();
		MemberModel memberModel = new MemberModel();
		int keyf;
		String keys = JComboboxSearch.getSelectedItem().toString().toLowerCase();
		if (keys.equalsIgnoreCase("male")) {
			keyf = 1;
		} else {
			keyf = 0;
		}
		int no = 1;
		for (Member member : memberModel.searchMemberGender(keyf)) {
			defaultTableModel.addRow(new Object[] { no, member.getMember_ID(), member.getName(),
					member.isGender() ? "Male" : "Female", member.getPhone(), member.getCard_number() });
			no++;
		}
		JTablemember.setModel(defaultTableModel);
	}
	// Click

	public void Click_mouseClicked(MouseEvent arg0) {
		int selectedIndex = JTablemember.getSelectedRow();
		String member_ID = JTablemember.getValueAt(selectedIndex, 1).toString();

		MemberModel memberModel = new MemberModel();
		Member member = memberModel.findByID(member_ID);

		JtextMember_ID.setText(member.getMember_ID());
		JtextName.setText(member.getName());
		JTextDate.setDate(member.getDob());
		if (member.isGender() == true) {
			male.setSelected(true);
		} else {
			female.setSelected(true);
		}
		JtextAddress.setText(member.getAddress());
		JtextPhone.setText(member.getPhone());
		JtextCardNumber.setText(member.getCard_number());
	}

	// Upload image
	private void btnUpload_actionPerformed(ActionEvent e) {

		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Update Image");
		FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGE FILE - jpg, png", "jpg", "png");
		chooser.setFileFilter(fnef);
		int result = chooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			String filePath = chooser.getSelectedFile().getAbsolutePath();
			if (filePath.endsWith(".png") || filePath.endsWith(".PNG") || filePath.endsWith(".JPG")
					|| filePath.endsWith(".jpg")) {
				try {
					BufferedImage originalImage = ImageIO.read(new File(filePath));
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					if (filePath.endsWith(".png") || filePath.endsWith(".PNG")) {
						ImageIO.write(originalImage, "png", baos);
						imageType = "png";
					}
					if (filePath.endsWith(".JPG") || filePath.endsWith(".jpg")) {
						ImageIO.write(originalImage, "jpg", baos);
						imageType = "jpg";
					}
					baos.flush();
					imageInByte = baos.toByteArray();
					JOptionPane.showMessageDialog(null, "Upload photo success");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			} else {
				JOptionPane.showMessageDialog(null, "Please choose file have type [png, jpg]");
			}
		}
	}

	// Reset
	public void BtnReset_actionPerformed(ActionEvent arg0) {
		resetEverything();
	}

	private void resetEverything() {
		JtextCardNumber.setText("");
		JtextName.setText("");
		JtextAddress.setText("");
		JtextPhone.setText("");
		loadData();
	}

	// Button-Group - NT
	private String getGenderSelected(ButtonGroup buttonGroup) {
		Enumeration<AbstractButton> buttons = buttonGender.getElements();
		while (buttons.hasMoreElements()) {
			JRadioButton radio = (JRadioButton) buttons.nextElement();
			if (radio.isSelected()) {
				return radio.getText();
			}
		}
		return null;
	}

	// Set edit
	private void setUneditable(JTextField j) {
	}

	private void setEditable(JTextField ji) {
		ji.setEditable(true);
	}

	private void checkKeyTyped(KeyEvent e) {
		if (e.getKeyChar() == ' ') {
			e.consume();
		}
	}
}
