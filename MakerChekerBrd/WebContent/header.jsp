<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

<title>Insert title here</title>

</head>
<body>

    
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Maker</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="Maker.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
         <a class="nav-link" href="#myModal"  class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal"> Delete</a>
      <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body">
         <form action="MakerServlet" method="post">
  <div class="form-group row">
    <label class="col-sm-2 col-form-label">Customer Code</label>
    <div class="col-sm-6">
      <input type="text"  class="form-control-plaintext" name="customerCode" required>
    </div>
  </div>
 
  <button type="submit" class="btn btn-default" name="delete">Submit</button>
</form>
</div>
</div>
      
      </li>
       <li class="nav-item active">
        <!-- <a class="nav-link" href="entry.jsp">Update</a>
 -->      
 		     <a class="nav-link" href="#myModal1"  class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal1"> Update</a>
      <div class="modal fade" id="myModal1" role="dialog">
    <div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body">
         <form action="MakerServlet" method="post">
  <div class="form-group row">
    <label class="col-sm-2 col-form-label">Customer name</label>
    <div class="col-sm-6">
      <input type="text"  class="form-control-plaintext" name="Customername" required>
    </div>
  </div>
  <button type="submit" class="btn btn-default" name="update">Submit</button>
</form>
</div>
</div>
 </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          View
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
         <form action="MakerServlet" method="post">
         <input type="submit" name="view" value="viewAll"/>
         </form>
          <a class="dropdown-item" href="View.jsp">View single</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">TableView</a>
        </div>
      </li>
  
    </ul>
    <form class="form-inline my-2 my-lg-0" action="Index.jsp">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit" name="logout">Logout</button>
    </form>
  </div>
</nav>
<script type="text/javascript">
$(document).ready(function() {
    $(".dropdown-toggle").dropdown();
});</script>
</body>
</html>