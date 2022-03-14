<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
<h1>Hello there</h1>

<h3 style="color: red;">${errmsg}</h3>

<form action="SignupServ" method="post">
  <div class="row mb-3">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
    <div class="col-sm-10">
      <input type="email" name="email" class="form-control" id="inputEmail3">
    </div>
  </div>
  
  <div class="row mb-3">
    <label for="inputPassword3" class="col-sm-2 col-form-label">Full name</label>
    <div class="col-sm-10">
      <input type="text" name="fname" class="form-control" id="inputPassword3">
    </div>
  </div>
  <a href="loclhost:3001/cofirmAccount/">Click Me</a>
  <div class="row mb-3">
    <label for="inputPassword3" class="col-sm-2 col-form-label">CIN</label>
    <div class="col-sm-10">
      <input type="text" name="cin" class="form-control" id="inputPassword3">
    </div>
  </div>
  
  <div class="row mb-3">
    <label for="inputPassword3" class="col-sm-2 col-form-label">CNE</label>
    <div class="col-sm-10">
      <input type="text" name="cne" class="form-control" id="inputPassword3">
    </div>
  </div>
  
  <div class="row mb-3">
    <label for="inputPassword3" class="col-sm-2 col-form-label">Filiere</label>
    <div class="col-sm-10">
      <input type="text" name="filier" class="form-control" id="inputPassword3">
    </div>
  </div>
  
  <div class="row mb-3">
    <label for="inputPassword3" class="col-sm-2 col-form-label">Date de naissance</label>
    <div class="col-sm-10">
      <input type="text" name="bDate" class="form-control" id="inputPassword3">
    </div>
  </div>
  
  <div class="row mb-3">
    <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
    <div class="col-sm-10">
      <input type="password" name="password" class="form-control" id="inputPassword3">
    </div>
  </div>
  <div class="row mb-3">
    <label for="inputPassword3" class="col-sm-2 col-form-label">ConfirmePassword</label>
    <div class="col-sm-10">
      <input type="password" name="Cpassword" class="form-control" id="inputPassword3">
    </div>
  </div>
  
  
  
  
  
  
  
  <button type="submit" class="btn btn-primary">Sign in</button>
</form>
</body>
</html>