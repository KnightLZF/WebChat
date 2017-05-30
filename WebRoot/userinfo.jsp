<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,model.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/userinfo.css">
    <script type="text/javascript" src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="js/lyf.js"></script>
<title>用户信息</title>
</head>

	<%
		String username = request.getParameter("username_info");

		if (username != null && !"".equals(username)) {

			UserinfoAction uia = new UserinfoAction();
			uia.setUsername(username);
			List<Userinfo> list = uia.SelectUsersInfo();
			pageContext.setAttribute("list", list);
	%>


	<div id="main-info" class="bg-success">

		<div id="userinfo">
			<table>
				<c:forEach items="${pageScope.list}" var="list">
					<tr>
						<td>姓名：${list.username}</td>
						<td>性别:${list.sex}</td>
						<td>年龄:${list.age}</td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<%
			ImpressionAction impa = new ImpressionAction();
				impa.setUsername_one(username);//设置被评价对象
				List<Impression> li = impa.SelectImpression();
				if (li.size() > 0) {
					pageContext.setAttribute("li", li);
		%>
		<div id="imp">
			<table>
				<c:forEach items="${pageScope.li}" var="li">
					<tr>
						<td>${li.usertwo}对${li.userone}的评价是：</td>
						<br>
						<td>${li.impression}</td>
						<td>${li.imptime}</td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<%
			} else {
		%>
		<div id="imp-no">
			<table>
				<tr>
					<td>暂时无好友评价，快给他评价吧！</td>
				</tr>
			</table>
		</div>
		<%
			}
		%>

		<%
			//判断查询评价时，用户身份的判断，如果是用户自己，则不能 对自己进行评价
				User user = (User) session.getAttribute("user");
		        System.out.println(user.getusername());
				friendsrelationAction fa = new friendsrelationAction();
				fa.setusername(username);
				List<friendsrelation> list_two = fa.FindAllFriends();
				boolean is = false;
				for(int i=0;i<list_two.size();i++){	
					if (list_two.get(i).getnametwo().equals(user.getusername())) {
						is = true;
					}
				}
				if(is){
		%>
		<div id="imp-add"
			style="top: 400px; left: 0px; height: 100px; width: 500px; position: absolute;">
			<form action="ImpressionServlet?username_one=<%=username%>"
				method="post">
				<textarea rows="4" cols="68" name="text" placeholder="请输入你对该用户的映像或评价吧。。。。。。。。"></textarea>
				<br> <input type="submit" value="提交" /> 
				<span><a href="main.jsp">返回主窗口</a></span>
			</form>

		</div>
		<%
			} else {
		%>
		<div
			style="top: 400px; left: 0px; height: 100px; width: 500px; position: absolute;">
			<textarea rows="4" cols="68" name="text" placeholder="请输入你对该用户的映像或评价吧。。。。。。。。" disabled="disabled"></textarea>
			<br> <input type="submit"  class="btn btn-success" value="提交" onclick="NotFriends()" /> 
			 	 <input type="submit" class="btn btn-success" value="加好友" />
			<span><a href="main.jsp" class="btn btn-default">返回主窗口</a></span>

		</div>
		<%
			}
		%>
	</div>
	<%
		} else {

			response.sendRedirect("main.jsp?SearchError=you should enter ,not null!");
		}
	%>

</body>
</html>