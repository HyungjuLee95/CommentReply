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
	<h1>${vo2.b_num } 게시글</h1>
	<table border=1>
		<tr>
			<td>b_num}</td>
			<td>b_title}</td>
			<td>b_content}</td>
			<td>b_user_id}</td>
		</tr>
<!-- 		model을 통해 vo2에 담아온 정보를 display -->
		<tr>
			<td>${vo2.b_num}</td>
			<td>${vo2.b_title}</td>
			<td>${vo2.b_content}</td>
			<td>${vo2.b_user_id}</td>
		</tr>
	</table>
	
	
	
	<hr>
	
<!-- 	<table border =1 > -->
<%-- 		<c:forEach var="" items=""> --%>
<!-- 		<tr> -->
<!-- 			<td>C_R_NUM</td> -->
<!-- 			<td>C_R_POSTED_NUM</td> -->
<!-- 			<td>C_R_COMMENTS</td> -->
<!-- 			<td>C_R_USER_ID</td> -->
<!-- 			<td>C_R_PARENT_COM</td> -->
<!-- 		</tr> -->
<%-- 		</c:forEach> --%>
<!-- 	</table> -->
<form action = "delete.do">
<input type="hidden" name="b_num" value=${vo2.b_num}>
<button type="submit"> 삭제 </button>
</form>

</body>
</html>