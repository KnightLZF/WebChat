package model;

public class friendsrelation {
	private int id;
	private String nameone;//����A������
	private String nametwo;//����B������
	
	public friendsrelation(){
		id=0;
		nameone="";
		nametwo="";
	}
	
	//����id,A�������Լ�B������
	public void setid(int i){
		id=i;
	}
	
	public void setnameone(String s){
		nameone=s;
	}
	
	public void setnametwo(String s){
		nametwo=s;
	}
	
	//��ȡid
	public int getid(){
		return id;
	}
	
	//��ȡA������
	public String getnameone(){
		return nameone;
	}
	
	//��ȡB������
	public String getnametwo(){
		return nametwo;
	}
}
