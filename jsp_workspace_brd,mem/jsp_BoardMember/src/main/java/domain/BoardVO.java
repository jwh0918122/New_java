package domain;

public class BoardVO {
	
	private int bno;
	private String title;
	private String writer;
	private String content;
	private String regdate;
	private String moddate;

	//생성자
	public BoardVO() {}
	
	//insert용
	public BoardVO(String title, String writer, String content) {
		this.title = title;
		this.writer = writer;
		this.content = content;
	}

	//update용
	public BoardVO(int bno, String title, String content) {
		this.bno = bno;
		this.title = title;
		this.content = content;
	}
	
	//list용
	public BoardVO(int bno, String title, String writer, String regdate, String moddate) {
		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.regdate = regdate;
		this.moddate = moddate;
	}

	//detail용
	public BoardVO(int bno, String title, String writer, String content, String regdate, String moddate) {
		super();
		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regdate = regdate;
		this.moddate = moddate;
	}

	//getter,setter
	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getModdate() {
		return moddate;
	}

	public void setModdate(String moddate) {
		this.moddate = moddate;
	}

	//toString
	@Override
	public String toString() {
		return bno + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regdate="
				+ regdate + ", moddate=" + moddate;
	}
	
	
	
	
}
