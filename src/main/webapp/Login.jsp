<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="dist/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="dist/css/style_login.css">
	<link rel="stylesheet"  href="font-awesome/css/font-awesome.min.css">
    <title>Login</title>
</head>
<body> 
<%-- <h3 style="color: red;">${errmsg}</h3> --%>
<%-- <h4 style="color :green">${Succmsg}</h4> --%>
<form action="LoginCnt" method="POST">
    <div class="nav-head  sticky-top">
        <div class="row">
            <div class="col-12 col-lg-6">
                <div class="logo">
                      <img src="assets/images/logo.png" alt="as" height="100px" width="200px" >
                </div>
            </div>
            <div class="col-12 col-lg-6">
                <p class="head-gram">
                </p>
            </div>
        </div>
      </div>
    <div class="container mt-5 mb-5 d-flex justify-content-center">
        <div class="card px-1 py-4">
            <div class="card-body">
                <div class="box">
                    <img src="assets/images/logo.png" alt="" srcset="" width="350px">
                    <img src="assets/images/fpt.png" alt="" srcset="" width="350px" class="pic">
                  </div>
                <h6 class="card-title mb-3">Vous etes :</h6>
                <div class="d-flex flex-row"> <label class="radio mr-1"> <input type="radio" name="typeuser" value="anz" checked> <span> <i class="fa fa-user"></i> Membre de bureau </span> </label> <label class="radio"> <input type="radio" name="typeuser" value="adherent"> <span> <i class="fa fa-plus-circle"></i> Adherent </span> </label> </div>
                <h6 class="information mt-4">Veuillez saisir votre <u>CNE</u> et <u>mot de passe</u> : </h6>
                   
                    
                	<div class="alert alert-danger" role="alert">
  					${errmsg} 
					</div>
                	<div class="alert alert-success" role="alert">
  					${Succmsg} 
					</div>
                
                
                <div class="row">
                    <div class="col-sm-12">
                        <div class="form-group">
                             <input  name ="CNE" class="form-control" type="text" placeholder="CNE"> </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <div class="form-group">
                            <div class="input-group"> <input class="form-control" name ="password" type="password" placeholder="Mot de passe"> </div>
                        </div>
                    </div>
                </div>
                <small>Club Informatique privacy</small>
                 <button type="submit" class="btn btn-primary btn-block confirm-button">Se Connecter </button>
            </div>
        </div>
    </div>
    </form>
    </body>
</html>