<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/11
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
    <link rel="stylesheet" href="/res/bootstrap/css/bootstrap.css" type="text/css">
</head>
<body>
<table class="table table-bordered">
    <thead>
    <tr>
        <th colspan="4" align="center">用户信息</th>
    </tr>
    <tr>
        <th>序号</th>
        <th>用户id</th>
        <th>用户名</th>
        <th>用户描述</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${user}" var="data">
        <tr>
            <td>${data.userId}</td>
            <td>${data.username}</td>
            <td>${data.password}</td>
            <td>${data.remark}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
