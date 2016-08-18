<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/18
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取用户信息</title>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/res/bootstrap/css/bootstrap.css">
</head>
<body>
<div class="container">
    <div>
       <form action="<%=request.getContextPath()%>/rest/getUser/1" method="get">
          <input type="submit" class="bg-primary btn" value="获取人员信息">
       </form>
    </div>
</div>

</body>
</html>
