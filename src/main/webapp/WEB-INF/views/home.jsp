<!-- web.xml에서 인코딩필터 설정해도 jsp파일 안에 있는 한글은 깨짐-->
<!-- jsp페이지 인코딩을 utf-8로 설정해야함 -->
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>
		Hello MySQL!  
	</h1>
	
	<P>  The time on the server is ${serverTime}. </P>
	<P>  My name is ${myName}. </P>
	<P>MySQL DB연결 상태 : ${dbConn}</P>
	<P><a href="./oracle">Oracle DB로 이동</a></P>
	
	<table border="1" width="880">
	        <tr>
	        <td width="77">
	            <p align="center">글번호</p>
	        </td>
	        <td width="327">
	            <p align="center">제목</p>
	        </td>
	        <td width="197">
	            <p align="center">작성자</p>
	        </td>
	        <td width="155">
	            <p align="center">작성일</p>
	        </td>
	        </tr>
			<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	        <c:forEach items="${list}" var="postDTO">
				<tr>
			        <td><a href="./read?post_id=${postDTO.post_id}">${postDTO.post_id}</a></td>
			        <td><a href="./read?post_id=${postDTO.post_id}">${postDTO.post_title}</a></td>
			        <td>${postDTO.post_writer}</td>
			        <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${postDTO.post_date}" />
					</td>
				</tr>
			</c:forEach>	
	</table>
	<a href="./write"><button type ="submit">글쓰기</button></a>
</body>
</html>
