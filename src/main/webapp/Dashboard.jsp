<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="net.connectionjee.Evenement"%>
<%@page import="net.connectionjee.Cnt.EventManager"%> 
<%@page import="net.connectionjee.Cnt.UserManager"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>

</head>
<style>

	.img {
		height: 150px
	}
	
	.cardh {
		width: 80%;
		margin : 10px auto;
		shadow : 2px 1px 1px  black;
	
	}
	
	.cl {padding : 3px 10px ;
		font-weight: bold;
		color: white;
		display: inline-block;
		text-decoration: none;
	}
	
	.divofalert{
		width :"100%";
		text-align: "center";
		display:  "flex";
		justify-content: "center";
		align-items:  :"center";
		background-color: "black"
	}
</style>
<body>

<%@ include file="parts/Header.jsp" %>





<%  
 List<Evenement> events = (List<Evenement>)request.getAttribute("result");
 String user_id = (String)request.getAttribute("session");
 int id = Integer.parseInt(user_id);
 EventManager env = new EventManager();
 UserManager usermanage = new UserManager();
 %>
 
 <div class="divofalert">
 
 <blockquote class="blockquote text-center">
  <p class="mb-0 display-4">Vous avez <%=(usermanage.nombreAbcence(id))
						      %>  d'absences</p>
			<p class="mb-0 display-4">il vous rest  <%=(5 - usermanage.nombreAbcence(id))
						      %>  absences</p>			      
  <footer class="blockquote-footer ">
  <div class="alert alert-danger" role="alert">
si vous avez complété le nombre d'absence vous serez automatiquement eliminé</div>
</cite></footer>
</blockquote>
 
<%--  <h1 style="text-align: 'center'">Vous avez <%=(usermanage.nombreAbcence(id)) --%>
<%-- 						      %> nombre d'absence</h1> --%>
						      
<%-- 						      <h1>il vous rest  <%=(5 - usermanage.nombreAbcence(id)) --%>
<%-- 						      %> nombre d'absence</h1> --%>
						      
<!-- <p class="lead"> -->
<!-- une vous avez comlété le nombre d'absence vous serez automatiqment eliminé</p> -->
<!--   </div> -->
 
 <% 
  for(Evenement event : events)
  {
%>

<div class="card cardh">
  <div class="card-body">
    <h5 class="card-title"><% out.print(event.getTitle());%></h5>
    <p >Titre : <% out.print(event.getDescription());%></p>
    
    <div class="d-flex justify-content-around ">
    <p >Date Debut : <% out.print(event.getDate_d());%></p>
    <p >Heure :<% out.print(event.getTimm_db());%></p>
    <%
    if(env.comparedatewhiteLocal(event.getDate_d())){
    	
    %>
    <p  class="btn-danger cl ">New</>
    
    <%
    }
    
    %>
    </div>
  </div>
</div>


<% } %>






</body>
</html>