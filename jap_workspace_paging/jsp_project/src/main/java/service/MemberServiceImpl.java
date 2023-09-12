package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.memberController;
import domain.MemberVO;
import repository.MemberDAO;
import repository.MemberDAOImpl;

public class MemberServiceImpl implements MemberService {
	private static final Logger log = LoggerFactory.getLogger(memberController.class);
	private MemberDAO mdao; //MemberDAO interface
	
	public MemberServiceImpl() {
		mdao=new MemberDAOImpl();
	}
	
	@Override
	//login
	public MemberVO login(MemberVO mvo) {
		log.info("login memservice ok");
		return mdao.login(mvo);
	}

}