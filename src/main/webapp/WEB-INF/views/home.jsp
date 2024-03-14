<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
<style type="text/css">
h1 {
	color: blue;
	margin-left: 279px;
	padding-top: 50px;
}

#second{
    margin-left: 430px;
}

h3 {
	color: red;
	margin-left: 535px;
}
</style>
</head>
<body>
	<div id="first">
		<h1>Welcome to Small Web App having Three Modules</h1>
		<br>
		<h3>${message}</h3>
		<div id="second">
			<a href="/signup">SignUp
					Module</a> ||  <a href="/login">Login Module</a> ||  <a href="#">Profile Updation Module</a>
		</div>
	</div>
</body>
</html>