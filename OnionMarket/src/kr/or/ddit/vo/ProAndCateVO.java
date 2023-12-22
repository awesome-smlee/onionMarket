package kr.or.ddit.vo;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jni.FileInfo;

// * VO 합침
public class ProAndCateVO { //PRODUCT, PRODUCT_CATEGORY, USERS, LOCATION 
	
	// PRODUCT
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
	private Double lat;
	private Double lng;
	
	// PRODUCT_CATEGORY
	// private String cate_id;
	private String cate_nm;
	
	// USERS 
	// private String ins_dt;
	private String user_id;
	private String user_nm;
	private String nick_nm;
	private String pw;
	private String tel;
	private String email;
	private int user_tp;
	private String reason;
	private String file_id;
	private int loc_id;
	
	// LOCATION
	private int pro_loc_id;
	private String pro_gu;
	private String pro_dong;
	
	// group by (집계)
	private int like_cnt;
	
	// 현재 접속자 id 
	// => 현재 상세를 조회하는 접속자가 좋아요를 눌렀는지 여부 확인용
	private String like_ins_id;
	
	// 현재 접속자가 좋아요 눌렀는지 여부
	private int is_like;
	
	List<FileInfoVO> file_list = new ArrayList<>();
	
	//--------------------------------
	

	// 기본 생성자
	public ProAndCateVO() {}
	
	//--------------------------------
	
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
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	
	public String getCate_nm() {
		return cate_nm;
	}

	public void setCate_nm(String cate_nm) {
		this.cate_nm = cate_nm;
	}
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_nm() {
		return user_nm;
	}

	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}

	public String getNick_nm() {
		return nick_nm;
	}

	public void setNick_nm(String nick_nm) {
		this.nick_nm = nick_nm;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUser_tp() {
		return user_tp;
	}

	public void setUser_tp(int user_tp) {
		this.user_tp = user_tp;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getFile_id() {
		return file_id;
	}

	public void setFile_id(String file_id) {
		this.file_id = file_id;
	}

	public int getLoc_id() {
		return loc_id;
	}

	public void setLoc_id(int loc_id) {
		this.loc_id = loc_id;
	}

	public int getPro_loc_id() {
		return pro_loc_id;
	}

	public void setPro_loc_id(int pro_loc_id) {
		this.pro_loc_id = pro_loc_id;
	}

	public String getPro_gu() {
		return pro_gu;
	}

	public void setPro_gu(String pro_gu) {
		this.pro_gu = pro_gu;
	}

	public String getPro_dong() {
		return pro_dong;
	}

	public void setPro_dong(String pro_dong) {
		this.pro_dong = pro_dong;
	}

	public int getLike_cnt() {
		return like_cnt;
	}

	public void setLike_cnt(int like_cnt) {
		this.like_cnt = like_cnt;
	}
	
	public String getLike_ins_id() {
		return like_ins_id;
	}

	public void setLike_ins_id(String like_ins_id) {
		this.like_ins_id = like_ins_id;
	}

	public int getIs_like() {
		return is_like;
	}

	public void setIs_like(int is_like) {
		this.is_like = is_like;
	}

	public List<FileInfoVO> getFile_list() {
		return file_list;
	}

	public void setFile_list(List<FileInfoVO> file_list) {
		this.file_list = file_list;
	}
	
}
