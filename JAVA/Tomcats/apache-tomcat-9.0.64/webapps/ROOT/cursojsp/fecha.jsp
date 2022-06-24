<html>
<head>
<style>
h2{
    background-color: #4CAF50;
}
</style>
</head>
<body>
<h1><%= new java.util.Date() %></h1>
<%
out.write("<h2>Hoy es viernes</h2>");
%>
<% int dia=new java.util.Date().getDate();
if(dia==1){ %>
<h2>Hoy me pasa el recibo de la luz</h2>
<% }else{ %>
<h2>Hace <%= dia-1 %> dias que me pasaron el maldito recibo</h2>
<% } %>
</body>
</html>