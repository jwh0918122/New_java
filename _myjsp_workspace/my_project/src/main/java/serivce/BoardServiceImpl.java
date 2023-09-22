package serivce;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.boardController;
import domain.BoardVO;
import domain.PagingVO;
import repository.BoardDAO;
import repository.BoardDAOImpl;

public class BoardServiceImpl implements BoardService {
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	private BoardDAO bdao; //BoardDAO interface
	
	public BoardServiceImpl() {
		//BoardDAO class
		bdao=new BoardDAOImpl(); 
	}

	//write
	public int write(BoardVO bvo) {
		log.info("write service ok");
		return bdao.write(bvo);
	}

	//list
	public List<BoardVO> getList(PagingVO pgv) {
		log.info("list service ok");
		return bdao.getList(pgv);
	}

	//boardTotalCnt
	public int getBoardTotalCnt(PagingVO pgv) {
		log.info("boardTotalCnt service ok");
		return bdao.boardTotalCnt(pgv);
	}

	//boardDetail
	public BoardVO brdDetail(int bno) {
		log.info("boardDetail service ok");
		return bdao.brdDetail(bno);
	}

	//getBvoForModify
	public BoardVO getBvoForModify(int bno) {
		log.info("getBvoForModify service ok");
		return bdao.getBvoForModify(bno);
	}

	//modify
	public int modify(BoardVO bvo) {
		log.info("modify service ok");
		return bdao.modify(bvo);
	}

	//remove
	public int remove(int bno) {
		log.info("remove service ok");
		return bdao.delete(bno);
	}







}
