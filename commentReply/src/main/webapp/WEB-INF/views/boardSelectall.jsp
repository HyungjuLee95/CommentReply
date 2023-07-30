<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border=1>
		<tr>
			<td>b_num</td>
			<td>b_title</td>
			<td>b_content</td>
			<td>b_user_id</td>
		</tr>
		<c:forEach var="vo" items="${vos }">
			<tr>
				<td><a href="selectOne.do?b_num=${vo.b_num}">${vo.b_num}</a></td>
				<td><a href="selectOne.do?b_num=${vo.b_num}">${vo.b_title}</a></td>
				<td>${vo.b_content}</td>
				<td>${vo.b_user_id}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="insert.do">글 작성</a>
</body>
</html>