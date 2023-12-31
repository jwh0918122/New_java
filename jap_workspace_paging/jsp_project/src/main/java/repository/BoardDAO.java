package repository;

import java.util.List;

import domain.BoardVO;
import domain.PagingVO;

public interface BoardDAO {

	int insert(BoardVO bvo);

	List<BoardVO> selectAll();

	BoardVO selectOne(int bno);

	int update(BoardVO bvo);

	int delete(int bno);

	int totalCount(PagingVO pgvo);

	List<BoardVO> pageList(PagingVO pgvo);

	String getFileName(int bno);


}
