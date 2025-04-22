<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					<td colspan="2" align="center"><img src="findimagebyid/${student.id }" height="200" width="160">
					<br>
					<a href="finddocsbyid/${student.id }" target="_blank">View Docs</a>
					</td>
				</tr>
				<tr>
					<td align="right">Id:</td>
					<td><input type="text" name="id" value="${student.id }" readonly="readonly"></td>
				</tr>
				<tr>
					<td align="right">Name:</td>
					<td><input type="text" name="name" value="${student.name }"></td>
				</tr>
				<tr>
					<td align="right">City:</td>
					<td><input type="text" name="city" value="${student.city }"></td>
				</tr>
				<tr>
					<td align="left">Percentage:</td>
					<td><input type="text" name="percentage" value="${student.percentage }"></td>
				</tr>
				<tr>
					<td align="right">change Image:</td>
					<td><input type="file" name="image"></td>
				</tr>
				<tr>
					<td align="right">change Docs:</td> 
					<td><input type="file" name="docs"></td>
				</tr>

				<tr>
					<td colspan="2" align="center">
						<input type="submit" name="b1" value="update"></td>

				</tr>
			</table>
		</form>
		</center>
</body>
</html>