package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import connect.ConnectDB;

public class LibCardModel {
	static String sql;

	public static Date getCreatedByIDCard(String ID_Card) {
		Connection con = ConnectDB.getConnection();
		Date created = new Date();
		sql = "SELECT start_date FROM lib_card WHERE card_number = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, ID_Card);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				created = resultSet.getDate("start_date");
			}
		} catch (Exception e) {
			return null;
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return created;
	}

	public Date getExpirationDate(String idCard) {
		Connection con = ConnectDB.getConnection();
		try {
			Date expiration_date = null;
			PreparedStatement preparedStatement = con
					.prepareStatement("select expiration_date from lib_card where card_number = ?");
			preparedStatement.setString(1, idCard);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				expiration_date = resultSet.getDate("expiration_date");
			}
			return expiration_date;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
