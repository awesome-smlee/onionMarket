package kr.or.ddit.vo;

public class ProCateVO {
	private String cate_id;
	private String cate_nm;
	
	// 기본생성자
	public ProCateVO() {}
	
	// 생성자
	public ProCateVO(String cate_id, String cate_nm) {
		super();
		this.cate_id = cate_id;
		this.cate_nm = cate_nm;
	}
	
	// getter, setter
	public String getCate_id() {
		return cate_id;
	}
	public void setCate_id(String cate_id) {
		this.cate_id = cate_id;
	}
	public String getCate_nm() {
		return cate_nm;
	}
	public void setCate_nm(String cate_nm) {
		this.cate_nm = cate_nm;
	}
	
	@Override
	public String toString() {
		return "ProCateVO [cate_id=" + cate_id + ", cate_nm=" + cate_nm + "]";
	}
}
