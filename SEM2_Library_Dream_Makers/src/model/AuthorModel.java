package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import connect.ConnectDB;
import entities.Author;

public class AuthorModel {

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

	public List<Author> searchBooks(String book_ID) {
		try {
			List<Author> authors = new ArrayList<Author>();
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(
					"select * from books b, author a, au_book ab where b.book_ID = ? and b.book_ID = ab.book_ID and ab.author_ID = a.author_ID");
			preparedStatement.setString(1, book_ID);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Author author = new Author();
				author.setName(resultSet.getString("name"));
				authors.add(author);
			}
			return authors;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}	
	}

	// Start NVT
	public Author findAuthorbyName(String name) {
		Author author = new Author();
		try {
			PreparedStatement preparedStatement = new ConnectDB().getConnection().prepareStatement(
					" SELECT * FROM author where name = ? ");
			preparedStatement.setString(1, name.trim());
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
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
	public static boolean create(Author author) {

		try {
			PreparedStatement preparedStatement = new ConnectDB().getConnection().prepareStatement(
					" insert into author(author_ID , name )  values(?,?) ");
			
			preparedStatement.setString(1, author.getAuthor_ID());
			preparedStatement.setString(2, author.getName());
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			return false;
		}
	}
	// End NVT
}
