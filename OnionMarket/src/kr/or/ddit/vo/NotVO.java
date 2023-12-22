package kr.or.ddit.vo;

public class NotVO {
	
	
	// notice
	private int noti_id;
	private String tit;
	private String cont;
	private String ins_dt;
	private String upd_dt;
	private int vw_cnt;
	private String ins_id;
	
	
	// notice_file
//	private int noti_id;
	private String file_id;


	public int getNoti_id() {
		return noti_id;
	}


	public void setNoti_id(int noti_id) {
		this.noti_id = noti_id;
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


	public int getVw_cnt() {
		return vw_cnt;
	}


	public void setVw_cnt(int vw_cnt) {
		this.vw_cnt = vw_cnt;
	}


	public String getIns_id() {
		return ins_id;
	}


	public void setIns_id(String ins_id) {
		this.ins_id = ins_id;
	}


	public String getFile_id() {
		return file_id;
	}


	public void setFile_id(String file_id) {
		this.file_id = file_id;
	}


	@Override
	public String toString() {
		return "NotVO [noti_id=" + noti_id + ", tit=" + tit + ", cont=" + cont + ", ins_dt=" + ins_dt + ", upd_dt="
				+ upd_dt + ", vw_cnt=" + vw_cnt + ", ins_id=" + ins_id + ", file_id=" + file_id + "]";
	}
	
	
}
