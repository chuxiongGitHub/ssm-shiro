<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/11
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="<%=request.getContextPath()%>/res/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
    <span class="text-danger">
        ${username}已经存在
    </span>
</div>
</body>
</html>
