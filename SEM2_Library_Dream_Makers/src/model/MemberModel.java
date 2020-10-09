package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.ConnectDB;
import entities.Member;


public class MemberModel {

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
	
}
