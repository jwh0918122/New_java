package repository;

import java.util.List;

import domain.BoardVO;

public interface BoardDAO {

	int insert(BoardVO bvo);

	List<BoardVO> list();

	BoardVO selectOne(int bno);

	int modify(BoardVO bvo);

	int remove(int bno);

}