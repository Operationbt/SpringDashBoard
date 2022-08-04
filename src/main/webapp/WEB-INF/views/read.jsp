<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글읽기</title>
</head>
<body>
	<form method="post">
		<p><label>글번호</label> <input type="text" name ="id" value ="${postDTO.post_id}" readonly="readonly"></p>
		<p><label>제목</label> <input type="text" name ="title" value ="${postDTO.post_title}" readonly="readonly"></p>
		<p><label>작성자</label> <input type="text" name="writer" size="15" value = "${postDTO.post_writer}"readonly="readonly"><p>
		<label>내용</label>
		<br>
		<textarea name=content rows ="10" cols="70" readonly="readonly">${postDTO.post_content}</textarea>
		<br>
		<button type="submit" formaction="modify" formmethod="get">수정</button>
		<button type="submit" formaction="delete" formmethod="post">삭제</button>
		<button type="submit" formaction="home" formmethod="get">목록</button>
	</form>
		
</body>
</html>