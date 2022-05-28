<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String message = (String) request.getAttribute("message");
%>
<html>
<head>
    <title><%=message%></title>
</head>
<body>
  <h1><%=message%></h1>
  <img src="https://memegenerator.net/img/instances/38405272/can-i-use-my-server-no-500-internal-server-error.jpg" alt="<%=message%>">
</body>
</html>
