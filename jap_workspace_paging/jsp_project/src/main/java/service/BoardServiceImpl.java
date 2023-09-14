package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import repository.BoardDAO;
import repository.BoardDAOImpl;

public class BoardServiceImpl implements BoardService {
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	private BoardDAO bdao; //BoardDAO interface
	
	public BoardServiceImpl() {
		bdao = new BoardDAOImpl(); //BoardDAO class 생성
	}

	@Override
	//add
	public int add(BoardVO bvo) {
		log.info("add service ok");
		return bdao.insert(bvo);
	}

	@Override
	//list
	public List<BoardVO> getList() {
		log.info("list service ok");
		return bdao.selectAll();
	}

	@Override
	//detail
	public BoardVO detail(int bno) {
		log.info("detail service ok");
		return bdao.selectOne(bno);
	}

	@Override
	//modify
	public int modify(BoardVO bvo) {
		log.info("modify service ok");
		return bdao.update(bvo);
	}

	@Override
	//remove
	public int remove(int bno) {
		log.info("remove service ok");
		return bdao.delete(bno);
	}

	@Override
	//getTotalCount
	public int getTotalCount(PagingVO pgvo) {
		log.info("regetTotalCountmove service ok");
		return bdao.totalCount(pgvo);
	}

	@Override
	//pageList
	public List<BoardVO> getPageList(PagingVO pgvo) {
		log.info("pageList service ok");
		return bdao.pageList(pgvo);
	}




}
