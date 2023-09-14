package domain;

public class PagingVO {
	private int pageNo; //현재 화면에 출력되는 페이지네이션 번호
	private int qty;// 한 페이지당 보여줄 게시글 수 (10개. 마지막은 다를수도있어)
	
	//검색 멤버 변수 추가
	
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
	
	//limit fir,sec  => first에 들어갈 거 구하는거
	// 2페이지면 => (2-1) *10 =10
	public int getPageStart() {
		return (pageNo-1)*qty;
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
	
	
}
