<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/10
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="common/header.jsp"></jsp:include>
</head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/res/bootstrap/css/bootstrap.css">
<body>
<div class="container">
    <form action="<%=request.getContextPath()%>/user/register" method="post">
  <table class="table table-bordered">
      <thead>
      <th colspan="2" align="center">用户新增</th>
      </thead>
      <tbody>
      <tr>
          <td>用户名<span class="glyphicon glyphicon-user"></span></td>
          <td><input type="text" class="form-control" name="username"></td>
      </tr>
      <tr>
          <td>密码<span class="glyphicon glyphicon-lock"></span></td>
          <td><input type="password" class="form-control" name="password"></td>
      </tr>
      <tr>
          <td>描述</td>
          <td><textarea name="remark" class="form-control"></textarea></td>
      </tr>
      <tr>
          <td colspan="2" align="center">
             <input type="submit" class="btn-primary btn" value="提交">
              <input type="reset" class="btn btn-primary" value="重置">
          </td>

      </tr>
      </tbody>
  </table>
    </form>
</div>
</body>
</html>
