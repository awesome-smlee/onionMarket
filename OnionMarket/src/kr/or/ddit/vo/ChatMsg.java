package kr.or.ddit.vo;

public class ChatMsg {
	
	private int chat_id;
	private String ins_id;
	private String message;
	private String ins_dt;
	private String read_yn;
	
	// 기본 생성자
	public ChatMsg() {}
	
	// 생성자
	public ChatMsg(int chat_id, String ins_id, String message, String ins_dt, String read_yn) {
		super();
		this.chat_id = chat_id;
		this.ins_id = ins_id;
		this.message = message;
		this.ins_dt = ins_dt;
		this.read_yn = read_yn;
	}

	// getter, setter
	public int getChat_id() {
		return chat_id;
	}

	public void setChat_id(int chat_id) {
		this.chat_id = chat_id;
	}

	public String getIns_id() {
		return ins_id;
	}

	public void setIns_id(String ins_id) {
		this.ins_id = ins_id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getIns_dt() {
		return ins_dt;
	}

	public void setIns_dt(String ins_dt) {
		this.ins_dt = ins_dt;
	}

	public String getRead_yn() {
		return read_yn;
	}

	public void setRead_yn(String read_yn) {
		this.read_yn = read_yn;
	}

	@Override
	public String toString() {
		return "ChatMsg [chat_id=" + chat_id + ", ins_id=" + ins_id + ", message=" + message + ", ins_dt=" + ins_dt
				+ ", read_yn=" + read_yn + "]";
	}
	
}
