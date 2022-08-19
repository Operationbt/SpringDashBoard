<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
</head>
<body>
	<jsp:include page="navigation.jsp" flush="false"></jsp:include>
	<h1>글 수정</h1>
	<form action="modifyOracle" method = "post"> 
		<p><label>제목</label><input type="text" name ="title" value="${postDTO.post_title}"></p>
		<p><label>작성자</label><input type="text" name="writer" size="15" value="${postDTO.post_writer}"readonly="readonly"></p>
		<label>내용</label><p>
		<%-- 글자수 제한 1000자 만들어야함 제이쿼리 쓰는듯 --%>
		<textarea rows="15" cols="65" name = "content">${postDTO.post_content}</textarea><p>
		<button type = "submit">수정</button>
	</form>
</body>
</html>