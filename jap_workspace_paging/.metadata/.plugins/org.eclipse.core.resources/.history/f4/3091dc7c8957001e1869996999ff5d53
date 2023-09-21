package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.commentController;
import domain.CommentVO;
import repository.CommentDAO;
import repository.CommentDAOImpl;

public class CommentSerivceImpl implements CommentService {
	private static final Logger log = LoggerFactory.getLogger(CommentSerivceImpl.class);
	
	private CommentDAO cdao;
	
	public CommentSerivceImpl() {
		cdao=new CommentDAOImpl();
	}

	@Override
	public int post(CommentVO cvo) {
	
		return cdao.insert(cvo);
	}



	@Override
	public List<CommentVO> getList(int bno) {
		
		return cdao.getList(bno);
	}

	@Override
	public int modify(CommentVO cvo) {
		
		return cdao.update(cvo);
	}

	@Override
	public int remove(int cno) {

		return cdao.delete(cno);
	}
	
	//게시글 지우기 전 댓글 지우기
	public int cmtRemove(int bno) {
		
		return cdao.cmtDeleteAll(bno);
	}
}
