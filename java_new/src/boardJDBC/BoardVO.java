package boardJDBC;

public class BoardVO {
	private int bno;
	private String title;
	private String writer;
	private String content;
	private String regdate;
	private String moddate;
	private int readcount;
	
	public BoardVO() {}

	//게시글 등록 (bno, regdate는 자동으로 들어가게 할거임)
	public BoardVO(String title, String writer, String content) {
		this.title = title;
		this.writer = writer;
		this.content = content;
	
	}
	//게시글 수정 (moddate는 자동으로 들어가게)
	public BoardVO(int bno, String title, String writer, String content) {
		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.content = content;
	}
	//게시글 목록(전체)
	public BoardVO(int bno, String title, String writer, String regdate, int readcount) {
		super();
		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.regdate = regdate;
		this.readcount = readcount;
	}

	//상세 검색
	public BoardVO(int bno, String title, String writer, String content, String regdate, String moddate,
			int readcount) {
		super();
		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regdate = regdate;
		this.moddate = moddate;
		this.readcount = readcount;
	}

	//게시글 검색(상세 출력-한개)
	public void printDetail() {
		System.out.println("글 번호 : "+bno+" writer : "+writer);
		System.out.println("제목 : "+title+"("+readcount+")"+" | 작성일 : "+regdate);
		System.out.println("내용 : "+content);
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

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	//toString
	@Override
	public String toString() {
		return bno + " title : " + title + " | writer : " + writer + " | regdate : "
				+ regdate + " | moddate : " + moddate + " | readcount : " + readcount;
	}
	

	
}
