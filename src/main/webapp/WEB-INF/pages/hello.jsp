<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">



	<title>Signin</title>

	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/signin.css" />" rel="stylesheet">





</head>

<body>

<div class="container">

	<form action="/login" method="post" class="form-signin" role="form">
		<h2 class="form-signin-heading">Please sign in</h2>
		<label class="alert-danger">
			${warning}
		</label>
		<input type="text" class="form-control" placeholder="Login" name="loginAut" required autofocus>
		<input type="password" class="form-control" placeholder="Password" name="passwordAut"required><br>
		<button class="btn btn-primary btn-block" type="submit">Sign in</button>
	</form>
	<form action="/registration" method="post" class="form-signin" role="form">
		<button class="btn btn-primary btn-block" type="submit">Registration</button>
	</form>

</div>
</body>
</html>