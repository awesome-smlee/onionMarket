package kr.or.ddit.vo;

public class ProFile {
	private String file_id;
	private int prod_id;
	
	// 기본 생성자
	public ProFile() {}
	
	// 생성자
	public ProFile(String file_id, int prod_id) {
		super();
		this.file_id = file_id;
		this.prod_id = prod_id;
	}

	// getter, setter
	public String getFile_id() {
		return file_id;
	}

	public void setFile_id(String file_id) {
		this.file_id = file_id;
	}

	public int getProd_id() {
		return prod_id;
	}

	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}

	@Override
	public String toString() {
		return "ProFile [file_id=" + file_id + ", prod_id=" + prod_id + "]";
	}
	
}
