package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.record.PageBreakRecord.Break;

import connect.ConnectDB;
import entities.BookBorrow;
import entities.Borrow_bill;

public class BookBorrowModel {
	static String sql;
	public static List<BookBorrow> getAllBookBorrows(List<Borrow_bill> bills, int option) {
		List<BookBorrow> bookBorrows = new ArrayList<BookBorrow>();

		for (Borrow_bill bill : bills) {
			List<BookBorrow> books = getListBookBorrows(bill, option);
			if (books != null) {
				for (BookBorrow book : books) {
					bookBorrows.add(book);
				}
			}
		}

		return bookBorrows;
	}

	public static List<BookBorrow> getListBookBorrows(Borrow_bill bill, int option) {
		List<BookBorrow> bookBorrows = new ArrayList<BookBorrow>();
		Connection con = ConnectDB.getConnection();
		if(option == 1 || option == 2 || option == 3) {
			sql = "SELECT * FROM bor_book WHERE borrow_ID = ? AND status = ?";
		}else if(option == 4){
			sql = "SELECT * FROM bor_book WHERE borrow_ID = ?";
		}else {
			return null;
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			if(option == 1 || option == 2 || option == 3) {
				preparedStatement.setInt(1, bill.getBorrow_ID());
				preparedStatement.setInt(2, option);
			}else if(option == 4){
				preparedStatement.setInt(1, bill.getBorrow_ID());
			}
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				BookBorrow bookBorrow = new BookBorrow();
				bookBorrow.setBorrow_ID(bill.getBorrow_ID());
				bookBorrow.setBorrow_date(bill.getBorrow_date());
				bookBorrow.setReturn_date(bill.getReturn_date());
				bookBorrow.setEmployee_ID(bill.getEmployee_ID());
				bookBorrow.setStatus(bill.isStatus());
				bookBorrow.setMemberName(MemberModel.getNameByID(bill.getMember_ID()));
				bookBorrow.setTitle(BooksModel.getTitleByID(resultSet.getString("book_ID")));
				bookBorrow.setStatusOk(resultSet.getInt("status") == 1 ? "Returned"
						: (resultSet.getInt("status") == 2 ? "Not Return" : "Lost"));

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
