package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.MemberController;
import domain.MemberVO;
import repository.MemberDAO;
import repository.MemberDAOImpl;

public class MemberServiceImpl implements MemberService {
	private static final Logger log =LoggerFactory.getLogger(MemberServiceImpl.class);
	
	private MemberDAO mdao; //repository(dao) -> interface
	
	public MemberServiceImpl() {
		mdao = new MemberDAOImpl(); //repository(dao) -> class 생성
	}

	@Override
	//register(insert)
	public int register(MemberVO mvo) {
		log.info("join check 2");
		
		return mdao.insert(mvo);
	}

	@Override
	//login
	public MemberVO login(MemberVO mvo) {
		log.info("login check 2");
		return mdao.login(mvo);
	}

	@Override
	//lastlogin
	public int lastLogin(String id) {
		log.info("lastlogin check 2");
		return mdao.lastLogin(id);
	}

	@Override
	//list
	public List<MemberVO> getList() {
		log.info("list check 2");
		return mdao.list();
	}

}
