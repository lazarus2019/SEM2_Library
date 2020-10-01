package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;
import java.util.Random;

import connect.ConnectDB;
import entities.Employee;

public class EmployeeModel {
	static String sql;
	static String charString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	// Check Login - NTS
	public static Employee checkLogin(String username) {
		Employee employee = null;
		sql = "SELECT * FROM employee WHERE username = ?";
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				employee = new Employee();
				employee.setEmployee_ID(resultSet.getString("employee_ID"));
				employee.setUsername(resultSet.getString("username"));
				employee.setPassword(resultSet.getString("password"));
				return employee;
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			return employee;
		}
	}

	// Decrypt password - NTS
	public static String decryptPassword(String password) {
		String password_cut = new String(Base64.getMimeDecoder().decode(password));
		return new String(password_cut.substring(0, password_cut.length() - 5));
	}

	// Encrypt password - NTS
	public static String encryptPassword(String password) {
		Random rand = new Random();
		String password_hash = "";
		for (int i = 0; i < 5; i++) {
			password_hash += charString.charAt(rand.nextInt(charString.length()));
		}
		String password_save = password + password_hash;
		return Base64.getEncoder().encodeToString(password_save.getBytes());
	}
}
