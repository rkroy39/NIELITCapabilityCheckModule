<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<style type="text/css">
h1 {
	margin-left: 479px;
	color: #028f2e;
}

h2 {
	margin-left: 410px;
}

form {
	margin-left: 487px;
}

button {
	margin-left: 107px;
	background-color: lightgreen;
	width: 91px;
	height: 31px;
}

h3 {
	color: red;
	margin-left: 511px;
}
span{
    color: darkred;
    font-size: 19px;
    margin-left: 500px;

}
</style>
</head>
<body>
	<h1>Welcome To Login Page</h1>
	<h2>Enter Your Credentials To Login into your Profile</h2>
	<h3>${message}</h3>
	<span id="message" value=""></span>
	<form action="/login" method="post">
		Login Id : <input type="text" id="loginid" name="loginid"><br>
		<br> Password : <input type="password" id="passw" name="password"><br>
		<br> <input type="hidden" value="${logintoken}" id="token"
			name="logintoken"><br>
		<button onclick="return validateform();">Submit</button>
	</form>
	
	<script>
function validateform(){
	var loginid=$('#loginid').val();
	var passw=$('#passw').val();
	var token=$('#token').val();
	if(loginid ==""|| loginid==null){
		$('#message').text('Please Enter LoginID');
		$('#loginid').focus();
		return false;
	}
	if(passw ==""|| passw==null){
		$('#message').text('Please Enter Password');
		$('#passw').focus();
		return false;
	}
	if(token ==""|| token==null){
		$('#message').text('Please Reload this page');		
		return false;
	}

}

</script>
</body>
<a href="/"><h2 style="padding-left: 100px;">Home Page</a>
<a href="/signup">SignUp Page
	</h2>
</a>
</html>