<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<%String errorMessage=(String)request.getAttribute("errorMessage");
if(errorMessage!=null){%>
<h3 style="color:red;"><%=errorMessage%></h3>
<%} %>
<form action="ExpenseController" method="post">
<input type="hidden" name="action" value="Add"/>
<section class="h-100 h-custom" style="background-color: #8fc4b7;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-lg-8 col-xl-6">
        <div class="card rounded-3">
          <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img3.webp"
            class="w-100" style="border-top-left-radius: .3rem; border-top-right-radius: .3rem;"
            alt="Sample photo">
          <div class="card-body p-4 p-md-5">
            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">Add Expense</h3>

            <form class="px-md-2">

              <div data-mdb-input-init class="form-outline mb-4">
                Expense Date:<input type="date"  name="date" id="form3Example1q" class="form-control" />
              </div>

                <div data-mdb-input-init class="form-outline mb-4">
                  <label for="etype">Expense Type: </label>
                  <select id="etype" name="etype" data-mdb-select-init>
                    <option value="Food">Food</option>
                    <option value="Medicine">Medicine</option>
                    <option value="Travel">Travel</option>
                                      </select>

                </div>
              
               <div data-mdb-input-init class="form-outline mb-4">
                Expense Discription:<input type="text"  name="ediscription" id="form3Example1q" class="form-control" />
              </div>
             

              <div data-mdb-input-init class="form-outline mb-4">
                Expense Amount:<input type="text"  name="amount" id="form3Example1q" class="form-control" />
              </div>

                </div>
              </div>

              <button type="submit" data-mdb-button-init data-mdb-ripple-init class="btn btn-success btn-lg mb-1">Submit</button>
                <button type="clear" data-mdb-button-init data-mdb-ripple-init class="btn btn-success btn-lg mb-1">Clear</button>
            </form>

          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</form>
</body>
</html>