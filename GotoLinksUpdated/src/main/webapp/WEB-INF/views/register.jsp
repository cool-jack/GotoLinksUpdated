<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registeration</title>
<style type="text/css">
.top-buffer { margin-top:50px; }
</style>
</head>
<body>
	<div class="container">
		<div class="top-buffer">
			<div class="row">
				<div class="mx-auto"><h2>Sign Up</h2> </div>
			</div>
			<div class="row">
				
				<div class="mx-auto" style="width: 350px;" > 
					<form method="post">
						<div class="form-group">
							<label>First Name</label>
							<input class="form-control" type="text" name="firstName" placeholder = "Enter First Name" />
						</div>
						<div class="form-group">
							<label>Last Name</label>
							<input class="form-control" type="text" name="lastName" placeholder = "Enter Last Name" />
						</div>
						<div class="form-group">
							<label>Email</label>
							<input class="form-control" type="eamil" name="email" placeholder = "Enter Email" />
						</div>
						<div class="form-group">
							<label>Confirmed Email</label>
							<input class="form-control" type="eamil" name="cEmail" placeholder = "Enter Email" />
							<small id="emailNoMatch" style="color: red;"></small>
						</div>
						<div class="form-group">
							<label>Password</label>
							<input class="form-control" type="password" name="password" placeholder = "password" />
						</div>
						<div class="form-group">
							<label>Confirmed Password</label>
							<input class="form-control" type="password" name="cPassword" placeholder = "password" />
						</div>
						<div class="mx-auto">
							<input type="submit" class="btn btn-info"  value="Sign Up" onclick="emailMatch()">
							Already have an account? <a href="/login" class="">Login</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	
<script src="/resources/js/allJs.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>