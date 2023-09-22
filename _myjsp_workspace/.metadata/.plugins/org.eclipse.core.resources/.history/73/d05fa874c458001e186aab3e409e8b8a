package domain;

public class PagingVO {
	private int paginaionNo; // 현재 페이지 네이션 번호
	private int qty; // 한 페이지에 있는 게시물 수

	// 자동으로 세팅 되어있는 거
	public PagingVO() {
		this.paginaionNo = 1;
		this.qty = 10;
	}
	

	// 값이 바뀌면
	public PagingVO(int paginaionNo, int qty) {
		this.paginaionNo = paginaionNo;
		this.qty = qty;
	}

	// paginaionNo => pageStart~pageEnd
	// 1 => 0~9
	// 2=> 10~19
	// 3=> 20~29
	public int getPageIndexStart() {
		return (paginaionNo - 1) * qty;
	}

	public int getpaginaionNo() {
		return paginaionNo;
	}

	public void setPageNo(int paginaionNo) {
		this.paginaionNo = paginaionNo;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

}
