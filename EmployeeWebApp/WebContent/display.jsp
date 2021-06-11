<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.* ,com.cestar.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"	crossorigin="anonymous">
</head>
<body>
	<% 
		List<Employee> emps = (ArrayList)session.getAttribute("emps");
		out.print(emps);
	%>
	
	<table border="5" class="table-striped">
		<tr>
			<th>ID</th> 
			<th>Name</th> 
			<th>City</th> 
			<th>Contact</th> 
			<th>Email</th>
			<th>Update</th>
			<th>Delete</th> 
		</tr>
		<%for(Employee emp:emps) {%>
		<tr>
			<td><%=emp.getId() %></td>
			<td><%=emp.getName() %></td>
			<td><%=emp.getCity() %></td>
			<td><%=emp.getContact() %></td>
			<td><%=emp.getEmail() %></td>
			<td><a href="edit?id=<%=emp.getId()%>" class="btn btn-success">Update</a></td>
			<td><a href="delete?id=<%=emp.getId()%>" class="btn btn-danger">Delete</a></td>			
		</tr>
		<%} %>
		<tr>
			<td colspan="7"><a href="insert.jsp" class="btn btn-primary">Insert</a></td>
		</tr>
	</table>
</body>
</html>