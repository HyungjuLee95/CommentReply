<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>게시글을 작성하세요</h1>
<form action="insertOK.do">
<input type="text" name="b_title" placeholder="제목을 입력하세요">
<input type="text" name="b_content" placeholder="내용을 작성해주세요">
<input type="hidden" name="b_user_id" value="HyungJul">
<button type="submit">제출</button>
</form>

</body>
</html>