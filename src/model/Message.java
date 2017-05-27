package model;

public class Message {
	private int msgid;
	private String from;
	private String to;
	private String msg;
	private String time;
	
	public Message(){
		msgid=0;
		from="";
		to="";
		msg="";
		time="";
	}
	
	public void setmsgid(int i){
		msgid=i;
	}
	public int getmsgid(){
		return msgid;
	}
	
	
	public void setfrom(String s){
		from=s;
	}
	public String getfrom(){
		return from;
	}
	
	public void setto(String s){
		to=s;
	}
	public String getto(){
		return to;
	}
	
	public void setmsg(String s){
		msg=s;
	}
	public String getmsg(){
		return msg;
	}
	
	public void settime(String s){
		time=s;
	}
	public String gettime(){
		return time;
	}
}
