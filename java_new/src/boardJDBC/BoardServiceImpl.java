package boardJDBC;

import java.util.ArrayList;

public class BoardServiceImpl implements Service {

	private DAO dao;
	
	public BoardServiceImpl() {
		dao = new BoardDAOImpl();
	}

	@Override
	//write
	public int write(BoardVO b) {
		System.out.println("write_service success!!");
		return dao.insert(b);
	}

	@Override
	//list
	public ArrayList<BoardVO> list() {
		System.out.println("list_service success!!");
		return dao.selectList();
	}

	@Override
	//detail
	public BoardVO detail(int bno) {
		int isOk = dao.readcount(bno);
		System.out.println("detail_service success!!");
		return (isOk>0)?dao.selectOne(bno):null;
	}

	@Override
	//modify
	public int modify(BoardVO b) {
		System.out.println("modify_survice success!!");
		return dao.update(b);
	}

	@Override
	//remove
	public int remove(int bno) {
		System.out.println("remove_survice success!!");
		return dao.delete(bno);
	}
}
