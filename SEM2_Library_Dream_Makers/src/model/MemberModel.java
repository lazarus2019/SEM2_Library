package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.ConnectDB;
import entities.Member;


public class MemberModel {
	static String sql;
	
	public List<Member> findAll(){
		try {
			List<Member> members = new ArrayList<Member>();
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement("select * from member");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
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
	
	public Member find(String idCard) {
		Member member = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement("select * from member where card_number = ?");
			preparedStatement.setString(1, idCard);
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
	
	// Get card number by id - NTS
	public static String getCardNoById(String member_ID) {
		sql = "SELECT * FROM member WHERE member_ID = ?";
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, member_ID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return resultSet.getString("card_number");
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	
	public static int getNewMember(int month) {
		int memberAM = 0;
		sql = "SELECT COUNT(m.member_ID) AS 'amount' FROM member m, lib_card l WHERE m.card_number = l.card_number AND MONTH(l.start_date) = ?";
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, month);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			memberAM  = resultSet.getInt("amount");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 0;
		}
		return memberAM;
	}
}
