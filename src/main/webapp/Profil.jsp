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

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="dist/css/Profil_Style.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">



<title>Profil</title>
 <script src="path/to/jquery.js" type="text/javascript"></script>
    <script>
    function redirect(elem){
        elem.setAttribute("action","EditPasswd.jsp");
        elem.submit();
   }
    </script>

</head>
<body>
 
<%@ include file="parts/Header.jsp" %>


	
	
	
				<form action="ProfilServ"  onsubmit="redirect(this);">   
				
				  		<div class="container rounded bg-white mt-5 mb-5">
		<%
						if (request.getAttribute("MyData") != null) {

							User TheUser = (User) request.getAttribute("MyData");
							

							
						%> 
			<div class="row">
				<div class="col-md-3 border-right">
					<div
						class="d-flex flex-column align-items-center text-center p-3 py-5">
						<img class="rounded-circle mt-5" width="150px"
							src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span
							class="font-weight-bold"><%=(TheUser.getFname())
						      %></span><span
							class="text-black-50"><%=(TheUser.getEmail())
						      %></span><span> </span>
					</div>
				</div>
				<div class="col-md-5 border-right">
					<div class="p-3 py-5">
						<div
							class="d-flex justify-content-between align-items-center mb-3">
							<h4 class="text-right">Informations personnelles</h4>
							 
							
						
					 
					
							
						</div>
						<div class="row mt-2">
							<div class="col-md-6">
								<label class="labels">Prénom :</label><input type="text"  
									class="form-control" name ="CNE"  value=" <%=(TheUser.getFname())
						      %>"  disabled>
							</div>
							<div class="col-md-6">
								<label class="labels">Nom :</label><input type="text"
									class="form-control" value=" <%=(TheUser.getLname())
						      %>" disabled>
							</div>
						</div>
						<div class="row mt-3">
							<div class="col-md-12">
								<label class="labels">Email :</label><input type="text"
									class="form-control" value="<%=(TheUser.getEmail())
						      %>" disabled>
							</div>
							<div class="col-md-12">
								<label class="labels">CNI :</label><input type="text"
									class="form-control" value="<%=(TheUser.getCIN())
						      %>" disabled>
							</div>
							<div class="col-md-12">
								<label class="labels">CNE :</label><input type="text"
									class="form-control" 
									value="<%=(TheUser.getCNE())
						      %>" disabled>
							</div>
							<div class="col-md-12">
								<label class="labels">Date de naissance :</label><input
									type="text" class="form-control"
									  value="<%=(TheUser.getInscription())
						      %>" disabled>
							</div>
							<div class="col-md-12">
								<label class="labels">Filière :</label><input type="text"
									class="form-control"  
									value=" <%=(TheUser.getFiliere())
						      %>" disabled>
							</div>
								<%  }%>
							
							<div class="mt-5 text-center">
								<button class="btn btn-primary profile-button" type="submit" href ="EditPasswd.jsp">Modifier
									le mot de passe</button>
							</div>
						</div>

						<div class="mt-5 text-center">
							<a class="btn btn-primary profile-button" href="EventsCnt" type="button">Retour
								à l'acceuil</a>
						</div>
					</div>
				</div>
			</div>
		
		</div>
				  
				
				</form>		


	
</body>
</html>