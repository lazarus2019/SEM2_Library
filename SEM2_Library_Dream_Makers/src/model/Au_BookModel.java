package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import connect.ConnectDB;
import entities.Author;
import entities.Books;

public class Au_BookModel {

	public static boolean createAu_Book(String book_ID, String author_ID) {
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement preparedStatement = con
					.prepareStatement(" insert into au_book(book_ID,author_ID) values(?,?) ");

			preparedStatement.setString(1, "" + book_ID);
			preparedStatement.setString(2, "" + author_ID);

			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
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

	public static boolean delete(String book_ID) {
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(" delete from au_book where book_ID = ? ");

			preparedStatement.setString(1, book_ID);
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
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

	public static boolean update(String book_ID, String author_ID) {

		try {
			PreparedStatement preparedStatement = new ConnectDB().getConnection()
					.prepareStatement(" update au_book set author_ID = ? where book_ID = ? ");

			preparedStatement.setString(1, author_ID);
			preparedStatement.setString(2, book_ID);
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			return false;
		}
	}

}
