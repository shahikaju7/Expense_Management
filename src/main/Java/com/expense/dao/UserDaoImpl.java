package com.expense.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.expense.model.Expense;
import com.expense.model.User;

public class UserDaoImpl implements InterfaceUserDao {

	@Override
	public boolean createuser(User user) {
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Expense","root","root");
			if(conn!=null) {
				String insertQuery=" Insert into user values(?,?,?);";
				PreparedStatement psmt=conn.prepareStatement(insertQuery);
				psmt.setString(1,user.getUname());
				psmt.setString(2,user.getPass());
				psmt.setString(3,user.getName());
				int k=psmt.executeUpdate();
				if(k>0) {
					return true;
				}
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User serachuser(String uname,String password) {
		User user=null;
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Expense","root","root");
			if(conn!=null) {
				String searchQuery="select *from user where username=? and password=?;";
				PreparedStatement psmt=conn.prepareStatement(searchQuery);
				psmt.setString(1,uname);
				psmt.setString(2,password);
				ResultSet rs=psmt.executeQuery();
				if(rs.next()) {
					user=new User();
					
				}
				
				//user.setUname(rs.getNString("uname"));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
   


}
