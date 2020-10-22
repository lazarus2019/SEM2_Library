package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.ConnectDB;
import entities.BookBorrow;
import entities.Borrow_bill;

public class BookBorrowModel {
	public static List<BookBorrow> getListBookBorrows(Borrow_bill bill){
		List<BookBorrow> bookBorrows = new ArrayList<BookBorrow>();
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement preparedStatement = con
					.prepareStatement("select * from bor_book where borrow_ID = ?  ");
			preparedStatement.setInt(1, bill.getBorrow_ID());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				BookBorrow bookBorrow = new BookBorrow();
				bookBorrow.setBorrow_ID(bill.getBorrow_ID());
				bookBorrow.setBorrow_date(bill.getBorrow_date());
				bookBorrow.setReturn_date(bill.getReturn_date());
				bookBorrow.setEmployee_ID(bill.getEmployee_ID());
				bookBorrow.setMemberName(MemberModel.getNameByID(bill.getMember_ID()));
				bookBorrow.setTitle(BooksModel.getTitleByID(resultSet.getString("book_ID")));
				bookBorrow.setStatusOk(resultSet.getInt("status") == 1 ? "Returned" : (resultSet.getInt("status") == 2 ? "Not Return" : "Lost"));
				
				bookBorrows.add(bookBorrow);
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
		return bookBorrows;
	}
}
