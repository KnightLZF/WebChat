package model;

public class friendsrelation {
	private int id;
	private String nameone;//朋友A的名字
	private String nametwo;//朋友B的名字
	
	public friendsrelation(){
		id=0;
		nameone="";
		nametwo="";
	}
	
	//设置id,A的名字以及B的名字
	public void setid(int i){
		id=i;
	}
	
	public void setnameone(String s){
		nameone=s;
	}
	
	public void setnametwo(String s){
		nametwo=s;
	}
	
	//获取id
	public int getid(){
		return id;
	}
	
	//获取A的名字
	public String getnameone(){
		return nameone;
	}
	
	//获取B的名字
	public String getnametwo(){
		return nametwo;
	}
}
