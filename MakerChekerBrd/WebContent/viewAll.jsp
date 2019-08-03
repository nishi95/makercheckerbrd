<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


</head>
<body>

	<%@include file="header.jsp"%>
	<form action="MakerServlet" method="post">
		<table id="Maker" cellspacing="0" border="1" class="display"
			style="font-size: .80em" width:"60%" type="checkbox">
			<thead>
				<tr>
					<th></th>
					<th>Customer Id</th>
					<th>Customer Code</th>
					<th>Customer Name</th>
					<th>Customer Address 1</th>
					<th>Customer Address 2</th>
					<th>Customer Pin code</th>
					<th>Customer Email</th>
					<th>Customer Contact</th>
					<th>Customer Contact Person</th>
					<th>Record Status</th>
					<th>Customer Flag</th>
					<th>Created Date</th>
					<th>Created By</th>
					<th>Modified Date</th>
					<th>Modified By</th>
					<th>Authorized Date</th>
					<th>Authorized By</th>
				</tr>
			</thead>
			<tfoot>
				<tr>


					<th></th>
					<th>Customer Id</th>
					<th>Customer Code</th>
					<th>Customer Name</th>
					<th>Customer Address 1</th>
					<th>Customer Address 2</th>
					<th>Customer Pin code</th>
					<th>Customer Email</th>
					<th>Customer Contact</th>
					<th>Customer Contact Person</th>
					<th>Record Status</th>
					<th>Customer Flag</th>
					<th>Created Date</th>
					<th>Created By</th>
					<th>Modified Date</th>
					<th>Modified By</th>
					<th>Authorized Date</th>
					<th>Authorized By</th>
				</tr>
			</tfoot>
			<tbody>

				<c:forEach items="${Users}" var="user">

					<tr>
						<td><input type="checkbox" name="check"
							value="${user.getCustomerCode()}"></td>

						<td>${user.getCustomerId()}</td>
						<td>${user.getCustomerCode()}</td>
						<td>${user.getCustomerName()}</td>
						<td>${user.getCustomerAddress1()}</td>
						<td>${user.getCustomerAddress2()}</td>
						<td>${user.getPincode()}</td>
						<td>${user.getEmail()}</td>
						<td>${user.getContact()}</td>
						<td>${user.getPrimaryContactPerson()}</td>
						<td>${user.getStatus()}</td>
						<td>${user.getFlag()}</td>
						<td>${user.getCreatedDate()}</td>
						<td>${user.getCreatedBy()}</td>
						<td>${user.getModifiedDate()}</td>
						<td>${user.getModifiedBy()}</td>
						<td>${user.getAuthorizedDate()}</td>
						<td>${user.getAuthorizedBy()}</td>


					</tr>
				</c:forEach>
			</tbody>
		</table>
		<button type="submit" name="datatable">Submit</button>

	</form>
	<script src="https://code.jquery.com/jquery-1.12.4.js"
		type="text/javascript"></script>
	<script
		src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"
		type="text/javascript"></script>


	<script>
		/* $(document).ready(function()
		 {
		 $('#Maker').DataTable();
		 } ); */
	</script>


</body>
</html>