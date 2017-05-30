package model;

public class friendsrelation {
	private int id;
	private String nameone;//朋友A的名字
	private String nametwo;//朋友B的名字
	private int groupid;//朋友B在朋友A好友列表里的分组
	
	public friendsrelation(){
		id=0;
		nameone="";
		nametwo="";
		groupid=0;
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
	
	//设置groupid
	public void setgroupid(int i){
		groupid=i;
	}
	
	//获取group分组名称
	public String getgroupname(){
		String s="";
		switch(groupid){
		case 1:s="好友";break;
		case 2:s="家人";break;
		case 3:s="同学";break;
		case 4:s="同事";break;
		case 5:s="陌生人";break;
		default:break;
		}
		return s;
	}
}
