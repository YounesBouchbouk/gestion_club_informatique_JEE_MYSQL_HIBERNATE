<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="net.connectionjee.User"%>
<%@page import="net.connectionjee.Cnt.UserManager"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">


<title>All Users List</title>
</head>
<body>

<form action="Userstable" method="post">

<div class="row mb-3">       
    <label for="inputEmail3" class="col-sm-2 col-form-label">Keyword</label>
    <div class="col-sm-10">
      <input type="text" name="serchkey" class="form-control" id="inputPassword3">
    </div>
  </div>

<button type="submit"   class="btn btn-primary">Searche</button>

</form>

<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Email</th>
      <th scope="col">CNE</th>
      <th scope="col">CIN</th>
      <th scope="col">Filier</th>
      <th scope="col">Date Inscription</th>
      <th scope="col">Status</th>
      <th scope="col">Action</th>
      
    </tr>
  </thead>
  <tbody>
  
  <% 
  
  if(request.getAttribute("model") != null){
	  
 	  List<User> usr = (List<User>)request.getAttribute("model");
	  
 	    for(User student : usr)
 	    {
// 	        out.print("<tr>");
// 	        out.print("<th scope=\"row\">" + student.getId() + "</th>");
// 	        out.print("<td>" + student.getId() + "</td>");
// 	        out.print("<td>" + student.getEmail() + "</td>");
// 	        out.print("<td>" + student.getCNE() + "</td>");
// 	        out.print("<td>" + student.getCIN()
// 	        		+ "</td>");
// 	        out.print("<td>" + student.getFiliere() + "</td>");
// 	        out.print("<td>" + student.getInscription() + "</td>");	

// 	        out.print("<tr>");
// 	    }
%>
	<tr>
      <th scope="row"><% out.print(student.getId());%></th>
      <td><% out.print(student.getEmail());%></td>
      
      <td><% out.print(student.getCNE());%></td>
      
      <td><% out.print(student.getCIN());%></td>
      <td><% out.print(student.getFiliere());%></td>
      <td><% out.print(student.getInscription());%></td>
      <td><% 
      switch(student.getState()){
      
    	  case 0 : out.print("Not Confimed"); break;
    	  case 1 : out.print("Confirmed"); 	break;
    	  case 2 : out.print("Disabled"); 	break;
    	  
      }
      
      %></td>
      
      
	  
	  <%
	  UserManager manager = new UserManager();
	  
	  if(student.getState() != 2){
		  %>
	  	<td><a href="DisableAcc.do?id=<% out.print(student.getId());%>" class="btn btn-danger">Disable</a></td>
		  <%  
	  }
	  
	  if(!manager.checkUserIfAdr(student.getId())){
		 %>
		  	  <td><a href="AddAdr.do?id=<% out.print(student.getId());%>" class="btn btn-success">Adherant</a></td>
		 <%  
	  }
	  
	  %>
	
    </tr>
<% }	}%>
   
    
  </tbody>
</table>

</body>
</html>