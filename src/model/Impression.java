package model;

public class Impression {

	private int impid; //����ID
	private String userone;//���ñ����û�
	private String usertwo;//���������û�
	private String impression;//��������
	private String imptime;//����ʱ��
	
	public Impression() {
	}

	
	public int getImpid() {
		return impid;
	}


	public void setImpid(int impid) {
		this.impid = impid;
	}

	

	public String getUserone() {
		return userone;
	}


	public void setUserone(String userone) {
		this.userone = userone;
	}


	public String getUsertwo() {
		return usertwo;
	}


	public void setUsertwo(String usertwo) {
		this.usertwo = usertwo;
	}


	public String getImpression() {
		return impression;
	}

	public void setImpression(String impression) {
		this.impression = impression;
	}


	public String getImptime() {
		return imptime;
	}


	public void setImptime(String imptime) {
		this.imptime = imptime;
	}
	
}
