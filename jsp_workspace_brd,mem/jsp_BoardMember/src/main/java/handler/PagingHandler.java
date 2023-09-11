package handler;

import domain.PagingVO;

public class PagingHandler {
	//jsp에서 list 하단에 나올 페이지네이션 핸들링 클래스
	//처음은 1(시작),10(끝) 
	//"다음"을 누르면 10(시작),20(끝)
	private int startPage; //현재 화면에서 보여줄 시작 페이지네이션 번호
	private int endPage; //현재 화면에서 보여줄 끝 페이지네이션 번호
	private int realEndPage; //실제 전체 끝 페이지 번호 (마지막 번호)
	private boolean prev, next;//이전, 다음페이지 존재 여부(있거나 없거나임)
	
	private int totalCount;// 전체 글 수
	private PagingVO pgvo;
	
	public PagingHandler(PagingVO pgvo, int totalCount) {
		this.pgvo=pgvo;
		this.totalCount=totalCount;
		
		//1~10까지는 10, 11~20은 20, 21~30은 30
		//현재페이지번호 / 한 화면의 게시글 수(10) * 한 화면의 게시글 수(10)
		// 1 / 10 = 0.1(=>1) * 10 = 10
		// 2 / 10 = 0.2(=>1) * 10 = 10
		this.endPage=
				(int)Math.ceil(pgvo.getPageNo() /(double)pgvo.getQty())*pgvo.getQty();
		
		this.startPage= this.endPage-9;
		
		//페이지네이션의 마지막 페이지
		//게시글 수 =11개 ->1,2page
		//전체 게시글 수 / 한 페이지 게시글 수 
		//나머지 생기면 무조건 1페이지 더 생성해야 함.
		this.realEndPage = (int)Math.ceil(totalCount / (double)pgvo.getQty());
		if(this.realEndPage < this.endPage) {
			this.endPage = this.realEndPage;
		}
		
		this.prev = this.startPage>1;// 존재여부(1보다 크면 존재)
		this.next = this.endPage < realEndPage;
	}
	
	//getter, setter
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

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public PagingVO getPgvo() {
		return pgvo;
	}

	public void setPgvo(PagingVO pgvo) {
		this.pgvo = pgvo;
	}
	
	
}
