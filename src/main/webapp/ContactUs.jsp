<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700,900&display=swap" rel="stylesheet">

  <link rel="stylesheet" type="text/css" href="dist/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="dist/css/style.css">
	<link rel="stylesheet"  href="font-awesome/css/font-awesome.min.css">

    <title>Contact | Club Informatique</title>
  </head>
  <body>
  <%@ include file="parts/Header.jsp" %>
  
    <!-- Ent�te -->
    <div class="nav-head  sticky-top">
      <div class="row">
          <div class="col-12 col-lg-6">
              <div class="logo">
                    <img src="assets/images/logo.png" alt="" height="100px" width="200px" >
              </div>
          </div>
          <div class="col-12 col-lg-6">
              <p class="head-gram">
              </p>
          </div>
      </div>
    </div>
  <div class="content" >
    
    <div class="container">
      <div class="row align-items-stretch no-gutters contact-wrap">
        <div class="box">
          <img src="assets/images/logo.png" alt=""  width="350px">
          <img src="assets/images/fpt.png" alt=""   class="pic">
        </div>
        <div class="col-md-12">
          <div class="form h-100">
            <h3>Get Started</h3>
            <div class="alert alert-success" role="alert">
  					${succ} 
					</div>
            <form class="mb-5" method="post" action="Contact" name="contactForm">
              <div class="row">
              
                <div class="col-md-6 form-group mb-3">
                  <label for="" class="col-form-label">Email *</label>
                  <input type="text" class="form-control" name="email" id="email"  placeholder="Your email">
                </div>
              </div>

              <div class="row">
                <div class="col-md-12 form-group mb-3">
                  <label for="budget" class="col-form-label">Objet</label>
                  <input type="text" class="form-control" name="subject" id="objet"  placeholder="Objet contact">
                </div>
              </div>

              <div class="row">
                <div class="col-md-12 form-group mb-3">
                  <label for="message" class="col-form-label">Message *</label>
                  <textarea class="form-control" name="content" id="message" cols="30" rows="4"  placeholder="Write your message"></textarea>
                </div>
              </div>
              <div class="row">
                <div class="col-md-12 form-group">
                  <input type="submit" value="Send Message" class="btn btn-primary rounded-0 py-2 px-4">
                  <span class="submitting"></span>
                </div>
              </div>
            </form>

           
        </div>
      </div>
    </div>

  </div>
    
    

    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.validate.min.js"></script>
    <script src="js/main.js"></script>

  </body>
</html>