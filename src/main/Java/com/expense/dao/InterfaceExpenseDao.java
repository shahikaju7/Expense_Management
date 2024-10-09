package com.expense.dao;

import java.util.List;

import com.expense.model.Expense;

public interface InterfaceExpenseDao {
	boolean addexpense(Expense expense);
	List<Expense>searchexpense(String Uname);
	boolean deleteexpense(int id);
}
