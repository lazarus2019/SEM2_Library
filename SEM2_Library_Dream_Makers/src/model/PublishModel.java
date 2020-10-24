package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.ConnectDB;
import entities.Category;
import entities.Publish_house;

public class PublishModel {

	public List<Publish_house> findAll() {
		Connection con = ConnectDB.getConnection();
		List<Publish_house> publishes = new ArrayList<Publish_house>();
		try {
			PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM publish_house  ");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Publish_house publish = new Publish_house();
				publish.setPublish_ID(resultSet.getInt("publish_ID"));
				publish.setName(resultSet.getString("name"));
				publish.setAddress(resultSet.getString("address"));
				publish.setPhone(resultSet.getString("phone"));
				publishes.add(publish);

			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			publishes = null;
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return publishes;
	}

	public Publish_house find(int publish_ID) {
		Connection con = ConnectDB.getConnection();
		Publish_house publish = new Publish_house();
		try {
			PreparedStatement preparedStatement = con
					.prepareStatement("SELECT * FROM publish_house where publish_ID = ?  ");
			preparedStatement.setInt(1, publish_ID);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				publish.setPublish_ID(resultSet.getInt("publish_ID"));
				publish.setName(resultSet.getString("name"));
				publish.setAddress(resultSet.getString("address"));
				publish.setPhone(resultSet.getString("phone"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			publish = null;
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return publish;
	}

	public static boolean create(Publish_house publish_house ) {

		try {
			PreparedStatement preparedStatement = new ConnectDB().getConnection()
					.prepareStatement(" insert into publish_house( name , address , phone )  values(?, ? , ?) ");
			preparedStatement.setString(1, publish_house.getName());
			preparedStatement.setString(2, publish_house.getAddress());
			preparedStatement.setString(3, publish_house.getPhone());
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			return false;
		}
	}

	public static boolean update(Publish_house publish_house, int publish_ID) {
		// TODO Auto-generated method stub
		
		return false;
	}
	public static boolean delete(int publish_ID) {
		
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement("delete from publish_house where publish_ID = ?");
			preparedStatement.setInt(1, publish_ID);
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
}
