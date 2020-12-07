package com.hrudhay.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hrudhay.web.model.World;

public class WorldDao {
	
	public World getWorld(String ID) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/world", user = "root", password = "new1@Pass",
				query = "SELECT * FROM city WHERE ID="+ID;
		World wo = new World();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,user,password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if(rs.next()) {
				wo.setID(rs.getString("ID"));
				wo.setName(rs.getString("Name"));
				wo.setCountryCode(rs.getString("CountryCode"));
				wo.setDistrict(rs.getString("District"));
				wo.setPopulation(rs.getString("Population"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return wo;
	}
	
}
