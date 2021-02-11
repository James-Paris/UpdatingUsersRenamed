<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"></style>
</head>
<body>

<h3>Edit User Credentials:</h3>

<form action="/update/${user.id }" method="post">
	<label>User ID: <b>${user.id }</b></label><br>
	<label>Username: <input type="text" name="username" value="${user.username }"></input></label><br>
	<label>Password: <input type="text" name="password" value="${user.password }"></input></label><br>
	<input type="submit" value="Update Info"></input>

</form>

</body>
</html>