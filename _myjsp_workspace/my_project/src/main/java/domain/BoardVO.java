package domain;

public class BoardVO {
	private int bno;
	private String title;//제목
	private String writer;//작성자
	private String content;//내용
	private String regDate;//작성일
	private String modDate;//수정일
	private int viewCnt; //조회수
	
	public BoardVO() {}

	//글 작석용
	public BoardVO(String title, String writer, String content) {
		this.title = title;
		this.writer = writer;
		this.content = content;
	}
	//글 수정용
	public BoardVO(int bno,String title, String content) {
		this.bno = bno;
		this.title = title;
		this.content = content;
	}
	//리스트용
	public BoardVO(int bno, String title, String writer, String regDate, String modDate, int viewCnt) {
		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.regDate = regDate;
		this.modDate = modDate;
		this.viewCnt = viewCnt;
	}
	//상세보기용
	public BoardVO(int bno, String title, String writer, String content, String regDate, String modDate, int viewCnt) {
		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regDate = regDate;
		this.modDate = modDate;
		this.viewCnt = viewCnt;
	}

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

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getModDate() {
		return modDate;
	}

	public void setModDate(String modDate) {
		this.modDate = modDate;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	@Override
	public String toString() {
		return bno + " title=" + title + ", writer=" + writer + ", content=" + content + ", regDate="
				+ regDate + ", modDate=" + modDate + ", viewCnt=" + viewCnt ;
	}
	
	
	
	
	
}
