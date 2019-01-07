<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%
    String latitude = (String)session.getAttribute("latitude");
	String longitude = (String)session.getAttribute("longitude");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<input type="text" name="latitude" value="<%=latitude%>">
	<input type="text" name="longitude" value="<%=longitude%>">
</body>
</html>