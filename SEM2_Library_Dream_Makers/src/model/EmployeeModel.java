package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Random;

import connect.ConnectDB;
import entities.Employee;
import main.bookPanel;

public class EmployeeModel {
	static String sql;
	static String charString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	// Get amount employee - NTS
	public static int getAmountEmployee() {
		int am_employee = 0;
		sql = "SELECT COUNT(level) as amount FROM employee WHERE level = 'librarian'";
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			am_employee = resultSet.getInt("amount");
		} catch (Exception e) {
			return am_employee;
		}
		return am_employee;
	}
	
	// Get issused book - NTS
	public static int getAmountReturnBook() {
		int am_returnBook = 0;
		sql = "SELECT COUNT(status) as amount FROM bor_book WHERE status = true";
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			am_returnBook = resultSet.getInt("amount");
		} catch (Exception e) {
			return am_returnBook;
		}
		return am_returnBook;
	}
	
	// Get issused book - NTS
	public static int getAmountIssuedBook() {
		int am_issuedBook = 0;
		sql = "SELECT COUNT(status) as amount FROM bor_book WHERE status = false";
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			am_issuedBook = resultSet.getInt("amount");
		} catch (Exception e) {
			return am_issuedBook;
		}
		return am_issuedBook;
	}
	
	// Get member - NTS
	public static int getAmountMember() {
		int am_member = 0;
		sql = "SELECT COUNT(member_ID) as amount FROM member";
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			am_member = resultSet.getInt("amount");
		} catch (Exception e) {
			return am_member;
		}
		return am_member;
	}

	// Get employee by id - NTS
	public static Employee getById(String employee_ID) {
		Employee employee = null;
		sql = "SELECT * FROM employee WHERE employee_ID = ?";
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, employee_ID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				employee = new Employee();
				employee.setEmployee_ID(resultSet.getString("employee_ID"));
				employee.setUsername(resultSet.getString("username"));
				employee.setPassword(resultSet.getString("password"));
				employee.setEmail(resultSet.getString("email"));
				employee.setLevel(resultSet.getString("level"));
				employee.setDob(resultSet.getDate("dob"));
				employee.setAddress(resultSet.getString("address"));
				employee.setPhone(resultSet.getString("phone"));
				employee.setName(resultSet.getString("name"));
				employee.setPhoto(resultSet.getString("photo"));
				employee.setGender(resultSet.getBoolean("gender"));
				return employee;
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			return employee;
		}
	}

	// Update Info by id - NTS
	public static boolean updateById(Employee employee) {
		sql = "UPDATE employee SET name = ?, dob = ?, address = ?, gender = ?, phone = ?, photo = ? WHERE employee_ID = ?";
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setDate(2, new java.sql.Date(employee.getDob().getTime()));
			preparedStatement.setString(3, employee.getAddress());
			preparedStatement.setBoolean(4, employee.isGender());
			preparedStatement.setString(5, employee.getPhone());
			preparedStatement.setString(6, employee.getPhoto());
			preparedStatement.setString(7, employee.getEmployee_ID());
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			return false;
		}
	}

	// Change Password - NTS
	public static boolean changePassword(String employee_ID, String password) {
		sql = "UPDATE employee SET password = ? WHERE employee_ID = ?";
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, employee_ID);
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			return false;
		}
	}

	// Change email - NTS
	public static boolean changeEmail(String employee_ID, String email) {
		sql = "UPDATE employee SET email = ? WHERE employee_ID = ?";
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, employee_ID);
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			return false;
		}
	}

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
				employee.setEmail(resultSet.getString("email"));
				employee.setLevel(resultSet.getString("level"));
				employee.setDob(resultSet.getDate("dob"));
				employee.setAddress(resultSet.getString("address"));
				employee.setPhone(resultSet.getString("phone"));
				employee.setName(resultSet.getString("name"));
				employee.setPhoto(resultSet.getString("photo"));
				employee.setGender(resultSet.getBoolean("gender"));
				return employee;
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			return employee;
		}
	}

	// Forgot Password - NTS
	public static Employee forGotPass(String email) {
		Employee employee = null;
		sql = "SELECT * FROM employee WHERE email = ?  ";
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				employee = new Employee();
				employee.setPassword(resultSet.getString("password"));
				employee.setEmail(resultSet.getString("email"));
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
