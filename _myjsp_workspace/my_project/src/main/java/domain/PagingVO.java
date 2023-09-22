package domain;

public class PagingVO {
	private int paginaionNo; // 현재 페이지 네이션 번호
	private int qty; // 한 페이지에 있는 게시물 수

	// 검색 멤버 변수 추가
	private String type; // 검색 타입
	private String keyword; // 검색어

	// 자동으로 세팅 되어있는 거(페이지네이션)
	public PagingVO() {
		this.paginaionNo = 1;
		this.qty = 10;
	}

	// 값이 바뀌면 세팅되는 거(페이지네이션)
	public PagingVO(int paginaionNo, int qty) {
		this.paginaionNo = paginaionNo;
		this.qty = qty;
	}

	// type이 여러개(ex:제목,내용 같이검색 & 회원id와 나이같이 검색)
	// 들어올 때 값을 배열로 리턴
	public String[] getTypeToArray() {
		return this.type == null ? new String[] {} : this.type.split("");
	}

	// paginaionNo => pageStart~pageEnd
	// 1 => 0~9
	// 2=> 10~19
	// 3=> 20~29
	public int getPageIndexStart() {
		return (paginaionNo - 1) * qty;
	}

	public int getPaginaionNo() {
		return paginaionNo;
	}

	public void setPaginaionNo(int paginaionNo) {
		this.paginaionNo = paginaionNo;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "PagingVO [paginaionNo=" + paginaionNo + ", qty=" + qty + "]";
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

	
}
