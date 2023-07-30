<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<style>
table{
width:1000px;

}
table td{
width:150px;
mar
}

</style>
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
	<form action = "delete.do">
<input type="hidden" name="b_num" value=${vo2.b_num}>
<button type="submit"> 삭제 </button>
</form>
	
	
	
	<hr>
	
	
	<h1>댓글</h1>
	<table border=1>

			<c:forEach items="${com_vos}" var="com_vo">
				<table border=1>
					<tr>
						<td> c_r_num	</td>
						<td> c_r_posted_num	</td>
						<td> c_r_comments	</td>
						<td> c_r_user_id	</td>
						<td> c_r_parent_com	</td>
					</tr>
					<tr>
						<td> ${com_vo.c_r_num}	</td>
						<td> ${com_vo.c_r_posted_num}	</td>
						<td> ${com_vo.c_r_comments}	</td>
						<td> ${com_vo.c_r_user_id}	</td>
						<td> ${com_vo.c_r_parent_com}	</td>
						</tr>
					<tr>
					<td colspan="2">
						<form action="reply_insertOK.do">
							<input type ="text" name="c_r_comments" placeholder="대댓글을 입력하세요">
							<input type ="hidden" name="c_r_posted_num" value="${com_vo.c_r_posted_num}">
							<input type ="hidden" name="c_r_parent_com" value="${com_vo.c_r_num}">
							<button type="submit"> 대댓글 등록</button>
						</form>
						
					</tr>
					<tr>
					<td colspan="2">
						
					</td>
					</tr>
					
				
				
		</table>
	
				
					<c:forEach items="${reply_vos}" var="reply_vo">
						<c:if test="${reply_vo.c_r_parent_com eq com_vo.c_r_num}">	
							<div style="background-color: green">
						
						<table border=1>
						
							<tr>
								<td> 대댓C_R_NUM	</td>
								<td> 대댓C_R_POSTED_NUM	</td>
								<td> 대댓C_R_COMMENTS	</td>
								<td> 대댓C_R_USER_ID	</td>
								<td> 대댓C_R_PARENT_COM	</td>
							</tr>
						
							<tr>
								<td> ${reply_vo.c_r_num}	</td>
								<td> ${reply_vo.c_r_posted_num}	</td>
								<td> ${reply_vo.c_r_comments}	</td>
								<td> ${reply_vo.c_r_user_id}	</td>
								<td> ${reply_vo.c_r_parent_com}	</td>
								
							</tr>
							<tr>
							<td>
						<form action="reply_deleteOK.do">
							<input type ="hidden" name="c_r_posted_num" value="${reply_vo.c_r_posted_num}">
							<input type ="hidden" name="c_r_num" value="${reply_vo.c_r_num}">
							<button type="submit"> 대댓글 삭제</button>
						</form>
						</td>
							
							</tr>
							
								</table>
								</div>	
							
						</c:if>
					</c:forEach>
	
	
	
			</c:forEach>
			
	<form action="com_insertOK.do">
	<input type ="text" name = "c_r_comments" placeholder="댓글을 입력해주세요."> 
	<input type ="hidden" name = "c_r_posted_num" value="${vo2.b_num}"> 
	<button type = "submit"> 제출 </button>
	</form>
	
	



</body>
</html>