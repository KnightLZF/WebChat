<%@ page language="java" import="java.util.*,model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
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
 	<script type="text/javascript" src="friend.js" charset="utf-8"></script>
  </head>

  <body>
  
  	<%--  //我想用ajax来传值到UserinfoServlet去执行当鼠标停留在名字上时，显示出资料卡，但是获取不到值
  		List<Userinfo> user_list = (List)session.getAttribute("user_info");
  		if(user_list!=null){
  			System.out.println(user_list.get(0).getUsername());
  			
  	--%>
  
  	 <!-- 用一个隐藏的div来显示资料卡 -->
         <div style="display:none; red;position: absolute;width:180px;height:200px;top:150px;left:0px" id="hideInfo" onmousedown="Hide()">
         
         	<table>
         		<tr>
         			<td><%--user_list.get(0).getUsername() --%></td>
         			<td><%--user_list.get(0).getSex() --%></td>
         			<td><%--=user_list.get(0).getAge() --%></td>
         		</tr>
         	</table>
         
         </div>
      
      <%--} --%>
      
      
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
    		 
    		 <a href="userinfo.jsp?username_info=<%=user.getusername() %>">留言及评价</a>
        </div>
		
        <!--搜索框-->
        <div id="search" class="bg-success">
        	<form action="userinfo.jsp" method="post">
           		<input id="searchtext" type="text" class="btn btn-default" name="username_info" placeholder="搜索">
		   		<input type="submit" value="搜索"/><br>
		   		<%
					String SearchError =request.getParameter("SearchError");
		   			if(SearchError!=null){
				%>
		   			<span><%=SearchError %></span>
		   		<%} %>
		   		
			</form>
		
			<!--  
               <button type="button" class="btn btn-default" name="button" onclick="search()">
               <span class="glyphicon glyphicon-search"></span>
               </button>
            -->
        </div>

		
		  <!--好友列表-->
        <table  id="main-friends" class="table table-hover table-bordered bg-success ">
        <%
        friendsrelationAction fa=new friendsrelationAction();
       
        fa.setusername(user.getusername());
        
        List list=fa.FindAllFriends();
        for(int i=0;i<list.size();i++){
            friendsrelation f=(friendsrelation)list.get(i);
            int j=f.getid();
            String nametwo=f.getnametwo();
            System.out.println(nametwo);
            out.println("<tr id="+i+">");
            out.println("<td>");
            out.println("<span><a href=\"javascript:getfriendname('"+nametwo+"') "+" \"  onmouseover=\"ComInfo()\" id=\"ua\">"+nametwo+"</a></span>");
            out.println("<input id=\""+j+"\" style=\"display:none\" value=\""+j+"\"/>");
            out.println("<input id=\""+nametwo+"\" "+"style=\"display:none\" value=\""+nametwo+"\"/>");
            out.println("<span><a href=\"userinfo.jsp?username_info="+nametwo+"\">查询好友资料</a></span>");
            out.println("<span><button type=\"button\" name=\"button\" onclick=\"shanchu('"+i+"','"+j+"')\">删除</button></span>");
            out.println("</td></tr>");
        }
        %>
         
        </table>
      </div>
     
      <!--聊天界面-->
      
      
      <div id="chat">
        <div id="chat-head">
          好友姓名<input id="friendname"  value="leila" readonly="readonly"/>
        </div>

        <div id="chat-body" >
          <span style="">聊天记录</span><br>
          <textarea id="message" rows="18" cols="95" readonly="readonly"><%=(String)request.getAttribute("chatmessage") %></textarea>
        </div>

        <div id="chat-input">
          <input type="text" id="chat-inputbox" name="" value="">
<<<<<<< HEAD
  		  <button type="button" class="btn btn-success" name="button" onclick="sendmessage()">发送</button>        </div>
=======
          <button type="button" class="btn btn-success" id="send" name="button">发送</button>
        </div>
>>>>>>> 6363998cc2f655dd37ab7e4c193a2296512587c9

        <div id="chat-send">
        </div>
      </div>
    </div>
  </body>
</html>
