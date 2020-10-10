package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.ConnectDB;
import entities.Borrow_bill;
import entities.Member;
import main.employeePanel;

public class Borrow_billModel {

	public List<Borrow_bill> findAll(){
		try {
			List<Borrow_bill> borrow_bills = new ArrayList<Borrow_bill>();
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement("select * from borrow_bill");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Borrow_bill borrow_bill = new Borrow_bill();
				borrow_bill.setBorrow_ID(resultSet.getInt("borrow_ID"));
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
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement("select count(status) as number from borrow_bill where status = ?");
			preparedStatement.setBoolean(1, status);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			return resultSet.getInt("number");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		
	}
	
}
