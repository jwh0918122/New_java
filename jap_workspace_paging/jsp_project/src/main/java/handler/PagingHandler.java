package handler;

import domain.PagingVO;

public class PagingHandler {
	
	private int startPage;//현재 화면에서 보여지는 시작 페이지네이션 번호
	private int endPage;//현재 화면에서 보여지는 끝 페이지네이션 번호
	private int realEndPage;//실제 전체 끝 페이지 번호
	private boolean prev, next;//이전, 다음페이지 존재 여부(있거나, 없거나임)
	
	private PagingVO pgvo;//내가 클릭한 페이지숫자, 한 페이지에 들어가는 게시글 수(10)
	private int totalCount;//전체 글 수
	
	public PagingHandler(PagingVO pgvo, int totalCount) {
		this.pgvo = pgvo;
		this.totalCount = totalCount;
		
		this.endPage=
				(int)Math.ceil(pgvo.getPageNo() / (double)pgvo.getQty()) * pgvo.getQty();
		
		this.startPage=this.endPage-9;
		
		this.realEndPage=(int)Math.ceil(totalCount / (double)pgvo.getQty());
		
		if(this.realEndPage < this.endPage) {
			this.endPage = this.realEndPage;
		}
		
		this.prev=this.startPage > 1;//존재여부(1보다 크면 존재)
		//startPage가 1이 아니란건 11,21,31...이라는 거임
		this.next=this.endPage < realEndPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getRealEndPage() {
		return realEndPage;
	}

	public void setRealEndPage(int realEndPage) {
		this.realEndPage = realEndPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public PagingVO getPgvo() {
		return pgvo;
	}

	public void setPgvo(PagingVO pgvo) {
		this.pgvo = pgvo;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	@Override
	public String toString() {
		return "PagingHandler [startPage=" + startPage + ", endPage=" + endPage + ", realEndPage=" + realEndPage
				+ ", prev=" + prev + ", next=" + next + ", pgvo=" + pgvo + ", totalCount=" + totalCount + "]";
	}
	
}
