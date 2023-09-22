package serivce;

import java.util.List;

import domain.BoardVO;
import domain.PagingVO;

public interface BoardService {

	int write(BoardVO bvo);

	List<BoardVO> getList(PagingVO pgv);

	int getBoardTotalCnt(PagingVO pgv);

	BoardVO brdDetail(int bno);

	BoardVO getBvoForModify(int bno);

	int modify(BoardVO bvo);

	int remove(int bno);







	
}
