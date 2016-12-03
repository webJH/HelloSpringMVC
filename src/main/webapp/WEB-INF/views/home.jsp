<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>


	<table border="10 width="100%">
		<tr>
			<th>year</th>
			<th>semester</th>
			<th>grade</th>
			<th>moreinfo</th>
		</tr>
		<c:forEach var="offer" items="${offers}" varStatus="status">
			<tr>
				<td><c:out value="${offer.year}">
					</c:out></td>
				<td><c:out value="${offer.semester}">
					</c:out></td>
				<td><c:out value="${grade.get(status.index)}">
					</c:out></td>
				<td><a
					href="/helloSpringMVC/offers?year=${offer.year}&semester=${offer.semester}">more
						info</a></td>
			</tr>
		</c:forEach>


	<table border="10 width="100%">
	<c:forEach var="divisions" items="${division}">
		<tr>
			<td><c:out value="${divisions.division}">
				</c:out></td>
			<td><c:out value="${divisions.grade}">
				</c:out></td>
		</tr>
	</c:forEach>
	</table>


	<p>
		<a href="/helloSpringMVC/createOffer">add course</a>
</body>
</html>
