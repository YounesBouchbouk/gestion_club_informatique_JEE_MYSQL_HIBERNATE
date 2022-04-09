<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

 <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="dist/css/Profil_Style.css">
	<link rel="stylesheet"  href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">	
	<link rel="stylesheet"  href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js">
	<link rel="stylesheet"  href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
	
	
	
    <title>Changemenet de mot de passe</title>


</head>
<body>
<form action="PasswdServ " method="post">

<div class="container rounded bg-white mt-5 mb-5">
    <div class="row">
        <div class="col-md-3 border-right">
            <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" width="150px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span class="font-weight-bold">Salim</span><span class="text-black-50">Jamil@Jidan.com.my</span><span> </span></div>
        </div>
        <div class="col-md-5 border-right">
        <h5 style="color: red;">${errmsg}</h3>
		<h5 style="color :green">${Succmsg}</h4>
            <div class="p-3 py-5">
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <h4 class="text-right">Changer votre mot de passe !</h4>
                </div>
                
                <div class="row mt-3">
                    <div class="col-md-12"><label class="labels">	Ancien mot de passe  :</label><input name ="OldPasswd" type="text" class="form-control"   value=""></div>
                    <div class="col-md-12"><label class="labels">Nouveau mot de passe :</label><input name ="NewPasswd" type="text" class="form-control"   value=""></div>
                    <div class="col-md-12"><label class="labels">Confirmation du nouveau mot de passe :</label><input name ="CPasswd" type="text" class="form-control"   value=""></div>
                     
                         <div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="submit">Enregistrer</button></div>
                </div>
              
                <div class="mt-5 text-center"><a class="btn btn-primary profile-button" href="EventsCnt" type="submit">Retour à l'acceuil</a></div>
            </div>
        </div>
      
    </div>
</div>


</form>



</body>
</html>