package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.BoardController;
import dao.BoardDAO;
import dao.BoardDAOImpl;
import domain.BoardVO;

public class BoardServiceImpl implements BoardService {

	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	private BoardDAO bdao; // dao => interface생성

	public BoardServiceImpl() {
		bdao = new BoardDAOImpl(); // dao => class로 생성
	}

	@Override
	//register
	public int register(BoardVO bvo) {
		log.info("service register check 2");
		return bdao.insert(bvo);
		
	}

	@Override
	//selectList
	public List<BoardVO> getList() {
		log.info("service list check 2");
		return bdao.selectList();
	}

	@Override
	//detail
	public BoardVO getDetail(int bno) {
		log.info("detail check 2");
		return bdao.selectOne(bno);
	}

}