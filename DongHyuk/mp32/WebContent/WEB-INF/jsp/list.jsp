<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<iframe name="songFrame" width="500" height="200"></iframe>
	
	<h2>list page</h2>
	<div>
		<h3><a href="/mp32/upload">업로드</a></h3>
	</div>
	<ul>
	<c:forEach var="mp3" items="${fileList}">
		<li><a href="/mp32/player?song=${param.path}/${mp3}" target="songFrame">${mp3}</a></li>
	</c:forEach>
	</ul>
</body>
</html>