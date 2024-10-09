<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.expense.controller.*,com.expense.model.*,com.expense.service.*,com.expense.dao.*" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Expense List</p>

 <table class="table">
  <thead>
    <tr>
      <th scope="col">Expense Id</th>
      <th scope="col">Expense Date</th>
      <th scope="col">Expense Type</th>
      <th scope="col">Expense Discription</th>
      <th scope="col">Amount</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <% 
  List<Expense>listofexpense=(List)session.getAttribute("listofexpense");
  for(Expense ex:listofexpense){
  %>
  <% %>
  <tbody>
    <tr>
      <th scope="row"><%=ex.getExpenseid() %></th>
      <%-- <td><%=ex.getExpenseid() %></td> --%>
      <td><%=ex.getDate() %></td>
      <td><%=ex.getExpensetype() %></td>
      <td><%=ex.getExdescription() %></td>
      <td><%=ex.getAmount() %></td>
      <td><a href="ExpenseController?id=<%=ex.getExpenseid()%><%session.setAttribute("uname",ex.getUname());%>">Delete</a></td>
    </tr>
    <% 
    }%>
  </tbody>
</table>
<button><a href="addexpense.jsp" class="add">Add Expense</a></button>
<button><a href="Logout" >Logout</a></button>
<%String errorMessage=(String)request.getAttribute("errorMessage");
if(errorMessage!=null){%>
<h3 style="color:red;"><%=errorMessage%></h3>
<%} %>
<!-- <input type="logout" value="logout"><br> -->
</form>
</body>
</html>