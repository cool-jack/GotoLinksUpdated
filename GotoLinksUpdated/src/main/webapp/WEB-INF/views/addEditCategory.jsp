<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.top-buffer { margin-top:50px; }
</style>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Category</title>
<style type="text/css">
.top-buffer { margin-top:50px; }
</style>
</head>
<body>

<c:if test="${activePage == 'add'}">
		<div class="container top-buffer">
		
			<div class="top-buffer">
			<p align="center"><font color="red">${message}</font></p>
			<a href="/showHomePage" class="btn btn-primary mx-auto" style="width: 170px;">Back to Home</a>
				<div class="row">
					<div class="mx-auto"><h2>Add New Category</h2> </div>
				</div>
				<div class="row">
					
					<div class="mx-auto" style="width: 320px;" > 
						<form method="post">
							<div class="form-group">
								<label>Enter New Category</label>
								<input class="form-control" type="text" name="categoryName" placeholder = "Enter Category" />
							</div>
							<div class="mx-auto">
								<input type="submit" class="btn btn-info"  value="Add Category">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	<c:if test="${activePage == 'edit'}">
		<div class="container top-buffer">
		
			<div class="top-buffer">
			<p align="center"><font color="red">${message}</font></p>
			<a href="/showHomePage" class="btn btn-primary" style="width: 170px;">Back to Home</a>
				<div class="row">
				
					<div class="mx-auto"><h2>Update Category</h2> </div>
				</div>
				<div class="row">
					
					<div class="mx-auto" style="width: 320px;" > 
						<form method="post" action="/editCategory">
							<div class="form-group">
								<label>Update Category</label>
								<input type="hidden" name="categoryId" value="${categoryBean.categoryId}"/>
								<input class="form-control" type="text" name="categoryName" value="${categoryBean.categoryName}" />
							</div>
							<div class="mx-auto">
								<input type="submit" class="btn btn-info"  value="Update Category">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>