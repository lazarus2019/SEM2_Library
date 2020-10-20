package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.ConnectDB;
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


}
