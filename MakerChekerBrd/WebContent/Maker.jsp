<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
  
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
<script src="script.js"></script>
<title>Insert title here</title>
<style>
input[type=text], select {
    width: 100%;
  
    margin: 2px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
 
}

input[type=submit] {
    width: 100%;
    background-color: #4CAF50;
    color: white;
  
   margin: 2px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
}

div {
   
    background-color: #f2f2f2; 
}
from{
 border: 1px solid black;

    padding-right: 200px;
    padding-bottom: 200px;
    padding-left: 200px;

}

</style>

</head>
<body  style="background-color:white;">  
<% session=request.getSession(false);
System.out.println(session); 
RequestDispatcher rd=null;
if(session.getAttribute("username")==null)
	{
	rd=request.getRequestDispatcher("Index.jsp");
	rd.include(request, response);
	}
	else
	{
	
	%>
  <%@include file="header.jsp" %>
<br>
<br>
<br>
<form  id="loginForm" class="form-horizontal" action="MakerServlet" method="post">
<div class="container" align="center">
<div class="form-group row">
    <label for="staticEmail" class="col-sm-2 col-form-label">Customer Code</label>
    <div class="col-sm-6">
      <input type="text"  class="form-control-plaintext" name="customerCode" onblur="valCustomerCode()">
      <p id="errorcustcode"></p>
    </div>
  </div>
  <div class="form-group row">
    <label for="text" class="col-sm-2 col-form-label">Customer Name</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="name" name="customerName" onblur="valCustomerName()">
      <p id="errorname"></p>
    </div>
  </div>
  <div class="form-group row">
    <label for="exampleTextarea" class="col-sm-2 col-form-label">Customer Address 1</label>
    <div class="col-sm-6">
    <textarea class="form-control" id="address1" rows="1" name="address1" onblur="valAddress()"></textarea>
    <p id="valAddress1"></p>
    </div>
  </div>
  <div class="form-group row">
    <label for="exampleTextarea" class="col-sm-2 col-form-label" >Customer Address 2</label>
    <div class="col-sm-6">
    <textarea class="form-control" rows="1" name="address2"></textarea>
    </div>
  </div>
    <div class="form-group row">
    <label for="exampleInputEmail1" class="col-sm-2 col-form-label">Pin Code</label>
    <div class="col-sm-6">
    <input type="text" class="form-control" id="pincode" name="pincode" onblur="valPinCode()"/>
    <p id="errorpincode"></p>
    </div>
  </div>
   <div class="form-group row">
    <label for="exampleInputEmail1" class="col-sm-2 col-form-label">Email Address</label>
    <div class="col-sm-6">
    <input type="text" class="form-control" name="email" onblur="valEmail()"/>
    <p id="erroremail"></p>
    </div>
  </div>
    <div class="form-group row">
    <label for="exampleInputEmail1" class="col-sm-2 col-form-label">Contact number</label>
    <div class="col-sm-6">
    <input type="text" class="form-control" id="contact" name="contact" onblur="valContactNum()"/>
    <p id="errorcontact"></p>
    </div>
  </div>
    <div class="form-group row">
    <label for="exampleInputEmail1" class="col-sm-2 col-form-label">Primary Contact Person</label>
    <div class="col-sm-6">
    <input type="text" class="form-control" id="primarycp" name="primaryContactPerson" onblur="valPrimaryContact()"/>
    <p id="errorpriconper"></p>
    </div>
  </div>
  
  <div class="form-group row">
    <label for="exampleSelect2" class="col-sm-2 col-form-label">Record Status</label>
    <div class="col-sm-6">
    <select class="form-control" id="recordstatus" name="status">
      <option value="N">N: New</option>
      <option value="M">M: Modified </option>
      <option value="D">D: Delete</option>
      <option value="A">A: Authorized</option>
      <option value="R">R: Rejected</option>
    </select>
    </div>
  </div>
<div class="form-group row">
    <label for="exampleSelect2" class="col-sm-2 col-form-label">Active/Inactive</label>
    <div class="col-sm-6">
    <select class="form-control" id="recordstatus" name="flag">
      <option value="A">Active</option>
      <option value="I">Inactive</option>
    </select>
    </div>
  </div>
<div align="center">
  <button type="submit" class="btn btn-primary col-sm-6 " id="btnsub" name="save" value="save" onclick="validateForm()">Save</button>
</div>
 
  </div>
</form>
${flag}
 <%--  <% String message = (String)request.getAttribute("alertMsg");%> --%>
<%-- <script type="text/javascript">
    var msg = "<%=message%>";
    alert(msg);
    window.location("update.jsp")
</script> --%>

</body>
</html>
<%}%>