package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import repository.BoardDAO;
import repository.BoardDAOImpl;
import service.CommentSerivceImpl;

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
		
		//댓글 먼저 지우고 게시글 삭제
		//CommentSerivceImpl에 요청.(댓글 지우는거는 commentMapper가 해야하니까)
		CommentSerivceImpl csv = new CommentSerivceImpl();
		int cnt=csv.commentCount(bno);
		if(cnt>0) {
			
			int isOk=csv.cmtRemove(bno);
		}
		
		
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

	@Override
	//getFileName
	public String getFileName(int bno) {		
		return bdao.getFileName(bno);
	}




}
