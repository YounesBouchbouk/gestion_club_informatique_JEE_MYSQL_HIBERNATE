<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>S'inscrire</title>
	<link rel="stylesheet" type="text/css" href="dist/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="dist/css/style.css">
	<link rel="stylesheet"  href="font-awesome/css/font-awesome.min.css">
</head>
<body>

	<!-- Entête -->
      <div class="nav-head  sticky-top">
        <div class="row">
            <div class="col-12 col-lg-6">
                <div class="logo">
                      <img src="assets/images/logo.png" alt="" srcset="" height="100px" width="200px" >
                </div>
            </div>
            <div class="col-12 col-lg-6">
                <p class="head-gram">
                </p>
            </div>
        </div>
      </div>
	<!-- Entête -->
    
	

	  	<!-- Formulaires_1 -->
	  	<div class="row style_2 d-flex justify-content-center">
	  		<div class="col-12 col-lg-4 news_4 justify-content-center">
	  			<form action="SignupServ" method="POST">
					  <div class="box">
						  <img src="assets/images/logo.png" alt="" srcset="" width="350px">
						  <img src="assets/images/fpt.png" alt="" srcset="" width="350px" class="pic">
						</div>
					
					<hr class="underline ml-0">
	  				<h4>S'inscrire</h4>
	  				<hr class="underline ml-0">
	  				<p>Veuillez remplir touts les champs </p>
	  				<div class="alert alert-danger" role="alert">
 						${errmsg}
					</div>
	  				<div class="form-row">
	  				
	  					<div class="col">
	  						<label for="name">Nom</label>
						    <input type="text" name = "lname" class="form-control">
	  					</div>
	  					<div class="col">
	  						<label for="name">Prenom</label>
						    <input type="text" name = "fname" class="form-control">
	  					</div>
	  				</div>
                      <div class="form-row">
                        <div class="col">
                            <label for="charset">CIN</label>
                          <input type="text" name = "cin" class="form-control">
                        </div>
                        <div class="col">
                            <label for="charset">CNE</label>
                          <input type="text" name = "cne"  class="form-control">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col">
                            <label for="name">filiere</label>
                          <input type="text" name="filier" class="form-control">
                        </div>
                        <div class="col">
                            <label for="name">email</label>
                          <input type="text" name = "email" class="form-control">
                        </div>
                    </div>
                    <div class="form-row">
							<div class="col">
								<label for="charset">Date Naissance</label>
							  <input type="date" name="bDate" class="form-control">
							</div>
	  				</div>
	  				<div class="form-row">
							<div class="col">
								<label for="charset">Mot de passe</label>
							  <input type="password" name="password" class="form-control">
							</div>
	  				</div>
	  				
	  				<div class="form-row">
							<div class="col">
								<label for="charset">Confirm</label>
							  <input type="password" name="Cpassword" class="form-control">
								<button type="submit" class="btn justify-content-center">S'inscrire</button>
							</div>
	  				</div>
	  				
	  				
	  			</form>
	  		</div>
		</div>	  
</body>

</html>