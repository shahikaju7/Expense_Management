<html>x
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<style>
.divider:after,
.divider:before {
content: "";
flex: 1;
height: 1px;
background: #eee;
}
.h-custom {
height: calc(100% - 73px);
}
@media (max-width: 450px) {
.h-custom {
height: 100%;
}
}
</style>
</head>
<body>
<%String errorMessage=(String)request.getAttribute("errorMessage");
if(errorMessage!=null){%>
<h3 style="color:red;"><%=errorMessage%></h3>
<%} %>
<form action="User" method="post">
 <input type="hidden" name="action" value="Login"/>
<section class="vh-100">
  <div class="container py-5 h-100">
    <div class="row d-flex align-items-center justify-content-center h-100">
      <div class="col-md-8 col-lg-7 col-xl-6">
        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.svg"
          class="img-fluid" alt="Phone image">
      </div>
      <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
       <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Login Page</p>
        <form>
          <!-- Email input -->
          <div data-mdb-input-init class="form-outline mb-4">
            Username:<input type="text" name="uname" id="form1Example13" class="form-control form-control-lg" />
  
          </div>

          <!-- Password input -->
          <div data-mdb-input-init class="form-outline mb-4">
           Password:<input type="password" name="pass" id="form1Example23" class="form-control form-control-lg" />
            
          </div>

          <!-- Submit button -->
          <button type="submit" data-mdb-button-init data-mdb-ripple-init class="btn btn-primary btn-lg btn-block">Submit</button>

          
         <!-- <button style="color:"reddata-mdb-button-init data-mdb-ripple-init class="btn btn-primary btn-lg btn-block"> <a href="register.jsp" class="add">New User</a></button> -->
         
         <a data-mdb-ripple-init class="btn btn-primary btn-lg btn-block" style="background-color: #55acee" href="register.jsp"
            role="button">
            <i class="fab fa-twitter me-2"></i>New Register</a>

        </form>
      </div>
    </div>
  </div>
 
</section>
</body>
</html>
