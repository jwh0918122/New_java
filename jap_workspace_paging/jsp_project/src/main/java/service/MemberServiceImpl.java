package service;

import java.util.List;

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

	@Override
	//lastlogin
	public int lastlogin(String id) {
		log.info("lastlogin memservice ok");
		return mdao.lastlogin(id);
	}

	@Override
	//list
	public List<MemberVO> list() {
		log.info("list memservice ok");
		return mdao.selectAll();
	}

	@Override
	//add
	public int add(MemberVO mvo) {
		log.info("add memservice ok");
		return mdao.insert(mvo);
	}

	@Override
	//modify
	public int modify(MemberVO mvo) {
		log.info("modify memservice ok");
		return mdao.update(mvo);
	}

	@Override
	//remove
	public int remove(String id) {
		log.info("remove memservice ok");
		return mdao.delete(id);
	}

}
