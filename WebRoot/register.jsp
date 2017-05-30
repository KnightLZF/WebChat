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
                  <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
                    <script type="text/javascript" src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>

                    <body>
                      <div class="container text-center">
                        <section id="content">
                          <form action="RegisterServlet" method="post">

                            <h1>用户注册</h1>
                            <table class="table-center">
                              <tr>
                                <td>用户名：</td>
                                <td><input type="text" name="username" placeholder="用户名" required="required"/></td>
                              </tr>
                              <tr>
                                <td>密码：</td>
                                <td><input type="password" placeholder="密码" required="required"name="password"/></td>
                              </tr>
                              <tr>
                                <td>确认密码：</td>
                                <td><input type="password" placeholder="确认密码" required="required"name="passwords"/></td>
                              </tr>
                              <tr>
                                <td>性别：</td>
                                <td>男<input type="radio" name="sex" value="0" checked="true">女<input type="radio" name="sex" value="1"></td>
                              </tr>
                              <tr>
                                <td>年龄：</td>
                                <td><input type="text"  required="required" name="ages" onkeyup="this.value=this.value.replace(/\D/g,''); "/></td>
                               </tr>
                            </table>

                            <input type="submit" class="input-center" value="注册用户" name="submit"/>
                            <input type="reset" value="重置" name="reset"/>
                            <br>
                              <%-- <div class="button" id="jump">
                              </div> --%>
                              <a  class="btn" href="index.jsp">已有账户，去登录</a>
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
