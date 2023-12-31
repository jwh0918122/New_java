package domain;

public class PagingVO {
	private int pageNo; //선택한 페이지네이션 번호
	private int qty;// 한 페이지당 보여줄 게시글 수 (10개)
	
	//검색 멤버 변수 추가
	private String type; //검색 대상(작성자검색인지,내용검색인지 등)
	private String keyword; //검색어
	
	//페이지네이션을 클릭하기 전 기본 리스트 출력 값
	//1번째 페이지, 게시글 10개
	public PagingVO() {
		this(1,10);
	}
	
	//클릭하면 설정되는 값
	public PagingVO(int pageNo, int qty) {
		this.pageNo = pageNo;
		this.qty = qty;
	}
	
	//limit pageStart,qty  => pageStart에 들어갈 거 구하는거
	//=> pageStart번지에 있는 게시물부터 qty개 가져와라(DB에 명령할거)
	// (pageNo이)1페이지면 => (1-1) *10 =0
	// (pageNo이)2페이지면 => (2-1) *10 =10
	// (pageNo이)3페이지면 => (3-1) *10 =20
	public int getPageStart() {
		return (pageNo-1)*qty;
	}
	
	//type이 여러개(ex:제목, 작성자, 내용 같이 검색)들어올 때 값을 배열로 리턴
	public String[] getTypeToArray() {
		return this.type==null? new String[] {}:this.type.split("");
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "PagingVO [pageNo=" + pageNo + ", qty=" + qty + ", type=" + type + ", keyword=" + keyword + "]";
	}
	
	
}
