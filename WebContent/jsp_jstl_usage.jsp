<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstl usage</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<h3>foreach 사용예</h3>

	<table class="table table-hover">

		<tr>
			<th colspan='2'>과목</th>
		</tr>
		<c:forEach var="subject" items="${subjects}" begin="1" varStatus="status">
			<tr><td>${status.count}</td><td>${subject}</td></tr>
		</c:forEach>
	</table>
	<br>
	<table >
		<tr>
			<th rowspan='2'>과목</th>
			<c:forEach var="subject" items="${subjects}" begin="1" varStatus="status">
				<td>${status.count}</td>
			</c:forEach>
		</tr>		
		<tr>	
			<c:forEach var="subject" items="${subjects}" begin="1" varStatus="status"><td>${subject}</td></c:forEach>
		</tr>		
	</table>
</div>
</body>
</html>