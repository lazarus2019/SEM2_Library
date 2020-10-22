package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Random;

import org.mindrot.jbcrypt.BCrypt;

import connect.ConnectDB;
import entities.Employee;
import main.bookPanel;

public class EmployeeModel {
	static String sql;
	static String charString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	// Start NTA
	// Find all - NTannh
	public List<Employee> findAll() {
		Connection con = ConnectDB.getConnection();
		sql = "SELECT * FROM employee";
		List<Employee> employees = new ArrayList<Employee>();
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setEmployee_ID(resultSet.getString("employee_ID"));
				employee.setUsername(resultSet.getString("username"));
				employee.setName(resultSet.getString("name"));
				employee.setDob(simpleDateFormat.parse(resultSet.getString("dob")));
				employee.setGender(resultSet.getBoolean("gender"));
				employee.setAddress(resultSet.getString("address"));
				employee.setPhone(resultSet.getString("phone"));
				employee.setEmail(resultSet.getString("email"));
				employee.setLevel(resultSet.getString("level"));
				employees.add(employee);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			employees = null;
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return employees;
	}

	// Search Size

	public static List<Employee> searchEmployee(String keyword) {
		Connection con = ConnectDB.getConnection();
		List<Employee> employees = new ArrayList<Employee>();
		try {
			PreparedStatement preparedStatement = con
					.prepareStatement("select * from employee where employee_ID like ?");
			preparedStatement.setString(1, "%" + keyword + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setEmployee_ID(resultSet.getString("employee_ID"));
				employee.setName(resultSet.getString("name"));
				employee.setAddress(resultSet.getString("address"));
				employee.setEmail(resultSet.getString("email"));
				employee.setLevel(resultSet.getString("level"));
				employees.add(employee);
			}
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
		return employees;
	}

	// Search Combobox
	public static List<Employee> searchEmployeeCom(String keyword) {
		Connection con = ConnectDB.getConnection();
		List<Employee> employees = new ArrayList<Employee>();
		try {
			PreparedStatement preparedStatement = con.prepareStatement("select * from employee where level like ?");
			preparedStatement.setString(1, "%" + keyword + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setEmployee_ID(resultSet.getString("employee_ID"));
				employee.setName(resultSet.getString("name"));
				employee.setAddress(resultSet.getString("address"));
				employee.setEmail(resultSet.getString("email"));
				employee.setLevel(resultSet.getString("level"));
				employees.add(employee);
			}
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
		return employees;
	}

	// Delete - NTanh
	public static boolean delete(String employee_ID) {
		sql = "delete from employee where employee_ID = ?";
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, employee_ID);
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	// Add employee - NT
	public static boolean Add(Employee employee) {
		sql = "INSERT into employee(employee_ID, username, password, name, dob, gender, address, phone, email, level) values(?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, employee.getEmployee_ID());
			preparedStatement.setString(2, employee.getUsername());
			preparedStatement.setString(3, employee.getPassword());
			preparedStatement.setString(4, employee.getName());
			preparedStatement.setDate(5, new java.sql.Date(employee.getDob().getTime()));
			preparedStatement.setBoolean(6, employee.isGender());
			preparedStatement.setString(7, employee.getAddress());
			preparedStatement.setString(8, employee.getPhone());
			preparedStatement.setString(9, employee.getEmail());
			preparedStatement.setString(10, employee.getLevel());
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			return false;
		}

	}

	// Update - NTanh
	public static boolean update(Employee employee, String employee_ID) {
		sql = " update employee set employee_ID = ? , username = ? , password = ? , name = ? , dob = ? , gender = ? , address = ? , phone = ? , email = ? , level = ? where employee_ID = ? ";
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);

			preparedStatement.setString(1, employee.getEmployee_ID());
			preparedStatement.setString(2, employee.getUsername());
			preparedStatement.setString(3, employee.getPassword());
			preparedStatement.setString(4, employee.getName());
			preparedStatement.setDate(5, new java.sql.Date(employee.getDob().getTime()));
			preparedStatement.setBoolean(6, employee.isGender());
			preparedStatement.setString(7, employee.getAddress());
			preparedStatement.setString(8, employee.getPhone());
			preparedStatement.setString(9, employee.getEmail());
			preparedStatement.setString(10, employee.getLevel());
			preparedStatement.setString(11, employee_ID);
			return preparedStatement.executeUpdate() > 0;

		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}

	}
	// End NTA

	// Get amount employee - NTS
	public static int getAmountEmployee() {
		Connection con = ConnectDB.getConnection();
		int am_employee = 0;
		sql = "SELECT COUNT(level) as amount FROM employee WHERE level = 'librarian'";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			am_employee = resultSet.getInt("amount");
		} catch (Exception e) {
			return am_employee;
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return am_employee;
	}
	
	// Get amount of member - NTS
	public static int getAmountMember() {
		Connection con = ConnectDB.getConnection();
		int am_member = 0;
		sql = "SELECT COUNT(member_ID) as amount FROM member";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			am_member = resultSet.getInt("amount");
		} catch (Exception e) {
			return am_member;
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return am_member;
	}

	// Get employee name by id - NTS
	public static String getNameById(String employee_ID) {
		Connection con = ConnectDB.getConnection();
		sql = "SELECT * FROM employee WHERE employee_ID = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, employee_ID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getString("name");
			} else {
				throw new Exception();
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
	}

	// Get employee by id - NTS
	public static Employee getById(String employee_ID) {
		Connection con = ConnectDB.getConnection();
		Employee employee = null;
		sql = "SELECT * FROM employee WHERE employee_ID = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
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

	// Update Password by email - NTS
	public static boolean updateByEmail(String email) {
		sql = "UPDATE employee SET password = ? WHERE email = ?";
		try {
			String passwordE = generatePassword();
			String passwordDB = encryptPassword(passwordE);
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, passwordDB);
			preparedStatement.setString(2, email);
			if (!SendMail.sendMailPassword(email, passwordE)) {
				return false;
			}
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			return false;
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
		Connection con = ConnectDB.getConnection();
		Employee employee = null;
		sql = "SELECT * FROM employee WHERE username = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
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

	// Forgot Password - NTS
	public static Employee forGotPass(String email) {
		Connection con = ConnectDB.getConnection();
		Employee employee = null;
		sql = "SELECT * FROM employee WHERE email = ?  ";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				employee = new Employee();
				employee.setEmail(resultSet.getString("email"));
				return employee;
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			return employee;
		}finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	// Encrypt password - NTS
	public static String encryptPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}

	// Get random password - NTS
	public static String generatePassword() {
		Random rand = new Random();
		String password = "";
		for (int i = 0; i < 8; i++) {
			password += charString.charAt(rand.nextInt(charString.length()));
		}
		return password;
	}
}
