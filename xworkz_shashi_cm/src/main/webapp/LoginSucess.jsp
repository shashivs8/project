<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Logged In</title>

	<!-- Import Bootstrap CSS -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
		integrity="sha384-wkT6z60+6x1U3K8uX9Y2+TZ1uJ+jRyrtW8y0BzQmxOIMCvRzovZ+ozFsfFC0YKjA"
		crossorigin="anonymous">
	
	<!-- Add custom CSS -->
	<style>
		.container {
			margin-top: 50px;
			text-align: center;
		}
		
		h1 {
			margin-bottom: 20px;
		}
		
		#userId {
			font-size: 24px;
			font-weight: bold;
			margin-top: 20px;
		}
	</style>
</head>
<body>
	<div class="container">
		<h1>Welcome to our site!</h1>
		<p>You have successfully logged in as:</p>
		<p id=userName>${userID}</p>
	</div>

	<!-- Import Bootstrap JS -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
</body>
</html>
