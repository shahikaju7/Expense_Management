package com.expense.service;

import java.util.List;

import com.expense.model.User;

public interface IUserService {
boolean createuser(User user);
User serachuser(String Uname,String password);
}
