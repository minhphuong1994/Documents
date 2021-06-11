<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Page</title>
<link rel="stylesheet"	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"	crossorigin="anonymous">
</head>
<body>
	<form action="insert" class="container bg-success">
		<div class="form group">
			<label for="id">Employee id: </label>
			<input type="text" id="id" name="id" class="form-cotrol"/>			
		</div>	
		
		<div class="form group">
			<label for="name">Name: </label>
			<input type="text" id="name" name="name" class="form-cotrol"/>			
		</div>	
		
		<div class="form group">
			<label for="city">City: </label>
			<input type="text" id="city" name="city" class="form-cotrol"/>			
		</div>	
		
		<div class="form group">
			<label for="contact">Contact: </label>
			<input type="text" id="contact" name="contact" class="form-cotrol"/>			
		</div>	
		
		<div class="form group">
			<label for="email">Email: </label>
			<input type="text" id="email" name="email" class="form-cotrol"/>			
		</div>		
		
		<div class="form group">
			<button type="submit" class="btn btn-primary">Insert</button>
		</div>
	</form>
</body>
</html>