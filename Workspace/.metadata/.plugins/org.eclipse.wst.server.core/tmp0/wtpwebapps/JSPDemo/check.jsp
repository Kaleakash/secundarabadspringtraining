<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="com.Login" %>
<%!String user,pass; %>
<%
user = request.getParameter("user");
pass = request.getParameter("pass");
Login ll = new Login();
ll.setUser(user);			ll.setPass(pass);
/*if(ll.checkUser()){
	out.println("Successfully LOgin");
}else {
	out.println("Failure try once again!");
}*/
%>
</body>
</html>


