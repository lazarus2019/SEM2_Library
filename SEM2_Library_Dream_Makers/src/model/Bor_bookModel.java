package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.ConnectDB;
import entities.Bor_book;
import entities.Borrow_bill;

public class Bor_bookModel {

	public List<Bor_book> findAll() {
		Connection con = ConnectDB.getConnection();
		try {
			List<Bor_book> bor_books = new ArrayList<Bor_book>();
			PreparedStatement preparedStatement = con.prepareStatement("select * from bor_book");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Bor_book bor_book = new Bor_book();
				bor_book.setBook_ID(resultSet.getString("book_ID"));
				bor_book.setBorrow_ID(resultSet.getInt("borrow_ID"));
				bor_books.add(bor_book);
			}
			return bor_books;
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

	public List<Bor_book> showBook(String idCard, int status) {
		Connection con = ConnectDB.getConnection();
		try {
			List<Bor_book> bor_books = new ArrayList<Bor_book>();
			PreparedStatement preparedStatement = con
					.prepareStatement("select * from bor_book bo, borrow_bill bi, member m "
							+ " where bo.status = ? and m.card_number = ? and bo.borrow_ID = bi.borrow_ID and bi.member_ID = m.member_ID");
			preparedStatement.setInt(1, status);
			preparedStatement.setString(2, idCard);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Bor_book bor_book = new Bor_book();
				bor_book.setBorrow_ID(resultSet.getInt("borrow_ID"));
				bor_book.setStatus(resultSet.getInt("status"));
				bor_book.setBook_ID(resultSet.getString("book_ID"));
				bor_books.add(bor_book);
			}
			return bor_books;
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

	public Integer count(int status, String idBook) {
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement preparedStatement = con
					.prepareStatement("select count(status) as number from bor_book where status = ? and book_ID = ?");
			preparedStatement.setInt(1, status);
			preparedStatement.setString(2, idBook);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			return resultSet.getInt("number");
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

	public boolean create(Bor_book bor_book) {
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(
					"insert into bor_book(book_ID, borrow_ID, status, description) values(?, ?, ?, '')");
			preparedStatement.setString(1, bor_book.getBook_ID());
			preparedStatement.setInt(2, bor_book.getBorrow_ID());
			preparedStatement.setInt(3, bor_book.getStatus());
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
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

	public boolean update(int status, int borrow_ID, String book_ID) {
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement preparedStatement = con
					.prepareStatement("update bor_book set status = ? where borrow_ID = ? and book_ID = ?");
			preparedStatement.setInt(1, status);
			preparedStatement.setInt(2, borrow_ID);
			preparedStatement.setString(3, book_ID);
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
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

	// Start NVT
	public boolean delete(int borrow_ID) {
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement preparedStatement = con.prepareStatement("delete from bor_book where borrow_ID = ?  ");
			preparedStatement.setInt(1, borrow_ID);
			return preparedStatement.executeUpdate() > 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			return false;
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
	// End NVT
}
