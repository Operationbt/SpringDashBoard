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
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<P>  My name is ${myName}. </P>
<P>DB연결 상태 : ${dbConn}</P> 
</body>
</html>
