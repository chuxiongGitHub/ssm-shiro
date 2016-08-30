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
    <script type="application/javascript" src="/res/bootstrap/js/jquery-3.1.0.js"></script>
</head>
<body>
<table class="table table-bordered">
    <thead>
    <tr>
        <th colspan="5" align="center">用户信息</th>
    </tr>
    <tr>
        <th>序号</th>
        <th>用户名</th>
        <th>用户密码</th>
        <th>用户描述</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${user}" var="data">
        <tr>
            <td></td>
            <td>${data.username}</td>
            <td>${data.password}</td>
            <td>${data.remark}</td>
            <td>
                <a class="btn btn-danger" href="<%=request.getContextPath()%>/user/delUser/${data.userId}">删除</a>
                &nbsp;&nbsp;
                <a class="btn bg-warning">修改</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script type="application/javascript">
    $(function(){
       var len=$('table tr').length;
        console.log(len);
        for(var i=1;i<len;i++){
            $('table tr:eq('+i+') td:first').text(i-1);
        }
    });
</script>
</body>
</html>
