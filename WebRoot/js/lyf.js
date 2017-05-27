	var xmlHttp;  //定义xmlHttp变量
	
	function createXMLHttpRequest(){
		try{
			xmlHttp = new XMLHttpRequest();
		}catch(e){
			try{
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			}catch(e){
				alert("你的浏览器不支持Ajax。");
				return false;
			}
		}
	}

function ComInfo(){
	createXMLHttpRequest();
	
	xmlHttp.open("GET","UserinfoServlet?username_info=3",true);
	xmlHttp.send(null);
	
	var user_pop = document.getElementById("hideInfo");
	user_pop.style.display="block";
	
}

function Hide(){
	var user_name = document.getElementById("hideInfo");
	
	user_name.style.display="none";
}


function IsMine(){
	alert("不要太自恋哦，自己就不要评论自己了！");
}

function NotFriends(){
	alert("你还不是好友哦，请加好友再聊天，评价！");
}