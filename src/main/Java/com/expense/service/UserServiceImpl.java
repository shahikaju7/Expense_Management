package com.expense.service;

import java.util.List;
import com.expense.dao.*;
import com.expense.dao.InterfaceUserDao;
import com.expense.dao.UserDaoImpl;
import com.expense.model.User;

public class UserServiceImpl implements IUserService {
	@Override
	public boolean createuser(User user) {
		InterfaceUserDao dao=new UserDaoImpl();
		return dao.createuser(user);
		
	}

	@Override
	public User serachuser(String uname,String password) {
		InterfaceUserDao dao=new UserDaoImpl();
		return dao.serachuser(uname,password);
	}

}
