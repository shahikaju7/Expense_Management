package com.expense.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.expense.model.Expense;

public class ExpensedaoImpl implements InterfaceExpenseDao {

	@Override
	public boolean addexpense(Expense expense) {
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Expense","root","root");
			if(conn!=null) {
				String insertQuery="Insert into expense values(?,?,?,?,?,?)";
				PreparedStatement psmt=conn.prepareStatement(insertQuery);
				psmt.setInt(1,expense.getExpenseid());
				psmt.setString(2,expense.getUname());
				psmt.setString(3,expense.getDate());
				psmt.setString(4,expense.getExpensetype());
				psmt.setString(5,expense.getExdescription());
				psmt.setFloat(6,expense.getAmount());
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
	public List<Expense> searchexpense(String Uname) {
		List<Expense> expenselist=new ArrayList<>();
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Expense","root","root");
			if(conn!=null) {
				String searchQuery="select * from expense where username=?";
				//String searchQuery="select * from expense";
				PreparedStatement psmt=conn.prepareStatement(searchQuery);
				psmt.setString(1,Uname);
				ResultSet rs=psmt.executeQuery();
				while(rs.next()) {
					Expense expense=new Expense();
					expense.setExpenseid(rs.getInt(1));
					expense.setUname(rs.getString(2));
					expense.setDate(rs.getString(3));
					expense.setExpensetype(rs.getString(4));
					expense.setExdescription(rs.getString(5));
					expense.setAmount(rs.getInt(6));
				    expenselist.add(expense);
					
				}
				//user.setUname(rs.getNString("uname"));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return expenselist;
	}

	@Override
	public boolean deleteexpense(int id) {
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Expense","root","root");
			if(conn!=null) {
				String insertQuery="delete from expense where expenseid=?";
				PreparedStatement psmt=conn.prepareStatement(insertQuery);
				psmt.setInt(1,id);
				int k=psmt.executeUpdate();
				if(k>0) {
					return true;
				}
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}
