<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp Page</title>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<style type="text/css">

span{
    color: darkred;
    font-size: 19px;
    margin-left: 500px;

}

</style>
</head>
<body>
	<h1 style="margin-left: 473px;">Welcome to Sign Up Page</h1>
	<div style="margin-left: 473px;">Please Enter Following Details</div>
	<br>
	<span id="message" value=""></span>
	<div style="margin-left: 473px;">
		<form action="/signup" method="post">
			Name:- <input type="text" id="name" name="umane"><br>
			<br> Email:- <input type="email" id="email" name="uemail"><br>
			<br> Mobile Number:- <input type="mob" maxlength=10 minlength=10 id="mob" name="umobile"><br>
			<br> UserName:- <input type="text" id="userid" name="userid"><br>
			<br> Password:-<input type="password" id="pass" name="password"><br>
			<br> <input type="hidden" id="token" value="${token}"
				name="token"><br>
			<button onclick="return validateform();"
				style="background-color: greenyellow; margin-left: 91px; width: 126px;">
				Submit</button>
			<br>
			<br>
			<br>
			<br>
		</form>
	</div>
	<a href="/"><h2 style="padding-left: 486px;">Home Page</a>
	<a href="/login">Login Page
		</h2>
	</a>
	
	
	<script>
function validateform(){
	var name=$('#name').val();
	var email=$('#email').val();
	var mob=$('#mob').val();
	var userid=$('#userid').val();
	var pass=$('#pass').val();
	var token=$('#token').val();
	if(name ==""|| name==null){
		$('#message').text('Please Enter Name');
		$('#name').focus();
		return false;
	}
	if(email ==""|| email==null){
		$('#message').text('Please Enter Email');
		$('#email').focus();
		return false;
	}
	if(mob ==""|| mob==null){
		$('#message').text('Please Enter Mobile Number');
		$('#mob').focus();
		return false;
	}
	if(userid ==""|| userid==null){
		$('#message').text('Please Enter UserId');
		$('#userid').focus();
		return false;
	}
	if(pass ==""|| pass==null){
		$('#message').text('Please Enter Password');
		$('#pass').focus();
		return false;
	}
	if(token ==""|| token==null){
		$('#message').text('Please Reload this page');		
		return false;
	}

}

</script>
</body>


</html>