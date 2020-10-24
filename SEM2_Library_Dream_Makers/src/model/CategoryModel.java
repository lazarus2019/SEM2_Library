package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.ConnectDB;
import entities.Author;
import entities.Category;

public class CategoryModel {
	public List<Category> findAll() {
		Connection con = ConnectDB.getConnection();
		List<Category> categories = new ArrayList<Category>();
		try {
			PreparedStatement preparedStatement = con
					.prepareStatement("SELECT * FROM category  ");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Category category = new Category();
				category.setCategory_ID(resultSet.getInt("category_ID"));
				category.setName(resultSet.getString("name"));
				categories.add(category) ;

			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			categories = null;
		}finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return categories;
	}
	
	public static Category find(int category_ID) {
		Connection con = ConnectDB.getConnection();
		Category category = null ; 
		try {
			PreparedStatement preparedStatement = con.prepareStatement(" select * from category where category_ID = ? ");
			preparedStatement.setInt(1, category_ID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				category = new Category();
				category.setCategory_ID(resultSet.getInt("category_ID"));
				category.setName(resultSet.getString("name"));
				return category;
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			return category;
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
	
	public static boolean update(Category category, int category_ID) {
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(" update category set name = ? where category_ID = ? ");
			preparedStatement.setString(1, category.getName());
			preparedStatement.setInt(2, category_ID);
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			return false ;
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

	public static boolean create(Category category ) {
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement preparedStatement = new ConnectDB().getConnection()
					.prepareStatement(" insert into category( name )  values(?) ");
			preparedStatement.setString(1, category.getName());
			
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			return false;
		} 
	}

	public static boolean delete(int category_ID) {
		
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement("delete from category where category_ID = ?");
			preparedStatement.setInt(1, category_ID);
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
}
