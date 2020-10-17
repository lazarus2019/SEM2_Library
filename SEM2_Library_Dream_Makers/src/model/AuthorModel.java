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

}
