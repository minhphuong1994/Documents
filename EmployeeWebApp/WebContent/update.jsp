<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.cestar.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Page</title>
<link rel="stylesheet"	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"	crossorigin="anonymous">
</head>
<body>
	<% 
		Employee emp = (Employee) session.getAttribute("update_emp");
		out.print(emp);
	%>
	
	<form action="update" class="container bg-success">
		<div class="form group">
			<label for="id">Employee id: </label>
			<input type="text" id="id" name="id" 
				class="form-cotrol" value="<%=emp.getId()%>"/>			
		</div>	
		
		<div class="form group">
			<label for="name">Name: </label>
			<input type="text" id="name" name="name" 
				class="form-cotrol" value="<%=emp.getName()%>"/>			
		</div>	
		
		<div class="form group">
			<label for="city">City: </label>
			<input type="text" id="city" name="city" 
				class="form-cotrol" value="<%=emp.getCity()%>"/>			
		</div>	
		
		<div class="form group">
			<label for="contact">Contact: </label>
			<input type="text" id="contact" name="contact" 
				class="form-cotrol" value="<%=emp.getContact()%>"/>			
		</div>	
		
		<div class="form group">
			<label for="email">Email: </label>
			<input type="text" id="email" name="email" 
				class="form-cotrol" value="<%=emp.getEmail()%>"/>			
		</div>		
		
		<div class="form group">
			<button type="submit" class="btn btn-primary">Update</button>
		</div>
	</form>
	
	
</body>
</html>