package boardJDBC;

import java.util.ArrayList;

public interface DAO {

	int insert(BoardVO b);

	ArrayList<BoardVO> selectList();

	BoardVO selectOne(int bno);

	int update(BoardVO b);

	int readcount(int bno);

	int delete(int bno);




}
