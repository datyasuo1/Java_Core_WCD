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
  <img src="https://www.prestashop.com/sites/default/files/wysiwyg/404_not_found.png" alt="<%=message%>">
</body>
</html>
