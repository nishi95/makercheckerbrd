<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>

  <title>Home</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
    align="center";
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
<body>
<%@ page import="com.nucleus.pojo.NewUser"%>
<%-- <% session=request.getSession(false);
RequestDispatcher rd=null;
if(session.getAttribute("username")==null)
{
	rd=request.getRequestDispatcher("Login.jsp");
	rd.include(request, response);
	
} %> --%>
<%@include file="header.jsp" %>
		<% NewUser pojo=(NewUser)request.getAttribute("value");%>
<form  id="loginForm" class="form-horizontal" action="MakerServlet" method="post">
<div class="container" align="center">
<div class="form-group row">
    <label for="staticEmail" class="col-sm-2 col-form-label">Customer Code</label>
    <div class="col-sm-6">
      <input type="text"  class="form-control-plaintext" name="customerCode" readonly value="<%=pojo.getCustomerCode() %>">
    </div>
  </div>
  <div class="form-group row">
    <label for="text" class="col-sm-2 col-form-label">Customer Name</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="name" name="customerName" onblur="valCustomerName()" value="<%=pojo.getCustomerName() %>">
     <p id="errorname"></p>
    </div>
  </div>
  <div class="form-group row">
    <label for="exampleTextarea" class="col-sm-2 col-form-label">Customer Address 1</label>
    <div class="col-sm-6">
    <input type="text" class="form-control" rows="1" id="address1" name="address1" onblur="valAddress()" value="<%=pojo.getCustomerAddress1() %>">
     <p id="valAddress1"></p>
    </div>
  </div>
  <div class="form-group row">
    <label for="exampleTextarea" class="col-sm-2 col-form-label" >Customer Address 2</label>
    <div class="col-sm-6">
    <input type="text" class="form-control" rows="1" name="address2" value="<%=pojo.getCustomerAddress2() %>">
    </div>
  </div>
    <div class="form-group row">
    <label for="exampleInputEmail1" class="col-sm-2 col-form-label">Pin Code</label>
    <div class="col-sm-6">
    <input type="text" class="form-control" id="pincode" onblur="valPinCode()" name="pincode" value="<%=pojo.getPincode() %>"/>
     <p id="errorpincode"></p>
    </div>
  </div>
   <div class="form-group row">
    <label for="exampleInputEmail1" class="col-sm-2 col-form-label">Email Address</label>
    <div class="col-sm-6">
    <input type="text" class="form-control" name="email" onblur="valEmail()" value="<%=pojo.getEmail()%>"/>
     <p id="erroremail"></p>
    </div>
  </div>
    <div class="form-group row">
    <label for="exampleInputEmail1" class="col-sm-2 col-form-label">Contact number</label>
    <div class="col-sm-6">
    <input type="text" class="form-control" id="contact" name="contact" onblur="valContactNum()" value="<%=pojo.getContact() %>"/>
     <p id="errorcontact"></p>
    </div>
  </div>
    <div class="form-group row">
    <label for="exampleInputEmail1" class="col-sm-2 col-form-label">Primary Contact Person</label>
    <div class="col-sm-6">
    <input type="text" class="form-control" id="primarycp" name="primaryContactPerson" onblur="valPrimaryContact()" value="<%=pojo.getPrimaryContactPerson() %>"/>
     <p id="errorpriconper"></p>
    </div>
  </div>
    
  <div class="form-group row" display="none">
    <label for="exampleSelect2" class="col-sm-2 col-form-label">Record Status</label>
    <div class="col-sm-6">
    <select class="form-control" id="recordstatus" name="status" >
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
    <select class="form-control" id="recordstatus" name="flag" >
      <option value="A">Active</option>
      <option value="I">Inactive</option>
    </select>
    </div>
  </div>
 
 <div class="col-sm-6" align="justify">
  <input type="submit" class="btn btn-primary col-sm-6 " name="update_data" value="Update"/>
</div>
 
  </div>
</form>

</body>
</html>