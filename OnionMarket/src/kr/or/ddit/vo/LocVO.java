package kr.or.ddit.vo;

public class LocVO {
	private int loc_id;
	private String gu;
	private String dong;
	
	//기본생성자
	public LocVO() {}

	//생성자
	public LocVO(int loc_id, String gu, String dong) {
		super();
		this.loc_id = loc_id;
		this.gu = gu;
		this.dong = dong;
	}

	//getter, setter
	public int getLoc_id() {
		return loc_id;
	}

	public void setLoc_id(int loc_id) {
		this.loc_id = loc_id;
	}

	public String getGu() {
		return gu;
	}

	public void setGu(String gu) {
		this.gu = gu;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	@Override
	public String toString() {
		return "LocVO [loc_id=" + loc_id + ", gu=" + gu + ", dong=" + dong + "]";
	}
	
	
	
	
	
	
	

}
