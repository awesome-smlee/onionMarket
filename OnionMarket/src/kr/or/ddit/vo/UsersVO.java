package kr.or.ddit.vo;

public class UsersVO {
	private String user_id  ;
	private String user_nm  ;
	private String nick_nm  ;
	private String pw       ;
	private String tel      ;
	private String email    ;
	private String ins_dt   ;
	private int user_tp  ;
	private String reason   ;
	private String file_id  ;
	private int loc_id   ;
	private String dong;
	
	public UsersVO() {}

	public UsersVO(String user_id, String user_nm, String nick_nm, String pw, String tel, String email, String ins_dt,
			int user_tp, String reason, String file_id, int loc_id, String dong) {
		super();
		this.user_id = user_id;
		this.user_nm = user_nm;
		this.nick_nm = nick_nm;
		this.pw = pw;
		this.tel = tel;
		this.email = email;
		this.ins_dt = ins_dt;
		this.user_tp = user_tp;
		this.reason = reason;
		this.file_id = file_id;
		this.loc_id = loc_id;
		this.dong = dong;
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

	public int getLoc_id() {
		return loc_id;
	}

	public void setLoc_id(int loc_id) {
		this.loc_id = loc_id;
	}
	
	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	@Override
	public String toString() {
		return "UsersVO [user_id=" + user_id + ", user_nm=" + user_nm + ", nick_nm=" + nick_nm + ", pw=" + pw + ", tel="
				+ tel + ", email=" + email + ", ins_dt=" + ins_dt + ", user_tp=" + user_tp + ", reason=" + reason
				+ ", file_id=" + file_id + ", loc_id=" + loc_id + ", dong=" + dong + "]";
	}

	
}                           
