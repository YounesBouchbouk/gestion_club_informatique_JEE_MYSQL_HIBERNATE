<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<style>
	 body {
        color: #566787;
		background: #f5f5f5;
		font-family: 'Varela Round', sans-serif;
		font-size: 13px;
	}
	.container {
		width: 60%;
		margin: 30px auto;
		padding: 20px;
	}
</style>

<body>

	<div class="container">
	<form method="post" action="Event"  enctype="multipart/form-data">
  <div class="form-group">
    <label for="exampleInputEmail1">Le titre de l'evenement : </label>
    <input type="text" name="title" class="form-control" id="exampleInputEmail1" placeholder="Titre .....">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Date</label>
    <input type="date"	name="date" class="form-control" id="exampleInputPassword1" >
  </div>
  
  <div class="form-group">
    <label for="exampleInputPassword1">Heure :</label>
    <input type="time"	name="time" class="form-control" id="exampleInputPassword1" >
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Description :</label>
    <textarea class="form-control" name="description" rows="3"></textarea>
  </div>
  
  <div class="form-group"> -->
    <label for="exampleInputFile">File input</label>
     <input type="file" name="file" id="file" id="exampleInputFile"> 
    <p class="help-block">couverture</p>
  </div> 
  <div class="checkbox">
    <label>
      <input type="checkbox" name="sendem"> notifier tous les aderants ?
    </label>
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
</form>
	</div>

</body>
</html>