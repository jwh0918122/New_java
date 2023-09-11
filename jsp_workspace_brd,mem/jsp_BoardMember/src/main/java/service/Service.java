package service;

import java.util.List;

import domain.BoardVO;
import domain.PagingVO;

public interface Service {

	int register(BoardVO bvo);

	List<BoardVO> getList();

	BoardVO detail(int bno);

	int modify(BoardVO bvo);

	int remove(int bno);

	int getTotalCount();

	List<BoardVO> getPageList(PagingVO pgvo);

}
