<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <%
    Coockie cc[]=request.getCookies();
    StringBuffer sb=new StringBuffer();
    for(int i=0;i<cc.length;i++){
        sb.append("<strong>"+cc[i].getName()+"</strong>");
        sb.append("=");
        sb.append(cc[i].getValue());
        sb.append("<br>");
    }
    %>
    <%=sb.toString()%>
</body>
</html>