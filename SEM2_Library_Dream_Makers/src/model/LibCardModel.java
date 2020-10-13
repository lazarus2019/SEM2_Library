package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import connect.ConnectDB;

public class LibCardModel {
	static String sql;
	public static Date getCreatedByIDCard(String ID_Card) {
		Date created = new Date();
		sql = "SELECT start_date FROM lib_card WHERE card_number = ?";
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, ID_Card);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				created = resultSet.getDate("start_date");
			}
		} catch (Exception e) {
			return null;
		}
		return created;
	}
}
