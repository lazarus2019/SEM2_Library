package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import connect.ConnectDB;
import entities.FamousBook;
import entities.FriendlyMember;
import entities.Member;

public class MemberModel {
	static String sql;

	public List<Member> findAll() {
		try {
			List<Member> members = new ArrayList<Member>();
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement("select * from member");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Member member = new Member();
				member.setMember_ID(resultSet.getString("member_ID"));
				member.setName(resultSet.getString("name"));
				member.setAddress(resultSet.getString("address"));
				member.setPhone(resultSet.getString("phone"));
				member.setCard_number(resultSet.getString("card_number"));
				member.setGender(resultSet.getBoolean("gender"));
				member.setDob(resultSet.getDate("dob"));
				members.add(member);
			}
			return members;
		} catch (Exception e) {
			return null;
		}
	}

	// Start NNHV
	public Member find(String idCard) {
		Member member = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection()
					.prepareStatement("select * from member where card_number = ?");
			preparedStatement.setString(1, idCard);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				member = new Member();
				member.setMember_ID(resultSet.getString("member_ID"));
				member.setName(resultSet.getString("name"));
				member.setCard_number(resultSet.getString("card_number"));
				member.setPhoto(resultSet.getString("photo"));
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			member = null;
		}
		return member;
	}

	public String getMemberID(String idCard) {
		String member_ID = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection()
					.prepareStatement("select member_ID from member where card_number = ?");
			preparedStatement.setString(1, idCard);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				member_ID = resultSet.getString("member_ID");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return member_ID;
	}
	// End NNHV
	
	// Start NVT
	public Member findByID(String member_ID) {
		Member member = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement("select * from member where member_ID = ?");
			preparedStatement.setString(1, member_ID);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				member = new Member();
				member.setMember_ID(resultSet.getString("member_ID"));
				member.setName(resultSet.getString("name"));
				member.setDob(resultSet.getDate("dob"));
				member.setGender(resultSet.getBoolean("gender"));
				member.setAddress(resultSet.getString("address"));
				member.setPhone(resultSet.getString("phone"));
				member.setCard_number(resultSet.getString("card_number"));
				member.setPhoto(resultSet.getString("photo"));
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			member = null;
		}
		return member;
	}
	// End NVT

	// Get card number by id - NTS
	public static String getCardNoById(String member_ID) {
		sql = "SELECT * FROM member WHERE member_ID = ?";
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, member_ID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getString("card_number");
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	// GET NEW MEMBER BY MONTH - NTS
	public static int getNewMember(int month) {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int memberAM = 0;
		sql = "SELECT COUNT(m.member_ID) AS 'amount' FROM member m, lib_card l WHERE m.card_number = l.card_number AND MONTH(l.start_date) = ? AND YEAR(l.start_date) = ?";
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, month);
			preparedStatement.setInt(2, year);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			memberAM = resultSet.getInt("amount");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 0;
		}
		return memberAM;
	}

	// GET FRIENDLY MEMBER - NTS
	public static List<FriendlyMember> getFriendlyMember(int day, int month, int year, int option) {
		List<FriendlyMember> members = new ArrayList<FriendlyMember>();

		// Switch condition
		switch (option) {
		case 0:
			sql = "SELECT br.member_ID AS memberID,m.name AS mbname, COUNT(bb.book_ID) AS 'amount' FROM bor_book bb, borrow_bill br, member m WHERE bb.borrow_ID = br.borrow_ID AND YEAR(br.borrow_date) = ? AND br.member_ID = m.member_ID GROUP BY br.borrow_ID ORDER BY COUNT(bb.book_ID) DESC LIMIT 5";
			break;
		case 1:
			sql = "SELECT br.member_ID AS memberID,m.name AS mbname, COUNT(bb.book_ID) AS 'amount' FROM bor_book bb, borrow_bill br, member m WHERE bb.borrow_ID = br.borrow_ID AND YEAR(br.borrow_date) = ? AND MONTH(br.borrow_date) = ? AND DAY(br.borrow_date) = ? AND br.member_ID = m.member_ID GROUP BY br.borrow_ID ORDER BY COUNT(bb.book_ID) DESC LIMIT 5";
			break;
		case 2:
			sql = "SELECT br.member_ID AS memberID,m.name AS mbname, COUNT(bb.book_ID) AS 'amount' FROM bor_book bb, borrow_bill br, member m WHERE bb.borrow_ID = br.borrow_ID AND YEAR(br.borrow_date) = ? AND MONTH(br.borrow_date) = ? AND DAY(br.borrow_date) = ? AND br.member_ID = m.member_ID GROUP BY br.borrow_ID ORDER BY COUNT(bb.book_ID) DESC LIMIT 5";
			break;
		case 3:
			sql = "SELECT br.member_ID AS memberID,m.name AS mbname, COUNT(bb.book_ID) AS 'amount' FROM bor_book bb, borrow_bill br, member m WHERE bb.borrow_ID = br.borrow_ID AND YEAR(br.borrow_date) = ? AND MONTH(br.borrow_date) = ? AND br.member_ID = m.member_ID GROUP BY br.borrow_ID ORDER BY COUNT(bb.book_ID) DESC LIMIT 5";
			break;
		default:
			return null;
		}

		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
			switch (option) {
			case 0:
				preparedStatement.setInt(1, year);
				break;
			case 1:
				preparedStatement.setInt(1, year);
				preparedStatement.setInt(2, month);
				preparedStatement.setInt(3, day);
				break;
			case 2:
				preparedStatement.setInt(1, year);
				preparedStatement.setInt(2, Calendar.getInstance().get(Calendar.MONTH) + 1);
				preparedStatement.setInt(3, day);
				break;
			case 3:
				preparedStatement.setInt(1, year);
				preparedStatement.setInt(2, month);
				break;
			default:
				return null;
			}
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				FriendlyMember member = new FriendlyMember();
				member.setMember_ID(resultSet.getString("memberID"));
				member.setName(resultSet.getString("mbname"));
				member.setAmountB(resultSet.getInt("amount"));
				members.add(member);
			}
		} catch (Exception e) {
			return null;
		}

		return members;
	}

	// GET NEW MEMBER - NTS
	public static List<Member> getAllNewMember(int day, int month, int year, int option) {
		List<Member> newMembers = new ArrayList<Member>();

		// Switch condition
		switch (option) {
		case 0:
			sql = "SELECT * FROM member m, lib_card l WHERE m.card_number = l.card_number AND YEAR(l.start_date) = ?";
			break;
		case 1:
			sql = "SELECT * FROM member m, lib_card l WHERE m.card_number = l.card_number AND YEAR(l.start_date) = ? AND MONTH(l.start_date) = ? AND DAY(l.start_date) = ?";
			break;
		case 2:
			sql = "SELECT * FROM member m, lib_card l WHERE m.card_number = l.card_number AND YEAR(l.start_date) = ? AND MONTH(l.start_date) = ? AND DAY(l.start_date) = ?";
			break;
		case 3:
			sql = "SELECT * FROM member m, lib_card l WHERE m.card_number = l.card_number AND YEAR(l.start_date) = ? AND MONTH(l.start_date) = ?";
			break;
		default:
			return null;
		}

		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
			switch (option) {
			case 0:
				preparedStatement.setInt(1, year);
				break;
			case 1:
				preparedStatement.setInt(1, year);
				preparedStatement.setInt(2, month);
				preparedStatement.setInt(3, day);
				break;
			case 2:
				preparedStatement.setInt(1, year);
				preparedStatement.setInt(2, new Date().getMonth() + 1);
				preparedStatement.setInt(3, day);
				break;
			case 3:
				preparedStatement.setInt(1, year);
				preparedStatement.setInt(2, month);
				break;
			default:
				return null;
			}
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Member newMember = new Member();
				newMember.setMember_ID(resultSet.getString("member_ID"));
				newMember.setCard_number(resultSet.getString("card_number"));
				newMember.setName(resultSet.getString("name"));
				newMembers.add(newMember);
			}
		} catch (Exception e) {
			return null;
		}

		return newMembers;
	}
}
