
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="net.connectionjee.User"%>
<%@page import="net.connectionjee.Cnt.UserManager"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title> User Management Table</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
    body {
        color: #566787;
		background: #f5f5f5;
		font-family: 'Varela Round', sans-serif;
		font-size: 13px;
	}
    .table-responsive {
        margin: 30px 0;
    }
	.table-wrapper {
        min-width: 1000px;
        background: #fff;
        padding: 20px 25px;
		border-radius: 3px;
        box-shadow: 0 1px 1px rgba(0,0,0,.05);
    }
	.table-title {
		padding-bottom: 15px;
		background: #299be4;
		color: #fff;
		padding: 16px 30px;
		margin: -20px -25px 10px;
		border-radius: 3px 3px 0 0;
    }
    .table-title h2 {
		margin: 5px 0 0;
		font-size: 24px;
	}
	.table-title .btn {
		color: #566787;
		float: right;
		font-size: 13px;
		background: #fff;
		border: none;
		min-width: 50px;
		border-radius: 2px;
		border: none;
		outline: none !important;
		margin-left: 10px;
	}
	.table-title .btn:hover, .table-title .btn:focus {
        color: #566787;
		background: #f2f2f2;
	}
	.table-title .btn i {
		float: left;
		font-size: 21px;
		margin-right: 5px;
	}
	.table-title .btn span {
		float: left;
		margin-top: 2px;
	}
    table.table tr th, table.table tr td {
        border-color: #e9e9e9;
		padding: 12px 15px;
		vertical-align: middle;
    }
	table.table tr th:first-child {
		width: 60px;
	}
	table.table tr th:last-child {
		width: 100px;
	}
    table.table-striped tbody tr:nth-of-type(odd) {
    	background-color: #fcfcfc;
	}
	table.table-striped.table-hover tbody tr:hover {
		background: #f5f5f5;
	}
    table.table th i {
        font-size: 13px;
        margin: 0 5px;
        cursor: pointer;
    }	
    table.table td:last-child i {
		opacity: 0.9;
		font-size: 22px;
        margin: 0 5px;
    }
	table.table td a {
		font-weight: bold;
		color: #566787;
		display: inline-block;
		text-decoration: none;
	}
	table.table td a:hover {
		color: #2196F3;
	}
	table.table td a.settings {
        color: #2196F3;
    }
    table.table td a.delete {
        color: #F44336;
    }
    table.table td i {
        font-size: 19px;
    }
	table.table .avatar {
		border-radius: 50%;
		vertical-align: middle;
		margin-right: 10px;
	}
	.status {
		font-size: 30px;
		margin: 2px 2px 0 0;
		display: inline-block;
		vertical-align: middle;
		line-height: 10px;
	}
    .text-success {
        color: #10c469;
    }
    .text-info {
        color: #62c9e8;
    }
    .text-warning {
        color: #FFC107;
    }
    .text-danger {
        color: #ff5b5b;
    }
    .pagination {
        float: right;
        margin: 0 0 5px;
    }
    .pagination li a {
        border: none;
        font-size: 13px;
        min-width: 30px;
        min-height: 30px;
        color: #999;
        margin: 0 2px;
        line-height: 30px;
        border-radius: 2px !important;
        text-align: center;
        padding: 0 6px;
    }
    .pagination li a:hover {
        color: #666;
    }	
    .pagination li.active a, .pagination li.active a.page-link {
        background: #03A9F4;
    }
    .pagination li.active a:hover {        
        background: #0397d6;
    }
	.pagination li.disabled i {
        color: #ccc;
    }
    .pagination li i {
        font-size: 16px;
        padding-top: 6px
    }
    .hint-text {
        float: left;
        margin-top: 10px;
        font-size: 13px;
    }
</style>
<script>
$(document).ready(function(){
	$('[data-toggle="tooltip"]').tooltip();
});
</script>
</head>
<body>

<form action="Userstable" method="post">
<div style ="margin: 25xp" >
<div   class="row mb-3">       
    <label  style ="margin-right: 25xp" for="inputEmail3" class="col-sm-1 col-form-label">Keyword</label>
    <div class="col-sm-10">
      <input type="text" style ="width: 450px" name="serchkey" class="form-control" id="inputPassword3">
    </div>
  </div>
</div>


<button type="submit"   class="btn btn-primary">Search</button>

</form>

<div class="container">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-xs-5">
                        <h2>User <b>Management</b></h2>
                    </div>
                    <div class="col-xs-7">
                        <a href="#" class="btn btn-primary"><i class="material-icons">&#xE147;</i> <span>Add New User</span></a>
                        <a href="#" class="btn btn-primary"><i class="material-icons">&#xE24D;</i> <span>Export to Excel</span></a>						
                    </div>
                </div>
            </div>
            
            
            
            
            
            
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Email</th>
                        <th>CNE</th>
                        <th>CIN</th>						
                        <th>Filiére</th>
                        <th>Date of birth</th>
                        <th>Status</th>
                        <th>Action</th>
                        <th>Role</th>
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
 
	  	<td><a style ="color:white" type="button" href="/Disable?id=<% out.print(student.getId());%>" class="btn btn-danger">Disable</a></td>

		  <%  
	  }
	  
	  if(!manager.checkUserIfAdr(student.getId())){
		 %>
 
		  	  <td><a  style ="color:white" type="button" href="setToAdh.do?id=<% out.print(student.getId());%>" class="btn btn-success">Adherant</a></td>

		 <%  
	  }
	  
	  %>
	
    </tr>
<% }	}%>
                </tbody>
            </table>
            <div class="clearfix">
                <div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>
                <ul class="pagination">
                    <li class="page-item disabled"><a href="#">Previous</a></li>
                    <li class="page-item active"><a href="#" class="page-link">1</a></li>
                    <li class="page-item"><a href="#" class="page-link">2</a></li>
                    <li class="page-item"><a href="#" class="page-link">3</a></li>
                    <li class="page-item"><a href="#" class="page-link">4</a></li>
                    <li class="page-item"><a href="#" class="page-link">5</a></li>
                    <li class="page-item"><a href="#" class="page-link">Next</a></li>
                </ul>
            </div>
        </div>
    </div>        
</div>     
</body>
</html>
