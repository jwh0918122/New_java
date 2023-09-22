package repository;

import java.util.List;

import domain.BoardVO;
import domain.PagingVO;

public interface BoardDAO {

	int write(BoardVO bvo);

	List<BoardVO> getList(PagingVO pgv);

	int boardTotalCnt(PagingVO pgv);

	BoardVO brdDetail(int bno);

	BoardVO getBvoForModify(int bno);

	int modify(BoardVO bvo);

	int delete(int bno);



}
