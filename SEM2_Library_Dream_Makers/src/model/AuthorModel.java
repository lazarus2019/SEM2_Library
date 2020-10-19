package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.xml.stream.events.StartDocument;

import connect.ConnectDB;
import entities.Author;

public class AuthorModel {
	static String sql;

	public List<Author> findAll() {
		try {
			List<Author> authors = new ArrayList<Author>();
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement("select * from author");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Author author = new Author();
				author.setAuthor_ID(resultSet.getString("author_ID"));
				author.setName(resultSet.getString("name"));
				author.setNation(resultSet.getString("nation"));
				authors.add(author);
			}
			return authors;
		} catch (Exception e) {
			return null;
		}
	}

	// Start NTA
	// Create
	public static boolean create(Author author) {

		try {
			PreparedStatement preparedStatement = new ConnectDB().getConnection()
					.prepareStatement(" insert into author(author_ID , name , nation )  values(?,?,?) ");

			preparedStatement.setString(1, author.getAuthor_ID());
			preparedStatement.setString(2, author.getName());
			preparedStatement.setString(3, author.getNation());
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			return false;
		}
	}
	// Delete - NTanh
	public static boolean delete(String author_ID) {
		sql = "delete from author where author_ID = ?";
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, author_ID);
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	// Update - NTanh
	public static boolean update(Author author, String author_ID) {
		sql = " update author set author_ID = ? , name = ? , nation = ? where author_ID = ? ";
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);

			preparedStatement.setString(1, author.getAuthor_ID());
			preparedStatement.setString(2, author.getName());
			preparedStatement.setString(3, author.getNation());
			preparedStatement.setString(4, author_ID);
			return preparedStatement.executeUpdate() > 0;

		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}

	}

	// Get author by id - NTanh
	public static Author getById(String author_ID) {
		Author author = null;
		sql = "SELECT * FROM author WHERE author_ID = ?";
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, author_ID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				author = new Author();
				author.setAuthor_ID(resultSet.getString("author_ID"));
				author.setName(resultSet.getString("name"));
				author.setNation(resultSet.getString("nation"));
				return author;
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			return author;
		}
	}

	public static List<Author> searchAuthors(String keys) {
		List<Author> authorr = new ArrayList<Author>();
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection()
					.prepareStatement("select * from author where author_ID like ?");
			preparedStatement.setString(1, "%" + keys + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Author author = new Author();
				author.setAuthor_ID(resultSet.getString("author_ID"));
				author.setName(resultSet.getString("name"));
				author.setNation(resultSet.getString("nation"));
				authorr.add(author);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}
		return authorr;
	}

	//Search book
	public List<Author> searchBooks(String book_ID) {
		List<Author> authors = new ArrayList<Author>();
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(
					"select * from books b, author a, au_book ab where b.book_ID = ? and b.book_ID = ab.book_ID and ab.author_ID = a.author_ID");
			preparedStatement.setString(1, book_ID);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Author author = new Author();
				author.setAuthor_ID(resultSet.getString("author_ID"));
				author.setName(resultSet.getString("name"));
				author.setNation(resultSet.getString("nation"));
				authors.add(author);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		return authors;
	}

	//Search combobox
	public static List<Author> searchAuthor(String keyword) {
		List<Author> authors = new ArrayList<Author>();
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection()
					.prepareStatement("select * from author where nation like ?");
			preparedStatement.setString(1, "%" + keyword + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Author author = new Author();
				author.setAuthor_ID(resultSet.getString("author_ID"));
				author.setName(resultSet.getString("name"));
				author.setNation(resultSet.getString("nation"));
				authors.add(author);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		return authors;
	}
	// End NTA
	// Start NVT
	public Author findAuthorbyName(String name) {
		Author author = new Author();
		try {
			PreparedStatement preparedStatement = new ConnectDB().getConnection()
					.prepareStatement(" SELECT * FROM author where name = ? ");
			preparedStatement.setString(1, name.trim());
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				author.setAuthor_ID(resultSet.getString("author_ID"));
				author.setName(resultSet.getString("name"));
				author.setNation(resultSet.getString("nation"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			author = null;
		}
		return author;

	}
	// End NVT
}
