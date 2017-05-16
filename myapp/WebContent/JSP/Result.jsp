<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String str1=String.valueOf(session.getAttribute("st1"));
String str2=String.valueOf(session.getAttribute("st2"));
String str3=String.valueOf(session.getAttribute("st3"));
%>
<div>
<pre>
State Searched: <%=str1%>
Capital       :  <%=str2%>
CM            : <%=str2 %>
</pre>
</div>
</body>
</html>