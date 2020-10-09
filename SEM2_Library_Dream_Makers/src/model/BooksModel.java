package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import connect.ConnectDB;
import entities.Books;

public class BooksModel {

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
			System.err.println(e.getMessage());
			books = null;
		}

		return books;
	}

	public Books find(String id) {
		
		Books book = new Books();
		try {
			PreparedStatement preparedStatement = new ConnectDB().getConnection()
					.prepareStatement("select * from books where book_ID = ?") ;
			preparedStatement.setString(1, id );
			ResultSet resultSet = preparedStatement.executeQuery() ;
			if(resultSet.next()) {	
				book.setBook_ID(resultSet.getString("book_ID"));
				book.setCall_number(resultSet.getString("call_number"));
				book.setIsbn(resultSet.getString("isbn"));
				book.setTitle(resultSet.getString("title"));
				book.setCategory_ID(resultSet.getInt("category_ID"));
				book.setPublish_ID(resultSet.getString("publish_ID"));
				book.setQuantity(resultSet.getInt("quantity"));
			}			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			book = null ; 
		} 		
		
		return book;
		
	}
}