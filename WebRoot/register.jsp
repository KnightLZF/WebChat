<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

      <title>用户注册页面</title>

      <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
          <meta http-equiv="expires" content="0">
            <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
              <meta http-equiv="description" content="This is my page">
                <!--
  	<link rel="stylesheet" type="text/css" href="styles.css">
  	-->
                <link rel="stylesheet" href="css/register.css">
                  <link rel="stylesheet" href="css/main.css"></head>

                  <body>
                    <div class="container">
                      <section id="content">
                        <form action="RegisterServlet" method="post">
                          <h1>用户注册</h1>
                          <table>
                            <tr>
                              <td>用户名：</td>
                              <td><input type="text" name="username"/></td>
                            </tr>
                            <tr>
                              <td>密码：</td>
                              <td><input type="password" name="password"/></td>
                            </tr>
                            <tr>
                              <td>确认密码：</td>
                              <td><input type="password" name="passwords"/></td>
                            </tr>
                          </table>
                          <input type="submit" value="注册用户" name="submit"/>
                          <input type="reset" value="重置" name="reset"/>
                          <br>
                            <div class="button" id="jump" >
                              <a href="index.jsp">已有账户，去登录</a>
                            </div>
                          </form>
                        <%
            String s=(String)request.getAttribute("registerfail");
            if(s==null) s="";
            else {out.print("<tr><p style=\"color:red\">"+s+"</p></tr>");}
          %>
                        </section>
                      </div>
                    </body>
                  </html>
