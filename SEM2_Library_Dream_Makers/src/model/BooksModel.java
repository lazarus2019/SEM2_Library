package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import connect.ConnectDB;
import entities.Author;
import entities.Books;

public class BooksModel {

	static String sql;

	public List<Books> findAll() {
		List<Books> books = new ArrayList<Books>();
		try {
			PreparedStatement preparedStatement = new ConnectDB().getConnection()
					.prepareStatement("SELECT * FROM books  ");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Books book = new Books();
				book.setBook_ID(resultSet.getString("book_ID"));
				book.setCall_number(resultSet.getString("call_number"));
				book.setIsbn(resultSet.getString("isbn"));
				book.setTitle(resultSet.getString("title"));
				book.setPublish_ID(resultSet.getInt("publish_ID"));
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
			preparedStatement.setInt(6, book.getPublish_ID());
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
			preparedStatement.setInt(5, book.getPublish_ID());
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

	public String findPublish(int publish_ID) {
		String name = null;
		try {
			PreparedStatement preparedStatement = new ConnectDB().getConnection()
					.prepareStatement(" select * from publish_house where publish_ID = ?  ");
			preparedStatement.setInt(1, publish_ID);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				name = resultSet.getString("name");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			name = null;
		}
		return name;

	}

	public List<Author> findAuthor(String book_ID) {
		List<Author> authors = new ArrayList<Author>();
		try {
			PreparedStatement preparedStatement = new ConnectDB().getConnection().prepareStatement(
					" SELECT books.title as bookTitle , author.name as authorName FROM author, books ,"
					+ "au_book WHERE author.author_ID = au_book.author_ID and au_book.book_ID = books.book_ID and books.book_ID = ?  ");
			preparedStatement.setString(1, book_ID);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Author author = new Author();
				author.setName(resultSet.getString("authorName"));
				authors.add(author);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			authors = null;
		}
		return authors;

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
			System.err.println(e.getMessage());
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
				book.setPublish_ID(resultSet.getInt("publish_ID"));
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
				book.setPublish_ID(resultSet.getInt("publish_ID"));
				book.setQuantity(resultSet.getInt("quantity"));
				books.add(book);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		return books;
	}
	
	public List<Books> searchBooksbyCate(int category_ID) {
		List<Books> books = new ArrayList<Books>();
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection()
					.prepareStatement("select * from books where category_ID = ?");
			preparedStatement.setInt(1,category_ID);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Books book = new Books();
				book.setBook_ID(resultSet.getString("book_ID"));
				book.setCall_number(resultSet.getString("call_number"));
				book.setIsbn(resultSet.getString("isbn"));
				book.setTitle(resultSet.getString("title"));
				book.setCategory_ID(resultSet.getInt("category_ID"));
				book.setPublish_ID(resultSet.getInt("publish_ID"));
				book.setQuantity(resultSet.getInt("quantity"));
				books.add(book);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		return books;
	}

	// Get Obselete bill by month and year
	public static List<String> getObseleteBill(int month, int year) {
		sql = "SELECT borrow_ID FROM borrow_bill WHERE status = 1 AND MONTH(return_date) = ? AND YEAR(return_date) = ? AND DATEDIFF(day, return_date, term_date) < 0";
		List<String> bills = new ArrayList<String>();
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, month);
			preparedStatement.setInt(2, year);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				bills.add(resultSet.getString("borrow_ID"));
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		return bills;
	}
}