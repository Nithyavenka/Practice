package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class EmpDao {
	public boolean register(int id, String name, int sal) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Properties props = new Properties();
				props.setProperty("user", "root");
				props.setProperty("password", "password");
				props.setProperty("serverTimezone", "America/New_York");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nithya", props);
				PreparedStatement ps = con.prepareStatement("insert into Employee values(?,?,?)");
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setInt(3, sal);
				ps.executeUpdate();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}


		public boolean update(int id, int sal) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Properties props = new Properties();
			props.setProperty("user", "root");
			props.setProperty("password", "password");
			props.setProperty("serverTimezone", "America/New_York");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nithya", props);
			PreparedStatement ps = con.prepareStatement("update Employee set EmpSalary=? where EmpID=?");
			ps.setInt(1, sal);
			ps.setInt(2, id);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Properties props = new Properties();
			props.setProperty("user", "root");
			props.setProperty("password", "password");
			props.setProperty("serverTimezone", "America/New_York");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nithya", props);
			PreparedStatement ps = con.prepareStatement("delete from Employee where EmpID=?");

			ps.setInt(2, id);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Employee select(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Properties props = new Properties();
			props.setProperty("user", "root");
			props.setProperty("password", "password");
			props.setProperty("serverTimezone", "America/New_York");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nithya", props);
			PreparedStatement ps = con.prepareStatement("select * from Employee where EmpID=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int i = rs.getInt("EmpID");
				String name = rs.getString("EmpName");
				int sal = rs.getInt("EmpSalary");
				Employee emp = new Employee(id, name, sal);
				return emp;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}

}
