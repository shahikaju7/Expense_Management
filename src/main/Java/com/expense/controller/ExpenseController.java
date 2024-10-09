package com.expense.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.expense.model.Expense;
import com.expense.model.User;
import com.expense.service.ExpenseServiceImpl;
import com.expense.service.IExpenseService;


/**
 * Servlet implementation class ExpenseController
 */
public class ExpenseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpenseController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		 IExpenseService service=new ExpenseServiceImpl();
		 HttpSession session=request.getSession();
		 String username=(String)session.getAttribute("uname");
		 //For Delete Expense
		 if(service.deleteexpense(id)) {
			 List<Expense> listofexpense= service.searchexpense(username);
			  if(service.searchexpense(username)!=null) {
			  session.setAttribute("listofexpense",listofexpense);
			  request.setAttribute("errorMessage", "Successsfully Deleted");
			  RequestDispatcher rd=request.getRequestDispatcher("expensemanagement.jsp");
				rd.forward(request, response);
		 }else {
			 request.setAttribute("errorMessage", "Something wrong");
				RequestDispatcher rd=request.getRequestDispatcher("expensemanagement.jsp");
				rd.forward(request, response);
		 }
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		 HttpSession session=request.getSession();
		 IExpenseService service=new ExpenseServiceImpl();
		String uname=(String) session.getAttribute("username");
		PrintWriter pw=response.getWriter();
		//For Add Expense
		 if("Add".equals(action)) {
		  String Expensedate=request.getParameter("date");
			String ExpenseType=request.getParameter("etype");
			String Ediscription=request.getParameter("ediscription");
			String Amount=request.getParameter("amount");
			Expense expense=new Expense();
			if(Expensedate.equals("")||ExpenseType.equals("")||Ediscription.equals("")||Amount.equals("")) {
				pw.print("Invalid Credentails");
				 request.setAttribute("errorMessage", "Please fill all the fields");
					RequestDispatcher rd=request.getRequestDispatcher("addexpense.jsp");
					rd.forward(request, response);
			}else {
			expense.setUname(uname);
			expense.setDate(Expensedate);
			expense.setExpensetype(ExpenseType);
			expense.setExdescription(Ediscription);
			expense.setAmount(Integer.parseInt(Amount));
			if(service.addexpense(expense)) {
				session.setAttribute("username", uname);
				List<Expense> listofexpense= service.searchexpense(uname);
				  if(service.searchexpense(uname)!=null) {
				  session.setAttribute("listofexpense",listofexpense);
				  request.setAttribute("errorMessage", "Expense is added successfully ");
					RequestDispatcher rd=request.getRequestDispatcher("expensemanagement.jsp");
					rd.forward(request, response);
			}
			else {
				pw.print("Invalid Credentails");
				 request.setAttribute("errorMessage", "Please fill all the fields");
					RequestDispatcher rd=request.getRequestDispatcher("addexpense.jsp");
					rd.forward(request, response);
			}
			}
			}
		 }else {List<Expense> listofexpense= service.searchexpense(uname);
	  if(service.searchexpense(uname)!=null) {
	  session.setAttribute("listofexpense",listofexpense);
	  response.sendRedirect("expensemanagement.jsp");
	  }else {
		  pw.print("error");
	  }
	}
 }
	}
