package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.sun.mail.imap.protocol.Status;

import connect.ConnectDB;
import entities.Books;
import entities.Bor_book;
import entities.ObseleteBook;

public class BooksModel {

	static String sql;

	public List<Books> findAll() {
		List<Books> books = new ArrayList<Books>();
		try {
			PreparedStatement preparedStatement = new ConnectDB().getConnection()
					.prepareStatement("SELECT * FROM books ");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Books book = new Books();
				book.setBook_ID(resultSet.getString("book_ID"));
				book.setCall_number(resultSet.getString("call_number"));
				book.setIsbn(resultSet.getString("isbn"));
				book.setTitle(resultSet.getString("title"));
				book.setPublish_ID(resultSet.getString("publish_ID"));
				book.setCategory_ID(resultSet.getInt("category_ID"));
				book.setQuantity(resultSet.getInt("quantity"));
				books.add(book);

			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			books = null;
		}

		return books;
	}

	public static boolean create(Books book) {

		try {
			PreparedStatement preparedStatement = new ConnectDB().getConnection().prepareStatement(
					" insert into books(book_ID,call_number,isbn,title,category_ID,publish_ID,quantity) values(?,?,?,?,?,?,?) ");

			preparedStatement.setString(1, book.getBook_ID());
			preparedStatement.setString(2, book.getCall_number());
			preparedStatement.setString(3, book.getIsbn());
			preparedStatement.setString(4, book.getTitle());
			preparedStatement.setInt(5, book.getCategory_ID());
			preparedStatement.setString(6, book.getPublish_ID());
			preparedStatement.setInt(7, book.getQuantity());
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			return false;
		}
	}

	public static boolean update(Books book, String book_ID) {

		try {
			PreparedStatement preparedStatement = new ConnectDB().getConnection().prepareStatement(
					" update books set call_number = ? , isbn = ? , title = ? , category_ID = ? , publish_ID = ? , quantity = ? where book_ID = ?  ");
			preparedStatement.setString(1, book.getCall_number());
			preparedStatement.setString(2, book.getIsbn());
			preparedStatement.setString(3, book.getTitle());
			preparedStatement.setInt(4, book.getCategory_ID());
			preparedStatement.setString(5, book.getPublish_ID());
			preparedStatement.setInt(6, book.getQuantity());
			preparedStatement.setString(7, book_ID);
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			return false;
		}
	}

	public static boolean delete(String book_ID) {
		try {
			PreparedStatement preparedStatement = new ConnectDB().getConnection()
					.prepareStatement("delete from books where book_ID = ? ");
			preparedStatement.setString(1, book_ID);
			return preparedStatement.executeUpdate() > 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			return false;
		}

	}

	public String findPublish(String publish_ID) {
		String name = null;
		try {
			PreparedStatement preparedStatement = new ConnectDB().getConnection()
					.prepareStatement(" select * from publish_house where publish_ID = ?  ");
			preparedStatement.setString(1, publish_ID);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				name = resultSet.getString("name");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage() + " 456");
			name = null;
		}
		return name;

	}

	public String findCategory(int category_ID) {
		String name = null;
		try {
			PreparedStatement preparedStatement = new ConnectDB().getConnection()
					.prepareStatement(" select * from category where category_ID = ?  ");
			preparedStatement.setInt(1, category_ID);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				name = resultSet.getString("name");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage() + " 123");
			name = null;
		}
		return name;
	}

	public Books find(String id) {

		Books book = new Books();
		try {
			PreparedStatement preparedStatement = new ConnectDB().getConnection()
					.prepareStatement("select * from books where book_ID = ?");
			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				book.setBook_ID(resultSet.getString("book_ID"));
				book.setCall_number(resultSet.getString("call_number"));
				book.setIsbn(resultSet.getString("isbn"));
				book.setTitle(resultSet.getString("title"));
				book.setCategory_ID(resultSet.getInt("category_ID"));
				book.setPublish_ID(resultSet.getString("publish_ID"));
				book.setQuantity(resultSet.getInt("quantity"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			book = null;
		}

		return book;

	}

	public List<Books> searchBooks(String keyword) {
		List<Books> books = new ArrayList<Books>();
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection()
					.prepareStatement("select * from books where title like ?");
			preparedStatement.setString(1, "%" + keyword + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Books book = new Books();
				book.setBook_ID(resultSet.getString("book_ID"));
				book.setCall_number(resultSet.getString("call_number"));
				book.setIsbn(resultSet.getString("isbn"));
				book.setTitle(resultSet.getString("title"));
				book.setCategory_ID(resultSet.getInt("category_ID"));
				book.setPublish_ID(resultSet.getString("publish_ID"));
				book.setQuantity(resultSet.getInt("quantity"));
				books.add(book);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		return books;
	}

	// Get Obselete Books - NTS
	public static List<ObseleteBook> getAll(List<Bor_book> books) {
		List<ObseleteBook> alls = new ArrayList<ObseleteBook>();
		sql = "SELECT employee_ID, member_ID, title FROM borrow_bill, books WHERE borrow_ID = ? AND book_ID = ?";
		for (Bor_book book : books) {
			try {
				PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
				preparedStatement.setString(1, book.getBorrow_ID());
				preparedStatement.setString(2, book.getBook_ID());
				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					ObseleteBook all = new ObseleteBook();
					all.setFee(book.getFee());
					all.setInvoice_ID(book.getBorrow_ID());
					all.setTerm_date(book.getTerm_date());
					all.setReturn_date(book.getReturn_date());
					all.setTitle(resultSet.getString("title"));
					all.setEmployee_name(EmployeeModel.getNameById(resultSet.getString("employee_ID")));
					all.setCard_number(MemberModel.getCardNoById(resultSet.getString("member_ID")));
					alls.add(all);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return alls;
	}

	// Get Obselete bill by month and year - NTS
	public static List<Bor_book> getObseleteBook(int status, int month, int year) {
		sql = "SELECT * FROM bor_book WHERE status = ? AND MONTH(return_date) = ? AND YEAR(return_date) = ?";
		List<Bor_book> books = new ArrayList<Bor_book>();
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, status);
			preparedStatement.setInt(2, month);
			preparedStatement.setInt(3, year);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getInt("status") == 3) {
					Bor_book book = new Bor_book();
					book.setBorrow_ID(resultSet.getString("borrow_ID"));
					book.setBook_ID(resultSet.getString("book_ID"));
					book.setFee(resultSet.getDouble("late_fee"));
					book.setReturn_date(resultSet.getDate("return_date"));
					book.setTerm_date(resultSet.getDate("term_date"));
					books.add(book);
				} else {
					if (checkBWDate(resultSet.getDate("term_date"), resultSet.getDate("return_date"))) {
						Bor_book book = new Bor_book();
						book.setBorrow_ID(resultSet.getString("borrow_ID"));
						book.setBook_ID(resultSet.getString("book_ID"));
						book.setFee(resultSet.getDouble("late_fee"));
						book.setReturn_date(resultSet.getDate("return_date"));
						book.setTerm_date(resultSet.getDate("term_date"));
						books.add(book);
					}
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		return books;
	}

	// Check between date - NTS
	public static boolean checkBWDate(Date dateOne, Date dateTwo) {
		return (dateOne.getTime() - dateTwo.getTime()) < 0;
	}

	// AMOUNT OF BOOK BY MONTH - NTS
	public static int getAmountBookByMonth(int month) {
		int amountBook = 0;
		sql = "SELECT COUNT(b.book_ID) AS amountB FROM bor_book b WHERE MONTH(b.borrow_date) = ?";
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, month);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			amountBook = resultSet.getInt("amountB");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return amountBook;
	}
}