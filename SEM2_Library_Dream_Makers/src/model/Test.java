package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.ConnectDB;

public class Test {
	static String sql;

	public static void main(String[] args) {
		List<String> test = getObseleteBill(11, 2020);
		System.out.println(test);
	}

	// Get Obselete bill by month and year
	public static List<String> getObseleteBill(int month, int year) {
		sql = "SELECT borrow_ID FROM borrow_bill WHERE status = 1 AND MONTH(return_date) = ? AND YEAR(return_date) = ? AND DATEDIFF(day, return_date, term_date) < 0";
		List<String> bills = new ArrayList<String>();
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, month);
			preparedStatement.setInt(2, year);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				bills.add(resultSet.getString("borrow_ID"));
			}
			return bills;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
}
