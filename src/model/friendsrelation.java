package model;

public class friendsrelation {
	private int id;
	private String nameone;//����A������
	private String nametwo;//����B������
	private int groupid;//����B������A�����б����ķ���

	public friendsrelation(){
		id=0;
		nameone="";
		nametwo="";
		groupid=0;
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

	//����groupid
	public void setgroupid(int i){
		groupid=i;
	}

	//��ȡgroup��������
	public String getgroupname(){
		String s="";
		switch(groupid){
		case 1:s="����";break;
		case 2:s="����";break;
		case 3:s="ͬѧ";break;
		case 4:s="ͬ��";break;
		case 5:s="İ����";break;
		default:break;
		}
		return s;
	}
}
