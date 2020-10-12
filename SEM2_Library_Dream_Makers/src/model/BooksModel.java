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
import entities.Borrow_bill;
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

	// Get Obselete bills by month and year - NTS
	public static List<Borrow_bill> getBills(int month, int year) {
		List<Borrow_bill> bills = new ArrayList<Borrow_bill>();
		sql = "SELECT * FROM borrow_bill b WHERE status = 1 AND MONTH(b.return_date) = ? AND YEAR(b.return_date) = ?";
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, month);
			preparedStatement.setInt(2, year);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (checkBWDate(resultSet.getDate("term_date"), resultSet.getDate("return_date"))) {
					Borrow_bill bill = new Borrow_bill();
					bill.setBorrow_ID(resultSet.getInt("borrow_ID"));
					bill.setMember_ID(resultSet.getString("member_ID"));
					bill.setEmployee_ID(resultSet.getString("employee_ID"));
					bill.setTerm_date(resultSet.getDate("term_date"));
					bill.setReturn_date(resultSet.getDate("return_date"));
					bills.add(bill);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return bills;
		}
		return bills;
	}

	// Get Obselete book - NTS
	public static List<ObseleteBook> getObseleteBook(List<Borrow_bill> bills, int status) {
		List<ObseleteBook> books = new ArrayList<ObseleteBook>();
		MemberModel memberModel = new MemberModel();
		EmployeeModel employeeModel = new EmployeeModel();
		for (Borrow_bill bill : bills) {
			sql = "SELECT title AS tt FROM bor_book b, books bs WHERE status = ? AND borrow_ID = ? AND b.book_ID = bs.book_ID";
			try {
				PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
				preparedStatement.setInt(1, status);
				preparedStatement.setInt(2, bill.getBorrow_ID());
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					ObseleteBook book = new ObseleteBook();
					book.setInvoice_ID(bill.getBorrow_ID());
					book.setReturn_date(bill.getReturn_date());
					book.setTerm_date(bill.getTerm_date());
					book.setEmployee_name(employeeModel.getNameById(bill.getEmployee_ID()));
					book.setTitle(resultSet.getString("tt"));
					book.setCard_number(memberModel.getCardNoById(bill.getMember_ID()));
					books.add(book);
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
				return null;
			}
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
		sql = "SELECT COUNT(b.book_ID) AS amountB FROM bor_book b, borrow_bill bb WHERE MONTH(bb.borrow_date) = ? AND b.borrow_ID = bb.borrow_ID";
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