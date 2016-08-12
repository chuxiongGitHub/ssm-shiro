<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../common/tag.jsp"%>
<html>
<head>
<TITLE>shiro权限管理系统</TITLE>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<LINK rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/res/jquery-easyui/style.css">
<LINK rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/res/jquery-easyui/login/login.css">
<LINK rel="stylesheet" type="text/css"	href="<%=request.getContextPath()%>/res/jquery-easyui/themes/default/easyui.css">
<LINK rel="stylesheet" type="text/css"	href="<%=request.getContextPath()%>/res/bootstrap/css/bootstrap.css"><LINK rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/res/jquery-easyui/style.css">

<STYLE type="text/css">
.btnalink {
	cursor: hand;
	display: block;
	width: 80px;
	height: 29px;
	float: left;
	margin: 12px 28px 12px auto;
	line-height: 30px;
	background: url('<%=request.getContextPath()%>/res/images/login/btnbg.jpg') no-repeat;
	font-size: 14px;
	color: #fff;
	font-weight: bold;
	text-decoration: none;
}
</STYLE>
<%@ include file="../common/common_js.jsp"%>


</HEAD>
<BODY style="background: #f6fdff url(<%=request.getContextPath()%>/res/images/login/bg1.jpg) repeat-x;">
	<form   action="<%=request.getContextPath()%>/user/login" method="post">
		<DIV class="logincon">

			<DIV class="title">
				<IMG alt="" src="<%=request.getContextPath()%>/res/images/login/xg.png">
			</DIV>

			<DIV class="cen_con">
				<IMG alt="" src="<%=request.getContextPath()%>/res/images/login/bg2.png">
			</DIV>

			<DIV class="tab_con">

				<input type="password" style="display:none;" />
				<TABLE class="tab" border="0" cellSpacing="6" cellPadding="8">
					<TBODY>
						<TR>
							<TD><span class="glyphicon glyphicon-user"></span>用户名：</TD>
							<TD colSpan="2"><input type="text" id="userCode"
								name="userCode" style="WIDTH: 130px;height: 20px" /></TD>
						</TR>
						<TR>
							<TD><span class="glyphicon glyphicon-lock"></span>密 码：</TD>
							<TD><input type="password" id="pwd" name="password" style="WIDTH: 130px;height: 20px" />
							</TD>
						</TR>
						<TR>
							<TD><span class="glyphicon glyphicon-cloud"></span>验证码：</TD>
							<TD><input id="randomcode" name="randomcode" size="8" /> <img
									id="randomcode_img" src="<%=request.getContextPath()%>/validatecode.jsp" alt=""
									width="56" height="20" align='absMiddle' /> <a
								href=javascript:randomcode_refresh()>刷新</a></TD>
						</TR>

						<TR>
							<TD colSpan="2" align="center"><input type="submit"
								class="btnalink"  value="登&nbsp;&nbsp;录" />
								<input type="reset" class="btnalink" value="重&nbsp;&nbsp;置" /></TD>
						</TR>
					</TBODY>
				</TABLE>

			</DIV>
		</DIV>
	</form>
</BODY>
</HTML>
