package boardJDBC;

import java.util.ArrayList;

public interface Service {

	int write(BoardVO b);

	ArrayList<BoardVO> list();

	BoardVO detail(int bno);

	int modify(BoardVO b);

	int remove(int bno);



}
