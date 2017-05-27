package model;

public class Impression {

	private int impid; //设置ID
	private String userone;//设置被评用户
	private String usertwo;//设置评价用户
	private String impression;//设置评价
	private String imptime;//评论时间
	
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
