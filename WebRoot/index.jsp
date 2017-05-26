<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

      <title>用户登录界面</title>

      <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
          <meta http-equiv="expires" content="0">
            <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
              <meta http-equiv="description" content="This is my page">
                <!--
		<link rel="stylesheet" type="text/css" href="styles.css">
		-->
                <link rel="stylesheet" href="css/main.css">
                  <link rel="stylesheet" href="css/index.css"></head>

                  <body>
                    <div class="container">
                      <section id="content">
                        <form action="LoginServlet" method="post">
                          <h1>用户登录</h1>
                          <div><input type="text" name="username" placeholder="用户名" required="required"/></div>
                          <div><input type="password" name="password" placeholder="密码" required="required"/></div>
                        <%
	              String s2=(String)request.getAttribute("registersuccess");
	              if(s2==null) s2="";
	              else {out.print("<tr><p style=\"color:red\">"+s2+"</p></tr>");}

	              String s=(String)request.getAttribute("loginfail");
	              if(s==null) s="";
	              else {out.print("<tr><p style=\"color:red\">"+s+"</p></tr>");}
	             %>
                          <div>
                            <input type="submit" value="登录" name="submit"/>
                          </div>
                        </form>
                        <div class="button">
                          <a class="btn" href="register.jsp">没有账号？注册用户</a>
                        </div>
                      </section>
                    </div>
                  </body>
                </html>
