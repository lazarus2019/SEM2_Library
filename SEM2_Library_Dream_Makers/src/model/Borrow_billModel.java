package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import connect.ConnectDB;
import entities.Borrow_bill;
import entities.Member;
import main.employeePanel;

public class Borrow_billModel {
	
	static String sql;

	public List<Borrow_bill> findAll() {
		try {
			List<Borrow_bill> borrow_bills = new ArrayList<Borrow_bill>();
			PreparedStatement preparedStatement = ConnectDB.getConnection()
					.prepareStatement("select * from borrow_bill");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Borrow_bill borrow_bill = new Borrow_bill();
				borrow_bill.setMember_ID(resultSet.getString("member_ID"));
				borrow_bill.setEmployee_ID(resultSet.getString("employee_ID"));
				borrow_bill.setDescription(resultSet.getString("description"));
				borrow_bill.setStatus(resultSet.getBoolean("status"));
				borrow_bill.setBorrow_date(resultSet.getDate("borrow_date"));
				borrow_bill.setTerm_date(resultSet.getDate("term_date"));
				borrow_bill.setReturn_date(resultSet.getDate("return_date"));
				borrow_bill.setDeposit_fee(resultSet.getDouble("deposit_fee"));
				borrow_bill.setLate_fee(resultSet.getDouble("late_fee"));
				borrow_bills.add(borrow_bill);
			}
			return borrow_bills;
		} catch (Exception e) {
			return null;
		}
	}

	public Integer count(boolean status) {
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection()
					.prepareStatement("select count(status) as number from borrow_bill where status = ?");
			preparedStatement.setBoolean(1, status);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			return resultSet.getInt("number");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	// Start NNHV
	public Borrow_bill showBorrowBook(String card_number, int status) {
		Borrow_bill borrow_bill = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection()
					.prepareStatement("select * from borrow_bill bi, member m, bor_book bo "
							+ " where m.card_number = ? and bo.status = ? and bi.member_ID = m.member_ID and bo.borrow_ID = bi.borrow_ID ");
			preparedStatement.setString(1, card_number);
			preparedStatement.setInt(2, status);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				borrow_bill = new Borrow_bill();
				borrow_bill.setBorrow_ID(resultSet.getInt("borrow_ID"));
				borrow_bill.setTerm_date(resultSet.getDate("term_Date"));
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		return borrow_bill;
	}

	public boolean create(Borrow_bill borrow_bill) {
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(
					" insert into borrow_bill(member_ID, employee_ID, status, borrow_date, term_date, deposit_fee, description) values(?,?,?,?,?,?, '')");
			preparedStatement.setString(1, borrow_bill.getMember_ID());
			preparedStatement.setString(2, borrow_bill.getEmployee_ID());
			preparedStatement.setBoolean(3, borrow_bill.isStatus());
			preparedStatement.setDate(4, new java.sql.Date(borrow_bill.getBorrow_date().getTime()));
			preparedStatement.setDate(5, new java.sql.Date(borrow_bill.getTerm_date().getTime()));
			preparedStatement.setDouble(6, borrow_bill.getDeposit_fee());
			return preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}

	}

	public boolean update(Borrow_bill borrow_bill, String member_ID) {
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(
					"update borrow_bill set status = ?, return_date = ?, late_fee = ?, compen_fee = ? where member_ID = ? and status = false");
			preparedStatement.setBoolean(1, borrow_bill.isStatus());
			preparedStatement.setDate(2, new java.sql.Date(borrow_bill.getReturn_date().getTime()));
			preparedStatement.setDouble(3, borrow_bill.getLate_fee());
			preparedStatement.setDouble(4, borrow_bill.getCompensation_fee());
			preparedStatement.setString(5, member_ID);
			return preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	public Integer getBorrowId() {
		int id = 0;
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection()
					.prepareStatement("select borrow_ID from borrow_bill order by borrow_ID desc limit 1");
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				id = resultSet.getInt("borrow_ID");
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return 0;
		}
		return id;
	}
	
	public Integer getReturnId(String member_ID, boolean status) {
		int id = 0;
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection()
					.prepareStatement("select borrow_ID from borrow_bill where member_ID = ? and status = ?");
			preparedStatement.setString(1, member_ID);
			preparedStatement.setBoolean(2, status);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				id = resultSet.getInt("borrow_ID");
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return 0;
		}
		return id;
	}
	// End NNHV
	
	// GET BILLS BY MONTH AND YEAR - NST
	public static List<Borrow_bill> getAllBills(int day, int month, int year, int option) {
		List<Borrow_bill> bills = new ArrayList<Borrow_bill>();

		// Switch condition
		switch (option) {
		case 0:
			sql = "SELECT * FROM borrow_bill b WHERE YEAR(b.borrow_date) = ?";
			break;
		case 1:
			sql = "SELECT * FROM borrow_bill b WHERE YEAR(b.borrow_date) = ? AND MONTH(b.borrow_date) = ? AND DAY(b.borrow_date) = ?";
			break;
		case 2:
			sql = "SELECT * FROM borrow_bill b WHERE YEAR(b.borrow_date) = ? AND MONTH(b.borrow_date) = ? AND DAY(b.borrow_date) = ?";
			break;
		case 3:
			sql = "SELECT * FROM borrow_bill b WHERE YEAR(b.borrow_date) = ? AND MONTH(b.borrow_date) = ?";
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
				Borrow_bill bill = new Borrow_bill();
				bill.setBorrow_ID(resultSet.getInt("borrow_ID"));
				bill.setMember_ID(resultSet.getString("member_ID"));
				bill.setStatus(resultSet.getBoolean("status"));
				bill.setBorrow_date(resultSet.getDate("borrow_date"));
				bills.add(bill);
			}
		} catch (Exception e) {
			return null;
		}

		return bills;
	}

}
