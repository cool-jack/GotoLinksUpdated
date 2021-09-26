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
<title>Edit Category</title>
<style type="text/css">
.top-buffer { margin-top:50px; }
</style>
</head>
<body>
<div class="container top-buffer">
<div class="mx-auto" style="width: 400px;"><h3>${message}</h3></div>
<div class="mx-auto" style="width: 400px;"><table> <tr><td><a href="/addCategory" class="btn btn-primary" style="width: 170px;">Add new Category</a></td><td><a href="/showHomePage" class="btn btn-primary" style="width: 170px;">Back to Home</a></td></tr></table></div>
<div class="mx-auto" style="width: 400px;"><h3>${userBean.firstName}'s Bookmark categories</h3></div>

	<table class="table mx-auto" style="width: 400px;">
		<thead>
			<tr>
				<th>Category Label</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${categoryList}" var="category">
				<tr>
					<td>${category.categoryName}</td>
					<td><a href="/editCategory?categoryId=${category.categoryId}" class="btn btn-primary" >Update</a> <a href="/deleteCategory?categoryId=${category.categoryId}" class="btn btn-danger">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
	
	

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>