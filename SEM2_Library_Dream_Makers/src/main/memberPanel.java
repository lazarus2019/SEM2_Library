package main;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.util.Date;

import java.util.Enumeration;
import java.util.List;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class memberPanel extends JPanel {
	private JTextField JSearch;
	private JTextField JtextMember_ID;
	private JTextField JtextName;
	private JTextField JtextAddress;
	private JTextField JtextPhone;
	private JTextField JtextCardNumber;
	private JTextField JtextPhoto;
	private final ButtonGroup buttonGender = new ButtonGroup();
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
		female.setBackground(new Color(245, 244, 252));
		buttonGender.add(female);
		female.setBounds(538, 34, 86, 25);
		panel_3.add(female);

		JtextPhone = new JTextField();
		JtextPhone.setColumns(10);
		JtextPhone.setBounds(459, 79, 214, 24);
		panel_3.add(JtextPhone);

		JLabel lblPhoto = new JLabel("Photo");
		lblPhoto.setBounds(361, 179, 86, 24);
		panel_3.add(lblPhoto);

		JtextCardNumber = new JTextField();
		JtextCardNumber.setColumns(10);
		JtextCardNumber.setBounds(459, 130, 214, 24);
		panel_3.add(JtextCardNumber);

		JtextPhoto = new JTextField();
		JtextPhoto.setColumns(10);
		JtextPhoto.setBounds(459, 178, 214, 24);
		panel_3.add(JtextPhoto);

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
		String[] colums = { "No. ", "Member_ID", "Name", "Gender", "Phone", "Card_Number"};
		
		defaultTableModel.setColumnIdentifiers(colums);
		
		DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<String>();
		defaultComboBoxModel.addElement("Male");
		defaultComboBoxModel.addElement("Female");
		JComboboxSearch.setModel(defaultComboBoxModel);
		
		int no = 1;
		for (Member member : memberModel.findAll()) {
			defaultTableModel.addRow(
					new Object[] { no, member.getMember_ID(), member.getName(), member.isGender() ? "Male" : "Female",
							member.getPhone(), member.getCard_number()});
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
		// Generate ID - NTanh
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
		setUneditable(JtextMember_ID);
	}

	// Add - NTanh
	public void Create_actionPerformed(ActionEvent arg0) {
		MemberModel memberModel = new MemberModel();
		Member member = new Member();
		member.setMember_ID(JtextMember_ID.getText().trim());
		member.setName(JtextName.getText().trim());
		member.setDob(JTextDate.getDate());
		if (getGenderSelected(buttonGender).equalsIgnoreCase("female")) {
			member.setGender(false);
		} else {
			member.setGender(true);
		}
		member.setAddress(JtextAddress.getText().trim());
		member.setPhone(JtextPhone.getText().trim());
		member.setCard_number(JtextCardNumber.getText().trim());
		member.setPhoto(JtextPhoto.getText().trim());
		
		if (memberModel.Add(member)) {
			JOptionPane.showMessageDialog(null, "Completed");
			loadData();
			setEditable(JtextCardNumber);
			JtextName.setText("");
			JtextAddress.setText("");
			JtextPhone.setText("");
			JtextPhoto.setText("");
		} else {
			JOptionPane.showMessageDialog(null, "Faild");
		}

	}

	// Update - NTanh
	public void Update_actionPerformed(ActionEvent arg0) {
		int selectedIndex = JTablemember.getSelectedRow();
		String member_IDs = JTablemember.getValueAt(selectedIndex, 1).toString();
		MemberModel memberModel = new MemberModel();
		Member member = memberModel.findByID(member_IDs);
		if (JtextName.getText().trim() != null) {
			member.setName(JtextName.getText().trim());
		}
		if (JTextDate.getDate() != null) {
			member.setDob(JTextDate.getDate());
		}
		String genders = getGenderSelected(buttonGender);
		if (genders != null) {
			if(genders.equalsIgnoreCase("female")) {
				member.setGender(false);
			}else {
				member.setGender(true);
			}
		}
		if (JtextPhone.getText().trim() != null) {
			member.setPhone(JtextPhone.getText().trim());
		}
		if (JtextAddress.getText().trim() != null) {
			member.setAddress(JtextAddress.getText().trim());
		}
		if (JtextPhoto.getText().trim() != null) {
			member.setPhoto(JtextPhoto.getText().trim());
		}
		if (JtextCardNumber.getText().trim() != null) {
			member.setCard_number(JtextCardNumber.getText().trim());
		}
		if (member_IDs == null) {
			JOptionPane.showMessageDialog(null, "Please select a book !");
		} else {
			if (memberModel.update(member, member_IDs)) {
				loadData();
			} else {
				JOptionPane.showMessageDialog(null, "Faild");
			}
		}

	}

	// delete - NT
	public void Delete_actionPerformed(ActionEvent arg0) {
		try {
			MemberModel memberModel = new MemberModel();
			int selectedIndex = JTablemember.getSelectedRow();
			String id = JTablemember.getValueAt(selectedIndex, 1).toString();
			if (id == null) {
				JOptionPane.showMessageDialog(null, "Please select a member !");
			} else {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure ? ", "Comfirm",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					if (memberModel.delete(id)) {
						loadData();
					} else {
						JOptionPane.showMessageDialog(null, "Failed");
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
			defaultTableModel.addRow(
					new Object[] { no, member.getMember_ID(), member.getName(), member.isGender() ? "Male" : "Female",
							member.getPhone(), member.getCard_number()});
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
		if(keys.equalsIgnoreCase("male")) {
			keyf = 1;
		} else {
			keyf = 0;
		}
		int no = 1;
		for (Member member : memberModel.searchMemberGender(keyf)) {
			defaultTableModel.addRow(
					new Object[] { no, member.getMember_ID(), member.getName(), member.isGender() ? "Male" : "Female",
							member.getPhone(), member.getCard_number()});
			no++;
		}
		JTablemember.setModel(defaultTableModel);
	}
	// Click

	public void Click_mouseClicked(MouseEvent arg0) {
		setUneditable(JtextCardNumber);
		int selectedIndex = JTablemember.getSelectedRow();
		String member_ID = JTablemember.getValueAt(selectedIndex, 1).toString();

		MemberModel memberModel = new MemberModel();
		Member member = memberModel.findByID(member_ID);
		
		setUneditable(JtextMember_ID);
		//setUneditable(JtextCardNumber);
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
		JtextPhoto.setText(member.getPhoto());
	}
	//Reset
	public void BtnReset_actionPerformed(ActionEvent arg0) {
		JtextCardNumber.setText("");
		setEditable(JtextCardNumber);
		JtextName.setText("");
		JtextAddress.setText("");
		JtextPhone.setText("");
		JtextPhoto.setText("");
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
		j.setEditable(false);
	}

	private void setEditable(JTextField ji) {
		ji.setEditable(true);
	}
}
