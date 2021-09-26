<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.top-buffer { margin-top:50px; }
.topLittle-buffer { margin-top:10px; }
</style>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Links</title>
</head>
<body>


<div class="container topLittle-buffer">
<div class="row mx-auto" style="width: 500px;"><h3>${message}</h3></div>
<div class=" row mx-auto" style="width: 500px;">
<table class="mx-auto"><tr><td>
	<a href="/addLink" class="btn btn-info"> Add Bookmarks</a>
	</td>
	<td>
	<a href="/listCategory" class="btn btn-info"  > Add/Edit Categories</a>
</td></tr></table>
<div class="mx-auto topLittle-buffer"> 
	<form action="/searchLinks">
		<table>
		<tr>
			<td><input class="form-control" type="text" name="linkNameKeyword" style="width: 250px"/>
			</td>
			<td><input type="submit" class="btn btn-secondary" value="Search Bookmark"></td>
		</tr>
		</table>
	</form>
</div>
<div class="mx-auto topLittle-buffer"> 
	<form action="/filterLinks">
		<table>
		<tr>
			<td><select class="form-select" name="categoryId">
					<c:choose>
						<c:when test = "${pageValue == 'category'}">
							<option selected disabled>${categoryBean.categoryName}</option>	
						</c:when>
						<c:otherwise>
							<option selected disabled>Please select Bookmark Category to filter </option>
						</c:otherwise>
					</c:choose>
					<option selected disabled>Please select Bookmark Category to filter </option>
					<c:forEach items="${categoryList}" var="categoryBean">
						<option value="${categoryBean.categoryId}">${categoryBean.categoryName}</option>
					</c:forEach>	
				</select>
			</td>
			<td><input type="submit" class="btn btn-secondary" value="Filter" /></td>
		</tr>
		</table>
	</form>
</div>
</div>
<div class="mx-auto top-buffer" style="width: 500px;"><h3>${userBean.firstName}'s Bookmarks</h3></div>
	<table class="table mx-auto" style="width: 500px;">
		<thead>
			<tr>
				<th>Bookmark Name</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${userLinks}" var="linkBean">
				<tr>
					<td><a href="${linkBean.linkUrl}" target="_blank">${linkBean.linkName}</a></td>
					<td><a href="/updateLink?linkId=${linkBean.linkId}" class="btn btn-primary">Update</a> <a href="/deleteLink?linkId=${linkBean.linkId}" class="btn btn-danger">Delete</a></td>
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
</html>