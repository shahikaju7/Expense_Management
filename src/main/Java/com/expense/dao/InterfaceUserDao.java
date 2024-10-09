package com.expense.dao;

import java.util.List;

import com.expense.model.Expense;
import com.expense.model.User;

public interface InterfaceUserDao {
boolean createuser (User user);
User serachuser(String Uname,String Password);
}
