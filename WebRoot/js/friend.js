
 var xmlHttp;//����xmlHttp����
 var xmlHttp2;

 function createXMLHttpRequest(){
		try{
			xmlHttp=new XMLHttpRequest();//������firefox��Opera��Safari�����Դ���
		}catch(e){
			try{
				xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
			}catch(e){
				alert("������������֧��Ajax!");
				return false;
			}
		}
	}

 function createXMLHttpRequest2(){
		try{
			xmlHttp2=new XMLHttpRequest();//������firefox��Opera��Safari�����Դ���
		}catch(e){
			try{
				xmlHttp2=new ActiveXObject("Microsoft.XMLHTTP");
			}catch(e){
				alert("������������֧��Ajax!");
				return false;
			}
		}
	}

function shanchu(rowId,friendid){
	//System.out.println("selc");
	var flag=window.confirm("Are you sure to delete?");
	var Index=document.getElementById(rowId).rowIndex; //��ȡ��ǰ�е�������
	 var id=document.getElementById(friendid);

	if(flag){
		/*����Ajax�ѵ�ǰ�û������ִ���servlet�������ݿ�������ɾ��*/
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
