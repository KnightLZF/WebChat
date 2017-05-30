
 var xmlHttp;//ï¿½ï¿½ï¿½ï¿½xmlHttpï¿½ï¿½ï¿½ï¿½
 var xmlHttp2;

 function createXMLHttpRequest(){
		try{
			xmlHttp=new XMLHttpRequest();//ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½firefoxï¿½ï¿½Operaï¿½ï¿½Safariï¿½ï¿½ï¿½ï¿½ï¿½Ô´ï¿½ï¿½ï¿½
		}catch(e){
			try{
				xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
			}catch(e){
				alert("ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ö§ï¿½ï¿½Ajax!");
				return false;
			}
		}
	}

 function createXMLHttpRequest2(){
		try{
			xmlHttp2=new XMLHttpRequest();//ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½firefoxï¿½ï¿½Operaï¿½ï¿½Safariï¿½ï¿½ï¿½ï¿½ï¿½Ô´ï¿½ï¿½ï¿½
		}catch(e){
			try{
				xmlHttp2=new ActiveXObject("Microsoft.XMLHTTP");
			}catch(e){
				alert("ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ö§ï¿½ï¿½Ajax!");
				return false;
			}
		}
	}

function shanchu(rowId,friendid){
	//System.out.println("selc");
	var flag=window.confirm("Are you sure to delete?");
	var Index=document.getElementById(rowId).rowIndex; //ï¿½ï¿½È¡ï¿½ï¿½Ç°ï¿½Ðµï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
	 var id=document.getElementById(friendid);

	if(flag){
		/*ï¿½ï¿½ï¿½ï¿½Ajaxï¿½Ñµï¿½Ç°ï¿½Ã»ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ö´ï¿½ï¿½ï¿½servletï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ý¿ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½É¾ï¿½ï¿½*/
		createXMLHttpRequest();
		xmlHttp.open("Get", "DeleteServlet?friendid="+id.value, true);
		xmlHttp.send(null);

	    document.getElementById("main-friends").deleteRow(Index);
	    alert("Successfuly delete!");
    }
}

function searchkeyw(){
	var textid=document.getElementById("searchtext");

	    createXMLHttpRequest();

		xmlHttp.onreadystatechange=call;

		xmlHttp.open("Get", "SearchServlet?keyword="+textid.value, true);
		xmlHttp.send(null);
}

function call(){
	alert("call");
	alert(document.getElementById("chat").innerHTML);
	alert(xmlhttp.responseText);
	if(xmlHttp.readyState==4 && xmlHttp.status==200){
		var Text=xmlHttp.responseText;
	    document.getElementById("chat").innerHTML=Text;
	}
}

function sendmessage(){
	var f=document.getElementById("friendname");
	var text=document.getElementById("chat-inputbox");
	createXMLHttpRequest();

	xmlHttp.open("Get", "SendMsgServlet?to="+f.value+"&msg="+text.value, true);
	xmlHttp.send(null);
	text.value="";

	createXMLHttpRequest2();
	xmlHttp2.onreadystatechange=calls2;
	xmlHttp2.open("Get", "GetMsgServlet?to="+f.value, true);
	xmlHttp2.send(null);
}

function calls2(){
	if(xmlHttp2.readyState==4 && xmlHttp2.status==200){
		var Text=xmlHttp2.responseText;
		document.getElementById("message").value=Text;
		}
	}

function getfriendname( nametwo){
	//alert("s");
	var n=document.getElementById(nametwo);
	document.getElementById("friendname").value=n.value;
	//alert(n.value);
    createXMLHttpRequest();
    xmlHttp.onreadystatechange=calls;
	xmlHttp.open("Get", "GetMsgServlet?to="+n.value, true);
	xmlHttp.send(null);

	//document.getElementById("message").value="what";
}

function calls(){
if(xmlHttp.readyState==4 && xmlHttp.status==200){
	var Text=xmlHttp.responseText;
	document.getElementById("message").value=Text;
	}
}

function myfresh(){
	var f=document.getElementById("friendname");
	createXMLHttpRequest2();
	xmlHttp2.onreadystatechange=calls2;
	xmlHttp2.open("Get", "GetMsgServlet?to="+f.value, true);
	xmlHttp2.send(null);
}
setInterval("myfresh();",100);
function downloadmessage(){
	//»ñÈ¡ÁÄÌì¼ÇÂ¼ÄÚÈÝÒÔ¼°½»»¥ºÃÓÑ
	var msg=document.getElementById("message");
	
	var n=document.getElementById("friendname");
	createXMLHttpRequest();

	xmlHttp.open("Get", "DownloadMsgServlet?dmsg="+msg.value+"&to="+n.value, true);
	xmlHttp.send(null);
	alert("Successfuly download");
}

function deletemsg(){
	//»ñÈ¡½»»¥ºÃÓÑ	
	var n=document.getElementById("friendname");
	createXMLHttpRequest();

	xmlHttp.open("Get", "DeleteMsgServlet?to="+n.value, true);
	xmlHttp.send(null);
	alert("Successfuly deleted");
}