package kr.or.ddit.vo;

public class ComJoinVO { // USERS, COMMUNITY, COMMUNITY_CATEGORY, LOCATION, FILEINFO
	// UESERS
	private String user_id;
	private String user_nm;
	private String nick_nm;
	private String pw;
	private String tel;
	private String email;
	private String ins_dt;
	private int user_tp;
	private String reason;
	private String file_id;
	// private int loc_id;
	
	// COMMUNITY
	private int com_id;
	private String tit;
	private String cont;
	// private String ins_dt;
	private String upd_dt;
	private int vw_cnt;
	private int lk_cnt;
	// private String cate_id;
	private String ins_id;
	private int lat;
	private int lng;
	
	// COMMUNITY_CATEGORY
	private String cate_id;
	private String cate_nm;
	
	
	// LOCATION
	private int loc_id;
	private String gu;
	private String dong;
	
	// FILEINFO
	// private String file_id;
	private String upload_nm;
	private String stored_nm;
	private long file_size;
	// private String ins_dt;
	
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
	public String getIns_dt() {
		return ins_dt;
	}
	public void setIns_dt(String ins_dt) {
		this.ins_dt = ins_dt;
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
	public int getCom_id() {
		return com_id;
	}
	public void setCom_id(int com_id) {
		this.com_id = com_id;
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
	public String getUpd_dt() {
		return upd_dt;
	}
	public void setUpd_dt(String upd_dt) {
		this.upd_dt = upd_dt;
	}
	public int getVw_cnt() {
		return vw_cnt;
	}
	public void setVw_cnt(int vw_cnt) {
		this.vw_cnt = vw_cnt;
	}
	public int getLk_cnt() {
		return lk_cnt;
	}
	public void setLk_cnt(int lk_cnt) {
		this.lk_cnt = lk_cnt;
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
	public String getUpload_nm() {
		return upload_nm;
	}
	public void setUpload_nm(String upload_nm) {
		this.upload_nm = upload_nm;
	}
	public String getStored_nm() {
		return stored_nm;
	}
	public void setStored_nm(String stored_nm) {
		this.stored_nm = stored_nm;
	}
	public long getFile_size() {
		return file_size;
	}
	public void setFile_size(long file_size) {
		this.file_size = file_size;
	}
	
	
	
	
	
}
