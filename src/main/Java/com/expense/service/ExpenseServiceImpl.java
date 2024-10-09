package com.expense.service;

import java.util.List;
import com.expense.dao.*;
import com.expense.dao.ExpensedaoImpl;
import com.expense.model.Expense;

public class ExpenseServiceImpl implements IExpenseService {

	@Override
	public boolean addexpense(Expense expense) {
		InterfaceExpenseDao dao=new ExpensedaoImpl();
		return dao.addexpense(expense);
	}

	@Override
	public boolean deleteexpense(int id) {
		InterfaceExpenseDao dao=new ExpensedaoImpl();
		return dao.deleteexpense(id);
	}

	@Override
	public List<Expense> searchexpense(String Uname) {
		InterfaceExpenseDao dao=new ExpensedaoImpl();
		return dao.searchexpense(Uname);
	}

}
