<%@ page language="java" import="java.util.*,model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

    <title>在线聊天系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="在线聊天系统,webchat,Javaweb期末实验">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/main.css">
  <script type="text/javascript" src="js/jquery-3.2.1.js"></script>


  </head>

  <body>
    <!--主界面-->
    <div id="main">

      <!--左侧界面-->
      <div id="panel">

        <!--通讯录上方自己姓名-->
        <div id="user" class="bg-success">
            <%User user=(User)session.getAttribute("user");
    		  if(user!=null)
         		 out.println(user.getusername()+"，欢迎您！");
    		 %>
        </div>

        <!--搜索框-->
        <div id="search" class="bg-success">
          <input type="text" class="btn btn-default" name="serch" value="搜索">

          <button type="button" class="btn btn-default" name="button">
            <span class="glyphicon glyphicon-search"></span>
          </button>
        </div>

        <!--好友列表-->
        <table  id="main-friends" class="table table-hover table-bordered bg-success ">
          <tr>
            <td>
              <span>罗梦清</span>
              <span><button type="button" name="button">移动</button></span>
              <span><button type="button" name="button">删除</button></span>
            </td>
          </tr>
          <tr>
            <td>李元富
                <span><button type="button" name="button">移动</button></span>
                <span><button type="button" name="button">删除</button></span>
            </td>
          </tr>
          <tr>
            <td>周国良
              <span><button type="button" name="button">移动</button></span>
              <span><button type="button" name="button">删除</button></span>
            </td>
          </tr>
          <tr>
            <td>游梓璇
              <span><button type="button" name="button">移动</button></span>
              <span><button type="button" name="button">删除</button></span>
            </td>
          </tr>
          <tr>
            <td>李振飞
              <span><button type="button" name="button">移动</button></span>
              <span><button type="button" name="button">删除</button></span>
            </td>
          </tr>
        </table>

      </div>

      <!--聊天界面-->
      <div id="chat">
        <div id="chat-head">
          好友姓名
        </div>

        <div id="chat-body">
          聊天记录
        </div>

        <div id="chat-input">
          <input type="text" id="chat-inputbox" name="" value="">
          <button type="button" class="btn btn-success" name="button">发送</button>
        </div>

        <div id="chat-send">
        </div>
      </div>
    </div>
  </body>
</html>
