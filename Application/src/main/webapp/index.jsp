<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h2>Student Registration Form</h2>
		<hr>
		<form action="req1" method="post" enctype="multipart/form-data">
			<table border="0">
				<tr>
					<td align="right">Id:</td>
					<td><input type="text" name="id" value="0"></td>
				</tr>
				<tr>
					<td align="right">Name:</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td align="right">City:</td>
					<td><input type="text" name="city"></td>
				</tr>
				<tr>
					<td align="left">Percentage:</td>
					<td><input type="text" name="percentage" value="0.0"></td>
				</tr>
				<tr>
					<td align="right">Image:</td>
					<td><input type="file" name="image"></td>
				</tr>
				<tr>
					<td align="right">Docs:</td>
					<td><input type="file" name="docs"></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit" name="b1"
						value="Add"> <input type="submit" name="b1" value="Delete">
						<input type="submit" name="b1" value="Display"></td>

				</tr>
			</table>
		</form>
		${msg } <br>
		<h3>List Students</h3>

		<form action="searchbyany" method="get">
			<input type="text" name="s1" placeholder="search by any">
			 <input type="submit" name="b1" value="Search">
		</form>

		<hr>
		<table border="1">
			<th>ID</th>
			<th>Image</th>
			<th>Name</th>
			<th>City</th>
			<th>Percentage</th>
			<th>Docs</th>
			<c:forEach var="s" items="${students}">
				<tr>
					<td>${s.id}</td>
					<td><img src="findimagebyid/${s.id }" height="100" width="80">
					</td>
					<td>${s.name}</td>
					<td>${s.city}</td>
					<td>${s.percentage}</td>
					<td><a href="finddocsbyid/${s.id}" target="_blank">View</a>
						&nbsp&nbsp <a href="finddocsbyid/${s.id}" download>Download</a></td>
				</tr>

			</c:forEach>
		</table>

	</center>
</body>
</html>