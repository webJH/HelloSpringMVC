<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
			<tr>
			<th>�г�</th>
			<th>�б�</th>
			<th>�ڵ�</th>
			<th>�̸�</th>
			<th>����</th>
			<th>����</th>
			</tr>
		<c:forEach var="offer" items="${offers}">
			<tr>
				<td><c:out value="${offer.year}">
					</c:out></td>
				<td><c:out value="${offer.semester}">
					</c:out></td>
				<td><c:out value="${offer.code}">
					</c:out></td>
				<td><c:out value="${offer.name}">
					</c:out></td>
				<td><c:out value="${offer.division}">
					</c:out></td>
				<td><c:out value="${offer.grade}">
					</c:out></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>