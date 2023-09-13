package service;

import java.util.List;

import domain.BoardVO;

public interface BoardService {

	int add(BoardVO bvo);

	List<BoardVO> getList();

	BoardVO detail(int bno);

	int modify(BoardVO bvo);

	int remove(int bno);

}
