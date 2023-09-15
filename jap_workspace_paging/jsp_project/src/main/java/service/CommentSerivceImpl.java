package service;

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
}
