<html>
<head>
</head>
<%@ page import="java.util.*" %> 

<%
Vector v=new Vector(); 
// Una forma igual session. putValue("nombre", request.getParameter("nombre"));
session.setAttribute("nombre", request.getParameter("nombre")); 
application.setAttribute( "opinion" ,v) ; 
%>
<frameset rows="60%,*"> 
    <frame src="chat_arriba.jsp"> 
    <frame src="chat_abajo.jsp"> 
</frameset> 
</html>