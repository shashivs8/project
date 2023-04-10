<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>X-Workz</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg-navbar-Light bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img
				src=" https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
				alt="" width="80" height="48" class="d-inline-block align text-top">

				<a href="index.jsp">Home</a>
				
				<a href="SignIn.jsp">SignIn</a>
				
		</div>

	</nav>
	<h1 style="color: green;">${message}</h1>
	<h5 style="color: red;">${messag}<br>
		<c:forEach items="${errors}" var="e">${e.message}</c:forEach>
	</h5>

	<form action="reg" method="post">
		<pre>
	User ID <input type="text" name="userId" id="userName" onchange="ValidName()"> <span id="nameError" style="color: red"></span>
			<span id="displayUserName" style="color: red"> </span>
			<br> 
			
	Email<input type="email" name="email" id="emailId" onchange="validEmail()"> <span id="emailError" style="color: red"></span><br>
		<span id="display" style="color: red"></span>
			  
	Mobile Number<input type="number" name="mobileNumber" id="userMobile" onchange="ValidMobile()"> <span id="mobileError" style="color: red"></span> <br>
		    <span id="displayUserMobile" style="color: red"></span>
		    
	Password<input type="password" name="password" id="userPassword" onchange="ValidPassword()"> <span id="passwordError" style="color: red"></span> 
			 <input type="checkbox" onclick="myFunction()">Show Password <br>
			
	ConfirmPassword<input type="password" name="confirmPassword" id="userConfirmPassword" onchange="ValidPassword()">
			<span id="passwordCompare" style="color: red"></span> <br>
			  
	Accept Agreement <input type="checkbox" name="acceptAgreement"
				id="agreementConfirm" onclick="onconfirm()"> <br>
		   
		   <button type="submit" id="submitId" disabled="true">SignUp</button>
	</pre>
	</form>

	<h4 style="color: red;">${password}</h4>

	<script>
		function myFunction() {
			var x = document.getElementById("userPassword");
			if (x.type === "password") {
				x.type = "text";
			} else {
				x.type = "password";
			}
		}

		function onconfirm() {
			var agree = document.getElementById('agreementConfirm');
			console.log(agree.checked);
			if (agree.checked) {
				document.getElementById('submitId').disabled = false;
			} else {
				document.getElementById('submitId').disabled = 'disabled';
			}

		}

		function ValidName() {
			var user = document.getElementById('userName');
			var uservalue = user.value;
			console.log(uservalue);
			if (uservalue != null && uservalue != "" && uservalue.length > 2
					&& uservalue.length < 30) {
				console.log('valid name');
				document.getElementById('nameError').innerHTML = '';
			} else {
				console.log('invalid name');
				document.getElementById('nameError').innerHTML = 'Please enter valid name min 4 and max 30 character';
			}

			const xhttp = new XMLHttpRequest();
			console.log("running in ajax");
			console.log(uservalue);
			xhttp.open("GET", "http://localhost:8080/xworkz_shashi_cm/userName/"
					+ uservalue);
			xhttp.send();
			xhttp.onload = function() {
				console.log(this);

				document.getElementById("displayUserName").innerHTML = this.responseText
			}

		}

		function validEmail() {
			var userEmail = document.getElementById('emailId');
			var userEmailvalue = userEmail.value;
			console.log(userEmailvalue);
			if (userEmailvalue != null && userEmailvalue != ""
					&& userEmailvalue.length > 4 && userEmailvalue.length < 40) {
				console.log('valid email');
				document.getElementById('emailError').innerHTML = '';
			} else {
				console.log('invalid email');
				document.getElementById('emailError').innerHTML = 'Please enter valid email';
			}

			const xhttp = new XMLHttpRequest();
			console.log('Running in ajax');
			console.log(userEmailvalue);
			xhttp.open("GET", "http://localhost:8080/xworkz_shashi_cm/email/"
					+ userEmailvalue);
			xhttp.send();
			xhttp.onload = function() {
				console.log(this);
				document.getElementById("display").innerHTML = this.responseText
			}
		}

		function ValidMobile() {
			var userMobile = document.getElementById('userMobile');
			var userMobilevalue = userMobile.value;
			console.log(userMobilevalue);
			if (userMobilevalue != null && userMobilevalue != ""
					&& userMobilevalue.length == 10) {
				console.log('valid mobile');
				document.getElementById('mobileError').innerHTML = '';
			} else {
				console.log('invalid mobile');
				document.getElementById('mobileError').innerHTML = 'Please enter valid Mobile Number';
			}

			const xhttp = new XMLHttpRequest();
			console.log('Running in ajax');
			console.log(userMobilevalue);
			xhttp.open("GET", "http://localhost:8080/xworkz_shashi_cm/mobile/"
					+ userMobilevalue);
			xhttp.send();
			xhttp.onload = function() {
				console.log(this);
				document.getElementById("displayUserMobile").innerHTML = this.responseText
			}

		}

		function ValidPassword() {
			var userPassword = document.getElementById('userPassword');
			var userConfirmPassword = document
					.getElementById('userConfirmPassword');
			var userPasswordvalue = userPassword.value;
			var userConfirmPasswordvalue = userConfirmPassword.value;
			console.log(userPasswordvalue);
			if (userPasswordvalue != null && userPasswordvalue != ""
					&& userPasswordvalue.length > 4
					&& userPasswordvalue.length < 12) {
				if (userPasswordvalue == userConfirmPasswordvalue) {
					console.log('valid both password are same');
					document.getElementById('passwordCompare').innerHTML = '';
				} else {
					console.log('valid both password are not same');
					document.getElementById('passwordCompare').innerHTML = 'Password and ConfirmPassword must be same';
				}
				console.log('valid password');
				document.getElementById('passwordError').innerHTML = '';
			} else {
				console.log('invalid password');
				document.getElementById('passwordError').innerHTML = 'Please enter valid password';
			}
		}
	</script>
</body>
</html>