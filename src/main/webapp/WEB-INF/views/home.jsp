<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css" />
<title>Restaurant Rating</title>
</head>
<body>
	<h1 align="center">Rate your favorite Restaurant!</h1>
	<div class="container" style="border: 1px solid #CCC">
		<table class="table">
			<thead>
				<tr>
					<th><a href="/sortByName" class="btn btn-light btn-sm">Name</a></th>
					<th><a href="/sortByRating" class="btn btn-light btn-sm">Rating</a></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="restaurant" items="${restaurants}">
					<tr>
						<td>${restaurant.name}</td>
						<td>${restaurant.rating}</td>
						<td><a href="/incrementRating?id=${ restaurant.id }"
							class="btn btn-light btn-sm"><img
								src="1338-thumbs-up-sign.png" alt="Up" border=3 height=25
								width=25 /></a> <a href="/decrementRating?id=${ restaurant.id }"
							class="btn btn-light btn-sm"><img
								src="1339-thumbs-down-sign.png" alt="Down" border=3 height=25
								width=25 /></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>