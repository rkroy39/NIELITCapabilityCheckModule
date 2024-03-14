<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to profile page</title>
<style>
h1 {
	color: green;
	margin-left: 511px;
}

button {
	margin-left: 55px;
	background-color: #31f131;
}

form {
	margin-left: 527px;
}

h3 {
	color: red;
	margin-left: 535px;
}
</style>
</head>
<h1>Your Profile Details</h1>
<body>
	<h3>${message}</h3>
	<form action="/updateProfile" method="post">
		Name:- <input type="text" id="name" value="${userdata.username}"
			name="umane"><br> <br> Email:- <input type="email"
			id="email" value="${userdata.email}" name="uemail"><br>
		<br> Mobile Number:- <input type="mob" id="mob"
			value="${userdata.mobile}" name="umobile"><br> <br>
		Password:-<input type="text" id="pass" value="${userdata.password}"
			name="password"><br> <br> <input type="hidden"
			id="token" value="${profiletoken}" name="token">
		<button>Update Your Details</button>
	</form>
	<a href="/logout"><button>Logout</button></a>
</body>
</html>