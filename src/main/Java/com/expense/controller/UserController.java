package com.expense.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.expense.model.User;
import com.expense.service.IUserService;
import com.expense.service.UserServiceImpl;

/**
 * Servlet implementation class UserController
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		IUserService service=new UserServiceImpl();
		User user=new User();
		String username=request.getParameter("uname");
		String password=request.getParameter("pass");
		//For Registration User
		if("Register".equals(action)) {
			String name=request.getParameter("name");
			if(name.equals("")||username.equals("")||password.equals("")) {
				request.setAttribute("errorMessage", "Please fill all the fields");
				RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
				rd.forward(request, response);
			}else {
			user.setName(name);
			user.setUname(username);
			user.setPass(password);
			try{if(service.createuser(user)) {
				request.setAttribute("errorMessage", "Thank you for register now you login");
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
			}
			//For Login User
		}else if("Login".equals(action)) {
			user.setUname(username);
			user.setPass(password);
			if(service.serachuser(username,password)!=null) {
				HttpSession session=request.getSession();
				session.setAttribute("username", username);
				RequestDispatcher rd=request.getRequestDispatcher("ExpenseController");
				rd.forward(request, response);
				
			}else {
				request.setAttribute("errorMessage", "Invalid Credentials");
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		}
		
	}

}
