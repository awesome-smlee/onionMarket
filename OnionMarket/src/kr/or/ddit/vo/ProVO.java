package kr.or.ddit.vo;

public class ProVO {
	private int prod_id;
	private String tit;
	private String cont;
	private int price;
	private String ins_dt;
	private String upd_dt;
	private int status;
	private int vw_cnt;
	private String cate_id;
	private String ins_id;
	private int lat;
	private int lng;
	
	// 기본 생성자
	public ProVO() {}
	
	// 생성자
	public ProVO(int prod_id, String tit, String cont, int price, String ins_dt, String upd_dt, int status, int vw_cnt,
			String cate_id, String ins_id, int lat, int lng) {
		super();
		this.prod_id = prod_id;
		this.tit = tit;
		this.cont = cont;
		this.price = price;
		this.ins_dt = ins_dt;
		this.upd_dt = upd_dt;
		this.status = status;
		this.vw_cnt = vw_cnt;
		this.cate_id = cate_id;
		this.ins_id = ins_id;
		this.lat = lat;
		this.lng = lng;
	}

	// getter, setter
	public int getProd_id() {
		return prod_id;
	}
	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}
	public String getTit() {
		return tit;
	}
	public void setTit(String tit) {
		this.tit = tit;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getIns_dt() {
		return ins_dt;
	}
	public void setIns_dt(String ins_dt) {
		this.ins_dt = ins_dt;
	}
	public String getUpd_dt() {
		return upd_dt;
	}
	public void setUpd_dt(String upd_dt) {
		this.upd_dt = upd_dt;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getVw_cnt() {
		return vw_cnt;
	}
	public void setVw_cnt(int vw_cnt) {
		this.vw_cnt = vw_cnt;
	}
	public String getCate_id() {
		return cate_id;
	}
	public void setCate_id(String cate_id) {
		this.cate_id = cate_id;
	}
	public String getIns_id() {
		return ins_id;
	}
	public void setIns_id(String ins_id) {
		this.ins_id = ins_id;
	}
	public int getLat() {
		return lat;
	}
	public void setLat(int lat) {
		this.lat = lat;
	}
	public int getLng() {
		return lng;
	}
	public void setLng(int lng) {
		this.lng = lng;
	}
	
	@Override
	public String toString() {
		return "ProVO [prod_id=" + prod_id + ", tit=" + tit + ", cont=" + cont + ", price=" + price + ", ins_dt="
				+ ins_dt + ", upd_dt=" + upd_dt + ", status=" + status + ", vw_cnt=" + vw_cnt + ", cate_id=" + cate_id
				+ ", ins_id=" + ins_id + ", lat=" + lat + ", lng=" + lng + "]";
	}
	
}
