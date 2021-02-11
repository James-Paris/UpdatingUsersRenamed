<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"></style>
</head>
<body>

<h3>User lookup:</h3>
<div style="color: red">${error}</div>
<form action="" method="post">
	<label>User ID:<input type="number" name="userid"></input></label>
	<input type="submit"></input>
</form>

</body>
</html>