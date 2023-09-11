package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.BoardController;
import domain.BoardVO;
import domain.PagingVO;
import repository.BoardDAO;
import repository.BoardDAOImpl;

public class BoardServiceImpl implements Service {
	private static final Logger log=LoggerFactory.getLogger(BoardServiceImpl.class);
	//DAO 객체 생성
	private BoardDAO bdao; //interface
	
	public BoardServiceImpl() {
		bdao = new BoardDAOImpl();//repository -> class생성
	}

	@Override
	//insert
	public int register(BoardVO bvo) {
		log.info("insert service ok");
		return bdao.insert(bvo);
	}

	@Override
	//list
	public List<BoardVO> getList() {
		log.info("list service ok");
		return bdao.list();
	}

	@Override
	//detail
	public BoardVO detail(int bno) {
		log.info("detail sevice ok");
		return bdao.selectOne(bno);
	}

	@Override
	//modify
	public int modify(BoardVO bvo) {
		log.info("modify sevice ok");
		return bdao.modify(bvo);
	}

	@Override
	//remove
	public int remove(int bno) {
		log.info("remove sevice ok");
		return bdao.remove(bno);
	}

	@Override
	public int getTotalCount() {		
		return bdao.getTotalCount();
	}

	@Override
	public List<BoardVO> getPageList(PagingVO pgvo) {
		return bdao.getPageList(pgvo);
	}
}
