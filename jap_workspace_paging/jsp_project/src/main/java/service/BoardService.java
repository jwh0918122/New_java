package service;

import java.util.List;

import domain.BoardVO;
import domain.PagingVO;

public interface BoardService {

	int add(BoardVO bvo);

	List<BoardVO> getList();

	BoardVO detail(int bno);

	int modify(BoardVO bvo);

	int remove(int bno);

	int getTotalCount(PagingVO pgvo);

	List<BoardVO> getPageList(PagingVO pgvo);

	String getFileName(int bno);


	

}
