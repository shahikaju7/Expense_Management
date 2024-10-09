package com.expense.service;

import java.util.List;

import com.expense.model.Expense;

public interface IExpenseService {
	boolean addexpense(Expense expense);
	boolean deleteexpense(int id);
	List<Expense>searchexpense(String Uname);
}
