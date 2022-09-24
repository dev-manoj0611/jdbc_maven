package com.ty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ty.dto.User;

public class UserDAO {
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/jdbcprc";
	String username = "root";
	String password = "root";
	Connection con = null;
	public User saveDetails(User u)
	{
		String query="insert into user values(?,?,?,?,?,?,?)";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url,username,password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getLastName());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			ps.setLong(5, u.getPhone());
			ps.setString(6, u.getDateOfBirth());
			ps.setString(7, u.getGender());
			int rows = ps.executeUpdate();
			if(rows==1)
			{
				return u;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public User updateDetails(User u)
	{
		String query = "UPDATE user SET firstname = ?,lastname = ?,password = ?,phone = ?,dob = ?,gender = ? where email=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url,username,password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getLastName());
			ps.setString(3, u.getPassword());
			ps.setLong(4, u.getPhone());
			ps.setString(5, u.getDateOfBirth());
			ps.setString(6, u.getGender());
			ps.setString(7, u.getEmail());
			int rows = ps.executeUpdate();
			if(rows==1)
			{
				return u;
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public String deleteDetails(String email)
	{
		String query = "delete from user where email=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url,username,password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email);
			int rows = ps.executeUpdate();
			if(rows == 1)
			{
				return "user details deleted";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "not deleted";
	}
	public User getDetails(String email)
	{
		String query="select* from user where email=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url,username,password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs!=null)
			{
				User u = new User();
				while(rs.next())
				{
					u.setFirstName(rs.getString(1));
					u.setLastName(rs.getString(2));
					u.setPassword(rs.getString(3));
					u.setPhone(rs.getLong(5));
					u.setDateOfBirth(rs.getString(6));
					u.setGender(rs.getString(7));
					return u;
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public List<User> getAllUser()
	{
		String query = "select* from user";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url,username,password);
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			List<User> list = new ArrayList();
			while(rs.next())
			{
				User u = new User();
				u.setFirstName(rs.getString(1));
				u.setLastName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(4));
				u.setPhone(rs.getLong(5));
				u.setDateOfBirth(rs.getString(6));
				u.setGender(rs.getString(7));
				list.add(u);
			}
			return list;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public User getUserByEmailAndPassword(String email, String password)
	{
		String query = "select* from user where email=? and password=?";
		try {
			Class.forName(query);
			con = DriverManager.getConnection(url,username,this.password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				User u = new User();
				u.setFirstName(rs.getString(1));
				u.setLastName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(4));
				u.setPhone(rs.getLong(5));
				u.setDateOfBirth(rs.getString(6));
				u.setGender(rs.getString("gender"));
				return u;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}