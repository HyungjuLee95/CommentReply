<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    // b_num 값을 URL 파라미터에서 가져옵니다.
    var bNumValue = ${param.b_num};

    $.ajax({
        url: "json_comment_selectAll.do?b_num="+${param.b_num}, // json 목록 가져오기
        method: "GET",
        dataType: "json",
        data: {
        },
        success: function(response) {
            console.log("ajax on");
            console.log("response", response);
            // 불러온 항목 처리 및 가공, 출력(html에 추가)

            var html = "";
            html += '<tr>';
            html += '<td>C_R_NUM}</td>';
          	 html += '<td>C_R_POSTED_NUM</td>';
          		 html += '<td>C_R_COMMENTS</td>';
          			 html += '<td>C_R_USER_ID</td>';
          				 html += '<td>C_R_PARENT_COM</td>';
		html+='</tr>';
            
            for (var i = 0; i < response.length; i++) {
                var vo2 = response[i]; // i번째 항목을 가져옵니다.
                html += '<tr>';
                html += '<td>' + vo2.c_r_num + '</td>';
                html += '<td>' + vo2.c_r_posted_num + '</td>';
                html += '<td>' + vo2.c_r_comments + '</td>';
                html += '<td>' + vo2.c_r_user_id + '</td>';
                html += '<td>' + vo2.c_r_parent_com + '</td>';
                html += '</tr>';
            }
            $(".ajax_com").append(html);
        },
        error: function(xhr, status, error) {
            console.error(error);
        }
    });
});

</script>

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
	
	
	<body>
	<h1>댓글</h1>
	<table border=1 class="ajax_com">
		
			
	</table>
	<form action="com_insertOK.do">
	<input type ="text" name = "c_r_comments" placeholder="댓글을 입력해주세요."> 
	<input type ="hidden" name = "c_r_posted_num" value="${vo2.b_num}"> 
	<button type = "submit"> 제출 </button>
	</form>
	
	
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


</body>
</html>